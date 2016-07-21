package com.google.android.exoplayer.audio;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
public final class AudioCapabilities
{
  private final int maxChannelCount;
  private final int[] supportedEncodings;
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof AudioCapabilities)) {
        return false;
      }
      paramObject = (AudioCapabilities)paramObject;
    } while ((Arrays.equals(supportedEncodings, supportedEncodings)) && (maxChannelCount == maxChannelCount));
    return false;
  }
  
  public final int hashCode()
  {
    return maxChannelCount + Arrays.hashCode(supportedEncodings) * 31;
  }
  
  public final boolean supportsEncoding(int paramInt)
  {
    return Arrays.binarySearch(supportedEncodings, paramInt) >= 0;
  }
  
  public final String toString()
  {
    return "AudioCapabilities[maxChannelCount=" + maxChannelCount + ", supportedEncodings=" + Arrays.toString(supportedEncodings) + "]";
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.audio.AudioCapabilities
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */