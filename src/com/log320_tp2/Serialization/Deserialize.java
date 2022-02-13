package com.log320_tp2.Serialization;

import com.log320_tp2.DataStructure.Node;
import com.log320_tp2.Helpers.Tuple;

import java.util.HashMap;
import java.util.UUID;

public class Deserialize
{
    public String Deserialize(String text)
    {
        var splitHeader = text.split("&&");

        var codex = BuildCodex(splitHeader[0]);

        var splitText = splitHeader[1].split(" ");

        StringBuilder stringBuilder = new StringBuilder();

        for (var code: splitText)
        {
            var value = codex.get(code);
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }

    private HashMap<String, String> BuildCodex(String header)
    {
        var splitHeader = header.split(",,");
        var codex = new HashMap<String, String>();

        for (var code:splitHeader)
        {
            var splitTuple = code.split(":");
            if(splitTuple.length>1)
                codex.put(splitTuple[1], splitTuple[0]);
        }
        return codex;
    }

}
