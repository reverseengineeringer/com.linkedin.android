package com.linkedin.android.identity.guidededit.infra;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider;
import com.linkedin.android.identity.guidededit.GuidedEditDataProvider.GuidedEditState;
import com.linkedin.android.identity.guidededit.infra.shared.GuidedEditSource;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.TrackableFragment.EnterTooEarlyException;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.RestliUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.common.lego.Visibility;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.CategoryNames;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditCategory;
import com.linkedin.android.pegasus.gen.voyager.identity.guidededit.GuidedEditTask;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditContextType;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditEducationsField.Builder;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditFlowNavAction;
import com.linkedin.gen.avro2pegasus.common.guidededit.GuidedEditPositionsField.Builder;
import com.linkedin.gen.avro2pegasus.common.guidededit.IsbFieldName;
import com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowImpressionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowNavActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.guidededit.GuidedEditFlowSaveActionEvent.Builder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONException;

public abstract class GuidedEditTaskFragment
  extends PageFragment
  implements OnBackPressedListener
{
  public static final Urn FAKE_URN = Urn.createFromTuple("mockurn", new Object[] { "DUMMY" });
  public static final String TAG = GuidedEditTaskFragment.class.getSimpleName();
  private BaseViewHolder baseViewHolder;
  public GuidedEditCategory guidedEditCategory;
  @Inject
  public GuidedEditDataProvider guidedEditDataProvider;
  public GuidedEditFlowManager guidedEditFlowManager;
  protected GuidedEditFlowRootFragment guidedEditFlowRootFragment;
  public GuidedEditSource guidedEditSource;
  private boolean isPostingData;
  public boolean isTaskRequired;
  @Inject
  protected LegoTrackingDataProvider legoTrackingDataProvider;
  private String legoTrackingId;
  @Inject
  public ProfileDataProvider profileDataProvider;
  @InjectView(2131755468)
  protected Toolbar toolbar;
  public GuidedEditBaseBundleBuilder transitionData;
  
  private static void changeStatusBarBackgroundColor(Activity paramActivity, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.addFlags(Integer.MIN_VALUE);
      localWindow.setStatusBarColor(paramActivity.getResources().getColor(paramInt));
    }
  }
  
  private void moveToNextTask()
  {
    GuidedEditFlowRootFragment localGuidedEditFlowRootFragment = guidedEditFlowRootFragment;
    GuidedEditBaseBundleBuilder localGuidedEditBaseBundleBuilder = getTransitionData();
    if (guidedEditFlowManager.isLastTask())
    {
      localGuidedEditFlowRootFragment.finishFlow(localGuidedEditBaseBundleBuilder);
      return;
    }
    GuidedEditFlowManager localGuidedEditFlowManager = guidedEditFlowManager;
    GuidedEditTask localGuidedEditTask = localGuidedEditFlowManager.getCurrentTask();
    if ((localGuidedEditTask != null) && (counted)) {
      currentCountedTaskIndex += 1;
    }
    if (!localGuidedEditFlowManager.isLastTask()) {
      currentTaskIndex += 1;
    }
    localGuidedEditFlowRootFragment.showCurrentTaskFragment(localGuidedEditBaseBundleBuilder);
  }
  
  private void sendGuidedEditFlowNavActionEvent(GuidedEditFlowNavAction paramGuidedEditFlowNavAction)
  {
    String str = getArguments().getString("flowTrackingId");
    if (str != null)
    {
      Tracker localTracker = tracker;
      GuidedEditFlowNavActionEvent.Builder localBuilder = new GuidedEditFlowNavActionEvent.Builder();
      if (paramGuidedEditFlowNavAction == null)
      {
        hasUserAction = false;
        userAction = null;
        if (str != null) {
          break label82;
        }
        hasFlowTrackingId = false;
      }
      for (flowTrackingId = null;; flowTrackingId = str)
      {
        localTracker.send(localBuilder);
        return;
        hasUserAction = true;
        userAction = paramGuidedEditFlowNavAction;
        break;
        label82:
        hasFlowTrackingId = true;
      }
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("The flowTrackingId is null."));
  }
  
  private void showUpdateDataErrorToast()
  {
    guidedEditFlowRootFragment.dismissProgressBar();
    Toast.makeText(getContext(), 2131232035, 1).show();
  }
  
  public final void cancelAndExitFlow()
  {
    sendGuidedEditFlowNavActionEvent(GuidedEditFlowNavAction.DISMISS);
    GuidedEditTask localGuidedEditTask = guidedEditFlowManager.getCurrentTask();
    if ((localGuidedEditTask == null) || (required))
    {
      guidedEditFlowRootFragment.cancelAndExitFlow();
      return;
    }
    guidedEditFlowRootFragment.finishFlow(getTransitionData());
  }
  
  public abstract ViewModel<? extends BaseViewHolder> createViewModel();
  
  public void doEnter()
    throws TrackableFragment.EnterTooEarlyException
  {
    super.doEnter();
    String str = getArguments().getString("flowTrackingId");
    if ((str != null) && (guidedEditSource != GuidedEditSource.$UNKNOWN))
    {
      GuidedEditContextType localGuidedEditContextType = GuidedEditFragmentHelper.convertToGuidedEditContextType(guidedEditSource);
      Tracker localTracker;
      List localList;
      GuidedEditFlowImpressionEvent.Builder localBuilder;
      if (localGuidedEditContextType != GuidedEditContextType.$UNKNOWN)
      {
        localTracker = tracker;
        localList = getFieldNames();
        localBuilder = new GuidedEditFlowImpressionEvent.Builder();
        if (localGuidedEditContextType != null) {
          break label129;
        }
        hasContextType = false;
        contextType = null;
        if (str != null) {
          break label144;
        }
        hasFlowTrackingId = false;
        flowTrackingId = null;
        label95:
        if (!localList.isEmpty())
        {
          if (localList != null) {
            break label159;
          }
          hasFieldNames = false;
        }
      }
      for (fieldNames = null;; fieldNames = localList)
      {
        localTracker.send(localBuilder);
        return;
        label129:
        hasContextType = true;
        contextType = localGuidedEditContextType;
        break;
        label144:
        hasFlowTrackingId = true;
        flowTrackingId = str;
        break label95;
        label159:
        hasFieldNames = true;
      }
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("The flowTrackingId is null or the GuidedEditSource is unknown."));
  }
  
  public void doResume()
  {
    super.doResume();
    toolbar.getBackground().mutate().setAlpha(0);
    toolbar.setNavigationIcon(2130838634);
    toolbar.setNavigationOnClickListener(new GuidedEditTaskFragment.1(this, tracker, "cancel", new TrackingEventBuilder[0]));
  }
  
  public final void finishAndExitFlow()
  {
    sendGuidedEditFlowNavActionEvent(GuidedEditFlowNavAction.EXIT);
    guidedEditFlowRootFragment.finishFlow(getTransitionData());
  }
  
  public abstract List<IsbFieldName> getFieldNames();
  
  public String getPostRoute()
  {
    return null;
  }
  
  public final GuidedEditBaseBundleBuilder getTransitionData()
  {
    if (transitionData == null) {
      transitionData = GuidedEditBaseBundleBuilder.copy(getArguments());
    }
    return transitionData;
  }
  
  public final String getVersionTag()
  {
    GuidedEditFlowRootFragment localGuidedEditFlowRootFragment = guidedEditFlowRootFragment;
    if (versionTag == null) {
      return "";
    }
    return versionTag;
  }
  
  public final <VIEW_HOLDER extends BaseViewHolder> VIEW_HOLDER getViewHolder(Class<VIEW_HOLDER> paramClass)
  {
    return (BaseViewHolder)paramClass.cast(baseViewHolder);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isParentFragment()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getParentFragment() instanceof GuidedEditFlowRootFragment))
    {
      guidedEditFlowRootFragment = ((GuidedEditFlowRootFragment)getParentFragment());
      guidedEditFlowManager = guidedEditFlowRootFragment.guidedEditFlowManager;
      if (guidedEditFlowManager == null)
      {
        getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("guidedEditFlowManager is null"));
      }
      return;
    }
    getContext();
    Util.safeThrow$7a8b4789(new RuntimeException("ParentFragment must be GuidedEditFlowRootFragment"));
  }
  
  public final boolean onBackPressed()
  {
    cancelAndExitFlow();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    guidedEditCategory = guidedEditFlowManager.guidedEditCategory;
    paramBundle = guidedEditFlowManager.getCurrentTask();
    if (paramBundle != null)
    {
      legoTrackingId = legoTrackingId;
      isTaskRequired = required;
    }
    boolean bool = "control".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_VIEW_DISABLE_PROFILE_VIEW_API));
    profileDataProvider.profileViewApiEnabled = bool;
    profileDataProvider.register(this);
    guidedEditSource = GuidedEditBaseBundleBuilder.getGuidedEditSource(getArguments());
    if (guidedEditSource == GuidedEditSource.$UNKNOWN)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("GuidedEditSource is unknown"));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramBundle = createViewModel();
    ViewHolderCreator localViewHolderCreator = paramBundle.getCreator();
    paramLayoutInflater = paramLayoutInflater.inflate(localViewHolderCreator.getLayoutId(), paramViewGroup, false);
    paramViewGroup = localViewHolderCreator.createViewHolder(paramLayoutInflater);
    paramBundle.onBindViewHolder(LayoutInflater.from(getActivity()), fragmentComponent.mediaCenter(), paramViewGroup);
    baseViewHolder = paramViewGroup;
    return paramLayoutInflater;
  }
  
  public void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramType == DataStore.Type.NETWORK) && (isPostingData) && ((CollectionUtils.isEmpty(paramSet)) || (paramSet.contains(getPostRoute()))))
    {
      isPostingData = false;
      showUpdateDataErrorToast();
    }
  }
  
  public void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (paramMap == null) {}
    do
    {
      return;
      if (paramMap.containsKey(guidedEditDataProvider.versionTagUri)) {
        guidedEditFlowRootFragment.versionTag = ((GuidedEditDataProvider.GuidedEditState)guidedEditDataProvider.state).getVersionTag();
      }
    } while ((!isPostingData) || (!paramMap.containsKey(getPostRoute())));
    isPostingData = false;
    paramType = RestliUtils.getIdFromListHeader(getgetPostRouteheaders);
    if (!TextUtils.isEmpty(paramType)) {
      getTransitionData().setPostEntityId(paramType);
    }
    paramType = tracker;
    paramSet = getArguments().getString("flowTrackingId");
    paramMap = guidedEditCategory;
    Object localObject = getTransitionData().build();
    if ((paramSet != null) && (paramMap != null)) {
      if ((id == CategoryNames.ADD_CURRENT_POSITION) || (id == CategoryNames.ADD_PAST_POSITION) || (id == CategoryNames.UPDATE_POSITION))
      {
        localObject = ((Bundle)localObject).getString("postEntityID");
        if (localObject == null) {}
      }
    }
    for (;;)
    {
      try
      {
        paramMap = new GuidedEditPositionsField.Builder();
        localObject = Arrays.asList(new String[] { localObject });
        if (localObject != null) {
          continue;
        }
        hasPositions = false;
        positions = null;
        paramMap = paramMap.build(RecordTemplate.Flavor.RECORD);
        localObject = new GuidedEditFlowSaveActionEvent.Builder();
        hasPositions = true;
        positions = paramMap;
        paramType.send(((GuidedEditFlowSaveActionEvent.Builder)localObject).setFlowTrackingId(paramSet));
      }
      catch (BuilderException paramSet)
      {
        paramType = appContext;
        Util.safeThrow$7a8b4789(new RuntimeException("Cannot send guided edit save event for position."));
        continue;
      }
      moveToNextTask();
      return;
      hasPositions = true;
      positions = ((List)localObject);
      continue;
      if ((id == CategoryNames.ADD_EDUCATION) || (id == CategoryNames.UPDATE_EDUCATION))
      {
        localObject = ((Bundle)localObject).getString("postEntityID");
        if (localObject != null) {
          for (;;)
          {
            try
            {
              paramMap = new GuidedEditEducationsField.Builder();
              localObject = Arrays.asList(new String[] { localObject });
              if (localObject != null) {
                break label437;
              }
              hasEducations = false;
              educations = null;
              paramMap = paramMap.build(RecordTemplate.Flavor.RECORD);
              localObject = new GuidedEditFlowSaveActionEvent.Builder();
              hasEducations = true;
              educations = paramMap;
              paramType.send(((GuidedEditFlowSaveActionEvent.Builder)localObject).setFlowTrackingId(paramSet));
            }
            catch (BuilderException paramSet)
            {
              paramType = appContext;
              Util.safeThrow$7a8b4789(new RuntimeException("Cannot send guided edit save event for education."));
            }
            break;
            label437:
            hasEducations = true;
            educations = ((List)localObject);
          }
        }
      }
      else
      {
        paramType.send(new GuidedEditFlowSaveActionEvent.Builder().setFlowTrackingId(paramSet));
        continue;
        paramType = appContext;
        Util.safeThrow$7a8b4789(new RuntimeException("The GuidedEditCategory or flowTrackingId is null."));
      }
    }
  }
  
  public void onDestroy()
  {
    profileDataProvider.unregister(this);
    super.onDestroy();
  }
  
  public void onStart()
  {
    super.onStart();
    changeStatusBarBackgroundColor(getActivity(), 2131624047);
  }
  
  public void onStop()
  {
    super.onStop();
    changeStatusBarBackgroundColor(getActivity(), 2131624109);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    changeStatusBarBackgroundColor(getActivity(), 2131624047);
    if (!TextUtils.isEmpty(legoTrackingId)) {
      legoTrackingDataProvider.sendWidgetImpressionEvent$4bb724c7(legoTrackingId, Visibility.SHOW);
    }
  }
  
  public boolean postData()
    throws JSONException
  {
    return false;
  }
  
  public final void saveDataAndMoveToNextTask()
  {
    try
    {
      boolean bool = validateInputData();
      if (!bool) {
        return;
      }
      if (!TextUtils.isEmpty(legoTrackingId)) {
        legoTrackingDataProvider.sendActionEvent$67c7f505(legoTrackingId, ActionCategory.PRIMARY_ACTION);
      }
      try
      {
        isPostingData = postData();
        if (isPostingData)
        {
          guidedEditFlowRootFragment.showProgressBar();
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        showUpdateDataErrorToast();
        return;
      }
      moveToNextTask();
      return;
    }
    catch (BuilderException localBuilderException) {}
  }
  
  public final void skipToNextTask()
  {
    if (!TextUtils.isEmpty(legoTrackingId)) {
      legoTrackingDataProvider.sendActionEvent$67c7f505(legoTrackingId, ActionCategory.SKIP);
    }
    sendGuidedEditFlowNavActionEvent(GuidedEditFlowNavAction.SKIP);
    moveToNextTask();
  }
  
  public final void startOver()
  {
    sendGuidedEditFlowNavActionEvent(GuidedEditFlowNavAction.START_OVER);
    GuidedEditFlowRootFragment localGuidedEditFlowRootFragment = guidedEditFlowRootFragment;
    localGuidedEditFlowRootFragment.findAndShowFirstTask(guidedEditFlowManager.guidedEditCategory);
  }
  
  public final void startTypeAheadForPeople(String paramString)
  {
    startActivityForResult(fragmentComponent.intentRegistry().search.newIntent(getContext(), SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.CONNECTIONS).setSearchBarHintText(getLocalizedString(2131232585)).setInputMaxLength$fdadbae().setFakeHitAtTop$6c621e23().setCustomTypeaheadPageKey(paramString)), TYPEAHEAD_PICKER_PEOPLErequestId);
  }
  
  public boolean validateInputData()
    throws BuilderException
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.infra.GuidedEditTaskFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */