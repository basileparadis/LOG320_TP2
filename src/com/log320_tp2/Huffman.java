package com.log320_tp2;

import java.io.IOException;

public class Huffman{

    // Ne pas changer ces fonctions, elles seront utilisées pour tester votre programme
    public void Compresser(String nomFichierEntre, String nomFichierSortie) throws Exception {
        Controlleur.Compress(nomFichierEntre, nomFichierSortie);
    }

    public void Decompresser(String nomFichierEntre, String nomFichierSortie) throws IOException {
        Controlleur.Decompress(nomFichierEntre, nomFichierSortie);
    }

}
