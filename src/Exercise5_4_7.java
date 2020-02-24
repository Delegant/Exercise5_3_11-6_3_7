import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Exercise5_4_7 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal firstCat = new Animal("Vasily");
        Animal secondCat = new Animal("Barsic");
        Object[] originalArr = {2, firstCat,secondCat};
        byte [] originalData = serializeArray(originalArr);
        Animal[] deserializeCat = deserializeAnimalArray(originalData);
            System.out.println(deserializeCat[0].equals(firstCat));
            System.out.println(deserializeCat[1].equals(secondCat));
    }

    public static byte[] serializeArray(Object[] data) throws IOException {
        byte[] serializeData;
        try (ByteArrayOutputStream is = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(is)) {
            oos.writeInt((int)data[0]);
            for (int i=1; i<data.length;i++) {
                oos.writeObject(data[i]);
            }
            serializeData = is.toByteArray();
        }
        System.out.println("Serialize complete");
        return serializeData;
    }

    public static Animal[] deserializeAnimalArray(byte[] data) throws IllegalArgumentException {
        IllegalArgumentException iaex = new IllegalArgumentException();
        Animal[] deserializeAnimal;
        int size;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            size = ois.readInt();
            deserializeAnimal = new Animal[size];
            for (int i = 0; i<size; i++) {
                deserializeAnimal[i] = (Animal) ois.readObject();
            }
        }
        catch (IOException e){
            throw iaex;
        }
        catch (ClassNotFoundException e){
            throw iaex;
        }
        return deserializeAnimal;
    }


    static class Animal implements Serializable {
        private final String name;

        public Animal(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Animal) {
                return Objects.equals(name, ((Animal) obj).name);
            }
            return false;
        }
    }
}

