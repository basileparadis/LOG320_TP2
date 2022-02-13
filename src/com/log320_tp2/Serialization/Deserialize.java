package com.log320_tp2.Serialization;

import com.log320_tp2.Helpers.Tuple;

import java.util.ArrayList;
import java.util.HashMap;

public class Deserialize
{
    public String Deserialize(ArrayList<Character> codes, String text)
    {
        var codex = BuildCodex(text);

        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder codeBuilder = new StringBuilder();

        for (int i = 0; i < codex.Item2; i++)
        {
            var codeValue = codes.get(i).hashCode() == 0? 0 : 1;

            codeBuilder.append(codeValue);

            if(codex.Item1.containsKey(codeBuilder.toString()))
            {
                var value = codex.Item1.get(codeBuilder.toString());
                stringBuilder.append(value);

                codeBuilder = new StringBuilder();
            }
        }

        return stringBuilder.toString();
    }

    private Tuple<HashMap<String, String>, Integer> BuildCodex(String header)
    {
        var splitHeader = header.split(",!,");
        var codex = new HashMap<String, String>();

        for (int i = 0; i < splitHeader.length-1; i++)
        {
            var splitTuple = splitHeader[i].split(":!:");
            if(splitTuple.length>1)
                codex.put(splitTuple[1], splitTuple[0]);
        }

        var bytesWritten = splitHeader[splitHeader.length-1];

        return new Tuple<>(codex, Integer.parseInt(bytesWritten));
    }

}
