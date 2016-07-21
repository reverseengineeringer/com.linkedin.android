package com.google.android.exoplayer.upstream;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer.util.Assertions;
import java.io.IOException;

public final class DefaultUriDataSource
  implements UriDataSource
{
  private final UriDataSource assetDataSource;
  private final UriDataSource contentDataSource;
  private UriDataSource dataSource;
  private final UriDataSource fileDataSource;
  private final UriDataSource httpDataSource;
  
  private DefaultUriDataSource(Context paramContext, TransferListener paramTransferListener, UriDataSource paramUriDataSource)
  {
    httpDataSource = ((UriDataSource)Assertions.checkNotNull(paramUriDataSource));
    fileDataSource = new FileDataSource(paramTransferListener);
    assetDataSource = new AssetDataSource(paramContext, paramTransferListener);
    contentDataSource = new ContentDataSource(paramContext, paramTransferListener);
  }
  
  public DefaultUriDataSource(Context paramContext, TransferListener paramTransferListener, String paramString)
  {
    this(paramContext, paramTransferListener, paramString, (byte)0);
  }
  
  private DefaultUriDataSource(Context paramContext, TransferListener paramTransferListener, String paramString, byte paramByte)
  {
    this(paramContext, paramTransferListener, new DefaultHttpDataSource(paramString, paramTransferListener));
  }
  
  public final void close()
    throws IOException
  {
    if (dataSource != null) {}
    try
    {
      dataSource.close();
      return;
    }
    finally
    {
      dataSource = null;
    }
  }
  
  public final String getUri()
  {
    if (dataSource == null) {
      return null;
    }
    return dataSource.getUri();
  }
  
  public final long open(DataSpec paramDataSpec)
    throws IOException
  {
    boolean bool;
    String str;
    if (dataSource == null)
    {
      bool = true;
      Assertions.checkState(bool);
      str = uri.getScheme();
      if ((!"file".equals(str)) && (!TextUtils.isEmpty(str))) {
        break label87;
      }
      if (!uri.getPath().startsWith("/android_asset/")) {
        break label76;
      }
      dataSource = assetDataSource;
    }
    for (;;)
    {
      return dataSource.open(paramDataSpec);
      bool = false;
      break;
      label76:
      dataSource = fileDataSource;
      continue;
      label87:
      if ("asset".equals(str)) {
        dataSource = assetDataSource;
      } else if ("content".equals(str)) {
        dataSource = contentDataSource;
      } else {
        dataSource = httpDataSource;
      }
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return dataSource.read(paramArrayOfByte, paramInt1, paramInt2);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.upstream.DefaultUriDataSource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */