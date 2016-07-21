package com.linkedin.android.infra.webviewer;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.customtabs.CustomTabsIntent.Builder;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthImpl;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.webrouter.core.WebRouter;
import com.linkedin.android.webrouter.core.webclients.WebClientConfig.Builder;
import com.linkedin.android.webrouter.customtabs.CustomTabSessionGetter;
import java.util.List;
import java.util.Map;

public class WebRouterUtil
{
  private static final String TAG = WebRouterUtil.class.getSimpleName();
  
  private static String constructSettingsPageKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return "settings_" + paramString + "_webview";
    }
    return "settings_webview";
  }
  
  public static String getPerfPageKey(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    default: 
      paramString = "web_viewer";
    }
    for (;;)
    {
      return "p_flagship3_" + paramString;
      paramString = "feed_web_viewer";
      continue;
      paramString = constructSettingsPageKey(paramString);
      continue;
      paramString = "job_apply_website";
      continue;
      paramString = "profile_view_web_viewer";
      continue;
      paramString = "groups_web_viewer";
      continue;
      paramString = "messaging_web_viewer";
    }
  }
  
  private void launchWebViewer(WebViewerBundle paramWebViewerBundle, Activity paramActivity, WebRouter paramWebRouter, LixManager paramLixManager, IntentRegistry paramIntentRegistry, boolean paramBoolean)
  {
    if (!"enabled".equals(paramLixManager.getTreatment(Lix.INFRA_USE_WEB_ROUTER)))
    {
      paramActivity.startActivity(webViewer.newIntent(paramActivity, paramWebViewerBundle));
      return;
    }
    paramIntentRegistry = new WebClientConfig.Builder();
    label60:
    Object localObject1;
    Object localObject3;
    Update localUpdate;
    Object localObject2;
    Object localObject4;
    if (customTabSessionGetter != null)
    {
      paramLixManager = customTabSessionGetter.get();
      paramLixManager = new CustomTabsIntent.Builder(paramLixManager);
      localObject1 = paramWebViewerBundle.build();
      paramWebViewerBundle = WebViewerBundle.getUrl((Bundle)localObject1);
      localObject3 = WebViewerBundle.getTitle((Bundle)localObject1);
      localUpdate = WebViewerBundle.getUpdate((Bundle)localObject1);
      localObject2 = paramActivity.getApplicationContext();
      i = ContextCompat.getColor((Context)localObject2, 2131624108);
      mIntent.putExtra("android.support.customtabs.extra.TOOLBAR_COLOR", i);
      mIntent.putExtra("android.support.customtabs.extra.TITLE_VISIBILITY", 1);
      localObject4 = new Intent(paramActivity, WebRouterActivity.class);
      ((Intent)localObject4).putExtra("Share Article", true);
      ((Intent)localObject4).putExtra("url", paramWebViewerBundle);
      if (localUpdate != null)
      {
        if (tracking != null)
        {
          ((Intent)localObject4).putExtra("update_tracking_request_id", tracking.requestId);
          ((Intent)localObject4).putExtra("update_tracking_tracking_id", tracking.trackingId);
        }
        if (urn != null) {
          ((Intent)localObject4).putExtra("update_urn", urn.toString());
        }
      }
      localObject4 = PendingIntent.getActivity((Context)localObject2, 0, (Intent)localObject4, 134217728);
      if (!"control".equals(Util.getAppComponent((Context)localObject2).lixManager().getTreatment(Lix.SHARING_NEW_SHARE_ICON))) {
        break label951;
      }
    }
    label951:
    for (int i = 2130838331;; i = 2130838335)
    {
      Object localObject5 = PhotoUtils.replaceBitmapColor(BitmapFactory.decodeResource(((Context)localObject2).getResources(), i), ContextCompat.getColor((Context)localObject2, 2131624058));
      Object localObject6 = ((Context)localObject2).getResources().getString(2131233738);
      Bundle localBundle = new Bundle();
      localBundle.putParcelable("android.support.customtabs.customaction.ICON", (Parcelable)localObject5);
      localBundle.putString("android.support.customtabs.customaction.DESCRIPTION", (String)localObject6);
      localBundle.putParcelable("android.support.customtabs.customaction.PENDING_INTENT", (Parcelable)localObject4);
      mIntent.putExtra("android.support.customtabs.extra.ACTION_BUTTON_BUNDLE", localBundle);
      mIntent.putExtra("android.support.customtabs.extra.TINT_ACTION_BUTTON", true);
      localObject4 = new Intent(paramActivity, WebRouterActivity.class);
      ((Intent)localObject4).putExtra("Copy Link", true);
      ((Intent)localObject4).putExtra("url", paramWebViewerBundle);
      if (localUpdate != null)
      {
        if (tracking != null)
        {
          ((Intent)localObject4).putExtra("update_tracking_request_id", tracking.requestId);
          ((Intent)localObject4).putExtra("update_tracking_tracking_id", tracking.trackingId);
        }
        if (urn != null) {
          ((Intent)localObject4).putExtra("update_urn", urn.toString());
        }
      }
      localObject4 = PendingIntent.getActivity((Context)localObject2, 1, (Intent)localObject4, 134217728);
      localObject5 = new Intent(paramActivity, WebRouterActivity.class);
      ((Intent)localObject5).putExtra("Open In Browser", true);
      ((Intent)localObject5).putExtra("url", paramWebViewerBundle);
      if (localUpdate != null)
      {
        if (tracking != null)
        {
          ((Intent)localObject5).putExtra("update_tracking_request_id", tracking.requestId);
          ((Intent)localObject5).putExtra("update_tracking_tracking_id", tracking.trackingId);
        }
        if (urn != null) {
          ((Intent)localObject5).putExtra("update_urn", urn.toString());
        }
      }
      localObject5 = PendingIntent.getActivity((Context)localObject2, 2, (Intent)localObject5, 134217728);
      localObject6 = new Intent(paramActivity, WebRouterActivity.class);
      ((Intent)localObject6).putExtra("Mail", true);
      ((Intent)localObject6).putExtra("title", (String)localObject3);
      ((Intent)localObject6).putExtra("url", paramWebViewerBundle);
      if (localUpdate != null)
      {
        if (tracking != null)
        {
          ((Intent)localObject6).putExtra("update_tracking_request_id", tracking.requestId);
          ((Intent)localObject6).putExtra("update_tracking_tracking_id", tracking.trackingId);
        }
        if (urn != null) {
          ((Intent)localObject6).putExtra("update_urn", urn.toString());
        }
      }
      localObject3 = PendingIntent.getActivity((Context)localObject2, 3, (Intent)localObject6, 134217728);
      paramLixManager.addMenuItem(((Context)localObject2).getResources().getString(2131233734), (PendingIntent)localObject4);
      paramLixManager.addMenuItem(((Context)localObject2).getResources().getString(2131233735), (PendingIntent)localObject5);
      paramLixManager.addMenuItem(((Context)localObject2).getResources().getString(2131233736), (PendingIntent)localObject3);
      if (Build.VERSION.SDK_INT > 15)
      {
        mStartAnimationBundle = ActivityOptions.makeCustomAnimation((Context)localObject2, 2131034140, 2131034141).toBundle();
        localObject2 = ActivityOptions.makeCustomAnimation((Context)localObject2, 2131034140, 2131034141).toBundle();
        mIntent.putExtra("android.support.customtabs.extra.EXIT_ANIMATION_BUNDLE", (Bundle)localObject2);
      }
      configExtras = ((Bundle)localObject1);
      forceIgnoreDeeplink = paramBoolean;
      localObject1 = new ArrayMap();
      ((Map)localObject1).put("Referer", "http://lnkd.in/");
      customRequestHeaders = ((Map)localObject1);
      if (!WebViewerUtils.isLinkedinUrl(paramWebViewerBundle)) {
        break label1052;
      }
      paramActivity = paramActivity.getApplicationContext();
      localObject1 = CookieManager.getInstance();
      localObject2 = LiAuthProvider.getInstance(paramActivity).getHttpStack();
      if (((HttpStack)localObject2).getCookieNameValuePairs(LiAuthImpl.cookieDomainSpec).isEmpty()) {
        break;
      }
      if (localObject1 != null) {
        break label959;
      }
      Log.e(TAG, "Cookie Manager is null");
      return;
      paramLixManager = null;
      break label60;
    }
    label959:
    if (Build.VERSION.SDK_INT >= 21)
    {
      ((CookieManager)localObject1).setAcceptCookie(true);
      ((CookieManager)localObject1).removeAllCookies(new WebRouterUtil.1(this, (HttpStack)localObject2, (CookieManager)localObject1, paramWebRouter, paramWebViewerBundle, paramIntentRegistry, paramLixManager));
      return;
    }
    CookieSyncManager.createInstance(paramActivity);
    ((CookieManager)localObject1).setAcceptCookie(true);
    ((CookieManager)localObject1).removeAllCookie();
    ((HttpStack)localObject2).addCookiesToCookieManager((CookieManager)localObject1);
    CookieSyncManager.getInstance().sync();
    paramWebViewerBundle = Uri.parse(paramWebViewerBundle);
    customTabsIntent = paramLixManager;
    paramWebRouter.launchUrl$7846e775(paramWebViewerBundle, paramIntentRegistry.build());
    return;
    label1052:
    paramWebViewerBundle = Uri.parse(paramWebViewerBundle);
    customTabsIntent = paramLixManager;
    paramWebRouter.launchUrl$7846e775(paramWebViewerBundle, paramIntentRegistry.build());
  }
  
  public static String pageKey(int paramInt, String paramString)
  {
    switch (paramInt)
    {
    case 6: 
    case 7: 
    default: 
      return "feed_web_viewer";
    case 0: 
    case 1: 
    case 2: 
      return "feed_web_viewer";
    case 3: 
      return constructSettingsPageKey(paramString);
    case 4: 
      return "job_apply_website";
    case 5: 
      return "profile_view_web_viewer";
    }
    return "profinder_service_proposal";
  }
  
  public static boolean shouldForceIgnoreDeeplink(String paramString)
  {
    return (WebViewerUtils.isLinkedinUrl(paramString)) || (WebViewerUtils.isLinkedInArticleUrl(paramString));
  }
  
  public static boolean shouldTrack(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      Util.safeThrow(new RuntimeException("Unable to determine tracking enabled for web view usage " + paramInt));
    case -1: 
    case 6: 
    case 7: 
      return false;
    }
    return true;
  }
  
  public final void launchWebViewer(WebViewerBundle paramWebViewerBundle, ActivityComponent paramActivityComponent, boolean paramBoolean)
  {
    launchWebViewer(paramWebViewerBundle, paramActivityComponent.activity(), paramActivityComponent.webRouter(), paramActivityComponent.lixManager(), paramActivityComponent.intentRegistry(), paramBoolean);
  }
  
  public final void launchWebViewer(WebViewerBundle paramWebViewerBundle, FragmentComponent paramFragmentComponent, boolean paramBoolean)
  {
    launchWebViewer(paramWebViewerBundle, paramFragmentComponent.activity(), paramFragmentComponent.webRouter(), paramFragmentComponent.lixManager(), paramFragmentComponent.intentRegistry(), paramBoolean);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebRouterUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */