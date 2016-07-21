package com.linkedin.android.infra.webviewer;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public class WebViewerActivity
  extends BaseActivity
{
  private Fragment fragment;
  
  public void onBackPressed()
  {
    if ((!(fragment instanceof WebViewerFragment)) || (!((WebViewerFragment)fragment).isBackButtonHandled())) {
      super.onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      return;
    }
    paramBundle = getIntent().getExtras();
    String str1 = WebViewerBundle.getUrl(paramBundle);
    String str2 = WebViewerBundle.getTitle(paramBundle);
    String str3 = WebViewerBundle.getSubtitle(paramBundle);
    String str4 = WebViewerBundle.getPageKeySuffix(paramBundle);
    Update localUpdate = WebViewerBundle.getUpdate(paramBundle);
    int j = WebViewerBundle.getUsage(paramBundle);
    int i;
    if (Build.VERSION.SDK_INT < 19)
    {
      i = 1;
      if (i != 0) {
        break label150;
      }
      paramBundle = new WebViewerBundle(str1, str2, str3, str4, localUpdate, j);
      if (j != 3) {
        break label132;
      }
    }
    label132:
    for (fragment = fragmentRegistry.settingsWebViewer.newFragment(paramBundle);; fragment = fragmentRegistry.externalArticleViewer.newFragment(paramBundle))
    {
      getSupportFragmentManager().beginTransaction().add(16908290, fragment).commit();
      return;
      i = 0;
      break;
    }
    label150:
    WebViewerUtils.openInExternalBrowser(this, str1);
    finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */