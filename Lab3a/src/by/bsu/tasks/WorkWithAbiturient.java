package by.bsu.tasks;

import java.util.Scanner;

//Klass dlya rapoty s ob'ektom
public class WorkWithAbiturient {

    //Metod vozvrashyaushiy summu ochenok abiturienta
    public static int getMarksSum(Abiturient abit) {
        int sum = 0;
        for (int mark : abit.getMarks()) {
            sum += mark;
        }
        return sum;
    }

    //Metod vozvrashyaushiy massiv ob'ektov
    public static Abiturient[] getArray(int n) {
        if (n <= 0)
            return null;
        else
            return new Abiturient[n];
    }

    //Metod vvodyashiy massiv ob'ektov
    public static void inputArrayData(Abiturient[] arr) {
        System.out.print("Введите элементы массива:\n\n");
        for (int i = 0; i < arr.length; ++i) {
            System.out.print("Введите " + i + "-ый элемент:\n");
            arr[i] = new Abiturient();
            WorkWithAbiturient.inputAbiturient(arr[i]);
            System.out.print("\n");
        }
    }

    //Metod vvodyashiy ob'ekt
    public static void inputAbiturient(Abiturient abit) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите фамилию: ");
        abit.setSurname(input.nextLine());
        System.out.print("Введите имя: ");
        abit.setName(input.nextLine());
        System.out.print("Введите отчество: ");
        abit.setFathersName(input.nextLine());
        System.out.print("Введите адрес: ");
        abit.setAdress(input.nextLine());
        System.out.print("Введите номер телефона: ");
        abit.setPhoneNumber(input.nextLine());
        System.out.print("Введите " + Abiturient.cntMarks + " оценки: ");
        for (int i = 0; i < Abiturient.cntMarks; ++i)
            abit.setMark(i, input.nextInt());
    }

    //Metod sortiruyshiy massiv ob'ektov
    public static void sortAbiturients(Abiturient[] arr) {
        boolean flag;
        for (int i = 0; i < (arr.length - 1); ++i) {
            flag = false;
            for (int j = 0; j < (arr.length - 1 - i); ++j) {
                if (WorkWithAbiturient.getMarksSum(arr[j]) < WorkWithAbiturient.getMarksSum(arr[j + 1])) {
                    Abiturient tmp = new Abiturient(arr[j]);
                    arr[j] = new Abiturient(arr[j + 1]);
                    arr[j + 1] = new Abiturient(tmp);
                    flag = true;
                }
            }
            if (flag == false)
                break;
        }
    }
}