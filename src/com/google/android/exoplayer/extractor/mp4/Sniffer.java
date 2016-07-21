package com.google.android.exoplayer.extractor.mp4;

import com.google.android.exoplayer.extractor.ExtractorInput;
import com.google.android.exoplayer.util.ParsableByteArray;
import com.google.android.exoplayer.util.Util;
import java.io.IOException;

final class Sniffer
{
  private static final int[] COMPATIBLE_BRANDS = { Util.getIntegerCodeForString("isom"), Util.getIntegerCodeForString("iso2"), Util.getIntegerCodeForString("avc1"), Util.getIntegerCodeForString("hvc1"), Util.getIntegerCodeForString("hev1"), Util.getIntegerCodeForString("mp41"), Util.getIntegerCodeForString("mp42"), Util.getIntegerCodeForString("3g2a"), Util.getIntegerCodeForString("3g2b"), Util.getIntegerCodeForString("3gr6"), Util.getIntegerCodeForString("3gs6"), Util.getIntegerCodeForString("3ge6"), Util.getIntegerCodeForString("3gg6"), Util.getIntegerCodeForString("M4V "), Util.getIntegerCodeForString("M4A "), Util.getIntegerCodeForString("f4v "), Util.getIntegerCodeForString("kddi"), Util.getIntegerCodeForString("M4VP"), Util.getIntegerCodeForString("qt  "), Util.getIntegerCodeForString("MSNV") };
  
  public static boolean sniffFragmented(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    return sniffInternal(paramExtractorInput, 4096, true);
  }
  
  private static boolean sniffInternal(ExtractorInput paramExtractorInput, int paramInt, boolean paramBoolean)
    throws IOException, InterruptedException
  {
    long l2 = paramExtractorInput.getLength();
    long l1;
    if (l2 != -1L)
    {
      l1 = l2;
      if (l2 <= paramInt) {}
    }
    else
    {
      l1 = paramInt;
    }
    int m = (int)l1;
    ParsableByteArray localParsableByteArray = new ParsableByteArray(64);
    int i = 0;
    int j = 0;
    boolean bool2 = false;
    boolean bool1 = bool2;
    int k;
    int n;
    label229:
    int i1;
    if (i < m)
    {
      paramInt = 8;
      paramExtractorInput.peekFully(data, 0, 8);
      localParsableByteArray.setPosition(0);
      l2 = localParsableByteArray.readUnsignedInt();
      k = localParsableByteArray.readInt();
      l1 = l2;
      if (l2 == 1L)
      {
        paramExtractorInput.peekFully(data, 8, 8);
        paramInt = 16;
        l1 = localParsableByteArray.readLong();
      }
      if ((l1 < paramInt) || (l1 > 2147483647L)) {
        return false;
      }
      bool1 = bool2;
      if (i + l1 <= m)
      {
        n = (int)l1 - paramInt;
        if (k == Atom.TYPE_ftyp)
        {
          if (n < 8) {
            return false;
          }
          n = (n - 8) / 4;
          paramExtractorInput.peekFully(data, 0, (n + 2) * 4);
          k = 0;
          paramInt = j;
          if (k < n + 2)
          {
            if (k == 1) {
              break label332;
            }
            i1 = localParsableByteArray.readInt();
            if (i1 >>> 8 != Util.getIntegerCodeForString("3gp")) {
              break label288;
            }
            paramInt = 1;
            label269:
            if (paramInt == 0) {
              break label332;
            }
            paramInt = 1;
          }
        }
      }
    }
    for (;;)
    {
      i = (int)(i + l1);
      j = paramInt;
      break;
      label288:
      int[] arrayOfInt = COMPATIBLE_BRANDS;
      int i2 = arrayOfInt.length;
      paramInt = 0;
      for (;;)
      {
        if (paramInt >= i2) {
          break label327;
        }
        if (arrayOfInt[paramInt] == i1)
        {
          paramInt = 1;
          break;
        }
        paramInt += 1;
      }
      label327:
      paramInt = 0;
      break label269;
      label332:
      k += 1;
      break label229;
      if (k == Atom.TYPE_moof)
      {
        bool1 = true;
        if ((j == 0) || (paramBoolean != bool1)) {
          break label387;
        }
        return true;
      }
      paramInt = j;
      if (n != 0)
      {
        paramExtractorInput.advancePeekPosition(n);
        paramInt = j;
      }
    }
    label387:
    return false;
  }
  
  public static boolean sniffUnfragmented(ExtractorInput paramExtractorInput)
    throws IOException, InterruptedException
  {
    return sniffInternal(paramExtractorInput, 128, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.mp4.Sniffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */