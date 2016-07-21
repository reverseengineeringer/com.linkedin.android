package com.google.android.exoplayer.hls;

public final class Subtitle
{
  public final boolean autoSelect;
  public final boolean isDefault;
  public final String language;
  public final String name;
  public final String uri;
  
  public Subtitle(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
  {
    name = paramString1;
    uri = paramString2;
    language = paramString3;
    autoSelect = paramBoolean2;
    isDefault = paramBoolean1;
  }
}

/* Location:
 * Qualified Name:     com.google.android.exoplayer.hls.Subtitle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */