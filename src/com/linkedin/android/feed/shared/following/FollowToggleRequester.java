package com.linkedin.android.feed.shared.following;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.shared.ToggleActionRequestQueue;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.VoidRecord;
import java.util.Map;

public class FollowToggleRequester
  extends ToggleActionRequestQueue
{
  private static final String TAG = FollowToggleRequester.class.getSimpleName();
  private final FlagshipDataManager dataManager;
  FollowingInfo followingInfo;
  private final String offUrl;
  private final String onUrl;
  FollowingInfo pendingFollowingInfo;
  
  public FollowToggleRequester(FlagshipApplication paramFlagshipApplication, FlagshipDataManager paramFlagshipDataManager, Routes paramRoutes, String paramString, FollowingInfo paramFollowingInfo)
  {
    super(paramFlagshipApplication, following);
    dataManager = paramFlagshipDataManager;
    followingInfo = paramFollowingInfo;
    onUrl = getUrl(paramRoutes, paramString, "follow");
    offUrl = getUrl(paramRoutes, paramString, "unfollow");
  }
  
  private static String getUrl(Routes paramRoutes, String paramString1, String paramString2)
  {
    paramString1 = paramRoutes.buildRouteForId(paramString1).buildUpon();
    if (paramRoutes == Routes.PROFILE) {
      paramString1.appendEncodedPath("profileActions");
    }
    return paramString1.appendQueryParameter("action", paramString2).build().toString();
  }
  
  public final void onErrorState(int paramInt)
  {
    if (pendingFollowingInfo != null)
    {
      followingInfo = pendingFollowingInfo;
      pendingFollowingInfo = null;
      overrideState(followingInfo.following);
    }
  }
  
  public final void onStableState()
  {
    if (pendingFollowingInfo != null)
    {
      followingInfo = pendingFollowingInfo;
      pendingFollowingInfo = null;
      overrideState(followingInfo.following);
    }
  }
  
  public final String tag()
  {
    return TAG;
  }
  
  public final void toggleNetworkOff(final Map<String, String> paramMap)
  {
    RecordTemplateListener local2 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<VoidRecord> paramAnonymousDataStoreResponse)
      {
        int j = statusCode;
        int i = j;
        if (error != null)
        {
          i = j;
          if (error.errorResponse != null) {
            i = error.errorResponse.code();
          }
        }
        FollowToggleRequester localFollowToggleRequester = FollowToggleRequester.this;
        if (error == null) {}
        for (boolean bool = true;; bool = false)
        {
          localFollowToggleRequester.requestFinished(bool, i, paramMap);
          return;
        }
      }
    };
    dataManager.submit(Request.post().url(offUrl).model(VoidRecord.INSTANCE).customHeaders(paramMap).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(local2));
  }
  
  public final void toggleNetworkOn(final Map<String, String> paramMap)
  {
    RecordTemplateListener local1 = new RecordTemplateListener()
    {
      public final void onResponse(DataStoreResponse<VoidRecord> paramAnonymousDataStoreResponse)
      {
        int j = statusCode;
        int i = j;
        if (error != null)
        {
          i = j;
          if (error.errorResponse != null) {
            i = error.errorResponse.code();
          }
        }
        FollowToggleRequester localFollowToggleRequester = FollowToggleRequester.this;
        if (error == null) {}
        for (boolean bool = true;; bool = false)
        {
          localFollowToggleRequester.requestFinished(bool, i, paramMap);
          return;
        }
      }
    };
    dataManager.submit(Request.post().url(onUrl).model(VoidRecord.INSTANCE).customHeaders(paramMap).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(local1));
  }
  
  public final void toggleUiOff()
  {
    try
    {
      followingInfo = new FollowingInfo.Builder().setEntityUrn(followingInfo.entityUrn).setFollowing(Boolean.valueOf(false)).setFollowerCount(Integer.valueOf(followingInfo.followerCount - 1)).build(RecordTemplate.Flavor.RECORD);
      dataManager.submit(Request.put().cacheKey(followingInfo.entityUrn.toString()).model(followingInfo).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
      return;
    }
    catch (BuilderException localBuilderException)
    {
      Log.e("Error building following info model", localBuilderException);
    }
  }
  
  public final void toggleUiOn()
  {
    try
    {
      followingInfo = new FollowingInfo.Builder().setEntityUrn(followingInfo.entityUrn).setFollowing(Boolean.valueOf(true)).setFollowerCount(Integer.valueOf(followingInfo.followerCount + 1)).build(RecordTemplate.Flavor.RECORD);
      dataManager.submit(Request.put().cacheKey(followingInfo.entityUrn.toString()).model(followingInfo).filter(DataManager.DataStoreFilter.LOCAL_ONLY));
      return;
    }
    catch (BuilderException localBuilderException)
    {
      Log.e("Error building following info model", localBuilderException);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.following.FollowToggleRequester
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */