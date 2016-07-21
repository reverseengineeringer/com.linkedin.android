package com.google.android.exoplayer.extractor;

import com.google.android.exoplayer.SampleHolder;
import com.google.android.exoplayer.upstream.Allocation;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.util.ParsableByteArray;
import java.util.concurrent.LinkedBlockingDeque;

public final class RollingSampleBuffer
{
  final int allocationLength;
  final Allocator allocator;
  final LinkedBlockingDeque<Allocation> dataQueue;
  final SampleExtrasHolder extrasHolder;
  final InfoQueue infoQueue;
  Allocation lastAllocation;
  int lastAllocationOffset;
  final ParsableByteArray scratch;
  long totalBytesDropped;
  long totalBytesWritten;
  
  public RollingSampleBuffer(Allocator paramAllocator)
  {
    allocator = paramAllocator;
    allocationLength = paramAllocator.getIndividualAllocationLength();
    infoQueue = new InfoQueue();
    dataQueue = new LinkedBlockingDeque();
    extrasHolder = new SampleExtrasHolder((byte)0);
    scratch = new ParsableByteArray(32);
    lastAllocationOffset = allocationLength;
  }
  
  final void dropDownstreamTo(long paramLong)
  {
    int j = (int)(paramLong - totalBytesDropped) / allocationLength;
    int i = 0;
    while (i < j)
    {
      allocator.release((Allocation)dataQueue.remove());
      totalBytesDropped += allocationLength;
      i += 1;
    }
  }
  
  public final boolean peekSample(SampleHolder paramSampleHolder)
  {
    return infoQueue.peekSample(paramSampleHolder, extrasHolder);
  }
  
  final int prepareForAppend(int paramInt)
  {
    if (lastAllocationOffset == allocationLength)
    {
      lastAllocationOffset = 0;
      lastAllocation = allocator.allocate();
      dataQueue.add(lastAllocation);
    }
    return Math.min(paramInt, allocationLength - lastAllocationOffset);
  }
  
