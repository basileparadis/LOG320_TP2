package com.log320_tp2.DataStructure;

import com.log320_tp2.Helpers.Tuple;
import com.log320_tp2.Huffman;

import java.util.*;

public class HuffmanHeap
{
    public ArrayList<Tuple<Character, Integer>> Heap;

    public void Build(PriorityQueue<Tuple<Character, Integer>> queue)
    {
        Heap = new ArrayList<Tuple<Character, Integer>>();

        var valuePrior =  queue.remove();

        Heap.add(valuePrior);

        while (!queue.isEmpty())
        {
            var newValue = new Tuple<Character, Integer>(null ,valuePrior.Item2 + queue.remove().Item2);

            Heap.add(newValue);

            MaxHeapify(Heap, 0);

            valuePrior = newValue;
        }
    }

    private void MaxHeapify(ArrayList<Tuple<Character, Integer>> array, int i)
    {
        var left = 2*i;
        var right = 2*i + 1;

        var leftValue = array.get(left).Item2;
        var rightValue = array.get(right).Item2;

        var largest = left <= array.size() &&  leftValue> rightValue ?  left : i;

        if(right <= array.size() && rightValue > array.get(largest).Item2) largest = right;

        if(largest != i)
        {
            var temp = array.get(i);

            array.set(i, array.get(largest));
            array.set(largest, temp);

            MaxHeapify(array, largest);
        }
    }

    private ArrayList<Tuple<Character, String>> GetLeaves(int index, StringBuilder binaryValue)
    {
        var list = new ArrayList<Tuple<Character, String>>();

        var left = 2*index;
        var right = 2*index + 1;

        var value = Heap.get(index);

        if(value != null && value.Item1 == null)
        {
            list.addAll(GetLeaves(left, binaryValue.append("1")));
            list.addAll(GetLeaves(right, binaryValue.append("0")));
        }
        else if(value != null && value.Item1 != null)
        {
            list.add(new Tuple<Character, String>(value.Item1, binaryValue.toString()));
        }

        return list;
    }


    public HashMap<String, Character> GetEncodedValues()
    {
        var array = GetLeaves(0, new StringBuilder());
        var map = new HashMap<String, Character>();

        for (var tuple : array)
        {
            map.put(tuple.Item2, tuple.Item1);
        }

        return map;
    }
}
