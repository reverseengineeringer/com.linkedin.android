package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.view.WindowManager.BadTokenException;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzr;

@zzhb
@TargetApi(11)
public class zzjv
  extends WebChromeClient
{
  private final zzjp zzpD;
  
  public zzjv(zzjp paramzzjp)
  {
    zzpD = paramzzjp;
  }
  
  private static Context zza(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzjp)) {
      paramWebView = paramWebView.getContext();
    }
    zzjp localzzjp;
    Activity localActivity;
    do
    {
      return paramWebView;
      localzzjp = (zzjp)paramWebView;
      localActivity = localzzjp.zzhP();
      paramWebView = localActivity;
    } while (localActivity != null);
    return localzzjp.getContext();
  }
  
  private static boolean zza(final Context paramContext, String paramString1, String paramString2, String paramString3, JsResult paramJsResult, JsPromptResult paramJsPromptResult, boolean paramBoolean)
  {
    try
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
      localBuilder.setTitle(paramString1);
      if (paramBoolean)
      {
        paramString1 = new LinearLayout(paramContext);
        paramString1.setOrientation(1);
        paramJsResult = new TextView(paramContext);
        paramJsResult.setText(paramString2);
        paramContext = new EditText(paramContext);
        paramContext.setText(paramString3);
        paramString1.addView(paramJsResult);
        paramString1.addView(paramContext);
        localBuilder.setView(paramString1).setPositiveButton(17039370, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            zzOi.confirm(paramContext.getText().toString());
          }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            zzOi.cancel();
          }
        }).setOnCancelListener(new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            zzOi.cancel();
          }
        }).create().show();
        return true;
      }
      localBuilder.setMessage(paramString2).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zzOh.confirm();
        }
      }).setNegativeButton(17039360, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          zzOh.cancel();
        }
      }).setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          zzOh.cancel();
        }
      }).create().show();
      return true;
    }
    catch (WindowManager.BadTokenException paramContext)
    {
      zzin.zzd("Fail to display Dialog.", paramContext);
    }
    return true;
  }
  
  public final void onCloseWindow(WebView paramWebView)
  {
    if (!(paramWebView instanceof zzjp))
    {
      zzin.zzaK("Tried to close a WebView that wasn't an AdWebView.");
      return;
    }
    paramWebView = ((zzjp)paramWebView).zzhS();
    if (paramWebView == null)
    {
      zzin.zzaK("Tried to close an AdWebView not associated with an overlay.");
      return;
    }
    paramWebView.close();
  }
  
  public final boolean onConsoleMessage(ConsoleMessage paramConsoleMessage)
  {
    String str = "JS: " + paramConsoleMessage.message() + " (" + paramConsoleMessage.sourceId() + ":" + paramConsoleMessage.lineNumber() + ")";
    if (str.contains("Application Cache")) {
      return super.onConsoleMessage(paramConsoleMessage);
    }
    switch (7.zzOk[paramConsoleMessage.messageLevel().ordinal()])
    {
    default: 
      zzin.zzaJ(str);
    }
    for (;;)
    {
      return super.onConsoleMessage(paramConsoleMessage);
      zzin.e(str);
      continue;
      zzin.zzaK(str);
      continue;
      zzin.zzaJ(str);
      continue;
      zzin.zzaI(str);
    }
  }
  
  public final boolean onCreateWindow(WebView paramWebView, boolean paramBoolean1, boolean paramBoolean2, Message paramMessage)
  {
    WebView.WebViewTransport localWebViewTransport = (WebView.WebViewTransport)obj;
    paramWebView = new WebView(paramWebView.getContext());
    paramWebView.setWebViewClient(zzpD.zzhU());
    localWebViewTransport.setWebView(paramWebView);
    paramMessage.sendToTarget();
    return true;
  }
  
  public final void onExceededDatabaseQuota(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    long l = 5242880L - paramLong3;
    if (l <= 0L)
    {
      paramQuotaUpdater.updateQuota(paramLong1);
      return;
    }
    if (paramLong1 == 0L)
    {
      if ((paramLong2 <= l) && (paramLong2 <= 1048576L)) {}
      for (;;)
      {
        paramQuotaUpdater.updateQuota(paramLong2);
        return;
        paramLong2 = 0L;
      }
    }
    if (paramLong2 == 0L) {
      paramLong3 = Math.min(Math.min(131072L, l) + paramLong1, 1048576L);
    }
    for (;;)
    {
      paramLong2 = paramLong3;
      break;
      paramLong3 = paramLong1;
      if (paramLong2 <= Math.min(1048576L - paramLong1, l)) {
        paramLong3 = paramLong1 + paramLong2;
      }
    }
  }
  
  public final void onGeolocationPermissionsShowPrompt(String paramString, GeolocationPermissions.Callback paramCallback)
  {
    if (paramCallback != null)
    {
      zzr.zzbC();
      if (!zzir.zza(zzpD.getContext().getPackageManager(), zzpD.getContext().getPackageName(), "android.permission.ACCESS_FINE_LOCATION"))
      {
        zzr.zzbC();
        if (!zzir.zza(zzpD.getContext().getPackageManager(), zzpD.getContext().getPackageName(), "android.permission.ACCESS_COARSE_LOCATION")) {
          break label90;
        }
      }
    }
    label90:
    for (boolean bool = true;; bool = false)
    {
      paramCallback.invoke(paramString, bool, true);
      return;
    }
  }
  
  public final void onHideCustomView()
  {
    zzd localzzd = zzpD.zzhS();
    if (localzzd == null)
    {
      zzin.zzaK("Could not get ad overlay when hiding custom view.");
      return;
    }
    localzzd.zzfl();
  }
  
  public final boolean onJsAlert(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsBeforeUnload(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsConfirm(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, null, paramJsResult, null, false);
  }
  
  public final boolean onJsPrompt(WebView paramWebView, String paramString1, String paramString2, String paramString3, JsPromptResult paramJsPromptResult)
  {
    return zza(zza(paramWebView), paramString1, paramString2, paramString3, null, paramJsPromptResult, true);
  }
  
  public final void onReachedMaxAppCacheSize(long paramLong1, long paramLong2, WebStorage.QuotaUpdater paramQuotaUpdater)
  {
    paramLong1 = 131072L + paramLong1;
    if (5242880L - paramLong2 < paramLong1)
    {
      paramQuotaUpdater.updateQuota(0L);
      return;
    }
    paramQuotaUpdater.updateQuota(paramLong1);
  }
  
  public final void onShowCustomView(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zza(paramView, -1, paramCustomViewCallback);
  }
  
  protected final void zza(View paramView, int paramInt, WebChromeClient.CustomViewCallback paramCustomViewCallback)
  {
    zzd localzzd = zzpD.zzhS();
    if (localzzd == null)
    {
      zzin.zzaK("Could not get ad overlay when showing custom view.");
      paramCustomViewCallback.onCustomViewHidden();
      return;
    }
    zzEl = new FrameLayout(mActivity);
    zzEl.setBackgroundColor(-16777216);
    zzEl.addView(paramView, -1, -1);
    mActivity.setContentView(zzEl);
    zzEs = true;
    zzEm = paramCustomViewCallback;
    zzEk = true;
    localzzd.setRequestedOrientation(paramInt);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.internal.zzjv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */