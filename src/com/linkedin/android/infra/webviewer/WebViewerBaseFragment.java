package com.linkedin.android.infra.webviewer;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.linkedin.android.infra.VoyagerShakeDelegate.ShakeDebugDataProvider;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthImpl;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.logger.Log;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import javax.inject.Inject;

public abstract class WebViewerBaseFragment
  extends PageFragment
  implements VoyagerShakeDelegate.ShakeDebugDataProvider
{
  private static final String TAG = WebViewerBaseFragment.class.getName();
  private CookieManager cookieManager;
  @Inject
  FragmentComponent fragmentComponent;
  protected String url;
  protected WebViewerBaseFragment.ScrollableWebView webView;
  private FrameLayout webViewContainer;
  
  protected static void clearCookies()
  {
    CookieManager localCookieManager = CookieManager.getInstance();
    if (Build.VERSION.SDK_INT >= 21)
    {
      localCookieManager.removeAllCookies(null);
      return;
    }
    localCookieManager.removeAllCookie();
  }
  
  protected static String constructSettingsPageKey(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return "settings_" + paramString + "_webview";
    }
    return "settings_webview";
  }
  
  public static int getHttpStatusCode(int paramInt)
  {
    switch (paramInt)
    {
    case -10: 
    case -9: 
    case -7: 
    default: 
      return 503;
    case -11: 
      return 412;
    case -8: 
    case -6: 
      return 408;
    case -5: 
      return 407;
    case -4: 
      return 401;
    }
    return 404;
  }
  
  private void loadUrl()
  {
    if (webView != null) {}
    try
    {
      fragmentComponent.webViewLoadProxy();
      WebViewLoadProxy.loadUrl(webView, url, cookieManager.getCookie(new URL(url).getHost()));
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      Log.e(TAG, "Invalid URL: " + url);
    }
  }
  
  public void doPause()
  {
    super.doPause();
    webView.onPause();
  }
  
  public void doResume()
  {
    webView.onResume();
    super.doResume();
  }
  
  protected abstract FrameLayout getWebViewContainer();
  
  protected final void loadWebViewWithCookies()
  {
    HttpStack localHttpStack = LiAuthProvider.getInstance(getContext()).getHttpStack();
    if (!localHttpStack.getCookieNameValuePairs(LiAuthImpl.cookieDomainSpec).isEmpty())
    {
      if (cookieManager == null) {
        Log.e(TAG, "Cookie Manager is null");
      }
    }
    else {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      cookieManager.setAcceptCookie(true);
      cookieManager.removeAllCookies(new WebViewerBaseFragment.1(this, localHttpStack));
      return;
    }
    cookieManager.setAcceptCookie(true);
    cookieManager.removeAllCookie();
    localHttpStack.addCookiesToCookieManager(cookieManager);
    CookieSyncManager.getInstance().sync();
    loadUrl();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    url = WebViewerBundle.getUrl(getArguments());
  }
  
  public void onDestroy()
  {
    if ((webViewContainer != null) && (webView != null))
    {
      webView.removeAllViews();
      webViewContainer.removeAllViews();
      webView.destroy();
      webView = null;
    }
    super.onDestroy();
  }
  
  protected void onPageCommitVisible$49a27f1e() {}
  
  protected void onPageFinished(WebView paramWebView, String paramString) {}
  
  protected void onPageStarted$49a27f1e(String paramString) {}
  
  protected void onProgressChanged$5ff25715(int paramInt) {}
  
  protected void onReceivedError$15530e61(String paramString, int paramInt) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    CookieSyncManager.createInstance(getContext().getApplicationContext());
    cookieManager = CookieManager.getInstance();
    clearCookies();
    webViewContainer = getWebViewContainer();
    webView = new WebViewerBaseFragment.ScrollableWebView(getActivity());
    webView.getSettings().setAllowContentAccess(false);
    webView.getSettings().setAllowFileAccess(false);
    webView.getSettings().setUseWideViewPort(true);
    webView.getSettings().setLoadWithOverviewMode(true);
    webView.setId(2131755021);
    webViewContainer.addView(webView, new FrameLayout.LayoutParams(-1, -1));
    webView.getSettings().setJavaScriptEnabled(true);
    webView.setWebChromeClient(new WebViewerBaseFragment.CustomWebChromeClient(this, (byte)0));
    webView.setWebViewClient(new CustomWebViewClient((byte)0));
    webView.getSettings().setBuiltInZoomControls(true);
    webView.getSettings().setDisplayZoomControls(false);
  }
  
  public String provideDebugData()
  {
    if (webView != null) {
      return "url: " + webView.getUrl();
    }
    return null;
  }
  
  protected boolean shouldOverrideUrlLoading$49a27f1a(String paramString)
  {
    return false;
  }
  
  private final class CustomWebViewClient
    extends WebViewClient
  {
    private CustomWebViewClient() {}
    
    public final void onPageCommitVisible(WebView paramWebView, String paramString)
    {
      super.onPageCommitVisible(paramWebView, paramString);
      onPageCommitVisible$49a27f1e();
    }
    
    public final void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      WebViewerBaseFragment.this.onPageFinished(paramWebView, paramString);
    }
    
    public final void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      onPageStarted$49a27f1e(paramString);
    }
    
    @Deprecated
    public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      onReceivedError$15530e61(paramString2, paramInt);
    }
    
    @TargetApi(23)
    public final void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
    {
      if (paramWebResourceRequest.isForMainFrame()) {
        onReceivedError$15530e61(paramWebResourceRequest.getUrl().toString(), paramWebResourceError.getErrorCode());
      }
    }
    
    public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      return shouldOverrideUrlLoading$49a27f1a(paramString);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebViewerBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */