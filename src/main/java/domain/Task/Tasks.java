package domain.Task;

import java.util.Objects;

public abstract class Tasks implements Comparable<Tasks>{

    private String name;
    private Category category;
    private Priority priority;
    private String deadline;
    protected int TaskId;


    public Tasks() {

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

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getTaskId() {
        return TaskId;
    }

    public void setTaskId(int taskId) {
        TaskId = taskId;
    }

    @Override
    public String toString() {
        String a = "TaskID: " + TaskId + '\n'+
                "Задача: " + getName() + '\n' +
                "Категория: " + getCategory() + '\n' +
                "Приоритет: " + getPriority() + '\n' +
                "Срок выполнения: " + getDeadline();
        return a.replaceAll("null", " - ");
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
        return Objects.equals(name, tasks.name) && Objects.equals(category, tasks.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, priority, deadline, TaskId);

    }

}








