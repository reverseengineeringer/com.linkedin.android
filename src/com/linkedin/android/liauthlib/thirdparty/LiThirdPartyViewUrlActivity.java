package com.linkedin.android.liauthlib.thirdparty;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Locale;

public class LiThirdPartyViewUrlActivity
  extends Activity
{
  WebView webview = null;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    webview = new WebView(this);
    webview.clearCache(true);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.addView(webview, (ViewGroup.LayoutParams)localObject);
    setContentView(paramBundle);
    localObject = webview.getSettings();
    paramBundle = "Android";
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      paramBundle = localBundle.getString("useragent");
    }
    ((WebSettings)localObject).setUserAgentString(paramBundle);
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    if (Build.VERSION.SDK_INT >= 11) {
      ((WebSettings)localObject).setAllowContentAccess(false);
    }
    ((WebSettings)localObject).setAllowFileAccess(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      ((WebSettings)localObject).setAllowUniversalAccessFromFileURLs(false);
      ((WebSettings)localObject).setAllowFileAccessFromFileURLs(false);
    }
    if ((getIntent() != null) && (!TextUtils.isEmpty(getIntent().getStringExtra("url"))))
    {
      paramBundle = getIntent().getStringExtra("url");
      paramBundle = paramBundle + "?_l=" + getResourcesgetConfigurationlocale.toString();
      webview.loadUrl(paramBundle);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyViewUrlActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */