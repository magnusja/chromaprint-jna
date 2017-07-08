package com.github.magnusja.chromaprint;

import com.sun.jna.ptr.PointerByReference;
import org.acoustid.chromaprint.jna.ChromaprintLibrary;

/**
 * Created by magnusja on 06/07/17.
 */
public class Fingerprint {
    PointerByReference context;

    Fingerprint(PointerByReference context) {
        this.context = context;
    }

    public String getString() {
        final PointerByReference ref = new PointerByReference();
        ChromaprintLibrary.INSTANCE.chromaprint_get_fingerprint(context, ref);
        return ref.getValue().getString(0);
    }
}
