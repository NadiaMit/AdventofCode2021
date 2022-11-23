package days;

import java.util.List;

public class Day2 extends Days{

    public Day2(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        int horizontal =0;
        int depth =0;

        for (String s: input){
            String[] split = s.split(" ");
            switch (split[0]){
                case "forward" : horizontal+= Integer.parseInt(split[1]); break;
                case "down" : depth+= Integer.parseInt(split[1]); break;
                case "up" : depth-= Integer.parseInt(split[1]); break;
                default: throw new IllegalArgumentException("case not found");
            }
        }
        System.out.println("Day 2, Puzzle 1: " + (horizontal*depth));
    }

    @Override
    public void puzzle2() {
        int horizontal =0;
        int depth =0;
        int aim =0;

        for (String s: input){
            String[] split = s.split(" ");
            switch (split[0]){
                case "forward": horizontal += Integer.parseInt(split[1]); depth+=aim*Integer.parseInt(split[1]); break;
                case "down" : aim+= Integer.parseInt(split[1]); break;
                case "up" : aim-= Integer.parseInt(split[1]); break;
                default: throw new IllegalArgumentException("case not found");
            }
        }

        System.out.println("Day 2, Puzzle 2: " + (horizontal*depth)+"\n Horizontal: " + horizontal + " Depth: "+ depth);
    }
}
