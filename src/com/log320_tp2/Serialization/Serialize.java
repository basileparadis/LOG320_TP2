package com.log320_tp2.Serialization;

import com.log320_tp2.Controlleur;
import com.log320_tp2.FileManipulation.FileBinaryWriter;
import com.log320_tp2.Helpers.Tuple;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Serialize
{
    public ArrayList<Tuple<String, Integer>> CreerTableFrequences(BufferedReader bufferedReader) throws IOException
    {
        var map = new HashMap<String, Tuple<String, Integer>>();

        while(bufferedReader.ready())
        {
            var key = Character.toString ((char)bufferedReader.read());

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

    public int Encode(BufferedReader bufferedReader, HashMap<String, String> codex, String outputFile) throws IOException
    {
        FileBinaryWriter fileWriter = new FileBinaryWriter(outputFile);

        int bytesWritten = 0;

        while(bufferedReader.ready())
        {
            var key = Character.toString((char)bufferedReader.read());

            var encodedValue = codex.get(key);

            for (var character : encodedValue.toCharArray())
            {
                var value = Integer.parseInt(String.valueOf(character));

                fileWriter.SingleWriteEncoded(value);

                bytesWritten++;
            }
        }

        fileWriter.Close();

        return bytesWritten;
    }

    public String SerializeHeader(HashMap<String, String> codex, int bytesWritten)
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(Controlleur.StaticStrings.ﾀ.toString());

        for (var value: codex.keySet())
        {
            stringBuilder.append(value+ ":!:" +codex.get(value)+ "&!&");
        }

        stringBuilder.append(bytesWritten);

        return stringBuilder.toString();
    }
}
