package HumanFriends.Model.PackAnimals;

import java.time.LocalDate;

public class Donkeys extends PackAnimals {

    public Donkeys(String name, LocalDate birthday, String appointment){
        super(name, birthday, appointment);
        commands.add("Везти");
        commands.add("Тащить");
    }
}
