package com.linkedin.android.identity.profile;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.deeplink.routes.LinkingRoutes;
import com.linkedin.android.deeplink.wrapper.DeeplinkIntent;
import com.linkedin.android.infra.IntentFactory;
import com.linkedin.android.infra.shared.Util;
import javax.inject.Inject;

public final class ProfileViewIntent
  extends IntentFactory<ProfileBundleBuilder>
  implements DeeplinkIntent
{
  public final Intent getDeeplinkIntent(Context paramContext, ArrayMap<String, String> paramArrayMap, String paramString, LinkingRoutes paramLinkingRoutes)
  {
    Intent localIntent = provideIntent(paramContext);
    if (paramLinkingRoutes == LinkingRoutes.CONTACTS) {
      paramArrayMap = null;
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getContentResolver().query(Uri.parse(paramString), null, null, null, null);
        if (paramContext != null)
        {
          paramArrayMap = paramContext;
          if (paramContext.moveToNext())
          {
            paramArrayMap = paramContext;
            localIntent.putExtras(ProfileBundleBuilder.createFromProfileId(paramContext.getString(paramContext.getColumnIndex("data1"))).build());
            return localIntent;
          }
        }
        return localIntent;
      }
      finally
      {
        if (paramArrayMap != null) {
          paramArrayMap.close();
        }
      }
      if (paramArrayMap == null) {
        break;
      }
      paramLinkingRoutes = (String)paramArrayMap.get("memberId");
      paramArrayMap = (String)paramArrayMap.get("vanityName");
      paramContext = null;
      if (paramLinkingRoutes != null) {
        if (paramLinkingRoutes.equals("view"))
        {
          paramArrayMap = Uri.parse(paramString).getQueryParameter("id");
          if (paramArrayMap != null) {
            paramContext = ProfileBundleBuilder.createFromProfileId(paramArrayMap);
          }
        }
      }
      while (paramContext != null)
      {
        localIntent.putExtras(paramContext.build());
        return localIntent;
        Util.safeThrow$7a8b4789(new IllegalArgumentException("profileId could not be parsed from URL"));
        continue;
        if (paramLinkingRoutes.equals("edit"))
        {
          paramContext = ProfileBundleBuilder.createSelfProfile();
        }
        else
        {
          paramContext = ProfileBundleBuilder.createFromProfileId(paramLinkingRoutes);
          continue;
          if (paramArrayMap != null) {
            paramContext = ProfileBundleBuilder.createFromPublicIdentifier(paramArrayMap);
          } else {
            Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap should have either proifileId or the profileUrl"));
          }
        }
      }
    }
    Util.safeThrow$7a8b4789(new IllegalArgumentException("arrayMap should not be null"));
    return localIntent;
  }
  
  public final Intent provideIntent(Context paramContext)
  {
    return new Intent(paramContext, ProfileViewActivity.class);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.ProfileViewIntent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */