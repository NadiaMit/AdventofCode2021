package days;

import java.util.Arrays;
import java.util.List;

public class Day8 extends Days {
    public Day8(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        String[] inputParts = new String[input.size()];
        String[] outputs = new String[4];
        int counter =0;
        for(int i =0; i< input.size(); i++){
            inputParts[i]=input.get(i).substring(input.get(i).indexOf('|')+2);
        }
        for(String inputs: inputParts){
            outputs= inputs.split(" ");
            for(String s:outputs){
                if(s.length()==2||s.length()==4||s.length()==3||s.length()==7){
                    counter++;
                }
            }
        }
        System.out.println("Result: "+ counter);
    }

    @Override
    public void puzzle2() {
        String[] keys;
        String[] output;
        String[] numbers = new String[10];
        int result=0;
        try {
            for (String inputLine : input) {
                keys = inputLine.substring(0, inputLine.indexOf('|') - 1).split(" ");
                output = inputLine.substring(inputLine.indexOf('|') + 2).split(" ");
                numbers[1] = Arrays.stream(keys).filter(x->x.length()==2).findAny().orElse("");
                numbers[4] = Arrays.stream(keys).filter(x->x.length()==4).findAny().orElse("");
                numbers[7] = Arrays.stream(keys).filter(x->x.length()==3).findAny().orElse("");
                numbers[8] = Arrays.stream(keys).filter(x->x.length()==7).findAny().orElse("");

                String helper = getDiff(numbers[4],numbers[1]);
                for (String key : keys) {
                    if(key.length()==5){
                        if(keyInNumber(numbers[1], key)){
                            numbers[3]=key;
                            //System.out.println("3 "+ numbers[3]+" "+key+" " + helper);
                        }
                        else if(keyInNumber(helper,key)){
                            numbers[5]=key;
                            //System.out.println("5 "+ numbers[5]+" "+key+" " + helper);
                        }
                        else{
                            numbers[2]=key;
                            //System.out.println("2 "+ numbers[2]+" "+key+" " + helper);
                        }
                    }
                    if(key.length()==6){
                        if(keyInNumber(numbers[4],key)){
                            numbers[9]=key;
                            //System.out.println("9 "+ numbers[9]+" "+key+" " + helper);
                        }
                        else if(keyInNumber(helper,key)){
                            numbers[6]=key;
                            //System.out.println("6 "+numbers[6]+" "+key+" " + helper);
                        }
                        else{
                            numbers[0]=key;
                            //System.out.println("0 "+ numbers[0]+" "+key+" " + helper);
                        }
                    }
                }

                String resultString="";
                for(String out:output){
                    for(int i = 0; i< numbers.length;i++){
                        //System.out.println(out+" "+i);
                        if(keyInNumber(out,numbers[i])&&keyInNumber(numbers[i],out)){
                            resultString+=i;
                            break;
                        }
                    }
                }
                result+=Integer.parseInt(resultString);
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }


        System.out.println("Result: "+result);
    }

    private boolean keyInNumber(String key, String number){
        //System.out.println("key: " +key+" number: "+number);
        int counter = 0;
        for(char k:key.toCharArray()){
            for(char n:number.toCharArray()){
                if(n==k){
                    counter++;
                }
            }
        }
        return counter==key.length()? true:false;
    }

    private String getDiff(String four, String one){
        char[] oneArray = one.toCharArray();
        String returnString="";
        for(char f: four.toCharArray()){
            if(f!=oneArray[0]&&f!=oneArray[1]){
                returnString+=f;
            }
        }

        return returnString;
    }
}