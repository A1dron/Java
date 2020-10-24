package CowsAndBulls;

import java.util.Arrays;
import java.util.Scanner;

public class BullsAndCows {
    public int[] array;
    private final int[] genArray;
    public boolean winGame;
    private final Scanner num = new Scanner(System.in);


    public BullsAndCows(int[] genArr) {

        array = new int[genArr.length];
        genArray = genArr;
        array = answerArray();
    }

    public void calculate() {
        int cow = 0;
        int bull = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < genArray.length; j++) {
                if (array[i] == genArray[j] && i == j) {
                    bull++;
                    cow++;
                } else if (array[i] == genArray[j]) {
                    cow++;
                }
            }
        }
        if (bull == array.length) {
            System.out.println("Congratulation");
            winGame = true;
            return;
        } else {
            System.out.println("Bulls: " + bull);
            System.out.println("Cows: " + cow);
            System.out.println("Are you want continue?");
            System.out.println("1. Yes           2. No");
        }
        winGame = false;
    }

    private int[] answerArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Введите число");
            array[i] =num.nextInt();
        }
        return array;
    }

    public boolean isHaveDuplicates(){
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if(array[i]==array[j]){
                    check++;
                }
                if (check>1){
                    System.out.println("Answer have duplicate");
                    return false;
                }
            }
        }
        return true;
    }


}
