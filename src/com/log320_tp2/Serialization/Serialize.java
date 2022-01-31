package com.log320_tp2.Serialization;

import com.log320_tp2.Helpers.Tuple;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class Serialize
{
    public ArrayList<Tuple<String, Integer>> CreerTableFrequences(byte[] bytes)
    {
        var map = new HashMap<String, Tuple<String, Integer>>();

        for (byte b: bytes)
        {
            var key = String.valueOf(b);

            if(map.containsKey(key))
            {
                var value = map.get(key);
                value.Item2++;

                map.replace(key, value);
            }
            else
            {
                map.put(key, new Tuple<>(key, 1));
            }
        }
        return map.values();
    }
}
