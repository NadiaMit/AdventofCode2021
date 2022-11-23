package days;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Day3 extends Days {
    private List<String>input2;
    public Day3(List<String> input1, List<String> input2) {
        super(input1);
        this.input2=input2;
    }
    private char[] charArray = new char[input.get(1).length()];

    @Override
    public void puzzle1() {
        String gamma ="";
        String epsilon="";
        int[][] coutner = new int[charArray.length][2];
        for(int j =0; j< charArray.length; j++){
            coutner[j][0]=0;
            coutner[j][1]=0;
            for(String s: input){
                charArray=s.toCharArray();
                switch (charArray[j]){
                    case '0' -> coutner[j][0]++;
                    case '1' -> coutner[j][1]++;
                    default -> throw new IllegalArgumentException("wrong bit");
                }
            }
            if(coutner[j][0]>coutner[j][1]){
                gamma+="0";
                epsilon+="1";
            }
            else if(coutner[j][1]>coutner[j][0]){
                gamma+="1";
                epsilon+="0";
            }
            else{
                throw new IllegalArgumentException("counts equal");
            }
        }
        try{
            System.out.println("Gamma: " + gamma + " Epsilon: " +epsilon + " Result: " +Integer.parseInt(gamma,2)*Integer.parseInt(epsilon,2));
        }catch (Exception e){
            System.out.println("Error at creating result: " + e.getMessage());
        }
    }

    @Override
    public void puzzle2() {
        int xzeroCount, xoneCount;
        int yzeroCount, yoneCount;
        int result=0;
        List<String> oxygen = new ArrayList<>();
        oxygen=input;
        List<String> co2 = new ArrayList<>();
        co2=input2;
        for(int j =0; j< charArray.length; j++) {
            xzeroCount = 0;
            xoneCount = 0;
            yzeroCount = 0;
            yoneCount = 0;
            for (String s : oxygen) {//go through oxygen values
                charArray = s.toCharArray();
                switch (charArray[j]) {
                    case '0' -> xzeroCount++;
                    case '1' -> xoneCount++;
                    default -> throw new IllegalArgumentException("wrong bit");
                }
            }
            for (String s : co2) {//go through co2 values
                charArray = s.toCharArray();
                switch (charArray[j]) {
                    case '0' -> yzeroCount++;
                    case '1' -> yoneCount++;
                    default -> throw new IllegalArgumentException("wrong bit");
                }
            }
            if(oxygen.size()>1){
                Iterator<String> itox = oxygen.iterator();
                while (itox.hasNext()) {
                    charArray = itox.next().toCharArray();
                    if (xzeroCount > xoneCount) {
                        if (charArray[j] == '1') {
                            itox.remove();
                        }
                    } else if (xoneCount > xzeroCount) {
                        if (charArray[j] == '0') {
                            itox.remove();
                        }
                    } else if (xzeroCount == xoneCount) {
                        if (charArray[j] == '0') {
                            itox.remove();
                        }
                    } else {
                        throw new IllegalArgumentException("counts error");
                    }
                }
            }
            if(co2.size()>1){
                Iterator<String> itco = co2.iterator();
                while (itco.hasNext()) {
                    charArray = itco.next().toCharArray();
                    if (yzeroCount > yoneCount) {
                        if (charArray[j] == '0') {
                            itco.remove();
                        }
                    } else if (yoneCount > yzeroCount) {
                        if (charArray[j] == '1') {
                            itco.remove();
                        }
                    } else if (yzeroCount == yoneCount) {
                        if (charArray[j] == '1') {
                            itco.remove();
                        }
                    } else {
                        throw new IllegalArgumentException("counts error");
                    }
                }
            }
        }
        try{
           result=Integer.parseInt(oxygen.get(0),2)*Integer.parseInt(co2.get(0),2);
        }catch (Exception e){
            System.out.println("Error at creating result: " + e.getMessage());
        }

        System.out.println("Oxygen: " + oxygen + " CO2: " +co2 + " Resul: " +result);
    }
}
