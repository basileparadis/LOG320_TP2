package com.log320_tp2.Helpers;

public class Tuple <K,T> implements Comparable<Tuple<K,T>>
{
    public K Item1;
    public T Item2;

    public Tuple(K item1, T item2)
    {
        this.Item1 = item1;
        this.Item2 = item2;
    }

    @Override
    public int compareTo(Tuple<K, T> o)
    {
        return this.Item1 == o ? 0 : 1;
    }
}
