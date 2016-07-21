package com.google.android.exoplayer.upstream;

import com.google.android.exoplayer.util.Assertions;
import java.util.Arrays;

public final class DefaultAllocator
  implements Allocator
{
  private int allocatedCount;
  private Allocation[] availableAllocations;
  private int availableCount;
  private final int individualAllocationSize;
  private final byte[] initialAllocationBlock;
  
  public DefaultAllocator(int paramInt)
  {
    this(paramInt, (byte)0);
  }
  
  private DefaultAllocator(int paramInt, byte paramByte)
  {
    if (paramInt > 0) {}
    for (boolean bool = true;; bool = false)
    {
      Assertions.checkArgument(bool);
      Assertions.checkArgument(true);
      individualAllocationSize = paramInt;
      availableCount = 0;
      availableAllocations = new Allocation[100];
      initialAllocationBlock = null;
      return;
    }
  }
  
  /* Error */
  public final Allocation allocate()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 43	com/google/android/exoplayer/upstream/DefaultAllocator:allocatedCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 43	com/google/android/exoplayer/upstream/DefaultAllocator:allocatedCount	I
    //   12: aload_0
    //   13: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   16: ifle +38 -> 54
    //   19: aload_0
    //   20: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   23: astore_2
    //   24: aload_0
    //   25: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   28: iconst_1
    //   29: isub
    //   30: istore_1
    //   31: aload_0
    //   32: iload_1
    //   33: putfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   36: aload_2
    //   37: iload_1
    //   38: aaload
    //   39: astore_2
    //   40: aload_0
    //   41: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   44: aload_0
    //   45: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   48: aconst_null
    //   49: aastore
    //   50: aload_0
    //   51: monitorexit
    //   52: aload_2
    //   53: areturn
    //   54: new 35	com/google/android/exoplayer/upstream/Allocation
    //   57: dup
    //   58: aload_0
    //   59: getfield 31	com/google/android/exoplayer/upstream/DefaultAllocator:individualAllocationSize	I
    //   62: newarray <illegal type>
    //   64: invokespecial 46	com/google/android/exoplayer/upstream/Allocation:<init>	([B)V
    //   67: astore_2
    //   68: goto -18 -> 50
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	DefaultAllocator
    //   30	8	1	i	int
    //   23	45	2	localObject1	Object
    //   71	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	36	71	finally
    //   40	50	71	finally
    //   54	68	71	finally
  }
  
  /* Error */
  public final void blockWhileTotalBytesAllocatedExceeds(int paramInt)
    throws java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 53	com/google/android/exoplayer/upstream/DefaultAllocator:getTotalBytesAllocated	()I
    //   6: iload_1
    //   7: if_icmple +15 -> 22
    //   10: aload_0
    //   11: invokevirtual 56	java/lang/Object:wait	()V
    //   14: goto -12 -> 2
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: athrow
    //   22: aload_0
    //   23: monitorexit
    //   24: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	25	0	this	DefaultAllocator
    //   0	25	1	paramInt	int
    //   17	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	17	finally
  }
  
  public final int getIndividualAllocationLength()
  {
    return individualAllocationSize;
  }
  
  public final int getTotalBytesAllocated()
  {
    try
    {
      int i = allocatedCount;
      int j = individualAllocationSize;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void release(Allocation paramAllocation)
  {
    label115:
    for (;;)
    {
      try
      {
        if (data != initialAllocationBlock) {
          if (data.length == individualAllocationSize)
          {
            break label115;
            Assertions.checkArgument(bool);
            allocatedCount -= 1;
            if (availableCount == availableAllocations.length) {
              availableAllocations = ((Allocation[])Arrays.copyOf(availableAllocations, availableAllocations.length * 2));
            }
            Allocation[] arrayOfAllocation = availableAllocations;
            int i = availableCount;
            availableCount = (i + 1);
            arrayOfAllocation[i] = paramAllocation;
            notifyAll();
          }
          else
          {
            bool = false;
            continue;
          }
        }
        boolean bool = true;
      }
      finally {}
    }
  }
  
  /* Error */
  public final void trim(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: iload_1
    //   4: aload_0
    //   5: getfield 31	com/google/android/exoplayer/upstream/DefaultAllocator:individualAllocationSize	I
    //   8: invokestatic 80	com/google/android/exoplayer/util/Util:ceilDivide	(II)I
    //   11: aload_0
    //   12: getfield 43	com/google/android/exoplayer/upstream/DefaultAllocator:allocatedCount	I
    //   15: isub
    //   16: invokestatic 85	java/lang/Math:max	(II)I
    //   19: istore_3
    //   20: aload_0
    //   21: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   24: istore_1
    //   25: iload_3
    //   26: iload_1
    //   27: if_icmplt +6 -> 33
    //   30: aload_0
    //   31: monitorexit
    //   32: return
    //   33: iload_3
    //   34: istore_1
    //   35: aload_0
    //   36: getfield 39	com/google/android/exoplayer/upstream/DefaultAllocator:initialAllocationBlock	[B
    //   39: ifnull +112 -> 151
    //   42: aload_0
    //   43: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   46: iconst_1
    //   47: isub
    //   48: istore_2
    //   49: iconst_0
    //   50: istore_1
    //   51: iload_1
    //   52: iload_2
    //   53: if_icmpgt +84 -> 137
    //   56: aload_0
    //   57: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   60: iload_1
    //   61: aaload
    //   62: astore 4
    //   64: aload 4
    //   66: getfield 63	com/google/android/exoplayer/upstream/Allocation:data	[B
    //   69: aload_0
    //   70: getfield 39	com/google/android/exoplayer/upstream/DefaultAllocator:initialAllocationBlock	[B
    //   73: if_acmpne +10 -> 83
    //   76: iload_1
    //   77: iconst_1
    //   78: iadd
    //   79: istore_1
    //   80: goto -29 -> 51
    //   83: aload_0
    //   84: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   87: iload_1
    //   88: aaload
    //   89: astore 5
    //   91: aload 5
    //   93: getfield 63	com/google/android/exoplayer/upstream/Allocation:data	[B
    //   96: aload_0
    //   97: getfield 39	com/google/android/exoplayer/upstream/DefaultAllocator:initialAllocationBlock	[B
    //   100: if_acmpeq +10 -> 110
    //   103: iload_2
    //   104: iconst_1
    //   105: isub
    //   106: istore_2
    //   107: goto -56 -> 51
    //   110: aload_0
    //   111: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   114: iload_1
    //   115: aload 5
    //   117: aastore
    //   118: aload_0
    //   119: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   122: iload_2
    //   123: aload 4
    //   125: aastore
    //   126: iload_2
    //   127: iconst_1
    //   128: isub
    //   129: istore_2
    //   130: iload_1
    //   131: iconst_1
    //   132: iadd
    //   133: istore_1
    //   134: goto -83 -> 51
    //   137: iload_3
    //   138: iload_1
    //   139: invokestatic 85	java/lang/Math:max	(II)I
    //   142: istore_1
    //   143: iload_1
    //   144: aload_0
    //   145: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   148: if_icmpge -118 -> 30
    //   151: aload_0
    //   152: getfield 37	com/google/android/exoplayer/upstream/DefaultAllocator:availableAllocations	[Lcom/google/android/exoplayer/upstream/Allocation;
    //   155: iload_1
    //   156: aload_0
    //   157: getfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   160: aconst_null
    //   161: invokestatic 89	java/util/Arrays:fill	([Ljava/lang/Object;IILjava/lang/Object;)V
    //   164: aload_0
    //   165: iload_1
    //   166: putfield 33	com/google/android/exoplayer/upstream/DefaultAllocator:availableCount	I
    //   169: goto -139 -> 30
    //   172: astore 4
    //   174: aload_0
    //   175: monitorexit
    //   176: aload 4
    //   178: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	DefaultAllocator
    //   0	179	1	paramInt	int
    //   48	82	2	i	int
    //   19	119	3	j	int
    //   62	62	4	localAllocation1	Allocation
    //   172	5	4	localObject	Object
    //   89	27	5	localAllocation2	Allocation
    // Exception table:
    //   from	to	target	type
    //   2	25	172	finally
    //   35	49	172	finally
    //   56	76	172	finally
    //   83	103	172	finally
    //   110	126	172	finally
    //   137	151	172	finally
    //   151	169	172	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DefaultAllocator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */