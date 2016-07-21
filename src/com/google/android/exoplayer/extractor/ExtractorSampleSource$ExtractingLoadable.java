package com.google.android.exoplayer.extractor;

import android.net.Uri;
import com.google.android.exoplayer.upstream.Allocator;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.util.Assertions;

final class ExtractorSampleSource$ExtractingLoadable
  implements Loader.Loadable
{
  private final Allocator allocator;
  private final DataSource dataSource;
  private final ExtractorSampleSource.ExtractorHolder extractorHolder;
  private volatile boolean loadCanceled;
  private boolean pendingExtractorSeek;
  private final PositionHolder positionHolder;
  private final int requestedBufferSize;
  private final Uri uri;
  
  public ExtractorSampleSource$ExtractingLoadable(Uri paramUri, DataSource paramDataSource, ExtractorSampleSource.ExtractorHolder paramExtractorHolder, Allocator paramAllocator, int paramInt, long paramLong)
  {
    uri = ((Uri)Assertions.checkNotNull(paramUri));
    dataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
    extractorHolder = ((ExtractorSampleSource.ExtractorHolder)Assertions.checkNotNull(paramExtractorHolder));
    allocator = ((Allocator)Assertions.checkNotNull(paramAllocator));
    requestedBufferSize = paramInt;
    positionHolder = new PositionHolder();
    positionHolder.position = paramLong;
    pendingExtractorSeek = true;
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
    //   0: iconst_0
    //   1: istore_1
    //   2: iload_1
    //   3: ifne +251 -> 254
    //   6: aload_0
    //   7: getfield 68	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:loadCanceled	Z
    //   10: ifne +244 -> 254
    //   13: aload_0
    //   14: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
    //   17: getfield 62	com/google/android/exoplayer/extractor/PositionHolder:position	J
    //   20: lstore 8
    //   22: aload_0
    //   23: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   26: new 77	com/google/android/exoplayer/upstream/DataSpec
    //   29: dup
    //   30: aload_0
    //   31: getfield 39	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:uri	Landroid/net/Uri;
    //   34: lload 8
    //   36: ldc2_w 78
    //   39: invokespecial 82	com/google/android/exoplayer/upstream/DataSpec:<init>	(Landroid/net/Uri;JJ)V
    //   42: invokeinterface 86 2 0
    //   47: lstore 6
    //   49: lload 6
    //   51: lstore 4
    //   53: lload 6
    //   55: ldc2_w 78
    //   58: lcmp
    //   59: ifeq +10 -> 69
    //   62: lload 6
    //   64: lload 8
    //   66: ladd
    //   67: lstore 4
    //   69: new 88	com/google/android/exoplayer/extractor/DefaultExtractorInput
    //   72: dup
    //   73: aload_0
    //   74: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   77: lload 8
    //   79: lload 4
    //   81: invokespecial 91	com/google/android/exoplayer/extractor/DefaultExtractorInput:<init>	(Lcom/google/android/exoplayer/upstream/DataSource;JJ)V
    //   84: astore 10
    //   86: iload_1
    //   87: istore_3
    //   88: aload_0
    //   89: getfield 47	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:extractorHolder	Lcom/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractorHolder;
    //   92: aload 10
    //   94: invokevirtual 95	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractorHolder:selectExtractor	(Lcom/google/android/exoplayer/extractor/ExtractorInput;)Lcom/google/android/exoplayer/extractor/Extractor;
    //   97: astore 11
    //   99: iload_1
    //   100: istore_2
    //   101: iload_1
    //   102: istore_3
    //   103: aload_0
    //   104: getfield 64	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:pendingExtractorSeek	Z
    //   107: ifeq +21 -> 128
    //   110: iload_1
    //   111: istore_3
    //   112: aload 11
    //   114: invokeinterface 100 1 0
    //   119: iload_1
    //   120: istore_3
    //   121: aload_0
    //   122: iconst_0
    //   123: putfield 64	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:pendingExtractorSeek	Z
    //   126: iload_1
    //   127: istore_2
    //   128: iload_2
    //   129: ifne +46 -> 175
    //   132: iload_2
    //   133: istore_3
    //   134: aload_0
    //   135: getfield 68	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:loadCanceled	Z
    //   138: ifne +37 -> 175
    //   141: iload_2
    //   142: istore_3
    //   143: aload_0
    //   144: getfield 51	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:allocator	Lcom/google/android/exoplayer/upstream/Allocator;
    //   147: aload_0
    //   148: getfield 53	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:requestedBufferSize	I
    //   151: invokeinterface 104 2 0
    //   156: iload_2
    //   157: istore_3
    //   158: aload 11
    //   160: aload 10
    //   162: aload_0
    //   163: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
    //   166: invokeinterface 108 3 0
    //   171: istore_2
    //   172: goto -44 -> 128
    //   175: iload_2
    //   176: iconst_1
    //   177: if_icmpne +17 -> 194
    //   180: iconst_0
    //   181: istore_1
    //   182: aload_0
    //   183: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   186: invokeinterface 111 1 0
    //   191: goto -189 -> 2
    //   194: aload_0
    //   195: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
    //   198: aload 10
    //   200: invokeinterface 117 1 0
    //   205: putfield 62	com/google/android/exoplayer/extractor/PositionHolder:position	J
    //   208: iload_2
    //   209: istore_1
    //   210: goto -28 -> 182
    //   213: astore 11
    //   215: aconst_null
    //   216: astore 10
    //   218: iload_1
    //   219: iconst_1
    //   220: if_icmpeq +22 -> 242
    //   223: aload 10
    //   225: ifnull +17 -> 242
    //   228: aload_0
    //   229: getfield 58	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:positionHolder	Lcom/google/android/exoplayer/extractor/PositionHolder;
    //   232: aload 10
    //   234: invokeinterface 117 1 0
    //   239: putfield 62	com/google/android/exoplayer/extractor/PositionHolder:position	J
    //   242: aload_0
    //   243: getfield 43	com/google/android/exoplayer/extractor/ExtractorSampleSource$ExtractingLoadable:dataSource	Lcom/google/android/exoplayer/upstream/DataSource;
    //   246: invokeinterface 111 1 0
    //   251: aload 11
    //   253: athrow
    //   254: return
    //   255: astore 11
    //   257: iload_3
    //   258: istore_1
    //   259: goto -41 -> 218
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	262	0	this	ExtractingLoadable
    //   1	258	1	i	int
    //   100	109	2	j	int
    //   87	171	3	k	int
    //   51	29	4	l1	long
    //   47	16	6	l2	long
    //   20	58	8	l3	long
    //   84	149	10	localDefaultExtractorInput	DefaultExtractorInput
    //   97	62	11	localExtractor	Extractor
    //   213	39	11	localObject1	Object
    //   255	1	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   13	49	213	finally
    //   69	86	213	finally
    //   88	99	255	finally
    //   103	110	255	finally
    //   112	119	255	finally
    //   121	126	255	finally
    //   134	141	255	finally
    //   143	156	255	finally
    //   158	172	255	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.extractor.ExtractorSampleSource.ExtractingLoadable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */