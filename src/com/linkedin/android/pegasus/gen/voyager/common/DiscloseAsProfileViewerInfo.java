package com.linkedin.android.pegasus.gen.voyager.common;

import com.linkedin.data.lite.EnumBuilder;

public enum DiscloseAsProfileViewerInfo
{
  DISCLOSE_ANONYMOUS,  DISCLOSE_FULL,  HIDE,  $UNKNOWN;
  
  private DiscloseAsProfileViewerInfo() {}
  
  public static DiscloseAsProfileViewerInfo of(int paramInt)
  {
    try
    {
      DiscloseAsProfileViewerInfo localDiscloseAsProfileViewerInfo = values()[paramInt];
      return localDiscloseAsProfileViewerInfo;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static DiscloseAsProfileViewerInfo of(String paramString)
  {
    try
    {
      paramString = valueOf(paramString);
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return $UNKNOWN;
  }
  
  public static final class Builder
    implements EnumBuilder<DiscloseAsProfileViewerInfo>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.common.DiscloseAsProfileViewerInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */