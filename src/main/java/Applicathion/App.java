package Applicathion;


import domain.Exception.InputDeadlineException;
import domain.Service.DateValidatorDTF;
import domain.Service.StreamMethod;
import domain.Task.*;
import domain.Users.User;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class App {

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    public static void main(String[] args) throws InputDeadlineException {

        User<Object> NewUser = new User.Builder<>()
                .withName("Ivan")
                .withSurname("Shkubel")
                .withEmail("negumadness@gmail.com")
                .withUserID(12234)
                .build();
        System.out.println(NewUser);


        User<Object> NewUser1 = new User.Builder<>()
                .withName("Ivan")
                .withSurname("Shkubel")
                .withEmail("negumadness@gmail.com")
                .withUserID("1fhswwq")
                .build();
        System.out.println(NewUser1);


        List<Tasks> taskList = new LinkedList<>();

        LocalDateTime today = LocalDateTime.now();
        String todayStr = today.format(dtf);

        System.out.println("Для создания новой задчачи введите - 1");

        Scanner sc1 = new Scanner(System.in);
        int userChoice;
        boolean b;
        try {
            userChoice = sc1.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Допустимы только цифровые значения");
            Scanner sc01 = new Scanner(System.in);
            b = sc01.hasNextInt();
            while (!b) {
                System.err.println("Допустимы только цифровые значения");
                sc01 = new Scanner(System.in);
                b = sc01.hasNextInt();
            }
            userChoice = sc01.nextInt();
        }

        String userChoice1;
        if (userChoice == 1) {
            do {

                System.out.println("Введите название задачи");
                Scanner sc2 = new Scanner(System.in);
                String name = sc2.nextLine();

                System.out.println("Введите категорию, (Enter чтобы пропустить)");
                Scanner sc3 = new Scanner(System.in);
                String category = sc3.nextLine();

                System.out.println("Введите приоритет, (Enter чтобы пропустить)");
                Scanner sc4 = new Scanner(System.in);
                String priority = sc4.nextLine();

                System.out.println("Введите критичную дату выполнения, (Enter чтобы пропустить)");
                Scanner sc5 = new Scanner(System.in);
                String deadlineStr;
                deadlineStr = sc5.nextLine();
                LocalDateTime deadline;

                DateValidatorDTF validator = new DateValidatorDTF(dtf);
                while (!validator.isValid(deadlineStr)) {
                    System.err.println("Incorrect format DateTime (dd.MM.yyyy HH:mm)");
                    Scanner sc05 = new Scanner(System.in);
                    deadlineStr = sc05.nextLine();
                }

                deadline = LocalDateTime.parse(deadlineStr, dtf);

                System.out.println(deadline);

                System.out.println("Нужно ли повторить задачу в будущем? y / n");
                Scanner sc6 = new Scanner(System.in);
                String repeat = sc6.nextLine();

                if (repeat.equals("y")) {
                    ReusableTask task = new ReusableTask();

                    for (Category elem : Category.values()) {
                        if (elem.name().equalsIgnoreCase(category)) {
                            task.setCategory(Category.valueOf(category.toUpperCase()));
                            break;
                        }
                        task.setCategory(Category.OTHER);
                    }

                    System.out.println("Введите количество повторов для этой задачи");
                    Scanner sc7 = new Scanner(System.in);
                    int repeatCount = sc7.nextInt();
                    task.setName(name);
                    for (Priority elem : Priority.values()) {
                        if (elem.name().equalsIgnoreCase(priority)) {
                            task.setPriority(Priority.valueOf(priority.toUpperCase()));
                            break;
                        }
                        task.setPriority(Priority.WITHOUT);
                    }
                    try {
                        task.setDeadline(deadline);
                    } catch (InputDeadlineException e) {
                        e.printStackTrace();
                    }
                    task.setDateCreation(today);
                    task.setRepeatCount(repeatCount);
                    taskList.add(task);
                    task.setTaskId(taskList.indexOf(task) + 1);
                    System.out.println("Создана повторяемая задача: " + "\n" + task + '\n');


                } else if (repeat.equals("n")) {
                    OneTimeTask task = new OneTimeTask();
                    task.setName(name);
                    for (Category elem : Category.values()) {
                        if (elem.name().equalsIgnoreCase(category)) {
                            task.setCategory(Category.valueOf(category.toUpperCase()));
                            break;
                        }
                        task.setCategory(Category.OTHER);
                    }
                    for (Priority elem : Priority.values()
                    ) {
                        if (elem.name().equalsIgnoreCase(priority)) {
                            task.setPriority(Priority.valueOf(priority.toUpperCase()));
                            break;
                        }
                        task.setPriority(Priority.WITHOUT);
                    }
                    task.setDeadline(deadline);
                    task.setDateCreation(today);
                    taskList.add(task);
                    task.setTaskId(taskList.indexOf(task) + 1);
                    System.out.println("Создана одноразовая задача: " + "\n" + task + '\n');

                } else {
                    System.out.println("Недопустимое значение");
                }

                System.out.println("Ввести новую задачу? (y / любая клавиша)");
                Scanner sc7 = new Scanner(System.in);
                userChoice1 = sc7.nextLine();
            } while (userChoice1.equals("y"));
        }
        System.out.println("Вывести все задачи? y / n");
        Scanner sc7 = new Scanner(System.in);
        String showAllTask = sc7.nextLine();
        if (showAllTask.equals("y")) {
            for (Tasks list : taskList) {
                System.out.println(list);
                System.out.println();
            }
        }

        System.out.println("Отсортировать задачи по названию? y/n");
        Scanner sc8 = new Scanner(System.in);
        String sort = sc8.nextLine();

        if (sort.equalsIgnoreCase("y")) {
            Collections.sort(taskList);
            for (Tasks list : taskList) {
                System.out.println(list);
                System.out.println();
            }

        }
        System.out.println("Фильтр задач. Введите категорию задачи");
        Scanner sc9 = new Scanner(System.in);
        String filterCategory = sc9.nextLine();

        StreamMethod.filterToCategory(taskList, filterCategory);

        System.out.println("Вывести названия задач? y / n");
        Scanner sc10 = new Scanner(System.in);
        String ShowAllName = sc10.nextLine();
        if (ShowAllName.equalsIgnoreCase("y")) {
            StreamMethod.showAllTask(taskList);
        }
        System.out.println("Вывести только уникальные по названию задачи? y / n");
        Scanner sc11 = new Scanner(System.in);
        String uniq = sc11.nextLine();
        if (uniq.equalsIgnoreCase("y")) {
            StreamMethod.UniqueTask(taskList);
        }
        System.out.println("Больше какого количества символов должны быть имена задач?");
        Scanner sc12 = new Scanner(System.in);
        int numberSymbols;
        boolean a;
        try {
            numberSymbols = sc12.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Допустимы только цифровые значения");
            Scanner sc13 = new Scanner(System.in);
            a = sc13.hasNextInt();
            while (!a) {
                System.err.println("Допустимы только цифровые значения");
                sc13 = new Scanner(System.in);
                a = sc13.hasNextInt();
            }
            numberSymbols = sc13.nextInt();
        }

        StreamMethod.symbol(taskList, numberSymbols);

    }


}












