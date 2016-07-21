package com.linkedin.android.infra.data;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.growth.calendar.sync.CalendarMetadata;
import com.linkedin.android.growth.contactsync.ContactSyncAdapter;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.events.MeUpdatedEvent;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Me;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;

public final class FlagshipSharedPreferences
  extends BaseSharedPreferences
{
  public static final long BACKGROUND_SESSION_THRESHOLD = TimeUnit.MINUTES.toMillis(30L);
  
  @Inject
  public FlagshipSharedPreferences(Context paramContext, ExecutorService paramExecutorService)
  {
    super(paramContext, paramExecutorService, "linkedInPrefsName");
  }
  
  private String getProfileId()
  {
    String str = getMeModelString();
    if (str != null) {
      try
      {
        str = PARSER_FACTORYcreateParserparseRecordByteArrayInputStreamgetBytesBUILDERminiProfile.entityUrn.getId();
        return str;
      }
      catch (DataReaderException localDataReaderException)
      {
        Log.e("FlagshipSharedPreferences", "Error reading Me for saving ABI sync member specific preference", localDataReaderException);
      }
    }
    return null;
  }
  
  public final long getAbiLastReadMaxContactId()
  {
    return getPreferences().getLong("abi_last_read_max_contact_id", 0L);
  }
  
  public final String getAdvertiserId()
  {
    return getPreferences().getString("advertiserId", "");
  }
  
  public final long getAppBadgeCount()
  {
    return getPreferences().getLong("appBadgeCount", 0L);
  }
  
  public final long getAppLastBackgroundTimeStamp()
  {
    return getPreferences().getLong("appLastBackground", 0L);
  }
  
  public final String getAuthUrl()
  {
    if (ActivityManager.isUserAMonkey()) {
      return "https://www.linkedin-ei.com";
    }
    return getPreferences().getString("baseUrl", "https://www.linkedin.com");
  }
  
  public final long getBadgeCount(HomeTabInfo paramHomeTabInfo)
  {
    return getPreferences().getLong("badgeCount_" + HomeTabInfo.idForTab(paramHomeTabInfo), 0L);
  }
  
  public final long getBadgeLastUpdateTimeStamp(HomeTabInfo paramHomeTabInfo)
  {
    return getPreferences().getLong("badgeLastUpdate" + HomeTabInfo.idForTab(paramHomeTabInfo), 0L);
  }
  
  public final String getBaseUrl()
  {
    if (ActivityManager.isUserAMonkey()) {
      return "https://www.linkedin-ei.com";
    }
    return getPreferences().getString("baseUrl", "https://www.linkedin.com");
  }
  
  public final String getBoostEligibilityModelString()
  {
    return getPreferences().getString("boostEligibilityModel", null);
  }
  
  public final boolean getCalendarSyncEnabled()
  {
    return getPreferences().getBoolean("calendarSyncStatus", false);
  }
  
  public final List<CalendarMetadata> getCalendarSyncPreferences()
  {
    Object localObject = getPreferences().getString("calendarSyncPreferences", new JSONArray().toString());
    try
    {
      localObject = CalendarMetadata.fromPreferencesJson(new JSONArray((String)localObject));
      return (List<CalendarMetadata>)localObject;
    }
    catch (JSONException localJSONException)
    {
      Util.safeThrow$7a8b4789(new RuntimeException(localJSONException));
    }
    return new ArrayList();
  }
  
  public final int getContactAddressBookSyncType()
  {
    return getPreferences().getInt("acContactsOption", 2);
  }
  
  public final boolean getDevTokenUserSelection()
  {
    return getPreferences().getBoolean("dev_token_user_selection", false);
  }
  
  public final boolean getInsertUnfollowEducateCard()
  {
    return getPreferences().getBoolean("insertUnfollowEducate", false);
  }
  
  public final long[] getInstalledStickerPackIds()
  {
    String[] arrayOfString = TextUtils.split(getPreferences().getString("stickerPacks", ""), ",");
    long[] arrayOfLong3 = new long[arrayOfString.length];
    int i = 0;
    long[] arrayOfLong2;
    for (;;)
    {
      long[] arrayOfLong1 = arrayOfLong3;
      if (i < arrayOfString.length) {
        try
        {
          arrayOfLong3[i] = Long.parseLong(arrayOfString[i]);
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          arrayOfLong2 = new long[0];
        }
      }
    }
    return arrayOfLong2;
  }
  
  public final boolean getIsAdtrackingLimited()
  {
    return getPreferences().getBoolean("isAdTrackingLimited", false);
  }
  
  public final HomeTabInfo getLastActiveTab()
  {
    if (System.currentTimeMillis() - getAppLastBackgroundTimeStamp() < BACKGROUND_SESSION_THRESHOLD) {
      return HomeTabInfo.tabForId(getPreferences().getInt("lastActiveTab", HomeTabInfo.idForTab(HomeTabInfo.getDefault())));
    }
    return HomeTabInfo.getDefault();
  }
  
  public final long getLastAttemptedAdvertiserIdSyncTime()
  {
    return getPreferences().getLong("lastAttemptedAdvertiserIdSyncTime", 0L);
  }
  
  public final String getLastCrashDetails()
  {
    return getPreferences().getString("lastCrashDetails", "");
  }
  
  public final String getLastCrashSummary()
  {
    return getPreferences().getString("lastCrashSummary", "");
  }
  
  public final String getMeModelString()
  {
    return getPreferences().getString("meModel", null);
  }
  
  public final String getMemberEmail()
  {
    return getPreferences().getString("memberEmail", null);
  }
  
  public final String getNewToVoyagerLegoTrackingToken()
  {
    return getPreferences().getString("newToVoyagerLegoTrackingToken", null);
  }
  
  public final int getNotificationAction(String paramString)
  {
    return getPreferences().getInt("notificationAction" + paramString, 0);
  }
  
  public final String getNotificationToken()
  {
    return getPreferences().getString("notificationToken", null);
  }
  
  public final boolean getShowCustomizingYourFeedView()
  {
    return getPreferences().getBoolean("showLoadingView", false);
  }
  
  @Deprecated
  public final boolean isAbiAutoSync()
  {
    boolean bool = false;
    if ((getPreferences().getBoolean("abi_autosync_on", false)) || (isAbiAutoSync(getProfileId()))) {
      bool = true;
    }
    return bool;
  }
  
  public final boolean isAbiAutoSync(String paramString)
  {
    boolean bool1 = false;
    boolean bool2 = getPreferences().getBoolean("abi_autosync_on", false);
    int i = 0;
    if (paramString != null) {
      if ((paramString == null) || (!getPreferences().getBoolean("abi_autosync_on_for_member_" + paramString, false))) {
        break label72;
      }
    }
    label72:
    for (i = 1;; i = 0)
    {
      if ((bool2) || (i != 0)) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final boolean isReadTheArticle()
  {
    return getPreferences().getBoolean("userHasReadTheArticleAndScroll", false);
  }
  
  public final boolean isShakyEnabled()
  {
    return getPreferences().getBoolean("isShakyEnabled", true);
  }
  
  public final void onEvent(MeUpdatedEvent paramMeUpdatedEvent)
  {
    if ((oldMe == null) && (!fromCache)) {
      ContactSyncAdapter.requestAccountSync(appContext);
    }
  }
  
  @SuppressLint({"CommitPrefEdits"})
  public final void recordCrash(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = getPreferences().edit();
    localEditor.putString("lastCrashSummary", paramString1);
    localEditor.putString("lastCrashDetails", paramString2);
    localEditor.putBoolean("cleanExitState", false);
    localEditor.commit();
  }
  
  public final void removeInstallationState()
  {
    getPreferences().edit().remove("installationState").apply();
  }
  
  public final void resetNewToVoyagerLegoTrackingToken()
  {
    getPreferences().edit().putString("newToVoyagerLegoTrackingToken", null).apply();
  }
  
  public final void saveHasNewAutoSyncContactsToToast(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("hasNewAutoSyncContactsToToast", paramBoolean).apply();
  }
  
  public final void saveNotificationAction(String paramString, int paramInt)
  {
    getPreferences().edit().putInt("notificationAction" + paramString, paramInt).commit();
  }
  
  public final void setAbiAutoSync(boolean paramBoolean, String paramString)
  {
    getPreferences().edit().putBoolean("abi_autosync_on", paramBoolean).apply();
    if (paramString != null) {
      setAbiAutoSyncMemberSpecific(paramString, paramBoolean);
    }
  }
  
  public final void setAbiAutoSyncMemberSpecific(String paramString, boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("abi_autosync_on_for_member_" + paramString, paramBoolean).apply();
  }
  
  public final void setAbiLastSyncTimestamp(long paramLong)
  {
    getPreferences().edit().putLong("abi_last_sync_timestamp", paramLong).apply();
  }
  
  public final void setAbiLastUploadedMaxContactId(long paramLong)
  {
    getPreferences().edit().putLong("abi_last_uploaded_max_contact_id", paramLong).apply();
  }
  
  public final void setAdvertiserId(String paramString)
  {
    getPreferences().edit().putString("advertiserId", paramString).apply();
  }
  
  public final void setAppBadgeCount(long paramLong)
  {
    getPreferences().edit().putLong("appBadgeCount", paramLong).apply();
  }
  
  public final void setAuthUrl(String paramString)
  {
    getPreferences().edit().putString("authUrl", paramString).apply();
  }
  
  public final void setBaseUrl(String paramString)
  {
    getPreferences().edit().putString("baseUrl", paramString).apply();
  }
  
  public final void setBoostEligibilityModelString(String paramString)
  {
    if (paramString != null) {
      getPreferences().edit().putString("boostEligibilityModel", paramString).apply();
    }
  }
  
  public final void setCalendarSyncEnabled(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("calendarSyncStatus", paramBoolean).apply();
  }
  
  public final void setCalendarSyncPreferences(List<CalendarMetadata> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localJSONArray.put(((CalendarMetadata)paramList.next()).toJson());
    }
    getPreferences().edit().putString("calendarSyncPreferences", localJSONArray.toString()).apply();
  }
  
  public final void setCleanExitState(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("cleanExitState", paramBoolean).commit();
  }
  
  public final void setConnectionStoreInitialized(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("connectionStoreInitialized", paramBoolean).apply();
  }
  
  public final void setContactAddressBookSyncType(int paramInt)
  {
    if (getContactAddressBookSyncType() != paramInt)
    {
      getPreferences().edit().putInt("acContactsOption", paramInt).apply();
      ContactSyncAdapter.requestAccountSync(appContext);
    }
  }
  
  public final void setDefaultShareVisibility(int paramInt)
  {
    getPreferences().edit().putInt("defaultShareVisibility", paramInt).apply();
  }
  
  public final void setDevTokenUserSelection(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("dev_token_user_selection", paramBoolean).apply();
  }
  
  public final void setInsertUnfollowEducateCard(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("insertUnfollowEducate", paramBoolean).apply();
  }
  
  public final void setInstallationState(Uri paramUri)
  {
    getPreferences().edit().putString("installationState", paramUri.toString()).apply();
  }
  
  public final void setIsAdtrackingLimited(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("isAdTrackingLimited", paramBoolean).apply();
  }
  
  public final void setLastActiveTab(HomeTabInfo paramHomeTabInfo)
  {
    getPreferences().edit().putInt("lastActiveTab", HomeTabInfo.idForTab(paramHomeTabInfo)).apply();
  }
  
  public final void setLastAttemptedAdvertiserIdSyncTime(long paramLong)
  {
    getPreferences().edit().putLong("lastAttemptedAdvertiserIdSyncTime", paramLong).apply();
  }
  
  public final void setMemberEmail(String paramString)
  {
    if (Patterns.EMAIL_ADDRESS.matcher(paramString.trim()).matches()) {
      getPreferences().edit().putString("memberEmail", paramString).apply();
    }
  }
  
  public final void setNewToVoyagerLegoTrackingToken(String paramString)
  {
    getPreferences().edit().putString("newToVoyagerLegoTrackingToken", paramString).apply();
  }
  
  public final void setReadTheArticle(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("userHasReadTheArticleAndScroll", paramBoolean).apply();
  }
  
  public final void setSamsungOAuth2Token(String paramString)
  {
    getPreferences().edit().putString("oauth2_token_ss", paramString).apply();
  }
  
  public final void setShowCustomizingYourFeedView(boolean paramBoolean)
  {
    getPreferences().edit().putBoolean("showLoadingView", paramBoolean).apply();
  }
  
  public final boolean shouldLimitNetworkCalls()
  {
    return getPreferences().getBoolean("addColdLaunchNetworkDoLimit", false);
  }
  
  public final boolean wasLastExitDueToCrash()
  {
    return (!getPreferences().getBoolean("cleanExitState", true)) && (!TextUtils.isEmpty(getLastCrashSummary()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.data.FlagshipSharedPreferences
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */