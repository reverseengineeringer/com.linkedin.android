package com.linkedin.android.webrouter.webviewer;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.util.ArrayMap;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.linkedin.android.webrouter.R.id;
import com.linkedin.android.webrouter.R.layout;
import com.linkedin.android.webrouter.core.WebRouter;
import com.linkedin.android.webrouter.core.webclients.WebClientNavigationCallbacks;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class WebViewerFragment
  extends Fragment
{
  private static final Map<String, String> CUSTOM_HEADERS = new ArrayMap();
  private static final String TAG = WebViewerFragment.class.getName();
  private Bundle config;
  private Map customRequestHeaders;
  private LayoutInflater inflater;
  private WebClientNavigationCallbacks navigationCallbacks;
  private ProgressBar progressBar;
  private Uri url;
  WebView webView;
  
  public void onCreate(Bundle paramBundle)
  {
    HashMap localHashMap = null;
    super.onCreate(paramBundle);
    Object localObject = getArguments();
    label52:
    NavigationCallbackFactory localNavigationCallbackFactory;
    if (localObject != null)
    {
      if (localObject != null)
      {
        paramBundle = (Uri)((Bundle)localObject).getParcelable("url");
        url = paramBundle;
        if (localObject == null) {
          break label168;
        }
        paramBundle = ((Bundle)localObject).getBundle("custom_tabs_intent");
        config = paramBundle;
      }
    }
    else
    {
      localNavigationCallbackFactory = getInstalledInstancefactory;
      if (localNavigationCallbackFactory == null) {
        break label178;
      }
      if (localObject == null) {
        break label173;
      }
      paramBundle = ((Bundle)localObject).getBundle("webclient_config_extras");
    }
    label83:
    label168:
    label173:
    label178:
    for (paramBundle = localNavigationCallbackFactory.createCallbacks(paramBundle);; paramBundle = null)
    {
      navigationCallbacks = paramBundle;
      paramBundle = localHashMap;
      if (localObject == null) {
        break label183;
      }
      localObject = ((Bundle)localObject).getStringArray("custom_request_header");
      paramBundle = localHashMap;
      if (localObject == null) {
        break label183;
      }
      localHashMap = new HashMap();
      int i = 0;
      for (;;)
      {
        paramBundle = localHashMap;
        if (i >= localObject.length) {
          break;
        }
        localHashMap.put(localObject[i], localObject[(i + 1)]);
        i += 2;
      }
      paramBundle = null;
      break;
      paramBundle = null;
      break label52;
      paramBundle = null;
      break label83;
    }
    label183:
    customRequestHeaders = paramBundle;
    if (url == null)
    {
      Log.e(TAG, "Could not find url to open, finishing activity now");
      getActivity().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    inflater = paramLayoutInflater;
    return paramLayoutInflater.inflate(R.layout.fragment_web_viewer, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    if (webView != null)
    {
      webView.removeAllViews();
      webView.destroy();
      webView = null;
    }
    super.onDestroy();
  }
  
  @SuppressLint({"SetJavaScriptEnabled"})
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (navigationCallbacks != null) {
      navigationCallbacks.onWebClientShown();
    }
    paramBundle = (Toolbar)paramView.findViewById(R.id.web_view_toolbar);
    paramBundle.setNavigationOnClickListener(new WebViewerFragment.1(this));
    progressBar = ((ProgressBar)paramView.findViewById(R.id.web_viewer_progress_bar));
    Object localObject1 = (ViewGroup)paramView.findViewById(R.id.web_view_container);
    WebViewerFragmentOptions.init(getContext(), paramBundle, config, url);
    webView = ((WebView)paramView.findViewById(R.id.web_view));
    paramView = webView.getSettings();
    paramView.setAllowContentAccess(false);
    paramView.setAllowFileAccess(false);
    paramView.setUseWideViewPort(true);
    paramView.setLoadWithOverviewMode(true);
    paramView.setJavaScriptEnabled(true);
    paramView.setBuiltInZoomControls(true);
    paramView.setDisplayZoomControls(false);
    webView.setWebViewClient(new CustomWebViewClient(navigationCallbacks, inflater, (ViewGroup)localObject1, paramBundle));
    webView.setWebChromeClient(new WebViewerFragment.CustomWebChromeClient(this));
    paramView = url.toString();
    if (WebRouter.shouldUseCookies)
    {
      paramBundle = CookieManager.getInstance();
      paramBundle.setAcceptCookie(true);
      paramBundle = paramBundle.getCookie(paramView);
      if (paramBundle != null)
      {
        if (customRequestHeaders != null)
        {
          localObject1 = customRequestHeaders.keySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject2 = ((Iterator)localObject1).next();
            String str = localObject2.toString();
            localObject2 = customRequestHeaders.get(localObject2).toString();
            CUSTOM_HEADERS.put(str, localObject2);
          }
        }
        CUSTOM_HEADERS.put("Cookie", paramBundle);
      }
      webView.loadUrl(paramView, CUSTOM_HEADERS);
      return;
    }
    webView.loadUrl(paramView);
  }
  
  private static final class CustomWebViewClient
    extends WebViewClient
  {
    private final ViewGroup container;
    private boolean errorReceived;
    private View errorView;
    private final LayoutInflater inflater;
    private final WebClientNavigationCallbacks navigationCallbacks;
    private Runnable reloadUrlRunnable;
    private final Toolbar toolbar;
    
    CustomWebViewClient(WebClientNavigationCallbacks paramWebClientNavigationCallbacks, LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Toolbar paramToolbar)
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
}

/* Location:
 * Qualified Name:     com.linkedin.android.webrouter.webviewer.WebViewerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */