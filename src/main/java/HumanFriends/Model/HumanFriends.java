package HumanFriends.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanFriends {

    protected List<String> commands; //выполняемые команды
    public String name; //кличка животного
    protected LocalDate birthday; // дата рождения
    private static int amount = 0; // счетчик животных
//    Animals animals = new Animals();

    public HumanFriends(String name, LocalDate birthday){
        this.name = name;
        this.birthday = birthday;
        this.commands = new ArrayList<>();
        HumanFriends.amount++;
    }
    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int getAmount(){
        return HumanFriends.amount;
    }

    @Override
    public String toString() {
        return name + " (" + birthday + ")";
    }
}
