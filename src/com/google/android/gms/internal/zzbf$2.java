package com.google.android.gms.internal;

import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;

final class zzbf$2
  implements Runnable
{
  ValueCallback<String> zzth = new ValueCallback() {};
  
  zzbf$2(zzbf paramzzbf, zzbc paramzzbc, WebView paramWebView, boolean paramBoolean) {}
  
  public final void run()
  {
    if (zztj.getSettings().getJavaScriptEnabled()) {}
    try
    {
      zztj.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", zzth);
      return;
    }
    catch (Throwable localThrowable)
    {
      zzth.onReceiveValue("");
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzbf.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */