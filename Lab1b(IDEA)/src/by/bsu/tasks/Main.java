package by.bsu.tasks;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); //create a scanner class object
        System.out.println("Enter size of array:");
        int n = in.nextInt();
        int[] arr = new int[n];
        int num = -1;
        System.out.println("Enter elements of array:");
        for (int k = 0; k < n; k++) {
            arr[k] = in.nextInt();
            if (arr[k] > 0 && num == -1) {
                num = arr[k];
            }
        }
        int[][] mtrx = new int[num + 1][num + 1];//create a matrix for storing a triangle
        for (int i = 0; i <= num; i++) {
            mtrx[i][0] = mtrx[i][i] = 1; //extreme elements are initialized to units
            for (int j = 1; j < i; j++) {
                mtrx[i][j] = mtrx[i - 1][j - 1] + mtrx[i - 1][j]; //fill the triangle
            }
        }
        for (int i = 0; i <= num; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(mtrx[i][j] + " ");  //draw a triangle
            }
            System.out.println("\n");
        }
    }
}