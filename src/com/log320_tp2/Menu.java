package com.log320_tp2;

import com.log320_tp2.FileManipulation.FileReader;
import com.log320_tp2.Serialization.Serialize;

import java.io.IOException;

public class Menu
{
    public void Compress(String nomFichierEntre, String nomFichierSortie) throws IOException
    {
        FileReader fileReader = new FileReader();
        Serialize serialize = new Serialize();

        serialize.CreerTableFrequences(fileReader.Read(nomFichierEntre));

    }
}
