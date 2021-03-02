package domain.Service;
import java.io.*;
public class SerializationService {

    public static void Serialization (Object object, String fileName) {

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

    public static Object Deserialization (String fileName) {
        try (FileInputStream fileInputStream = new FileInputStream(fileName);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)
        ) {
            return objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("An error occurred during object deserialization.");
            throw new RuntimeException(e);
        }
    }

}


