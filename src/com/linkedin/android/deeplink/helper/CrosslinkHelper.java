package com.linkedin.android.deeplink.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

public class CrosslinkHelper
{
  private static final String TAG = CrosslinkHelper.class.getSimpleName();
  private static CrosslinkHelper instance;
  private static final Object instanceLock = new Object();
  private Context applicationContext;
  
  private CrosslinkHelper(Context paramContext)
  {
    applicationContext = paramContext.getApplicationContext();
  }
  
  public static Intent buildCrosslinkIntent$4b1ae7cf(Uri paramUri)
  {
    paramUri = new Intent("android.intent.action.VIEW", paramUri);
    paramUri.addFlags(268435456);
    paramUri.addCategory("android.intent.category.DEFAULT");
    paramUri.addCategory("android.intent.category.BROWSABLE");
    paramUri.putExtra("skipBackstacks", false);
    return paramUri;
  }
  
  public static CrosslinkHelper create(Context paramContext)
  {
    synchronized (instanceLock)
    {
      if (instance == null) {
        instance = new CrosslinkHelper(paramContext);
      }
      return instance;
    }
  }
  
  public static void crosslink(Context paramContext, Intent paramIntent)
  {
    Log.i(TAG, "Crosslinking on: " + paramIntent.getData().toString());
    paramContext.startActivity(paramIntent);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.helper.CrosslinkHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */