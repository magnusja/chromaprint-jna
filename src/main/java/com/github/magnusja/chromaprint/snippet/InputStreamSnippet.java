package com.github.magnusja.chromaprint.snippet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Created by magnusja on 06/07/17.
 */
public class InputStreamSnippet implements Snippet {
    private InputStream inputSteam;
    private ByteOrder byteOrder;

    public InputStreamSnippet(InputStream inputSteam, ByteOrder byteOrder) {
        this.inputSteam = inputSteam;
        this.byteOrder = byteOrder;
    }

    public InputStreamSnippet(InputStream inputSteam) {
        this(inputSteam, ByteOrder.LITTLE_ENDIAN);
    }

    public int read(short[] data, int off, int len) throws IOException {
        byte[] buffer = new byte[len * 2];
        int read = inputSteam.read(buffer, 0, buffer.length);
        if(read == -1) {
            return -1;
        }

        ByteBuffer.wrap(buffer)
                .order(byteOrder)
                .asShortBuffer()
                .get(data, off, read / 2);

        return read / 2;
    }
}
