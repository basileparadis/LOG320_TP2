package com.log320_tp2;

public class Main
{
    public static void main(String[] args) throws Exception {
        Huffman huffman = new Huffman();

        huffman.Compresser("C:\\Users\\david\\Downloads\\exemple.txt",
                "C:\\Users\\david\\OneDrive\\Documents\\Compressed.txt");

        huffman.Decompresser("C:\\Users\\david\\OneDrive\\Documents\\Compressed.txt",
                "C:\\Users\\david\\OneDrive\\Documents\\HomemadeDecompressed.txt");
    }
}
