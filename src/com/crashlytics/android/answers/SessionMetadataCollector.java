package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.common.IdManager;

final class SessionMetadataCollector
{
  final Context context;
  final IdManager idManager;
  final String versionCode;
  final String versionName;
  
  public SessionMetadataCollector(Context paramContext, IdManager paramIdManager, String paramString1, String paramString2)
  {
    context = paramContext;
    idManager = paramIdManager;
    versionCode = paramString1;
    versionName = paramString2;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.SessionMetadataCollector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */