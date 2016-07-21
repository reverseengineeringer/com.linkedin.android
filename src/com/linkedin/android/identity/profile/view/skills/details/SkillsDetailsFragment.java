package com.linkedin.android.identity.profile.view.skills.details;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListFragment;
import com.linkedin.android.identity.profile.view.skills.SkillEntryViewModel;
import com.linkedin.android.identity.profile.view.skills.SkillsTransformer;
import com.linkedin.android.identity.shared.ProfileUrnUtil;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementStatusType;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementsCollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorserMiniProfile.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormEndorsement.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class SkillsDetailsFragment
  extends PagedListFragment<EndorsedSkill, EndorsementsCollectionMetadata, SkillEntryViewModel>
{
  private static final String TAG = SkillsDetailsFragment.class.getSimpleName();
  private GraphDistance distance;
  private CollectionTemplateHelper<EndorsedSkill, EndorsementsCollectionMetadata> endorsedSkillsCollectionHelper;
  private Map<String, SkillEntryViewModel> entryMap;
  @Inject
  MemberUtil memberUtil;
  private ProfileDataProvider profileDataProvider;
  private String profileId;
  private ProfileViewListener profileViewListener;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public static SkillsDetailsFragment newInstance(SkillsDetailsBundleBuilder paramSkillsDetailsBundleBuilder)
  {
    SkillsDetailsFragment localSkillsDetailsFragment = new SkillsDetailsFragment();
    localSkillsDetailsFragment.setArguments(paramSkillsDetailsBundleBuilder.build());
    return localSkillsDetailsFragment;
  }
  
  public final void doEnter()
  {
    super.doEnter();
    if ((profileId != null) && (fragmentComponent.memberUtil().isSelf(profileId))) {}
    for (String str = "profile_self_view_skills_details";; str = "profile_view_skills_details")
    {
      delayedExecution.postExecution(ProfileViewUtils.getPageViewEventRunnable(tracker, str));
      return;
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
  }
  
  public final Uri getBaseLoadMoreUri()
  {
    return ProfileRoutes.buildEndorsedSkillsRoute(profileId);
  }
  
  public final CollectionTemplateHelper<EndorsedSkill, EndorsementsCollectionMetadata> getCollectionHelper()
  {
    if (endorsedSkillsCollectionHelper == null) {
      endorsedSkillsCollectionHelper = new CollectionTemplateHelper(fragmentComponent.dataManager(), null, EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER);
    }
    return endorsedSkillsCollectionHelper;
  }
  
  public final Uri getInitialFetchUri()
  {
    return ProfileRoutes.buildEndorsedSkillsRouteWithCount$68d17de5(profileId);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof HomeActivity)) {
      profileViewListener = new ProfileViewListenerImpl((HomeActivity)paramActivity);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    profileId = getArguments().getString("profileId");
    distance = ((GraphDistance)getArguments().get("graphDistance"));
    profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
    paramBundle = profileDataProvider;
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    state).allEndorsedSkillsRoute = ProfileRoutes.buildEndorsedSkillsRouteWithCount$68d17de5(profileId).toString();
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramBundle.performMultiplexedFetch(str1, str2, localMap, localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY).optional(Request.get().url(state).allEndorsedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))));
    entryMap = new HashMap();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969218, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    super.onDataReady(paramType, paramSet, paramMap);
    if (paramSet == null) {}
    for (;;)
    {
      return;
      Iterator localIterator1 = paramSet.iterator();
      while (localIterator1.hasNext()) {
        if (((String)localIterator1.next()).equalsIgnoreCase(ProfileRoutes.buildCreateEndorsementRoute(profileId).toString()))
        {
          if (profileDataProvider.getAllEndorsedSkills() != null) {}
          for (paramType = profileDataProvider.getAllEndorsedSkills().elements;; paramType = null)
          {
            NormEndorsement localNormEndorsement = (NormEndorsement)getbuildCreateEndorsementRouteprofileId).toString())).request.model;
            paramSet = null;
            Object localObject = null;
            if (CollectionUtils.isEmpty(paramType)) {
              break;
            }
            Iterator localIterator2 = paramType.iterator();
            paramType = (DataStore.Type)localObject;
            for (;;)
            {
              paramSet = paramType;
              if (!localIterator2.hasNext()) {
                break;
              }
              paramSet = (EndorsedSkill)localIterator2.next();
              if (skill.name.equals(skill.name)) {
                paramType = paramSet;
              }
            }
          }
          if ((paramSet != null) && (entryMap.containsKey(skill.name)))
          {
            paramType = SkillsTransformer.toSkillEntry(paramSet, profileId, GraphDistance.DISTANCE_1, true, fragmentComponent, true, profileViewListener);
            updateItem((ViewModel)entryMap.get(skill.name), paramType);
            entryMap.remove(skill.name);
          }
        }
      }
    }
  }
  
  @Subscribe
  public void onEvent(EndorseSkillDetailEvent paramEndorseSkillDetailEvent)
    throws BuilderException
  {
    Object localObject1 = Urn.createFromTuple("member", new Object[] { Long.valueOf(fragmentComponent.memberUtil().getMemberId()) });
    Object localObject2 = Urn.createFromTuple("member", new Object[] { endorseeProfileId });
    localObject1 = new NormEndorsement.Builder().setSkill(endorsedSkill.skill).setEndorserUrn((Urn)localObject1).setEndorseeUrn((Urn)localObject2).build(RecordTemplate.Flavor.RECORD);
    profileDataProvider.postAddEndorsementDetail(busSubscriberId, getRumSessionId(), endorseeProfileId, (NormEndorsement)localObject1, Tracker.createPageInstanceHeader(getPageInstance()));
    Object localObject3;
    try
    {
      localObject1 = endorsedSkill;
      localObject2 = endorseeProfileId;
      localObject3 = fragmentComponent.memberUtil().getMiniProfile();
      Endorsement.Builder localBuilder = new Endorsement.Builder();
      localBuilder.setEntityUrn(ProfileUrnUtil.createEndorsementUrn((String)localObject2, "-1")).setEndorser(new EndorserMiniProfile.Builder().setMiniProfile((MiniProfile)localObject3).build(RecordTemplate.Flavor.RECORD)).setStatus(EndorsementStatusType.PENDING);
      localObject3 = new ArrayList();
      Iterator localIterator = endorsements.iterator();
      while (localIterator.hasNext()) {
        ((List)localObject3).add((Endorsement)localIterator.next());
      }
      ((List)localObject3).add(0, localBuilder.build(RecordTemplate.Flavor.RECORD));
    }
    catch (BuilderException paramEndorseSkillDetailEvent)
    {
      Log.e(TAG, "Could not create skill detail entry viewmodel");
      return;
    }
    localObject1 = SkillsTransformer.toSkillEntry(new EndorsedSkill.Builder().setSkill(skill).setEndorsedByViewer(Boolean.valueOf(true)).setEndorsementCount(Integer.valueOf(endorsementCount + 1)).setEndorsements((List)localObject3).build(), (String)localObject2, GraphDistance.DISTANCE_1, true, fragmentComponent, true, profileViewListener);
    isButtonDisabled = true;
    updateItem(viewModel, (ViewModel)localObject1);
    entryMap.put(endorsedSkill.skill.name, localObject1);
  }
  
  @Subscribe
  public void onEvent(UnendorseSkillDetailEvent paramUnendorseSkillDetailEvent)
    throws IOException
  {
    EndorsedSkill localEndorsedSkill;
    String str;
    ArrayList localArrayList;
    if (endorsementId != null)
    {
      profileDataProvider.deleteEndorsementDetail(busSubscriberId, getRumSessionId(), endorseeProfileId, endorsementId, endorsedSkill.skill.name, Tracker.createPageInstanceHeader(getPageInstance()));
      try
      {
        localObject = endorsementId;
        localEndorsedSkill = endorsedSkill;
        str = endorseeProfileId;
        localArrayList = new ArrayList();
        Iterator localIterator = endorsements.iterator();
        while (localIterator.hasNext())
        {
          Endorsement localEndorsement = (Endorsement)localIterator.next();
          if (!entityUrn.getLastId().equalsIgnoreCase((String)localObject))
          {
            localArrayList.add(localEndorsement);
            continue;
            return;
          }
        }
      }
      catch (BuilderException paramUnendorseSkillDetailEvent)
      {
        Log.e(TAG, "Could not create skill detail entry viewmodel");
      }
    }
    Object localObject = SkillsTransformer.toSkillEntry(new EndorsedSkill.Builder().setSkill(skill).setEndorsedByViewer(Boolean.valueOf(false)).setEndorsementCount(Integer.valueOf(endorsementCount - 1)).setEndorsements(localArrayList).build(), str, GraphDistance.DISTANCE_1, true, fragmentComponent, true, profileViewListener);
    updateItem(viewModel, (ViewModel)localObject);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setTitle(2131233293);
    toolbar.setNavigationOnClickListener(new SkillsDetailsFragment.1(this));
  }
  
  public final String pageKey()
  {
    return "profile_view_base_skills_details";
  }
  
  public final void showEmptyMessage()
  {
    super.showEmptyMessage();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.skills.details.SkillsDetailsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */