package CowsAndBulls;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BullsAndCows {
    private int length;
    private int[] genArray;
    private int[] array;
    private boolean winGame = false;

    public BullsAndCows() {
        Scanner isContinue = new Scanner(System.in);
        length = printDifficulty();
        genArray = generateArray(length);
        while (!winGame) {
            array = new int[length];
            array = answerArray();
            if (!isHaveDuplicates()) {
                return;
            }
            int arr[] = calculate();
            if (arr[1] == length) {
                winGame = true;
                System.out.println("Congratulation");
            } else {
                System.out.println("Cows = " + arr[0]);
                System.out.println("Bulls = " + arr[1]);
                System.out.println("Continue? 1. Yes   2. No");
                if (isContinue.nextInt() == 2) {
                    winGame = true;
                    System.out.print("Answer: ");
                    printMas(genArray);
                }
            }

        }
    }

    private int printDifficulty() {
        System.out.println("Введите сложность игры: 3, 4, 5");
        Scanner difficulty = new Scanner(System.in);
        int diff = difficulty.nextInt();
        if (diff < 3 || diff > 5) {
            System.out.println("Некоректная сложность");
            winGame = true;
        }
        return diff;
    }

    private void printMas(int[] genArray) {
        for (int i = 0; i < length; i++) {
            System.out.print(genArray[i] + "   ");
        }
    }

    private int[] answerArray() {
        Scanner num = new Scanner(System.in);
        for (int i = 0; i < length; i++) {
            System.out.println("Введите число");
            array[i] = num.nextInt();
        }
        return array;
    }

    private boolean isHaveDuplicates() {
        int check = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    check++;
                }
                if (check > 1) {
                    System.out.println("Answer have duplicate");
                    return false;
                }
            }
        }
        return true;
    }

    private int[] generateArray(int length) {
        Random num = new Random();
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

    private int[] calculate() {
        int[] arr = new int[2];
        int cow = 0;
        int bull = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < genArray.length; j++) {
                if (array[i] == genArray[j]) {
                    if (i == j) {
                        bull++;
                    } else cow++;
                }
            }
        }
        arr[0] = cow;
        arr[1] = bull;
        return arr;
    }
}
