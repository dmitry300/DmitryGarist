INSERT INTO users (id,
                   login,
                   password,
                   role,
                   user_status)
VALUES (2,
        'user1',
        'EE11CBB19052E40B07AAC0CA060C23EE', /* MD5 хэш пароля "user" */
        1,
        0),
       (3,
        'user2',
        'EE11CBB19052E40B07AAC0CA060C23EE', /* MD5 хэш пароля "user" */
        2,
        1),
       (4,
        'user3',
        'EE11CBB19052E40B07AAC0CA060C23EE', /* MD5 хэш пароля "user" */
        2,
        1);

INSERT INTO user_info
    (id, surname, name, patronymic, phone, birthday, email)
VALUES (1, 'Иванов', 'Иван', 'Иванович', +375291234567, '2000-10-18', 'ivan200@mail.ru'),
       (2, 'Петров', 'Пётр', 'Петрович', +375292345678, '1995-12-10', 'petr123@gmail.com'),
       (3, 'Сидоров', 'Сидор', 'Сидорович', +375293456789, '1987-01-03', 'sidar142ov@yandex.ru'),
       (4, 'Васильев', 'Василий', 'Васильевич', +375294567890, '2005-09-17', 'vasya@gmail.com');

INSERT INTO haircuts
    (id, price, name, time)
VALUES (1, 25, 'Первая стрижка', '01:00:00'),
       (2, 30, 'Профи стрижка', '01:00:00'),
       (3, 23, 'Стрижка машинкой', '00:30:00'),
       (4, 25, 'Бритьё головы', '00:45:00'),
       (5, 20, 'Бритьё(коррекция) бороды', '00:45:00'),
       (6, 25, 'Детская стрижка до 9-ти лет', '01:00:00'),
       (7, 45, 'Стрижка профи + бритьё(коррекция) бороды', '01:30:00'),
       (8, 40, 'Бритьё головы и лица', '01:00:00'),
       (9, 37, 'Стрижка машинкой + бритьё(коррекция) бороды', '01:15:00'),
       (10, 25, 'Тонирование бороды', '00:30:00'),
       (11, 30, 'Камуфляж седины', '00:30:00'),
       (12, 15, 'Удаление волос воском', '00:15:00');

INSERT INTO barbers
(id, name, surname, patronymic, birthday, photo, phone, start_job, tiktok_link, end_job)
VALUES (1, 'Гриша', 'Лазаренко', 'Павлович', '2000-10-18', 'img/barber1.jpg', +375295004712, '2020-02-01',
        'https://vm.tiktok.com/ZM8j1tcmY/',
        null),
       (2, 'Костя', 'Дмитриенко', 'Олегович', '1991-02-15', 'img/barber2.jpg', +375295564712, '2021-03-17',
        'https://vm.tiktok.com/ZM8j1VTNc/',
        null),
       (3, 'Иван', 'Светлый', 'Александрович', '1995-12-09', 'img/barber3.jpg', +375295849812, '2019-06-26',
        'https://vm.tiktok.com/ZM8j1vFmy/',
        null),
       (4, 'Александр', 'Лихачев', 'Миронович', '1985-03-14', 'img/barber4.jpg', +375291547896, '2021-08-25',
        'https://vm.tiktok.com/ZM8j1EGcA/',
        null);
INSERT INTO reviews
    (id, comment, comment_data, user_id, barber_id)
VALUES (1, 'Неплохая работа!', '2021-01-01 13:30:00', 1, 1),
       (2, 'Молодец!', '2021-01-01 13:30:00', 2, 1),
       (3, 'Ну такое себе, лучше бы не ходил к нему!', '2021-01-01 13:30:00', 1, 2);
INSERT INTO orders
(id, status, date_time_plane, date_time, user_id, barber_id, haircut_id)
VALUES (1, 0, '2021-01-01 13:30:00', '2020-12-20 18:50:00', 1, 1, 1),
       (2, 1, '2021-01-01 14:30:00', '2020-12-28 17:30:00', 2, 1, 2),
       (3, 2, '2021-01-01 13:30:00', '2020-11-20 19:50:00', 3, 2, 4),
       (4, 1, '2021-01-01 14:15:00', '2020-12-20 18:55:00', 4, 2, 2);