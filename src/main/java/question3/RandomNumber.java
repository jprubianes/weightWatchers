package question3;

import java.util.*;

public class RandomNumber {

    public static void main(String[] args) {

        List<Integer> numbersList = new ArrayList<Integer>();
        Random rand = new Random();
        for(int i = 0; i < 500; i++){
            Integer  n = rand.nextInt(100000) + 1;
            numbersList.add(n);
        }

        Collections.sort(numbersList);
        System.out.println("smallest number " + numbersList.get(0));
        System.out.println("largest number " + numbersList.get(499));
    }

}
