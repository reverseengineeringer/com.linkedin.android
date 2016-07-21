package com.linkedin.android.relationships.meetings;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.pemberly.text.AttributedText;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.RelMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingDetail;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.calendar.MeetingStatus;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.prop.Prop;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent;
import com.linkedin.android.relationships.shared.events.InvitationUpdatedEvent.Type;
import com.linkedin.android.relationships.widgets.FakeListView;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.prop.Entity.Builder;
import com.linkedin.gen.avro2pegasus.events.prop.PropImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class MeetingDetailsFragment
  extends PageFragment
{
  @InjectView(2131758412)
  FakeListView attendeesList;
  private ViewModelArrayAdapter<MeetingDetailAttendeeViewModel> attendeesListAdapter;
  @InjectView(2131758411)
  TextView attendeesSectionTitle;
  @InjectView(2131758410)
  View container;
  @Inject
  Context context;
  private ErrorPageViewModel errorPageViewModel;
  @InjectView(2131756773)
  ViewStub errorViewStub;
  @Inject
  MediaCenter mediaCenter;
  @Inject
  MeetingDetailsDataProvider meetingDetailsDataProvider;
  private int pageState;
  @InjectView(2131756626)
  ProgressBar progressBar;
  private Prop prop;
  @InjectView(2131755468)
  Toolbar toolbar;
  @Inject
  Tracker tracker;
  
  private void fetchDataAndShowLoading()
  {
    if (getView() != null)
    {
      updatePageState(0);
      progressBar.animate();
    }
    String str1 = getArguments().getString("meeting_id");
    MeetingDetailsDataProvider localMeetingDetailsDataProvider = meetingDetailsDataProvider;
    String str2 = busSubscriberId;
    String str3 = getRumSessionId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    state).meetingDetailsRoute = Routes.RELATIONSHIPS_MEETING_DETAILS.buildUponRoot().buildUpon().appendPath(str1).build().toString();
    localMeetingDetailsDataProvider.performFetch(MeetingDetail.BUILDER, state).meetingDetailsRoute, str2, str3, localMap);
  }
  
  private void renderErrorPage()
  {
    if (getView() == null) {
      return;
    }
    updatePageState(2);
    Object localObject = new MeetingDetailsFragment.2(this, tracker, "try_again");
    ErrorPageViewHolder localErrorPageViewHolder = (ErrorPageViewHolder)errorPageViewModel.getCreator().createViewHolder(getView());
    errorPageViewModel.setupDefaultErrorConfiguration(getContext(), (TrackingClosure)localObject);
    localObject = errorPageViewModel;
    LayoutInflater localLayoutInflater = getActivity().getLayoutInflater();
    applicationComponent.mediaCenter();
    ((ErrorPageViewModel)localObject).onBindViewHolderWithErrorTracking$18b8048(localLayoutInflater, localErrorPageViewHolder, tracker, getPageInstance());
  }
  
  private void updatePageState(int paramInt)
  {
    int j = 0;
    pageState = paramInt;
    Object localObject = progressBar;
    if (paramInt == 0)
    {
      i = 0;
      ((ProgressBar)localObject).setVisibility(i);
      localObject = container;
      if (paramInt != 1) {
        break label63;
      }
    }
    label63:
    for (int i = j;; i = 8)
    {
      ((View)localObject).setVisibility(i);
      if (paramInt != 2) {
        errorPageViewModel.remove();
      }
      return;
      i = 8;
      break;
    }
  }
  
  private void updateTitle(MeetingStatus paramMeetingStatus)
  {
    switch (MeetingDetailsFragment.3.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$relationships$shared$calendar$MeetingStatus[paramMeetingStatus.ordinal()])
    {
    default: 
      toolbar.setTitle(2131233438);
      return;
    case 1: 
      toolbar.setTitle(2131233437);
      return;
    }
    toolbar.setTitle(2131233436);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if (pageState == -1) {
      fetchDataAndShowLoading();
    }
  }
  
  public final void doLeave()
  {
    super.doLeave();
    if ((prop == null) || (attendeesListAdapter.getValues().size() == 0)) {
      return;
    }
    View localView = attendeesListAdapter.getValues().get(0)).viewHolder.itemView;
    Entity.Builder localBuilder = new Entity.Builder();
    Object localObject = new ArrayList();
    try
    {
      localBuilder.setUrn(prop.entityUrn.toString()).setTrackingId(prop.trackingId).setVisibleTime(Long.valueOf(0L)).setDuration(Long.valueOf(0L)).setListPosition(new ListPosition.Builder().setIndex(Integer.valueOf(1)).build(RecordTemplate.Flavor.RECORD)).setSize(new EntityDimension.Builder().setHeight(Integer.valueOf(localView.getHeight())).setWidth(Integer.valueOf(localView.getWidth())).build(RecordTemplate.Flavor.RECORD));
      ((List)localObject).add(localBuilder.build(RecordTemplate.Flavor.RECORD));
      localObject = new PropImpressionEvent.Builder().setModuleKey("p-flagship3-people").setEntities((List)localObject);
      tracker.send((TrackingEventBuilder)localObject);
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Log.e("Error tracking impression:", localBuilderException);
      }
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    fragmentComponent.inject(this);
    meetingDetailsDataProvider.register(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969372, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((pageState != 1) && (paramType == DataStore.Type.NETWORK)) {
      renderErrorPage();
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramMap = ((MeetingDetailsDataProvider.State)meetingDetailsDataProvider.state).meetingDetail();
    if (paramMap != null) {
      if (getView() != null)
      {
        updatePageState(1);
        updateTitle(type);
        if (title.size() > 0) {
          attendeesSectionTitle.setText(AttributedTextUtils.getAttributedString((AttributedText)title.get(0), context));
        }
        paramType = attendeesListAdapter;
        paramSet = fragmentComponent;
        paramMap = attendees;
        localProp = prop;
        localArrayList = new ArrayList();
        i = 0;
        if (i < paramMap.size())
        {
          localRelMiniProfile = (RelMiniProfile)paramMap.get(i);
          if (i != paramMap.size() - 1) {}
          for (bool = true;; bool = false)
          {
            localArrayList.add(MeetingDetailAttendeeViewModelTransformer.toViewModel(paramSet, localRelMiniProfile, localProp, bool));
            i += 1;
            break;
          }
        }
        paramType.setValues(localArrayList);
      }
    }
    while ((pageState == 1) || (paramType != DataStore.Type.NETWORK))
    {
      Prop localProp;
      ArrayList localArrayList;
      int i;
      RelMiniProfile localRelMiniProfile;
      boolean bool;
      return;
    }
    renderErrorPage();
  }
  
  public void onDestroy()
  {
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
    meetingDetailsDataProvider.unregister(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(InvitationUpdatedEvent paramInvitationUpdatedEvent)
  {
    Object localObject = attendeesListAdapter.getValues().iterator();
    MeetingDetailAttendeeViewModel localMeetingDetailAttendeeViewModel;
    while (((Iterator)localObject).hasNext())
    {
      localMeetingDetailAttendeeViewModel = (MeetingDetailAttendeeViewModel)((Iterator)localObject).next();
      if ((TextUtils.equals(profileId, profileId)) && (type == InvitationUpdatedEvent.Type.SENT))
      {
        paramInvitationUpdatedEvent = (MeetingDetailsDataProvider.State)meetingDetailsDataProvider.state;
        localObject = profileId;
        paramInvitationUpdatedEvent = paramInvitationUpdatedEvent.meetingDetail();
        if (paramInvitationUpdatedEvent == null) {
          break label163;
        }
        Iterator localIterator = attendees.iterator();
        do
        {
          if (!localIterator.hasNext()) {
            break;
          }
          paramInvitationUpdatedEvent = (RelMiniProfile)localIterator.next();
        } while (!miniProfile.entityUrn.getId().equals(localObject));
      }
    }
    for (;;)
    {
      paramInvitationUpdatedEvent = MeetingDetailAttendeeViewModelTransformer.toViewModel(fragmentComponent, paramInvitationUpdatedEvent, prop, showBottomBorder);
      state = 3;
      attendeesListAdapter.changeViewModel(localMeetingDetailAttendeeViewModel, paramInvitationUpdatedEvent);
      return;
      label163:
      paramInvitationUpdatedEvent = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = getArguments();
    prop = ((Prop)RecordParceler.quietUnparcel(Prop.BUILDER, "prop", paramView));
    errorPageViewModel = new ErrorPageViewModel(errorViewStub);
    errorPageViewModel.remove();
    attendeesListAdapter = new ViewModelArrayAdapter(context, mediaCenter, null);
    attendeesList.setAdapter(attendeesListAdapter);
    updateTitle(MeetingStatus.$UNKNOWN);
    updatePageState(-1);
    toolbar.setNavigationOnClickListener(new MeetingDetailsFragment.1(this, tracker, "close", new TrackingEventBuilder[0]));
  }
  
  public final String pageKey()
  {
    return "people_meeting_details";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.meetings.MeetingDetailsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */