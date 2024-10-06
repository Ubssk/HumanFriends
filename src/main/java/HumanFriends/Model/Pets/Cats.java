package HumanFriends.Model.Pets;

import java.time.LocalDate;

public class Cats extends Pets {

    public Cats(String name, LocalDate birthday, String ownerName){
        super(name, birthday, ownerName);
        commands.add("Кушать");
        commands.add("Мяукать");
    }
}
