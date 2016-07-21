package com.google.android.exoplayer.text;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer.SampleHolder;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

public final class SubtitleParserHelper
  implements Handler.Callback
{
  private IOException error;
  private final Handler handler = new Handler(paramLooper, this);
  private final SubtitleParser parser;
  private boolean parsing;
  private Subtitle result;
  private SampleHolder sampleHolder;
  
  public SubtitleParserHelper(Looper paramLooper, SubtitleParser paramSubtitleParser)
  {
    parser = paramSubtitleParser;
    flush();
  }
  
  public final void flush()
  {
    try
    {
      sampleHolder = new SampleHolder(1);
      parsing = false;
      result = null;
      error = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Subtitle getAndClearResult()
    throws IOException
  {
    try
    {
      if (error != null) {
        throw error;
      }
    }
    finally
    {
      try
      {
        error = null;
        result = null;
        throw ((Throwable)localObject1);
      }
      finally {}
      Subtitle localSubtitle = result;
      error = null;
      result = null;
      return localSubtitle;
    }
  }
  
  public final SampleHolder getSampleHolder()
  {
    try
    {
      SampleHolder localSampleHolder = sampleHolder;
      return localSampleHolder;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final boolean handleMessage(Message paramMessage)
  {
    SampleHolder localSampleHolder = (SampleHolder)obj;
    try
    {
      paramMessage = new ByteArrayInputStream(data.array(), 0, size);
      localSubtitle = parser.parse$70e760a9(paramMessage, sampleHolder.timeUs);
      paramMessage = null;
    }
    catch (IOException paramMessage)
    {
      for (;;)
      {
        Subtitle localSubtitle = null;
      }
    }
    try
    {
      if (sampleHolder == localSampleHolder)
      {
        result = localSubtitle;
        error = paramMessage;
        parsing = false;
      }
      return true;
    }
    finally {}
  }
  
  public final boolean isParsing()
  {
    try
    {
      boolean bool = parsing;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void startParseOperation()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 45	com/google/android/exoplayer/text/SubtitleParserHelper:parsing	Z
    //   8: ifne +40 -> 48
    //   11: iload_1
    //   12: invokestatic 102	com/google/android/exoplayer/util/Assertions:checkState	(Z)V
    //   15: aload_0
    //   16: iconst_1
    //   17: putfield 45	com/google/android/exoplayer/text/SubtitleParserHelper:parsing	Z
    //   20: aload_0
    //   21: aconst_null
    //   22: putfield 47	com/google/android/exoplayer/text/SubtitleParserHelper:result	Lcom/google/android/exoplayer/text/Subtitle;
    //   25: aload_0
    //   26: aconst_null
    //   27: putfield 49	com/google/android/exoplayer/text/SubtitleParserHelper:error	Ljava/io/IOException;
    //   30: aload_0
    //   31: getfield 30	com/google/android/exoplayer/text/SubtitleParserHelper:handler	Landroid/os/Handler;
    //   34: iconst_0
    //   35: aload_0
    //   36: getfield 43	com/google/android/exoplayer/text/SubtitleParserHelper:sampleHolder	Lcom/google/android/exoplayer/SampleHolder;
    //   39: invokevirtual 106	android/os/Handler:obtainMessage	(ILjava/lang/Object;)Landroid/os/Message;
    //   42: invokevirtual 109	android/os/Message:sendToTarget	()V
    //   45: aload_0
    //   46: monitorexit
    //   47: return
    //   48: iconst_0
    //   49: istore_1
    //   50: goto -39 -> 11
    //   53: astore_2
    //   54: aload_0
    //   55: monitorexit
    //   56: aload_2
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	SubtitleParserHelper
    //   1	49	1	bool	boolean
    //   53	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	11	53	finally
    //   11	45	53	finally
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.text.SubtitleParserHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */