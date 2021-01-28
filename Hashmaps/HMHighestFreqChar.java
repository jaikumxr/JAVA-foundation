import java.io.*;
import java.util.*;

//Program to print the character with the highest frequency in a String, using Hashmaps

public class HMHighestFreqChar {

//take one, accepted

    public static Character hfc(String str) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if(h1.containsKey(ch)){
                h1.put(ch, h1.get(ch)+1);
            } else {
                h1.put(ch, 1);
            }
        }
        Character maxc = null;
        int max  = Integer.MIN_VALUE;
        for (Character c : h1.keySet()) {
            if(h1.get(c)>max){
                max = h1.get(c);
                maxc = c;
            }
        }
        return maxc;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        System.out.println(hfc(s));
    }

}
