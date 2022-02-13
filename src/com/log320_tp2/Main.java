package com.log320_tp2;

public class Main
{
    public static void main(String[] args) throws Exception {
        Huffman huffman = new Huffman();

        huffman.Compresser("/Users/basileparadis/Downloads/exemple.txt",
                "/Users/basileparadis/Downloads/Compressed.txt");

        huffman.Decompresser("/Users/basileparadis/Downloads/Compressed.txt",
                "/Users/basileparadis/Downloads/exemple2.txt");
    }
}
