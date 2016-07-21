package com.linkedin.android.tos.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import com.linkedin.android.tos.R.id;
import com.linkedin.android.tos.R.layout;

public class ToSWebviewActivity
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = null;
    Bundle localBundle = getIntent().getExtras();
    if (localBundle != null) {
      paramBundle = localBundle.getString("extra_url");
    }
    setContentView(R.layout.activity_to_swebview);
    ((WebView)findViewById(R.id.webview)).loadUrl(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.tos.ui.ToSWebviewActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */