package com.log320_tp2;

import com.log320_tp2.DataStructure.Heap;
import com.log320_tp2.DataStructure.Node;
import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.FileManipulation.FileWriter;
import com.log320_tp2.Helpers.Tuple;
import com.log320_tp2.Serialization.Serialize;

import java.io.IOException;

public class Template
{
    public void Compress(String nomFichierEntre, String nomFichierSortie) throws Exception
    {
        var fileReader = new FileReader();
        var fileWriter = new FileWriter();

        var serialize = new Serialize();

        var heap = new Heap();

        var tuples = serialize.CreerTableFrequences(fileReader.Read(nomFichierEntre));

        heap.Build((Tuple<Character, Integer>[]) tuples.toArray());

        fileWriter.Write(nomFichierSortie, b);
    }
}
