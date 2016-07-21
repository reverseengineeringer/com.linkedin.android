package com.google.android.exoplayer.extractor.ts;

import com.google.android.exoplayer.util.Assertions;
import java.util.Arrays;

final class NalUnitTargetBuffer
{
  boolean isCompleted;
  private boolean isFilling;
  public byte[] nalData;
  public int nalLength;
  private final int targetType;
  
  public NalUnitTargetBuffer(int paramInt)
  {
    targetType = paramInt;
    nalData = new byte[''];
    nalData[2] = 1;
  }
  
  public final void appendToNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!isFilling) {
      return;
    }
    paramInt2 -= paramInt1;
    if (nalData.length < nalLength + paramInt2) {
      nalData = Arrays.copyOf(nalData, (nalLength + paramInt2) * 2);
    }
    System.arraycopy(paramArrayOfByte, paramInt1, nalData, nalLength, paramInt2);
    nalLength += paramInt2;
  }
  
  public final boolean endNalUnit(int paramInt)
  {
    if (!isFilling) {
      return false;
    }
    nalLength -= paramInt;
    isFilling = false;
    isCompleted = true;
    return true;
  }
  
  public final void reset()
  {
    isFilling = false;
    isCompleted = false;
  }
  
  public final void startNalUnit(int paramInt)
  {
    boolean bool2 = true;
    if (!isFilling)
    {
      bool1 = true;
      Assertions.checkState(bool1);
      if (paramInt != targetType) {
        break label53;
      }
    }
    label53:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      isFilling = bool1;
      if (isFilling)
      {
        nalLength = 3;
        isCompleted = false;
      }
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ts.NalUnitTargetBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */