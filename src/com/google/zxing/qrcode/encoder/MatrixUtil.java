package com.google.zxing.qrcode.encoder;

import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Version;

final class MatrixUtil
{
  private static final int[][] POSITION_ADJUSTMENT_PATTERN;
  private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
  private static final int[][] POSITION_DETECTION_PATTERN;
  private static final int[][] TYPE_INFO_COORDINATES;
  
  static
  {
    int[] arrayOfInt1 = { 1, 0, 0, 0, 0, 0, 1 };
    int[] arrayOfInt2 = { 1, 0, 1, 1, 1, 0, 1 };
    int[] arrayOfInt3 = { 1, 0, 1, 1, 1, 0, 1 };
    POSITION_DETECTION_PATTERN = new int[][] { { 1, 1, 1, 1, 1, 1, 1 }, arrayOfInt1, { 1, 0, 1, 1, 1, 0, 1 }, arrayOfInt2, arrayOfInt3, { 1, 0, 0, 0, 0, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1 } };
    arrayOfInt1 = new int[] { 1, 1, 1, 1, 1 };
    arrayOfInt2 = new int[] { 1, 0, 1, 0, 1 };
    arrayOfInt3 = new int[] { 1, 1, 1, 1, 1 };
    POSITION_ADJUSTMENT_PATTERN = new int[][] { arrayOfInt1, { 1, 0, 0, 0, 1 }, arrayOfInt2, { 1, 0, 0, 0, 1 }, arrayOfInt3 };
    arrayOfInt1 = new int[] { -1, -1, -1, -1, -1, -1, -1 };
    arrayOfInt2 = new int[] { 6, 18, -1, -1, -1, -1, -1 };
    arrayOfInt3 = new int[] { 6, 22, -1, -1, -1, -1, -1 };
    int[] arrayOfInt4 = { 6, 26, -1, -1, -1, -1, -1 };
    int[] arrayOfInt5 = { 6, 30, -1, -1, -1, -1, -1 };
    int[] arrayOfInt6 = { 6, 34, -1, -1, -1, -1, -1 };
    int[] arrayOfInt7 = { 6, 22, 38, -1, -1, -1, -1 };
    int[] arrayOfInt8 = { 6, 26, 46, -1, -1, -1, -1 };
    int[] arrayOfInt9 = { 6, 30, 54, -1, -1, -1, -1 };
    int[] arrayOfInt10 = { 6, 32, 58, -1, -1, -1, -1 };
    int[] arrayOfInt11 = { 6, 26, 46, 66, -1, -1, -1 };
    int[] arrayOfInt12 = { 6, 26, 48, 70, -1, -1, -1 };
    int[] arrayOfInt13 = { 6, 30, 54, 78, -1, -1, -1 };
    int[] arrayOfInt14 = { 6, 30, 56, 82, -1, -1, -1 };
    int[] arrayOfInt15 = { 6, 34, 62, 90, -1, -1, -1 };
    int[] arrayOfInt16 = { 6, 32, 58, 84, 110, -1, -1 };
    int[] arrayOfInt17 = { 6, 34, 62, 90, 118, -1, -1 };
    int[] arrayOfInt18 = { 6, 26, 50, 74, 98, 122, -1 };
    int[] arrayOfInt19 = { 6, 30, 54, 78, 102, 126, -1 };
    int[] arrayOfInt20 = { 6, 26, 52, 78, 104, 130, -1 };
    int[] arrayOfInt21 = { 6, 30, 56, 82, 108, 134, -1 };
    int[] arrayOfInt22 = { 6, 34, 60, 86, 112, 138, -1 };
    int[] arrayOfInt23 = { 6, 30, 58, 86, 114, 142, -1 };
    int[] arrayOfInt24 = { 6, 30, 54, 78, 102, 126, 150 };
    int[] arrayOfInt25 = { 6, 28, 54, 80, 106, 132, 158 };
    int[] arrayOfInt26 = { 6, 30, 58, 86, 114, 142, 170 };
    POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 6, 24, 42, -1, -1, -1, -1 }, arrayOfInt8, { 6, 28, 50, -1, -1, -1, -1 }, arrayOfInt9, arrayOfInt10, { 6, 34, 62, -1, -1, -1, -1 }, arrayOfInt11, arrayOfInt12, { 6, 26, 50, 74, -1, -1, -1 }, arrayOfInt13, arrayOfInt14, { 6, 30, 58, 86, -1, -1, -1 }, arrayOfInt15, { 6, 28, 50, 72, 94, -1, -1 }, { 6, 26, 50, 74, 98, -1, -1 }, { 6, 30, 54, 78, 102, -1, -1 }, { 6, 28, 54, 80, 106, -1, -1 }, arrayOfInt16, { 6, 30, 58, 86, 114, -1, -1 }, arrayOfInt17, arrayOfInt18, arrayOfInt19, arrayOfInt20, arrayOfInt21, arrayOfInt22, arrayOfInt23, { 6, 34, 62, 90, 118, 146, -1 }, arrayOfInt24, { 6, 24, 50, 76, 102, 128, 154 }, arrayOfInt25, { 6, 32, 58, 84, 110, 136, 162 }, { 6, 26, 54, 82, 110, 138, 166 }, arrayOfInt26 };
    arrayOfInt1 = new int[] { 8, 1 };
    arrayOfInt2 = new int[] { 8, 3 };
    arrayOfInt3 = new int[] { 8, 4 };
    arrayOfInt4 = new int[] { 8, 5 };
    arrayOfInt5 = new int[] { 8, 8 };
    arrayOfInt6 = new int[] { 7, 8 };
    arrayOfInt7 = new int[] { 3, 8 };
    arrayOfInt8 = new int[] { 0, 8 };
    TYPE_INFO_COORDINATES = new int[][] { { 8, 0 }, arrayOfInt1, { 8, 2 }, arrayOfInt2, arrayOfInt3, arrayOfInt4, { 8, 7 }, arrayOfInt5, arrayOfInt6, { 5, 8 }, { 4, 8 }, arrayOfInt7, { 2, 8 }, { 1, 8 }, arrayOfInt8 };
  }
  
  static void buildMatrix(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = 0;
    int j;
    while (i < height)
    {
      j = 0;
      while (j < width)
      {
        bytes[i][j] = -1;
        j += 1;
      }
      i += 1;
    }
    i = POSITION_DETECTION_PATTERN[0].length;
    embedPositionDetectionPattern(0, 0, paramByteMatrix);
    embedPositionDetectionPattern(width - i, 0, paramByteMatrix);
    embedPositionDetectionPattern(0, width - i, paramByteMatrix);
    embedHorizontalSeparationPattern(0, 7, paramByteMatrix);
    embedHorizontalSeparationPattern(width - 8, 7, paramByteMatrix);
    embedHorizontalSeparationPattern(0, width - 8, paramByteMatrix);
    embedVerticalSeparationPattern(7, 0, paramByteMatrix);
    embedVerticalSeparationPattern(height - 7 - 1, 0, paramByteMatrix);
    embedVerticalSeparationPattern(7, height - 7, paramByteMatrix);
    if (paramByteMatrix.get(8, height - 8) == 0) {
      throw new WriterException();
    }
    paramByteMatrix.set(8, height - 8, 1);
    if (versionNumber >= 2)
    {
      i = versionNumber - 1;
      localObject = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i];
      int n = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE[i].length;
      i = 0;
      while (i < n)
      {
        j = 0;
        while (j < n)
        {
          int i1 = localObject[i];
          int i2 = localObject[j];
          if ((i2 != -1) && (i1 != -1) && (isEmpty(paramByteMatrix.get(i2, i1))))
          {
            int k = 0;
            while (k < 5)
            {
              int m = 0;
              while (m < 5)
              {
                paramByteMatrix.set(i2 - 2 + m, i1 - 2 + k, POSITION_ADJUSTMENT_PATTERN[k][m]);
                m += 1;
              }
              k += 1;
            }
          }
          j += 1;
        }
        i += 1;
      }
    }
    i = 8;
    while (i < width - 8)
    {
      j = (i + 1) % 2;
      if (isEmpty(paramByteMatrix.get(i, 6))) {
        paramByteMatrix.set(i, 6, j);
      }
      if (isEmpty(paramByteMatrix.get(6, i))) {
        paramByteMatrix.set(6, i, j);
      }
      i += 1;
    }
    Object localObject = new BitArray();
    if ((paramInt >= 0) && (paramInt < 8)) {}
    for (i = 1; i == 0; i = 0) {
      throw new WriterException("Invalid mask pattern");
    }
    i = bits << 3 | paramInt;
    ((BitArray)localObject).appendBits(i, 5);
    ((BitArray)localObject).appendBits(calculateBCHCode(i, 1335), 10);
    paramErrorCorrectionLevel = new BitArray();
    paramErrorCorrectionLevel.appendBits(21522, 15);
    if (bits.length != bits.length) {
      throw new IllegalArgumentException("Sizes don't match");
    }
    i = 0;
    while (i < bits.length)
    {
      int[] arrayOfInt = bits;
      arrayOfInt[i] ^= bits[i];
      i += 1;
    }
    if (size != 15) {
      throw new WriterException("should not happen but we got: " + size);
    }
    i = 0;
    if (i < size)
    {
      boolean bool = ((BitArray)localObject).get(size - 1 - i);
      paramByteMatrix.set(TYPE_INFO_COORDINATES[i][0], TYPE_INFO_COORDINATES[i][1], bool);
      if (i < 8) {
        paramByteMatrix.set(width - i - 1, 8, bool);
      }
      for (;;)
      {
        i += 1;
        break;
        paramByteMatrix.set(8, height - 7 + (i - 8), bool);
      }
    }
    maybeEmbedVersionInfo(paramVersion, paramByteMatrix);
    embedDataBits(paramBitArray, paramInt, paramByteMatrix);
  }
  
  private static int calculateBCHCode(int paramInt1, int paramInt2)
  {
    int i = findMSBSet(paramInt2);
    paramInt1 <<= i - 1;
    while (findMSBSet(paramInt1) >= i) {
      paramInt1 ^= paramInt2 << findMSBSet(paramInt1) - i;
    }
    return paramInt1;
  }
  
  private static void embedDataBits(BitArray paramBitArray, int paramInt, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i1 = 0;
    int k = -1;
    int j = width - 1;
    int i = height - 1;
    while (j > 0)
    {
      int i2 = i1;
      int m = j;
      int n = i;
      if (j == 6)
      {
        m = j - 1;
        n = i;
      }
      for (i2 = i1; (n >= 0) && (n < height); i2 = j)
      {
        i1 = 0;
        j = i2;
        if (i1 < 2)
        {
          i2 = m - i1;
          i = j;
          if (isEmpty(paramByteMatrix.get(i2, n)))
          {
            boolean bool1;
            if (j < size)
            {
              bool1 = paramBitArray.get(j);
              j += 1;
            }
            for (;;)
            {
              bool2 = bool1;
              if (paramInt == -1) {
                break;
              }
              switch (paramInt)
              {
              default: 
                throw new IllegalArgumentException("Invalid mask pattern: " + paramInt);
                bool1 = false;
              }
            }
            i = n + i2 & 0x1;
            label226:
            if (i != 0) {
              break label372;
            }
            i = 1;
            label232:
            bool2 = bool1;
            if (i != 0) {
              if (bool1) {
                break label377;
              }
            }
          }
          label372:
          label377:
          for (boolean bool2 = true;; bool2 = false)
          {
            paramByteMatrix.set(i2, n, bool2);
            i = j;
            i1 += 1;
            j = i;
            break;
            i = n & 0x1;
            break label226;
            i = i2 % 3;
            break label226;
            i = (n + i2) % 3;
            break label226;
            i = (n >>> 1) + i2 / 3 & 0x1;
            break label226;
            i = n * i2;
            i = i % 3 + (i & 0x1);
            break label226;
            i = n * i2;
            i = i % 3 + (i & 0x1) & 0x1;
            break label226;
            i = n * i2 % 3 + (n + i2 & 0x1) & 0x1;
            break label226;
            i = 0;
            break label232;
          }
        }
        n += k;
      }
      k = -k;
      i = n + k;
      j = m - 2;
      i1 = i2;
    }
    if (i1 != size) {
      throw new WriterException("Not all bits consumed: " + i1 + '/' + size);
    }
  }
  
  private static void embedHorizontalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = 0;
    while (i < 8)
    {
      if (!isEmpty(paramByteMatrix.get(paramInt1 + i, paramInt2))) {
        throw new WriterException();
      }
      paramByteMatrix.set(paramInt1 + i, paramInt2, 0);
      i += 1;
    }
  }
  
  private static void embedPositionDetectionPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
  {
    int i = 0;
    while (i < 7)
    {
      int j = 0;
      while (j < 7)
      {
        paramByteMatrix.set(paramInt1 + j, paramInt2 + i, POSITION_DETECTION_PATTERN[i][j]);
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void embedVerticalSeparationPattern(int paramInt1, int paramInt2, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int i = 0;
    while (i < 7)
    {
      if (!isEmpty(paramByteMatrix.get(paramInt1, paramInt2 + i))) {
        throw new WriterException();
      }
      paramByteMatrix.set(paramInt1, paramInt2 + i, 0);
      i += 1;
    }
  }
  
  private static int findMSBSet(int paramInt)
  {
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (i != 0)
    {
      i >>>= 1;
      paramInt += 1;
    }
    return paramInt;
  }
  
  private static boolean isEmpty(int paramInt)
  {
    return paramInt == -1;
  }
  
  private static void maybeEmbedVersionInfo(Version paramVersion, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    if (versionNumber < 7) {}
    for (;;)
    {
      return;
      BitArray localBitArray = new BitArray();
      localBitArray.appendBits(versionNumber, 6);
      localBitArray.appendBits(calculateBCHCode(versionNumber, 7973), 12);
      if (size != 18) {
        throw new WriterException("should not happen but we got: " + size);
      }
      int j = 17;
      int i = 0;
      while (i < 6)
      {
        int k = 0;
        while (k < 3)
        {
          boolean bool = localBitArray.get(j);
          j -= 1;
          paramByteMatrix.set(i, height - 11 + k, bool);
          paramByteMatrix.set(height - 11 + k, i, bool);
          k += 1;
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.encoder.MatrixUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */