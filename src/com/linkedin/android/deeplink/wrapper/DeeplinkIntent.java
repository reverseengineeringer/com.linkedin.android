package com.linkedin.android.deeplink.wrapper;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;

public abstract interface DeeplinkIntent
{
  public abstract Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes);
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.wrapper.DeeplinkIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */