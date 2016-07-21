package com.google.android.exoplayer.chunk;

import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import com.google.android.exoplayer.upstream.Loader.Loadable;
import com.google.android.exoplayer.util.Assertions;

public abstract class Chunk
  implements Loader.Loadable
{
  public final DataSource dataSource;
  public final DataSpec dataSpec;
  public final Format format;
  public final int trigger;
  public final int type;
  
  public Chunk(DataSource paramDataSource, DataSpec paramDataSpec, int paramInt, Format paramFormat)
  {
    dataSource = ((DataSource)Assertions.checkNotNull(paramDataSource));
    dataSpec = ((DataSpec)Assertions.checkNotNull(paramDataSpec));
    type = paramInt;
    trigger = 0;
    format = paramFormat;
  }
  
  public abstract long bytesLoaded();
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.chunk.Chunk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */