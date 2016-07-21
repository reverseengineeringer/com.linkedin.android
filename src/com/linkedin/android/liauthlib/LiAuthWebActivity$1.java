package com.linkedin.android.liauthlib;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class LiAuthWebActivity$1
  extends WebViewClient
{
  LiAuthWebActivity$1(LiAuthWebActivity paramLiAuthWebActivity) {}
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    paramWebView = Uri.parse(paramString).getQueryParameter("LOGIN_RESULT");
    if (!TextUtils.isEmpty(paramWebView))
    {
      paramString = LiAuthWebActivity.access$000(this$0);
      LiAuthWebActivity.access$100(this$0, paramWebView, paramString);
      this$0.finish();
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.LiAuthWebActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */