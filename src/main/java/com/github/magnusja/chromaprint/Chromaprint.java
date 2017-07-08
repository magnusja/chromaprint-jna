package com.github.magnusja.chromaprint;

import com.sun.jna.ptr.PointerByReference;
import org.acoustid.chromaprint.jna.ChromaprintLibrary;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

/**
 * Created by magnusja on 06/07/17.
 */
public class Chromaprint {
    private final AudioInputStream inputStream;

    public Chromaprint(AudioInputStream inputStream) {
        AudioFormat format = inputStream.getFormat();
        format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                format.getSampleRate(),
                format.getSampleSizeInBits(),
                format.getChannels(),
                format.getFrameSize(),
                format.getFrameRate(),
                format.isBigEndian());
        this.inputStream = AudioSystem.getAudioInputStream(format, inputStream);
    }

    public Fingerprint calculateFingerPrint() throws IOException {
        AudioFormat format = inputStream.getFormat();
        PointerByReference context = ChromaprintLibrary.INSTANCE.chromaprint_new(
                ChromaprintLibrary.ChromaprintAlgorithm.CHROMAPRINT_ALGORITHM_DEFAULT);

        int result = ChromaprintLibrary.INSTANCE.chromaprint_start(context,
                (int) format.getSampleRate(), format.getChannels());

        assert result == 1;

        byte[] byteArrayBuffer = new byte[4096];
        ShortBuffer shortBuffer = ByteBuffer.wrap(byteArrayBuffer, 0, byteArrayBuffer.length)
                .order(format.isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN)
                .asShortBuffer();
        short[] shortArrayBuffer = new short[byteArrayBuffer.length / 2];
        int read;
        while((read = inputStream.read(byteArrayBuffer, 0, byteArrayBuffer.length)) != -1) {
            shortBuffer.clear();
            shortBuffer.limit(read / 2);
            shortBuffer.get(shortArrayBuffer, 0, read / 2);
            result = ChromaprintLibrary.INSTANCE.chromaprint_feed(context, shortArrayBuffer, read / 2);
            assert result == 1;
        }


        result = ChromaprintLibrary.INSTANCE.chromaprint_finish(context);
        assert result == 1;

        return new Fingerprint(context);
    }
}
