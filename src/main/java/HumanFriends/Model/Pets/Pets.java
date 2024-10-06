package HumanFriends.Model.Pets;

import HumanFriends.Model.HumanFriends;

import java.time.LocalDate;

public class Pets extends HumanFriends {

    protected String ownerName;

    public Pets(String name, LocalDate birthday, String ownerName){
        super(name, birthday);
        this.ownerName = ownerName;
    }
}
