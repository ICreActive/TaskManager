package domain.Task;

import domain.Exception.InputDeadlineException;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Tasks implements Comparable<Tasks> {

    private String name;
    private Category category;
    private Priority priority;
    private String dateCreation;
    private LocalDateTime deadline;
    protected int TaskId;

    public Tasks() {

    }

    public Tasks(String name, Category category, Priority priority, LocalDateTime deadline) {
        this.name = name;
        this.category = category;
        this.priority = priority;
        this.deadline = deadline;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return this.priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(String dateCreation) {
        this.dateCreation = dateCreation;
    }

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) throws InputDeadlineException {
        LocalDateTime today = LocalDateTime.now();
        if (deadline.isBefore(today)) {
            throw new InputDeadlineException("Incorrect date of deadline");
        }
        this.deadline = deadline;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    @Override
    public int compareTo(Tasks t) {
        return this.name.compareTo(t.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tasks tasks = (Tasks) o;
        return Objects.equals(name, tasks.name) && Objects.equals(deadline, tasks.deadline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, deadline);
    }

    @Override
    public String toString() {
        String a = "TaskID: " + getTaskId() + '\n' +
                "Задача: " + getName() + '\n' +
                "Категория: " + getCategory() + '\n' +
                "Приоритет: " + getPriority() + '\n' +
                "Дата создания: " + getDateCreation() + '\n' +
                "Срок выполнения: " + getDeadline();

        return a.replaceAll("null", " - ");
    }
}








