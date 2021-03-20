package domain.Model.Task;

import domain.Performable;

import java.io.Serializable;
import java.time.LocalDateTime;

public class OneTimeTask extends Tasks implements Performable, Serializable {

    public OneTimeTask() {
    }

    public OneTimeTask (String name, Category category, Priority priority, LocalDateTime deadline) {
        super(name, category, priority, deadline);
    }

    @Override
    public void Performable() {

    }

}
