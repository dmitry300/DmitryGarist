CREATE DATABASE barbershop_db;

create user 'barbershop_user'@localhost
        identified by 'barbershop_password';

GRANT SELECT,INSERT,UPDATE,DELETE
    ON barbershop_db.*
    TO 'barbershop_user'@localhost;

