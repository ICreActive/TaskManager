package domain.Model.Task;

import domain.Exception.InputDeadlineException;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TasksTest {

    public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");

    @Test (expected = InputDeadlineException.class)
    public void setDeadline() throws InputDeadlineException {
        ReusableTask task = new ReusableTask();
        String deadLine = "13.03.2021 09:00";
        LocalDateTime deadline1 = LocalDateTime.parse(deadLine, dtf);
        task.setDeadline(deadline1);
    }
}