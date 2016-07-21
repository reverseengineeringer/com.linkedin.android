package com.linkedin.android.liauthlib.registration;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class ChallengeWebViewActivity$1
  extends WebViewClient
{
  ChallengeWebViewActivity$1(ChallengeWebViewActivity paramChallengeWebViewActivity) {}
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    if ("linkedin://captcha".equals(paramString.substring(0, 18)))
    {
      paramWebView = new Intent("com.linkedin.android.liauthlib.registration.intentChallengeCompleted");
      paramWebView.putExtra("com.linkedin.android.liauthlib.registration.challengeVerificationToken", paramString.substring(25));
      LocalBroadcastManager.getInstance(this$0.getApplicationContext()).sendBroadcast(paramWebView);
      this$0.finish();
      bool = true;
    }
    return bool;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.registration.ChallengeWebViewActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */