package by.bsu.tasks;

import java.util.Arrays;

public class Abiturient {
    //Kolichestvo ochenok v massive
    public static final int cntMarks = 5;
    //Unikal'nyi id dlya ob'ektov klassa
    private static int nextId = 0;
    private int id;
    private String surname;
    private String name;
    private String fathersName;
    private String adress;
    private String phoneNumber;
    private int[] marks;

    //Konstruktor kopitovaniya
    public Abiturient(final Abiturient abit) {
        this.id = abit.id;
        this.surname = abit.surname;
        this.name = abit.name;
        this.fathersName = abit.fathersName;
        this.adress = abit.adress;
        this.phoneNumber = abit.phoneNumber;
        this.marks = new int[Abiturient.cntMarks];
        for (int i = 0; i < Abiturient.cntMarks; ++i)
            this.marks[i] = abit.marks[i];
    }

    //Konstructor po umolchaniu
    public Abiturient() {
        this.id = Abiturient.nextId++;
        this.surname = "";
        this.name = "";
        this.fathersName = "";
        this.adress = "";
        this.phoneNumber = "";
        this.marks = new int[Abiturient.cntMarks];
        for (int i = 0; i < Abiturient.cntMarks; ++i)
            this.marks[i] = 0;
    }

    //Konstructor s parametrami
    public Abiturient(final String surname, final String name, final String fathersName, final String adress, final String phoneNumber, final int[] marks) {
        this.id = Abiturient.nextId++;
        this.surname = surname;
        this.name = name;
        this.fathersName = fathersName;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
        this.marks = new int[Abiturient.cntMarks];
        if (marks.length >= Abiturient.cntMarks) {
            for (int i = 0; i < Abiturient.cntMarks; ++i)
                this.marks[i] = marks[i];
        } else {
            for (int i = 0; i < Abiturient.cntMarks; ++i)
                this.marks[i] = 0;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(final String fathersName) {
        this.fathersName = fathersName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(final String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int[] getMarks() {
        return marks;
    }

    public void setMarks(final int[] marks) {
        if (marks.length >= Abiturient.cntMarks) {
            for (int i = 0; i < Abiturient.cntMarks; ++i)
                this.marks[i] = marks[i];
        }
    }

    public int getMark(int index) {
        if ((index >= 0) && (index < Abiturient.cntMarks))
            return this.marks[index];
        else
            return 0;
    }

    public void setMark(int index, int n) {
        if ((index >= 0) && (index < Abiturient.cntMarks))
            this.marks[index] = n;
    }

    //Peregruzka metoda toString
    @Override
    public String toString() {
        return "Абитуриент{ " +
                "id = " + id +
                ", фамилия = " + surname +
                ", имя = " + name +
                ", отчество = " + fathersName +
                ", адресс = " + adress +
                ", номер телефона = " + phoneNumber +
                ", оценки = " + Arrays.toString(marks) +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Abiturient that = (Abiturient) o;

        if (id != that.id) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (fathersName != null ? !fathersName.equals(that.fathersName) : that.fathersName != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        return Arrays.equals(marks, that.marks);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (fathersName != null ? fathersName.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(marks);
        return result;
    }
}