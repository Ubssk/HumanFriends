package HumanFriends.Presenter;

import HumanFriends.Model.PackAnimals.Camels;
import HumanFriends.Model.PackAnimals.Donkeys;
import HumanFriends.Model.PackAnimals.Horses;
import HumanFriends.Model.Pets.Cats;
import HumanFriends.Model.Pets.Dogs;
import HumanFriends.Model.Pets.Hamsters;
import HumanFriends.Model.HumanFriends;
import HumanFriends.Presenter.Registry;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleUI {

    public static void consoleUI() {

        Scanner scanner = new Scanner(System.in);
        Registry registry = new Registry();
        boolean running = true;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


        while (running) {
            System.out.println("\nРеестр домашних животных:");
            System.out.println("1. Добавить животное");
            System.out.println("2. Показать команды животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Показать список животных по дате рождения");
            System.out.println("5. Общее количество созданных животных");
            System.out.println("6. Выход");
            System.out.print("Выберите опцию: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите тип животного (домашнее/вьючное): ");
                    String type = scanner.nextLine().toLowerCase();
                    if (!type.equals("домашнее") && !type.equals("вьючное")) {
                        System.out.println("Неизвестный тип животного. Попробуйте снова.");
                        break;
                    }
                    System.out.print("Введите имя животного: ");
                    String name = scanner.nextLine();
                    LocalDate birthday = null;
                    while (birthday == null) {
                        System.out.print("Введите дату рождения (гггг-мм-дд): ");
                        String birthdayString = scanner.nextLine();
                        try {
                            birthday = LocalDate.parse(birthdayString, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Некорректный формат даты или дата больше текущей. Пожалуйста, используйте формат 'гггг-мм-дд'.");
                        }
                    }

                    switch (type.toLowerCase()) {
                        case "домашнее":
                            System.out.print("Введите тип животного (собака/кошка/хомяк): ");
                            String typeOfPets = scanner.nextLine().toLowerCase();
                            if (!typeOfPets.equals("собака") && !typeOfPets.equals("кошка") && !typeOfPets.equals("хомяк")) {
                                System.out.println("Неизвестный тип домашнего животного. Попробуйте снова.");
                                break; // Возвращаемся к началу цикла
                            }
                            System.out.print("Введите имя хозяина: ");
                            String ownerName = scanner.nextLine();
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
                            String typeOfPackAnimals = scanner.nextLine().toLowerCase();
                            if (!typeOfPackAnimals.equals("верблюд") && !typeOfPackAnimals.equals("осел") && !typeOfPackAnimals.equals("лошадь")) {
                                System.out.println("Неизвестный тип вьючного животного. Попробуйте снова.");
                                break;
                            }
                            System.out.print("Введите назначение: ");
                            String appointment = scanner.nextLine();
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
                    }
                    break;

                case 2:
                    System.out.print("Введите имя животного: ");
                    String humanFriendsName = scanner.nextLine();
                    List<HumanFriends> foundHumanFriends = registry.humanFriend.stream()
                            .filter(humanFriends -> humanFriends.getName().equalsIgnoreCase(humanFriendsName)) // Используем getName() если у вас метод для доступа к имени
                            .collect(Collectors.toList());

                    if (!foundHumanFriends.isEmpty()) {
                        for (HumanFriends humanFriend : foundHumanFriends) {
                            registry.listCommands(humanFriend);
                        }
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 3:
                    System.out.print("Введите имя животного: ");
                    humanFriendsName = scanner.nextLine();
                    foundHumanFriends = registry.humanFriend.stream()
                            .filter(humanFriends -> humanFriends.getName().equalsIgnoreCase(humanFriendsName))
                            .collect(Collectors.toList());

                    if (!foundHumanFriends.isEmpty()) {
                        System.out.println("Найденные животные с именем \"" + humanFriendsName + "\":");
                        for (HumanFriends humanFriend : foundHumanFriends) {
                            System.out.println("ID: " + humanFriend.getId() + ", Имя: " + humanFriend.getName() + ", Дата рождения: " + humanFriend.getBirthday() + ", Комманды животного: " + humanFriend.getCommands());
                        }

                        System.out.print("Введите ID животного, для которого хотите добавить команду: ");
                        int selectedId = scanner.nextInt();
                        scanner.nextLine();

                        HumanFriends selectedHumanFriend = foundHumanFriends.stream()
                                .filter(humanFriends -> humanFriends.getId() == selectedId)
                                .findFirst()
                                .orElse(null);

                        if (selectedHumanFriend != null) {
                            System.out.print("Введите новую команду: ");
                            String newCommand = scanner.nextLine();
                            selectedHumanFriend.addCommand(newCommand);
                            System.out.println("Команда добавлена.");
                        } else {
                            System.out.println("Животное с таким ID не найдено.");
                        }
                    } else {
                        System.out.println("Животное не найдено.");
                    }
                    break;

                case 4:
                    registry.listHumanFriendsByBirthday();
                    break;

                case 5:
                    HumanFriends.getAmount();
                    System.out.println(HumanFriends.getAmount());
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
