package com.linkedin.messengerlib.utils;

import android.content.Context;
import com.linkedin.android.internationalization.InternationalizationManager;
import com.linkedin.android.internationalization.LocaleManager;
import com.linkedin.android.internationalization.LocalizeStringApi;
import com.linkedin.android.networking.interfaces.InternationalizationApi;

public final class I18NManager
  implements LocalizeStringApi, InternationalizationApi
{
  private final InternationalizationManager internationalizationManager;
  
  public I18NManager(Context paramContext)
  {
    internationalizationManager = new InternationalizationManager(paramContext.getApplicationContext());
  }
  
  public final String getCurrentLocale()
  {
    return internationalizationManager.localeManager.getCurrentLinkedInFrontEndLocaleString();
  }
  
  public final String getString(int paramInt)
  {
    return internationalizationManager.getString(paramInt);
  }
  
  public final String getString(int paramInt, Object... paramVarArgs)
  {
    return internationalizationManager.getString(paramInt, paramVarArgs);
  }
  
  public final String getString(String paramString, Object... paramVarArgs)
  {
    return internationalizationManager.getString(paramString, paramVarArgs);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.utils.I18NManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */