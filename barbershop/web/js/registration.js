// let password1 = document.getElementById("password");
// let password2 = document.getElementById("repeatPassword");
// let error_message = document.getElementById("passwords_mismatch");
(() => {
    'use strict';

    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    const forms = document.querySelectorAll('.needs-validation');

    // Loop over them and prevent submission
    Array.prototype.slice.call(forms).forEach((form) => {
        form.addEventListener('submit', (event) => {
            if (!form.checkValidity()) {
                event.preventDefault();
                event.stopPropagation();
            }
            form.classList.add('was-validated');
            window.scrollTo(0, 0);
        }, false);
    });
})();

