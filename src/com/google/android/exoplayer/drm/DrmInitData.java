package com.google.android.exoplayer.drm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public abstract class DrmInitData
{
  public final String mimeType;
  
  public DrmInitData(String paramString)
  {
    mimeType = paramString;
  }
  
  public static final class Mapped
    extends DrmInitData
  {
    public final Map<UUID, byte[]> schemeData = new HashMap();
    
    public Mapped(String paramString)
    {
      super();
    }
  }
  
  public static final class Universal
    extends DrmInitData
  {
    private byte[] data;
    
    public Universal(String paramString, byte[] paramArrayOfByte)
    {
      super();
      data = paramArrayOfByte;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.drm.DrmInitData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */