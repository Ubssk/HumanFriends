package HumanFriends.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanFriends {

    protected List<String> commands; //выполняемые команды
    public String name; // кличка животного
    protected LocalDate birthday; // дата рождения
    public static int amount = 0; // счетчик животных

    public HumanFriends(String name, LocalDate birthday){ // конструктор, принимающий имя и др, создающий лист команд и считающий количество
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
        HumanFriends.amount++;
    }
    public void addCommand(String command) {
        commands.add(command);
    } // добавление команды

    public List<String> getCommands() {
        return commands;
    } // получение, имеюшихся команд

    public LocalDate getBirthday() {
        return birthday;
    } // получение возраста

    public static int getAmount(){ // получение количества животных
        return HumanFriends.amount;
    }

    @Override
    public String toString() {
        return name + " (" + birthday + ")";
    }
}
