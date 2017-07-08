package org.acoustid.chromaprint.jna;

import com.sun.jna.ptr.PointerByReference;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by magnusja on 06/07/17.
 */
public class ChromaprintLibraryTest {

    private PointerByReference context;

    @Before
    public void setUp() throws Exception {
        context = ChromaprintLibrary.INSTANCE.chromaprint_new(
                ChromaprintLibrary.ChromaprintAlgorithm.CHROMAPRINT_ALGORITHM_DEFAULT);
    }

    @Test
    public void chromaprint_new() throws Exception {
        Assert.assertNotNull(context.getPointer());
    }

    @Test
    public void chromaprint_start() throws Exception {
        int result = ChromaprintLibrary.INSTANCE.chromaprint_start(context, 44100, 1);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void chromaprint_feed() throws Exception {
        ChromaprintLibrary.INSTANCE.chromaprint_start(context, 44100, 1);
        short[] data = {0, 1, 2, 3};
        int result = ChromaprintLibrary.INSTANCE.chromaprint_feed(context, data, data.length);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void chromaprint_finish() throws Exception {
        ChromaprintLibrary.INSTANCE.chromaprint_start(context, 44100, 1);
        short[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ChromaprintLibrary.INSTANCE.chromaprint_feed(context, data, data.length);
        int result = ChromaprintLibrary.INSTANCE.chromaprint_finish(context);
        Assert.assertEquals(result, 1);
    }

    @Test
    public void chromaprint_get_fingerprint() throws Exception {
        ChromaprintLibrary.INSTANCE.chromaprint_start(context, 44100, 1);
        short[] data = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ChromaprintLibrary.INSTANCE.chromaprint_feed(context, data, data.length);
        ChromaprintLibrary.INSTANCE.chromaprint_finish(context);

        final PointerByReference ref = new PointerByReference();
        ChromaprintLibrary.INSTANCE.chromaprint_get_fingerprint(context, ref);
        System.out.println(ref.getValue().getString(0));
    }

    @After
    public void tearDown() throws Exception {
        ChromaprintLibrary.INSTANCE.chromaprint_free(context);
    }
}