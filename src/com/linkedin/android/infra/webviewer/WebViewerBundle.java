package com.linkedin.android.infra.webviewer;

import android.os.Bundle;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class WebViewerBundle
  implements BundleBuilder
{
  protected final Bundle bundle = new Bundle();
  
  public WebViewerBundle(String paramString1, String paramString2, String paramString3, String paramString4, Update paramUpdate, int paramInt)
  {
    bundle.putString("url", paramString1);
    bundle.putString("title", paramString2);
    bundle.putString("subtitle", paramString3);
    bundle.putString("pageKeySuffix", paramString4);
    if (paramUpdate != null)
    {
      RecordParceler.quietParcel(paramUpdate, "update", bundle);
      bundle.putBoolean("key_is_sponsored_url", FeedTracking.isSponsored(tracking));
    }
    bundle.putInt("usage", paramInt);
  }
  
  public static WebViewerBundle create(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    return new WebViewerBundle(paramString1, paramString2, paramString3, null, null, paramInt);
  }
  
  public static WebViewerBundle createFeedViewer(String paramString1, String paramString2, String paramString3, Update paramUpdate, int paramInt)
  {
    return new WebViewerBundle(paramString1, paramString2, paramString3, null, paramUpdate, paramInt);
  }
  
  public static WebViewerBundle createSettingsViewer(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return new WebViewerBundle(paramString1, paramString2, paramString3, paramString4, null, 3);
  }
  
  public static String getPageKeySuffix(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("pageKeySuffix", "");
    }
    return "";
  }
  
  public static String getSubtitle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("subtitle");
    }
    return null;
  }
  
  public static String getTitle(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return paramBundle.getString("title", "");
    }
    return "";
  }
  
  public static Update getUpdate(Bundle paramBundle)
  {
    if (paramBundle != null) {
      return (Update)RecordParceler.quietUnparcel(Update.BUILDER, "update", paramBundle);
    }
    return null;
  }
  
  public static String getUrl(Bundle paramBundle)
  {
    if (paramBundle == null) {
      paramBundle = "";
    }
    String str;
    do
    {
      return paramBundle;
      str = paramBundle.getString("url", "");
      paramBundle = str;
    } while (!WebViewerUtils.isLinkedinUrl(str));
    return WebViewerUtils.getHttpsUrl(str);
  }
  
  public static int getUsage(Bundle paramBundle)
  {
    int i = -1;
    if (paramBundle != null) {
      i = paramBundle.getInt("usage", -1);
    }
    return i;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final WebViewerBundle setUsage$37eab3ba()
  {
    bundle.putInt("usage", 4);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */