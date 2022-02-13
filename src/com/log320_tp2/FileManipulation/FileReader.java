package com.log320_tp2.FileManipulation;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class FileReader
{
    public byte[] Read(String path) throws IOException
    {
        return Files.readAllBytes(Paths.get(path));
    }
}
