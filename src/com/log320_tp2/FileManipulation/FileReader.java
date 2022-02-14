package com.log320_tp2.FileManipulation;

import com.log320_tp2.Controlleur;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class FileReader
{
    public BufferedReader Read(String path) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
        BufferedReader buffReader = new BufferedReader(inputStreamReader);

        return buffReader;
    }

    public ArrayList<Character> ReadDecompress(String path) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
        BufferedReader buffReader = new BufferedReader(inputStreamReader);

        var chars = new ArrayList<Character>();

        boolean reachedCodex = false;

        while (buffReader.ready())
        {
            var value = (char)buffReader.read();

            if(reachedCodex)chars.add(value);

            if(String.valueOf(value).equals(Controlleur.StaticStrings.ﾀ.toString()))
                reachedCodex = true;
        }

        return chars;
    }


    public BitInputStream ReadBinary(String path) throws IOException
    {
        BitInputStream bitInputStream = new BitInputStream(path);

        return bitInputStream;
    }
}
