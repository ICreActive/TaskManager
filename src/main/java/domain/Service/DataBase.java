package domain.Service;

import domain.Task.Tasks;
import domain.Users.User;

import java.util.LinkedList;
import java.util.List;

public final class DataBase implements StorageService {

    private static final String STORAGE_FILE_TASKS = "D:/Tasks.txt";
    private static final String STORAGE_FILE_USERS = "D:/User.txt";
    private static List <User> users = new LinkedList<>();


    @Override
    public void saveTasks(List<Tasks> tasksList) {
        SerializationService.Serialization(tasksList, STORAGE_FILE_TASKS);
        System.out.println("Tasks are saved.");
    }

    @Override
    public List<Tasks> loadTasks() {
        List<Tasks> deserialized = (List<Tasks>) SerializationService.Deserialization (STORAGE_FILE_TASKS);
        System.out.println("Tasks are loaded.");
        return deserialized;
    }

    public static void saveUsers(List <User> user) {
        SerializationService.Serialization(user, STORAGE_FILE_USERS);
        System.out.println("Users are saved.");
    }

    public static List <User> loadUser() {
        List <User> deserialized = (List<User>) SerializationService.Deserialization(STORAGE_FILE_USERS);
        System.out.println("Users are loaded");
        deserialized.forEach(System.out::println);
        return deserialized;
    }

}
