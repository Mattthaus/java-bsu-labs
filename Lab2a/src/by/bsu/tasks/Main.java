package by.bsu.tasks;

import java.util.Scanner;

/**
 * Task received: 15.02.2020 12.00
 * Task completed: 22.02.2020 12.00
 * @author Danilevich Matvei
 * @version 1.0
 */
public class Main {

    /**
     * Method checking if the number is a palindrome
     * @param String    the String object with number
     * @return boolean  is String is Palindrome or not
     */
    public static boolean isPalindrome(final String number) {
        for (int i = 0; i < (number.length() / 2); ++i) {
            if (number.charAt(i) != number.charAt(number.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int n;
        Scanner input = new Scanner(System.in);
        do {
            System.out.print("Введите размер массива: ");
            n = input.nextInt();
            if (n <= 0) {
                System.out.print("Ошибка! Некорректные данные\n");
                continue;
            }
            break;
        } while (true);
        String[] numbers = new String[n];
        System.out.print("\nВведите массив чисел: ");
        for (int i = 0; i < n; ++i) {
            numbers[i] = input.next();
        }
        String first = "", second = "";
        for (String number : numbers) {
            if (isPalindrome(number)) {
                if (first.equals("")) {
                    first = number;
                } else {
                    second = number;
                    break;
                }
            }
        }
        if (!first.equals("")) {
            System.out.print("Первое число-палиндром: " + first + "\n");
            if (!second.equals("")) {
                System.out.print("Второе число-палиндром: " + second + "\n");
            }
        } else {
            System.out.print("Нет число-палиндромов\n");
        }
    }
}
