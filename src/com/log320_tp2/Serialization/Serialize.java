package com.log320_tp2.Serialization;

import com.log320_tp2.DataStructure.HuffmanHeap;
import com.log320_tp2.Helpers.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class Serialize
{
    public ArrayList<Tuple<String, Integer>> CreerTableFrequences(ArrayList<Character> chars)
    {
        var map = new HashMap<String, Tuple<String, Integer>>();

        for (var character : chars)
        {
            var key = character.toString();

            if(map.containsKey(key))
            {
                var value = map.get(key);
                value.Item2++;

                map.replace(String.valueOf(key), value);
            }
            else map.put(String.valueOf(key), new Tuple(key, 1));
        }

        return new ArrayList(map.values());
    }

    public String Encode(ArrayList<Character> chars, HuffmanHeap heap)
    {
        var codex = heap.GetEncodedValues();

        var header = SerializeHeader(codex);

        StringBuilder stringBuilder = new StringBuilder(header);

        for (var string: chars)
        {
            var encodedValue = codex.get(string.toString());

            stringBuilder.append(encodedValue + "");
        }

        return stringBuilder.toString();
    }

    private String SerializeHeader(HashMap<String, String> codex)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (var value: codex.keySet())
        {
            stringBuilder.append(value+":"+codex.get(value)+",,");
        }

        stringBuilder.append("&&");

        return stringBuilder.toString();
    }
}
