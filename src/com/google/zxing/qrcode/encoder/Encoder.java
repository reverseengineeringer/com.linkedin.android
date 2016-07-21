package com.google.zxing.qrcode.encoder;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.GenericGFPoly;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import com.google.zxing.qrcode.decoder.Version.ECBlocks;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Encoder
{
  private static final int[] ALPHANUMERIC_TABLE = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1 };
  
  private static int chooseMaskPattern(BitArray paramBitArray, ErrorCorrectionLevel paramErrorCorrectionLevel, Version paramVersion, ByteMatrix paramByteMatrix)
    throws WriterException
  {
    int n = Integer.MAX_VALUE;
    int i1 = -1;
    int j = 0;
    while (j < 8)
    {
      MatrixUtil.buildMatrix(paramBitArray, paramErrorCorrectionLevel, paramVersion, j, paramByteMatrix);
      int i5 = MaskUtil.applyMaskPenaltyRule1Internal(paramByteMatrix, true);
      int i6 = MaskUtil.applyMaskPenaltyRule1Internal(paramByteMatrix, false);
      int k = 0;
      byte[][] arrayOfByte = bytes;
      int i3 = width;
      int i4 = height;
      int m = 0;
      while (m < i4 - 1)
      {
        i = k;
        k = 0;
        while (k < i3 - 1)
        {
          i7 = arrayOfByte[m][k];
          i2 = i;
          if (i7 == arrayOfByte[m][(k + 1)])
          {
            i2 = i;
            if (i7 == arrayOfByte[(m + 1)][k])
            {
              i2 = i;
              if (i7 == arrayOfByte[(m + 1)][(k + 1)]) {
                i2 = i + 1;
              }
            }
          }
          k += 1;
          i = i2;
        }
        m += 1;
        k = i;
      }
      int i = 0;
      arrayOfByte = bytes;
      i4 = width;
      int i7 = height;
      int i2 = 0;
      byte[] arrayOfByte1;
      while (i2 < i7)
      {
        i3 = 0;
        while (i3 < i4)
        {
          arrayOfByte1 = arrayOfByte[i2];
          m = i;
          if (i3 + 6 < i4)
          {
            m = i;
            if (arrayOfByte1[i3] == 1)
            {
              m = i;
              if (arrayOfByte1[(i3 + 1)] == 0)
              {
                m = i;
                if (arrayOfByte1[(i3 + 2)] == 1)
                {
                  m = i;
                  if (arrayOfByte1[(i3 + 3)] == 1)
                  {
                    m = i;
                    if (arrayOfByte1[(i3 + 4)] == 1)
                    {
                      m = i;
                      if (arrayOfByte1[(i3 + 5)] == 0)
                      {
                        m = i;
                        if (arrayOfByte1[(i3 + 6)] == 1) {
                          if (!MaskUtil.isWhiteHorizontal(arrayOfByte1, i3 - 4, i3))
                          {
                            m = i;
                            if (!MaskUtil.isWhiteHorizontal(arrayOfByte1, i3 + 7, i3 + 11)) {}
                          }
                          else
                          {
                            m = i + 1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          i = m;
          if (i2 + 6 < i7)
          {
            i = m;
            if (arrayOfByte[i2][i3] == 1)
            {
              i = m;
              if (arrayOfByte[(i2 + 1)][i3] == 0)
              {
                i = m;
                if (arrayOfByte[(i2 + 2)][i3] == 1)
                {
                  i = m;
                  if (arrayOfByte[(i2 + 3)][i3] == 1)
                  {
                    i = m;
                    if (arrayOfByte[(i2 + 4)][i3] == 1)
                    {
                      i = m;
                      if (arrayOfByte[(i2 + 5)][i3] == 0)
                      {
                        i = m;
                        if (arrayOfByte[(i2 + 6)][i3] == 1) {
                          if (!MaskUtil.isWhiteVertical(arrayOfByte, i3, i2 - 4, i2))
                          {
                            i = m;
                            if (!MaskUtil.isWhiteVertical(arrayOfByte, i3, i2 + 7, i2 + 11)) {}
                          }
                          else
                          {
                            i = m + 1;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          i3 += 1;
        }
        i2 += 1;
      }
      m = 0;
      arrayOfByte = bytes;
      i7 = width;
      int i8 = height;
      i2 = 0;
      while (i2 < i8)
      {
        arrayOfByte1 = arrayOfByte[i2];
        i3 = 0;
        while (i3 < i7)
        {
          i4 = m;
          if (arrayOfByte1[i3] == 1) {
            i4 = m + 1;
          }
          i3 += 1;
          m = i4;
        }
        i2 += 1;
      }
      i2 = height * width;
      k = i5 + i6 + k * 3 + i * 40 + Math.abs(m * 2 - i2) * 10 / i2 * 10;
      i = n;
      if (k < n)
      {
        i = k;
        i1 = j;
      }
      j += 1;
      n = i;
    }
    return i1;
  }
  
  private static Version chooseVersion(int paramInt, ErrorCorrectionLevel paramErrorCorrectionLevel)
    throws WriterException
  {
    int i = 1;
    while (i <= 40)
    {
      Version localVersion = Version.getVersionForNumber(i);
      if (totalCodewords - localVersion.getECBlocksForLevel(paramErrorCorrectionLevel).getTotalECCodewords() >= (paramInt + 7) / 8) {
        return localVersion;
      }
      i += 1;
    }
    throw new WriterException("Data too big");
  }
  
  public static QRCode encode(String paramString, ErrorCorrectionLevel paramErrorCorrectionLevel, Map<EncodeHintType, ?> paramMap)
    throws WriterException
  {
    paramMap = (String)paramMap.get(EncodeHintType.CHARACTER_SET);
    Object localObject1 = paramMap;
    if (paramMap == null) {
      localObject1 = "ISO-8859-1";
    }
    if ("Shift_JIS".equals(localObject1)) {
      if (isOnlyDoubleByteKanji(paramString)) {
        paramMap = Mode.KANJI;
      }
    }
    Object localObject3;
    int k;
    int m;
    for (;;)
    {
      localObject2 = new BitArray();
      if ((paramMap == Mode.BYTE) && (!"ISO-8859-1".equals(localObject1)))
      {
        localObject3 = CharacterSetECI.getCharacterSetECIByName((String)localObject1);
        if (localObject3 != null)
        {
          ((BitArray)localObject2).appendBits(ECIbits, 4);
          ((BitArray)localObject2).appendBits(values[0], 8);
        }
      }
      ((BitArray)localObject2).appendBits(bits, 4);
      localObject3 = new BitArray();
      switch (paramMap)
      {
      default: 
        throw new WriterException("Invalid mode: " + paramMap);
        paramMap = Mode.BYTE;
        continue;
        j = 0;
        k = 0;
        i = 0;
        if (i < paramString.length())
        {
          m = paramString.charAt(i);
          if ((m >= 48) && (m <= 57)) {
            j = 1;
          }
          for (;;)
          {
            i += 1;
            break;
            if (getAlphanumericCode(m) == -1) {
              break label261;
            }
            k = 1;
          }
          label261:
          paramMap = Mode.BYTE;
        }
        else if (k != 0)
        {
          paramMap = Mode.ALPHANUMERIC;
        }
        else if (j != 0)
        {
          paramMap = Mode.NUMERIC;
        }
        else
        {
          paramMap = Mode.BYTE;
        }
        break;
      }
    }
    int j = paramString.length();
    int i = 0;
    while (i < j)
    {
      k = paramString.charAt(i) - '0';
      if (i + 2 < j)
      {
        ((BitArray)localObject3).appendBits(k * 100 + (paramString.charAt(i + 1) - '0') * 10 + (paramString.charAt(i + 2) - '0'), 10);
        i += 3;
      }
      else if (i + 1 < j)
      {
        ((BitArray)localObject3).appendBits(k * 10 + (paramString.charAt(i + 1) - '0'), 7);
        i += 2;
      }
      else
      {
        ((BitArray)localObject3).appendBits(k, 4);
        i += 1;
        continue;
        j = paramString.length();
        i = 0;
        while (i < j)
        {
          k = getAlphanumericCode(paramString.charAt(i));
          if (k == -1) {
            throw new WriterException();
          }
          if (i + 1 < j)
          {
            m = getAlphanumericCode(paramString.charAt(i + 1));
            if (m == -1) {
              throw new WriterException();
            }
            ((BitArray)localObject3).appendBits(k * 45 + m, 11);
            i += 2;
          }
          else
          {
            ((BitArray)localObject3).appendBits(k, 6);
            i += 1;
            continue;
            try
            {
              localObject1 = paramString.getBytes((String)localObject1);
              j = localObject1.length;
              i = 0;
              while (i < j)
              {
                ((BitArray)localObject3).appendBits(localObject1[i], 8);
                i += 1;
              }
              try
              {
                localObject1 = paramString.getBytes("Shift_JIS");
                m = localObject1.length;
                j = 0;
                if (j >= m) {
                  break;
                }
                i = localObject1[j];
                n = localObject1[(j + 1)] & 0xFF | (i & 0xFF) << 8;
                k = -1;
                if ((n >= 33088) && (n <= 40956))
                {
                  i = n - 33088;
                  if (i != -1) {
                    break label731;
                  }
                  throw new WriterException("Invalid byte sequence");
                }
              }
              catch (UnsupportedEncodingException paramString)
              {
                throw new WriterException(paramString);
              }
            }
            catch (UnsupportedEncodingException paramString)
            {
              throw new WriterException(paramString);
            }
            for (;;)
            {
              int n;
              i = k;
              if (n >= 57408)
              {
                i = k;
                if (n <= 60351)
                {
                  i = n - 49472;
                  continue;
                  label731:
                  ((BitArray)localObject3).appendBits((i & 0xFF) + (i >> 8) * 192, 13);
                  j += 2;
                }
              }
            }
          }
        }
      }
    }
    localObject1 = chooseVersion(size + paramMap.getCharacterCountBits(Version.getVersionForNumber(1)) + size, paramErrorCorrectionLevel);
    localObject1 = chooseVersion(size + paramMap.getCharacterCountBits((Version)localObject1) + size, paramErrorCorrectionLevel);
    BitArray localBitArray = new BitArray();
    localBitArray.appendBitArray((BitArray)localObject2);
    if (paramMap == Mode.BYTE) {}
    for (i = ((BitArray)localObject3).getSizeInBytes();; i = paramString.length())
    {
      j = paramMap.getCharacterCountBits((Version)localObject1);
      if (i < 1 << j) {
        break;
      }
      throw new WriterException(i + " is bigger than " + ((1 << j) - 1));
    }
    localBitArray.appendBits(i, j);
    localBitArray.appendBitArray((BitArray)localObject3);
    paramString = ((Version)localObject1).getECBlocksForLevel(paramErrorCorrectionLevel);
    i = totalCodewords - paramString.getTotalECCodewords();
    terminateBits(i, localBitArray);
    paramString = interleaveWithECBytes(localBitArray, totalCodewords, i, paramString.getNumBlocks());
    Object localObject2 = new QRCode();
    ecLevel = paramErrorCorrectionLevel;
    mode = paramMap;
    version = ((Version)localObject1);
    i = versionNumber * 4 + 17;
    paramMap = new ByteMatrix(i, i);
    i = chooseMaskPattern(paramString, paramErrorCorrectionLevel, (Version)localObject1, paramMap);
    maskPattern = i;
    MatrixUtil.buildMatrix(paramString, paramErrorCorrectionLevel, (Version)localObject1, i, paramMap);
    matrix = paramMap;
    return (QRCode)localObject2;
  }
  
  private static byte[] generateECBytes(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramArrayOfByte.length;
    int[] arrayOfInt1 = new int[j + paramInt];
    int i = 0;
    while (i < j)
    {
      paramArrayOfByte[i] &= 0xFF;
      i += 1;
    }
    paramArrayOfByte = new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256);
    if (paramInt == 0) {
      throw new IllegalArgumentException("No error correction bytes");
    }
    int k = arrayOfInt1.length - paramInt;
    if (k <= 0) {
      throw new IllegalArgumentException("No data bytes provided");
    }
    GenericGFPoly localGenericGFPoly = paramArrayOfByte.buildGenerator(paramInt);
    int[] arrayOfInt2 = new int[k];
    System.arraycopy(arrayOfInt1, 0, arrayOfInt2, 0, k);
    paramArrayOfByte = GenericGFPolyfield, arrayOfInt2).multiplyByMonomial(paramInt, 1).divide(localGenericGFPoly)[1].coefficients;
    int m = paramInt - paramArrayOfByte.length;
    i = 0;
    while (i < m)
    {
      arrayOfInt1[(k + i)] = 0;
      i += 1;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfInt1, k + m, paramArrayOfByte.length);
    paramArrayOfByte = new byte[paramInt];
    i = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)arrayOfInt1[(j + i)]);
      i += 1;
    }
    return paramArrayOfByte;
  }
  
  private static int getAlphanumericCode(int paramInt)
  {
    if (paramInt < ALPHANUMERIC_TABLE.length) {
      return ALPHANUMERIC_TABLE[paramInt];
    }
    return -1;
  }
  
  private static BitArray interleaveWithECBytes(BitArray paramBitArray, int paramInt1, int paramInt2, int paramInt3)
    throws WriterException
  {
    if (paramBitArray.getSizeInBytes() != paramInt2) {
      throw new WriterException("Number of bits and data bytes does not match");
    }
    int m = 0;
    int j = 0;
    int i = 0;
    ArrayList localArrayList = new ArrayList(paramInt3);
    int k = 0;
    Object localObject1;
    byte[] arrayOfByte;
    if (k < paramInt3)
    {
      localObject1 = new int[1];
      Object localObject2 = new int[1];
      if (k >= paramInt3) {
        throw new WriterException("Block ID too large");
      }
      int n = paramInt1 % paramInt3;
      int i1 = paramInt3 - n;
      int i5 = paramInt1 / paramInt3;
      int i2 = paramInt2 / paramInt3;
      int i3 = i2 + 1;
      int i4 = i5 - i2;
      i5 = i5 + 1 - i3;
      if (i4 != i5) {
        throw new WriterException("EC bytes mismatch");
      }
      if (paramInt3 != i1 + n) {
        throw new WriterException("RS blocks mismatch");
      }
      if (paramInt1 != n * (i3 + i5) + (i2 + i4) * i1) {
        throw new WriterException("Total bytes mismatch");
      }
      if (k < i1)
      {
        localObject1[0] = i2;
        localObject2[0] = i4;
      }
      for (;;)
      {
        n = localObject1[0];
        arrayOfByte = new byte[n];
        paramBitArray.toBytes$101cc16b(m * 8, arrayOfByte, n);
        localObject2 = generateECBytes(arrayOfByte, localObject2[0]);
        localArrayList.add(new BlockPair(arrayOfByte, (byte[])localObject2));
        j = Math.max(j, n);
        i = Math.max(i, localObject2.length);
        m += localObject1[0];
        k += 1;
        break;
        localObject1[0] = i3;
        localObject2[0] = i5;
      }
    }
    if (paramInt2 != m) {
      throw new WriterException("Data bytes does not match offset");
    }
    paramBitArray = new BitArray();
    paramInt2 = 0;
    while (paramInt2 < j)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfByte = nextdataBytes;
        if (paramInt2 < arrayOfByte.length) {
          paramBitArray.appendBits(arrayOfByte[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      localObject1 = localArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        arrayOfByte = nexterrorCorrectionBytes;
        if (paramInt2 < arrayOfByte.length) {
          paramBitArray.appendBits(arrayOfByte[paramInt2], 8);
        }
      }
      paramInt2 += 1;
    }
    if (paramInt1 != paramBitArray.getSizeInBytes()) {
      throw new WriterException("Interleaving error: " + paramInt1 + " and " + paramBitArray.getSizeInBytes() + " differ.");
    }
    return paramBitArray;
  }
  
  private static boolean isOnlyDoubleByteKanji(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("Shift_JIS");
      int j = paramString.length;
      if (j % 2 != 0) {
        return false;
      }
      int i = 0;
      for (;;)
      {
        if (i >= j) {
          break label68;
        }
        int k = paramString[i] & 0xFF;
        if (((k < 129) || (k > 159)) && ((k < 224) || (k > 235))) {
          break;
        }
        i += 2;
      }
      label68:
      return true;
    }
    catch (UnsupportedEncodingException paramString) {}
    return false;
  }
  
  private static void terminateBits(int paramInt, BitArray paramBitArray)
    throws WriterException
  {
    int k = paramInt << 3;
    if (size > k) {
      throw new WriterException("data bits cannot fit in the QR Code" + size + " > " + k);
    }
    int i = 0;
    while ((i < 4) && (size < k))
    {
      paramBitArray.appendBit(false);
      i += 1;
    }
    i = size & 0x7;
    if (i > 0) {
      while (i < 8)
      {
        paramBitArray.appendBit(false);
        i += 1;
      }
    }
    int m = paramBitArray.getSizeInBytes();
    i = 0;
    if (i < paramInt - m)
    {
      if ((i & 0x1) == 0) {}
      for (int j = 236;; j = 17)
      {
        paramBitArray.appendBits(j, 8);
        i += 1;
        break;
      }
    }
    if (size != k) {
      throw new WriterException("Bits size does not equal capacity");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.zxing.qrcode.encoder.Encoder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */