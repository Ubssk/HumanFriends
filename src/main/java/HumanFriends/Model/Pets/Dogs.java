package HumanFriends.Model.Pets;

import java.time.LocalDate;

public class Dogs extends Pets {

    public Dogs(String name, LocalDate birthday, String ownerName){
        super(name, birthday, ownerName);
        commands.add("Сидеть");
        commands.add("Лежать");
    }
}
