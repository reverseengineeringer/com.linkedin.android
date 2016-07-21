package com.linkedin.android.entities.viewmodels.cards;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.linkedin.android.infra.webviewer.WebViewLoadProxy;

final class CareerBrandingCardViewModel$ResizeClient
  extends WebViewClient
{
  private final WebViewLoadProxy webViewLoadProxy;
  
  CareerBrandingCardViewModel$ResizeClient(WebViewLoadProxy paramWebViewLoadProxy)
  {
    webViewLoadProxy = paramWebViewLoadProxy;
  }
  
  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    paramString = (WindowManager)paramWebView.getContext().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramString.getDefaultDisplay().getMetrics(localDisplayMetrics);
    widthPixels = paramWebView.getMeasuredWidth();
    widthPixels = ((int)(widthPixels / density));
    WebViewLoadProxy.loadUrl(paramWebView, "javascript:var scale = " + widthPixels + " / document.body.scrollWidth; document.body.style.zoom = scale;");
  }
  
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.CareerBrandingCardViewModel.ResizeClient
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */