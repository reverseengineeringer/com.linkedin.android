package com.google.android.exoplayer.util;

import com.google.android.exoplayer.MediaFormat;

public final class Ac3Util
{
  private static final int[] BITRATES = { 32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640 };
  private static final int[] CHANNEL_COUNTS;
  private static final int[] FRMSIZECOD_TO_FRAME_SIZE_44_1 = { 69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393 };
  private static final int[] SAMPLE_RATES = { 48000, 44100, 32000 };
  
  static
  {
    CHANNEL_COUNTS = new int[] { 2, 1, 2, 3, 3, 4, 4, 5 };
  }
  
  public static int getBitrate(int paramInt1, int paramInt2)
  {
    return (paramInt1 * 8 * paramInt2 + 768000) / 1536000;
  }
  
  public static MediaFormat parseAnnexFAc3Format(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readUnsignedByte();
    int k = SAMPLE_RATES[((i & 0xC0) >> 6)];
    int m = paramParsableByteArray.readUnsignedByte();
    int j = CHANNEL_COUNTS[((m & 0x38) >> 3)];
    i = j;
    if ((m & 0x4) != 0) {
      i = j + 1;
    }
    return MediaFormat.createAudioFormat$7493b6ef("audio/ac3", i, k, null);
  }
  
  public static MediaFormat parseAnnexFEAc3Format(ParsableByteArray paramParsableByteArray)
  {
    paramParsableByteArray.skipBytes(2);
    int i = paramParsableByteArray.readUnsignedByte();
    int k = SAMPLE_RATES[((i & 0xC0) >> 6)];
    int m = paramParsableByteArray.readUnsignedByte();
    int j = CHANNEL_COUNTS[((m & 0xE) >> 1)];
    i = j;
    if ((m & 0x1) != 0) {
      i = j + 1;
    }
    return MediaFormat.createAudioFormat$7493b6ef("audio/eac3", i, k, null);
  }
  
  public static MediaFormat parseFrameAc3Format(ParsableBitArray paramParsableBitArray)
  {
    int i = 1;
    paramParsableBitArray.skipBits(32);
    int j = paramParsableBitArray.readBits(2);
    paramParsableBitArray.skipBits(14);
    int k = paramParsableBitArray.readBits(3);
    if (((k & 0x1) != 0) && (k != 1)) {
      paramParsableBitArray.skipBits(2);
    }
    if ((k & 0x4) != 0) {
      paramParsableBitArray.skipBits(2);
    }
    if (k == 2) {
      paramParsableBitArray.skipBits(2);
    }
    boolean bool = paramParsableBitArray.readBit();
    k = CHANNEL_COUNTS[k];
    if (bool) {}
    for (;;)
    {
      return MediaFormat.createAudioFormat$7493b6ef("audio/ac3", i + k, SAMPLE_RATES[j], null);
      i = 0;
    }
  }
  
  public static int parseFrameSize(ParsableBitArray paramParsableBitArray)
  {
    paramParsableBitArray.skipBits(32);
    int j = paramParsableBitArray.readBits(2);
    int i = paramParsableBitArray.readBits(6);
    j = SAMPLE_RATES[j];
    int k = BITRATES[(i / 2)];
    if (j == 32000) {
      return k * 6;
    }
    if (j == 44100) {
      return (FRMSIZECOD_TO_FRAME_SIZE_44_1[(i / 2)] + i % 2) * 2;
    }
    return k * 4;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.Ac3Util
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */