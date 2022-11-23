import days.*;

public class Main {
    public static void main(String[] args){
        Reader reader = new Reader("C:\\Users\\Nadia\\Documents\\AdventofCode2021\\Inputs\\");//new reader with path of directory
        Days day = new Day11(reader.readInput("test.txt"));//new day using input from reader
        System.out.print("Puzzle 1: ");
        day.puzzle1();
        System.out.print("Puzzle 2: ");
        day.puzzle2();
    }
}
