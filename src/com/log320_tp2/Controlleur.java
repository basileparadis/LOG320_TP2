package com.log320_tp2;

import com.log320_tp2.DataStructure.HuffmanHeap;
import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.FileManipulation.FileWriter;
import com.log320_tp2.Helpers.Tuple;
import com.log320_tp2.Serialization.Deserialize;
import com.log320_tp2.Serialization.Serialize;

import java.io.IOException;
import java.util.PriorityQueue;

public class Controlleur
{
    public static void Compress(String nomFichierEntre, String nomFichierSortie) throws Exception
    {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter();
        var serialize = new Serialize();
        var huffmanHeap = new HuffmanHeap();

        var bytes = fileReader.Read(nomFichierEntre);

        var tableFrequences = serialize.CreerTableFrequences(bytes);

        var queue = new PriorityQueue<Tuple<String, Integer>>((o1, o2) ->
        {
            if(o1.Item2 > o2.Item2) return -1;
            if(o1.Item2 < o2.Item2) return 1;
            return 0;
        });

        queue.addAll(tableFrequences);

        huffmanHeap.Build(queue);

        fileWriter.Write(nomFichierSortie, serialize.Encode(bytes, huffmanHeap));
    }


    public static String Compress(String stringInput) throws Exception
    {
        var serialize = new Serialize();
        var huffmanHeap = new HuffmanHeap();

        var tableFrequences = serialize.CreerTableFrequences(stringInput.getBytes());

        var queue = new PriorityQueue<Tuple<String, Integer>>((o1, o2) ->
        {
            if(o1.Item2 > o2.Item2) return -1;
            if(o1.Item2 < o2.Item2) return 1;
            return 0;
        });

        queue.addAll(tableFrequences);

        huffmanHeap.Build(queue);

        return serialize.Encode(stringInput.getBytes(), huffmanHeap);
    }

    public static void Decompress(String nomFichierEntre, String nomFichierSortie) throws IOException {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter();
        var deserialize = new Deserialize();

        var bytes = fileReader.Read(nomFichierEntre);

        var value = deserialize.Deserialize(new String(bytes));
        fileWriter.Write(nomFichierSortie, value);
    }

    public static String Decompress(String stringInput) throws IOException {
        var deserialize = new Deserialize();

        var bytes = stringInput.getBytes();

        return deserialize.Deserialize(new String(bytes));
    }
}

