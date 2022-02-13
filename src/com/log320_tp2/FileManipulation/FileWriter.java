package com.log320_tp2.FileManipulation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter
{
    public void Write(String path, String string) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        fileOutputStream.write(string.getBytes(StandardCharsets.UTF_8));

        BinaryStdOut binaryStdOut = new
    }
}
