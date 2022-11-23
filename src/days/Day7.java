package days;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

public class Day7 extends Days {
    public Day7(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        int[] crabPos = super.stringToInt(input.get(0));
        int minPos = Arrays.stream(crabPos).min().orElse(0);
        int maxPos =Arrays.stream(crabPos).max().orElse(0);
        int minFuel=0;
        int countFuel;
        boolean first =true;
        for(int i=minPos; i<=maxPos;i++){
            countFuel=0;
            for(int crab:crabPos){
                countFuel+=(Math.abs(crab-i));
            }
            if(first){
                minFuel=countFuel;
                first=false;
            }
            else{
                if(minFuel>countFuel){
                    minFuel=countFuel;
                }
            }
        }
        System.out.println("Result: "+minFuel);
    }

    @Override
    public void puzzle2() {
        int[] crabPos = super.stringToInt(input.get(0));
        int minPos = Arrays.stream(crabPos).min().orElse(0);
        int maxPos =Arrays.stream(crabPos).max().orElse(0);
        int minFuel=0;
        int countFuel;
        int n=0;
        double average = (Arrays.stream(crabPos).mapToDouble(x -> x).average().getAsDouble());
        int realAvarage =0;
        boolean first =true;
        for(int i=minPos; i<=maxPos;i++){
            countFuel=0;
            for(int crab:crabPos){
                n=(Math.abs(crab-i));
                countFuel+=((n*(n+1))/2);
            }
            if(first){
                minFuel=countFuel;
                first=false;
                realAvarage=i;
            }
            else{
                if(minFuel>countFuel){
                    minFuel=countFuel;
                    realAvarage=i;
                }
            }
        }
        System.out.println("Result: "+minFuel+" Real Avarage: "+ realAvarage +" calculated Avarage: "+ average);
    }
}
