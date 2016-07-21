package com.linkedin.android.infra.webviewer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedWebRouterUtil;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public class WebRouterActivity
  extends BaseActivity
{
  private void trackButtonShortPress(String paramString)
  {
    new ControlInteractionEvent(applicationComponent.tracker(), paramString, ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    boolean bool1 = paramBundle.getBooleanExtra("Share Article", false);
    boolean bool2 = paramBundle.getBooleanExtra("Copy Link", false);
    boolean bool3 = paramBundle.getBooleanExtra("Open In Browser", false);
    boolean bool4 = paramBundle.getBooleanExtra("Mail", false);
    String str1 = paramBundle.getStringExtra("update_tracking_tracking_id");
    String str2 = paramBundle.getStringExtra("update_tracking_request_id");
    String str3 = paramBundle.getStringExtra("update_urn");
    String str4 = paramBundle.getStringExtra("title");
    Object localObject = paramBundle.getDataString();
    paramBundle = (Bundle)localObject;
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      paramBundle = getIntent().getStringExtra("url");
    }
    if (bool1)
    {
      trackButtonShortPress("reshare");
      if (str1 != null)
      {
        localObject = applicationComponent.tracker();
        ((Tracker)localObject).send(FeedTracking.createFeedActionEvent((Tracker)localObject, ActionCategory.EXPAND, "reshare", "expandReshareBox", str2, str1, str3, "feed-item:phone"));
      }
      paramBundle = ShareBundle.createFeedShare(ShareComposeBundle.createOriginalShareWithArticleUrl(paramBundle));
      startActivity(applicationComponent.intentRegistry().share.newIntent(this, paramBundle));
    }
    for (;;)
    {
      finish();
      return;
      if (bool2)
      {
        trackButtonShortPress("more");
        if (str1 != null) {
          FeedWebRouterUtil.sendMenuTracking(applicationComponent, str1, str2, str3);
        }
        WebViewerUtils.copyToClipboard(this, paramBundle);
      }
      else if (bool3)
      {
        trackButtonShortPress("more");
        if (str1 != null) {
          FeedWebRouterUtil.sendMenuTracking(applicationComponent, str1, str2, str3);
        }
        WebViewerUtils.openInExternalBrowser(this, paramBundle);
      }
      else if (bool4)
      {
        trackButtonShortPress("more");
        if (str1 != null) {
          FeedWebRouterUtil.sendMenuTracking(applicationComponent, str1, str2, str3);
        }
        WebViewerUtils.composeMail(this, str4, paramBundle);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.webviewer.WebRouterActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */