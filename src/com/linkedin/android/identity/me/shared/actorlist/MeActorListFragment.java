package com.linkedin.android.identity.me.shared.actorlist;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardBaseDataProvider.MeCardState;
import com.linkedin.android.identity.me.notifications.cards.dataproviders.MeCardDataProvider;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.ui.DividerItemDecoration;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.me.ActorMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.me.AggregateFollowCard;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Card.Value;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MeActorListFragment
  extends PageFragment
{
  ViewModelArrayAdapter<ViewModel> adapter;
  @InjectView(2131756633)
  RecyclerView recyclerView;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  private MeActorListItemViewModel getMeActorListItemViewModel(MiniProfile paramMiniProfile, MemberDistance paramMemberDistance)
  {
    MiniProfile localMiniProfile = MeActorListBundleBuilder.getVieweeMiniProfile(getArguments());
    String str = MeActorListBundleBuilder.getCompanyName(getArguments());
    if ((localMiniProfile != null) && (!TextUtils.isEmpty(str)))
    {
      FragmentComponent localFragmentComponent = fragmentComponent;
      MeActorListItemViewModel localMeActorListItemViewModel = MeActorListItemTransformer.toMeActorListItemViewModel(localFragmentComponent, paramMiniProfile, paramMemberDistance);
      if (("enabled".equals(localFragmentComponent.lixManager().getTreatment(Lix.ME_WVMP_VIEWERS_CTA_INTRODUCE))) && (paramMemberDistance != null) && (value == GraphDistance.DISTANCE_2))
      {
        localFragmentComponent.i18NManager();
        paramMemberDistance = I18NManager.getName(localMiniProfile);
        localFragmentComponent.i18NManager();
        paramMiniProfile = I18NManager.getName(paramMiniProfile);
        paramMiniProfile = localFragmentComponent.i18NManager().getString(2131233088, new Object[] { paramMemberDistance, paramMiniProfile, str });
        ctaTextId = 2131233089;
        ctaTextClickListener = new MeActorListItemTransformer.1(localFragmentComponent.tracker(), "message_from_wvmp", new TrackingEventBuilder[0], localFragmentComponent, localMiniProfile, paramMiniProfile);
      }
      return localMeActorListItemViewModel;
    }
    return MeActorListItemTransformer.toMeActorListItemViewModel(fragmentComponent, paramMiniProfile, paramMemberDistance);
  }
  
  public static MeActorListFragment newInstance(Bundle paramBundle)
  {
    MeActorListFragment localMeActorListFragment = new MeActorListFragment();
    localMeActorListFragment.setArguments(paramBundle);
    return localMeActorListFragment;
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968972, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((BaseActivity)getActivity() == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("MeActorListFragment onDataReady called without activity"));
    }
    int j;
    label214:
    for (;;)
    {
      return;
      paramType = getActivityactivityComponent.meCardDataProvider();
      if ((paramSet != null) && (paramSet.contains(state).meCardRoute)))
      {
        if (((MeCardBaseDataProvider.MeCardState)state).getMeCard() != null) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label214;
          }
          paramType = ((MeCardBaseDataProvider.MeCardState)state).getMeCard();
          if ((paramType == null) || (value.aggregateFollowCardValue == null)) {
            break;
          }
          paramType = value.aggregateFollowCardValue;
          if (followers.size() <= adapter.getItemCount()) {
            break;
          }
          j = adapter.getItemCount();
          i = j;
          while (i < followers.size())
          {
            paramSet = (ActorMiniProfile)followers.get(i);
            adapter.appendValue(getMeActorListItemViewModel(miniProfile, distance));
            i += 1;
          }
        }
      }
    }
    adapter.notifyItemRangeChanged(j, adapter.getItemCount() - j);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setNavigationOnClickListener(new MeActorListFragment.1(this));
    adapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
    paramView = new LinearLayoutManager(fragmentComponent.activity());
    recyclerView.setLayoutManager(paramView);
    paramView = new DividerItemDecoration(1);
    paramView.setStartMargin((int)getResources().getDimension(2131493301));
    paramView.setTopMargin((int)getResources().getDimension(2131493301));
    paramView.setEndMargin((int)getResources().getDimension(2131493301));
    paramView.setDivider(getResources(), 2130837823);
    recyclerView.addItemDecoration(paramView);
    recyclerView.setAdapter(adapter);
    if (getArguments() != null)
    {
      Object localObject1 = MeActorListBundleBuilder.getActorList(getArguments());
      Object localObject2;
      if (localObject1 != null)
      {
        paramBundle = MeActorListBundleBuilder.getMemberDistances(getArguments());
        paramView = paramBundle;
        if (paramBundle == null) {
          paramView = Collections.emptyList();
        }
        localObject2 = new ArrayList(((List)localObject1).size());
        int i = 0;
        if (i < ((List)localObject1).size())
        {
          localObject3 = (MiniProfile)((List)localObject1).get(i);
          if (paramView.size() == 0) {}
          for (paramBundle = null;; paramBundle = (MemberDistance)paramView.get(i))
          {
            ((List)localObject2).add(getMeActorListItemViewModel((MiniProfile)localObject3, paramBundle));
            i += 1;
            break;
          }
        }
        adapter.setValues((List)localObject2);
        adapter.notifyDataSetChanged();
      }
      paramView = MeActorListBundleBuilder.getActorListTitle(getArguments());
      if (paramView != null) {
        toolbar.setTitle(paramView);
      }
      Object localObject3 = MeActorListBundleBuilder.getFollowCardUrn(getArguments());
      if (localObject3 != null)
      {
        paramView = getActivityactivityComponent.meCardDataProvider();
        paramBundle = busSubscriberId;
        localObject1 = getRumSessionId();
        localObject2 = Tracker.createPageInstanceHeader(getPageInstance());
        localObject3 = MeCardDataProvider.getMeCardRoute((String)localObject3);
        ((MeCardBaseDataProvider.MeCardState)state).setMeCardRoute((String)localObject3);
        paramView.performFetch(Card.BUILDER, (String)localObject3, paramBundle, (String)localObject1, (Map)localObject2);
      }
    }
  }
  
  public final String pageKey()
  {
    return "me_profile_list";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actorlist.MeActorListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */