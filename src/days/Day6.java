package days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day6 extends Days {
    public Day6(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        long[] fishList = new long[9];
        long fishCount=0;
        for(long i : fishList){
            i=0;
        }
        for(String s: input.get(0).split(",")){
            fishList[Integer.parseInt(s)]+=1;
        }
        for(int day=0; day<80; day++){
            long fishZero = fishList[0];
            for(int i =1; i<9;i++){
                fishList[i-1]=fishList[i];
            }
            fishList[8]=fishZero;
            fishList[6]+=fishZero;
        }
        fishCount= Arrays.stream(fishList).sum();
        System.out.println("Result: "+fishCount);
    }

    @Override
    public void puzzle2() {
        long[] fishList = new long[9];
        long fishCount=0;
        for(long i : fishList){
            i=0;
        }
        for(String s: input.get(0).split(",")){
            fishList[Integer.parseInt(s)]+=1;
        }
        for(int day=0; day<256; day++){
            long fishZero = fishList[0];
            for(int i =1; i<9;i++){
                fishList[i-1]=fishList[i];
            }
            fishList[8]=fishZero;
            fishList[6]+=fishZero;
        }
        fishCount= Arrays.stream(fishList).sum();
        System.out.println("Result: "+fishCount);
    }
}
