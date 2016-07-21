package com.google.android.exoplayer.hls;

import com.google.android.exoplayer.chunk.DataChunk;
import com.google.android.exoplayer.upstream.DataSource;
import com.google.android.exoplayer.upstream.DataSpec;
import java.io.ByteArrayInputStream;
import java.io.IOException;

final class HlsChunkSource$MediaPlaylistChunk
  extends DataChunk
{
  private final HlsPlaylistParser playlistParser;
  private final String playlistUrl;
  HlsMediaPlaylist result;
  public final int variantIndex;
  
  public HlsChunkSource$MediaPlaylistChunk(DataSource paramDataSource, DataSpec paramDataSpec, byte[] paramArrayOfByte, HlsPlaylistParser paramHlsPlaylistParser, int paramInt, String paramString)
  {
    super(paramDataSource, paramDataSpec, 4, paramArrayOfByte);
    variantIndex = paramInt;
    playlistParser = paramHlsPlaylistParser;
    playlistUrl = paramString;
  }
  
  protected final void consume(byte[] paramArrayOfByte, int paramInt)
    throws IOException
  {
    result = ((HlsMediaPlaylist)HlsPlaylistParser.parse(playlistUrl, new ByteArrayInputStream(paramArrayOfByte, 0, paramInt)));
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.HlsChunkSource.MediaPlaylistChunk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */