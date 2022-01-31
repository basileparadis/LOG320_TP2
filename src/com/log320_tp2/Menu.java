package com.log320_tp2;

import com.log320_tp2.DataStructure.Heap;
import com.log320_tp2.DataStructure.Node;
import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.FileManipulation.FileWriter;
import com.log320_tp2.Serialization.Serialize;

import java.io.IOException;

public class Menu
{
    public void Compress(String nomFichierEntre, String nomFichierSortie) throws Exception
    {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter();

        var serialize = new Serialize();

        var heap = new Heap<Node>();

        var tuples = serialize.CreerTableFrequences(fileReader.Read(nomFichierEntre));

        for (var tuple: tuples) heap.Insert(new Node(tuple));

        fileWriter.Write(nomFichierEntre, b);
    }
}
