package com.log320_tp2.DataStructure;

import com.log320_tp2.Helpers.Tuple;
import com.log320_tp2.Huffman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HuffmanHeap
{
    //private Node<Tuple<Character, Integer>>[] internalCollection;

    private HashMap<Character, Node> internalCollectionReccurence;

    private HashMap<Character, String> internalCollectionPosition;

    //public Node<Tuple<Character, Integer>>[] GetInternalCollection() { return internalCollection; }

    public HashMap<Character, Integer> GetInternalCollection() { return internalCollectionReccurence; }

    public void Build(PriorityQueue<Tuple<Character, Integer>> queue)
    {
        //internalCollection = new Node[queue.size()];

        Huffman(null, queue);

        //for (int i = 0; i < queue.size(); i++) internalCollection[i] = new Node(qu[i]);

        //for (int i = array.length/2; i > 1; i--) MaxHeapify(internalCollection, i);
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

    private void Huffman(Node node, PriorityQueue<Tuple<Character, Integer>> queue)
    {
        if(queue.isEmpty()) return;
        if(node == null)
        {
            var value =  queue.remove();
            node = new Node(value);
            internalCollectionReccurence.put(value.Item1, node);
        }

        Node child = new Node(queue.remove());
        Node root = new Node(new Tuple<Character, Integer>(null, ((Tuple<Character, Integer>)child.GetValue()).Item2));

        node.Parent = child.Parent = root;
        root.LeftChild = node;
        root.RightChild = child;

        Huffman(root, queue);
    }

    public String GetCode(char c)
    {
        if(internalCollectionPosition.containsKey(c))return internalCollectionPosition.get(c);

        if(internalCollectionReccurence.containsKey(c))
        {
            StringBuilder position = new StringBuilder();

            Node current = internalCollectionReccurence.get(c);
            Node parent = current.Parent;

            while (parent != null)
            {
                position.append(parent.RightChild.equals(current) ? '1' : '0');
                parent = parent.Parent;
                current = parent;
            }

            internalCollectionPosition.put(c, position.toString());
        }
    }

}
