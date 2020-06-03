package by.bsu.tasks;

public class ControllerSymbolSet {
    //return symmetric difference of 2 SymbolSets
    public static SymbolSet SymmetricDifference(SymbolSet s1, SymbolSet s2)
    {
        return Difference(Union(s1, s2), Intersect(s1, s2));
    }
    //check if the element is contained in the set
    public static boolean Contains(SymbolSet set, Character ch)
    {
        return set.getHashSet().contains(ch);
    }
    //return intersection of 2 SymbolSets
    public static SymbolSet Intersect(SymbolSet set1, SymbolSet set2)
    {
        SymbolSet set = new SymbolSet(set1);
        set.getHashSet().retainAll(set2.getHashSet());
        return set;
    }
    //return union of 2 SymbolSets
    public static SymbolSet Union(SymbolSet set1, SymbolSet set2)
    {
        SymbolSet set = new SymbolSet(set1);
        set.getHashSet().addAll(set2.getHashSet());
        return set;
    }
    //return difference of 2 SymbolSets
    public static SymbolSet Difference(SymbolSet set1,SymbolSet set2)
    {
        SymbolSet set = new SymbolSet(set1);
        set.getHashSet().removeAll(set2.getHashSet());
        return set;
    }
}