  final void readData(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      dropDownstreamTo(paramLong);
      int j = (int)(paramLong - totalBytesDropped);
      int k = Math.min(paramInt - i, allocationLength - j);
      Allocation localAllocation = (Allocation)dataQueue.peek();
      System.arraycopy(data, offset + j, paramArrayOfByte, i, k);
      paramLong += k;
      i += k;
    }
  }
  
  public final void skipSample()
  {
    dropDownstreamTo(infoQueue.moveToNextSample());
  }
  
  private static final class InfoQueue
  {
    int absoluteReadIndex;
    private int capacity = 1000;
    private byte[][] encryptionKeys = new byte[capacity][];
    private int[] flags = new int[capacity];
    private long[] offsets = new long[capacity];
    int queueSize;
    int relativeReadIndex;
    int relativeWriteIndex;
    private int[] sizes = new int[capacity];
    private long[] timesUs = new long[capacity];
    
    /* Error */
    public final void commitSample(long paramLong1, int paramInt1, long paramLong2, int paramInt2, byte[] paramArrayOfByte)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   6: aload_0
      //   7: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   10: lload_1
      //   11: lastore
      //   12: aload_0
      //   13: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   16: aload_0
      //   17: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   20: lload 4
      //   22: lastore
      //   23: aload_0
      //   24: getfield 35	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:sizes	[I
      //   27: aload_0
      //   28: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   31: iload 6
      //   33: iastore
      //   34: aload_0
      //   35: getfield 33	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:flags	[I
      //   38: aload_0
      //   39: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   42: iload_3
      //   43: iastore
      //   44: aload_0
      //   45: getfield 39	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:encryptionKeys	[[B
      //   48: aload_0
      //   49: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   52: aload 7
      //   54: aastore
      //   55: aload_0
      //   56: aload_0
      //   57: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   60: iconst_1
      //   61: iadd
      //   62: putfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   65: aload_0
      //   66: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   69: aload_0
      //   70: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   73: if_icmpne +264 -> 337
      //   76: aload_0
      //   77: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   80: sipush 1000
      //   83: iadd
      //   84: istore_3
      //   85: iload_3
      //   86: newarray <illegal type>
      //   88: astore 7
      //   90: iload_3
      //   91: newarray <illegal type>
      //   93: astore 9
      //   95: iload_3
      //   96: newarray <illegal type>
      //   98: astore 10
      //   100: iload_3
      //   101: newarray <illegal type>
      //   103: astore 11
      //   105: iload_3
      //   106: anewarray 37	[B
      //   109: astore 12
      //   111: aload_0
      //   112: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   115: aload_0
      //   116: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   119: isub
      //   120: istore 6
      //   122: aload_0
      //   123: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   126: aload_0
      //   127: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   130: aload 7
      //   132: iconst_0
      //   133: iload 6
      //   135: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   138: aload_0
      //   139: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   142: aload_0
      //   143: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   146: aload 9
      //   148: iconst_0
      //   149: iload 6
      //   151: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   154: aload_0
      //   155: getfield 33	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:flags	[I
      //   158: aload_0
      //   159: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   162: aload 10
      //   164: iconst_0
      //   165: iload 6
      //   167: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   170: aload_0
      //   171: getfield 35	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:sizes	[I
      //   174: aload_0
      //   175: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   178: aload 11
      //   180: iconst_0
      //   181: iload 6
      //   183: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   186: aload_0
      //   187: getfield 39	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:encryptionKeys	[[B
      //   190: aload_0
      //   191: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   194: aload 12
      //   196: iconst_0
      //   197: iload 6
      //   199: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   202: aload_0
      //   203: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   206: istore 8
      //   208: aload_0
      //   209: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   212: iconst_0
      //   213: aload 7
      //   215: iload 6
      //   217: iload 8
      //   219: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   222: aload_0
      //   223: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   226: iconst_0
      //   227: aload 9
      //   229: iload 6
      //   231: iload 8
      //   233: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   236: aload_0
      //   237: getfield 33	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:flags	[I
      //   240: iconst_0
      //   241: aload 10
      //   243: iload 6
      //   245: iload 8
      //   247: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   250: aload_0
      //   251: getfield 35	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:sizes	[I
      //   254: iconst_0
      //   255: aload 11
      //   257: iload 6
      //   259: iload 8
      //   261: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   264: aload_0
      //   265: getfield 39	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:encryptionKeys	[[B
      //   268: iconst_0
      //   269: aload 12
      //   271: iload 6
      //   273: iload 8
      //   275: invokestatic 54	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
      //   278: aload_0
      //   279: aload 7
      //   281: putfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   284: aload_0
      //   285: aload 9
      //   287: putfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   290: aload_0
      //   291: aload 10
      //   293: putfield 33	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:flags	[I
      //   296: aload_0
      //   297: aload 11
      //   299: putfield 35	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:sizes	[I
      //   302: aload_0
      //   303: aload 12
      //   305: putfield 39	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:encryptionKeys	[[B
      //   308: aload_0
      //   309: iconst_0
      //   310: putfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   313: aload_0
      //   314: aload_0
      //   315: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   318: putfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   321: aload_0
      //   322: aload_0
      //   323: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   326: putfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   329: aload_0
      //   330: iload_3
      //   331: putfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   334: aload_0
      //   335: monitorexit
      //   336: return
      //   337: aload_0
      //   338: aload_0
      //   339: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   342: iconst_1
      //   343: iadd
      //   344: putfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   347: aload_0
      //   348: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   351: aload_0
      //   352: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   355: if_icmpne -21 -> 334
      //   358: aload_0
      //   359: iconst_0
      //   360: putfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   363: goto -29 -> 334
      //   366: astore 7
      //   368: aload_0
      //   369: monitorexit
      //   370: aload 7
      //   372: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	373	0	this	InfoQueue
      //   0	373	1	paramLong1	long
      //   0	373	3	paramInt1	int
      //   0	373	4	paramLong2	long
      //   0	373	6	paramInt2	int
      //   0	373	7	paramArrayOfByte	byte[]
      //   206	68	8	i	int
      //   93	193	9	arrayOfLong	long[]
      //   98	194	10	arrayOfInt1	int[]
      //   103	195	11	arrayOfInt2	int[]
      //   109	195	12	arrayOfByte	byte[][]
      // Exception table:
      //   from	to	target	type
      //   2	334	366	finally
      //   337	363	366	finally
    }
    
    /* Error */
    public final long moveToNextSample()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: aload_0
      //   4: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   7: iconst_1
      //   8: isub
      //   9: putfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   12: aload_0
      //   13: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   16: istore_1
      //   17: aload_0
      //   18: iload_1
      //   19: iconst_1
      //   20: iadd
      //   21: putfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   24: aload_0
      //   25: aload_0
      //   26: getfield 58	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:absoluteReadIndex	I
      //   29: iconst_1
      //   30: iadd
      //   31: putfield 58	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:absoluteReadIndex	I
      //   34: aload_0
      //   35: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   38: aload_0
      //   39: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   42: if_icmpne +8 -> 50
      //   45: aload_0
      //   46: iconst_0
      //   47: putfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   50: aload_0
      //   51: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   54: ifle +17 -> 71
      //   57: aload_0
      //   58: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   61: aload_0
      //   62: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   65: laload
      //   66: lstore_2
      //   67: aload_0
      //   68: monitorexit
      //   69: lload_2
      //   70: lreturn
      //   71: aload_0
      //   72: getfield 35	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:sizes	[I
      //   75: iload_1
      //   76: iaload
      //   77: i2l
      //   78: lstore_2
      //   79: aload_0
      //   80: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   83: iload_1
      //   84: laload
      //   85: lstore 4
      //   87: lload_2
      //   88: lload 4
      //   90: ladd
      //   91: lstore_2
      //   92: goto -25 -> 67
      //   95: astore 6
      //   97: aload_0
      //   98: monitorexit
      //   99: aload 6
      //   101: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	102	0	this	InfoQueue
      //   16	68	1	i	int
      //   66	26	2	l1	long
      //   85	4	4	l2	long
      //   95	5	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	50	95	finally
      //   50	67	95	finally
      //   71	87	95	finally
    }
    
    /* Error */
    public final boolean peekSample(SampleHolder paramSampleHolder, RollingSampleBuffer.SampleExtrasHolder paramSampleExtrasHolder)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   6: istore_3
      //   7: iload_3
      //   8: ifne +11 -> 19
      //   11: iconst_0
      //   12: istore 4
      //   14: aload_0
      //   15: monitorexit
      //   16: iload 4
      //   18: ireturn
      //   19: aload_1
      //   20: aload_0
      //   21: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   24: aload_0
      //   25: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   28: laload
      //   29: putfield 66	com/google/android/exoplayer/SampleHolder:timeUs	J
      //   32: aload_1
      //   33: aload_0
      //   34: getfield 35	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:sizes	[I
      //   37: aload_0
      //   38: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   41: iaload
      //   42: putfield 69	com/google/android/exoplayer/SampleHolder:size	I
      //   45: aload_1
      //   46: aload_0
      //   47: getfield 33	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:flags	[I
      //   50: aload_0
      //   51: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   54: iaload
      //   55: putfield 71	com/google/android/exoplayer/SampleHolder:flags	I
      //   58: aload_2
      //   59: aload_0
      //   60: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   63: aload_0
      //   64: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   67: laload
      //   68: putfield 76	com/google/android/exoplayer/extractor/RollingSampleBuffer$SampleExtrasHolder:offset	J
      //   71: aload_2
      //   72: aload_0
      //   73: getfield 39	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:encryptionKeys	[[B
      //   76: aload_0
      //   77: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   80: aaload
      //   81: putfield 79	com/google/android/exoplayer/extractor/RollingSampleBuffer$SampleExtrasHolder:encryptionKeyId	[B
      //   84: iconst_1
      //   85: istore 4
      //   87: goto -73 -> 14
      //   90: astore_1
      //   91: aload_0
      //   92: monitorexit
      //   93: aload_1
      //   94: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	95	0	this	InfoQueue
      //   0	95	1	paramSampleHolder	SampleHolder
      //   0	95	2	paramSampleExtrasHolder	RollingSampleBuffer.SampleExtrasHolder
      //   6	2	3	i	int
      //   12	74	4	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	7	90	finally
      //   19	84	90	finally
    }
    
    /* Error */
    public final long skipToKeyframeBefore(long paramLong)
    {
      // Byte code:
      //   0: ldc2_w 82
      //   3: lstore 8
      //   5: aload_0
      //   6: monitorenter
      //   7: lload 8
      //   9: lstore 6
      //   11: aload_0
      //   12: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   15: ifeq +25 -> 40
      //   18: aload_0
      //   19: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   22: aload_0
      //   23: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   26: laload
      //   27: lstore 6
      //   29: lload_1
      //   30: lload 6
      //   32: lcmp
      //   33: ifge +12 -> 45
      //   36: lload 8
      //   38: lstore 6
      //   40: aload_0
      //   41: monitorexit
      //   42: lload 6
      //   44: lreturn
      //   45: aload_0
      //   46: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   49: ifne +90 -> 139
      //   52: aload_0
      //   53: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   56: istore_3
      //   57: lload 8
      //   59: lstore 6
      //   61: lload_1
      //   62: aload_0
      //   63: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   66: iload_3
      //   67: iconst_1
      //   68: isub
      //   69: laload
      //   70: lcmp
      //   71: ifgt -31 -> 40
      //   74: iconst_0
      //   75: istore_3
      //   76: iconst_m1
      //   77: istore 5
      //   79: aload_0
      //   80: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   83: istore 4
      //   85: iload 4
      //   87: aload_0
      //   88: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   91: if_icmpeq +56 -> 147
      //   94: aload_0
      //   95: getfield 31	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:timesUs	[J
      //   98: iload 4
      //   100: laload
      //   101: lload_1
      //   102: lcmp
      //   103: ifgt +44 -> 147
      //   106: aload_0
      //   107: getfield 33	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:flags	[I
      //   110: iload 4
      //   112: iaload
      //   113: iconst_1
      //   114: iand
      //   115: ifeq +6 -> 121
      //   118: iload_3
      //   119: istore 5
      //   121: iload 4
      //   123: iconst_1
      //   124: iadd
      //   125: aload_0
      //   126: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   129: irem
      //   130: istore 4
      //   132: iload_3
      //   133: iconst_1
      //   134: iadd
      //   135: istore_3
      //   136: goto -51 -> 85
      //   139: aload_0
      //   140: getfield 44	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeWriteIndex	I
      //   143: istore_3
      //   144: goto -87 -> 57
      //   147: lload 8
      //   149: lstore 6
      //   151: iload 5
      //   153: iconst_m1
      //   154: if_icmpeq -114 -> 40
      //   157: aload_0
      //   158: aload_0
      //   159: getfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   162: iload 5
      //   164: isub
      //   165: putfield 46	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:queueSize	I
      //   168: aload_0
      //   169: aload_0
      //   170: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   173: iload 5
      //   175: iadd
      //   176: aload_0
      //   177: getfield 27	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:capacity	I
      //   180: irem
      //   181: putfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   184: aload_0
      //   185: aload_0
      //   186: getfield 58	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:absoluteReadIndex	I
      //   189: iload 5
      //   191: iadd
      //   192: putfield 58	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:absoluteReadIndex	I
      //   195: aload_0
      //   196: getfield 29	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:offsets	[J
      //   199: aload_0
      //   200: getfield 48	com/google/android/exoplayer/extractor/RollingSampleBuffer$InfoQueue:relativeReadIndex	I
      //   203: laload
      //   204: lstore 6
      //   206: goto -166 -> 40
      //   209: astore 10
      //   211: aload_0
      //   212: monitorexit
      //   213: aload 10
      //   215: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	216	0	this	InfoQueue
      //   0	216	1	paramLong	long
      //   56	88	3	i	int
      //   83	48	4	j	int
      //   77	115	5	k	int
      //   9	196	6	l1	long
      //   3	145	8	l2	long
      //   209	5	10	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   11	29	209	finally
      //   45	57	209	finally
      //   61	74	209	finally
      //   79	85	209	finally
      //   85	106	209	finally
      //   106	118	209	finally
      //   121	132	209	finally
      //   139	144	209	finally
      //   157	206	209	finally
    }
  }
  
  private static final class SampleExtrasHolder
  {
    public byte[] encryptionKeyId;
    public long offset;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.RollingSampleBuffer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */