package domain.Task;

import domain.Performable;

public class ReusableTask extends Tasks implements Performable, Comparable<Tasks> {

    private int repeatCount;

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    @Override

    public String toString() {
        String a = "TaskID: " + TaskId + '\n' +
                "Задача: " + getName() + '\n' +
                "Категория: " + getCategory() + '\n' +
                "Приоритет: " + getPriority() + '\n' +
                "Срок выполнения: " + getDeadline() + '\n' +
                "Количество повторений: " + getRepeatCount();


        return a.replaceAll("null", " - ");
    }

    @Override
    public void Performable() {
        int a = getRepeatCount();
        a = a - 1;
        setRepeatCount(a);
    }

}
