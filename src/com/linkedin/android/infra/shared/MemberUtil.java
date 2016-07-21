package com.linkedin.android.infra.shared;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.MeUpdatedEvent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.Me;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.DataReaderException;
import com.linkedin.data.lite.DataTemplateParser;
import com.linkedin.data.lite.DataTemplateParserFactory;
import java.io.ByteArrayInputStream;
import java.util.Map;
import javax.inject.Inject;

public class MemberUtil
{
  private static final String TAG = MemberUtil.class.getSimpleName();
  private final Auth auth;
  private final Bus bus;
  private final ConsistencyManager consistencyManager;
  private final FlagshipDataManager dataManager;
  public Me meModel;
  private final RecordTemplateListener<Me> meModelListener = new MemberUtil.1(this);
  private final MediaCenter mediaCenter;
  private DefaultConsistencyListener miniProfileListener;
  public boolean overrideIsPremium;
  private final FlagshipSharedPreferences sharedPreferences;
  private final Tracker tracker;
  
  @Inject
  public MemberUtil(Auth paramAuth, Bus paramBus, FlagshipDataManager paramFlagshipDataManager, ConsistencyManager paramConsistencyManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, MediaCenter paramMediaCenter, Tracker paramTracker)
  {
    auth = paramAuth;
    bus = paramBus;
    dataManager = paramFlagshipDataManager;
    consistencyManager = paramConsistencyManager;
    sharedPreferences = paramFlagshipSharedPreferences;
    mediaCenter = paramMediaCenter;
    tracker = paramTracker;
  }
  
  private Me loadMeFromSharedPreferences()
  {
    Object localObject = sharedPreferences.getMeModelString();
    if (localObject != null) {
      try
      {
        localObject = (Me)DataManager.PARSER_FACTORY.createParser().parseRecord(new ByteArrayInputStream(((String)localObject).getBytes()), Me.BUILDER);
        return (Me)localObject;
      }
      catch (DataReaderException localDataReaderException)
      {
        Log.e(TAG, "Error parsing Me model string from SharedPreferences", localDataReaderException);
      }
    }
    return null;
  }
  
  public final long getMemberId()
  {
    if (meModel != null) {
      return meModel.plainId;
    }
    return -1L;
  }
  
  public final MiniProfile getMiniProfile()
  {
    if (meModel != null) {
      return meModel.miniProfile;
    }
    return null;
  }
  
  public final String getProfileId()
  {
    if (meModel != null) {
      return meModel.miniProfile.entityUrn.getId();
    }
    return null;
  }
  
  public final boolean isPremium()
  {
    return (overrideIsPremium) || ((meModel != null) && (meModel.premiumSubscriber));
  }
  
  public final boolean isSelf(String paramString)
  {
    String str = getProfileId();
    if (getMemberId() == -1L) {}
    for (int i = 1; (i == 0) && (str != null) && (str.equals(paramString)); i = 0) {
      return true;
    }
    return false;
  }
  
  public final boolean loadAndSetMeFromSharedPref()
  {
    Me localMe = loadMeFromSharedPreferences();
    if (localMe != null)
    {
      Log.i(TAG, "Loaded Me model from shared preferences");
      setMeModel(localMe, true);
    }
    return localMe != null;
  }
  
  public final void loadMe()
  {
    loadAndSetMeFromSharedPref();
    Log.i(TAG, "Firing network request to load Me model");
    dataManager.submit(Request.get().url(Routes.ME.buildUponRoot().toString()).customHeaders(Tracker.createPageInstanceHeader(tracker.generateBackgroundPageInstance())).builder(Me.BUILDER).filter(DataManager.DataStoreFilter.NETWORK_ONLY).listener(meModelListener));
  }
  
  final void setMeModel(Me paramMe, boolean paramBoolean)
  {
    Me localMe = meModel;
    meModel = paramMe;
    CrashReporter.setUserInfo(paramMe);
    if (miniProfileListener == null)
    {
      miniProfileListener = new MemberUtil.2(this, miniProfile);
      consistencyManager.listenForUpdates(miniProfileListener);
    }
    if (!paramBoolean)
    {
      Object localObject = PegasusPatchGenerator.modelToJSONString(paramMe);
      if (localObject != null) {
        sharedPreferences.getPreferences().edit().putString("meModel", (String)localObject).apply();
      }
      localObject = auth;
      MediaCenter localMediaCenter = mediaCenter;
      ArrayMap localArrayMap = new ArrayMap();
      localArrayMap.put("auth_username", liAuth.getUsername());
      localArrayMap.put("auth_package_name", context.getPackageName());
      localArrayMap.put("auth_app_name", context.getApplicationInfo().name);
      localArrayMap.put("auth_first_name", miniProfile.firstName);
      localArrayMap.put("auth_last_name", miniProfile.lastName);
      localArrayMap.put("auth_full_name", i18NManager.getString(2131233236, new Object[] { I18NManager.getName(miniProfile) }));
      localArrayMap.put("auth_headline", miniProfile.occupation);
      localArrayMap.put("auth_picture_url", localMediaCenter.load(miniProfile.picture).getLoadUrl(null));
      liAuth.saveProfileData(context, new LiSSOInfo(localArrayMap));
    }
    bus.publishInMainThread(new MeUpdatedEvent(localMe, meModel, paramBoolean));
  }
  
  protected void setOverrideIsPremium(boolean paramBoolean)
  {
    overrideIsPremium = paramBoolean;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.MemberUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */