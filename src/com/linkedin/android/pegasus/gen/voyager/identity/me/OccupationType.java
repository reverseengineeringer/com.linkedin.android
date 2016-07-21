package com.linkedin.android.pegasus.gen.voyager.identity.me;

import com.linkedin.data.lite.EnumBuilder;

public enum OccupationType
{
  EDUCATION,  POSITION,  $UNKNOWN;
  
  private OccupationType() {}
  
  public static OccupationType of(int paramInt)
  {
    try
    {
      OccupationType localOccupationType = values()[paramInt];
      return localOccupationType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static OccupationType of(String paramString)
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
    implements EnumBuilder<OccupationType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.me.OccupationType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */