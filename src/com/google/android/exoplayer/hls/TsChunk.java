package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.Format;
import com.google.android.exoplayer.chunk.MediaChunk;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;

public final class TsChunk
  extends MediaChunk
{
  private int bytesLoaded;
  public final HlsExtractorWrapper extractorWrapper;
  private final boolean isEncrypted;
  private volatile boolean loadCanceled;
  
  public TsChunk(DataSource paramDataSource, DataSpec paramDataSpec, Format paramFormat, long paramLong1, long paramLong2, int paramInt, boolean paramBoolean, HlsExtractorWrapper paramHlsExtractorWrapper, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2) {}
  
  public final long bytesLoaded()
  {
    return bytesLoaded;
  }
  
  public final void cancelLoad()
  {
    loadCanceled = true;
  }
  
  public final boolean isLoadCanceled()
  {
    return loadCanceled;
  }
  
  /* Error */
  public final void load()
    throws java.io.IOException, java.lang.InterruptedException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/google/android/exoplayer/hls/TsChunk:isEncrypted	Z
    //   4: ifeq +104 -> 108
    //   7: aload_0
    //   8: getfield 48	com/google/android/exoplayer/hls/TsChunk:dataSpec	Lcom/google/android/exoplayer/upstream/DataSpec;
    //   11: astore_3
    //   12: aload_0
    //   13: getfield 33	com/google/android/exoplayer/hls/TsChunk:bytesLoaded	I
    //   16: ifeq +87 -> 103
    //   19: iconst_1
    //   20: istore_1
    //   21: new 50	com/google/android/exoplayer/extractor/DefaultExtractorInput
    //   24: dup
    //   25: aload_0
    //   26: getfield 22	com/google/android/exoplayer/hls/TsChunk:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   29: aload_3
    //   30: getfield 56	com/google/android/exoplayer/upstream/DataSpec:absoluteStreamPosition	J
    //   33: aload_0
    //   34: getfield 22	com/google/android/exoplayer/hls/TsChunk:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   37: aload_3
    //   38: invokeinterface 62 2 0
    //   43: invokespecial 65	com/google/android/exoplayer/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer/upstream/DataSource;JJ)V
    //   46: astore_3
    //   47: iload_1
    //   48: ifeq +13 -> 61
    //   51: aload_3
    //   52: aload_0
    //   53: getfield 33	com/google/android/exoplayer/hls/TsChunk:bytesLoaded	I
    //   56: invokeinterface 71 2 0
    //   61: iconst_0
    //   62: istore_1
    //   63: iload_1
    //   64: ifne +66 -> 130
    //   67: aload_0
    //   68: getfield 37	com/google/android/exoplayer/hls/TsChunk:loadCanceled	Z
    //   71: ifne +59 -> 130
    //   74: aload_0
    //   75: getfield 18	com/google/android/exoplayer/hls/TsChunk:extractorWrapper	Lcom/google/android/exoplayer/hls/HlsExtractorWrapper;
    //   78: getfield 77	com/google/android/exoplayer/hls/HlsExtractorWrapper:extractor	Lcom/google/android/exoplayer/extractor/Extractor;
    //   81: aload_3
    //   82: aconst_null
    //   83: invokeinterface 83 3 0
    //   88: istore_1
    //   89: iload_1
    //   90: iconst_1
    //   91: if_icmpeq +34 -> 125
    //   94: iconst_1
    //   95: istore_2
    //   96: iload_2
    //   97: invokestatic 89	com/google/android/exoplayer/util/Assertions:checkState	(Z)V
    //   100: goto -37 -> 63
    //   103: iconst_0
    //   104: istore_1
    //   105: goto -84 -> 21
    //   108: aload_0
    //   109: getfield 48	com/google/android/exoplayer/hls/TsChunk:dataSpec	Lcom/google/android/exoplayer/upstream/DataSpec;
    //   112: aload_0
    //   113: getfield 33	com/google/android/exoplayer/hls/TsChunk:bytesLoaded	I
    //   116: invokestatic 95	com/google/android/exoplayer/util/Util:getRemainderDataSpec	(Lcom/google/android/exoplayer/upstream/DataSpec;I)Lcom/google/android/exoplayer/upstream/DataSpec;
    //   119: astore_3
    //   120: iconst_0
    //   121: istore_1
    //   122: goto -101 -> 21
    //   125: iconst_0
    //   126: istore_2
    //   127: goto -31 -> 96
    //   130: aload_0
    //   131: aload_3
    //   132: invokeinterface 98 1 0
    //   137: aload_0
    //   138: getfield 48	com/google/android/exoplayer/hls/TsChunk:dataSpec	Lcom/google/android/exoplayer/upstream/DataSpec;
    //   141: getfield 56	com/google/android/exoplayer/upstream/DataSpec:absoluteStreamPosition	J
    //   144: lsub
    //   145: l2i
    //   146: putfield 33	com/google/android/exoplayer/hls/TsChunk:bytesLoaded	I
    //   149: aload_0
    //   150: getfield 22	com/google/android/exoplayer/hls/TsChunk:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   153: invokeinterface 101 1 0
    //   158: return
    //   159: astore 4
    //   161: aload_0
    //   162: aload_3
    //   163: invokeinterface 98 1 0
    //   168: aload_0
    //   169: getfield 48	com/google/android/exoplayer/hls/TsChunk:dataSpec	Lcom/google/android/exoplayer/upstream/DataSpec;
    //   172: getfield 56	com/google/android/exoplayer/upstream/DataSpec:absoluteStreamPosition	J
    //   175: lsub
    //   176: l2i
    //   177: putfield 33	com/google/android/exoplayer/hls/TsChunk:bytesLoaded	I
    //   180: aload 4
    //   182: athrow
    //   183: astore_3
    //   184: aload_0
    //   185: getfield 22	com/google/android/exoplayer/hls/TsChunk:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   188: invokeinterface 101 1 0
    //   193: aload_3
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	this	TsChunk
    //   20	102	1	i	int
    //   95	32	2	bool	boolean
    //   11	152	3	localObject1	Object
    //   183	11	3	localObject2	Object
    //   159	22	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   67	89	159	finally
    //   96	100	159	finally
    //   21	47	183	finally
    //   51	61	183	finally
    //   130	149	183	finally
    //   161	183	183	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.TsChunk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */