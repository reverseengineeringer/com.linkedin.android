package com.linkedin.android.identity.edit;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.skills.EndorsedSkillTransformerV2;
import com.linkedin.android.identity.edit.skills.EndorsedSkillViewModelV2;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.ProfileViewUtils;
import com.linkedin.android.identity.shared.SwipeDeleteUndoHelper;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.DelayedExecution;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementsCollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormSkill.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill.Builder;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public class ProfileSkillsEditFragmentV2
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileSkillsEditFragmentV2.class.getSimpleName();
  private EndlessViewModelAdapter<EndorsedSkillViewModelV2> adapter;
  public Boolean editMode;
  @InjectView(2131757545)
  ImageButton editModeBtn;
  private List<EndorsedSkill> endorsedSkills;
  @InjectView(2131757544)
  TextView header;
  @Inject
  IntentRegistry intentRegistry;
  private List<EndorsedSkill> originalSkills;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757546)
  RecyclerView recyclerView;
  private Map<String, Integer> skillEndorsementCountMap;
  private SwipeDeleteUndoHelper swipeDeleteUndoHelper;
  
  public static ProfileSkillsEditFragmentV2 newInstance(ProfileSkillsEditBundleBuilder paramProfileSkillsEditBundleBuilder)
  {
    ProfileSkillsEditFragmentV2 localProfileSkillsEditFragmentV2 = new ProfileSkillsEditFragmentV2();
    localProfileSkillsEditFragmentV2.setArguments(paramProfileSkillsEditBundleBuilder.build());
    return localProfileSkillsEditFragmentV2;
  }
  
  private void onSkillNumberChanged()
  {
    updateTitle();
    MenuItem localMenuItem = toolbar.getMenu().findItem(2131758752);
    if (endorsedSkills.size() < 50) {}
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setEnabled(bool);
      return;
    }
  }
  
  private void switchToEditMode()
  {
    if (editMode.booleanValue())
    {
      Log.e(TAG, "error switching to edit mode: already in edit mode");
      return;
    }
    editMode = Boolean.valueOf(true);
    if (enableEditSave) {
      setEditSaveMenuItemEnabled(false);
    }
    for (;;)
    {
      Iterator localIterator = adapter.getValues().iterator();
      while (localIterator.hasNext()) {
        nexteditMode = editMode.booleanValue();
      }
      createMenu();
    }
    adapter.notifyDataSetChanged();
  }
  
  private void updateTitle()
  {
    if ((endorsedSkills != null) && (header != null)) {
      header.setText(i18NManager.getString(2131233138));
    }
  }
  
  protected final void createMenu()
  {
    super.createMenu();
    toolbar.inflateMenu(2131820555);
    Object localObject = toolbar.getMenu();
    ((Menu)localObject).findItem(2131758754).setVisible(false);
    ((Menu)localObject).findItem(2131758751).setVisible(editMode.booleanValue());
    MenuItem localMenuItem = ((Menu)localObject).findItem(2131758752);
    boolean bool;
    if (!editMode.booleanValue())
    {
      bool = true;
      localMenuItem.setVisible(bool);
      ((Menu)localObject).findItem(2131758753).setVisible(false);
      localObject = toolbar.getMenu().findItem(2131758752);
      if ((getActivity() == null) || (getActivity().isFinishing())) {
        break label183;
      }
      ((MenuItem)localObject).setIcon(DrawableHelper.setTint(((MenuItem)localObject).getIcon(), ContextCompat.getColor(getActivity(), 2131624058)));
    }
    for (;;)
    {
      if (!editMode.booleanValue()) {
        break label199;
      }
      editModeBtn.setVisibility(8);
      return;
      bool = false;
      break;
      label183:
      ((MenuItem)localObject).setIcon(((MenuItem)localObject).getIcon());
    }
    label199:
    editModeBtn.setVisibility(0);
  }
  
  public final void doEnter()
  {
    super.doEnter();
    delayedExecution.postExecution(ProfileViewUtils.getPageViewEventRunnable(tracker, "profile_self_view_skills_details"));
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757542;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969188;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131233272;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    return i18NManager.getString(2131232574);
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    int j;
    if ((endorsedSkills != null) && (typeahead == ProfileTypeahead.TYPEAHEAD_PICKER_SKILL)) {
      j = 0;
    }
    try
    {
      Object localObject1 = endorsedSkills.iterator();
      do
      {
        i = j;
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
      } while (!nextskill.name.equals(text.trim()));
      int i = 1;
      if (i == 0)
      {
        localObject1 = urn;
        Object localObject2 = text;
        paramProfileTypeaheadResult = new ArrayList();
        localObject1 = new Skill.Builder().setName((String)localObject2).setStandardizedSkillUrn((Urn)localObject1).setEntityUrn(profileUtil.getMockCompoundUrn("fs_skill")).build(RecordTemplate.Flavor.RECORD);
        paramProfileTypeaheadResult = new EndorsedSkill.Builder().setSkill((Skill)localObject1).setEntityUrn(ProfileUtil.getMockUrn()).setEndorsementCount(Integer.valueOf(paramProfileTypeaheadResult.size())).setEndorsedByViewer(Boolean.valueOf(false)).setEndorsements(paramProfileTypeaheadResult).build();
        localObject1 = new NormSkill.Builder().setEntityUrn(skill.entityUrn).setName(skill.name).build(RecordTemplate.Flavor.RECORD);
        localObject2 = getDataProvider();
        String str1 = busSubscriberId;
        String str2 = getRumSessionId();
        String str3 = fragmentComponent.memberUtil().getProfileId();
        String str4 = getDataProvider().getProfileVersionTag();
        Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
        str4 = ProfileRoutes.buildAddEntityRoute("normSkills", str3, str4).toString();
        state).featuredSkillsForEditRoute = ProfileRoutes.buildFeaturedSkillsRouteForEdit(str3).toString();
        ((ProfileDataProvider)localObject2).performMultiplexedFetch(str1, str2, localMap, ((ProfileDataProvider)localObject2).getPostRequestBuilder(str4, str3, (RecordTemplate)localObject1, Request.get().url(state).featuredSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)), true));
        delayedExecution.postDelayedExecution(new ProfileSkillsEditFragmentV2.2(this, paramProfileTypeaheadResult), 500L);
        if (!editMode.booleanValue()) {
          switchToEditMode();
        }
      }
      return;
    }
    catch (BuilderException paramProfileTypeaheadResult)
    {
      getActivity();
      Util.safeThrow$7a8b4789(new RuntimeException("Failed to create EndorsedSkill object: " + paramProfileTypeaheadResult.getMessage()));
    }
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    Object localObject1;
    String str;
    Object localObject2;
    int i;
    if ((getDataProvider().isDataAvailable()) && (getDataProvider().getFeaturedSkillsForEdit() != null) && (getDataProvidergetFeaturedSkillsForEditelements != null))
    {
      localObject1 = getDataProvidergetFeaturedSkillsForEditelements;
      if (skillEndorsementCountMap != null)
      {
        str = null;
        localObject2 = ((List)localObject1).iterator();
        do
        {
          localObject1 = str;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (EndorsedSkill)((Iterator)localObject2).next();
        } while ((!skillEndorsementCountMap.containsKey(skill.name)) || (((Integer)skillEndorsementCountMap.get(skill.name)).intValue() == endorsementCount));
        if (localObject1 != null)
        {
          skillEndorsementCountMap.put(skill.name, Integer.valueOf(endorsementCount));
          i = 0;
          if (i < endorsedSkills.size())
          {
            if (!endorsedSkills.get(i)).skill.name.equals(skill.name)) {
              break label303;
            }
            endorsedSkills.set(i, localObject1);
            adapter.getValues().set(i, EndorsedSkillTransformerV2.toViewModel((EndorsedSkill)localObject1, this, profileViewListener));
            adapter.notifyItemChanged(i);
          }
        }
      }
      updateTitle();
    }
    for (;;)
    {
      swipeDeleteUndoHelper = new SwipeDeleteUndoHelper(2131232568, new ProfileSkillsEditFragmentV2.1(this, busSubscriberId, getProfileId()), tracker, "edit_skills_swipe_delete_undo");
      swipeDeleteUndoHelper.attachToRecyclerView(recyclerView);
      return;
      label303:
      i += 1;
      break;
      adapter.showLoadingView(true);
      if (originalSkills == null)
      {
        originalSkills = new ArrayList();
        endorsedSkills = new ArrayList();
      }
      localObject1 = getDataProvider();
      str = busSubscriberId;
      localObject2 = getRumSessionId();
      Object localObject3 = getProfileId();
      Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
      state).featuredSkillsForEditRoute = ProfileRoutes.buildFeaturedSkillsRouteForEdit((String)localObject3).toString();
      localObject3 = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      ((ProfileDataProvider)localObject1).performMultiplexedFetch(str, (String)localObject2, localMap, ((MultiplexRequest.Builder)localObject3).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.get().url(state).featuredSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))));
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    if ((endorsedSkills != null) && (originalSkills != null))
    {
      if (endorsedSkills.size() != originalSkills.size()) {
        return true;
      }
      int i = 0;
      while (i < endorsedSkills.size())
      {
        if (!endorsedSkills.get(i)).skill.name.equals(originalSkills.get(i)).skill.name)) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    return true;
  }
  
  @OnClick({2131757545})
  void onAddSkill(View paramView)
  {
    sendCustomShortPressTrackingEvent("edit_skills_detailed");
    switchToEditMode();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle != null) {
      editMode = Boolean.valueOf(paramBundle.getBoolean("defaultInEditMode"));
    }
    adapter = new EndlessViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), null);
    initializeFieldsWithDataProvider();
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if ((paramType == DataStore.Type.NETWORK) && (!paramSet.isEmpty()))
    {
      onFormSubmitFailure();
      return;
    }
    super.onDataError(paramType, paramSet, paramDataManagerException);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (getDataProvider().getFeaturedSkillsForEdit() != null)
    {
      paramType = getDataProvidergetFeaturedSkillsForEditelements;
      adapter.showLoadingView(false);
      if ((paramType.isEmpty()) || (!originalSkills.isEmpty()))
      {
        originalSkills.clear();
        endorsedSkills.clear();
      }
      originalSkills.addAll(paramType);
      endorsedSkills.addAll(paramType);
      paramType = adapter;
      Object localObject = endorsedSkills;
      paramSet = profileViewListener;
      paramMap = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        paramMap.add(EndorsedSkillTransformerV2.toViewModel((EndorsedSkill)((Iterator)localObject).next(), this, paramSet));
      }
      paramType.setValues(paramMap);
      skillEndorsementCountMap = new HashMap();
      paramType = originalSkills.iterator();
      while (paramType.hasNext())
      {
        paramSet = (EndorsedSkill)paramType.next();
        skillEndorsementCountMap.put(skill.name, Integer.valueOf(endorsementCount));
      }
      onSkillNumberChanged();
    }
  }
  
  public final void onDeleteClicked(EndorsedSkillViewModelV2 paramEndorsedSkillViewModelV2)
  {
    int i = adapter.getValues().indexOf(paramEndorsedSkillViewModelV2);
    if ((i >= 0) && (i < adapter.getItemCount()))
    {
      paramEndorsedSkillViewModelV2 = (EndorsedSkill)endorsedSkills.remove(i);
      adapter.getValues().remove(i);
      adapter.notifyItemRemoved(i);
      if (paramEndorsedSkillViewModelV2 != null) {
        getDataProvider().deleteFeaturedSkill(busSubscriberId, getRumSessionId(), getProfileId(), paramEndorsedSkillViewModelV2, getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
      }
      setEditSaveMenuItemEnabled(isFormModified());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getDataProvider().isDataAvailable()) && (getProfile() != null)) {
      ((ProfileState)getDataProviderstate).clearModel(ProfileRoutes.buildFeaturedSkillsRouteForEdit(getProfileId()).toString());
    }
    if (swipeDeleteUndoHelper != null) {
      swipeDeleteUndoHelper.dismissUndoBar();
    }
  }
  
  protected final boolean onMenuClick(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    case 2131758753: 
    default: 
      return super.onMenuClick(paramMenuItem);
    case 2131758754: 
      sendCustomShortPressTrackingEvent("edit_skills_detailed");
      switchToEditMode();
      return true;
    }
    sendCustomShortPressTrackingEvent("edit_skills_add");
    sendCustomShortPressTrackingEvent("edit_skills_add");
    startActivityForResult(intentRegistry.search.newIntent(getActivity(), SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.SKILL).setSearchBarHintText(getLocalizedString(2131232572)).setCustomTypeaheadPageKey("profile_self_skill_typeahead").setInputMaxLength$fdadbae().setFakeHitAtTop$6c621e23().setCustomTypeaheadClickTrackingName("edit_skills_add_select").setCustomTypeaheadSearchBarCancelTrackingName("edit_skills_add_cancel").setCustomTrackingName("done")), TYPEAHEAD_PICKER_SKILLrequestId);
    return true;
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("defaultInEditMode", editMode.booleanValue());
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramView = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(paramView);
    recyclerView.setAdapter(adapter);
  }
  
  protected final void optimisticLockingUpdateForm() {}
  
  public final String pageKey()
  {
    return "profile_view_base_skills_details";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    super.setFragmentData(paramBundle);
    if (editMode == null) {
      editMode = Boolean.valueOf(ProfileSkillsEditBundleBuilder.getDefaultInEditMode(getArguments()));
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    if (endorsedSkills != null)
    {
      onFormSubmitSuccess();
      return;
    }
    onFormSubmitFailure();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileSkillsEditFragmentV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */