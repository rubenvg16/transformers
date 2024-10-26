package org.iesvdm.transformer;


import java.util.ArrayList;

public class    Joiners
{
    public static <T> LispList<T> zipLists(Joiner<T> joiner,LispList<T> ls1,LispList<T> ls2)
    {
        if(ls1.isEmpty()||ls2.isEmpty())
            return LispList.empty();
        else
        {
            T h = joiner.join(ls1.head(),ls2.head());
            LispList<T> t = zipLists(joiner,ls1.tail(),ls2.tail());
            return t.cons(h);
        }
    }

    public static <T> ArrayList<T> zipArrayLists(ArrayList<T> list1, ArrayList<T> list2, Joiner<T> joiner) {
        ArrayList<T> result = new ArrayList<>();
        int minSize = Math.min(list1.size(), list2.size());

        for (int i = 0; i < minSize; i++) {
            T joinedItem = joiner.join(list1.get(i), list2.get(i));
            result.add(joinedItem);
        }

        return result;
    }
}