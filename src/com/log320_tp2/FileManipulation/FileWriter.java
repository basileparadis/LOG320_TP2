package com.log320_tp2.FileManipulation;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter
{
    public void Write(String path, byte[] bytes) throws IOException
    {
        FileOutputStream fileOutputStream = new FileOutputStream(path);

        fileOutputStream.write(bytes);
    }
}
