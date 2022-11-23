package days;

import java.util.ArrayList;
import java.util.List;

public abstract class Days {
    List<String> input = new ArrayList<String>();

    public Days(List<String> input){
        if(input == null || input.isEmpty()){
            throw new IllegalArgumentException("Empty input List for Day");
        }
        this.input = input;
    }

    public int[] numberToDigits(String stringInput){
        int[] digits = new int[stringInput.length()];
        int i = 0;
        try{
            for(char c: stringInput.toCharArray()){
                digits[i] = Integer.parseInt(String.valueOf(c));
                i++;
            }
        }catch (Exception e){
            System.out.println("Error at numberToDigits: "+e.getMessage());
        }
        return digits;
    }

    public int[][] listTo2DArray(List<String> stringList){
        int[][] returnArray = new int[stringList.size()][stringList.get(0).length()];
        int counter;
        for(int i = 0; i< stringList.size(); i++){
            counter=0;
            for (char c : stringList.get(i).toCharArray()){
                returnArray[i][counter] = Integer.parseInt(String.valueOf(c));
                counter++;
            }
        }
        return returnArray;
    }

    public int[] stringToInt(String stringInput){
        String[] strings = stringInput.split(",");
        int[] returnArray = new int[strings.length];
        for(int i = 0; i<strings.length; i++){
            returnArray[i] = Integer.parseInt(strings[i]);
        }
        return returnArray;
    }

    public int[] listToInt(List<String> stringList){
        int[] inputArray = new int[input.size()];
        try{
            int i =0;
            for(String s: input){
                inputArray[i++] = Integer.parseInt(s);
            }
        }
        catch(Exception e){
            System.out.println("Error at converting string to int: " + e.getMessage());
        }
        return inputArray;
    }

    public abstract void puzzle1();

    public abstract void puzzle2();
}
