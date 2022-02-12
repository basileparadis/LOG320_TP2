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

    public ArrayList<String> ReadAsString(String path) throws IOException
    {
        var spaceChars = new String[] {"\n", " ", "?", "!", ";", ",","\t"};

        var bytes = Files.readAllBytes(Paths.get(path));

        StringBuilder stringBuilder = new StringBuilder();

        ArrayList<String> strings = new ArrayList<>();

        for (var bite: bytes )
        {
            var character = String.valueOf((char)bite);

            if(Arrays.stream(spaceChars).anyMatch(string -> string.equals(character)))
            {
                strings.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
            else
            {
                stringBuilder.append(character);
            }
        }

        return strings;
    }
}
