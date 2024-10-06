package HumanFriends.Model.PackAnimals;

import java.time.LocalDate;

public class Camels extends PackAnimals {

    public Camels(String name, LocalDate birthday, String appointment){
        super(name, birthday, appointment);
        commands.add("Идти");
        commands.add("Нести");
    }
}
