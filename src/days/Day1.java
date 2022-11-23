package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day1 extends Days{
    private int[] inputArray = super.listToInt(input);

    public Day1(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        int result =0;
        for(int i=0; i<(inputArray.length-1); i++){
            if(inputArray[i]<inputArray[i+1]){
                result++;
            }
        }
        System.out.println("Puzzle 1: Result: " +result);
    }

    @Override
    public void puzzle2() {
        int result =0;
        for(int i=0; i<(inputArray.length-3); i++) {
            if (inputArray[i] < inputArray[i + 3]) {
                result++;
            }
        }
        System.out.println("Puzzle 2: Result: "+result);
    }
}
