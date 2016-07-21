package com.linkedin.android.infra;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.VoyagerActivityCallbacks;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixHelper;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.logger.FileLog;
import com.linkedin.android.shaky.ShakeDelegate;
import java.io.File;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class VoyagerShakeDelegate
  extends ShakeDelegate
{
  private static final String[] DIVISION_EMAILS = { "feed", "me", "notifications", "messaging", "people", "search", "profile", "reg", "onboarding", "abi", "ge", "settings" };
  private static final String[] ENTITY_SUB_DIVISIONS = { "company", "school", "job" };
  private static final String[] GROUPS_DIVISIONS = { "group", "groups" };
  private static final String[] PROFILE_EDIT_SUB_DIVISIONS = { "add", "edit", "hub", "crop" };
  private static final String[] PUBLISHING_DIVISIONS = { "pulse" };
  private static final String[] PUBLISHING_KEYS = { "pulse_read", "feed_share", "feed_reshare", "feed_reshare_share", "feed_share_link" };
  private static String[] pageKeys = new String[5];
  private final Context appContext;
  private final LixManager lixManager;
  private final MemberUtil memberUtil;
  private final FlagshipSharedPreferences sharedPreferences;
  
  public VoyagerShakeDelegate(Context paramContext, LixManager paramLixManager, MemberUtil paramMemberUtil, FlagshipSharedPreferences paramFlagshipSharedPreferences)
  {
    appContext = paramContext;
    lixManager = paramLixManager;
    memberUtil = paramMemberUtil;
    sharedPreferences = paramFlagshipSharedPreferences;
  }
  
  private void appendDataForFragment(Fragment paramFragment, StringBuilder paramStringBuilder)
  {
    if (paramFragment == null) {}
    for (;;)
    {
      return;
      if ((paramFragment instanceof ShakeDebugDataProvider))
      {
        String str = ((ShakeDebugDataProvider)paramFragment).provideDebugData();
        if (!TextUtils.isEmpty(str))
        {
          paramStringBuilder.append(str);
          paramStringBuilder.append('\n');
        }
      }
      paramFragment = paramFragment.getChildFragmentManager().getFragments();
      if (paramFragment != null)
      {
        int i = 0;
        int j = paramFragment.size();
        while (i < j)
        {
          appendDataForFragment((Fragment)paramFragment.get(i), paramStringBuilder);
          i += 1;
        }
      }
    }
  }
  
  private static String extractPageKeyDivision(String paramString)
  {
    if ((paramString == null) || (paramString.length() < 2)) {}
    String[] arrayOfString;
    do
    {
      return null;
      if ("feed_reshare_messaging" == paramString) {
        return "messaging";
      }
      arrayOfString = paramString.split("_");
    } while (arrayOfString.length < 2);
    int j = 0;
    int i = j;
    if (paramString.charAt(1) == '_')
    {
      int k = paramString.charAt(0);
      if ((k != 100) && (k != 112) && (k != 116) && (k != 98))
      {
        i = j;
        if (k != 119) {}
      }
      else
      {
        i = 2;
      }
    }
    return arrayOfString[i];
  }
  
  private static String nonNullJoin(CharSequence paramCharSequence, Object[] paramArrayOfObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 1;
    int m = paramArrayOfObject.length;
    int j = 0;
    if (j < m)
    {
      Object localObject = paramArrayOfObject[j];
      int k = i;
      if (localObject != null)
      {
        if (i == 0) {
          break label63;
        }
        i = 0;
      }
      for (;;)
      {
        localStringBuilder.append(localObject);
        k = i;
        j += 1;
        i = k;
        break;
        label63:
        localStringBuilder.append(paramCharSequence);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void pushPageKey(String paramString)
  {
    System.arraycopy(pageKeys, 0, pageKeys, 1, pageKeys.length - 1);
    pageKeys[0] = paramString;
  }
  
  private static String resolveHostToString(String paramString)
  {
    try
    {
      String str1 = InetAddress.getByName(paramString).toString();
      return paramString + " : " + str1;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      for (;;)
      {
        String str2 = "unknown";
      }
    }
  }
  
  public final ArrayList<Uri> collectAttachments()
  {
    ArrayList localArrayList = new ArrayList();
    if (FileLog.isEnabled())
    {
      File localFile = FileLog.getLastLogFile();
      if (localFile != null)
      {
        Context localContext = appContext;
        localArrayList.add(FileProvider.getUriForFile(localContext, localContext.getPackageName() + ".fileprovider", localFile));
      }
    }
    return localArrayList;
  }
  
  public final String collectBackgroundDebugInfo()
  {
    int k = 0;
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject1 = appContext;
    localStringBuilder1.append("Network Info\n------------------------\n");
    localStringBuilder1.append(resolveHostToString("www.linkedin.com")).append('\n').append(resolveHostToString("static.licdn.com")).append('\n').append(resolveHostToString("media.licdn.com")).append('\n');
    localObject1 = ((ConnectivityManager)((Context)localObject1).getSystemService("connectivity")).getActiveNetworkInfo();
    boolean bool;
    int i;
    label114:
    label144:
    Object localObject2;
    if ((localObject1 != null) && (((NetworkInfo)localObject1).isConnectedOrConnecting()))
    {
      bool = true;
      if ((localObject1 == null) || (((NetworkInfo)localObject1).getType() != 1)) {
        break label237;
      }
      i = 1;
      int j = k;
      if (localObject1 != null)
      {
        j = k;
        if (((NetworkInfo)localObject1).getType() == 0) {
          j = 1;
        }
      }
      if (j == 0) {
        break label242;
      }
      localObject1 = ((NetworkInfo)localObject1).getSubtypeName();
      localStringBuilder1.append("Connected : ").append(String.valueOf(bool)).append('\n');
      StringBuilder localStringBuilder2 = localStringBuilder1.append("WiFi : ");
      if (i == 0) {
        break label250;
      }
      localObject2 = "ON";
      label185:
      localStringBuilder2.append((String)localObject2).append('\n');
      localObject2 = localStringBuilder1.append("Mobile : ");
      if (j == 0) {
        break label258;
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject2).append((String)localObject1).append('\n');
      return localStringBuilder1.toString();
      bool = false;
      break;
      label237:
      i = 0;
      break label114;
      label242:
      localObject1 = "";
      break label144;
      label250:
      localObject2 = "OFF";
      break label185;
      label258:
      localObject1 = "OFF";
    }
  }
  
  public final String collectDebugInfo()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = appContext;
    localStringBuilder.append(TextUtils.join("\n", new String[] { "Version Name: 4.0.53", "Version Code: 856", "Build Type: release", "Flavor: google", "MP Version: 0.21.208", "Git SHA: 92d5122", "Build Time: 2016-07-14T16:27Z", "Device Model: " + Build.MANUFACTURER + " - " + Build.MODEL, "Android Version: " + Build.VERSION.RELEASE, "Locale: " + getResourcesgetConfigurationlocale.toString(), "Page Key: " + pageKeys[0], "Member ID: " + memberUtil.getMemberId(), "Page Key History: " + nonNullJoin(",", pageKeys) }));
    localStringBuilder.append('\n');
    localObject = appContext).activityLifecycleCallbacks.currentActivity;
    if ((localObject instanceof FragmentActivity))
    {
      localObject = ((FragmentActivity)localObject).getSupportFragmentManager().getFragments();
      if (localObject != null)
      {
        int i = 0;
        int j = ((List)localObject).size();
        while (i < j)
        {
          appendDataForFragment((Fragment)((List)localObject).get(i), localStringBuilder);
          i += 1;
        }
      }
    }
    localObject = appContext;
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("voyager-android");
    String str = extractPageKeyDivision(pageKeys[0]);
    if ((str != null) && (str.equalsIgnoreCase("me"))) {
      localArrayList.add("Me");
    }
    localStringBuilder.append("jira-component:");
    localStringBuilder.append(nonNullJoin(",", localArrayList.toArray()));
    localStringBuilder.append('\n');
    if (!getResourcesgetConfigurationlocale.getLanguage().equalsIgnoreCase("en"))
    {
      localStringBuilder.append("jira-labelappend:");
      localStringBuilder.append("vi18n");
      localStringBuilder.append('\n');
    }
    return localStringBuilder.toString();
  }
  
  public final String[] collectRecipientEmails()
  {
    String str2 = pageKeys[0];
    String str1;
    if (str2 != null)
    {
      str1 = extractPageKeyDivision(str2);
      if (str1 != null) {
        break label450;
      }
      str1 = str2;
    }
    label450:
    for (;;)
    {
      if (Arrays.asList(DIVISION_EMAILS).contains(str1))
      {
        if (str1.equals("profile"))
        {
          Iterator localIterator = Arrays.asList(PROFILE_EDIT_SUB_DIVISIONS).iterator();
          while (localIterator.hasNext()) {
            if (str2.contains((String)localIterator.next())) {
              str1 = String.format("voyager-%s-feedback@linkedin.com", new Object[] { "profileedit" });
            }
          }
        }
        for (;;)
        {
          return new String[] { str1 };
          if (str1.equalsIgnoreCase("notifications")) {
            str1 = "voyager-me-feedback-beta@linkedin.com";
          } else if (str1.equalsIgnoreCase("me"))
          {
            if (str2.contains("me_wvm")) {
              str1 = "voyager-me-wvmp-feedback@linkedin.com";
            } else if ((str2.equals("me_post_analytics")) || (str2.equals("me_share_analytics"))) {
              str1 = "content-analytics-feedback@linkedin.com";
            } else {
              str1 = "voyager-me-feedback-beta@linkedin.com";
            }
          }
          else if (str1.equals("feed"))
          {
            if (Arrays.asList(PUBLISHING_KEYS).contains(str2)) {
              str1 = "ask_publishing@linkedin.com";
            } else {
              str1 = String.format("%s-feedback@linkedin.com", new Object[] { str1.toLowerCase(Locale.US) });
            }
          }
          else {
            str1 = String.format("voyager-%s-feedback@linkedin.com", new Object[] { str1.toLowerCase(Locale.US) });
          }
        }
      }
      if (str1.equals("premium")) {
        str2 = "premium-voyager-dev@linkedin.com";
      }
      for (;;)
      {
        str1 = str2;
        if (str2 != null) {
          break;
        }
        str1 = "voyager-pillar-leads@linkedin.com";
        break;
        if (str2.contains("pending_endorsements")) {
          str2 = "voyager-ge-feedback@linkedin.com";
        } else if (Arrays.asList(ENTITY_SUB_DIVISIONS).contains(str1)) {
          str2 = String.format("voyager-%s-feedback@linkedin.com", new Object[] { "entity" });
        } else if (Arrays.asList(GROUPS_DIVISIONS).contains(str1)) {
          str2 = "groups-feedback@linkedin.com";
        } else if (Arrays.asList(PUBLISHING_DIVISIONS).contains(str1)) {
          str2 = "ask_publishing@linkedin.com";
        } else if ((str2.contains("detail_base")) || (str2.contains("detail_likes_base")) || (str2.contains("pymk_list")) || (str2.contains("connection_updates_list"))) {
          str2 = String.format("%s-feedback@linkedin.com", new Object[] { "feed" });
        } else {
          str2 = null;
        }
      }
    }
  }
  
  public final boolean shakeDetectionEnabled()
  {
    return (LixHelper.isStaff(lixManager)) && (sharedPreferences.isShakyEnabled());
  }
  
  public static abstract interface ShakeDebugDataProvider
  {
    public abstract String provideDebugData();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.VoyagerShakeDelegate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */