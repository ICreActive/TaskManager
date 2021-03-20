package domain.Service;

import domain.Model.Task.Tasks;
import java.util.List;

public interface StorageService {

    void saveTasks(List<Tasks> tasksList);
    List <Tasks> loadTasks();

}
