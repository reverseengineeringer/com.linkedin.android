package com.linkedin.android.liauthlib.registration;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.linkedin.android.liauthlib.R.id;
import com.linkedin.android.liauthlib.R.layout;

public class ChallengeWebViewActivity
  extends Activity
{
  private String mUrl;
  private WebView mWebView;
  private WebViewClient mWebViewClient;
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.challenge_web_view);
    mUrl = getIntent().getStringExtra("com.linkedin.android.liauthlib.registration.challengeUrl");
    paramBundle = (ViewGroup)findViewById(R.id.webview_container);
    ((ViewGroup)findViewById(R.id.progressContainer)).setVisibility(8);
    mWebView = new WebView(this);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    mWebView.setLayoutParams(localLayoutParams);
    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.loadUrl(mUrl + "&ru=linkedin://captcha");
    mWebViewClient = new WebViewClient()
    {
      public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        boolean bool = false;
        if ("linkedin://captcha".equals(paramAnonymousString.substring(0, 18)))
        {
          paramAnonymousWebView = new Intent("com.linkedin.android.liauthlib.registration.intentChallengeCompleted");
          paramAnonymousWebView.putExtra("com.linkedin.android.liauthlib.registration.challengeVerificationToken", paramAnonymousString.substring(25));
          LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(paramAnonymousWebView);
          finish();
          bool = true;
        }
        return bool;
      }
    };
    mWebView.setWebViewClient(mWebViewClient);
    mWebView.setWebChromeClient(new WebChromeClient());
    paramBundle.addView(mWebView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.registration.ChallengeWebViewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */