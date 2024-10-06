package HumanFriends.Model.PackAnimals;

import java.time.LocalDate;

public class Horses extends PackAnimals {

    public Horses(String name, LocalDate birthday, String appointment){
        super(name, birthday, appointment);
        commands.add("Идти");
        commands.add("Бежать");
    }
}
