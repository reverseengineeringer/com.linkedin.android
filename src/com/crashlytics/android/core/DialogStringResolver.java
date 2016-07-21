package com.crashlytics.android.core;

import android.content.Context;
import io.fabric.sdk.android.services.common.CommonUtils;
import io.fabric.sdk.android.services.settings.PromptSettingsData;

final class DialogStringResolver
{
  private final Context context;
  final PromptSettingsData promptData;
  
  public DialogStringResolver(Context paramContext, PromptSettingsData paramPromptSettingsData)
  {
    context = paramContext;
    promptData = paramPromptSettingsData;
  }
  
  final String resourceOrFallbackValue(String paramString1, String paramString2)
  {
    paramString1 = CommonUtils.getStringsFileValue(context, paramString1);
    if ((paramString1 == null) || (paramString1.length() == 0)) {}
    for (int i = 1; i != 0; i = 0) {
      return paramString2;
    }
    return paramString1;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.core.DialogStringResolver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */