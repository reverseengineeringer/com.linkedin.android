package com.linkedin.android.identity.profile.view.featuredskills.details;

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
import com.linkedin.android.identity.profile.view.featuredskills.FeaturedSkillEntryViewModel;
import com.linkedin.android.identity.profile.view.featuredskills.FeaturedSkillsTransformer;
import com.linkedin.android.identity.profile.view.pagedlist.PagedListFragment;
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
import org.greenrobot.eventbus.Subscribe;

public class FeaturedSkillsDetailsFragment
  extends PagedListFragment<EndorsedSkill, EndorsementsCollectionMetadata, FeaturedSkillEntryViewModel>
{
  private static final String TAG = FeaturedSkillsDetailsFragment.class.getSimpleName();
  private GraphDistance distance;
  private CollectionTemplateHelper<EndorsedSkill, EndorsementsCollectionMetadata> endorsedSkillsCollectionHelper;
  private Map<String, FeaturedSkillEntryViewModel> entryMap;
  private ProfileDataProvider profileDataProvider;
  private String profileId;
  private ProfileViewListener profileViewListener;
  @InjectView(2131755468)
  Toolbar toolbar;
  
  public static FeaturedSkillsDetailsFragment newInstance(FeaturedSkillsDetailsBundleBuilder paramFeaturedSkillsDetailsBundleBuilder)
  {
    FeaturedSkillsDetailsFragment localFeaturedSkillsDetailsFragment = new FeaturedSkillsDetailsFragment();
    localFeaturedSkillsDetailsFragment.setArguments(paramFeaturedSkillsDetailsBundleBuilder.build());
    return localFeaturedSkillsDetailsFragment;
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
    return ProfileRoutes.buildFeaturedSkillsRoute(profileId);
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
    return ProfileRoutes.buildFeaturedSkillsRouteWithCount$68d17de5(profileId);
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
    profileId = getArguments().getString("profileId", "");
    Object localObject = (GraphDistance)getArguments().get("graphDistance");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = GraphDistance.$UNKNOWN;
    }
    distance = paramBundle;
    profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
    paramBundle = profileDataProvider;
    localObject = busSubscriberId;
    String str = getRumSessionId();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    state).allFeaturedSkillsRoute = ProfileRoutes.buildFeaturedSkillsRouteWithCount$68d17de5(profileId).toString();
    MultiplexRequest.Builder localBuilder = MultiplexRequest.Builder.parallel();
    multiplexerUrl = Routes.MUX.buildUponRoot().toString();
    paramBundle.performMultiplexedFetch((String)localObject, str, localMap, localBuilder.filter(DataManager.DataStoreFilter.NETWORK_ONLY).optional(Request.get().url(state).allFeaturedSkillsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))));
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
      String str = ProfileRoutes.buildCreateEndorsementRoute(profileId).toString();
      Iterator localIterator1 = paramSet.iterator();
      while (localIterator1.hasNext()) {
        if ((((String)localIterator1.next()).equalsIgnoreCase(str)) && (paramMap != null) && (paramMap.containsKey(str)))
        {
          if (profileDataProvider.getAllFeaturedSkills() != null) {}
          for (paramType = profileDataProvider.getAllFeaturedSkills().elements;; paramType = null)
          {
            NormEndorsement localNormEndorsement = (NormEndorsement)getrequest.model;
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
            paramType = FeaturedSkillsTransformer.toSkillEntry(paramSet, profileId, GraphDistance.DISTANCE_1, true, fragmentComponent, true, profileViewListener, false);
            updateItem((ViewModel)entryMap.get(skill.name), paramType);
            entryMap.remove(skill.name);
          }
        }
      }
    }
  }
  
  @Subscribe
  public void onEvent(EndorseFeaturedSkillDetailEvent paramEndorseFeaturedSkillDetailEvent)
    throws BuilderException
  {
    long l = fragmentComponent.memberUtil().getMemberId();
    Object localObject1 = fragmentComponent.memberUtil().getMiniProfile();
    if ((l == -1L) || (localObject1 == null)) {
      return;
    }
    Object localObject2 = Urn.createFromTuple("member", new Object[] { Long.valueOf(l) });
    Object localObject3 = Urn.createFromTuple("member", new Object[] { endorseeProfileId });
    localObject2 = new NormEndorsement.Builder().setSkill(endorsedSkill.skill).setEndorserUrn((Urn)localObject2).setEndorseeUrn((Urn)localObject3).build(RecordTemplate.Flavor.RECORD);
    profileDataProvider.postAddEndorsementDetailFeaturedSkill(busSubscriberId, getRumSessionId(), endorseeProfileId, (NormEndorsement)localObject2, Tracker.createPageInstanceHeader(getPageInstance()));
    try
    {
      localObject2 = endorsedSkill;
      localObject3 = endorseeProfileId;
      Object localObject4 = new Endorsement.Builder().setEntityUrn(ProfileUrnUtil.createEndorsementUrn((String)localObject3, "-1")).setEndorser(new EndorserMiniProfile.Builder().setMiniProfile((MiniProfile)localObject1).build(RecordTemplate.Flavor.RECORD)).setStatus(EndorsementStatusType.ACCEPTED);
      localObject1 = new ArrayList();
      ((List)localObject1).add(0, ((Endorsement.Builder)localObject4).build(RecordTemplate.Flavor.RECORD));
      localObject4 = endorsements.iterator();
      while (((Iterator)localObject4).hasNext()) {
        ((List)localObject1).add((Endorsement)((Iterator)localObject4).next());
      }
      localObject1 = FeaturedSkillsTransformer.toSkillEntry(new EndorsedSkill.Builder().setSkill(skill).setEndorsedByViewer(Boolean.valueOf(true)).setEndorsementCount(Integer.valueOf(endorsementCount + 1)).setEndorsements((List)localObject1).build(), (String)localObject3, GraphDistance.DISTANCE_1, true, fragmentComponent, true, profileViewListener, false);
    }
    catch (BuilderException paramEndorseFeaturedSkillDetailEvent)
    {
      Log.e(TAG, "Could not create skill detail entry viewmodel");
      return;
    }
    isButtonDisabled = true;
    updateItem(viewModel, (ViewModel)localObject1);
    entryMap.put(endorsedSkill.skill.name, localObject1);
  }
  
  @Subscribe
  public void onEvent(UnendorseFeaturedSkillDetailEvent paramUnendorseFeaturedSkillDetailEvent)
    throws IOException
  {
    profileDataProvider.deleteEndorsementDetailFeaturedSkill(busSubscriberId, getRumSessionId(), endorseeProfileId, endorsementId, endorsedSkill.skill.name, Tracker.createPageInstanceHeader(getPageInstance()));
    Object localObject;
    try
    {
      localObject = endorsementId;
      EndorsedSkill localEndorsedSkill = endorsedSkill;
      String str = endorseeProfileId;
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = endorsements.iterator();
      while (localIterator.hasNext())
      {
        Endorsement localEndorsement = (Endorsement)localIterator.next();
        if ((hasEntityUrn) && (!entityUrn.getLastId().equalsIgnoreCase((String)localObject))) {
          localArrayList.add(localEndorsement);
        }
      }
      localObject = FeaturedSkillsTransformer.toSkillEntry(new EndorsedSkill.Builder().setSkill(skill).setEndorsedByViewer(Boolean.valueOf(false)).setEndorsementCount(Integer.valueOf(endorsementCount - 1)).setEndorsements(localArrayList).build(), str, GraphDistance.DISTANCE_1, true, fragmentComponent, true, profileViewListener, false);
    }
    catch (BuilderException paramUnendorseFeaturedSkillDetailEvent)
    {
      Log.e(TAG, "Could not create skill detail entry viewmodel");
      return;
    }
    updateItem(viewModel, (ViewModel)localObject);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    toolbar.setTitle(2131233293);
    toolbar.setNavigationOnClickListener(new FeaturedSkillsDetailsFragment.1(this));
  }
  
  public final String pageKey()
  {
    return "profile_view_base_skills_details";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.featuredskills.details.FeaturedSkillsDetailsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */