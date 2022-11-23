package days;

import java.util.Arrays;
import java.util.List;

public class Day5 extends Days {
    public Day5(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        int size=1000;
        int[][] points = new int[size][size];
        int X1 =0;
        int Y1=0;
        int X2 =0;
        int Y2=0;
        int result =0;

        for(int row=0; row<size;row++){
            for(int column=0; column<size; column++){
                points[row][column]=0;
            }
        }
        //System.out.println("");
        for(String s : input){
            String[] splitinput = s.split(" -> ");
            String[] firstPoints = splitinput[0].split(",");
            String[] secondPoints = splitinput[1].split(",");
            X1 = Integer.parseInt(firstPoints[0]);
            Y1 = Integer.parseInt(firstPoints[1]);
            X2 = Integer.parseInt(secondPoints[0]);
            Y2 = Integer.parseInt(secondPoints[1]);
            //System.out.print(X1+","+Y1+" -> "+X2+","+Y2);
            if(X1==X2&&Y1==Y2){
                //System.out.print("true X=Y");
                points[Y1][X1]++;
            }
            else{
                if(X1==X2){
                    //System.out.print(" true X ");
                    if(Y1<Y2) {
                        for (int i = Y1; i <= Y2; i++) {
                            points[i][X1]++;
                            //System.out.print(" " + i);
                        }
                    }
                    else if(Y1>Y2){
                        for (int i = Y2; i <= Y1; i++) {
                            points[i][X1]++;
                            //System.out.print(" " + i);
                        }
                    }
                }
                else if(Y1==Y2) {
                    //System.out.print(" true Y ");
                    if(X1<X2){
                        for (int i = X1; i <= X2; i++) {
                            points[Y1][i]++;
                            //System.out.print(" " + i);
                        }
                    }
                    else if(X1>X2){
                        for (int i = X2; i <= X1; i++) {
                            points[Y1][i]++;
                            //System.out.print(" " + i);
                        }
                    }
                }
            }
            //System.out.print("\n");
        }
        //System.out.println("");
        for(int zeile =0; zeile<size;zeile++){
            //System.out.print("Row "+zeile+": ");
            for(int spalte=0; spalte<size; spalte++){
                if(points[zeile][spalte]>1){
                    result++;
                }
                /*if(points[zeile][spalte]==0){
                    System.out.print(".");
                }
                else {
                    System.out.print(points[zeile][spalte]);
                }*/
            }
            //System.out.println("");
        }
        System.out.println("Result: "+ result);
    }

    @Override
    public void puzzle2() {

        int size=1000;
        int[][] points = new int[size][size];
        int X1 =0;
        int Y1=0;
        int X2 =0;
        int Y2=0;
        int result =0;

        for(int row=0; row<size;row++){
            for(int column=0; column<size; column++){
                points[row][column]=0;
            }
        }
        //System.out.println("");
        for(String s : input){
            String[] splitinput = s.split(" -> ");
            String[] firstPoints = splitinput[0].split(",");
            String[] secondPoints = splitinput[1].split(",");
            X1 = Integer.parseInt(firstPoints[0]);
            Y1 = Integer.parseInt(firstPoints[1]);
            X2 = Integer.parseInt(secondPoints[0]);
            Y2 = Integer.parseInt(secondPoints[1]);
            //System.out.print(X1+","+Y1+" -> "+X2+","+Y2);
            if(Math.abs(X1-X2)==Math.abs(Y1-Y2)){
                //System.out.print("true X=Y");
                //DIAGONAL-------------------------------------------------------------
                if(X1<X2) {
                    if(Y1>Y2){
                        for (int i = X1, j =Y1; i<=X2&&j>=Y2;i++,j--){
                            points[j][i]++;
                        }
                    }
                    else{
                        for (int i = X1, j =Y1; i<=X2&&j<=Y2;i++,j++){
                            points[j][i]++;
                        }
                    }
                }
                else if(X1>X2){
                    if(Y1<Y2){
                        for (int i = X1, j =Y1; i>=X2&&j<=Y2;i--,j++){
                            points[j][i]++;
                        }
                    }
                    else {
                        for (int i = X2, j = Y2; i <= X1 && j <= Y1; i++, j++) {
                            points[j][i]++;
                        }
                    }
                }
            }
            // WAAGRECHT UND SENKRECHT-----------------------------------------------------------------
            else{
                if(X1==X2){
                    //System.out.print(" true X ");
                    if(Y1<Y2) {
                        for (int i = Y1; i <= Y2; i++) {
                            points[i][X1]++;
                            //System.out.print(" " + i);
                        }
                    }
                    else if(Y1>Y2){
                        for (int i = Y2; i <= Y1; i++) {
                            points[i][X1]++;
                            //System.out.print(" " + i);
                        }
                    }
                }
                else if(Y1==Y2) {
                    //System.out.print(" true Y ");
                    if(X1<X2){
                        for (int i = X1; i <= X2; i++) {
                            points[Y1][i]++;
                            //System.out.print(" " + i);
                        }
                    }
                    else if(X1>X2){
                        for (int i = X2; i <= X1; i++) {
                            points[Y1][i]++;
                            //System.out.print(" " + i);
                        }
                    }
                }
            }
            //System.out.print("\n");
        }
        //System.out.println("\n       0123456789");
        for(int zeile =0; zeile<size;zeile++){
            //System.out.print("Row "+zeile+": ");
            for(int spalte=0; spalte<size; spalte++){
                if(points[zeile][spalte]>1){
                    result++;
                }
                /*if(points[zeile][spalte]==0){
                    System.out.print(".");
                }
                else {
                    System.out.print(points[zeile][spalte]);
                }*/
            }
            //System.out.println("");
        }
        System.out.println("Result: "+ result);
    }
}
