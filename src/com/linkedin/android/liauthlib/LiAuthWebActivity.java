package com.linkedin.android.liauthlib;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.linkedin.android.liauthlib.network.HttpStack;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

@SuppressLint({"SetJavaScriptEnabled"})
public class LiAuthWebActivity
  extends Activity
{
  private WebView webview = null;
  
  private byte[] getPostData()
  {
    ArrayList localArrayList = new ArrayList(3);
    Object localObject = null;
    Bundle localBundle = getIntent().getExtras();
    String str;
    if (localBundle != null)
    {
      localArrayList.add(new BasicNameValuePair("session_key", localBundle.getString("username")));
      localObject = localBundle.getString("password");
      str = localBundle.getString("googleIdToken");
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label138;
      }
      localArrayList.add(new BasicNameValuePair("session_password", (String)localObject));
    }
    for (;;)
    {
      localArrayList.add(new BasicNameValuePair("session_redirect", localBundle.getString("host") + "/nhome"));
      try
      {
        localObject = EntityUtils.toByteArray(new UrlEncodedFormEntity(localArrayList));
        return (byte[])localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        return null;
      }
      catch (IOException localIOException)
      {
        label138:
        localIOException.printStackTrace();
      }
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(new BasicNameValuePair("googleIdToken", str));
      }
    }
    return null;
  }
  
  private void sendChallengeCompletedBroadcast(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent("com.linkedin.android.liauthlib.intent.challengeCompleted");
    localIntent.putExtra("challenge_login_result", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      localIntent.putExtra("challenge_login_param", paramString2);
    }
    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(localIntent);
  }
  
  public void onBackPressed()
  {
    if (webview.canGoBack())
    {
      webview.goBack();
      return;
    }
    sendChallengeCompletedBroadcast("USER_CANCELLED", null);
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    webview = new WebView(this);
    paramBundle = new LinearLayout(this);
    Object localObject = new LinearLayout.LayoutParams(-1, -1);
    paramBundle.addView(webview, (ViewGroup.LayoutParams)localObject);
    setContentView(paramBundle);
    localObject = webview.getSettings();
    ((WebSettings)localObject).setJavaScriptEnabled(true);
    paramBundle = "Android";
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      paramBundle = localBundle.getString("useragent");
    }
    ((WebSettings)localObject).setUserAgentString(paramBundle);
    paramBundle = LiAuthProvider.getInstance(this).getHttpStack();
    if (!paramBundle.getCookieNameValuePairs(LiAuthImpl.cookieDomainSpec).isEmpty())
    {
      CookieSyncManager.createInstance(this);
      localObject = CookieManager.getInstance();
      if (localObject != null)
      {
        ((CookieManager)localObject).setAcceptCookie(true);
        ((CookieManager)localObject).removeAllCookie();
        paramBundle.addCookiesToCookieManager((CookieManager)localObject);
        CookieSyncManager.getInstance().sync();
      }
    }
    webview.setWebViewClient(new WebViewClient()
    {
      public final boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
      {
        paramAnonymousWebView = Uri.parse(paramAnonymousString).getQueryParameter("LOGIN_RESULT");
        if (!TextUtils.isEmpty(paramAnonymousWebView))
        {
          paramAnonymousString = LiAuthWebActivity.access$000(LiAuthWebActivity.this);
          LiAuthWebActivity.this.sendChallengeCompletedBroadcast(paramAnonymousWebView, paramAnonymousString);
          finish();
          return true;
        }
        return false;
      }
    });
    webview.setWebChromeClient(new WebChromeClient());
    paramBundle = getPostData();
    localObject = getIntent().getExtras();
    if (localObject != null)
    {
      localObject = ((Bundle)localObject).getString("challenge_url");
      if (localObject != null) {
        webview.postUrl((String)localObject, paramBundle);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.LiAuthWebActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */