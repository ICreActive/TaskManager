package Applicathion;


import domain.Task.*;
import domain.Users.User;

import java.util.*;

public class App {

    public static void main(String[] args) {

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

        System.out.println("Для создания новой задчачи введите - 1");

        Scanner sc1 = new Scanner(System.in);
        int userChoice = sc1.nextInt();
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
                String deadline = sc5.nextLine();

                System.out.println("Нужно ли повторить задачу в будущем? y / n");
                Scanner sc6 = new Scanner(System.in);
                String repeat = sc6.nextLine();


                if (repeat.equals("y")) {
                    ReusableTask task = new ReusableTask();

                    for (Category elem : Category.values()) {
                        if (elem.name().equalsIgnoreCase(category)) {
                            task.setCategory(category.toUpperCase(Locale.ROOT));
                            break;
                        }
                        task.setCategory("OTHER");
                    }

                    System.out.println("Введите количество повторов для этой задачи");
                    Scanner sc7 = new Scanner(System.in);
                    int repeatCount = sc7.nextInt();
                    task.setName(name);
                    for (Priority elem : Priority.values()) {
                        if (elem.name().equals(priority)) {
                            task.setPriority(priority);
                            break;
                        }
                        task.setPriority("without");
                    }

                    task.setDeadline(deadline);
                    task.setRepeatCount(repeatCount);
                    taskList.add(task);
                    task.setTaskId(taskList.indexOf(task) + 1);
                    System.out.println("Создана повторяемая задача: " + "\n" + task + '\n');

                } else if (repeat.equals("n")) {
                    OneTimeTask task = new OneTimeTask();
                    task.setName(name);
                    for (Category elem : Category.values()) {
                        if (elem.name().equalsIgnoreCase(category)) {
                            task.setCategory(category.toUpperCase());
                            break;
                        }
                        task.setCategory("OTHER");
                    }
                    for (Priority elem : Priority.values()
                    ) {
                        if (elem.name().equalsIgnoreCase(priority)) {
                            task.setPriority(priority.toUpperCase());
                            break;
                        }
                        task.setPriority("without");
                    }
                    task.setPriority(priority);
                    task.setDeadline(deadline);
                    taskList.add(task);
                    task.setTaskId(taskList.indexOf(task) + 1);
                    System.out.println("Создана одноразовая задача: " + "\n" + task + '\n');

                } else {
                    System.out.println("Недопустимое значение");
                }

                System.out.println("Ввести новую задачу? (yes / любая клавиша)");
                Scanner sc7 = new Scanner(System.in);
                userChoice1 = sc7.nextLine();
            } while (userChoice1.equals("yes"));


            System.out.println("Вывести все задачи? y / n");
            Scanner sc7 = new Scanner(System.in);
            String showAllTask = sc7.nextLine();
            if (showAllTask.equals("y")) {
                for (Tasks list : taskList) {
                    System.out.println(list);
                    System.out.println();
                }

            }
        }
        System.out.println("Отсортировать задачи по названию? y/n");
        Scanner sc8 = new Scanner(System.in);
        String sort = sc8.nextLine();

        if (sort.equals("y")) {
            Collections.sort(taskList);
            for (Tasks list : taskList) {
                System.out.println(list);
                System.out.println();
            }

        }
    }

}





