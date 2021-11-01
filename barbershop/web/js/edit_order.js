var exampleModal = document.getElementById('exampleModal')
exampleModal.addEventListener('show.bs.modal', function (event) {
    // Кнопка, запускающая модальное окно
    var button = event.relatedTarget
    // Извлечь информацию из атрибутов data-bs- *
    var recipient = button.getAttribute('data-bs-whatever')
    // При необходимости вы можете инициировать запрос AJAX здесь
    // а затем выполните обновление в обратном вызове.
    //
    // Обновите содержимое модального окна.
    var modalTitle = exampleModal.querySelector('.modal-title')
    var modalBodyInput = exampleModal.querySelector('.modal-body input')

    modalTitle.textContent = 'Новое сообщение для ' + recipient
    modalBodyInput.value = recipient
})