package com.linkedin.android.imageloader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public final class IntArrayPool
{
  protected static final Comparator<int[]> BUF_COMPARATOR = new Comparator() {};
  private final List<int[]> mBuffersByLastUse = new LinkedList();
  private final List<int[]> mBuffersBySize = new ArrayList(64);
  private int mCurrentSize = 0;
  private final int mSizeLimit = 65536;
  
  /* Error */
  private void trim()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/linkedin/android/imageloader/IntArrayPool:mCurrentSize	I
    //   6: aload_0
    //   7: getfield 42	com/linkedin/android/imageloader/IntArrayPool:mSizeLimit	I
    //   10: if_icmple +47 -> 57
    //   13: aload_0
    //   14: getfield 30	com/linkedin/android/imageloader/IntArrayPool:mBuffersByLastUse	Ljava/util/List;
    //   17: iconst_0
    //   18: invokeinterface 49 2 0
    //   23: checkcast 51	[I
    //   26: astore_1
    //   27: aload_0
    //   28: getfield 37	com/linkedin/android/imageloader/IntArrayPool:mBuffersBySize	Ljava/util/List;
    //   31: aload_1
    //   32: invokeinterface 54 2 0
    //   37: pop
    //   38: aload_0
    //   39: aload_0
    //   40: getfield 39	com/linkedin/android/imageloader/IntArrayPool:mCurrentSize	I
    //   43: aload_1
    //   44: arraylength
    //   45: isub
    //   46: putfield 39	com/linkedin/android/imageloader/IntArrayPool:mCurrentSize	I
    //   49: goto -47 -> 2
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	IntArrayPool
    //   26	18	1	arrayOfInt	int[]
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	49	52	finally
  }
  
  /* Error */
  public final int[] getBuf(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iload_2
    //   5: aload_0
    //   6: getfield 37	com/linkedin/android/imageloader/IntArrayPool:mBuffersBySize	Ljava/util/List;
    //   9: invokeinterface 60 1 0
    //   14: if_icmpge +67 -> 81
    //   17: aload_0
    //   18: getfield 37	com/linkedin/android/imageloader/IntArrayPool:mBuffersBySize	Ljava/util/List;
    //   21: iload_2
    //   22: invokeinterface 63 2 0
    //   27: checkcast 51	[I
    //   30: astore_3
    //   31: aload_3
    //   32: arraylength
    //   33: iload_1
    //   34: if_icmplt +40 -> 74
    //   37: aload_0
    //   38: aload_0
    //   39: getfield 39	com/linkedin/android/imageloader/IntArrayPool:mCurrentSize	I
    //   42: aload_3
    //   43: arraylength
    //   44: isub
    //   45: putfield 39	com/linkedin/android/imageloader/IntArrayPool:mCurrentSize	I
    //   48: aload_0
    //   49: getfield 37	com/linkedin/android/imageloader/IntArrayPool:mBuffersBySize	Ljava/util/List;
    //   52: iload_2
    //   53: invokeinterface 49 2 0
    //   58: pop
    //   59: aload_0
    //   60: getfield 30	com/linkedin/android/imageloader/IntArrayPool:mBuffersByLastUse	Ljava/util/List;
    //   63: aload_3
    //   64: invokeinterface 54 2 0
    //   69: pop
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_3
    //   73: areturn
    //   74: iload_2
    //   75: iconst_1
    //   76: iadd
    //   77: istore_2
    //   78: goto -74 -> 4
    //   81: iload_1
    //   82: newarray <illegal type>
    //   84: astore_3
    //   85: goto -15 -> 70
    //   88: astore_3
    //   89: aload_0
    //   90: monitorexit
    //   91: aload_3
    //   92: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	93	0	this	IntArrayPool
    //   0	93	1	paramInt	int
    //   3	75	2	i	int
    //   30	55	3	arrayOfInt	int[]
    //   88	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	70	88	finally
    //   81	85	88	finally
  }
  
  public final void returnBuf(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null) {}
    try
    {
      if (paramArrayOfInt.length <= mSizeLimit)
      {
        mBuffersByLastUse.add(paramArrayOfInt);
        int j = Collections.binarySearch(mBuffersBySize, paramArrayOfInt, BUF_COMPARATOR);
        int i = j;
        if (j < 0) {
          i = -j - 1;
        }
        mBuffersBySize.add(i, paramArrayOfInt);
        mCurrentSize += paramArrayOfInt.length;
        trim();
      }
      return;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.IntArrayPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */