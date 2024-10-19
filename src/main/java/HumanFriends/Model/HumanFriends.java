package HumanFriends.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanFriends {

    public int id = 1; // Уникальный идентификатор

    public String name; // кличка животного
    protected LocalDate birthday; // дата рождения
    protected List<String> commands; //выполняемые команды
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ", Birthday: " + birthday + ")";
    }
}
