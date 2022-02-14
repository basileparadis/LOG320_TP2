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

        if(GetToText(codes, codeBuilder))
        {
           codeBuilder = new StringBuilder();
        }
        else
            throw new IOException();

        while(true)
        {
            var bite = codes.readBit();

            if(bite == -1)
                break;

            codeBuilder.append(bite);

            if(codex.containsKey(codeBuilder.toString()))
            {
                var value = codex.get(codeBuilder.toString());

                fileWriter2.SingleWriteString(value);

                codeBuilder = new StringBuilder();
            }
        }
    }

    private boolean GetToText(BitInputStream codes, StringBuilder codeBuilder)
    {
        boolean check = false;

        StringBuilder middleCheck = new StringBuilder();

        for (int i = 0; i <= 100; i++) middleCheck.append(1);

        char[] toFind = ("101"+middleCheck.toString() +"101").toCharArray();

        while (true)
        {
            var bite = codes.readBit();

            if(bite == -1)
                return false;

            codeBuilder.append(bite);

            check = true;

            for (int i = 0; i < codeBuilder.length(); i++) {
                if(!(codeBuilder.charAt(i) == toFind[i]))
                {
                    check = false;
                    codeBuilder = new StringBuilder();
                    break;
                }
            }
            if (check && codeBuilder.length() == toFind.length)
            {
                return true;
            }
        }

    }

    private HashMap<String, String> BuildCodex(String header)
    {
        var splitHeader = header.split("&!&");
        var codex = new HashMap<String, String>();

        for (int i = 0; i < splitHeader.length-1; i++)
        {
            var splitTuple = splitHeader[i].split(":!:");

            if(splitTuple.length>1)
                codex.put(splitTuple[1], splitTuple[0]);
        }

        return codex;
    }

}
