package domain.Task;

public enum Category {
    HOME("home"), SHOP("shop"), STUDY("study"), WORK("work"), OTHER ("other");

    String name;

    Category(String name) {
        this.name = name;
    }



}
