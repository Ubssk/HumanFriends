package HumanFriends.Presenter;

import HumanFriends.Model.HumanFriends;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Registry {
    public List<HumanFriends> humanFriend = new ArrayList<>();
//    private HumanFriends humanFriends = new HumanFriends();

    public void addHumanFriends(HumanFriends humanFriends){
        humanFriend.add(humanFriends);
    }

    public void listCommands(HumanFriends humanFriends){
        System.out.println("Команды для " + humanFriends + ": " + humanFriends.getCommands());
    }

    public void listHumanFriendsByBirthday() {
        Collections.sort(humanFriend, Comparator.comparing(HumanFriends::getBirthday));
        for (HumanFriends humanFriends : humanFriend) {
            System.out.println(humanFriends);
        }
    }
}
