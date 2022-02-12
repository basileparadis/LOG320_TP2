package com.log320_tp2.Serialization;

import com.log320_tp2.DataStructure.Node;
import com.log320_tp2.Helpers.Tuple;

import java.util.UUID;

public class Deserialize
{
    public Node Deserialize(String text)
    {
        var values = text.split(";");

        return NodeFromString(values, 0);
    }

    private Node NodeFromString(String[] text, int index)
    {
        var values = text[index].split("&");

        var ID = UUID.fromString(values[0]);
        var value = new Tuple<Character, Integer>(values[0].charAt(0), Integer.getInteger(values[1]));

        var leftChild = NodeFromString(text, 2 * index);
        var rightChild = NodeFromString(text, 2 * index + 1);

        Node node = new Node(value, ID);

        node.LeftChild = leftChild;
        node.RightChild = rightChild;

        return node;
    }
}
