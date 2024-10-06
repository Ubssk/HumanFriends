package HumanFriends.Model.PackAnimals;

import HumanFriends.Model.HumanFriends;

import java.time.LocalDate;

public class PackAnimals extends HumanFriends {

    protected String appointment;

    public PackAnimals(String name, LocalDate birthday, String appointment){
        super(name, birthday);
        this.appointment = appointment;
    }
}
