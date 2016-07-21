package com.linkedin.android.growth.onboarding.base;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import butterknife.Optional;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.DefaultModelListener;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.DataTemplateBuilder;
import com.linkedin.data.lite.RecordTemplate;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class OnboardingProfileEditFragment
  extends LegoFragment
{
  @InjectView(2131756106)
  public Button continueButton;
  @Inject
  public KeyboardUtil keyboardUtil;
  @Inject
  public LixManager lixManager;
  @InjectView(2131756107)
  @Optional
  public Button skipButton;
  @Inject
  public SnackbarUtil snackBar;
  
  public final JSONObject createProfileDiff(NormProfile paramNormProfile1, NormProfile paramNormProfile2)
  {
    try
    {
      paramNormProfile1 = PegasusPatchGenerator.INSTANCE.diff(paramNormProfile1, paramNormProfile2);
      return paramNormProfile1;
    }
    catch (JSONException paramNormProfile1)
    {
      getActivity();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Unable to parse JSON while diffing", paramNormProfile1));
    }
    return null;
  }
  
  public void doResume()
  {
    super.doResume();
    updateViewWhenLixEnabled();
    continueButton.setEnabled(verifyAllInputsFilled());
  }
  
  public final OnboardingDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.onboardingDataProvider();
  }
  
  public abstract void onInputError();
  
  public abstract void onPostFailed();
  
  public abstract void onPostSuccess();
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    continueButton.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.PRIMARY_ACTION, legoTrackingDataProvider, tracker, "continue", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = keyboardUtil;
        KeyboardUtil.hideKeyboard(continueButton);
        verifyInputsAndPostData();
      }
    });
    if (skipButton != null) {
      skipButton.setOnClickListener(new LegoActionTrackingOnClickListener(legoWidget.getTrackingToken(), ActionCategory.SKIP, legoTrackingDataProvider, tracker, "skip", new TrackingEventBuilder[0])
      {
        public final void onClick(View paramAnonymousView)
        {
          super.onClick(paramAnonymousView);
          paramAnonymousView = keyboardUtil;
          KeyboardUtil.hideKeyboard(skipButton);
          legoWidget.finishCurrentFragment();
        }
      });
    }
    paramView = getDataProvider();
    paramBundle = busSubscriberId;
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    Object localObject = activityComponent.memberUtil().getProfileId();
    if (localObject != null)
    {
      state).profileRoute = ProfileRoutes.buildProfileRoute((String)localObject).toString();
      state).versionTagRoute = ProfileRoutes.buildVersionTagRoute((String)localObject, "versionTag").toString();
      localObject = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      paramView.performMultiplexedFetch(paramBundle, null, localMap, ((MultiplexRequest.Builder)localObject).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.get().url(state).profileRoute).builder(Profile.BUILDER)).required(Request.get().url(state).versionTagRoute).builder(VersionTag.BUILDER)));
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("Profile id is null"));
  }
  
  public abstract void postData();
  
  public final void postUpdateProfile(JSONObject paramJSONObject, Map<String, String> paramMap)
  {
    if (getDataProvider().isVersionTagAvailable())
    {
      OnboardingDataProvider localOnboardingDataProvider = getDataProvider();
      String str1 = busSubscriberId;
      VersionTag localVersionTag = getDataProvider().getVersionTag();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      String str2 = activityComponent.memberUtil().getProfileId();
      if (str2 != null)
      {
        state).editProfileRoute = ProfileRoutes.buildEditProfileRoute(str2, versionTag, paramMap).toString();
        state).versionTagRoute = ProfileRoutes.buildVersionTagRoute(str2, "versionTag").toString();
        paramMap = MultiplexRequest.Builder.sequential();
        multiplexerUrl = Routes.MUX.buildUponRoot().toString();
        localOnboardingDataProvider.performMultiplexedFetch(str1, null, localMap, paramMap.filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.post().url(state).editProfileRoute).model(new JsonModel(paramJSONObject))).required(Request.get().url(state).versionTagRoute).builder(VersionTag.BUILDER)));
        return;
      }
      Util.safeThrow$7a8b4789(new RuntimeException("Profile id is null"));
      return;
    }
    getActivity();
    Util.safeThrow$7a8b4789(new IllegalStateException("Version tag is not available"));
    getDataProvider().fetchVersionTag$5ea691a4("", Tracker.createPageInstanceHeader(getPageInstance()));
    onPostFailed();
  }
  
  public final <T extends RecordTemplate<T>> void restoreModelFromCache(String paramString, DataTemplateBuilder<T> paramDataTemplateBuilder, final Closure<T, Void> paramClosure)
  {
    getDataProvider().loadDataModelFromCache(paramString, new DefaultModelListener()
    {
      public final void onCacheError(DataManagerException paramAnonymousDataManagerException)
      {
        paramClosure.apply(null);
      }
      
      public final void onCacheSuccess(T paramAnonymousT)
      {
        paramClosure.apply(paramAnonymousT);
      }
    }, paramDataTemplateBuilder);
  }
  
  public final void showMissingFieldSnackBar(String paramString)
  {
    paramString = snackBar.make(i18NManager.getString(2131231601, new Object[] { paramString }), 0);
    if (paramString != null) {
      paramString.show();
    }
  }
  
  public void updateViewWhenLixEnabled() {}
  
  public abstract boolean verifyAllInputsFilled();
  
  public final void verifyInputsAndPostData()
  {
    if (verifyAllInputsFilled())
    {
      postData();
      return;
    }
    onInputError();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.base.OnboardingProfileEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */