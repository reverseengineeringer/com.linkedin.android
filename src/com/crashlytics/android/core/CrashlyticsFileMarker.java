package com.crashlytics.android.core;

import io.fabric.sdk.android.Fabric;
import io.fabric.sdk.android.Logger;
import io.fabric.sdk.android.services.persistence.FileStore;
import java.io.File;
import java.io.IOException;

final class CrashlyticsFileMarker
{
  private final FileStore fileStore;
  private final String markerName;
  
  public CrashlyticsFileMarker(String paramString, FileStore paramFileStore)
  {
    markerName = paramString;
    fileStore = paramFileStore;
  }
  
  public final boolean create()
  {
    try
    {
      boolean bool = getMarkerFile().createNewFile();
      return bool;
    }
    catch (IOException localIOException)
    {
      Fabric.getLogger().e("CrashlyticsCore", "Error creating marker: " + markerName, localIOException);
    }
    return false;
  }
  
  final File getMarkerFile()
  {
    return new File(fileStore.getFilesDir(), markerName);
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.CrashlyticsFileMarker
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */