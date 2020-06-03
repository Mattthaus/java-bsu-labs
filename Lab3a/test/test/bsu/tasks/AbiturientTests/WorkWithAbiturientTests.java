package test.bsu.tasks.AbiturientTests;

import by.bsu.tasks.Abiturient;
import by.bsu.tasks.WorkWithAbiturient;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class WorkWithAbiturientTests {

    //Metod dlya testirovaniya funkchyi getMarksSum
    @Test
    public void getMarksSumTest() {
        //Sozdaem pustogo abiturienta
        Abiturient abiturient = new Abiturient();
        //Zapolnyaem ego ochenki
        abiturient.setMarks(new int[] {1, 2, 3, 4, 5});
        //Vyzyvaem funkchyu getMarksSum
        int actual = WorkWithAbiturient.getMarksSum(abiturient);
        //Proveryaem sovpodaut li znacheniya
        Assert.assertEquals(actual, 15);
    }

    //Metod dlya testirovaniya funkchyi sortAbiturients
    @Test
    public void sortAbiturientsTest() {
        //Sozdaem massiv abiturientov i zadaem im ochenki
        Abiturient[] actual = WorkWithAbiturient.getArray(3);
        actual[0] = new Abiturient();
        actual[1] = new Abiturient();
        actual[2] = new Abiturient();
        actual[0].setMarks(new int[] {1, 2, 3, 4, 2});
        actual[1].setMarks(new int[] {1, 2, 3, 4, 1});
        actual[2].setMarks(new int[] {1, 2, 3, 4, 5});
        //Sozdaem massiv abiturientov kotoryi doljna vernut' funkchiya
        Abiturient[] expected = WorkWithAbiturient.getArray(3);
        expected[0] = new Abiturient();
        expected[1] = new Abiturient();
        expected[2] = new Abiturient();
        expected[0].setId(actual[2].getId());
        expected[1].setId(actual[0].getId());
        expected[2].setId(actual[1].getId());
        expected[0].setMarks(new int[] {1, 2, 3, 4, 5});
        expected[1].setMarks(new int[] {1, 2, 3, 4, 2});
        expected[2].setMarks(new int[] {1, 2, 3, 4, 1});
        //Vyzyvaem funkchyu sortAbiturients
        WorkWithAbiturient.sortAbiturients(actual);
        //Proveryaem sovpodaut li rezultaty
        Assert.assertEquals(Arrays.asList(actual), Arrays.asList(expected));
    }
}
