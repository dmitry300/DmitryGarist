CREATE TABLE users
(
    id          INTEGER       NOT NULL AUTO_INCREMENT,
    login       CHAR(20)      NOT NULL UNIQUE,
    password    VARCHAR(1000) NOT NULL,
    /*
     * 0 - админ (Role.ADMINISTRATOR)
     * 1 - авторизированный клиент (Role.User)
     * 2 - гость клиент (Role.Guest  )
     */
    role        TINYINT       NOT NULL CHECK (role IN (0, 1, 2)),
    /*
     * 0 - заблокированный (STATUS.BLOCKED)
     * 1 - разрешенный клиент (STATUS.PERMITTED)
     */
    user_status TINYINT       NOT NULL CHECK (user_status IN (0, 1)),
    CONSTRAINT PK_users PRIMARY KEY (id)
);

CREATE TABLE user_info
(
    id         INTEGER      NOT NULL AUTO_INCREMENT,
    name       VARCHAR(30)  NOT NULL,
    surname    VARCHAR(40)  NOT NULL,
    patronymic VARCHAR(40),
    phone      LONG         NOT NULL,
    birthday   DATE,
    email      VARCHAR(255) NOT NULL,
    CONSTRAINT PK_userInfo PRIMARY KEY (id),
    CONSTRAINT FK_userInfoUsers FOREIGN KEY (id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE barbers
(
    id          INTEGER      NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30)  NOT NULL,
    surname     VARCHAR(40)  NOT NULL,
    patronymic  VARCHAR(40)  NOT NULL,
    birthday    DATE         NOT NULL,
    photo       VARCHAR(255) NOT NULL,
    phone       LONG         NOT NULL,
    start_job   DATE         NOT NULL,
    tiktok_link VARCHAR(2083),
    end_job     DATE,
    CONSTRAINT PK_barbers PRIMARY KEY (id)
);
CREATE TABLE reviews
(
    id           INTEGER      NOT NULL AUTO_INCREMENT,
    comment      VARCHAR(180) NOT NULL,
    comment_data TIMESTAMP    NOT NULL,
    user_id      INTEGER      NOT NULL,
    barber_id    INTEGER      NOT NULL,
    CONSTRAINT PK_reviews PRIMARY KEY (id),
    CONSTRAINT FK_reviewBarber FOREIGN KEY (barber_id)
        REFERENCES barbers (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT FK_reviewUser FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE haircuts
(
    id    INTEGER                   NOT NULL AUTO_INCREMENT,
    name  VARCHAR(50)               NOT NULL UNIQUE,
    time  TIME                      NOT NULL,
    price DECIMAL CHECK (price > 0) NOT NULL,
    CONSTRAINT PK_haircuts PRIMARY KEY (id)
);



CREATE TABLE orders
(
    id              INTEGER   NOT NULL AUTO_INCREMENT,
    status          TINYINT   NOT NULL CHECK (status IN (0, 1, 2)),
    date_time       TIMESTAMP NOT NULL,
    date_time_plane TIMESTAMP NOT NULL,
    user_id         INTEGER   NOT NULL,
    barber_id       INTEGER   NOT NULL,
    haircut_id      INTEGER   NOT NULL,
    CONSTRAINT PK_orders PRIMARY KEY (id),
    CONSTRAINT FK_orderHaircut FOREIGN KEY (haircut_id)
        REFERENCES haircuts (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT FK_orderBarber FOREIGN KEY (barber_id)
        REFERENCES barbers (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT,
    CONSTRAINT FK_orderUserInfo FOREIGN KEY (user_id)
        REFERENCES users (id)
        ON UPDATE CASCADE
        ON DELETE RESTRICT
);