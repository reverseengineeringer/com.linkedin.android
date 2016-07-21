package com.linkedin.android.imageloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.os.Build.VERSION;
import java.io.File;

public final class Utils
{
  private static volatile String CACHED_REFERER_HEADER = null;
  
  private static String getAppName(Context paramContext)
  {
    try
    {
      paramContext = getPackageManagergetPackageInfogetPackageName0applicationInfo.name;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  private static String getAppVersion(Context paramContext)
  {
    try
    {
      paramContext = getPackageManagergetPackageInfogetPackageName0versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return "";
  }
  
  public static String getFileUrl(File paramFile)
  {
    return "file://" + paramFile.getAbsolutePath();
  }
  
  public static String getRefererHeader(Context paramContext)
  {
    if (CACHED_REFERER_HEADER == null) {
      CACHED_REFERER_HEADER = "mobile://Android/" + Build.VERSION.RELEASE + "/" + getAppName(paramContext) + "/" + getAppVersion(paramContext);
    }
    return CACHED_REFERER_HEADER;
  }
  
  public static String getResourceUrl(Context paramContext, int paramInt)
  {
    return "android_res://" + paramContext.getResources().getResourceEntryName(paramInt);
  }
  
  public static Matrix getTransformationMatrix(int paramInt)
  {
    Matrix localMatrix = new Matrix();
    switch (paramInt)
    {
    default: 
      return localMatrix;
    case 2: 
      localMatrix.setScale(-1.0F, 1.0F);
      return localMatrix;
    case 3: 
      localMatrix.setRotate(180.0F);
      return localMatrix;
    case 4: 
      localMatrix.setRotate(180.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 5: 
      localMatrix.setRotate(90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    case 6: 
      localMatrix.setRotate(90.0F);
      return localMatrix;
    case 7: 
      localMatrix.setRotate(-90.0F);
      localMatrix.postScale(-1.0F, 1.0F);
      return localMatrix;
    }
    localMatrix.setRotate(-90.0F);
    return localMatrix;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.Utils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */