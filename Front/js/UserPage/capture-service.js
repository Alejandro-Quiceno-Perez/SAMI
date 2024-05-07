document.addEventListener("DOMContentLoaded", function () {


    const requestButton = document.getElementById("btn-request");


    requestButton.addEventListener("click", function () {

        const requestContainer = document.querySelector(".request-container");
        const mapContainer = document.querySelector(".map-container");
        const serviceContainer = document.querySelector(".service-container");

        // Oculta el contenedor de solicitud y muestra el mapa y el servicio al hacer clic en el botón de solicitud
        requestContainer.style.display = "none";
        mapContainer.style.display = "block";
        serviceContainer.style.display = "block";
    });


    const requestForm = document.querySelector('.request-container');


    requestForm.addEventListener('submit', function (event) {

        event.preventDefault();

        // Captura los valores de los campos del formulario
        const fullName = document.getElementById('name').value;
        const email = document.getElementById('email').value;
        const address = document.getElementById('address').value;
        const phoneNumber = document.getElementById('phone').value;
        const age = document.getElementById('age').value;
        const numberOfPatients = document.getElementById('patients').value;
        const emergencyDegree = document.getElementById('emergency').value;
        const emergencyDescription = document.getElementById('emerg-description').value;

        //imprime la información en el service-container
        const serviceContainer = document.querySelector(".service-container");
        serviceContainer.innerHTML = `
        <h3>Time: 00:00:00</h3>
        <p>Full Name: ${fullName}</p>
        <p>Email: ${email}</p>
        <p>Age: ${age}</p>
        <p>Phone Number: ${phoneNumber}</p>
        <p>Address: ${address}</p>
        <p>Number of Patients: ${numberOfPatients}</p>
        <p>Emergency Degree: ${emergencyDegree}</p>
        <p>Description of the Emergency: ${emergencyDescription}</p>
        <button type="button" class="btn btn-danger" id="cancelService">Cancel Service</button>
        `;

        // Muestra el contenedor de servicio al enviar el formulario
        serviceContainer.style.display = "block";

        // Oculta el formulario de solicitud
        const requestContainer = document.querySelector(".request-container");
        requestContainer.style.display = "none";
    });

    // Captura el botón de cancelar servicio
    document.addEventListener('click', function (event) {
        if (event.target && event.target.id === 'cancelService') {

            const serviceContainer = document.querySelector(".service-container");
            const mapContainer = document.querySelector(".map-container");

            serviceContainer.style.display = "none";
            mapContainer.style.display = "none";


            const requestContainer = document.querySelector(".request-container");
            requestContainer.style.display = "block";
        }
    });
});
