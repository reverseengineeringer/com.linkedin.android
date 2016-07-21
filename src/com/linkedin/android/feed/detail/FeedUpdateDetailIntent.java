package com.linkedin.android.feed.detail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.home.HomeBundle;
import com.linkedin.android.home.HomeIntent;
import com.linkedin.android.home.HomeTabInfo;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.gen.avro2pegasus.events.feed.highlightedUpdateSource;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId;
import com.linkedin.gen.avro2pegasus.events.messages.MessageId.Builder;
import java.util.ArrayList;
import javax.inject.Inject;
import org.json.JSONArray;
import org.json.JSONException;

public final class FeedUpdateDetailIntent
  extends IntentFactory<FeedUpdateDetailBundleBuilder>
  implements DeeplinkIntent
{
  private static String[] getCommentUrns(Uri paramUri)
  {
    Object localObject;
    if (paramUri == null) {
      localObject = null;
    }
    for (;;)
    {
      return (String[])localObject;
      localObject = paramUri.getQueryParameter("commentUrns");
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        try
        {
          JSONArray localJSONArray = new JSONArray((String)localObject);
          String[] arrayOfString = new String[localJSONArray.length()];
          int i = 0;
          for (;;)
          {
            localObject = arrayOfString;
            if (i >= localJSONArray.length()) {
              break;
            }
            arrayOfString[i] = localJSONArray.getString(i);
            i += 1;
          }
          paramUri = paramUri.getQueryParameter("commentUrn");
        }
        catch (JSONException localJSONException)
        {
          Log.e("unable to parse highlightedCommentUrns for feed update deep link", localJSONException);
        }
      }
    }
    if (!TextUtils.isEmpty(paramUri)) {
      return new String[] { paramUri };
    }
    return null;
  }
  
  private static MessageId getSourceTrackingId$e464505(Uri paramUri)
  {
    String str2 = paramUri.getQueryParameter("trkEmail");
    String str1 = paramUri.getQueryParameter("flockMessageUrn");
    paramUri = str1;
    if (str1 == null)
    {
      paramUri = str1;
      if (str2 != null)
      {
        paramUri = str2.split("-");
        paramUri = paramUri[(paramUri.length - 1)];
      }
    }
    try
    {
      paramUri = new MessageId.Builder().setFlockMessageUrn(paramUri).setExternalIds(new ArrayList()).build();
      return paramUri;
    }
    catch (BuilderException paramUri)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Failed to create MessageId ", paramUri));
    }
    return null;
  }
  
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    Uri localUri = Uri.parse(paramString);
    Object localObject1;
    if (localUri != null)
    {
      localObject2 = localUri.getQueryParameter("highlightedUpdateUrns");
      localObject1 = localUri.getQueryParameter("highlightedUpdateTypes");
      if ((localObject1 != null) && (localObject2 != null))
      {
        paramLinkingRoutes = ((String)localObject2).split(";");
        localObject1 = ((String)localObject1).split(";");
        if (paramString.contains("trkEmail")) {}
        for (paramArrayMap = highlightedUpdateSource.EMAIL;; paramArrayMap = highlightedUpdateSource.PUSH_NOTIFICATION)
        {
          localObject2 = getSourceTrackingId$e464505(localUri);
          paramString = new FeedBundleBuilder();
          bundle.putStringArray("highlightedUpdateTypes", (String[])localObject1);
          bundle.putStringArray("highlightedUpdateUrns", paramLinkingRoutes);
          bundle.putString("highlightedUpdateSource", paramArrayMap.toString());
          if (localObject2 != null) {
            RecordParceler.quietParcel((RecordTemplate)localObject2, "sourceTrackingId", bundle);
          }
          paramArrayMap = new HomeBundle();
          activeTab = HomeTabInfo.FEED;
          activeTabBundleBuilder = paramString;
          return getAppComponentintentRegistryhome.newIntent(paramContext, paramArrayMap);
        }
      }
    }
    Object localObject2 = provideIntent(paramContext);
    if (paramArrayMap != null)
    {
      localObject1 = "";
      switch (paramLinkingRoutes)
      {
      default: 
        paramContext = (String)paramArrayMap.get("updateUrn");
        if (TextUtils.isEmpty(paramContext)) {
          break label480;
        }
        paramString = Uri.parse(paramString);
        paramArrayMap = FeedUpdateDetailBundleBuilder.create(paramContext, null);
        paramContext = getCommentUrns(paramString);
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramArrayMap.highlightedCommentUrns(paramContext);
          paramArrayMap.anchor(2);
        }
        if (paramString != null)
        {
          paramLinkingRoutes = paramString.getQueryParameter("likeUrn");
          if (!TextUtils.isEmpty(paramLinkingRoutes))
          {
            paramContext = new String[1];
            paramContext[0] = paramLinkingRoutes;
            label312:
            if ((paramContext != null) && (paramContext.length > 0)) {
              bundle.putStringArray("highlightedLikeUrns", paramContext);
            }
            if (paramString == null) {
              break label475;
            }
            paramString = paramString.getQueryParameter("replyUrn");
            if (TextUtils.isEmpty(paramString)) {
              break label475;
            }
            paramContext = new String[1];
            paramContext[0] = paramString;
          }
        }
        break;
      }
      for (;;)
      {
        if ((paramContext != null) && (paramContext.length > 0)) {
          paramArrayMap.highlightedReplyUrns(paramContext);
        }
        ((Intent)localObject2).putExtras(paramArrayMap.build());
        return (Intent)localObject2;
        paramArrayMap = (String)paramArrayMap.get("updateId");
        paramContext = (Context)localObject1;
        if (paramArrayMap == null) {
          break;
        }
        paramContext = Urn.createFromTuple("activity", new Object[] { paramArrayMap }).toString();
        break;
        paramContext = (Context)localObject1;
        if (localUri == null) {
          break;
        }
        paramArrayMap = localUri.getQueryParameter("topic");
        paramContext = (Context)localObject1;
        if (paramArrayMap == null) {
          break;
        }
        paramContext = Urn.createFromTuple("activity", new Object[] { paramArrayMap }).toString();
        break;
        paramContext = null;
        break label312;
        label475:
        paramContext = null;
      }
      label480:
      Util.safeThrow$7a8b4789(new IllegalArgumentException("received no update ID for an update deep link!"));
      return (Intent)localObject2;
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("received a null arrayMap for deep linking"));
    return (Intent)localObject2;
  }
  
  protected final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, FeedUpdateDetailActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */