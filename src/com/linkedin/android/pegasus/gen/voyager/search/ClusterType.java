package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.data.lite.EnumBuilder;

public enum ClusterType
{
  LARGE,  MEDIUM,  PRIMARY,  SMALL,  $UNKNOWN;
  
  private ClusterType() {}
  
  public static ClusterType of(int paramInt)
  {
    try
    {
      ClusterType localClusterType = values()[paramInt];
      return localClusterType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static ClusterType of(String paramString)
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
    implements EnumBuilder<ClusterType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.ClusterType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */