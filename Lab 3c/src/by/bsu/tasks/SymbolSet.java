package by.bsu.tasks;
import java.util.*;
//it is a set of symbols
public class SymbolSet {

    //create a hashset
    private HashSet<Character> set = new HashSet<Character>();
    //default constructor
    public SymbolSet()
    {
    }
    //constructor with parameters
    public SymbolSet(HashSet<Character> set)
    {
        this.set.clear();
        this.set.addAll(set);
    }
    //copy constructor
    public SymbolSet(SymbolSet set)
    {
        this.set = new HashSet<>(set.set);
    }
    //return hashset
    public HashSet<Character> getHashSet() {
            return set;
    }
    //set hashset
    public void setHashSet(HashSet<Character> set) {
        this.set = new HashSet<>(set);
    }
    //adding an element to the set
    public void Insert(Character ch)
    {
        this.set.add(ch);
    }
    //add our object with transferred
    public void Addition(SymbolSet set)
    {
        this.set.addAll(set.set);
    }
    //subtract the transferred object from our
    public void Subtraction(SymbolSet set)
    {
        this.set.removeAll(set.set);
    }
    //multiply our object by transferred
    public void Multiplication(SymbolSet set)
    {
        this.set.retainAll(set.set);
    }
    //return element of the set by index
    public Character IndexOf(int index)
    {
        int i = 0;
        for (Character ch: this.set) {
            if(i==index)
            {
                return ch;
            }
            i++;
        }
        return null;
    }


}
