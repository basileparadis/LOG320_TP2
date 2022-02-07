package com.log320_tp2.DataStructure;

import com.log320_tp2.Helpers.Tuple;

public class Heap
{
    private Node<Tuple<Character, Integer>>[] internalCollection;

    public void Build(Tuple<Character, Integer>[] array)
    {
        internalCollection = new Node[array.length];

        for (int i = 0; i < array.length; i++) internalCollection[i] = new Node(array[i]);

        for (int i = array.length/2; i > 1; i--) MaxHeapify(internalCollection, i);
    }

    public void Delete(int value) throws Exception
    {

    }

    public void InOrderWalk() throws Exception
    {

    }

    public double Pop() throws Exception
    {
        return null;
    }

    private void MaxHeapify(Node<Tuple<Character, Integer>>[] array, int i)
    {
        var left = 2*i;
        var right = 2*i + 1;

        var leftValue = array[left].GetValue().Item2;
        var rightValue = array[right].GetValue().Item2;

        var largest = left <= array.length &&  leftValue> rightValue ?  left : i;

        if(right <= array.length && rightValue > array[largest].GetValue().Item2) largest = right;

        if(largest != i)
        {
            var temp = array[i];

            array[i] = array[largest];
            array[largest] = temp;

            MaxHeapify(array, largest);
        }
    }
}
