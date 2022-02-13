package com.log320_tp2;

import com.log320_tp2.DataStructure.HuffmanHeap;
import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.FileManipulation.FileWriter2;
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
        var fileWriter = new FileWriter2();
        var serialize = new Serialize();
        var huffmanHeap = new HuffmanHeap();

        var chars = fileReader.Read(nomFichierEntre);

        var tableFrequences = serialize.CreerTableFrequences(chars);

        var queue = new PriorityQueue<Tuple<String, Integer>>((o1, o2) ->
        {
            if(o1.Item2 > o2.Item2) return -1;
            if(o1.Item2 < o2.Item2) return 1;
            return 0;
        });

        queue.addAll(tableFrequences);

        huffmanHeap.Build(queue);

        var codex = huffmanHeap.GetEncodedValues();

        var encodedString = serialize.Encode(chars, codex);

        int bytesWritten = encodedString.length();

        fileWriter.WriteEncoded(nomFichierSortie, encodedString);

        fileWriter.WriteAppendText(nomFichierSortie, serialize.SerializeHeader(codex, bytesWritten));
    }


    public static void Decompress(String nomFichierEntre, String nomFichierSortie) throws IOException {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter2();
        var deserialize = new Deserialize();

        var chars = fileReader.ReadBinary(nomFichierEntre);

        var codex = fileReader.ReadDecompress(nomFichierEntre);


        StringBuilder stringBuilder = new StringBuilder();

        for (var code:codex) stringBuilder.append(code);

        var value = deserialize.Deserialize(chars, stringBuilder.toString());

        fileWriter.WriteText(nomFichierSortie, value);
    }
}

