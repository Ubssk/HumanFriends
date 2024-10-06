package HumanFriends.Model.Pets;

import java.time.LocalDate;

public class Dogs extends Pets { // наследование класса Pets

    public Dogs(String name, LocalDate birthday, String ownerName){ // конструктор, принимающий имя животного, др, имя хозяина и добавляющий базовые команды животного
        super(name, birthday, ownerName);
        commands.add("Сидеть");
        commands.add("Лежать");
    }
}
