

// Función para alternar la clase 'active' en el menu-section y ocultar/mostrar el menú
function toggleMenuSection() {
    let menuSection = document.querySelector(".menu-section");
    menuSection.classList.toggle("active");
    console.log("toggleMenuSection function called");

    // Verifica si el menú está visible o no y ajusta la visibilidad según corresponda
    if (menuSection.classList.contains("active")) {
        menuSection.style.display = "block";
    } else {
        menuSection.style.display = "none";
    }
}

document.getElementById("menuButton").addEventListener("click", toggleMenuSection);

// Script para generar opciones de edad del 1 al 100, menos de 10 años y más de 100 años
const ageSelect = document.getElementById("age");
ageSelect.innerHTML = "<option value=''>Select</option>";

const less10age = document.createElement("option");
less10age.value = "<10";
less10age.textContent = "less than 10 years";
ageSelect.appendChild(less10age);

for (let i = 11; i <= 99; i++) {
    const option = document.createElement("option");
    option.value = i;
    option.textContent = i;
    ageSelect.appendChild(option);
}

const more100age = document.createElement("option");
more100age.value = ">100";
more100age.textContent = "more than 100 years";
ageSelect.appendChild(more100age);
