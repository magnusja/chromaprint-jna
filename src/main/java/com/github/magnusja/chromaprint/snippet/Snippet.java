package com.github.magnusja.chromaprint.snippet;

import java.io.IOException;

/**
 * Created by magnusja on 06/07/17.
 */
public interface Snippet {
    int read(short[] data, int off, int len) throws IOException;
}
