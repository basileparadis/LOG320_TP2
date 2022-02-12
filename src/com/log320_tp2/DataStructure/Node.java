package com.log320_tp2.DataStructure;

import com.log320_tp2.Helpers.ID;
import com.log320_tp2.Helpers.IEquatable;
import com.log320_tp2.Helpers.Tuple;

import java.util.UUID;
import java.util.concurrent.RunnableFuture;

public class Node<T extends ID> implements IEquatable<Node>, ID
{
    public Node Parent;
    public Node LeftChild;
    public Node RightChild;

    private UUID ID;
    private T Value;

    public Node()
    {
        this.ID = UUID.randomUUID();
    }

    public Node(T value)
    {
        this.ID = UUID.randomUUID();
        this.Value = value;
    }

    public Node(T value, UUID ID)
    {
        this.ID = ID == null ? UUID.randomUUID() : ID;
        this.Value = value;
    }

    public UUID GetID() { return this.ID; }

    public T GetValue() { return Value; }

    @Override
    public boolean Equals(Node node)
    {
        return this.ID.equals(node.ID);
    }

    public boolean Equals(T value)
    {
        return this.ID.equals(T.ID);
    }

    public static String Encode(Node<Tuple<Character, Integer>> node)
    {
        StringBuilder stringBuilder = new StringBuilder();

        String valueSeparator = "&";

        stringBuilder.append(node.ID + valueSeparator);
        stringBuilder.append(node.Value.Item1);

        return stringBuilder.toString();
    }
}
