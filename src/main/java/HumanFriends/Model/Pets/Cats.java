package HumanFriends.Model.Pets;

import java.time.LocalDate;

public class Cats extends Pets { // наследование класса Pets

    public Cats(String name, LocalDate birthday, String ownerName){ // конструктор, принимающий имя животного, др, имя хозяина и добавляющий базовые команды животного
        super(name, birthday, ownerName);
        commands.add("Кушать");
        commands.add("Мяукать");
    }
}
