package com.linkedin.android.identity.guidededit.infra;

import android.app.Activity;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider.GuidedEditState;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.ContextType;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditProfileUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.TaskNames;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.VersionTag;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class GuidedEditFlowRootFragment
  extends PageFragment
{
  public static final String TAG = GuidedEditFlowRootFragment.class.getSimpleName();
  @Inject
  GuidedEditDataProvider guidedEditDataProvider;
  GuidedEditFlowManager guidedEditFlowManager;
  private GuidedEditListener guidedEditListener;
  @InjectView(2131756464)
  View progressLayout;
  String versionTag;
  
  public static GuidedEditFlowRootFragment newInstance(GuidedEditBaseBundleBuilder paramGuidedEditBaseBundleBuilder)
  {
    GuidedEditFlowRootFragment localGuidedEditFlowRootFragment = new GuidedEditFlowRootFragment();
    localGuidedEditFlowRootFragment.setArguments(paramGuidedEditBaseBundleBuilder.build());
    return localGuidedEditFlowRootFragment;
  }
  
  final void cancelAndExitFlow()
  {
    guidedEditListener.onCancelAndExitGuidedEdit$b0b86fb();
  }
  
  public final void dismissProgressBar()
  {
    progressLayout.setVisibility(8);
  }
  
  final void findAndShowFirstTask(GuidedEditCategory paramGuidedEditCategory)
  {
    guidedEditFlowManager = new GuidedEditFlowManager(paramGuidedEditCategory);
    showCurrentTaskFragment(GuidedEditBaseBundleBuilder.copy(getArguments()).setCategory(guidedEditFlowManager.guidedEditCategory));
  }
  
  final void finishFlow(GuidedEditBaseBundleBuilder paramGuidedEditBaseBundleBuilder)
  {
    paramGuidedEditBaseBundleBuilder = GuidedEditFragmentHelper.getGuidedEditProfileUpdate(paramGuidedEditBaseBundleBuilder);
    guidedEditListener.onFinishGuidedEdit(guidedEditFlowManager.guidedEditCategory, paramGuidedEditBaseBundleBuilder);
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (!(paramActivity instanceof GuidedEditListener)) {
      throw new IllegalStateException("Activity must implement OnGuidedEditListener");
    }
    guidedEditListener = ((GuidedEditListener)paramActivity);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle != null)
    {
      guidedEditFlowManager = new GuidedEditFlowManager(paramBundle);
      versionTag = paramBundle.getString("versionTag");
    }
    paramBundle = guidedEditDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    versionTagUri = ProfileRoutes.buildVersionTagRoute(activityComponent.memberUtil().getProfileId(), "versionTag").toString();
    state).versionTagUri = versionTagUri;
    paramBundle.performFetch(VersionTag.BUILDER, versionTagUri, str1, str2, localMap);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968911, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (paramMap == null) {
      return;
    }
    if ((paramType == DataStore.Type.NETWORK) && (paramMap.containsKey(guidedEditDataProvider.forcedGuidedEditCategoryRoute)))
    {
      paramType = guidedEditDataProvider;
      if (((GuidedEditDataProvider.GuidedEditState)state).forcedGuidedEditCategory() == null) {
        break label96;
      }
    }
    label96:
    for (paramType = ((GuidedEditDataProvider.GuidedEditState)state).forcedGuidedEditCategory();; paramType = null)
    {
      findAndShowFirstTask(paramType);
      if (!paramMap.containsKey(guidedEditDataProvider.versionTagUri)) {
        break;
      }
      versionTag = ((GuidedEditDataProvider.GuidedEditState)guidedEditDataProvider.state).getVersionTag();
      return;
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (guidedEditFlowManager != null)
    {
      Object localObject = guidedEditFlowManager;
      GuidedEditBaseBundleBuilder.wrap(paramBundle).setCategory(guidedEditCategory);
      paramBundle.putInt("currentTaskIndex", currentTaskIndex);
      paramBundle.putInt("currentCountedTaskIndex", currentCountedTaskIndex);
      paramBundle.putInt("totalCountedTaskCount", totalCountedTaskCount);
      if (versionTag != null)
      {
        paramBundle = GuidedEditBaseBundleBuilder.wrap(paramBundle);
        localObject = versionTag;
        bundle.putString("versionTag", (String)localObject);
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramBundle != null) {
      return;
    }
    paramView = getArguments().getString("guidedEditForceCategory");
    paramBundle = GuidedEditBaseBundleBuilder.getGuidedEditSource(getArguments());
    Object localObject = getArguments().getString("guidedEditSuggestionId");
    if (!TextUtils.isEmpty(paramView))
    {
      if (localObject != null)
      {
        showProgressBar();
        paramBundle = guidedEditDataProvider;
        str1 = busSubscriberId;
        str2 = getRumSessionId();
        localMap = Tracker.createPageInstanceHeader(getPageInstance());
        str3 = applicationComponent.memberUtil().getProfileId();
        forcedGuidedEditCategoryRoute = GuidedEditDataProvider.ROOT.buildUpon().appendEncodedPath(paramView).appendQueryParameter("vieweeMemberIdentity", str3).appendQueryParameter("suggestionId", (String)localObject).build().toString();
        paramBundle.sendForcedCategoryRequest(str1, str2, localMap);
        return;
      }
      showProgressBar();
      localObject = guidedEditDataProvider;
      String str1 = busSubscriberId;
      String str2 = getRumSessionId();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      String str3 = applicationComponent.memberUtil().getProfileId();
      paramBundle = GuidedEditFragmentHelper.convertToUeditContextType(paramBundle);
      forcedGuidedEditCategoryRoute = GuidedEditDataProvider.ROOT.buildUpon().appendEncodedPath(paramView).appendQueryParameter("vieweeMemberIdentity", str3).appendQueryParameter("contextType", paramBundle.name()).build().toString();
      ((GuidedEditDataProvider)localObject).sendForcedCategoryRequest(str1, str2, localMap);
      return;
    }
    if (GuidedEditSource.DEEPLINK == paramBundle)
    {
      showProgressBar();
      guidedEditDataProvider.fetchData(busSubscriberId, getRumSessionId(), Tracker.createPageInstanceHeader(getPageInstance()), applicationComponent.memberUtil().getProfileId(), paramBundle);
      return;
    }
    paramView = GuidedEditBaseBundleBuilder.getCategory(getArguments());
    if (paramView != null)
    {
      findAndShowFirstTask(paramView);
      return;
    }
    cancelAndExitFlow();
  }
  
  public final String pageKey()
  {
    return "";
  }
  
  public final boolean shouldTrack()
  {
    return false;
  }
  
  final void showCurrentTaskFragment(GuidedEditBaseBundleBuilder paramGuidedEditBaseBundleBuilder)
  {
    Object localObject = guidedEditFlowManager.getCurrentTask();
    if ((localObject == null) || (taskName == null)) {}
    for (localObject = TaskNames.$UNKNOWN;; localObject = taskName)
    {
      GuidedEditTaskFragmentFactory localGuidedEditTaskFragmentFactory = guidedEditFlowManager.guidedEditTaskFragmentFactory;
      if (localGuidedEditTaskFragmentFactory == null) {
        break;
      }
      paramGuidedEditBaseBundleBuilder = localGuidedEditTaskFragmentFactory.createGuidedEditTaskFragment((TaskNames)localObject, paramGuidedEditBaseBundleBuilder);
      if (paramGuidedEditBaseBundleBuilder == null) {
        break;
      }
      localObject = GuidedEditTaskFragment.TAG;
      dismissProgressBar();
      getChildFragmentManager().beginTransaction().replace(2131756463, paramGuidedEditBaseBundleBuilder, (String)localObject).commitAllowingStateLoss();
      return;
    }
    cancelAndExitFlow();
  }
  
  public final void showProgressBar()
  {
    progressLayout.setVisibility(0);
  }
  
  public static abstract interface GuidedEditListener
  {
    public abstract void onCancelAndExitGuidedEdit$b0b86fb();
    
    public abstract void onFinishGuidedEdit(GuidedEditCategory paramGuidedEditCategory, GuidedEditProfileUpdate paramGuidedEditProfileUpdate);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.GuidedEditFlowRootFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */