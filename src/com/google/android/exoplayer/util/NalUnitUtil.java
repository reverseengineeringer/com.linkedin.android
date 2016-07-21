package com.google.android.exoplayer.util;

public final class NalUnitUtil
{
  public static final float[] ASPECT_RATIO_IDC_VALUES;
  public static final byte[] NAL_START_CODE = { 0, 0, 0, 1 };
  private static int[] scratchEscapePositions = new int[10];
  private static final Object scratchEscapePositionsLock;
  
  static
  {
    ASPECT_RATIO_IDC_VALUES = new float[] { 1.0F, 1.0F, 1.0909091F, 0.90909094F, 1.4545455F, 1.2121212F, 2.1818182F, 1.8181819F, 2.909091F, 2.4242425F, 1.6363636F, 1.3636364F, 1.939394F, 1.6161616F, 1.3333334F, 1.5F, 2.0F };
    scratchEscapePositionsLock = new Object();
  }
  
  public static void clearPrefixFlags(boolean[] paramArrayOfBoolean)
  {
    paramArrayOfBoolean[0] = false;
    paramArrayOfBoolean[1] = false;
    paramArrayOfBoolean[2] = false;
  }
  
  public static int findNalUnit(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean[] paramArrayOfBoolean)
  {
    boolean bool2 = true;
    int j = paramInt2 - paramInt1;
    if (j >= 0)
    {
      bool1 = true;
      Assertions.checkState(bool1);
      if (j != 0) {
        break label34;
      }
    }
    label34:
    do
    {
      return paramInt2;
      bool1 = false;
      break;
      if (paramArrayOfBoolean != null)
      {
        if (paramArrayOfBoolean[0] != 0)
        {
          clearPrefixFlags(paramArrayOfBoolean);
          return paramInt1 - 3;
        }
        if ((j > 1) && (paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[paramInt1] == 1))
        {
          clearPrefixFlags(paramArrayOfBoolean);
          return paramInt1 - 2;
        }
        if ((j > 2) && (paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[paramInt1] == 0) && (paramArrayOfByte[(paramInt1 + 1)] == 1))
        {
          clearPrefixFlags(paramArrayOfBoolean);
          return paramInt1 - 1;
        }
      }
      paramInt1 += 2;
      while (paramInt1 < paramInt2 - 1)
      {
        int i = paramInt1;
        if ((paramArrayOfByte[paramInt1] & 0xFE) == 0)
        {
          if ((paramArrayOfByte[(paramInt1 - 2)] == 0) && (paramArrayOfByte[(paramInt1 - 1)] == 0) && (paramArrayOfByte[paramInt1] == 1))
          {
            if (paramArrayOfBoolean != null) {
              clearPrefixFlags(paramArrayOfBoolean);
            }
            return paramInt1 - 2;
          }
          i = paramInt1 - 2;
        }
        paramInt1 = i + 3;
      }
    } while (paramArrayOfBoolean == null);
    if (j > 2) {
      if ((paramArrayOfByte[(paramInt2 - 3)] == 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
      {
        bool1 = true;
        paramArrayOfBoolean[0] = bool1;
        if (j <= 1) {
          break label358;
        }
        if ((paramArrayOfByte[(paramInt2 - 2)] != 0) || (paramArrayOfByte[(paramInt2 - 1)] != 0)) {
          break label352;
        }
        bool1 = true;
        label254:
        paramArrayOfBoolean[1] = bool1;
        if (paramArrayOfByte[(paramInt2 - 1)] != 0) {
          break label384;
        }
      }
    }
    label352:
    label358:
    label384:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramArrayOfBoolean[2] = bool1;
      return paramInt2;
      bool1 = false;
      break;
      if (j == 2)
      {
        if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 2)] == 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
        {
          bool1 = true;
          break;
        }
        bool1 = false;
        break;
      }
      if ((paramArrayOfBoolean[1] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 1))
      {
        bool1 = true;
        break;
      }
      bool1 = false;
      break;
      bool1 = false;
      break label254;
      if ((paramArrayOfBoolean[2] != 0) && (paramArrayOfByte[(paramInt2 - 1)] == 0))
      {
        bool1 = true;
        break label254;
      }
      bool1 = false;
      break label254;
    }
  }
  
  public static int getH265NalUnitType(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte[(paramInt + 3)] & 0x7E) >> 1;
  }
  
  public static int getNalUnitType(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[(paramInt + 3)] & 0x1F;
  }
  
  public static byte[] parseChildNalUnit(ParsableByteArray paramParsableByteArray)
  {
    int i = paramParsableByteArray.readUnsignedShort();
    int j = position;
    paramParsableByteArray.skipBytes(i);
    return CodecSpecificDataUtil.buildNalUnit(data, j, i);
  }
  
  /* Error */
  public static int unescapeStream(byte[] paramArrayOfByte, int paramInt)
  {
    // Byte code:
    //   0: getstatic 39	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositionsLock	Ljava/lang/Object;
    //   3: astore 8
    //   5: aload 8
    //   7: monitorenter
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore 4
    //   13: iload_2
    //   14: iload_1
    //   15: if_icmpge +102 -> 117
    //   18: iload_2
    //   19: iload_1
    //   20: iconst_2
    //   21: isub
    //   22: if_icmpge +90 -> 112
    //   25: aload_0
    //   26: iload_2
    //   27: baload
    //   28: ifne +77 -> 105
    //   31: aload_0
    //   32: iload_2
    //   33: iconst_1
    //   34: iadd
    //   35: baload
    //   36: ifne +69 -> 105
    //   39: aload_0
    //   40: iload_2
    //   41: iconst_2
    //   42: iadd
    //   43: baload
    //   44: iconst_3
    //   45: if_icmpne +60 -> 105
    //   48: iload_2
    //   49: istore_3
    //   50: iload_3
    //   51: istore_2
    //   52: iload_3
    //   53: iload_1
    //   54: if_icmpge -41 -> 13
    //   57: getstatic 41	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositions	[I
    //   60: arraylength
    //   61: iload 4
    //   63: if_icmpgt +18 -> 81
    //   66: getstatic 41	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositions	[I
    //   69: getstatic 41	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositions	[I
    //   72: arraylength
    //   73: iconst_2
    //   74: imul
    //   75: invokestatic 89	java/util/Arrays:copyOf	([II)[I
    //   78: putstatic 41	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositions	[I
    //   81: getstatic 41	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositions	[I
    //   84: astore 9
    //   86: aload 9
    //   88: iload 4
    //   90: iload_3
    //   91: iastore
    //   92: iload_3
    //   93: iconst_3
    //   94: iadd
    //   95: istore_2
    //   96: iload 4
    //   98: iconst_1
    //   99: iadd
    //   100: istore 4
    //   102: goto -89 -> 13
    //   105: iload_2
    //   106: iconst_1
    //   107: iadd
    //   108: istore_2
    //   109: goto -91 -> 18
    //   112: iload_1
    //   113: istore_3
    //   114: goto -64 -> 50
    //   117: iload_1
    //   118: iload 4
    //   120: isub
    //   121: istore 5
    //   123: iconst_0
    //   124: istore_2
    //   125: iconst_0
    //   126: istore_3
    //   127: iconst_0
    //   128: istore_1
    //   129: iload_1
    //   130: iload 4
    //   132: if_icmpge +59 -> 191
    //   135: getstatic 41	com/google/android/exoplayer/util/NalUnitUtil:scratchEscapePositions	[I
    //   138: iload_1
    //   139: iaload
    //   140: iload_2
    //   141: isub
    //   142: istore 6
    //   144: aload_0
    //   145: iload_2
    //   146: aload_0
    //   147: iload_3
    //   148: iload 6
    //   150: invokestatic 95	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   153: iload_3
    //   154: iload 6
    //   156: iadd
    //   157: istore_3
    //   158: iload_3
    //   159: iconst_1
    //   160: iadd
    //   161: istore 7
    //   163: aload_0
    //   164: iload_3
    //   165: iconst_0
    //   166: bastore
    //   167: iload 7
    //   169: iconst_1
    //   170: iadd
    //   171: istore_3
    //   172: aload_0
    //   173: iload 7
    //   175: iconst_0
    //   176: bastore
    //   177: iload_2
    //   178: iload 6
    //   180: iconst_3
    //   181: iadd
    //   182: iadd
    //   183: istore_2
    //   184: iload_1
    //   185: iconst_1
    //   186: iadd
    //   187: istore_1
    //   188: goto -59 -> 129
    //   191: aload_0
    //   192: iload_2
    //   193: aload_0
    //   194: iload_3
    //   195: iload 5
    //   197: iload_3
    //   198: isub
    //   199: invokestatic 95	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   202: aload 8
    //   204: monitorexit
    //   205: iload 5
    //   207: ireturn
    //   208: astore_0
    //   209: aload 8
    //   211: monitorexit
    //   212: aload_0
    //   213: athrow
    //   214: astore_0
    //   215: goto -6 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	paramArrayOfByte	byte[]
    //   0	218	1	paramInt	int
    //   9	184	2	i	int
    //   49	150	3	j	int
    //   11	122	4	k	int
    //   121	85	5	m	int
    //   142	40	6	n	int
    //   161	13	7	i1	int
    //   3	207	8	localObject	Object
    //   84	3	9	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   57	81	208	finally
    //   81	86	208	finally
    //   135	153	208	finally
    //   191	205	208	finally
    //   209	212	214	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.util.NalUnitUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */