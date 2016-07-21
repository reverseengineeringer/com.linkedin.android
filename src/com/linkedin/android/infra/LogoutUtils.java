package com.linkedin.android.infra;

import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.appwidget.AppWidgetUtils;
import com.linkedin.android.authenticator.AccountChangeReceiver;
import com.linkedin.android.developer.OAuthNetworkHelper;
import com.linkedin.android.feed.page.feed.newupdatespill.CheckForNewUpdatesRunnable;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipCacheManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.FlagshipSharedPreferences.KeepPreferences;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.CalendarTaskUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.l2m.notification.PackageReplacedReceiver;
import com.linkedin.android.liauthlib.common.LiAuthResponse.AuthListener;
import com.linkedin.android.networking.cookies.CookieUtil;
import com.linkedin.android.networking.interfaces.RequestDelegate;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.request.AbstractRequest;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.messengerlib.database.MessengerProvider;
import com.linkedin.messengerlib.shared.StickerUtils;
import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class LogoutUtils
{
  private static final String TAG = LogoutUtils.class.getSimpleName();
  
  public static LiAuthResponse.AuthListener createSignOutListener(ApplicationComponent paramApplicationComponent, boolean paramBoolean)
  {
    return new LogoutUtils.1(paramBoolean, paramApplicationComponent);
  }
  
  public static void onSignout(ApplicationComponent paramApplicationComponent)
  {
    paramApplicationComponent.eventBus();
    Bus.publish(new LogoutEvent());
    Object localObject1 = paramApplicationComponent.oAuthNetworkHelper();
    Object localObject2 = flagshipSharedPreferences.getPreferences().getString("oauth2_token_ss", null);
    Object localObject4;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject3 = new ArrayMap();
      ((Map)localObject3).put("X-IsAJAXForm", "1");
      localObject4 = new ArrayMap();
      ((Map)localObject4).put("oauth2Token", localObject2);
      localObject2 = createsetAdditionalHeaderssetParams"application/x-www-form-urlencoded"requestDelegate;
      localObject3 = networkClient.factory;
      localObject4 = context;
      localObject2 = ((RequestFactory)localObject3).getRelativeRequest$3868be9b(1, "/uas/oauth2/revokeToken", null, (RequestDelegate)localObject2);
      networkClient.add((AbstractRequest)localObject2);
      flagshipSharedPreferences.getPreferences().edit().remove("oauth2_token_ss").apply();
    }
    localObject1 = paramApplicationComponent.flagshipSharedPreferences();
    localObject2 = new FlagshipSharedPreferences.KeepPreferences((FlagshipSharedPreferences)localObject1, (byte)0);
    baseUrl = this$0.getBaseUrl();
    authUrl = this$0.getAuthUrl();
    cleanExitState = this$0.getPreferences().getBoolean("cleanExitState", true);
    lastCrashSummary = this$0.getLastCrashSummary();
    lastCrashDetails = this$0.getLastCrashDetails();
    Object localObject3 = FlagshipSharedPreferences.access$100(this$0);
    this$0.setAbiAutoSync(this$0.isAbiAutoSync((String)localObject3), (String)localObject3);
    localObject3 = this$0.getPreferences().getAll();
    if (localObject3 != null)
    {
      localObject3 = ((Map)localObject3).keySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (String)((Iterator)localObject3).next();
        if (((String)localObject4).startsWith("abi_autosync_on_for_member_")) {
          memberSpecificAutoSyncMap.put(localObject4, Boolean.valueOf(this$0.getPreferences().getBoolean((String)localObject4, false)));
        }
      }
    }
    advertiserId = this$0.getAdvertiserId();
    isAdtrackingLimited = this$0.getIsAdtrackingLimited();
    lastAttemptedSyncTime = this$0.getLastAttemptedAdvertiserIdSyncTime();
    boostEligibilityModel = this$0.getBoostEligibilityModelString();
    ((FlagshipSharedPreferences)localObject1).getPreferences().edit().clear().apply();
    this$0.setBaseUrl(baseUrl);
    this$0.setAuthUrl(authUrl);
    this$0.setCleanExitState(cleanExitState);
    this$0.recordCrash(lastCrashSummary, lastCrashDetails);
    localObject3 = memberSpecificAutoSyncMap.entrySet().iterator();
    Object localObject5;
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      localObject5 = this$0;
      localObject1 = (String)((Map.Entry)localObject4).getKey();
      if ((localObject1 == null) || (!((String)localObject1).startsWith("abi_autosync_on_for_member_"))) {}
      for (localObject1 = "";; localObject1 = ((String)localObject1).substring(27))
      {
        ((FlagshipSharedPreferences)localObject5).setAbiAutoSyncMemberSpecific((String)localObject1, ((Boolean)((Map.Entry)localObject4).getValue()).booleanValue());
        break;
      }
    }
    this$0.setAdvertiserId(advertiserId);
    this$0.setIsAdtrackingLimited(isAdtrackingLimited);
    this$0.setLastAttemptedAdvertiserIdSyncTime(lastAttemptedSyncTime);
    this$0.setBoostEligibilityModelString(boostEligibilityModel);
    ContactSyncAdapter.removeAllLinkedInAccounts(paramApplicationComponent.appContext());
    paramApplicationComponent.flagshipCacheManager().clear();
    MessengerProvider.clearDatabase();
    memberUtilmeModel = null;
    paramApplicationComponent.lixManager().clearAllTreatments();
    localObject1 = paramApplicationComponent.cookieUtil();
    localObject2 = new ArrayMap();
    localObject3 = ((CookieUtil)localObject1).cookieManager().getCookieStore().getURIs().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (URI)((Iterator)localObject3).next();
      localObject5 = ((CookieUtil)localObject1).cookieManager().getCookieStore().get((URI)localObject4).iterator();
      while (((Iterator)localObject5).hasNext())
      {
        HttpCookie localHttpCookie = (HttpCookie)((Iterator)localObject5).next();
        if (CookieUtil.SAVED_COOKIES.contains(localHttpCookie.getName())) {
          if (((Map)localObject2).containsKey(localObject4))
          {
            ((List)((Map)localObject2).get(localObject4)).add(localHttpCookie);
          }
          else
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(localHttpCookie);
            ((Map)localObject2).put(localObject4, localArrayList);
          }
        }
      }
    }
    ((CookieUtil)localObject1).cookieManager().getCookieStore().removeAll();
    localObject2 = ((Map)localObject2).entrySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject2).next();
      localObject4 = ((List)((Map.Entry)localObject3).getValue()).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (HttpCookie)((Iterator)localObject4).next();
        ((CookieUtil)localObject1).cookieManager().getCookieStore().add((URI)((Map.Entry)localObject3).getKey(), (HttpCookie)localObject5);
      }
    }
    paramApplicationComponent.calendarTaskUtil().unregisterTask();
    profilePendingConnectionRequestManagerpendingStates.clear();
    updateChangeCoordinatorcollapsedUpdates.clear();
    AppWidgetUtils.handleSignout(paramApplicationComponent);
    paramApplicationComponent.newUpdatesChecker().stop();
    StickerUtils.clearStickerFiles(paramApplicationComponent.appContext());
    Util.setComponentEnabled(paramApplicationComponent.appContext(), PackageReplacedReceiver.class, false);
    Util.setComponentEnabled(paramApplicationComponent.appContext(), AccountChangeReceiver.class, false);
    ((NotificationManager)paramApplicationComponent.appContext().getSystemService("notification")).cancelAll();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.LogoutUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */