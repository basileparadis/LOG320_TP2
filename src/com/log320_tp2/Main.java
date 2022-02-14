package com.log320_tp2;

import com.log320_tp2.Serialization.Deserialize;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws Exception {
        Huffman huffman = new Huffman();

        //Compress(huffman);

        //DeCompress(huffman);
    }

    public static void Compress(Huffman huffman) throws Exception {
        huffman.Compresser("C:\\Users\\david\\Downloads\\exemple.txt",
                "C:\\Users\\david\\OneDrive\\Documents\\Compressed.txt");
    }

    public static void DeCompress( Huffman huffman ) throws IOException {
        huffman.Decompresser("C:\\Users\\david\\OneDrive\\Documents\\Compressed.txt",
                "C:\\Users\\david\\OneDrive\\Documents\\HomemadeDecompressed.txt");
    }


}
