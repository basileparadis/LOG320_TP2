package com.log320_tp2.FileManipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileWriter
{
    public void Write(String path, byte[] bytes) throws IOException
    {
        Files.write(Paths.get(path), bytes);
    }
}
