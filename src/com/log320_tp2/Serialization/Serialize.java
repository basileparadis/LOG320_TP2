package com.log320_tp2.Serialization;

import com.log320_tp2.Helpers.Tuple;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

public class Serialize
{
    public ArrayList<Tuple<String, Integer>> CreerTableFrequences(byte[] bytes)
    {
        var list = new ArrayList<Tuple<String, Integer>>();

        for (byte b: bytes)
        {
            if(list.contains(String.valueOf(b)))
            {
                ++list.get(list.indexOf(String.valueOf(b))).Item2;
            }
            else
            {
                list.add(new Tuple(String.valueOf(b),1));
            }
        }
        return list;
    }
}
