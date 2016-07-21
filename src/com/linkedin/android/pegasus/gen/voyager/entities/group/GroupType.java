package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.data.lite.EnumBuilder;

public enum GroupType
{
  MEMBERS_ONLY,  SECRET,  $UNKNOWN;
  
  private GroupType() {}
  
  public static GroupType of(int paramInt)
  {
    try
    {
      GroupType localGroupType = values()[paramInt];
      return localGroupType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static GroupType of(String paramString)
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
    implements EnumBuilder<GroupType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.GroupType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */