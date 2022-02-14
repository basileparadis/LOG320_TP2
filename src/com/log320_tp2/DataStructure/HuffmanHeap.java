package com.log320_tp2.DataStructure;

import com.log320_tp2.Controlleur;
import com.log320_tp2.Helpers.Tuple;

import java.util.*;

public class HuffmanHeap
{
    public ArrayList<Tuple<String, Integer>> Heap;

    public void Build(PriorityQueue<Tuple<String, Integer>> queue) throws NoSuchFieldException
    {
        Heap = new ArrayList<Tuple<String, Integer>>();

        var queueEmpty =  new PriorityQueue<Tuple<String, Integer>>(queue);

        var valuePrior =  queueEmpty.remove();

        while (!queueEmpty.isEmpty())
        {
            var value = queueEmpty.remove();

            var emptyValue = new Tuple<String , Integer>("empty" ,valuePrior.Item2 + value.Item2);

            Insert(Heap, emptyValue);

            valuePrior = emptyValue;
        }

        while (!queue.isEmpty())
        {
            var value = queue.remove();
            Insert(Heap, value);
        }
    }

    private void Insert(ArrayList<Tuple<String, Integer>> array, Tuple<String, Integer> value) throws NoSuchFieldException {
        array.add(new Tuple<>(null, Integer.MAX_VALUE));

        IncreaseKey(array, array.size()-1, value);
    }

    private void IncreaseKey(ArrayList<Tuple<String, Integer>> array, int i, Tuple<String, Integer> value) throws NoSuchFieldException {
        if(value.Item2 < array.get(i).Item2)
        {
            array.set(i, value);
            return;
        }
        array.set(i, value);

        while (i>1 && array.get(i/2).Item2 > array.get(i).Item2)
        {
            var temp = array.get(i);

            array.set(i, array.get(i/2));
            array.set(i/2, temp);
        }
    }

    private void MaxHeapify(ArrayList<Tuple<String, Integer>> array, int i)
    {
        var left = 2*i;
        var right = 2*i + 1;

        int largest = 0;

        if(left < array.size() && array.get(left).Item2 > array.get(i).Item2)
            largest = left;
        else
            largest = i;

        if(right < array.size() && array.get(right).Item2 > array.get(largest).Item2)
            largest = right;

        if(largest != i)
        {
            var temp = array.get(i);

            array.set(i, array.get(largest));
            array.set(largest, temp);

            MaxHeapify(array, largest);
        }
    }

    public HashMap<String, String> GetEncodedValues()
    {
        var array = GetLeaves(1, "");

        var map = new HashMap<String, String>();

        for (var tuple : array)
        {
            map.put(tuple.Item1, tuple.Item2);
        }

        return map;
    }

    private ArrayList<Tuple<String, String>> GetLeaves(int index, String binaryValue)
    {
        var list = new ArrayList<Tuple<String, String>>();

        var left = 2*index;
        var right = (2*index)+1;

        if(index-1 >= Heap.size()) return list;

        var value = Heap.get(index-1);

        if(!value.Item1.equals("empty"))
        {
            list.add(new Tuple<String, String>(value.Item1, binaryValue));
        }
        else
        {
            list.addAll(GetLeaves(left, binaryValue + "0"));
            list.addAll(GetLeaves(right, binaryValue + "1"));
        }
        return list;
    }
}
