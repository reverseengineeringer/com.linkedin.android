package com.linkedin.android.identity.edit;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.MultiplexRequest.Builder;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.endorsements.EndorsementTransformer;
import com.linkedin.android.identity.edit.endorsements.EndorsementViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementStatusType;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsementsCollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Skill;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileEndorsementsEditFragment
  extends ProfileEditBaseFragment
{
  private static final String TAG = ProfileEndorsementsEditFragment.class.getSimpleName();
  private EndlessViewModelAdapter<EndorsementViewModel> adapter;
  private int endorsementCount;
  private boolean endorsementLoading;
  private List<EndorsementStatusType> endorsementStatusTypes;
  @Inject
  IntentRegistry intentRegistry;
  @Inject
  MemberUtil memberUtil;
  private boolean noMoreEndorsements;
  private List<Endorsement> originalEndorsements;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757505)
  RecyclerView recyclerView;
  private String skillName;
  
  private boolean isEndorsementModified(int paramInt)
  {
    return (paramInt >= 0) && (paramInt < originalEndorsements.size()) && (endorsementStatusTypes.get(paramInt) != originalEndorsements.get(paramInt)).status);
  }
  
  public static ProfileEndorsementsEditFragment newInstance(ProfileEndorsementsEditBundleBuilder paramProfileEndorsementsEditBundleBuilder)
  {
    ProfileEndorsementsEditFragment localProfileEndorsementsEditFragment = new ProfileEndorsementsEditFragment();
    localProfileEndorsementsEditFragment.setArguments(paramProfileEndorsementsEditBundleBuilder.build());
    return localProfileEndorsementsEditFragment;
  }
  
  private void onLoadFinished(List<Endorsement> paramList, CollectionMetadata paramCollectionMetadata)
  {
    endorsementLoading = false;
    adapter.showLoadingView(false);
    Object localObject1 = new ArrayList();
    Object localObject2 = paramList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Endorsement localEndorsement = (Endorsement)((Iterator)localObject2).next();
      if (status == EndorsementStatusType.$UNKNOWN) {
        ((List)localObject1).add(localEndorsement);
      }
    }
    paramList.removeAll((Collection)localObject1);
    originalEndorsements.addAll(paramList);
    localObject1 = paramList.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Endorsement)((Iterator)localObject1).next();
      endorsementStatusTypes.add(status);
    }
    localObject1 = EndorsementTransformer.toViewModelList(paramList, this, profileUtil);
    if (originalEndorsements.size() == paramList.size()) {
      adapter.setValues((List)localObject1);
    }
    for (;;)
    {
      if (paramCollectionMetadata != null) {
        noMoreEndorsements = true;
      }
      return;
      adapter.appendValues((List)localObject1);
    }
  }
  
  public final String getCancelTrackingControlName()
  {
    return "edit_endorsements_back";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969191;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131233272;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "edit_endorsements_save";
  }
  
  public final String getTitle()
  {
    return i18NManager.getString(2131232403, new Object[] { skillName, Integer.valueOf(endorsementCount) });
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    if (ProfileEndorsementsEditBundleBuilder.getEndorsedSkill(getArguments()) != null)
    {
      noMoreEndorsements = false;
      endorsementLoading = true;
      adapter.showLoadingView(true);
      if (originalEndorsements == null)
      {
        originalEndorsements = new ArrayList();
        endorsementStatusTypes = new ArrayList();
      }
      for (;;)
      {
        getDataProvider().fetchMoreEndorsements$1adbc258(busSubscriberId, getRumSessionId(), getProfileId(), skillName, Tracker.createPageInstanceHeader(getPageInstance()), 0);
        return;
        originalEndorsements.clear();
        endorsementStatusTypes.clear();
      }
    }
    new AlertDialog.Builder(getActivity()).setTitle(2131232621).setPositiveButton(2131232620, new ProfileEndorsementsEditFragment.2(this)).setCancelable(false).show();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    if (originalEndorsements != null)
    {
      int i = 0;
      while (i < originalEndorsements.size())
      {
        if (isEndorsementModified(i)) {
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
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((endorsementLoading) && (getDataProvider().getSkillEndorsements() != null))
    {
      paramSet = getDataProvider().getSkillEndorsements();
      if (elements != null)
      {
        paramType = new ArrayList(elements);
        onLoadFinished(paramType, paging);
      }
    }
    do
    {
      return;
      paramType = new ArrayList();
      break;
      if (getDataProvider().getEndorsedSkillsForEdit() != null)
      {
        onFormSubmitSuccess();
        return;
      }
    } while (!dataResponseHandler.handleOnDataReady(paramType, paramSet, paramMap));
  }
  
  public final void onEndorsementToggle(EndorsementViewModel paramEndorsementViewModel)
  {
    int i = adapter.getValues().indexOf(paramEndorsementViewModel);
    EndorsementStatusType localEndorsementStatusType;
    if ((i >= 0) && (i < adapter.getItemCount()))
    {
      paramEndorsementViewModel = (EndorsementStatusType)endorsementStatusTypes.get(i);
      localEndorsementStatusType = originalEndorsements.get(i)).status;
      if (paramEndorsementViewModel != localEndorsementStatusType) {
        break label112;
      }
      if (EndorsementStatusType.ACCEPTED != paramEndorsementViewModel) {
        break label105;
      }
      paramEndorsementViewModel = EndorsementStatusType.HIDDEN;
      endorsementStatusTypes.set(i, paramEndorsementViewModel);
    }
    for (;;)
    {
      adapter.notifyItemChanged(i);
      setEditSaveMenuItemEnabled(isFormModified());
      return;
      label105:
      paramEndorsementViewModel = EndorsementStatusType.ACCEPTED;
      break;
      label112:
      endorsementStatusTypes.set(i, localEndorsementStatusType);
    }
  }
  
  protected final void optimisticLockingUpdateForm() {}
  
  public final String pageKey()
  {
    return "profile_self_edit_endorsements";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    super.setFragmentData(paramBundle);
    paramBundle = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(paramBundle);
    paramBundle = ProfileEndorsementsEditBundleBuilder.getEndorsedSkill(getArguments());
    if (paramBundle != null)
    {
      skillName = skill.name;
      endorsementCount = endorsementCount;
      adapter = new EndlessViewModelAdapter(getActivity(), applicationComponent.mediaCenter(), null);
      recyclerView.clearOnScrollListeners();
      recyclerView.addOnScrollListener(new ProfileEndorsementsEditFragment.1(this));
      recyclerView.setAdapter(adapter);
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    if (isFormModified()) {}
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new ArrayList();
        i = 0;
        if (i < originalEndorsements.size())
        {
          if (!isEndorsementModified(i)) {
            break label392;
          }
          ((List)localObject1).add(originalEndorsements.get(i)).entityUrn.getLastId());
          break label392;
        }
        Object localObject2 = new JSONObject();
        i = 0;
        if (i < originalEndorsements.size())
        {
          if (!isEndorsementModified(i)) {
            break label399;
          }
          localObject3 = (Endorsement)originalEndorsements.get(i);
          localObject4 = new Endorsement.Builder((Endorsement)originalEndorsements.get(i)).setStatus((EndorsementStatusType)endorsementStatusTypes.get(i)).build(RecordTemplate.Flavor.RECORD);
          localObject4 = PegasusPatchGenerator.INSTANCE.diff((RecordTemplate)localObject3, (RecordTemplate)localObject4);
          ((JSONObject)localObject2).put(entityUrn.getLastId(), localObject4);
          break label399;
        }
        Object localObject5 = new JSONObject();
        ((JSONObject)localObject5).put("entities", localObject2);
        localObject2 = getDataProvider();
        Object localObject3 = busSubscriberId;
        Object localObject4 = getRumSessionId();
        String str = getProfileId();
        localObject5 = new JsonModel((JSONObject)localObject5);
        Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
        state).endorsedSkillsForEditRoute = ProfileRoutes.buildEndorsedSkillsRouteForEdit(str).toString();
        ((ProfileState)state).clearModel(state).endorsedSkillsForEditRoute);
        localObject1 = ProfileRoutes.buildEditEndorsementsRoute(str, (List)localObject1);
        ((ProfileDataProvider)localObject2).performMultiplexedFetch((String)localObject3, (String)localObject4, localMap, ProfileDataProvider.newUpdateRequestBuilder().required(Request.post().url((String)localObject1).model((RecordTemplate)localObject5)).optional(Request.get().url(state).endorsedSkillsForEditRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(EndorsedSkill.BUILDER, EndorsementsCollectionMetadata.BUILDER))));
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.d(TAG, "Failed to generate diff for update: " + localJSONException.getMessage());
        return;
      }
      onFormSubmitFailure();
      return;
      label392:
      i += 1;
      continue;
      label399:
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileEndorsementsEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */