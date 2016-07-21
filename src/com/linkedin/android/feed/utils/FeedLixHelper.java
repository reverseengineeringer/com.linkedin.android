package com.linkedin.android.feed.utils;

import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;

public final class FeedLixHelper
{
  public static boolean isEnabled(LixManager paramLixManager, LixDefinition paramLixDefinition)
  {
    return !"control".equals(paramLixManager.getTreatment(paramLixDefinition));
  }
  
  public static int parseInt$7e416bce(LixManager paramLixManager, LixDefinition paramLixDefinition, int paramInt)
  {
    paramLixManager = paramLixManager.getTreatment(paramLixDefinition);
    int i = paramInt;
    if (paramLixManager.indexOf("value_") == 0) {}
    try
    {
      i = Integer.parseInt(paramLixManager.substring(6));
      i *= 1;
      return i;
    }
    catch (NumberFormatException paramLixManager) {}
    return paramInt;
  }
  
  public static long parseLong(LixManager paramLixManager, LixDefinition paramLixDefinition, long paramLong1, long paramLong2)
  {
    paramLixManager = paramLixManager.getTreatment(paramLixDefinition);
    long l = paramLong1;
    if (paramLixManager.indexOf("value_") == 0) {}
    try
    {
      l = Long.parseLong(paramLixManager.substring(6));
      l *= paramLong2;
      return l;
    }
    catch (NumberFormatException paramLixManager) {}
    return paramLong1;
  }
  
  public static boolean showScrollbars(LixManager paramLixManager)
  {
    return !isEnabled(paramLixManager, Lix.FEED_HIDE_SCROLLBAR);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedLixHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */