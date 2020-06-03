package by.bsu.tasks;

import java.util.Scanner;

public class Main {

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
        System.out.print("\n");
        Abiturient[] arr = WorkWithAbiturient.getArray(n);
        WorkWithAbiturient.inputArrayData(arr);
        int k;
        do {
            System.out.print("0 - Выход\n1 - Вывести список абитуриентов, имеющих неудовлетворительные оценки\n2 - Вывести список абитуриентов, у которых сумма баллов выше заданной\n3 - Выбрать заданное число n абитуриентов, имеющих самую высокую сумму баллов (вывести также полный список абитуриентов, имеющих полупроходную сумму)\n4 - Вывести всех абитуриентов\n");
            System.out.print("Ваш выбор: ");
            k = input.nextInt();
            if ((k < 0) || (k > 4)) {
                System.out.print("Ошибка! Некорректные данные\n");
                continue;
            }
            System.out.print("\n");
            switch (k) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    int mark;
                    System.out.print("Введите неудовлетворительную оценку: ");
                    mark = input.nextInt();
                    for (Abiturient abit : arr) {
                        for (int m : abit.getMarks()) {
                            if (m <= mark) {
                                System.out.print(abit + "\n");
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    int sum;
                    System.out.print("Введите сумму баллов: ");
                    sum = input.nextInt();
                    for (Abiturient abit : arr) {
                        if (WorkWithAbiturient.getMarksSum(abit) > sum)
                            System.out.print(abit + "\n");
                    }
                    break;
                case 3:
                    int m;
                    boolean flag = false;
                    do {
                        System.out.print("Введите количество абитуриентов: ");
                        m = input.nextInt();
                        if ((m <= 0) || (m > n)) {
                            System.out.print("Ошибка! Некорректные данные\n");
                            continue;
                        }
                        break;
                    } while (true);
                    WorkWithAbiturient.sortAbiturients(arr);
                    System.out.print("Проходные баллы:\n");
                    while ((m > 0) && (m < n) && (WorkWithAbiturient.getMarksSum(arr[m - 1]) == WorkWithAbiturient.getMarksSum(arr[m]))) {
                        --m;
                        flag = true;
                    }
                    for (int i = 0; i < m; ++i) {
                        System.out.print(arr[i] + "\n");
                    }
                    System.out.print("\nПолупроходные  баллы:\n");
                    if (flag) {
                        System.out.println(arr[m] + "\n");
                        for (int i = m + 1; i < n; ++i) {
                            if (WorkWithAbiturient.getMarksSum(arr[i]) == WorkWithAbiturient.getMarksSum(arr[m]))
                                System.out.print(arr[i] + "\n");
                            else
                                break;
                        }
                    }
                    break;
                case 4:
                    for (Abiturient abit : arr) {
                        System.out.print(abit + "\n");
                    }
            }
            System.out.print("\n");
        } while (true);
    }
}