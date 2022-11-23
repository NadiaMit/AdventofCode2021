package days;

import java.util.List;

public class Day0 extends Days{

    public Day0(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        int[] inputArray = super.listToInt(input);
        int result =0;
        int number1=0;
        int number2=0;
        for(int i =0; i<inputArray.length;i++){
            for(int j=1; j<inputArray.length; j++){
                    if ((inputArray[i] + inputArray[j]) == 2020) {
                        result = inputArray[i] * inputArray[j];
                        number1 = inputArray[i];
                        number2 = inputArray[j];
                        break;
                    }

            }
        }
        System.out.println("Number1: " + number1 + " Number2: " + number2 + "\nResult: "+ result);
    }

    @Override
    public void puzzle2() {

        int[] inputArray = super.listToInt(input);
        int result =0;
        int number1=0;
        int number2=0;
        int number3=0;
        for(int i =0; i<inputArray.length;i++){
            for(int j=1; j<inputArray.length; j++){
                for(int z=2; z<inputArray.length;z++) {
                    if ((inputArray[i] + inputArray[j]+ inputArray[z]) == 2020) {
                        result = inputArray[i] * inputArray[j]*inputArray[z];
                        number1 = inputArray[i];
                        number2 = inputArray[j];
                        number3 = inputArray[z];
                        break;
                    }
                }
            }
        }
        System.out.println("Number1: " + number1 + " Number2: " + number2 + " Number3: " + number3 + "\nResult: "+ result);
    }
}
