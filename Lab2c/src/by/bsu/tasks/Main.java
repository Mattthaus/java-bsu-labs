package by.bsu.tasks;

import java.util.Scanner;

public class Main {

    //Metod schitaushiy summu elementov v stroke matrichy
    public static int calcLineSum(int[] line) {
        int result = 0;
        for (int val : line) {
            result += val;
        }
        return result;
    }

    public static void main(String[] args) {
        //Sozdem ob'ekt classa Scanner dlya vvoda s consoli
        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of matrix: ");
        int n = input.nextInt();
        int[][] arr = new int[n][n];
        System.out.print("This is your matrix:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //Zapolnyaem matrichu randomnymi znacheniyami iz [-n; n]
                arr[i][j] = (int) ((Math.random() * (2 * n + 1)) - n);
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }

        //Sortirovka strok matrichy metodom puzyr'ka
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (calcLineSum(arr[j]) > calcLineSum(arr[j + 1])) {
                    int[] buffLine = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = buffLine;
                }
            }
        }
        System.out.print("This is a sorted matrix:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.print("\n");
        }
    }
}