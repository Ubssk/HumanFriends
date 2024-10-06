package HumanFriends.Model.PackAnimals;

import HumanFriends.Model.HumanFriends;

import java.time.LocalDate;

public class PackAnimals extends HumanFriends { // класс наследует HumanFriends

    protected String appointment; // назначение животного

    public PackAnimals(String name, LocalDate birthday, String appointment){ // конструктор, принимающий имя животного, др и указывающий назначение животного
        super(name, birthday);
        this.appointment = appointment;
    }
}
