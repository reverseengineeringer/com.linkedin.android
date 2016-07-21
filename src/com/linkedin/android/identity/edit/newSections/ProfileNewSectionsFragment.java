package com.linkedin.android.identity.edit.newSections;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.edit.ProfileEditFragmentUtils;
import com.linkedin.android.identity.edit.ProfileEditListener;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileModelUtils;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.ProfilePictureSelectDialogFragment.OnUserSelectionListener;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.PhotoUtils;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ProfileNewSectionsFragment
  extends PageFragment
  implements ProfilePictureSelectDialogFragment.OnUserSelectionListener, OnBackPressedListener, PhotoUtils.UriListener
{
  private static final String TAG = ProfileNewSectionsFragment.class.getSimpleName();
  private boolean addCertificationsEnabled;
  private boolean addCoursesEnabled;
  private boolean addHonorsEnabled;
  private boolean addPatentsEnabled;
  private boolean addProjectsEnabled;
  private boolean addPublicationsEnabled;
  private ViewModelArrayAdapter<ViewModel> arrayAdapter;
  private List<List<ChildDrawerViewModel>> childrenViewModels = new ArrayList();
  private ParentViewModel.Category defaultExpandCategory = ParentViewModel.Category.OTHER;
  private Runnable defaultExpandRunnable;
  @Inject
  DelayedExecution delayedExecution;
  @Inject
  Bus eventBus;
  private ParentViewModel.Category expandedCategory;
  private ProfileHubListener hubListener;
  private boolean isFetchingData;
  private NormProfile modifiedNormProfile;
  private List<ParentViewModel> parentViewModels = new ArrayList();
  private Uri photoUri;
  @Inject
  PhotoUtils photoUtil;
  private Profile profile;
  private ProfileDataProvider profileDataProvider;
  private ProfileViewListenerImpl profileViewListener;
  @InjectView(2131757505)
  RecyclerView recyclerView;
  @InjectView(2131757567)
  Toolbar toolbar;
  
  private void initializeAdapter()
  {
    Object localObject3 = childrenViewModels;
    Object localObject2 = new ArrayList();
    Object localObject1 = localObject2;
    if (profile != null)
    {
      localObject1 = localObject2;
      if (modifiedNormProfile != null)
      {
        localObject4 = profile;
        localObject5 = modifiedNormProfile;
        localObject2 = fragmentComponent;
        localObject6 = profileViewListener;
        localObject1 = new ArrayList();
        if (!hasLocation)
        {
          localObject7 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject2).i18NManager().getString(2131232447);
          subHead = ((FragmentComponent)localObject2).i18NManager().getString(2131232448);
          icon = 2130838247;
          iconLegend = 2130838120;
          onClickListener = new IntroTransformer.1(((FragmentComponent)localObject2).tracker(), "add_location", new TrackingEventBuilder[0], (ProfileViewListener)localObject6, (FragmentComponent)localObject2);
          ((List)localObject1).add(localObject7);
        }
        if ((!hasHeadline) || (headline.isEmpty()))
        {
          localObject7 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject2).i18NManager().getString(2131232438);
          subHead = ((FragmentComponent)localObject2).i18NManager().getString(2131232439);
          icon = 2130838247;
          iconLegend = 2130838275;
          onClickListener = new IntroTransformer.2(((FragmentComponent)localObject2).tracker(), "add_headline", new TrackingEventBuilder[0], (ProfileViewListenerImpl)localObject6, (FragmentComponent)localObject2);
          ((List)localObject1).add(localObject7);
        }
        if ((!hasSummary) || (summary.isEmpty()))
        {
          localObject7 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject2).i18NManager().getString(2131232468);
          subHead = ((FragmentComponent)localObject2).i18NManager().getString(2131232469);
          icon = 2130838247;
          iconLegend = 2130838211;
          onClickListener = new IntroTransformer.3(((FragmentComponent)localObject2).tracker(), "add_summary", new TrackingEventBuilder[0], (ProfileViewListenerImpl)localObject6, (FragmentComponent)localObject2);
          ((List)localObject1).add(localObject7);
        }
        if ((((List)localObject1).isEmpty()) && (hasPictureInfo))
        {
          localObject4 = miniProfile;
          localObject5 = ((FragmentComponent)localObject2).i18NManager();
          localObject6 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject2).i18NManager().getString(2131232444);
          subHead = ((I18NManager)localObject5).getString(2131232446, new Object[] { I18NManager.getName((MiniProfile)localObject4) });
          icon = 2130837692;
          iconLegend = 2130837936;
          onClickListener = null;
          ((List)localObject1).add(localObject6);
        }
      }
    }
    ((List)localObject3).add(localObject1);
    localObject1 = childrenViewModels;
    Object localObject7 = profileDataProvider.getPositions();
    Object localObject6 = profileDataProvider.getEducations();
    localObject2 = profileDataProvider.getVolunteerExperiences();
    localObject3 = fragmentComponent;
    Object localObject4 = profileViewListener;
    Object localObject5 = new ArrayList();
    Object localObject8 = new ChildDrawerViewModel();
    title = ((FragmentComponent)localObject3).i18NManager().getString(2131232455);
    icon = 2130838247;
    iconLegend = 2130837920;
    onClickListener = new BackgroundTransformer.2(((FragmentComponent)localObject3).tracker(), "add_position", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
    label838:
    label972:
    label1152:
    Object localObject10;
    Object localObject9;
    int i;
    label1281:
    int j;
    label1302:
    int k;
    label1323:
    int m;
    label1345:
    int n;
    label1367:
    int i1;
    label1389:
    ChildDrawerViewModel localChildDrawerViewModel;
    if ((CollectionUtils.isNonEmpty((CollectionTemplate)localObject7)) && (paging != null))
    {
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232456, new Object[] { Integer.valueOf(paging.total) });
      ((List)localObject5).add(localObject8);
      localObject7 = new ChildDrawerViewModel();
      title = ((FragmentComponent)localObject3).i18NManager().getString(2131232435);
      icon = 2130838247;
      iconLegend = 2130838314;
      onClickListener = new BackgroundTransformer.1(((FragmentComponent)localObject3).tracker(), "add_education", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
      if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject6)) || (paging == null)) {
        break label2468;
      }
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232436, new Object[] { Integer.valueOf(paging.total) });
      ((List)localObject5).add(localObject7);
      localObject6 = new ChildDrawerViewModel();
      title = ((FragmentComponent)localObject3).i18NManager().getString(2131232470);
      icon = 2130838247;
      iconLegend = 2130838060;
      onClickListener = new BackgroundTransformer.3(((FragmentComponent)localObject3).tracker(), "add_volunteer_exp", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
      if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject2)) || (paging == null)) {
        break label2489;
      }
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232471, new Object[] { Integer.valueOf(paging.total) });
      ((List)localObject5).add(localObject6);
      ((List)localObject1).add(localObject5);
      localObject1 = childrenViewModels;
      localObject2 = profileDataProvider.getEndorsedSkills();
      localObject3 = fragmentComponent;
      localObject4 = profileViewListener;
      localObject5 = new ArrayList();
      localObject6 = new ChildDrawerViewModel();
      title = ((FragmentComponent)localObject3).i18NManager().getString(2131232465);
      icon = 2130838247;
      iconLegend = 2130838123;
      onClickListener = new SkillsTransformer.1(((FragmentComponent)localObject3).tracker(), "edit_skills_add", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
      if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject2)) || (paging == null)) {
        break label2510;
      }
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232466, new Object[] { Integer.valueOf(paging.total) });
      ((List)localObject5).add(localObject6);
      ((List)localObject1).add(localObject5);
      if (shouldSetupAccomplishmentSection())
      {
        localObject1 = childrenViewModels;
        localObject5 = profileDataProvider.getPublications();
        localObject10 = profileDataProvider.getCertifications();
        localObject2 = profileDataProvider.getPatents();
        localObject9 = profileDataProvider.getCourses();
        localObject7 = profileDataProvider.getProjects();
        localObject8 = profileDataProvider.getHonors();
        localObject3 = fragmentComponent;
        localObject4 = profileViewListener;
        localObject6 = ((FragmentComponent)localObject3).lixManager();
        if ("control".equals(((LixManager)localObject6).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_PUBLICATIONS))) {
          break label2531;
        }
        i = 1;
        if ("control".equals(((LixManager)localObject6).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_CERTIFICATIONS))) {
          break label2536;
        }
        j = 1;
        if ("control".equals(((LixManager)localObject6).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_PATENTS))) {
          break label2541;
        }
        k = 1;
        if ("control".equals(((LixManager)localObject6).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_COURSES))) {
          break label2546;
        }
        m = 1;
        if ("control".equals(((LixManager)localObject6).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_PROJECTS))) {
          break label2552;
        }
        n = 1;
        if ("control".equals(((LixManager)localObject6).getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_HONORS))) {
          break label2558;
        }
        i1 = 1;
        localObject6 = new ArrayList();
        if (j != 0)
        {
          localChildDrawerViewModel = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject3).i18NManager().getString(2131232429);
          icon = 2130838247;
          iconLegend = 2130837934;
          onClickListener = new AccomplishmentsTransformer.2(((FragmentComponent)localObject3).tracker(), "add_certification", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
          if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject10)) || (paging == null)) {
            break label2564;
          }
          subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232430, new Object[] { Integer.valueOf(paging.total) });
          label1526:
          ((List)localObject6).add(localChildDrawerViewModel);
        }
        if (m != 0)
        {
          localObject10 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject3).i18NManager().getString(2131232432);
          icon = 2130838247;
          iconLegend = 2130838195;
          onClickListener = new AccomplishmentsTransformer.4(((FragmentComponent)localObject3).tracker(), "add_course", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
          if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject9)) || (paging == null)) {
            break label2585;
          }
          subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232433, new Object[] { Integer.valueOf(paging.total) });
          label1665:
          ((List)localObject6).add(localObject10);
        }
        if (i1 != 0)
        {
          localObject9 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject3).i18NManager().getString(2131232440);
          icon = 2130838247;
          iconLegend = 2130838350;
          onClickListener = new AccomplishmentsTransformer.5(((FragmentComponent)localObject3).tracker(), "add_honor", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
          if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject8)) || (paging == null)) {
            break label2606;
          }
          subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232441, new Object[] { Integer.valueOf(paging.total) });
          label1804:
          ((List)localObject6).add(localObject9);
        }
        if (n != 0)
        {
          localObject8 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject3).i18NManager().getString(2131232458);
          icon = 2130838247;
          iconLegend = 2130838277;
          onClickListener = new AccomplishmentsTransformer.6(((FragmentComponent)localObject3).tracker(), "add_project", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
          if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject7)) || (paging == null)) {
            break label2627;
          }
          subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232459, new Object[] { Integer.valueOf(paging.total) });
          label1943:
          ((List)localObject6).add(localObject8);
        }
        if (i != 0)
        {
          localObject7 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject3).i18NManager().getString(2131232461);
          icon = 2130838247;
          iconLegend = 2130838194;
          onClickListener = new AccomplishmentsTransformer.1(((FragmentComponent)localObject3).tracker(), "add_publication", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
          if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject5)) || (paging == null)) {
            break label2648;
          }
          subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232462, new Object[] { Integer.valueOf(paging.total) });
          label2081:
          ((List)localObject6).add(localObject7);
        }
        if (k != 0)
        {
          localObject5 = new ChildDrawerViewModel();
          title = ((FragmentComponent)localObject3).i18NManager().getString(2131232449);
          icon = 2130838247;
          iconLegend = 2130838212;
          onClickListener = new AccomplishmentsTransformer.3(((FragmentComponent)localObject3).tracker(), "add_patent", new TrackingEventBuilder[0], (ProfileViewListener)localObject4, (FragmentComponent)localObject3);
          if ((!CollectionUtils.isNonEmpty((CollectionTemplate)localObject2)) || (paging == null)) {
            break label2669;
          }
          subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232450, new Object[] { Integer.valueOf(paging.total) });
          label2219:
          ((List)localObject6).add(localObject5);
        }
        ((List)localObject1).add(localObject6);
      }
      if ((profile == null) || (expandedCategory != null)) {
        break label2793;
      }
      if (defaultExpandCategory == ParentViewModel.Category.OTHER)
      {
        if ((!CollectionUtils.isEmpty(profileDataProvider.getPositions())) && (!CollectionUtils.isEmpty(profileDataProvider.getEducations()))) {
          break label2690;
        }
        localObject1 = ParentViewModel.Category.BACKGROUND;
      }
    }
    for (;;)
    {
      defaultExpandCategory = ((ParentViewModel.Category)localObject1);
      localObject1 = arrayAdapter;
      localObject2 = new ArrayList();
      ((List)localObject2).add(setupIntroParent(true));
      if (childrenViewModels.size() > 0) {
        ((List)localObject2).addAll((Collection)childrenViewModels.get(0));
      }
      ((List)localObject2).add(setupBackgroundParent(true));
      if (childrenViewModels.size() > 1) {
        ((List)localObject2).addAll((Collection)childrenViewModels.get(1));
      }
      ((List)localObject2).add(setupSkillsParent$7f1d174b());
      if (shouldSetupAccomplishmentSection()) {
        ((List)localObject2).add(setupAccomplishmentsParent$7f1d174b());
      }
      ((ViewModelArrayAdapter)localObject1).setValues((List)localObject2);
      return;
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232457);
      break;
      label2468:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232437);
      break label838;
      label2489:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232472);
      break label972;
      label2510:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232467);
      break label1152;
      label2531:
      i = 0;
      break label1281;
      label2536:
      j = 0;
      break label1302;
      label2541:
      k = 0;
      break label1323;
      label2546:
      m = 0;
      break label1345;
      label2552:
      n = 0;
      break label1367;
      label2558:
      i1 = 0;
      break label1389;
      label2564:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232431);
      break label1526;
      label2585:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232434);
      break label1665;
      label2606:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232442);
      break label1804;
      label2627:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232460);
      break label1943;
      label2648:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232463);
      break label2081;
      label2669:
      subHead = ((FragmentComponent)localObject3).i18NManager().getString(2131232451);
      break label2219;
      label2690:
      if (CollectionUtils.isEmpty(profileDataProvider.getSkills()))
      {
        localObject1 = ParentViewModel.Category.SKILLS;
      }
      else
      {
        localObject1 = profile;
        if (!hasPictureInfo) {
          i = 1;
        }
        for (;;)
        {
          if (i == 0) {
            break label2757;
          }
          localObject1 = ParentViewModel.Category.INTRO;
          break;
          if (!hasLocation) {
            i = 1;
          } else {
            i = 0;
          }
        }
        label2757:
        if ((addPublicationsEnabled) && (CollectionUtils.isEmpty(profileDataProvider.getPublications()))) {
          localObject1 = ParentViewModel.Category.ACCOMPLISHMENTS;
        } else {
          localObject1 = ParentViewModel.Category.BACKGROUND;
        }
      }
    }
    label2793:
    localObject1 = arrayAdapter;
    localObject2 = new ArrayList();
    ((List)localObject2).add(setupIntroParent(false));
    ((List)localObject2).add(setupBackgroundParent(false));
    ((List)localObject2).add(setupSkillsParent$7f1d174b());
    if (shouldSetupAccomplishmentSection()) {
      ((List)localObject2).add(setupAccomplishmentsParent$7f1d174b());
    }
    ((ViewModelArrayAdapter)localObject1).setValues((List)localObject2);
  }
  
  public static ProfileNewSectionsFragment newInstance(ProfileNewSectionBundleBuilder paramProfileNewSectionBundleBuilder)
  {
    ProfileNewSectionsFragment localProfileNewSectionsFragment = new ProfileNewSectionsFragment();
    localProfileNewSectionsFragment.setArguments(paramProfileNewSectionBundleBuilder.build());
    return localProfileNewSectionsFragment;
  }
  
  private ParentDrawerViewModel setupAccomplishmentsParent$7f1d174b()
  {
    ParentDrawerViewModel localParentDrawerViewModel = ParentDrawerTransformer.toViewModel(fragmentComponent, false, ParentViewModel.Category.ACCOMPLISHMENTS);
    parentViewModels.add(localParentDrawerViewModel);
    return localParentDrawerViewModel;
  }
  
  private ParentDrawerViewModel setupBackgroundParent(boolean paramBoolean)
  {
    ParentDrawerViewModel localParentDrawerViewModel = ParentDrawerTransformer.toViewModel(fragmentComponent, paramBoolean, ParentViewModel.Category.BACKGROUND);
    parentViewModels.add(localParentDrawerViewModel);
    return localParentDrawerViewModel;
  }
  
  private IntroDrawerViewModel setupIntroParent(boolean paramBoolean)
  {
    IntroDrawerViewModel localIntroDrawerViewModel = IntroDrawerTransformer.toViewModel(modifiedNormProfile, fragmentComponent, paramBoolean, ParentViewModel.Category.INTRO);
    parentViewModels.add(localIntroDrawerViewModel);
    return localIntroDrawerViewModel;
  }
  
  private ParentDrawerViewModel setupSkillsParent$7f1d174b()
  {
    ParentDrawerViewModel localParentDrawerViewModel = ParentDrawerTransformer.toViewModel(fragmentComponent, false, ParentViewModel.Category.SKILLS);
    parentViewModels.add(localParentDrawerViewModel);
    return localParentDrawerViewModel;
  }
  
  private boolean shouldSetupAccomplishmentSection()
  {
    return (addPublicationsEnabled) || (addCertificationsEnabled) || (addPatentsEnabled) || (addCoursesEnabled) || (addProjectsEnabled) || (addHonorsEnabled);
  }
  
  private void startAnimation()
  {
    defaultExpandRunnable = new ProfileNewSectionsFragment.2(this);
    if (expandedCategory == null)
    {
      recyclerView.post(new ProfileNewSectionsFragment.3(this));
      return;
    }
    recyclerView.post(new ProfileNewSectionsFragment.4(this));
  }
  
  public final void doPause()
  {
    super.doPause();
    delayedExecution.stopDelayedExecution(defaultExpandRunnable);
    Object localObject = parentViewModels.iterator();
    ParentViewModel localParentViewModel;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localParentViewModel = (ParentViewModel)((Iterator)localObject).next();
    } while (!isExpanded);
    for (localObject = category;; localObject = ParentViewModel.Category.OTHER)
    {
      expandedCategory = ((ParentViewModel.Category)localObject);
      toolbar.setNavigationOnClickListener(null);
      return;
    }
  }
  
  public final void doResume()
  {
    super.doResume();
    if (!isFetchingData) {
      startAnimation();
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    boolean bool2 = true;
    super.onActivityCreated(paramBundle);
    paramBundle = fragmentComponent.lixManager();
    if (!"control".equals(paramBundle.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_PUBLICATIONS)))
    {
      bool1 = true;
      addPublicationsEnabled = bool1;
      if ("control".equals(paramBundle.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_CERTIFICATIONS))) {
        break label223;
      }
      bool1 = true;
      label62:
      addCertificationsEnabled = bool1;
      if ("control".equals(paramBundle.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_PATENTS))) {
        break label228;
      }
      bool1 = true;
      label87:
      addPatentsEnabled = bool1;
      if ("control".equals(paramBundle.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_COURSES))) {
        break label233;
      }
      bool1 = true;
      label112:
      addCoursesEnabled = bool1;
      if ("control".equals(paramBundle.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_PROJECTS))) {
        break label238;
      }
      bool1 = true;
      label137:
      addProjectsEnabled = bool1;
      if ("control".equals(paramBundle.getTreatment(Lix.PROFILE_EDIT_NEW_SECTIONS_ADD_HONORS))) {
        break label243;
      }
    }
    label223:
    label228:
    label233:
    label238:
    label243:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      addHonorsEnabled = bool1;
      arrayAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      if (profileDataProvider.isDataAvailable()) {
        initializeAdapter();
      }
      recyclerView.setAdapter(arrayAdapter);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label62;
      bool1 = false;
      break label87;
      bool1 = false;
      break label112;
      bool1 = false;
      break label137;
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 != 11) {
        break label65;
      }
      photoUri = paramIntent.getData();
    }
    for (;;)
    {
      if ((photoUri != null) && (!photoUri.toString().isEmpty()))
      {
        if (profileViewListener == null) {
          break;
        }
        ProfileEditFragmentUtils.startEditPhoto(profileViewListener, photoUri);
      }
      return;
      label65:
      if (paramInt1 == 12) {
        getActivity().getContentResolver().notifyChange(photoUri, null);
      }
    }
    ProfileEditFragmentUtils.startEditPhoto((ProfileEditListener)getActivity(), photoUri);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof ProfileHubListener))
    {
      hubListener = ((ProfileHubListener)paramActivity);
      return;
    }
    if ((paramActivity instanceof HomeActivity))
    {
      profileViewListener = new ProfileViewListenerImpl((BaseActivity)getActivity());
      hubListener = profileViewListener;
      return;
    }
    throw new IllegalStateException("Activity must implement ProfileEditListener");
  }
  
  public final boolean onBackPressed()
  {
    hubListener.onExitProfileHub();
    return true;
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    photoUri = paramUri;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
    profileDataProvider.setModifiedNormProfileModel(null);
    profileDataProvider.setMasterImageUploadSignature(null);
    profileDataProvider.setCroppedImageUploadSignature(null);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    isFetchingData = false;
    if ((paramBundle != null) && (!profileDataProvider.isDataAvailable()))
    {
      profileDataProvider.loadProfileFromCache(busSubscriberId, getRumSessionId(), applicationComponent.memberUtil().getProfileId());
      isFetchingData = true;
    }
    return paramLayoutInflater.inflate(2130969194, paramViewGroup, false);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramType == DataStore.Type.LOCAL) && (profileDataProvider.isDataAvailable()))
    {
      profile = profileDataProvider.getProfileModel();
      modifiedNormProfile = profileDataProvider.getModifiedNormProfileModel();
      if (modifiedNormProfile != null) {}
    }
    try
    {
      modifiedNormProfile = ProfileModelUtils.toNormProfile(profile);
      initializeAdapter();
      if ((isResumed()) && (isFetchingData)) {
        startAnimation();
      }
      return;
    }
    catch (BuilderException paramType)
    {
      for (;;)
      {
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to convert Profile to NormProfile", paramType));
      }
    }
  }
  
  public void onDestroy()
  {
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    childrenViewModels.clear();
    parentViewModels.clear();
    recyclerView.setAdapter(null);
    super.onDestroyView();
  }
  
  @Subscribe
  public void onEvent(ParentDrawerCollapsedEvent paramParentDrawerCollapsedEvent)
  {
    int j = category.ordinal();
    if ((j < childrenViewModels.size()) && (j < parentViewModels.size()))
    {
      int i = 0;
      while (i < ((List)childrenViewModels.get(j)).size())
      {
        arrayAdapter.removeValueAtPosition(arrayAdapter.getIndex(parentViewModels.get(j)) + 1);
        i += 1;
      }
    }
  }
  
  @Subscribe
  public void onEvent(ParentDrawerExpandedEvent paramParentDrawerExpandedEvent)
  {
    int i = category.ordinal();
    if ((i < parentViewModels.size()) && (i < childrenViewModels.size()))
    {
      if (arrayAdapter.getIndex(parentViewModels.get(i)) == arrayAdapter.getItemCount() - 1) {
        arrayAdapter.appendValues((List)childrenViewModels.get(i));
      }
      while (collapseOthers)
      {
        Iterator localIterator = parentViewModels.iterator();
        while (localIterator.hasNext())
        {
          ParentViewModel localParentViewModel = (ParentViewModel)localIterator.next();
          if (category != category) {
            localParentViewModel.collapse();
          }
        }
        arrayAdapter.insertValues((List)childrenViewModels.get(i), arrayAdapter.getIndex(parentViewModels.get(i)) + 1);
      }
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("photoUri", photoUri);
    paramBundle.putSerializable("expandedCategory", expandedCategory);
  }
  
  public void onStart()
  {
    super.onStart();
    toolbar.setNavigationOnClickListener(new ProfileNewSectionsFragment.1(this, tracker, "new_section_close", new TrackingEventBuilder[0]));
  }
  
  public final void onUserSelected(int paramInt)
  {
    profileDataProvider.setModifiedNormProfileModel(modifiedNormProfile);
    String str = null;
    switch (paramInt)
    {
    default: 
      if (profileViewListener == null) {
        break;
      }
    }
    for (Object localObject = profileViewListener;; localObject = (ProfileEditListener)getActivity())
    {
      photoUtil.onUserSelection(paramInt, (ProfileEditListener)localObject, this, this, tracker, str);
      return;
      str = "profile_self_member_photo_view";
      break;
      str = "profile_self_member_photo_library";
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (paramBundle != null)
    {
      photoUri = ((Uri)paramBundle.getParcelable("photoUri"));
      expandedCategory = ((ParentViewModel.Category)paramBundle.getSerializable("expandedCategory"));
    }
    if (expandedCategory == null)
    {
      paramView = getArguments();
      if (paramView != null)
      {
        paramBundle = (ParentViewModel.Category)paramView.getSerializable("defaultExpandCategory");
        paramView = paramBundle;
        if (paramBundle == null) {
          paramView = ParentViewModel.Category.OTHER;
        }
        defaultExpandCategory = paramView;
      }
    }
    if (profileDataProvider.isDataAvailable())
    {
      profile = profileDataProvider.getProfileModel();
      modifiedNormProfile = profileDataProvider.getModifiedNormProfileModel();
    }
    if ((profile == null) || (modifiedNormProfile == null)) {}
    for (;;)
    {
      try
      {
        modifiedNormProfile = ProfileModelUtils.toNormProfile(profile);
        paramView = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(paramView);
        return;
      }
      catch (BuilderException paramView)
      {
        Util.safeThrow(new RuntimeException("Failed to convert Profile to NormProfile", paramView));
        continue;
      }
      if (modifiedNormProfile.hasPictureInfo) {
        paramView = null;
      }
      try
      {
        paramBundle = ProfileModelUtils.toNormProfile(profile);
        paramView = paramBundle;
      }
      catch (BuilderException paramBundle)
      {
        for (;;)
        {
          Util.safeThrow(new RuntimeException("Failed to convert profile to core profile", paramBundle));
        }
      }
      if ((paramView != null) && (!paramView.equals(modifiedNormProfile))) {
        profileDataProvider.postUpdateProfilePicture(busSubscriberId, getRumSessionId(), profile.entityUrn.getId(), paramView, modifiedNormProfile, profile.versionTag, Tracker.createPageInstanceHeader(getPageInstance()));
      }
    }
  }
  
  public final String pageKey()
  {
    return "profile_self_hub";
  }
  
  public static abstract interface ProfileHubListener
  {
    public abstract void onExitProfileHub();
    
    public abstract void startProfileHub(ParentViewModel.Category paramCategory);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.newSections.ProfileNewSectionsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */