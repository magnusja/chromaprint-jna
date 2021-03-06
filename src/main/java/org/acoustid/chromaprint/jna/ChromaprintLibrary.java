package org.acoustid.chromaprint.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import com.sun.jna.ptr.ShortByReference;
import java.nio.IntBuffer;
/**
 * JNA Wrapper for library <b>chromaprint</b><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public interface ChromaprintLibrary extends Library {
	public static final String JNA_LIBRARY_NAME = "chromaprint";
	public static final NativeLibrary JNA_NATIVE_LIB = NativeLibrary.getInstance(ChromaprintLibrary.JNA_LIBRARY_NAME);
	public static final ChromaprintLibrary INSTANCE = (ChromaprintLibrary)Native.loadLibrary(ChromaprintLibrary.JNA_LIBRARY_NAME, ChromaprintLibrary.class);
	/**
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:71</i><br>
	 * enum values
	 */
	public static interface ChromaprintAlgorithm {
		/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:72</i> */
		public static final int CHROMAPRINT_ALGORITHM_TEST1 = 0;
		/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:73</i> */
		public static final int CHROMAPRINT_ALGORITHM_TEST2 = 1;
		/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:74</i> */
		public static final int CHROMAPRINT_ALGORITHM_TEST3 = 2;
		/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:75</i> */
		public static final int CHROMAPRINT_ALGORITHM_TEST4 = 3;
		/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:76</i> */
		public static final int CHROMAPRINT_ALGORITHM_TEST5 = 4;
		/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:77</i> */
		public static final int CHROMAPRINT_ALGORITHM_DEFAULT = (int)ChromaprintLibrary.ChromaprintAlgorithm.CHROMAPRINT_ALGORITHM_TEST2;
	};
	/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h</i> */
	public static final int CHROMAPRINT_VERSION_MAJOR = (int)1;
	/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h</i> */
	public static final int CHROMAPRINT_VERSION_MINOR = (int)4;
	/** <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h</i> */
	public static final int CHROMAPRINT_VERSION_PATCH = (int)2;
	/**
	 * Return the version number of Chromaprint.<br>
	 * Original signature : <code>char* chromaprint_get_version()</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:83</i>
	 */
	Pointer chromaprint_get_version();
	/**
	 * Allocate and initialize the Chromaprint context.<br>
	 * Note that when Chromaprint is compiled with FFTW, this function is<br>
	 * not reentrant and you need to call it only from one thread at a time.<br>
	 * This is not a problem when using FFmpeg or vDSP.<br>
	 * @param algorithm the fingerprint algorithm version you want to use, or<br>
	 * 	CHROMAPRINT_ALGORITHM_DEFAULT for the default algorithm<br>
	 * @return ctx Chromaprint context pointer<br>
	 * Original signature : <code>ChromaprintContext* chromaprint_new(int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:97</i>
	 */
	PointerByReference chromaprint_new(int algorithm);
	/**
	 * Deallocate the Chromaprint context.<br>
	 * Note that when Chromaprint is compiled with FFTW, this function is<br>
	 * not reentrant and you need to call it only from one thread at a time.<br>
	 * This is not a problem when using FFmpeg or vDSP.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * Original signature : <code>void chromaprint_free(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:108</i>
	 */
	void chromaprint_free(PointerByReference ctx);
	/**
	 * Return the fingerprint algorithm this context is configured to use.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return current algorithm version<br>
	 * Original signature : <code>int chromaprint_get_algorithm(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:115</i>
	 */
	int chromaprint_get_algorithm(PointerByReference ctx);
	/**
	 * Set a configuration option for the selected fingerprint algorithm.<br>
	 * DO NOT USE THIS FUNCTION IF YOU ARE PLANNING TO USE<br>
	 * THE GENERATED FINGERPRINTS WITH THE ACOUSTID SERVICE.<br>
	 * Possible options:<br>
	 *  - silence_threshold: threshold for detecting silence, 0-32767<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[in] name option name<br>
	 * @param[in] value option value<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_set_option(ChromaprintContext*, const char*, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:132</i>
	 */
	int chromaprint_set_option(PointerByReference ctx, String name, int value);
	/**
	 * Set a configuration option for the selected fingerprint algorithm.<br>
	 * DO NOT USE THIS FUNCTION IF YOU ARE PLANNING TO USE<br>
	 * THE GENERATED FINGERPRINTS WITH THE ACOUSTID SERVICE.<br>
	 * Possible options:<br>
	 *  - silence_threshold: threshold for detecting silence, 0-32767<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[in] name option name<br>
	 * @param[in] value option value<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_set_option(ChromaprintContext*, const char*, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:132</i>
	 */
	int chromaprint_set_option(PointerByReference ctx, Pointer name, int value);
	/**
	 * Get the number of channels that is internally used for fingerprinting.<br>
	 * @note You normally don't need this. Just set the audio's actual number of channels<br>
	 * when calling chromaprint_start() and everything will work. This is only used for<br>
	 * certain optimized cases to control the audio source.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return number of channels<br>
	 * Original signature : <code>int chromaprint_get_num_channels(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:145</i>
	 */
	int chromaprint_get_num_channels(PointerByReference ctx);
	/**
	 * Get the sampling rate that is internally used for fingerprinting.<br>
	 * @note You normally don't need this. Just set the audio's actual number of channels<br>
	 * when calling chromaprint_start() and everything will work. This is only used for<br>
	 * certain optimized cases to control the audio source.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return sampling rate<br>
	 * Original signature : <code>int chromaprint_get_sample_rate(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:158</i>
	 */
	int chromaprint_get_sample_rate(PointerByReference ctx);
	/**
	 * Get the duration of one item in the raw fingerprint in samples.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return duration in samples<br>
	 * Original signature : <code>int chromaprint_get_item_duration(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:167</i>
	 */
	int chromaprint_get_item_duration(PointerByReference ctx);
	/**
	 * Get the duration of one item in the raw fingerprint in milliseconds.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return duration in milliseconds<br>
	 * Original signature : <code>int chromaprint_get_item_duration_ms(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:176</i>
	 */
	int chromaprint_get_item_duration_ms(PointerByReference ctx);
	/**
	 * Get the duration of internal buffers that the fingerprinting algorithm uses.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return duration in samples<br>
	 * Original signature : <code>int chromaprint_get_delay(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:185</i>
	 */
	int chromaprint_get_delay(PointerByReference ctx);
	/**
	 * Get the duration of internal buffers that the fingerprinting algorithm uses.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return duration in milliseconds<br>
	 * Original signature : <code>int chromaprint_get_delay_ms(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:194</i>
	 */
	int chromaprint_get_delay_ms(PointerByReference ctx);
	/**
	 * Restart the computation of a fingerprint with a new audio stream.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[in] sample_rate sample rate of the audio stream (in Hz)<br>
	 * @param[in] num_channels numbers of channels in the audio stream (1 or 2)<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_start(ChromaprintContext*, int, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:205</i>
	 */
	int chromaprint_start(PointerByReference ctx, int sample_rate, int num_channels);
	/**
	 * Send audio data to the fingerprint calculator.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[in] data raw audio data, should point to an array of 16-bit signed<br>
	 *          integers in native byte-order<br>
	 * @param[in] size size of the data buffer (in samples)<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_feed(ChromaprintContext*, const int16_t*, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:217</i>
	 */
	int chromaprint_feed(PointerByReference ctx, short data[], int size);
	/**
	 * Send audio data to the fingerprint calculator.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[in] data raw audio data, should point to an array of 16-bit signed<br>
	 *          integers in native byte-order<br>
	 * @param[in] size size of the data buffer (in samples)<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_feed(ChromaprintContext*, const int16_t*, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:217</i>
	 */
	int chromaprint_feed(PointerByReference ctx, ShortByReference data, int size);
	/**
	 * Process any remaining buffered audio data.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_finish(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:226</i>
	 */
	int chromaprint_finish(PointerByReference ctx);
	/**
	 * Return the calculated fingerprint as a compressed string.<br>
	 * The caller is responsible for freeing the returned pointer using<br>
	 * chromaprint_dealloc().<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] fingerprint pointer to a pointer, where a pointer to the allocated array<br>
	 *                 will be stored<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_fingerprint(ChromaprintContext*, char**)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:240</i>
	 */
	int chromaprint_get_fingerprint(PointerByReference ctx, PointerByReference fingerprint);
	/**
	 * Return the calculated fingerprint as an array of 32-bit integers.<br>
	 * The caller is responsible for freeing the returned pointer using<br>
	 * chromaprint_dealloc().<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] fingerprint pointer to a pointer, where a pointer to the allocated array<br>
	 *                 will be stored<br>
	 * @param[out] size number of items in the returned raw fingerprint<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_raw_fingerprint(ChromaprintContext*, uint32_t**, int*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:255</i>
	 */
	int chromaprint_get_raw_fingerprint(PointerByReference ctx, PointerByReference fingerprint, IntBuffer size);
	/**
	 * Return the calculated fingerprint as an array of 32-bit integers.<br>
	 * The caller is responsible for freeing the returned pointer using<br>
	 * chromaprint_dealloc().<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] fingerprint pointer to a pointer, where a pointer to the allocated array<br>
	 *                 will be stored<br>
	 * @param[out] size number of items in the returned raw fingerprint<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_raw_fingerprint(ChromaprintContext*, uint32_t**, int*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:255</i>
	 */
	int chromaprint_get_raw_fingerprint(PointerByReference ctx, PointerByReference fingerprint, IntByReference size);
	/**
	 * Return the length of the current raw fingerprint.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] size number of items in the current raw fingerprint<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_raw_fingerprint_size(ChromaprintContext*, int*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:265</i>
	 */
	int chromaprint_get_raw_fingerprint_size(PointerByReference ctx, IntBuffer size);
	/**
	 * Return the length of the current raw fingerprint.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] size number of items in the current raw fingerprint<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_raw_fingerprint_size(ChromaprintContext*, int*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:265</i>
	 */
	int chromaprint_get_raw_fingerprint_size(PointerByReference ctx, IntByReference size);
	/**
	 * Return 32-bit hash of the calculated fingerprint.<br>
	 * See chromaprint_hash_fingerprint() for details on how to use the hash.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] hash pointer to a 32-bit integer where the hash will be stored<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_fingerprint_hash(ChromaprintContext*, uint32_t*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:277</i>
	 */
	int chromaprint_get_fingerprint_hash(PointerByReference ctx, IntBuffer hash);
	/**
	 * Return 32-bit hash of the calculated fingerprint.<br>
	 * See chromaprint_hash_fingerprint() for details on how to use the hash.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @param[out] hash pointer to a 32-bit integer where the hash will be stored<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_get_fingerprint_hash(ChromaprintContext*, uint32_t*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:277</i>
	 */
	int chromaprint_get_fingerprint_hash(PointerByReference ctx, IntByReference hash);
	/**
	 * Clear the current fingerprint, but allow more data to be processed.<br>
	 * This is useful if you are processing a long stream and want to many<br>
	 * smaller fingerprints, instead of waiting for the entire stream to be<br>
	 * processed.<br>
	 * @param[in] ctx Chromaprint context pointer<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_clear_fingerprint(ChromaprintContext*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:290</i>
	 */
	int chromaprint_clear_fingerprint(PointerByReference ctx);
	/**
	 * Compress and optionally base64-encode a raw fingerprint<br>
	 * The caller is responsible for freeing the returned pointer using<br>
	 * chromaprint_dealloc().<br>
	 * @param[in] fp pointer to an array of 32-bit integers representing the raw<br>
	 *        fingerprint to be encoded<br>
	 * @param[in] size number of items in the raw fingerprint<br>
	 * @param[in] algorithm Chromaprint algorithm version which was used to generate the<br>
	 *               raw fingerprint<br>
	 * @param[out] encoded_fp pointer to a pointer, where the encoded fingerprint will be<br>
	 *                stored<br>
	 * @param[out] encoded_size size of the encoded fingerprint in bytes<br>
	 * @param[in] base64 Whether to return binary data or base64-encoded ASCII data. The<br>
	 *            compressed fingerprint will be encoded using base64 with the<br>
	 *            URL-safe scheme if you set this parameter to 1. It will return<br>
	 *            binary data if it's 0.<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_encode_fingerprint(const uint32_t*, int, int, char**, int*, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:313</i>
	 */
	int chromaprint_encode_fingerprint(int fp[], int size, int algorithm, PointerByReference encoded_fp, IntBuffer encoded_size, int base64);
	/**
	 * Uncompress and optionally base64-decode an encoded fingerprint<br>
	 * The caller is responsible for freeing the returned pointer using<br>
	 * chromaprint_dealloc().<br>
	 * @param[in] encoded_fp pointer to an encoded fingerprint<br>
	 * @param[in] encoded_size size of the encoded fingerprint in bytes<br>
	 * @param[out] fp pointer to a pointer, where the decoded raw fingerprint (array<br>
	 *        of 32-bit integers) will be stored<br>
	 * @param[out] size Number of items in the returned raw fingerprint<br>
	 * @param[out] algorithm Chromaprint algorithm version which was used to generate the<br>
	 *               raw fingerprint<br>
	 * @param[in] base64 Whether the encoded_fp parameter contains binary data or<br>
	 *            base64-encoded ASCII data. If 1, it will base64-decode the data<br>
	 *            before uncompressing the fingerprint.<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_decode_fingerprint(const char*, int, uint32_t**, int*, int*, int)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:334</i>
	 */
	int chromaprint_decode_fingerprint(String encoded_fp, int encoded_size, PointerByReference fp, IntBuffer size, IntBuffer algorithm, int base64);
	/**
	 * Generate a single 32-bit hash for a raw fingerprint.<br>
	 * If two fingerprints are similar, their hashes generated by this function<br>
	 * will also be similar. If they are significantly different, their hashes<br>
	 * will most likely be significantly different as well, but you can't rely<br>
	 * on that.<br>
	 * You compare two hashes by counting the bits in which they differ. Normally<br>
	 * that would be something like POPCNT(hash1 XOR hash2), which returns a<br>
	 * number between 0 and 32. Anthing above 15 means the hashes are<br>
	 * completely different.<br>
	 * @param[in] fp pointer to an array of 32-bit integers representing the raw<br>
	 *        fingerprint to be hashed<br>
	 * @param[in] size number of items in the raw fingerprint<br>
	 * @param[out] hash pointer to a 32-bit integer where the hash will be stored<br>
	 * @return 0 on error, 1 on success<br>
	 * Original signature : <code>int chromaprint_hash_fingerprint(const uint32_t*, int, uint32_t*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:356</i>
	 */
	int chromaprint_hash_fingerprint(int fp[], int size, IntBuffer hash);
	/**
	 * Free memory allocated by any function from the Chromaprint API.<br>
	 * @param ptr pointer to be deallocated<br>
	 * Original signature : <code>void chromaprint_dealloc(void*)</code><br>
	 * <i>native declaration : Downloads/chromaprint-1.4.2/src/chromaprint.h:363</i>
	 */
	void chromaprint_dealloc(Pointer ptr);
	public static class ChromaprintContext extends PointerType {
		public ChromaprintContext(Pointer address) {
			super(address);
		}
		public ChromaprintContext() {
			super();
		}
	};
}
