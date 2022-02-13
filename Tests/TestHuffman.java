import com.log320_tp2.Controlleur;
import com.log320_tp2.Huffman;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;


public class TestHuffman {

    @Test
    @DisplayName("Compress one short single string and validate its output")
    public void testSmallString() throws Exception
    {
        String initialString = "ETS";

        String compressedText = Controlleur.Compress(initialString);
        String decompressedText = Controlleur.Decompress(compressedText);

        Assert.assertEquals(initialString, decompressedText);
    }

    @Test
    @DisplayName("Compress text file and validate the decompression afterwards")
    public void testTxtFile() throws Exception
    {
        File fileInput = new File("fileInput.txt");
        File fileOutput = new File("fileOutput.txt");
        String data = generateLongString();
        Huffman huff = new Huffman();
        try
        {
            FileOutputStream fos = new FileOutputStream(fileInput);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            byte[] bytes = data.getBytes();
            bos.write(bytes);
            bos.close();
            fos.close();
            huff.Compresser(fileInput.getAbsolutePath(), fileOutput.getAbsolutePath());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //AssertTrue(IOUtils.contentEquals(fileInput, fileOutput));

    }

    @Test
    @DisplayName("Compress one long single string and validate its output")
    public void testLongString() throws Exception
    {

        String generatedString = generateLongString();
        String compressedText = Controlleur.Compress(generatedString);
        String decompressedText = Controlleur.Decompress(compressedText);

        Assert.assertEquals(generatedString, decompressedText);
    }

    public String generateLongString()
    {
        byte[] array = new byte[9999];
        return new String(array, StandardCharsets.UTF_8);
    }
}
