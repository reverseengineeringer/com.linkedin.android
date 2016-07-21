package com.linkedin.android.liauthlib.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import org.json.JSONObject;

public final class LiSSOInfo
{
  public final String appName;
  public final String firstName;
  public final String fullName;
  public final String headline;
  public final String lastName;
  public final String memberID;
  public final String pictureUrl;
  public final String pkgName;
  public final String shortFullName;
  public final String username;
  
  public LiSSOInfo(Context paramContext, SharedPreferences paramSharedPreferences)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationContext().getApplicationInfo();
    pkgName = packageName;
    username = paramSharedPreferences.getString("auth_username", null);
    appName = paramContext.getPackageManager().getApplicationLabel(localApplicationInfo).toString();
    memberID = paramSharedPreferences.getString("auth_member_id", null);
    firstName = paramSharedPreferences.getString("auth_first_name", null);
    lastName = paramSharedPreferences.getString("auth_last_name", null);
    shortFullName = paramSharedPreferences.getString("auth_short_full_name", null);
    fullName = paramSharedPreferences.getString("auth_full_name", null);
    headline = paramSharedPreferences.getString("auth_headline", null);
    pictureUrl = paramSharedPreferences.getString("auth_picture_url", null);
  }
  
  public LiSSOInfo(Context paramContext, JSONObject paramJSONObject, String paramString)
  {
    ApplicationInfo localApplicationInfo = paramContext.getApplicationContext().getApplicationInfo();
    pkgName = packageName;
    username = paramString;
    appName = paramContext.getPackageManager().getApplicationLabel(localApplicationInfo).toString();
    memberID = String.valueOf(paramJSONObject.optLong("memberID"));
    firstName = paramJSONObject.optString("firstName");
    lastName = paramJSONObject.optString("lastName");
    shortFullName = paramJSONObject.optString("shortFullName");
    fullName = paramJSONObject.optString("fullName");
    headline = paramJSONObject.optString("headline");
    pictureUrl = paramJSONObject.optString("pictureUrl");
  }
  
  public LiSSOInfo(String paramString1, String paramString2)
  {
    username = paramString1;
    pkgName = paramString2;
    memberID = null;
    appName = null;
    firstName = null;
    lastName = null;
    shortFullName = null;
    fullName = null;
    pictureUrl = null;
    headline = null;
  }
  
  public LiSSOInfo(Map<String, String> paramMap)
  {
    username = ((String)paramMap.get("auth_username"));
    pkgName = ((String)paramMap.get("auth_package_name"));
    appName = ((String)paramMap.get("auth_app_name"));
    memberID = ((String)paramMap.get("auth_member_id"));
    firstName = ((String)paramMap.get("auth_first_name"));
    lastName = ((String)paramMap.get("auth_last_name"));
    shortFullName = ((String)paramMap.get("auth_short_full_name"));
    fullName = ((String)paramMap.get("auth_full_name"));
    headline = ((String)paramMap.get("auth_headline"));
    pictureUrl = ((String)paramMap.get("auth_picture_url"));
  }
  
  public static void clearPicture(Context paramContext)
  {
    getPictureFile(paramContext).delete();
  }
  
  public static File getPictureFile(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "sso");
    if (!paramContext.exists()) {
      paramContext.mkdir();
    }
    return new File(paramContext, "profile_pic.png");
  }
  
  public static Bitmap loadPicture(Context paramContext)
  {
    paramContext = getPictureFile(paramContext);
    if (!paramContext.exists()) {}
    try
    {
      paramContext.createNewFile();
      if (!paramContext.exists()) {}
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        try
        {
          paramContext = new FileInputStream(paramContext);
          Bitmap localBitmap = BitmapFactory.decodeStream(paramContext);
          paramContext.close();
          return localBitmap;
        }
        catch (FileNotFoundException paramContext)
        {
          paramContext.printStackTrace();
          return null;
        }
        catch (IOException paramContext)
        {
          paramContext.printStackTrace();
          continue;
        }
        localIOException = localIOException;
        localIOException.printStackTrace();
      }
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("username");
    localStringBuilder.append("=");
    localStringBuilder.append(username);
    localStringBuilder.append(" pkgName");
    localStringBuilder.append("=");
    localStringBuilder.append(pkgName);
    localStringBuilder.append(" fullName=");
    localStringBuilder.append(fullName);
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.common.LiSSOInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */