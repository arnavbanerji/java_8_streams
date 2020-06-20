package CodingInterviews;

import java.util.*;
import java.util.stream.Collectors;

public class Operative {

    public static void main(String[] args) {
        String S = "BALLOONXCVF";
        if (S.length() < 7) {
            System.out.println("ok");
        } else {
            int moves = 0;
            List<Character> balloon = new ArrayList<Character>() {
                {
                    add('B');
                    add('A');
                    add('L');
                    add('L');
                    add('O');
                    add('O');
                    add('N');
                }
            };

            while (true) {
                List<Character> tempBalloon = new ArrayList(balloon);
                for(int i=0 ; i<S.length() ; i++) {
                    if(tempBalloon.contains(S.charAt(i))) {
                        tempBalloon.remove(new Character(S.charAt(i)));
                    }
                }

                if (tempBalloon.isEmpty()) {
                    moves++;
                    continue;
                } else {
                    break;
                }
            }
            System.out.println("moves: "+moves);
        }

    }
}
