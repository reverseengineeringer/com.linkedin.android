package com.linkedin.android.infra.webviewer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

final class WebViewerBaseFragment$CustomWebViewClient
  extends WebViewClient
{
  private WebViewerBaseFragment$CustomWebViewClient(WebViewerBaseFragment paramWebViewerBaseFragment) {}
  
  public final void onPageCommitVisible(WebView paramWebView, String paramString)
  {
    super.onPageCommitVisible(paramWebView, paramString);
    this$0.onPageCommitVisible$49a27f1e();
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    this$0.onPageFinished(paramWebView, paramString);
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    this$0.onPageStarted$49a27f1e(paramString);
  }
  
  @Deprecated
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this$0.onReceivedError$15530e61(paramString2, paramInt);
  }
  
  @TargetApi(23)
  public final void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    if (paramWebResourceRequest.isForMainFrame()) {
      this$0.onReceivedError$15530e61(paramWebResourceRequest.getUrl().toString(), paramWebResourceError.getErrorCode());
    }
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return this$0.shouldOverrideUrlLoading$49a27f1a(paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerBaseFragment.CustomWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */