// const buttons = document.querySelectorAll('button[data-target]');
//
// for (let button of buttons) {
//     button.addEventListener('click', event => {
//         event.preventDefault();
//
//         const target = document.querySelector(button.dataset.target);
//
//         if (target) {
//             target.scrollIntoView({
//                 behavior: 'smooth'
//             });
//         }
//     });
// }
setTimeout(function scrollToElement() {
    let top = document.getElementById('edit-review').getBoundingClientRect().top - 40;
    window.scrollTo(0, top);
}, 100);