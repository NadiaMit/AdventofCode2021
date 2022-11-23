package days;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day4 extends Days {
    public Day4(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        int[] numbers = super.stringToInt(input.get(0));
        int size = (int) input.stream().filter(s -> s.equals("")).count();
        Integer[][][] bingoset = new Integer[size][6][6];
        String[] stringArray;
        int winner = 0;
        int summe = 0;
        int lastNumber = 0;
        int lineCounter = 2;
        boolean numbersBool =false;
        boolean setBools = false;
        boolean zeileBools = false;
        for (int set = 0; set < size; set++) {
            for (int zeile = 0; zeile < 5; zeile++) {
                if (input.get(lineCounter).isEmpty()) {
                    lineCounter++;
                }
                for (int spalte = 0; spalte < 5; spalte++) {
                    stringArray = input.get(lineCounter).trim().replaceAll("\s{2,}", " ").split(" ");
                    try {
                        bingoset[set][zeile][spalte] = Integer.valueOf(stringArray[spalte]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + stringArray[spalte] + " " + e.getMessage());
                    }
                }
                lineCounter++;
                bingoset[set][zeile][5] = 0;
            }
            for (int i = 0; i < 6; i++) {
                bingoset[set][5][i] = 0;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int set = 0; set < size; set++) {
                for (int zeile = 0; zeile < 5; zeile++) {
                    for (int spalte = 0; spalte < 5; spalte++) {
                        if (bingoset[set][zeile][spalte] != null && bingoset[set][zeile][spalte] == numbers[i]) {
                            bingoset[set][zeile][spalte] = null;
                            bingoset[set][zeile][5]++;
                            bingoset[set][5][spalte]++;
                            if (bingoset[set][zeile][5] == 5 || bingoset[set][5][spalte] == 5) {
                                winner = set;
                                lastNumber = numbers[i];
                                numbersBool=true;
                                setBools = true;
                                zeileBools=true;
                                break;
                            }
                        }
                    }
                    if(zeileBools) break;
                }
                if(setBools) break;
            }
            if(numbersBool) break;
        }


        for (int zeile = 0; zeile < 5; zeile++) {
            for (int spalte = 0; spalte < 5; spalte++) {
                if (!(bingoset[winner][zeile][spalte] == null)) {
                    summe += bingoset[winner][zeile][spalte];
                }
            }
        }

        System.out.println("Result: " + summe * lastNumber + " summe: " + summe + " last lastNumber: " + lastNumber);
    }

    @Override
    public void puzzle2 () {
        int[] numbers = super.stringToInt(input.get(0));
        int size = (int) input.stream().filter(s -> s.equals("")).count();
        Integer[][][] bingoset = new Integer[size][6][6];
        String[] stringArray;
        int winner = 0;
        int summe = 0;
        int lastNumber = 0;
        int lineCounter = 2;
        boolean numbersBool =false;
        boolean setBools = false;
        boolean zeileBools = false;
        Map<Integer,Boolean> winnerMap = new HashMap<>();
        for (int set = 0; set < size; set++) {
            for (int zeile = 0; zeile < 5; zeile++) {
                if (input.get(lineCounter).isEmpty()) {
                    lineCounter++;
                }
                for (int spalte = 0; spalte < 5; spalte++) {
                    stringArray = input.get(lineCounter).trim().replaceAll("\s{2,}", " ").split(" ");
                    try {
                        bingoset[set][zeile][spalte] = Integer.valueOf(stringArray[spalte]);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: " + stringArray[spalte] + " " + e.getMessage());
                    }
                }
                lineCounter++;
                bingoset[set][zeile][5] = 0;
            }
            for (int i = 0; i < 6; i++) {
                bingoset[set][5][i] = 0;
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            for (int set = 0; set < size; set++) {
                for (int zeile = 0; zeile < 5; zeile++) {
                    for (int spalte = 0; spalte < 5; spalte++) {
                        if (bingoset[set][zeile][spalte] != null && bingoset[set][zeile][spalte] == numbers[i]) {
                            //System.out.println(bingoset[set][zeile][spalte]);
                            bingoset[set][zeile][spalte] = null;
                            bingoset[set][zeile][5]++;
                            bingoset[set][5][spalte]++;
                            if (bingoset[set][zeile][5] == 5 || bingoset[set][5][spalte] == 5) {
                                winner = set;
                                lastNumber = numbers[i];
                                if(winnerMap.get(set)==null) {
                                    winnerMap.put(set, true);
                                }
                                System.out.println("winner: " + winner + " lastNumber: " + lastNumber);
                                if(winnerMap.size()== bingoset.length) {
                                    numbersBool = true;
                                    setBools = true;
                                    zeileBools = true;
                                    break;
                                }
                            }
                        }
                    }
                    if(zeileBools) break;
                }
                if(setBools) break;
            }
            if(numbersBool) break;
        }


        for (int zeile = 0; zeile < 5; zeile++) {
            for (int spalte = 0; spalte < 5; spalte++) {
                if (!(bingoset[winner][zeile][spalte] == null)) {
                    summe += bingoset[winner][zeile][spalte];
                }
            }
        }

        System.out.println("Result: " + summe * lastNumber + " summe: " + summe + " last lastNumber: " + lastNumber);
    }
}
