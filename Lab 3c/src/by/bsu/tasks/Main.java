package by.bsu.tasks;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //create object type of Scanner
        Scanner in = new Scanner(System.in);
        //create SymbolSet1
        SymbolSet set1 = new SymbolSet();
        //fill SymbolSet1
        set1.Insert('1');
        set1.Insert('2');
        set1.Insert('3');
        set1.Insert('4');
        //create SymbolSet2
        SymbolSet set2 = new SymbolSet();
        //fill SymbolSet2
        set2.Insert('1');
        set2.Insert('2');
        set2.Insert('5');
        set2.Insert('6');
        set2.Insert('7');
        System.out.println("Проверяем содержится ли символ в множестве");
        System.out.println("Введите любой символ:");
        //vvodim lyboy simvol i proveryaem soderjitsa li on v nashem mnojestve
        Character ch1 = in.next().charAt(0);
        if (ControllerSymbolSet.Contains(set1,ch1))
        {
            System.out.println("Этот элемент содержится в множестве!");
        }
        else
        {
            System.out.println("Этот элемент не содержится в множестве!");
        }
        System.out.println("Объединение:");
        //ob'edin'aem nashi mnojestva i vyvodim
        for (var ch : ControllerSymbolSet.Union(set1,set2).getHashSet()) {
            System.out.println(ch);
        }
        System.out.println("Пересечение:");
        //peresekaem nashi mnojestva i vyvodim
        for (var ch : ControllerSymbolSet.Intersect(set1,set2).getHashSet()) {
            System.out.println(ch);
        }
        System.out.println("Разность:");
        //nahodim raznost mejdu nashimi mnojestvami i vyvodim
        for (var ch : ControllerSymbolSet.Difference(set1,set2).getHashSet()) {
            System.out.println(ch);
        }
        //sozdaem massiv mnojestv
        ArrayList<SymbolSet> lst = new ArrayList<>();
        System.out.println("Введите количество множеств в массиве:");
        //vvodim ego razmer
        int size = in.nextInt();
        for (int i = 0; i < size; i++)
        {
            lst.add(new SymbolSet());
            System.out.println("Введите количество элементов в " + (i+1) + " множестве:");
            //vvodim razmer odnogo mnojestva
            int n = in.nextInt();
            for (int j = 0; j < n; j++)
            {
                System.out.println("Введите " + (j+1) + " элемент:");
                //vvodim element mnojestva
                Character el = in.next().charAt(0);
                lst.get(i).Insert(el);
            }
        }
        //vyvodim simmetrichesku'u raznost (i) i (i+1) mnojestva
        for (int i = 0; i < size - 1; i++)
        {
            System.out.println("Симметрическая разность " + (i+1) + " и " + (i+2) + " множеств:");
            for (var ch : ControllerSymbolSet.SymmetricDifference(lst.get(i), lst.get(i+1)).getHashSet()) {
                System.out.println(ch);
            }
        }
    }
}
