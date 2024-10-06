package HumanFriends.Model.PackAnimals;

import java.time.LocalDate;

public class Camels extends PackAnimals { // класс наследует PackAnimals

    public Camels(String name, LocalDate birthday, String appointment){ // конструктор, принимающий имя животного, др, назначение и добавляющий базовые команды животного
        super(name, birthday, appointment);
        commands.add("Идти");
        commands.add("Нести");
    }
}
