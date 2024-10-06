package HumanFriends.Model.Pets;

import java.time.LocalDate;

public class Hamsters extends Pets { // наследование класса Pets

    public Hamsters(String name, LocalDate birthday, String ownerName){ // конструктор, принимающий имя животного, др, имя хозяина и добавляющий базовые команды животного
        super(name, birthday, ownerName);
        commands.add("Идти на руки");
        commands.add("Бегать");
    }
}
