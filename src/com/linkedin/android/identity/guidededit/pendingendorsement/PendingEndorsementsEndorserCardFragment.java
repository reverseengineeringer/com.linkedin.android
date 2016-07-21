package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardBaseDataProvider.MeCardState;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ActorMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.EndorsementStatus;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PendingEndorsementsEndorserCardFragment
  extends PageFragment
  implements OnBackPressedListener
{
  public static final String TAG = PendingEndorsementsEndorserCardFragment.class.getSimpleName();
  private PendingEndorsementsEndorserListener endorserListener;
  @InjectView(2131757148)
  CardView pendingEndorsementsEndorserCardView;
  private PendingEndorsementsEndorserViewHolder viewHolder;
  private PendingEndorsementsEndorserViewModel viewModel;
  
  final void fetchPendingEndorsementsEndorser()
  {
    PendingEndorsementsEndorserDataProvider localPendingEndorsementsEndorserDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    localBuilder = localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    customHeaders = trackingHeader;
    localBuilder = localBuilder.required(Request.get().url(state).meCardRoute).builder(Card.BUILDER));
    localPendingEndorsementsEndorserDataProvider.performMultiplexedFetch(str1, str2, trackingHeader, localBuilder);
  }
  
  final PendingEndorsementsEndorserDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.pendingEndorsementsEndorserDataProvider();
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    try
    {
      endorserListener = ((PendingEndorsementsEndorserListener)paramContext);
      return;
    }
    catch (ClassCastException paramContext)
    {
      throw new ClassCastException(endorserListener.toString() + " must implement PendingEndorsementsEndorserListener");
    }
  }
  
  public final boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    paramBundle = ((BaseActivity)getActivity()).getIntent().getExtras();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getString("meCardUrn");; paramBundle = null)
    {
      getDataProvidertrackingHeader = Tracker.createPageInstanceHeader(getPageInstance());
      ((MeCardBaseDataProvider.MeCardState)getDataProviderstate).setMeCardRoute(PendingEndorsementsEndorserDataProvider.getMeCardRoute(paramBundle));
      return;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969126, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    super.onDataError(paramType, paramSet, paramDataManagerException);
    toggleVisibility(false);
    endorserListener.onEndorserDataReceived();
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    int i;
    if ((paramMap != null) && (paramMap.containsKey(getDataProviderstate).meCardRoute)))
    {
      endorserListener.onEndorserDataReceived();
      if (((MeCardBaseDataProvider.MeCardState)getDataProviderstate).getMeCard() == null) {
        break label110;
      }
      i = 1;
    }
    while (i != 0)
    {
      paramType = getDataProviderstate).getMeCard().value.endorsementCardValue.endorser.miniProfile;
      Object localObject = getDataProvider().getPendingEndorsements();
      if (((List)localObject).isEmpty())
      {
        toggleVisibility(false);
        return;
        label110:
        i = 0;
      }
      else
      {
        toggleVisibility(true);
        paramSet = i18NManager;
        paramMap = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Endorsement localEndorsement = (Endorsement)((Iterator)localObject).next();
          if (status == EndorsementStatus.ACCEPTED) {
            paramMap.add(skill);
          } else if (status == EndorsementStatus.PENDING) {
            localArrayList.add(skill);
          }
        }
        localObject = new PendingEndorsementsEndorserViewModel();
        profileClickListener = new PendingEndorsementsEndorserTransformer.1(paramType, this);
        rumSessionId = Util.retrieveRumSessionId(fragmentComponent);
        oldEndorsedSkills = paramMap;
        newEndorsedSkills = localArrayList;
        endorserCardTitle = paramSet.getString(2131233031, new Object[] { I18NManager.getName(paramType), Integer.valueOf(paramMap.size() + localArrayList.size()) });
        endorser = paramType;
        seeAllSkillsClickListener = new PendingEndorsementsEndorserTransformer.2(tracker, "pending_endorsements:see_all_skills", new TrackingEventBuilder[0], this);
        if (viewModel == null)
        {
          paramType = LayoutInflater.from(getActivity()).inflate(PendingEndorsementsEndorserViewHolder.CREATOR.getLayoutId(), (ViewGroup)getView(), true);
          viewHolder = ((PendingEndorsementsEndorserViewHolder)PendingEndorsementsEndorserViewHolder.CREATOR.createViewHolder(paramType));
        }
        getActivity().getLayoutInflater();
        ((PendingEndorsementsEndorserViewModel)localObject).onBindViewHolder$68ba20cb(applicationComponent.mediaCenter(), viewHolder);
        viewModel = ((PendingEndorsementsEndorserViewModel)localObject);
        return;
      }
    }
    toggleVisibility(false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getView().setVisibility(8);
    if (PendingEndorsementsEntryPoint.ME == PendingEndorsementsUtil.getEntryPoint(this))
    {
      fetchPendingEndorsementsEndorser();
      return;
    }
    toggleVisibility(false);
  }
  
  public final String pageKey()
  {
    return "pending_endorsements_endorser";
  }
  
  final void toggleVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      pendingEndorsementsEndorserCardView.setVisibility(0);
    }
    for (;;)
    {
      endorserListener.onEndorserCardVisibilityChanged(paramBoolean);
      return;
      pendingEndorsementsEndorserCardView.setVisibility(8);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementsEndorserCardFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */