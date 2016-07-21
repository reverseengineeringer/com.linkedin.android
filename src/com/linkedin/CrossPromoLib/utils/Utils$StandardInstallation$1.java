package com.linkedin.CrossPromoLib.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;

final class Utils$StandardInstallation$1
  implements View.OnClickListener
{
  Utils$StandardInstallation$1(Utils.StandardInstallation paramStandardInstallation, String paramString1, Context paramContext, String paramString2, String paramString3, NonMarketUrlRunnable paramNonMarketUrlRunnable, Runnable paramRunnable) {}
  
  public final void onClick(View paramView)
  {
    paramView = null;
    int j = 1;
    Object localObject;
    int i;
    if (!TextUtils.isEmpty(val$actionUrl))
    {
      if (val$actionUrl.contains("://")) {
        paramView = Utils.StandardInstallation.access$000(val$context, new Intent("android.intent.action.VIEW", Uri.parse(val$actionUrl)));
      }
    }
    else
    {
      localObject = paramView;
      if (paramView == null)
      {
        localObject = paramView;
        if (!TextUtils.isEmpty(val$appId))
        {
          localObject = paramView;
          if (this$0.isAppInstalled(val$context, val$appId)) {
            localObject = Utils.StandardInstallation.access$000(val$context, Utils.createOpenApplicationIntent(val$context, val$appId));
          }
        }
      }
      paramView = (View)localObject;
      i = j;
      if (localObject == null)
      {
        paramView = (View)localObject;
        i = j;
        if (!TextUtils.isEmpty(val$storeUrl))
        {
          paramView = Utils.StandardInstallation.access$100(val$storeUrl);
          if (paramView == null) {
            break label279;
          }
          paramView = Utils.StandardInstallation.access$000(val$context, new Intent("android.intent.action.VIEW", Uri.parse(paramView)));
          i = j;
        }
      }
    }
    for (;;)
    {
      localObject = paramView;
      if (paramView == null)
      {
        localObject = paramView;
        if (!TextUtils.isEmpty(val$appId)) {
          localObject = Utils.StandardInstallation.access$000(val$context, Utils.createGooglePlayStoreIntent(val$appId, Utils.access$200(val$storeUrl)));
        }
      }
      if ((localObject != null) && (i != 0))
      {
        ((Intent)localObject).setFlags(268435456);
        val$context.startActivity((Intent)localObject);
      }
      if (val$afterStart != null) {}
      try
      {
        val$afterStart.run();
        return;
      }
      catch (Exception paramView)
      {
        label279:
        Log.w("Utils", val$afterStart.toString(), paramView);
      }
      paramView = Utils.StandardInstallation.access$000(val$context, new Intent(val$actionUrl));
      break;
      paramView = (View)localObject;
      i = j;
      if (val$handleNonMarketUrl != null)
      {
        val$handleNonMarketUrl.storeUrl = val$storeUrl;
        val$handleNonMarketUrl.run();
        i = 0;
        paramView = (View)localObject;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Utils.StandardInstallation.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */