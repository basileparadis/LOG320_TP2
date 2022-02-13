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

        while (buffReader.ready()) {
            // Read and print characters one by one
            // by converting into character
            chars.add((char)buffReader.read());
        }

        return chars;
    }
}
