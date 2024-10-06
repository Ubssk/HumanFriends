package HumanFriends.Model.PackAnimals;

import java.time.LocalDate;

public class Donkeys extends PackAnimals { // класс наследует PackAnimals

    public Donkeys(String name, LocalDate birthday, String appointment){ // конструктор, принимающий имя животного, др, назначение и добавляющий базовые команды животного
        super(name, birthday, appointment);
        commands.add("Везти");
        commands.add("Тащить");
    }
}
