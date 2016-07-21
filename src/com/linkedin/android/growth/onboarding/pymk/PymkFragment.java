package com.linkedin.android.growth.onboarding.pymk;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.linkedin.android.datamanager.DataRequestWrapper.Builder;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.lego.LegoFragment;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider;
import com.linkedin.android.growth.onboarding.OnboardingDataProvider.OnboardingState;
import com.linkedin.android.growth.onboarding.base.OnboardingListFragment;
import com.linkedin.android.growth.onboarding.base.OnboardingListSelectionEvent;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.ViewModelListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.RecyclerViewPortListener;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact.Handle;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeEmail.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.InviteeProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Builder;
import com.linkedin.android.pegasus.gen.voyager.growth.invitation.NormInvitation.Invitee.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow.Entity;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PymkFragment
  extends OnboardingListFragment<PeopleYouMayKnow, PymkItemViewModel>
{
  Set<String> invitedPymkHandles;
  @Inject
  SnackbarUtil snackbar;
  @Inject
  ViewPortManager viewPortManager;
  
  static JSONObject createInvitations(List<PeopleYouMayKnow> paramList)
  {
    for (;;)
    {
      try
      {
        localJSONArray = new JSONArray();
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localPeopleYouMayKnow = (PeopleYouMayKnow)localIterator.next();
        paramList = null;
        if (entity.miniProfileValue == null) {
          continue;
        }
        paramList = entity.miniProfileValue.entityUrn.getId();
        paramList = new InviteeProfile.Builder().setProfileId(paramList).build(RecordTemplate.Flavor.RECORD);
        paramList = new NormInvitation.Invitee.Builder().setInviteeProfileValue(paramList).build();
      }
      catch (BuilderException paramList)
      {
        PeopleYouMayKnow localPeopleYouMayKnow;
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed validation for invitations", paramList));
        return null;
        if (entity.guestContactValue == null) {
          continue;
        }
        String str = entity.guestContactValue.handle.stringValue;
        if (str == null) {
          continue;
        }
        paramList = new InviteeEmail.Builder().setEmail(str).build(RecordTemplate.Flavor.RECORD);
        paramList = new NormInvitation.Invitee.Builder().setInviteeEmailValue(paramList).build();
        continue;
        Util.safeThrow$7a8b4789(new RuntimeException("Pymk entity is not a member or a guest"));
        continue;
      }
      catch (JSONException paramList)
      {
        JSONArray localJSONArray;
        Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to create JSON object for invitations", paramList));
        continue;
        if (localJSONArray.length() <= 0) {
          continue;
        }
        paramList = new JSONObject().put("invitations", localJSONArray);
      }
      if (paramList != null) {
        localJSONArray.put(PegasusPatchGenerator.modelToJSON(new NormInvitation.Builder().setInvitee(paramList).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD)));
      }
    }
    return paramList;
  }
  
  static String getPymkHandle(PeopleYouMayKnow paramPeopleYouMayKnow)
  {
    if (entity.miniProfileValue != null) {
      return entity.miniProfileValue.entityUrn.getId();
    }
    if (entity.guestContactValue != null)
    {
      if (entity.guestContactValue.handle.stringValue != null) {
        return entity.guestContactValue.handle.stringValue;
      }
    }
    else {
      Util.safeThrow$7a8b4789(new RuntimeException("Pymk entity is not a member or a guest"));
    }
    return null;
  }
  
  private void onConnectFailed()
  {
    Snackbar localSnackbar = snackbar.make(2131231606, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  static void togglePymkViewModelState(PymkItemViewModel paramPymkItemViewModel)
  {
    if (!selected) {}
    for (boolean bool = true;; bool = false)
    {
      selected = bool;
      if (viewModelListener != null) {
        viewModelListener.onViewModelChanged(paramPymkItemViewModel);
      }
      return;
    }
  }
  
  public final void doEnter()
  {
    super.doEnter();
    viewPortManager.trackAll(tracker);
  }
  
  public final void doLeave()
  {
    super.doLeave();
    viewPortManager.untrackAll();
  }
  
  protected final void initialize()
  {
    if ((getDataProvider().getPeopleYouMayKnow() != null) && (getDataProvidergetPeopleYouMayKnowhasElements))
    {
      List localList = transformModelCollection(getDataProvidergetPeopleYouMayKnowelements);
      adapter.setValues(localList);
      updateAddAllButton();
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  final void onConnectAllFailed()
  {
    Snackbar localSnackbar = snackbar.make(2131231603, 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    invitedPymkHandles = new HashSet();
    if (paramBundle != null)
    {
      fromCache = true;
      getDataProvider().makeParallelCacheRequest(busSubscriberId, getRumSessionId(), new DataRequestWrapper.Builder[] { Request.get().url(getDataProviderstate).peopleYouMayKnowRoute).builder(CollectionTemplate.of(PeopleYouMayKnow.BUILDER)) });
      paramBundle = paramBundle.getStringArrayList("invitedPymkHandles");
      if (paramBundle != null) {
        invitedPymkHandles.addAll(paramBundle);
      }
    }
  }
  
  public final View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968846, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((getDataProvider().getPeopleYouMayKnow() != null) && (getDataProvidergetPeopleYouMayKnowhasElements)) {
      initialize();
    }
  }
  
  @Subscribe
  public final void onEvent(OnboardingListSelectionEvent<PeopleYouMayKnow, PymkItemViewModel> paramOnboardingListSelectionEvent)
  {
    Object localObject = (PeopleYouMayKnow)model;
    PymkItemViewModel localPymkItemViewModel = (PymkItemViewModel)viewModel;
    if (isSelection)
    {
      paramOnboardingListSelectionEvent = new ArrayList();
      paramOnboardingListSelectionEvent.add(localObject);
      paramOnboardingListSelectionEvent = createInvitations(paramOnboardingListSelectionEvent);
      if (paramOnboardingListSelectionEvent != null)
      {
        localObject = getPymkHandle((PeopleYouMayKnow)localObject);
        if (localObject != null) {
          invitedPymkHandles.add(localObject);
        }
        updateAddAllButton();
        togglePymkViewModelState(localPymkItemViewModel);
        trackLegoWidgetPrimaryAction(1);
        getDataProvider().batchSendPymkInvitations$55f8b3d8(paramOnboardingListSelectionEvent, new PymkFragment.3(this, (String)localObject, localPymkItemViewModel), Tracker.createPageInstanceHeader(getPageInstance()));
      }
    }
    else
    {
      return;
    }
    onConnectFailed();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("saved", true);
    if (invitedPymkHandles != null)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(invitedPymkHandles);
      paramBundle.putStringArrayList("invitedPymkHandles", localArrayList);
    }
  }
  
  public final void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    paramView = new DividerItemDecoration(1);
    paramView.setDivider(getResources(), 2130837654);
    paramView.setStartMargin((int)getResources().getDimension(2131492963) + (int)getResources().getDimension(2131492989));
    recyclerView.addItemDecoration(paramView);
    addAllButton.setOnClickListener(new PymkFragment.1(this, tracker, "connect_all", new TrackingEventBuilder[0]));
    nextButton.setText(2131231575);
    nextButton.setOnClickListener(new PymkFragment.2(this, legoWidget.getTrackingToken(), ActionCategory.SKIP, legoTrackingDataProvider, tracker, "next", new TrackingEventBuilder[0]));
    viewPortManager.container = recyclerView;
    adapter.setViewPortManager(viewPortManager);
    recyclerView.addOnScrollListener(new RecyclerViewPortListener(viewPortManager));
  }
  
  public final String pageKey()
  {
    return "onboarding_pymk";
  }
  
  final void updateAddAllButton()
  {
    boolean bool = true;
    Object localObject;
    if ((addAllButton != null) && (getDataProvider().getPeopleYouMayKnow() != null) && (getDataProvidergetPeopleYouMayKnowhasElements))
    {
      localObject = i18NManager.getString(2131231511, new Object[] { Integer.valueOf(getDataProvidergetPeopleYouMayKnowelements.size() - invitedPymkHandles.size()) });
      addAllButton.setText((CharSequence)localObject);
      localObject = addAllButton;
      if (invitedPymkHandles.size() >= getDataProvidergetPeopleYouMayKnowelements.size()) {
        break label124;
      }
    }
    for (;;)
    {
      ((Button)localObject).setEnabled(bool);
      return;
      label124:
      bool = false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.pymk.PymkFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */