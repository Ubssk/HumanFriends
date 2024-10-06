package HumanFriends.Presenter;

import HumanFriends.Model.HumanFriends;
import HumanFriends.Model.PackAnimals.Camels;
import HumanFriends.Model.PackAnimals.Donkeys;
import HumanFriends.Model.PackAnimals.Horses;
import HumanFriends.Model.PackAnimals.PackAnimals;
import HumanFriends.Model.Pets.Cats;
import HumanFriends.Model.Pets.Dogs;
import HumanFriends.Model.Pets.Hamsters;
import HumanFriends.Model.Pets.Pets;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI {

    Scanner scanner = new Scanner(System.in);
    Registry registry = new Registry();
    boolean running = true;

    public ConsoleUI(){

    }
    public static void start(Scanner scanner, Registry registry, boolean running) {
        while (running) {
            System.out.println("\nМеню:");
            System.out.println("1. Добавить животное");
            System.out.println("2. Показать команды животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Показать список животных по дате рождения");
            System.out.println("5. Общее количество созданных животных");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Считываем остаток строки

            switch (choice) {
                case 1:
                    System.out.print("Введите тип животного (домашнее/вьючное): ");
                    String type = scanner.nextLine();
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите дату рождения (гггг-мм-дд): ");
                    LocalDate birthday = scanner.nextLine();

                    switch (type.toLowerCase()) {
                        case "домашнее":
                            System.out.print("Введите тип животного (собака/кошка/хомяк): ");
                            String typeOfPets = scanner.nextLine();
                            System.out.print("Введите имя хозяина): ");
                            String ownerName = scanner.nextLine();
                            registry.addHumanFriends(new Pets(name, birthday, ownerName));
                            switch (typeOfPets.toLowerCase()) {
                                case "собака":
                                    registry.addHumanFriends(new Dogs(name, birthday, ownerName));
                                    break;
                                case "кошка":
                                    registry.addHumanFriends(new Cats(name, birthday, ownerName));
                                    break;
                                case "хомяк":
                                    registry.addHumanFriends(new Hamsters(name, birthday, ownerName));
                                    break;
                                default:
                                    System.out.println("Неизвестный тип животного.");
                            }
                            break;
                        case "вьючное":
                            System.out.print("Введите тип животного (верблюд/осел/лошадь): ");
                            String typeOfPackAnimals = scanner.nextLine();
                            System.out.print("Введите назначение): ");
                            String appointment = scanner.nextLine();
                            registry.addHumanFriends(new PackAnimals(name, birthday, appointment));
                            switch (typeOfPackAnimals.toLowerCase()) {
                                case "верблюд":
                                    registry.addHumanFriends(new Camels(name, birthday, appointment));
                                    break;
                                case "осел":
                                    registry.addHumanFriends(new Donkeys(name, birthday, appointment));
                                    break;
                                case "лошадь":
                                    registry.addHumanFriends(new Horses(name, birthday, appointment));
                                    break;
                                default:
                                    System.out.println("Неизвестный тип животного.");
                            }
                            break;
                        default:
                            System.out.println("Неизвестный тип животного.");
                    }
                    break;

                case 2:
                    System.out.print("Введите имя животного: ");
                    String humanFriendsName = scanner.nextLine();
                    HumanFriends foundHumanFriends = registry.humanFriend.stream()
                            .filter(humanFriends -> humanFriends.name.equalsIgnoreCase(humanFriendsName))
                            .findFirst()
                            .orElse(null);
                    if (foundHumanFriends != null) {
                        registry.listCommands(foundHumanFriends);
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 3:
                    System.out.print("Введите имя животного: ");
                    humanFriendsName = scanner.nextLine();
                    foundHumanFriends = registry.humanFriend.stream()
                            .filter(humanFriends -> humanFriends.name.equalsIgnoreCase(humanFriendsName))
                            .findFirst()
                            .orElse(null);
                    if (foundHumanFriends != null) {
                        System.out.print("Введите новую команду: ");
                        String newCommand = scanner.nextLine();
                        foundHumanFriends.addCommand(newCommand);
                        System.out.println("Команда добавлена.");
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 4:
                    registry.listHumanFriendsByBirthday();
                    break;

                case 5:
                    humanFriends.getAmount();
                    break;

                case 6:
                    running = false;
                    System.out.println("Выход из программы.");
                    break;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }

        scanner.close();
    }
}
