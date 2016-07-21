package com.linkedin.android.infra.webviewer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.linkedin.android.logger.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;

public class WebViewerUtils
{
  private static final Pattern FIRST_PARTY_ARTICLE_PATTERN = Pattern.compile("(http|https)://www.linkedin.com/pulse/+");
  private static final Pattern NEWSLE_PATTERN = Pattern.compile("(http|https)://www.linkedin.com/pulse/news-mention-retracted+");
  private static final Pattern PUBLIC_PROFILE_PATTERN_1;
  private static final Pattern PUBLIC_PROFILE_PATTERN_2;
  private static final String TAG = WebViewerUtils.class.getSimpleName();
  
  static
  {
    PUBLIC_PROFILE_PATTERN_1 = Pattern.compile("(https|https)://www.linkedin.com/(in|pub)/([^(?|/)]+)");
    PUBLIC_PROFILE_PATTERN_2 = Pattern.compile("(http|https)://www.linkedin.com/profile/view[?]id=([^&]+)");
  }
  
  public static void composeMail(Activity paramActivity, String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString1);
    localIntent.putExtra("android.intent.extra.TEXT", paramString2);
    localIntent.setType("text/html");
    localIntent.putExtra("android.intent.extra.TITLE", paramActivity.getString(2131233737));
    try
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    catch (ActivityNotFoundException paramString1)
    {
      Toast.makeText(paramActivity, 2131232788, 0).show();
    }
  }
  
  public static void copyToClipboard(Activity paramActivity, String paramString)
  {
    ((ClipboardManager)paramActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("copy_link", paramString));
  }
  
  public static String getAuthorityFromUrl(String paramString)
  {
    String str = "";
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      str = new URL(paramString).getAuthority();
      return str;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String getHttpsUrl(String paramString)
  {
    HttpUrl localHttpUrl = HttpUrl.parse(paramString);
    if (localHttpUrl == null) {
      Log.e(TAG, "Invalid HTTP url: " + paramString);
    }
    while (localHttpUrl.isHttps()) {
      return paramString;
    }
    return localHttpUrl.newBuilder().scheme("https").toString();
  }
  
  public static boolean isLinkedInArticleUrl(String paramString)
  {
    Matcher localMatcher = FIRST_PARTY_ARTICLE_PATTERN.matcher(paramString);
    if (NEWSLE_PATTERN.matcher(paramString).find()) {
      return false;
    }
    return localMatcher.find();
  }
  
  public static boolean isLinkedinUrl(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        URL localURL = new URL(paramString);
        if (!localURL.getHost().equals("www.linkedin.com"))
        {
          boolean bool = localURL.getHost().equals("www.linkedin-ei.com");
          if (!bool) {}
        }
        else
        {
          return true;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Log.e(TAG, "Invalid url: " + paramString, localMalformedURLException);
      }
    }
    return false;
  }
  
  public static void openInExternalBrowser(Activity paramActivity, String paramString)
  {
    String str = paramString;
    if (!paramString.startsWith("http")) {
      str = "http://" + paramString;
    }
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(str));
    try
    {
      paramActivity.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      Toast.makeText(paramActivity, 2131232788, 0).show();
    }
  }
  
  public static String parsePublicProfileId(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return null;
      Matcher localMatcher = PUBLIC_PROFILE_PATTERN_1.matcher(paramString);
      paramString = PUBLIC_PROFILE_PATTERN_2.matcher(paramString);
      if (localMatcher.find()) {
        return localMatcher.group(3);
      }
    } while (!paramString.find());
    return paramString.group(2);
  }
  
  public static String parsePulseArticleFromEmail(String paramString)
  {
    paramString = Uri.parse(paramString);
    if (paramString.getQueryParameterNames().contains("permLink"))
    {
      paramString = paramString.getQueryParameter("permLink");
      return "https://www.linkedin.com/pulse/" + paramString;
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */