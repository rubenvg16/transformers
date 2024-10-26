package org.iesvdm.transformer;

import java.util.ArrayList;
import java.util.function.Function;

public class Transformers
{
    public static <T> ArrayList<T> applyConst(Transformer<T> tran, ArrayList<T> a)
    {
        ArrayList<T> b = new ArrayList<>();
        for(T t : a)
            b.add(tran.transform(t));
        return b;
    }

    public static <T> void applyDest(ArrayList<T> list, Function<T, T> func) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, func.apply(list.get(i)));
        }
    }
}

