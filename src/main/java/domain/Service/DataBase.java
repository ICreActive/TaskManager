package domain.Service;

import domain.Task.Tasks;

import java.util.List;

public class DataBase implements StorageService {

    private static final String STORAGE_FILE_NAME = "D:/Tasks.txt";

    @Override
    public void saveTasks(List<Tasks> tasksList) {
        SerializationService.Serialization(tasksList, STORAGE_FILE_NAME);
        System.out.println("Tasks are saved.");

    }

    @Override
    public List<Tasks> loadTasks() {
        List<Tasks> deserialized = (List<Tasks>) SerializationService.Deserialization (STORAGE_FILE_NAME);
        System.out.println("Tasks are loaded.");

        return deserialized;
    }
}
