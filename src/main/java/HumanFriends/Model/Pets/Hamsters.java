package HumanFriends.Model.Pets;

import java.time.LocalDate;

public class Hamsters extends Pets {

    public Hamsters(String name, LocalDate birthday, String ownerName){
        super(name, birthday, ownerName);
        commands.add("Идти на руки");
        commands.add("Бегать");
    }
}
