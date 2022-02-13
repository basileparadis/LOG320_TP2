package com.log320_tp2.FileManipulation;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader
{
    public ArrayList<Character> Read(String path) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
        BufferedReader buffReader = new BufferedReader(inputStreamReader);

        var chars = new ArrayList<Character>();

        while (buffReader.ready())
        {
            chars.add((char)buffReader.read());
        }

        return chars;
    }

    public ArrayList<Character> ReadDecompress(String path) throws IOException
    {
        FileInputStream fileInputStream = new FileInputStream(path);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, Charset.forName("UTF-8"));
        BufferedReader buffReader = new BufferedReader(inputStreamReader);

        var chars = new ArrayList<Character>();

        boolean reachedCodex = false;
        int counter = 0;

        while (buffReader.ready())
        {
            if(!reachedCodex)
            {
                if((char)buffReader.read() == '&') counter++;
                else counter =0;

                if(counter == 2) reachedCodex = true;
            }
            else if (reachedCodex)
                chars.add((char)buffReader.read());
        }

        return chars;
    }


    public ArrayList<Character> ReadBinary(String path) throws IOException
    {
        BitInputStream bitInputStream = new BitInputStream(path);

        var chars = new ArrayList<Character>(10000000);

        while (true) {
            var value = bitInputStream.readBit();
            if(value==-1)break;
            chars.add((char)value);
        }

        bitInputStream.close();

        return chars;
    }
}
