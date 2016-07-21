package com.google.android.exoplayer.util;

import android.util.Pair;

public final class CodecSpecificDataUtil
{
  private static final int[] AUDIO_SPECIFIC_CONFIG_CHANNEL_COUNT_TABLE = { 0, 1, 2, 3, 4, 5, 6, 8 };
  private static final int[] AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE;
  private static final byte[] NAL_START_CODE = { 0, 0, 0, 1 };
  
  static
  {
    AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE = new int[] { 96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350 };
  }
  
  public static byte[] buildAacAudioSpecificConfig(int paramInt1, int paramInt2, int paramInt3)
  {
    return new byte[] { (byte)(paramInt1 << 3 & 0xF8 | paramInt2 >> 1 & 0x7), (byte)(paramInt2 << 7 & 0x80 | paramInt3 << 3 & 0x78) };
  }
  
  public static byte[] buildNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[NAL_START_CODE.length + paramInt2];
    System.arraycopy(NAL_START_CODE, 0, arrayOfByte, 0, NAL_START_CODE.length);
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, NAL_START_CODE.length, paramInt2);
    return arrayOfByte;
  }
  
  public static Pair<Integer, Integer> parseAacAudioSpecificConfig(byte[] paramArrayOfByte)
  {
    boolean bool = true;
    int i = paramArrayOfByte[0] >> 3 & 0x1F;
    int j;
    if ((i == 5) || (i == 29))
    {
      i = 1;
      j = (paramArrayOfByte[i] & 0x7) << 1 | paramArrayOfByte[(i + 1)] >> 7 & 0x1;
      if (j >= 13) {
        break label84;
      }
    }
    for (;;)
    {
      Assertions.checkState(bool);
      return Pair.create(Integer.valueOf(AUDIO_SPECIFIC_CONFIG_SAMPLING_RATE_TABLE[j]), Integer.valueOf(paramArrayOfByte[(i + 1)] >> 3 & 0xF));
      i = 0;
      break;
      label84:
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.CodecSpecificDataUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */