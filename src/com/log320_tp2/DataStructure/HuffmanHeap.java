package com.log320_tp2.DataStructure;

import com.log320_tp2.Helpers.Tuple;
import com.log320_tp2.Huffman;

import java.awt.print.Printable;
import java.util.*;

public class HuffmanHeap
{
    public ArrayList<Tuple<String, Integer>> Heap;

    public void Build(PriorityQueue<Tuple<String, Integer>> queue)
    {
        Heap = new ArrayList<Tuple<String, Integer>>();

        var valuePrior =  queue.remove();

        Heap.add(valuePrior);

        while (!queue.isEmpty())
        {
            var value = queue.remove();

            var emptyValue = new Tuple<String , Integer>("empty" ,valuePrior.Item2 + value.Item2);

            Heap.add(emptyValue);

            Heap.add(value);

            valuePrior = emptyValue;
        }

        for (int i = Heap.size()/2; i > 0; i--) {
            MaxHeapify(Heap, i);
        }

        Heap.removeIf(tuple->tuple.Item1.equals("empty"));
    }

    private void MaxHeapify(ArrayList<Tuple<String, Integer>> array, int i)
    {
        var left = 2*i;
        var right = 2*i + 1;

        if(array.size()<left+1 || array.size()<right+1) return;

        var leftValue = array.get(left-1).Item2;
        var rightValue = array.get(right-1).Item2;

        var largest = left <= array.size() &&  leftValue > rightValue ?  left : i;

        if(right <= array.size() && rightValue > array.get(largest).Item2) largest = right;

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
        var array = GetLeaves(0, "0");

        var map = new HashMap<String, String>();

        for (var tuple : array)
        {
            map.put(tuple.Item1, tuple.Item2);
        }

        return map;
    }

    private ArrayList<Tuple<String, String>> GetLeaves(int index, String binaryValue)
    {
        if(index ==0) index++;

        var list = new ArrayList<Tuple<String, String>>();

        var left = (2*index);
        var right = 2*index+1;

        if(index >= Heap.size()) return list;

        var value = Heap.get(index-1);


        if(value != null)
        {
            list.add(new Tuple<String, String>(value.Item1, binaryValue));
            list.addAll(GetLeaves(left, binaryValue + ""));
            list.addAll(GetLeaves(right, binaryValue + ""));

        }
        return list;
    }
}
