package HumanFriends.Presenter;

import HumanFriends.Model.HumanFriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Registry {
    public List<HumanFriends> humanFriend = new ArrayList<>(); // создание упорядоченного списка с индексацией

    public void addHumanFriends(HumanFriends humanFriends){ // добавление нового животного
        humanFriend.add(humanFriends);
    }

    public void listCommands(HumanFriends humanFriends){ // список команд
        System.out.println("Команды для " + humanFriends.name + ": " + humanFriends.getCommands());
    }

    public void listHumanFriendsByBirthday() { // список животных по дню рождения
        Collections.sort(humanFriend, Comparator.comparing(HumanFriends::getBirthday));
        for (HumanFriends humanFriends : humanFriend) {
            System.out.println(humanFriends);
        }
    }
}
