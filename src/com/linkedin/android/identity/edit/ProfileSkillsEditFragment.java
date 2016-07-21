package com.linkedin.android.identity.edit;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.skills.EndorsedSkillTransformer;
import com.linkedin.android.identity.edit.skills.EndorsedSkillViewModel;
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
import com.linkedin.android.infra.shared.SnackbarUtil;
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

public class ProfileSkillsEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfileSkillsEditFragment.class.getSimpleName();
  private EndlessViewModelAdapter<EndorsedSkillViewModel> adapter;
  @InjectView(2131757541)
  Button addSkillBtn;
  public Boolean editMode;
  private List<EndorsedSkill> endorsedSkills;
  @InjectView(2131757527)
  TextView header;
  @Inject
  IntentRegistry intentRegistry;
  @Inject
  MemberUtil memberUtil;
  private List<EndorsedSkill> originalSkills;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757505)
  public RecyclerView recyclerView;
  private Map<String, Integer> skillEndorsementCountMap;
  public SwipeDeleteUndoHelper swipeDeleteUndoHelper;
  
  public static ProfileSkillsEditFragment newInstance(ProfileSkillsEditBundleBuilder paramProfileSkillsEditBundleBuilder)
  {
    ProfileSkillsEditFragment localProfileSkillsEditFragment = new ProfileSkillsEditFragment();
    localProfileSkillsEditFragment.setArguments(paramProfileSkillsEditBundleBuilder.build());
    return localProfileSkillsEditFragment;
  }
  
  private void onSkillNumberChanged()
  {
    updateTitle();
    Button localButton = addSkillBtn;
    if (endorsedSkills.size() < 50) {}
    for (boolean bool = true;; bool = false)
    {
      localButton.setEnabled(bool);
      return;
    }
  }
  
  private void startSkillTypeahead()
  {
    sendCustomShortPressTrackingEvent("edit_skills_add");
    startActivityForResult(intentRegistry.search.newIntent(getActivity(), SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.SKILL).setSearchBarHintText(getLocalizedString(2131232572)).setCustomTypeaheadPageKey("profile_self_skill_typeahead").setInputMaxLength$fdadbae().setFakeHitAtTop$6c621e23().setCustomTypeaheadClickTrackingName("edit_skills_add_select").setCustomTypeaheadSearchBarCancelTrackingName("edit_skills_add_cancel").setCustomTrackingName("done")), TYPEAHEAD_PICKER_SKILLrequestId);
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
  
  private void switchToViewMode$1385ff()
  {
    if (!editMode.booleanValue()) {
      Log.e(TAG, "error switching to non-edit mode: already in non-edit mode");
    }
    if (swipeDeleteUndoHelper != null) {
      swipeDeleteUndoHelper.dismissUndoBar();
    }
    editMode = Boolean.valueOf(false);
    createMenu();
    endorsedSkills.clear();
    endorsedSkills.addAll(originalSkills);
    adapter.setValues(EndorsedSkillTransformer.toViewModelList(endorsedSkills, this, profileViewListener));
  }
  
  private void updateTitle()
  {
    TextView localTextView;
    if ((endorsedSkills != null) && (header != null))
    {
      localTextView = header;
      if (50 > endorsedSkills.size()) {
        break label62;
      }
    }
    label62:
    for (String str = i18NManager.getString(2131232571, new Object[] { Integer.valueOf(50) });; str = i18NManager.getString(2131232570, new Object[] { Integer.valueOf(50 - endorsedSkills.size()) }))
    {
      localTextView.setText(str);
      return;
    }
  }
  
  protected final void createMenu()
  {
    super.createMenu();
    toolbar.inflateMenu(2131820555);
    Object localObject = toolbar.getMenu();
    MenuItem localMenuItem = ((Menu)localObject).findItem(2131758754);
    if (!editMode.booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      ((Menu)localObject).findItem(2131758751).setVisible(editMode.booleanValue());
      ((Menu)localObject).findItem(2131758752).setVisible(false);
      ((Menu)localObject).findItem(2131758753).setVisible(false);
      localObject = toolbar.getMenu().findItem(2131758752);
      if ((getActivity() == null) || (getActivity().isFinishing())) {
        break;
      }
      ((MenuItem)localObject).setIcon(DrawableHelper.setTint(((MenuItem)localObject).getIcon(), ContextCompat.getColor(getActivity(), 2131624058)));
      return;
    }
    ((MenuItem)localObject).setIcon(((MenuItem)localObject).getIcon());
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
    return 2131757540;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969187;
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
    if ((endorsedSkills != null) && (typeahead == ProfileTypeahead.TYPEAHEAD_PICKER_SKILL))
    {
      int j = 0;
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
          if ((urn != null) || (text != null))
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
            String str3 = memberUtil.getProfileId();
            String str4 = getDataProvider().getProfileVersionTag();
            Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
            str4 = ProfileRoutes.buildAddEntityRoute("normSkills", str3, str4).toString();
            state).endorsedSkillsForEditRoute = ProfileRoutes.buildEndorsedSkillsRouteForEdit(str3).toString();
            ((ProfileDataProvider)localObject2).performMultiplexedFetch(str1, str2, localMap, ((ProfileDataProvider)localObject2).getPostRequestBuilder(str4, str3, (RecordTemplate)localObject1, Request.get().url(state).endorsedSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER)), true));
            fragmentComponent.eventBus();
            Bus.publishStickyEvent(new ProfileSkillsAddedEvent());
            recyclerView.postDelayed(new ProfileSkillsEditFragment.3(this, paramProfileTypeaheadResult), 500L);
          }
          if (!editMode.booleanValue()) {
            switchToEditMode();
          }
        }
        else
        {
          fragmentComponent.snackbarUtil();
          SnackbarUtil.show(SnackbarUtil.make(recyclerView, 2131233759, 0), tracker);
          return;
        }
      }
      catch (BuilderException paramProfileTypeaheadResult)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to create EndorsedSkill object: " + paramProfileTypeaheadResult.getMessage()));
      }
    }
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    Object localObject1;
    String str;
    Object localObject2;
    int i;
    if ((getDataProvider().isDataAvailable()) && (getDataProvider().getEndorsedSkillsForEdit() != null) && (getDataProvidergetEndorsedSkillsForEditelements != null))
    {
      localObject1 = getDataProvidergetEndorsedSkillsForEditelements;
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
            adapter.getValues().set(i, EndorsedSkillTransformer.toViewModel((EndorsedSkill)localObject1, this, profileViewListener));
            adapter.notifyItemChanged(i);
          }
        }
      }
      updateTitle();
    }
    for (;;)
    {
      swipeDeleteUndoHelper = new SwipeDeleteUndoHelper(2131232568, new ProfileSkillsEditFragment.2(this, busSubscriberId, getProfileId()), tracker, "edit_skills_swipe_delete_undo");
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
      state).endorsedSkillsForEditRoute = ProfileRoutes.buildEndorsedSkillsRouteForEdit((String)localObject3).toString();
      localObject3 = MultiplexRequest.Builder.parallel();
      multiplexerUrl = Routes.MUX.buildUponRoot().toString();
      ((ProfileDataProvider)localObject1).performMultiplexedFetch(str, (String)localObject2, localMap, ((MultiplexRequest.Builder)localObject3).filter(DataManager.DataStoreFilter.NETWORK_ONLY).required(Request.get().url(state).endorsedSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))));
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
  
  @OnClick({2131757541})
  void onAddSkill(View paramView)
  {
    startSkillTypeahead();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    if (paramBundle != null)
    {
      editMode = Boolean.valueOf(paramBundle.getBoolean("defaultInEditMode"));
      adapter = new EndlessViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), null);
    }
    while (adapter != null) {
      return;
    }
    adapter = new EndlessViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), null);
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
    if (getDataProvider().getEndorsedSkillsForEdit() != null)
    {
      paramType = getDataProvidergetEndorsedSkillsForEditelements;
      adapter.showLoadingView(false);
      if ((paramType.isEmpty()) || (!originalSkills.isEmpty()))
      {
        originalSkills.clear();
        endorsedSkills.clear();
      }
      originalSkills.addAll(paramType);
      endorsedSkills.addAll(paramType);
      adapter.setValues(EndorsedSkillTransformer.toViewModelList(endorsedSkills, this, profileViewListener));
      skillEndorsementCountMap = new HashMap();
      paramType = originalSkills.iterator();
      while (paramType.hasNext())
      {
        paramSet = (EndorsedSkill)paramType.next();
        skillEndorsementCountMap.put(skill.name, Integer.valueOf(endorsementCount));
      }
      onSkillNumberChanged();
    }
    while (!dataResponseHandler.handleOnDataReady(paramType, paramSet, paramMap)) {
      return;
    }
  }
  
  public final void onDeleteClicked(EndorsedSkillViewModel paramEndorsedSkillViewModel)
  {
    int i = adapter.getValues().indexOf(paramEndorsedSkillViewModel);
    if ((i >= 0) && (i < adapter.getItemCount()))
    {
      paramEndorsedSkillViewModel = (EndorsedSkill)endorsedSkills.remove(i);
      adapter.getValues().remove(i);
      adapter.notifyItemRemoved(i);
      if (paramEndorsedSkillViewModel != null) {
        getDataProvider().deleteEndorsedSkill(busSubscriberId, getRumSessionId(), getProfileId(), paramEndorsedSkillViewModel, getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
      }
      setEditSaveMenuItemEnabled(isFormModified());
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if ((getDataProvider().isDataAvailable()) && (getProfile() != null)) {
      ((ProfileState)getDataProviderstate).clearModel(ProfileRoutes.buildEndorsedSkillsRouteForEdit(getProfileId()).toString());
    }
    if (swipeDeleteUndoHelper != null) {
      swipeDeleteUndoHelper.dismissUndoBar();
    }
  }
  
  protected final boolean onMenuClick(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default: 
      return super.onMenuClick(paramMenuItem);
    case 2131758754: 
      sendCustomShortPressTrackingEvent("edit_skills_detailed");
      switchToEditMode();
      return true;
    case 2131758753: 
      sendCustomShortPressTrackingEvent("edit_skills_cancel_detail");
      if (isFormModified())
      {
        new AlertDialog.Builder(getActivity()).setMessage(2131232726).setPositiveButton(2131232724, null).setNegativeButton(2131232725, new ProfileSkillsEditFragment.1(this)).setIcon$38a3bc68().show();
        return true;
      }
      switchToViewMode$1385ff();
      return true;
    }
    sendCustomShortPressTrackingEvent("edit_skills_add");
    startSkillTypeahead();
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
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileSkillsEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */