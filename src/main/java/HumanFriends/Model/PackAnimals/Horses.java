package HumanFriends.Model.PackAnimals;

import java.time.LocalDate;

public class Horses extends PackAnimals { // класс наследует PackAnimals

    public Horses(String name, LocalDate birthday, String appointment){ // конструктор, принимающий имя животного, др, назначение и добавляющий базовые команды животного
        super(name, birthday, appointment);
        commands.add("Идти");
        commands.add("Бежать");
    }
}
