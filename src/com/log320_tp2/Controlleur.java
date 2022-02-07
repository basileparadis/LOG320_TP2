package com.log320_tp2;

import com.log320_tp2.DataStructure.HuffmanHeap;
import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.FileManipulation.FileWriter;
import com.log320_tp2.Helpers.Tuple;
import com.log320_tp2.Serialization.Serialize;
import java.util.PriorityQueue;

public class Controlleur
{
    public void Compress(String nomFichierEntre, String nomFichierSortie) throws Exception
    {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter();
        var serialize = new Serialize();
        var huffmanHeap = new HuffmanHeap();

        var bytes = fileReader.Read(nomFichierEntre);

        var tuples = serialize.CreerTableFrequences(bytes);

        var queue = new PriorityQueue<Tuple<Character, Integer>>((o1, o2) ->
        {
            if(o1.Item2 > o2.Item2) return 1;
            if(o1.Item2 < o2.Item2) return -1;
            return 0;
        });

        queue.addAll(tuples);

        huffmanHeap.Build(queue);

        fileWriter.Write(nomFichierSortie, serialize.Encode(bytes, huffmanHeap).getBytes());
    }

    public void Decompress()
    {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter();
        var deserialize = new Serialize();



    }
}
