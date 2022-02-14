package com.log320_tp2.Serialization;

import com.log320_tp2.FileManipulation.BitInputStream;
import com.log320_tp2.FileManipulation.FileTextWriter;
import com.log320_tp2.Helpers.Tuple;
import java.io.IOException;
import java.util.HashMap;

public class Deserialize
{
    public void Deserialize(BitInputStream codes, String text, String outPutFile) throws IOException
    {
        var codex = BuildCodex(text);

        FileTextWriter fileWriter2 = new FileTextWriter(outPutFile);

        StringBuilder codeBuilder = new StringBuilder();

        int count = 0;

        while(count < codex.Item2)
        {
            var bite = codes.readBit();

            if(bite == -1)
                break;

            codeBuilder.append(bite);

            if(codex.Item1.containsKey(codeBuilder.toString()))
            {
                var value = codex.Item1.get(codeBuilder.toString());

                fileWriter2.SingleWriteString(value);

                codeBuilder = new StringBuilder();
            }
            count++;
        }
    }

    private Tuple<HashMap<String, String>, Integer> BuildCodex(String header)
    {
        var splitHeader = header.split("&!&");
        var codex = new HashMap<String, String>();

        for (int i = 0; i < splitHeader.length-1; i++)
        {
            var splitTuple = splitHeader[i].split(":!:");

            if(splitTuple.length>1)
                codex.put(splitTuple[1], splitTuple[0]);
        }

        return new Tuple(codex, Integer.parseInt(splitHeader[splitHeader.length-1]));
    }

}
