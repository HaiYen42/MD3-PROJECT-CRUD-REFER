package Config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static Scanner scanner(){
        Scanner scanner= new Scanner(System.in);
        return scanner;
    }
    public static final String PATH_PRODUCT = "src/database/product.txt";
    public static final String PATH_CATEGORY= "src/database/category.txt";
    // Read File
    public List<T> readFromFile(String pathFile){
        List<T> tList = new ArrayList<>();
        try{
            File file = new File(pathFile);
            if (file.exists()) {
                FileInputStream fileInputStream = new FileInputStream(pathFile);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                tList= (List<T>) objectInputStream.readObject();
                fileInputStream.close();
                objectInputStream.close();
            }
        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }catch (IOException e){
            System.out.println("IOException");
        }catch (ClassNotFoundException e){
            System.out.println("ClassNotFoundException");
        }
        return tList;
    }
    //Write File
    public void writeToFile(String pathFile, List<T> tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        }catch (FileNotFoundException e){
            System.out.println("FileNotFoundException");
        }catch (IOException e){
            System.out.println("IOException");
        }
    }
}
