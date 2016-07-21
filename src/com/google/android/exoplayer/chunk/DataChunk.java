package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.io.IOException;
import java.util.Arrays;

public abstract class DataChunk
  extends Chunk
{
  public byte[] data;
  private int limit;
  private volatile boolean loadCanceled;
  
  public DataChunk(DataSource paramDataSource, DataSpec paramDataSpec, int paramInt, byte[] paramArrayOfByte)
  {
    super(paramDataSource, paramDataSpec, paramInt, null);
    data = paramArrayOfByte;
  }
  
  public final long bytesLoaded()
  {
    return limit;
  }
  
  public final void cancelLoad()
  {
    loadCanceled = true;
  }
  
  public abstract void consume(byte[] paramArrayOfByte, int paramInt)
    throws IOException;
  
  public final boolean isLoadCanceled()
  {
    return loadCanceled;
  }
  
  public final void load()
    throws IOException, InterruptedException
  {
    for (;;)
    {
      try
      {
        dataSource.open(dataSpec);
        limit = 0;
        int i = 0;
        if ((i == -1) || (loadCanceled)) {
          break;
        }
        if (data == null)
        {
          data = new byte['䀀'];
          int j = dataSource.read(data, limit, 16384);
          i = j;
          if (j == -1) {
            continue;
          }
          limit += j;
          i = j;
          continue;
        }
        if (data.length >= limit + 16384) {
          continue;
        }
      }
      finally
      {
        dataSource.close();
      }
      data = Arrays.copyOf(data, data.length + 16384);
    }
    if (!loadCanceled) {
      consume(data, limit);
    }
    dataSource.close();
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.DataChunk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */