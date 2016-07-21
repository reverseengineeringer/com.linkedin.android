package com.linkedin.android.growth.utils;

import com.linkedin.android.infra.lix.LixDefinition;
import com.linkedin.android.infra.lix.LixManager;

public final class GrowthLixHelper
{
  @Deprecated
  public static boolean isEnabled(LixManager paramLixManager, LixDefinition paramLixDefinition)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramLixManager != null)
    {
      bool1 = bool2;
      if (paramLixDefinition != null)
      {
        bool1 = bool2;
        if (!"control".equalsIgnoreCase(paramLixManager.getTreatment(paramLixDefinition))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static int parseInt(LixManager paramLixManager, LixDefinition paramLixDefinition, int paramInt, String paramString)
  {
    paramLixManager = paramLixManager.getTreatment(paramLixDefinition);
    int i = paramInt;
    if (paramLixManager.startsWith(paramString)) {}
    try
    {
      i = Integer.parseInt(paramLixManager.substring(paramString.length()));
      return i;
    }
    catch (NumberFormatException paramLixManager) {}
    return paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.utils.GrowthLixHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */