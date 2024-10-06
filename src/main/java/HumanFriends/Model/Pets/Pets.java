package HumanFriends.Model.Pets;

import HumanFriends.Model.HumanFriends;

import java.time.LocalDate;

public class Pets extends HumanFriends { // класс, наследующий HumanFriends

    protected String ownerName; // имя хозяина

    public Pets(String name, LocalDate birthday, String ownerName){ // конструктор, принимающий имя животного, др и назначающий имя хозяина
        super(name, birthday);
        this.ownerName = ownerName;
    }
}
