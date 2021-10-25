package by.training.barbershop.controller;

import by.training.barbershop.bean.*;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        User user = new User();
        Optional<User> user1 = Optional.of(user);
        if (user1.isEmpty()){
            System.out.println("user is null");
        }else {
            System.out.println("user is not null");
        }

    }
}

