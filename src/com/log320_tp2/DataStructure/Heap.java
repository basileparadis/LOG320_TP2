package com.log320_tp2.DataStructure;

import com.log320_tp2.Helpers.Actions;

public class Heap
{
    public void Build(Node<int, string>[] array)
    {
        for (int i = array.length/2; i > 1; i--)
        {
            MaxHeapify(array, i);
        }
    }

    public void Insert(double value) throws Exception
    {

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

    private void MaxHeapify(double[] array, int i)
    {
        var left = 2*i;
        var right = 2*i + 1;

        var largest = left <= array.length && array[left] > array[right] ?  left : i;

        if(right <= array.length && array[right] > array[largest]) largest = right;

        if(largest != i)
        {
            var temp = array[i];

            array[i] = array[largest];
            array[largest] = temp;

            MaxHeapify(array, largest);
        }
    }
}
