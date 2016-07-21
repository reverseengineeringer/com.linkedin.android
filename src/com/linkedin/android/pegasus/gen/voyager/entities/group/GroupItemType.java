package com.linkedin.android.pegasus.gen.voyager.entities.group;

import com.linkedin.data.lite.EnumBuilder;

public enum GroupItemType
{
  ABOUT,  SIMILAR_GROUPS,  $UNKNOWN;
  
  private GroupItemType() {}
  
  public static GroupItemType of(int paramInt)
  {
    try
    {
      GroupItemType localGroupItemType = values()[paramInt];
      return localGroupItemType;
    }
    catch (Exception localException) {}
    return $UNKNOWN;
  }
  
  public static GroupItemType of(String paramString)
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
    implements EnumBuilder<GroupItemType>
  {
    public static final Builder INSTANCE = new Builder();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.group.GroupItemType
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */