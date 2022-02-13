package com.log320_tp2.FileManipulation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileWriter2
{
    public void WriteEncoded(String path, String string) throws IOException
    {
        BitOutputStream bitOutputStream = new BitOutputStream(path);

        for (var characters: string.toCharArray())
        {
            var value = String.valueOf(characters);

            bitOutputStream.writeBit(Integer.parseInt(value));
        }

        bitOutputStream.close();
    }

    public void WriteText(String path, String string) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        fileOutputStream.write(string.getBytes());
    }

    public void WriteAppendText(String path, String string) throws IOException
    {
        var bufferedWriter = new BufferedWriter(new FileWriter(path, true));
        bufferedWriter.write(string);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
