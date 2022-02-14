package com.log320_tp2.FileManipulation;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileTextWriter
{
    FileOutputStream fileOutputStream;

    public FileTextWriter(String path) throws FileNotFoundException {
        fileOutputStream = new FileOutputStream(path);
    }

    public void SingleWriteString(String string) throws IOException
    {
        fileOutputStream.write(string.getBytes());
    }

    public static void Write(String path, String string) throws IOException
    {
        var bufferedWriter = new BufferedWriter(new FileWriter(path, false));
        bufferedWriter.write(string);
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
