package CowsAndBulls;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final Random num = new Random();
    private static int[] array;
    private static final Scanner isA = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Введите сложность игры: 3, 4, 5");
        Scanner difficulty = new Scanner(System.in);
        int diff = difficulty.nextInt();
        if (diff < 3 || diff > 5) {
            System.out.println("Некоректная сложность");
            return;
        }
        array = generateArray(diff);
        boolean gameResult;
        do {
            gameResult = game();
        }
        while (gameResult);
    }

    private static boolean game() {
        BullsAndCows difficult = new BullsAndCows(array);
        if (!difficult.isHaveDuplicates()){
            return false;
        }
        difficult.calculate();
        if (difficult.winGame || isA.nextInt() == 2) {
            System.out.print("Answer: ");
            printArray(array);
            return false;
        }
        return true;
    }

    private static void printArray(int[] array) {
        for (int j : array) {
            System.out.print(j + "; ");
        }
    }

    private static int[] generateArray(int length) {
        int[] genArr = new int[length];
        int uniqCount = 0;
        while (uniqCount != genArr.length) {
            genArr[uniqCount] = num.nextInt(10);
            boolean isUniq = true;
            for (int i = 0; i < uniqCount; i++) {
                if (genArr[uniqCount] == genArr[i]) {
                    isUniq = false;
                    break;
                }
            }
            if (isUniq) {
                uniqCount++;
            }
        }
        return genArr;
    }
}
