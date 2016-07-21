package com.google.android.exoplayer;

import android.media.MediaCodec.CryptoInfo;
import com.google.android.exoplayer.util.Util;

public final class CryptoInfo
{
  public final MediaCodec.CryptoInfo frameworkCryptoInfo;
  public byte[] iv;
  public byte[] key;
  public int mode;
  public int[] numBytesOfClearData;
  public int[] numBytesOfEncryptedData;
  public int numSubSamples;
  
  public CryptoInfo()
  {
    if (Util.SDK_INT >= 16) {}
    for (MediaCodec.CryptoInfo localCryptoInfo = new MediaCodec.CryptoInfo();; localCryptoInfo = null)
    {
      frameworkCryptoInfo = localCryptoInfo;
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.CryptoInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */