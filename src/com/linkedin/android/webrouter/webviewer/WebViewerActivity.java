package com.linkedin.android.webrouter.webviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import com.linkedin.android.webrouter.R.layout;

public class WebViewerActivity
  extends AppCompatActivity
{
  private int exitAnimationId;
  private Fragment fragment;
  
  public void finish()
  {
    super.finish();
    if (exitAnimationId != 0) {
      overridePendingTransition(0, exitAnimationId);
    }
  }
  
  public void onBackPressed()
  {
    if ((fragment instanceof WebViewerFragment))
    {
      WebViewerFragment localWebViewerFragment = (WebViewerFragment)fragment;
      if ((webView == null) || (!webView.canGoBack())) {
        break label53;
      }
      webView.goBack();
    }
    label53:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        super.onBackPressed();
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.activity_web_viewer);
    if (paramBundle != null) {
      return;
    }
    paramBundle = getIntent().getExtras();
    exitAnimationId = paramBundle.getInt("exit_animation");
    fragment = new WebViewerFragment();
    fragment.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().add(16908290, fragment).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.webrouter.webviewer.WebViewerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */