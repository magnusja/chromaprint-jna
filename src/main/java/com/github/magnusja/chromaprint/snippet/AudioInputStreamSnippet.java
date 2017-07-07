package com.github.magnusja.chromaprint.snippet;

import javax.sound.sampled.AudioInputStream;
import java.nio.ByteOrder;

/**
 * Created by magnusja on 06/07/17.
 */
public class AudioInputStreamSnippet extends InputStreamSnippet {

    public AudioInputStreamSnippet(AudioInputStream inputStream) {
        super(inputStream, inputStream.getFormat().isBigEndian() ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
    }
}
