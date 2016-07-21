package com.google.android.exoplayer.drm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class DrmInitData$Mapped
  extends DrmInitData
{
  public final Map<UUID, byte[]> schemeData = new HashMap();
  
  public DrmInitData$Mapped(String paramString)
  {
    super(paramString);
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.drm.DrmInitData.Mapped
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */