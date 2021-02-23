package domain.Service;

import domain.Task.Tasks;

import java.io.*;
import java.util.List;

public class IO {

    File FILE = new File("D:/Tasks.txt");

    public boolean Serialization(List<Tasks> taskList) {
        boolean flag = false;
        ObjectOutputStream oos = null;

        try {
            FileOutputStream fos = new FileOutputStream(FILE);
            if (fos != null) {
                oos = new ObjectOutputStream(fos);
                oos.writeObject(taskList);
                flag = true;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;

    }

    public Object Deserialization ()

    {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(fis);
            return ois.readObject();
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
}


