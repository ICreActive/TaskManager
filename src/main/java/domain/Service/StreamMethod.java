package domain.Service;

import domain.Task.Category;
import domain.Task.Tasks;

import java.util.List;
import java.util.stream.Collectors;

public class StreamMethod {

    public static void filterToCategory(List<Tasks> taskList, String filterCategory) {

        for (
                Category elem : Category.values())
            if (elem.name().

                    equalsIgnoreCase(filterCategory)) {
                taskList.stream()
                        .filter(tasks -> tasks.getCategory().equals(Category.valueOf(filterCategory.toUpperCase())))
                        .forEach(System.out::println);
            }
    }

    public static void showAllTask(List<Tasks> tasks) {
        tasks.stream()
                .map(Tasks::getName)
                .forEach(System.out::println);
    }


    public static void UniqueTask(List<Tasks> tasks) {

        tasks.stream()
                .distinct()
                .collect(Collectors.toList())
                .forEach(System.out::println);

    }

    public static void symbol(List<Tasks> tasks, int symbols) {
        boolean lengthName = tasks.stream().allMatch(task -> task.getName().length() > symbols);
        if (lengthName) {
            System.out.println("Названия длинее чем " + symbols);
        } else {
            System.out.println("Названия не длинее чем " + symbols);
        }
    }

}