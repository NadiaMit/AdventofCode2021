import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.lang.*;

public class Reader {
    String path;
    public Reader(String path){
        if(path.isBlank()){
            throw new IllegalArgumentException("Path for Reader is empty");
        }
        this.path = path;
    }
    public List readInput(String filename){
        List<String> inputList = new ArrayList<>();
        try(Scanner myReader = new Scanner(new File(path+filename))){//try with resources, schließt alles wieder automatisch
            while (myReader.hasNextLine()) {
                inputList.add(myReader.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error occured: " + e.getMessage());
        }
        return inputList;
    }


}
