package com.linkedin.CrossPromoLib.utils;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import com.linkedin.CrossPromoLib.models.PromoModel;
import com.linkedin.crosspromo.common.android.RichText;
import com.linkedin.crosspromo.fe.api.android.Promo;
import java.util.Arrays;
import java.util.List;

public final class Utils
{
  public static final Installation STANDARD_INSTALLATION;
  public static volatile Installation currentInstallation;
  
  static
  {
    StandardInstallation localStandardInstallation = new StandardInstallation();
    STANDARD_INSTALLATION = localStandardInstallation;
    currentInstallation = localStandardInstallation;
  }
  
  public static Intent createGooglePlayStoreIntent(String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    try
    {
      return new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString1 + "&referrer=" + paramString2));
    }
    catch (ActivityNotFoundException paramString1) {}
    paramString1 = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + paramString1));
    return paramString1;
    return null;
  }
  
  public static View.OnClickListener createOnClickDismissListener(View paramView, final Runnable paramRunnable)
  {
    new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        val$view.setVisibility(8);
        if (paramRunnable != null) {}
        try
        {
          paramRunnable.run();
          return;
        }
        catch (Exception paramAnonymousView)
        {
          Log.w("Utils", paramRunnable.toString(), paramAnonymousView);
        }
      }
    };
  }
  
  public static View.OnClickListener createOnClickListener(Context paramContext, String paramString1, String paramString2, String paramString3, Runnable paramRunnable, NonMarketUrlRunnable paramNonMarketUrlRunnable)
  {
    if ((TextUtils.isEmpty(paramString1)) && (TextUtils.isEmpty(paramString2))) {
      return null;
    }
    return currentInstallation.createPromptListener(paramContext, paramString1, paramString2, paramString3, paramRunnable, paramNonMarketUrlRunnable);
  }
  
  public static Intent createOpenApplicationIntent(Context paramContext, String paramString)
  {
    return paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
  }
  
  private static int getOrientation(Context paramContext)
  {
    return ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRotation();
  }
  
  public static RichText getPromptText(Context paramContext, PromoModel paramPromoModel)
  {
    return currentInstallation.getPromptText(paramContext, paramPromoModel);
  }
  
  public static boolean isAppInstalled(Context paramContext, String paramString)
  {
    return currentInstallation.isAppInstalled(paramContext, paramString);
  }
  
  public static boolean isLandscapeView(Context paramContext)
  {
    return (getOrientation(paramContext) == 1) || (getOrientation(paramContext) == 3);
  }
  
  public static boolean isPortraitView(Context paramContext)
  {
    int i = getOrientation(paramContext);
    return (i == 0) || (i == 2);
  }
  
  public static boolean isValidIntent(Intent paramIntent, Context paramContext)
  {
    return (paramIntent != null) && (paramIntent.resolveActivity(paramContext.getPackageManager()) != null);
  }
  
  public static final class StandardInstallation
    implements Installation
  {
    private static final List<Pair<String, String>> MARKET_URLS = Arrays.asList(new Pair[] { new Pair("market:", "market:"), new Pair("http://play.google.com/store/apps/details?", "market://details?"), new Pair("https://play.google.com/store/apps/details?", "market://details?"), new Pair("http://play.google.com/store/search?", "market://search?"), new Pair("https://play.google.com/store/search?", "market://search?"), new Pair("http://play.google.com/store/apps/collection/", "market://apps/collection/"), new Pair("https://play.google.com/store/apps/collection/", "market://apps/collection/") });
    
    public final View.OnClickListener createPromptListener(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final Runnable paramRunnable, final NonMarketUrlRunnable paramNonMarketUrlRunnable)
    {
      new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = null;
          int j = 1;
          Object localObject;
          int i;
          if (!TextUtils.isEmpty(paramString2))
          {
            if (paramString2.contains("://")) {
              paramAnonymousView = Utils.StandardInstallation.access$000(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(paramString2)));
            }
          }
          else
          {
            localObject = paramAnonymousView;
            if (paramAnonymousView == null)
            {
              localObject = paramAnonymousView;
              if (!TextUtils.isEmpty(paramString1))
              {
                localObject = paramAnonymousView;
                if (isAppInstalled(paramContext, paramString1)) {
                  localObject = Utils.StandardInstallation.access$000(paramContext, Utils.createOpenApplicationIntent(paramContext, paramString1));
                }
              }
            }
            paramAnonymousView = (View)localObject;
            i = j;
            if (localObject == null)
            {
              paramAnonymousView = (View)localObject;
              i = j;
              if (!TextUtils.isEmpty(paramString3))
              {
                paramAnonymousView = Utils.StandardInstallation.access$100(paramString3);
                if (paramAnonymousView == null) {
                  break label279;
                }
                paramAnonymousView = Utils.StandardInstallation.access$000(paramContext, new Intent("android.intent.action.VIEW", Uri.parse(paramAnonymousView)));
                i = j;
              }
            }
          }
          for (;;)
          {
            localObject = paramAnonymousView;
            if (paramAnonymousView == null)
            {
              localObject = paramAnonymousView;
              if (!TextUtils.isEmpty(paramString1)) {
                localObject = Utils.StandardInstallation.access$000(paramContext, Utils.createGooglePlayStoreIntent(paramString1, Utils.access$200(paramString3)));
              }
            }
            if ((localObject != null) && (i != 0))
            {
              ((Intent)localObject).setFlags(268435456);
              paramContext.startActivity((Intent)localObject);
            }
            if (paramRunnable != null) {}
            try
            {
              paramRunnable.run();
              return;
            }
            catch (Exception paramAnonymousView)
            {
              label279:
              Log.w("Utils", paramRunnable.toString(), paramAnonymousView);
            }
            paramAnonymousView = Utils.StandardInstallation.access$000(paramContext, new Intent(paramString2));
            break;
            paramAnonymousView = (View)localObject;
            i = j;
            if (paramNonMarketUrlRunnable != null)
            {
              paramNonMarketUrlRunnablestoreUrl = paramString3;
              paramNonMarketUrlRunnable.run();
              i = 0;
              paramAnonymousView = (View)localObject;
            }
          }
        }
      };
    }
    
    public final RichText getPromptText(Context paramContext, PromoModel paramPromoModel)
    {
      Promo localPromo = promo;
      if ((localPromo != null) && (appId != null) && (isAppInstalled(paramContext, appId))) {
        return paramPromoModel.getPromptTextOpen();
      }
      return paramPromoModel.getPromptTextDownload();
    }
    
    public final boolean isAppInstalled(Context paramContext, String paramString)
    {
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getPackageInfo(paramString, 1);
        return true;
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        Log.d("Utils", "app package " + paramString + " not found");
      }
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.CrossPromoLib.utils.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */