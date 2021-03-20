package domain.Service;

import domain.Model.Task.ReusableTask;
import domain.Model.Task.Tasks;
import org.junit.Assert;

import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

@RunWith(Theories.class)
public class StreamMethodTest extends Assert {

    @DataPoints
    public static int [] data = new int[] {1, 2, 3, 4};
    List <Tasks> tasks = new LinkedList();
    ReusableTask task = new ReusableTask();


    @Theory
    public void symbol() {
        task.setName("1234545");
        tasks.add(task);
        boolean lengthName = tasks.stream().allMatch(task -> task.getName().length() > data[0]);
        assertTrue(lengthName);
    }
}