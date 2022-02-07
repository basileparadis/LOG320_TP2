package com.log320_tp2.Serialization;

import com.log320_tp2.Helpers.Tuple;
import java.util.ArrayList;
import java.util.HashMap;

public class Serialize
{
    public ArrayList<Tuple<Character, Integer>> CreerTableFrequences(byte[] bytes)
    {
        var map = new HashMap<Character, Tuple<Character, Integer>>();

        for (byte b : bytes)
        {
            var key = (char)b;

            if(map.containsKey(key))
            {
                var value = map.get(key);
                value.Item2++;

                map.replace(key, value);
            }
            else map.put(key, new Tuple<>(key, 1));
        }

        return new ArrayList(map.values());
    }
}
