//imports
import { apiUrl, states } from "../helpers/conts.js";
import { randomAmbulancia } from "./ambulance.js";

//Urls
// selectores
// Definir elementos del DOM como variables globales si es necesario
const container_cards = document.getElementById("conCards");
const containerServicesActive = document.querySelector(".servicesActive");
const containerServicesStarted = document.querySelector(".servicesStart");
const containerServicesCompleted = document.querySelector(".servicesCompleted");
const tbodyAllServices = document.querySelector(".allServices tbody");

document.addEventListener("DOMContentLoaded", async (e) => {
    e.preventDefault();
    await obtenerInfo();
    await obtenerInfoJson();
});

let btnEliminar;
let btnAccept;
let btnStart;
let btnComplete;

export const obtenerInfoJson = async () => {
    try {
        const response = await fetch(`${apiUrl}/ambulances`);
        const data = await response.json();
        return data;
    } catch (error) {
        console.log(error.message);
    }
};
const obtenerInfo = async () => {
    try {
        const response = await fetch(`${apiUrl}/requests`);
        const data = await response.json();
        pintarCardsRight(data);
    } catch (error) {
        console.log(error.message);
    }
};

const pintarCardsRight = (data) => {
    // Reinicializa el contenido del container_cards
    container_cards.innerHTML = "";
    containerServicesActive.innerHTML = "";
    containerServicesStarted.innerHTML = "";
    containerServicesCompleted.innerHTML = "";
    tbodyAllServices.innerHTML = "";

    data.forEach((i) => {
        if (i.state === states.pending) {
            container_cards.innerHTML += `
    <div class="card m-3">
            <h5 class="card-header">New service</h5>
            <div class="card-body">
              <h5 class="card-text">${i.name}</h5>
              <p class="card-text">Email: ${i.email}</p>
              <p class="card-text">Tel: ${i.phone}</p>
              <p class="card-text">Address: ${i.address}</p>
              <p class="card-text">Patients: ${i.patients}</p>
              <p class="card-text">Emergency Grade: ${i.emergencyGrade}</p>
              <p class="card-text">Emergency Description: <br>${i.emergencyDescription}</br></p>
              <div class="modal-footer">
                <button class="btn btn-danger eliminar" id=${i.id}>Cancel</button>
                <button class="btn btn-success mx-3 accept" id=${i.id} >Accept</button>
              </div>
            </div>
          </div>
        `;
        } else if (i.state === states.active) {
            containerServicesActive.innerHTML += `
        <div class="card mt-3">
            <h5 class="card-header">Active service</h5>
            <div class="card-body">
              <h5 class="card-title">${i.name}</h5>
              <p class="card-text">Emergency Grade: ${i.emergencyGrade}
              <br>Patients: ${i.patients}</br>
              <br>Emergency Description: ${i.emergencyDescription}</br>
              </p>
              <div class="modal-footer d-grid gap-2">
                <button class="btn btn-info ambulance" id=${i.id}>Assign ambulance</button>
                <button class="btn btn-success start" id=${i.id}>Start service</button>
              </div>
            </div>
          </div>`;
        } else if (i.state === states.started) {
            containerServicesStarted.innerHTML += `
        <div class="card mt-3">
            <h5 class="card-header">Started service</h5>
            <div class="card-body">
              <h5 class="card-title">${i.name}</h5>
              <p class="card-text">Email: ${i.email}
              <br>Phone: ${i.phone}</br></p>
              <div class="modal-footer">
                <button class="btn btn-info mx-3 complete" id=${i.id}>Completed</button>
                <button class="btn btn-danger eliminar"id=${i.id}>Delete service</button>
              </div>
            </div>
          </div>`;
        } else if (i.state === states.completed) {
            containerServicesCompleted.innerHTML += `
        <div class="card mt-3">
        <div class="card-header">
          Service Completed: Id: ${i.id}
        </div>
        <div class="card-body">
          <blockquote class="blockquote mb-0">
            <p>Nombre: ${i.name}</p>
          </blockquote>
        </div>
      </div>`;
        }
        tbodyAllServices.innerHTML += `
        <tr>
                <th scope="row">${i.id}</th>
                <td>${i.name}</td>
                <td>${i.state}</td>
              </tr>`;
    });

    const btnAmbulance = document.querySelectorAll(".ambulance");
    btnAmbulance.forEach((i) => {
        i.addEventListener("click", async (e) => {
            e.preventDefault();
            const ambulance = await randomAmbulancia(obtenerInfoJson());
            updateServiceState(i.id, states.active, ambulance);
        });
    });

    btnStart = document.querySelectorAll(".start");
    btnStart.forEach((i) => {
        i.addEventListener("click", (e) => {
            e.preventDefault();
            startService(i.id);
            captureCompleteInfo(i.id);
        });
    });

    btnComplete = document.querySelectorAll(".complete");
    btnComplete.forEach((i) => {
        i.addEventListener("click", (e) => {
            e.preventDefault();
            completeService(i.id);
        });
    });

    btnAccept = document.querySelectorAll(".accept");
    btnAccept.forEach((i) => {
        i.addEventListener("click", (e) => {
            e.preventDefault();
            acceptService(i.id);
        });
    });

    btnEliminar = document.querySelectorAll(".eliminar");
    btnEliminar.forEach((i) => {
        i.addEventListener("click", (e) => {
            e.preventDefault();
            eliminarService(i.id);
        });
    });
};

const captureCompleteInfo = async (id) => {
    try {
        const info = await fetch(`${apiUrl}/requests/${id}?_expand=user`);
        const data = await info.json();

        // Almacena el objeto 'data' directamente en el localStorage
        localStorage.setItem("request", JSON.stringify(data));
    } catch (error) {
        return console.log(error.message);
    }
};

const updateServiceState = async (id, newState, ambulance) => {
    try {
        const service = await fetch(`${apiUrl}/requests/${id}?_expand=user`);

        const data = await service.json();

        if (!data) {
            console.log("El servicio no existe");
            return;
        }
        const updatedAmbulance =
            ambulance !== undefined ? ambulance : data.ambulance;

        await fetch(`${apiUrl}/requests/${data.id}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                ...data,
                state: newState,
                ambulance: updatedAmbulance,
            }),
        });

        obtenerInfo();
    } catch (error) {
        console.log(error.message);
    }
};

const startService = async (id) => {
    await updateServiceState(id, states.started);
};

const completeService = async (id) => {
    await updateServiceState(id, states.completed);
};

const acceptService = async (id) => {
    await updateServiceState(id, states.active);
};

const eliminarService = async (id) => {
    await updateServiceState(id, states.deleted);
};
