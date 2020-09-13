import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class E10_SerializeArrayList {
    public static void main(String[] args) {


        List<Double> doubles = new ArrayList<>();

        doubles.add(3.14);
        doubles.add(1.65);
        doubles.add(13.27);
        doubles.add(42.69);

        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("double.ser"));
            outputStream.writeObject(doubles);
            outputStream.close();

            ObjectInputStream inputStream = new  ObjectInputStream (new FileInputStream("double.ser"));
            Object o = inputStream.readObject();

            if(o instanceof ArrayList){
               var list =  (ArrayList<Double>) o;
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
