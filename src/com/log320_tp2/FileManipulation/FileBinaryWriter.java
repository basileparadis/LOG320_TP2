package com.log320_tp2.FileManipulation;

import java.io.IOException;

public class FileBinaryWriter
{
    BitOutputStream bitOutputStream;

    public FileBinaryWriter(String path)
    {
        bitOutputStream = new BitOutputStream(path);
    }

    public void SingleWriteEncoded(int binary) throws IOException
    {
        bitOutputStream.writeBit(binary);
    }

    public void Close()
    {
        bitOutputStream.close();
    }
}
