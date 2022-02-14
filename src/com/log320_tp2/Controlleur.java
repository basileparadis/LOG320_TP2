package com.log320_tp2;

import com.log320_tp2.DataStructure.HuffmanHeap;
import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.FileManipulation.FileTextWriter;
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
        var serialize = new Serialize();
        var huffmanHeap = new HuffmanHeap();

        var tableFrequences = serialize.CreerTableFrequences(fileReader.Read(nomFichierEntre));

        var queue = new PriorityQueue<Tuple<String, Integer>>((o1, o2) ->
        {
            if(o1.Item2 > o2.Item2) return -1;
            if(o1.Item2 < o2.Item2) return 1;
            return 0;
        });

        queue.addAll(tableFrequences);

        huffmanHeap.Build(queue);

        var codex = huffmanHeap.GetEncodedValues();

        FileTextWriter.Write(nomFichierSortie, serialize.SerializeHeader(codex));

        serialize.Encode(fileReader.Read(nomFichierEntre), codex, nomFichierSortie);
    }


    public static void Decompress(String nomFichierEntre, String nomFichierSortie) throws IOException
    {
        var fileReader = new FileReader();
        var deserialize = new Deserialize();

        var bitInputStream = fileReader.ReadBinary(nomFichierEntre);

        var codex = fileReader.ReadDecompress(nomFichierEntre);

        StringBuilder stringBuilder = new StringBuilder();

        for (var code:codex) stringBuilder.append(code);

        deserialize.Deserialize(bitInputStream, stringBuilder.toString(), nomFichierSortie);

    }
}

