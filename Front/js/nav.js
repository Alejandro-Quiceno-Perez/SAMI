const navContainer = document.querySelector('#nav-container');
function nav(){
    navContainer.innerHTML = `
                <ul class="nav">
                <li>
                    <img src="../img/logo3BG.png" alt="" class="img-logo-header">
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" aria-current="page" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="../pages/userPage.html">Your Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-danger" href="../pages/aboutUs.html">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-whit" aria-disabled="true" href="../pages/admin.html">Admin</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link text-whit" aria-disabled="true" href="../pages/ambulance.html">Ambulance</a>
                </li>
            </ul>
            <ul class="nav">
            <li class="nav-item"><a href="" class="nav-link text-dark"><i class="bi bi-person-circle">
                            Cuchumfulo</a></i></li>
                <li class="nav-item d-flex me-5"><a href="" class="nav-link text-danger">ES</a><span
                        class="nav-link text-danger">/</span><a href="" class="nav-link text-danger">EN</a></li>
                <li class="nav-item"><a class="btn btn-danger" href="../pages/login.html">Login</a></li>
                <li class="nav-item d-none"><a class="btn btn-danger" href="../pages/login.html">Log out</a></li>
            </ul>
        `;
}
nav();