package days;

import java.util.ArrayList;
import java.util.List;

public class Day9 extends Days {
    public Day9(List<String> input) {
        super(input);
    }
    int[][] heightArray = new int[input.size()][input.get(0).length()];

    private void makeArray(){
        for(int i =0; i<heightArray.length; i++){
            heightArray[i] = super.numberToDigits(input.get(i));
        }
    }


    @Override
    public void puzzle1() {
        int result = 0;
        int point = 0;
        makeArray();
        for(int zeile =0; zeile<heightArray.length; zeile++) {
            for (int spalte = 0; spalte < heightArray[0].length; spalte++) {
                point = heightArray[zeile][spalte];
                if(zeile>0 && point>=heightArray[zeile-1][spalte]){//berechnet UP falls möglich
                    continue;
                }
                if(zeile<(heightArray.length-1) && point>=heightArray[zeile+1][spalte]){//berechnet DOWN falls möglich
                    continue;
                }
                if(spalte>0 && point>=heightArray[zeile][spalte-1]){//berechnet LEFT falls möglich
                    continue;
                }
                if(spalte<(heightArray[0].length-1) && point>=heightArray[zeile][spalte+1]){//berechnet RIGHT falls möglich
                    continue;
                }
                result+=point+1;
            }
        }

        System.out.println("Result: "+result);
    }

    @Override
    public void puzzle2() {
        Integer[] maxBasins = new Integer[3];
        int point = 0;
        List<Integer[]> lowestList = new ArrayList<>();
        List<Integer> basinList = new ArrayList<>();
        makeArray();
        for(int zeile =0; zeile<heightArray.length; zeile++) {
            for (int spalte = 0; spalte < heightArray[0].length; spalte++) {
                point = heightArray[zeile][spalte];
                if(zeile>0 && point>=heightArray[zeile-1][spalte]){
                    continue;
                }
                if(zeile<(heightArray.length-1) && point>=heightArray[zeile+1][spalte]){
                    continue;
                }
                if(spalte>0 && point>=heightArray[zeile][spalte-1]){
                    continue;
                }
                if(spalte<(heightArray[0].length-1) && point>=heightArray[zeile][spalte+1]){
                    continue;
                }
                Integer[] helper={zeile,spalte};
                lowestList.add(helper);
            }
        }
        //lowestList.forEach(x->System.out.println(x[0].toString()+" "+x[1].toString()));

        for(Integer[] i : lowestList){
            basinList.add(basinSearch(i[0],i[1]));
        }

        //basinList.forEach(x->System.out.println(x.toString()));

        for(int i=0; i<3; i++){
            maxBasins[i]=basinList.stream().mapToInt(x->x).max().orElse(0);
            basinList.remove(maxBasins[i]);
        }
        /*for(int zeile =0; zeile<heightArray.length; zeile++) {
            System.out.println("");
            for (int spalte = 0; spalte < heightArray[0].length; spalte++) {
                if(heightArray[zeile][spalte]==9){
                    System.out.print("X");
                }
                else {
                    System.out.print(heightArray[zeile][spalte]);
                }
            }
        }*/
        System.out.println("\n"+maxBasins[0]+" " +maxBasins[1]+" " +maxBasins[2]);
        System.out.println("\nResult: "+(maxBasins[0]*maxBasins[1]*maxBasins[2]));
    }

    private Integer basinSearch(int zeile, int spalte){
        int counter =1;
        heightArray[zeile][spalte]=9;
        try {
            if (zeile > 0 && heightArray[zeile - 1][spalte] != 9) {
                counter += basinSearch(zeile - 1, spalte);
            }
            if (zeile < (heightArray.length - 1) && heightArray[zeile + 1][spalte] != 9) {
                counter += basinSearch(zeile + 1, spalte);
            }
            if (spalte > 0 && heightArray[zeile][spalte - 1] != 9) {
                counter += basinSearch(zeile, spalte - 1);
            }
            if (spalte < (heightArray[0].length - 1) && heightArray[zeile][spalte + 1] != 9) {
                counter += basinSearch(zeile, spalte + 1);
            }
        }catch (StackOverflowError e){
            System.out.println("Error basinSearch: "+zeile+" "+spalte+": "+heightArray[zeile][spalte]+" "+e.getMessage());
            System.exit(1);
        }
        return counter;
    }
}
