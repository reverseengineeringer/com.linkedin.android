package com.linkedin.android.webrouter.webviewer;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.linkedin.android.webrouter.core.webclients.WebClientNavigationCallbacks;

final class WebViewerFragment$CustomWebViewClient
  extends WebViewClient
{
  private final ViewGroup container;
  private boolean errorReceived;
  private View errorView;
  private final LayoutInflater inflater;
  private final WebClientNavigationCallbacks navigationCallbacks;
  private Runnable reloadUrlRunnable;
  private final Toolbar toolbar;
  
  WebViewerFragment$CustomWebViewClient(WebClientNavigationCallbacks paramWebClientNavigationCallbacks, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Toolbar paramToolbar)
  {
    navigationCallbacks = paramWebClientNavigationCallbacks;
    inflater = paramLayoutInflater;
    container = paramViewGroup;
    toolbar = paramToolbar;
  }
  
  private void showErrorView(WebView paramWebView, String paramString)
  {
    if (navigationCallbacks != null)
    {
      navigationCallbacks.onWebClientNavigationFailed();
      container.removeView(errorView);
      reloadUrlRunnable = new WebViewerFragment.CustomWebViewClient.1(this, paramWebView, paramString);
      errorView = navigationCallbacks.createErrorView(inflater, container, reloadUrlRunnable);
      paramWebView.setVisibility(8);
      container.addView(errorView);
      errorReceived = true;
    }
  }
  
  public final void onPageCommitVisible(WebView paramWebView, String paramString)
  {
    super.onPageCommitVisible(paramWebView, paramString);
    toolbar.setTitle(paramWebView.getTitle());
    toolbar.setSubtitle(paramString);
    if (navigationCallbacks != null)
    {
      navigationCallbacks.onPageCommitVisible();
      if (!errorReceived)
      {
        paramWebView.setVisibility(0);
        container.removeView(errorView);
      }
      errorReceived = false;
    }
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    if (navigationCallbacks != null) {
      navigationCallbacks.onWebClientNavigationFinished();
    }
  }
  
  public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onPageStarted(paramWebView, paramString, paramBitmap);
    if (navigationCallbacks != null) {
      navigationCallbacks.onWebClientNavigationStarted();
    }
  }
  
  @Deprecated
  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    showErrorView(paramWebView, paramString2);
  }
  
  @TargetApi(23)
  public final void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    if (paramWebResourceRequest.isForMainFrame()) {
      showErrorView(paramWebView, paramWebResourceRequest.getUrl().toString());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.webrouter.webviewer.WebViewerFragment.CustomWebViewClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */