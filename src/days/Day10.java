package days;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Day10 extends Days {
    public Day10(List<String> input) {
        super(input);
    }

    @Override
    public void puzzle1() {
        boolean skip;
        int result=0;
        try{
            for(String s:input){
                Stack stack = new Stack();
                for(char c: s.toCharArray()){
                    skip=false;
                    switch (c){
                        case '(': stack.push(')'); break;
                        case '[': stack.push(']'); break;
                        case '{': stack.push('}'); break;
                        case '<': stack.push('>'); break;
                        case ')': {
                            if((!stack.empty())&&(stack.peek().equals(')'))){
                            stack.pop();
                            }
                            else{
                                skip=true;
                                result+=3;
                            }
                        } break;
                        case ']': {
                            if((!stack.empty())&&(stack.peek().equals(']'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                                result+=57;
                            }
                        } break;
                        case '}': {
                            if((!stack.empty())&&(stack.peek().equals('}'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                                result+=1197;
                            }
                        } break;
                        case '>': {
                            if((!stack.empty())&&(stack.peek().equals('>'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                                result+=25137;
                            }
                        } break;
                        default: throw new IllegalArgumentException("Not existent char");
                    }
                    if(skip) break;
                }
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        System.out.println("Result: "+result);
    }

    @Override
    public void puzzle2() {
        boolean skip =false;
        List<Long> resultList = new ArrayList<>();
        long result;
        try{
            for(String s:input){
                result=0;
                Stack stack = new Stack();
                List<Character> incompleteList = new ArrayList<>();
                for(char c: s.toCharArray()){
                    skip=false;
                    switch (c){
                        case '(': stack.push(')'); break;
                        case '[': stack.push(']'); break;
                        case '{': stack.push('}'); break;
                        case '<': stack.push('>'); break;
                        case ')': {
                            if((!stack.empty())&&(stack.peek().equals(')'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                            }
                        } break;
                        case ']': {
                            if((!stack.empty())&&(stack.peek().equals(']'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                            }
                        } break;
                        case '}': {
                            if((!stack.empty())&&(stack.peek().equals('}'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                            }
                        } break;
                        case '>': {
                            if((!stack.empty())&&(stack.peek().equals('>'))){
                                stack.pop();
                            }
                            else{
                                skip=true;
                            }
                        } break;
                        default: throw new IllegalArgumentException("Not existent char");
                    }
                    if(skip) break;
                }
                if(!skip){
                    incompleteList = stack.stream().toList();
                    for(int i = (incompleteList.size()-1); i>=0;i--){
                        result*=5;
                        switch (incompleteList.get(i)){
                            case ')': result+=1; break;
                            case ']': result+=2; break;
                            case '}': result+=3; break;
                            case '>': result+=4; break;
                        }
                    }
                    resultList.add(result);
                }
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        Collections.sort(resultList);
        System.out.println("Result: "+(resultList.get((resultList.size()-1)/2)));
    }
}
