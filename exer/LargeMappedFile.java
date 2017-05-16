package exer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * author: cshuo
 * date: 2017/3/20
 * version: 1.0
 * description:
 */
public class LargeMappedFile {
    static int length = 0x8FFFF;

    public static void main(String[] args) throws IOException {
        MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
        for(int i=0; i<length; i++)
            out.put((byte)'x');

        System.out.println("Finish writing...");

        for(int i=length/2; i<length/2+6; i++){
            System.out.print((char)out.get(i) + " ");
        }

    }
}
