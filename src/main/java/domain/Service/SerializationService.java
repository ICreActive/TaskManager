package domain.Service;

import java.io.*;
import java.util.LinkedList;


public class SerializationService {

    private static final String STORAGE_FILE_USERS = "D:/User.txt";
    private static final String STORAGE_FILE_TASKS = "D:/Tasks.txt";

    public static void Serialization(Object object, String fileName) {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            fos.close();

        } catch (IOException e) {
            System.out.println("An error occurred during object serialization.");
            throw new RuntimeException(e);
        }
    }

    public static Object Deserialization(String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            if (fileName.equals(STORAGE_FILE_USERS)) {
                File file = new File(STORAGE_FILE_USERS);
            } else {
                File file = new File(STORAGE_FILE_TASKS);
            }
            return new LinkedList();
        }
    }

}


