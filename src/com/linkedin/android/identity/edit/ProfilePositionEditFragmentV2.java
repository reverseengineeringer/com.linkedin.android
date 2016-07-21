package com.linkedin.android.identity.edit;

import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.editComponents.DatesViewModel;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer.7;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer.8;
import com.linkedin.android.identity.edit.editComponents.MultilineFieldViewModel;
import com.linkedin.android.identity.edit.editComponents.TypeaheadFieldViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.DateRangePresenter.Builder;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.DateRange;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPosition.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PositionCompany.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfilePositionEditFragmentV2
  extends ProfileEditTreasuryBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfilePositionEditFragmentV2.class.getSimpleName();
  private TypeaheadFieldViewModel companyViewModel;
  @Inject
  FlagshipDataManager dataManager;
  private DatesViewModel datesViewModel;
  private MultilineFieldViewModel descriptionViewModel;
  @Inject
  Bus eventBus;
  @Inject
  IntentRegistry intentRegistry;
  private TypeaheadFieldViewModel locationViewModel;
  private NormPosition originalPosition;
  private Position position;
  @Inject
  ProfileUtil profileUtil;
  private boolean resetDataAfterSave;
  private Position tempPosition;
  private TypeaheadFieldViewModel titleViewModel;
  
  private NormPosition getCurrentPosition()
    throws BuilderException
  {
    Position.Builder localBuilder = new Position.Builder();
    populateFields(localBuilder);
    return normalizePosition(localBuilder.build(RecordTemplate.Flavor.RECORD));
  }
  
  private static NormPosition getOriginalPosition(Position paramPosition)
    throws BuilderException
  {
    if (paramPosition != null) {
      paramPosition = new Position.Builder(paramPosition);
    }
    for (;;)
    {
      return normalizePosition(paramPosition.build(RecordTemplate.Flavor.RECORD));
      paramPosition = new Position.Builder();
      paramPosition.setEntityUrn(ProfileUtil.getDummyMockUrn());
    }
  }
  
  public static ProfilePositionEditFragmentV2 newInstance(ProfilePositionEditBundleBuilder paramProfilePositionEditBundleBuilder)
  {
    ProfilePositionEditFragmentV2 localProfilePositionEditFragmentV2 = new ProfilePositionEditFragmentV2();
    localProfilePositionEditFragmentV2.setArguments(paramProfilePositionEditBundleBuilder.build());
    return localProfilePositionEditFragmentV2;
  }
  
  private static NormPosition normalizePosition(Position paramPosition)
    throws BuilderException
  {
    return new NormPosition.Builder().setEntityUrn(entityUrn).setTitle(title).setDescription(description).setTimePeriod(timePeriod).setRegion(region).setLocationName(locationName).setCompanyUrn(companyUrn).setCompanyName(companyName).setCompanyUrn(companyUrn).build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(Position.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject;
    MiniCompany localMiniCompany;
    if (position == null)
    {
      localObject = ProfileUtil.getMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject);
      localObject = null;
      if (companyViewModel.miniCompany != null)
      {
        localObject = new PositionCompany.Builder();
        localMiniCompany = companyViewModel.miniCompany;
        if (localMiniCompany != null) {
          break label247;
        }
        hasMiniCompany = false;
        miniCompany = null;
        label59:
        localObject = ((PositionCompany.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      }
      if (localObject != null) {
        break label260;
      }
      hasCompany = false;
      company = null;
      label81:
      localObject = companyViewModel.getText();
      if (localObject != null) {
        break label273;
      }
      hasCompanyName = false;
      companyName = null;
      label103:
      localObject = companyViewModel.urn;
      if (localObject != null) {
        break label286;
      }
      hasCompanyUrn = false;
      companyUrn = null;
      label125:
      localObject = titleViewModel.getText();
      if (localObject != null) {
        break label299;
      }
      hasTitle = false;
      title = null;
      label147:
      localObject = locationViewModel.getText();
      if (localObject != null) {
        break label312;
      }
      hasLocationName = false;
      locationName = null;
      label169:
      localObject = locationViewModel.urn;
      if (localObject != null) {
        break label325;
      }
      hasRegion = false;
      region = null;
      label191:
      localObject = datesViewModel.getDateRange();
      if (localObject != null) {
        break label338;
      }
      hasTimePeriod = false;
    }
    for (timePeriod = null;; timePeriod = ((DateRange)localObject))
    {
      localObject = descriptionViewModel.getText();
      if (localObject != null) {
        break label351;
      }
      hasDescription = false;
      description = null;
      return;
      localObject = position.entityUrn;
      break;
      label247:
      hasMiniCompany = true;
      miniCompany = localMiniCompany;
      break label59;
      label260:
      hasCompany = true;
      company = ((PositionCompany)localObject);
      break label81;
      label273:
      hasCompanyName = true;
      companyName = ((String)localObject);
      break label103;
      label286:
      hasCompanyUrn = true;
      companyUrn = ((Urn)localObject);
      break label125;
      label299:
      hasTitle = true;
      title = ((String)localObject);
      break label147;
      label312:
      hasLocationName = true;
      locationName = ((String)localObject);
      break label169;
      label325:
      hasRegion = true;
      region = ((Urn)localObject);
      break label191;
      label338:
      hasTimePeriod = true;
    }
    label351:
    hasDescription = true;
    description = ((String)localObject);
  }
  
  public final void doPause()
  {
    super.doPause();
    try
    {
      Position.Builder localBuilder = new Position.Builder();
      populateFields(localBuilder);
      getDataProviderstate).modifiedPosition = localBuilder.build(RecordTemplate.Flavor.RECORD);
      return;
    }
    catch (BuilderException localBuilderException)
    {
      getContext();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to build a correct Education model"));
    }
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232509;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (position == null) {
        i = 2131232235;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232505;
      continue;
      i = 2131232663;
    }
  }
  
  protected final List<ViewModel> getViewModels()
  {
    boolean bool2 = true;
    Object localObject4 = null;
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = tempPosition;
    Object localObject2 = fragmentComponent;
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = null;
      titleViewModel = EditComponentTransformer.toTypeaheadFieldViewModel((String)localObject1, null, null, null, TypeaheadType.TITLE, (FragmentComponent)localObject2);
      localObject3 = tempPosition;
      FragmentComponent localFragmentComponent = fragmentComponent;
      if (localObject3 != null) {
        break label599;
      }
      localObject1 = null;
      label66:
      if (localObject3 != null) {
        break label608;
      }
      localObject2 = null;
      label74:
      if ((localObject3 == null) || (!hasCompany)) {
        break label618;
      }
      localObject3 = company.miniCompany;
      label97:
      companyViewModel = EditComponentTransformer.toTypeaheadFieldViewModel((String)localObject1, (Urn)localObject2, null, (MiniCompany)localObject3, TypeaheadType.COMPANY, localFragmentComponent);
      localObject2 = tempPosition;
      localObject3 = fragmentComponent;
      if (localObject2 != null) {
        break label624;
      }
      localObject1 = null;
      label134:
      if (localObject2 != null) {
        break label633;
      }
      localObject2 = null;
      label142:
      locationViewModel = EditComponentTransformer.toTypeaheadFieldViewModel((String)localObject1, (Urn)localObject2, null, null, TypeaheadType.GEO, (FragmentComponent)localObject3);
      localObject1 = tempPosition;
      localObject2 = fragmentComponent;
      if (localObject1 != null) {
        break label643;
      }
      localObject1 = null;
      label176:
      descriptionViewModel = EditComponentTransformer.toMultilineFieldViewModel$166cb2ec((String)localObject1, 2000, ((FragmentComponent)localObject2).i18NManager().getString(2131232510), (FragmentComponent)localObject2);
      localObject1 = tempPosition;
      localObject2 = fragmentComponent;
      if (localObject1 != null) {
        break label651;
      }
      localObject1 = localObject4;
      label220:
      localObject3 = new DatesViewModel();
      i18NManager = ((FragmentComponent)localObject2).i18NManager();
      supportToPresent = true;
      showMonth = true;
      startDateHint = ((FragmentComponent)localObject2).i18NManager().getString(2131232516);
      endDateHint = ((FragmentComponent)localObject2).i18NManager().getString(2131232511);
      if (localObject1 != null)
      {
        startDate = startDate;
        if (hasEndDate) {
          endDate = endDate;
        }
        if (hasEndDate) {
          break label659;
        }
        bool1 = true;
        label327:
        currentlyWorks = bool1;
      }
      onFieldEdited = new EditComponentTransformer.7((FragmentComponent)localObject2);
      currentWorkChecked = new EditComponentTransformer.8(((FragmentComponent)localObject2).tracker(), "edit_position_date_toggle");
      localObject1 = new DateRangePresenter.Builder();
      fieldName = "positionDates";
      startDateTrackingControlName = "edit_position_start_date";
      endDateTrackingControlName = "edit_position_end_date";
      activity = ((FragmentComponent)localObject2).activity();
      localObject1 = ((DateRangePresenter.Builder)localObject1).showMonth(Boolean.valueOf(true)).selectStartYear$721a06ed();
      selectEndFutureYear = 0;
      dateRangePresenterBuilder = ((DateRangePresenter.Builder)localObject1).allowEmptyYear(Boolean.valueOf(true)).allowEmptyMonth(Boolean.valueOf(true));
      localBroadcastManager = LocalBroadcastManager.getInstance(((FragmentComponent)localObject2).activity());
      datesViewModel = ((DatesViewModel)localObject3);
      localArrayList.addAll(Arrays.asList(new ViewModel[] { titleViewModel, companyViewModel, locationViewModel, datesViewModel, descriptionViewModel }));
      if ((position != null) && ("enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_POSITION_TREASURY)))) {
        localArrayList.addAll(getTreasuryViewModels());
      }
      if (position != null) {
        break label664;
      }
    }
    label599:
    label608:
    label618:
    label624:
    label633:
    label643:
    label651:
    label659:
    label664:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localArrayList.add(EditComponentTransformer.toDeleteButtonViewModel(bool1, 2, fragmentComponent));
      return localArrayList;
      localObject1 = title;
      break;
      localObject1 = companyName;
      break label66;
      localObject2 = companyUrn;
      break label74;
      localObject3 = null;
      break label97;
      localObject1 = locationName;
      break label134;
      localObject2 = region;
      break label142;
      localObject1 = description;
      break label176;
      localObject1 = timePeriod;
      break label220;
      bool1 = false;
      break label327;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    switch (ProfilePositionEditFragmentV2.2.$SwitchMap$com$linkedin$android$identity$shared$ProfileTypeahead[typeahead.ordinal()])
    {
    }
    for (;;)
    {
      setEditSaveMenuItemEnabled(isFormModified());
      return;
      companyViewModel.applyTypeaheadResult(paramProfileTypeaheadResult);
      continue;
      titleViewModel.applyTypeaheadResult(paramProfileTypeaheadResult);
      continue;
      locationViewModel.applyTypeaheadResult(paramProfileTypeaheadResult);
    }
  }
  
  protected final void initializeFields() {}
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      boolean bool;
      if (getCurrentPosition().equals(originalPosition)) {
        bool = super.isFormModified();
      }
      return bool;
    }
    catch (BuilderException localBuilderException)
    {
      Log.d(TAG, "Failed to populate fields: " + localBuilderException.getMessage());
      goBackToPreviousFragment();
    }
    return true;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    boolean bool1 = titleViewModel.isValid$495862a3(2131232515);
    boolean bool2 = companyViewModel.isValid$495862a3(2131232514);
    boolean bool3 = datesViewModel.isValid$3a567496(true, false, false);
    boolean bool4 = descriptionViewModel.isValid$25dace8(2000);
    if (!bool1) {
      recyclerView.scrollToPosition(arrayAdapter.getIndex(titleViewModel));
    }
    while ((bool2) && (bool1) && (bool3) && (bool4))
    {
      return true;
      if (!bool2) {
        recyclerView.scrollToPosition(arrayAdapter.getIndex(companyViewModel));
      } else if (!bool3) {
        recyclerView.scrollToPosition(arrayAdapter.getIndex(datesViewModel));
      } else if (!bool4) {
        recyclerView.scrollToPosition(arrayAdapter.getIndex(descriptionViewModel));
      }
    }
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
    if (paramBundle != null)
    {
      tempPosition = ProfilePositionEditBundleBuilder.getPosition(paramBundle);
      return;
    }
    getDataProviderstate).modifiedPosition = null;
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if (resetDataAfterSave) {
      getDataProvider().clearProfile(busSubscriberId);
    }
    super.onDataReady(paramType, paramSet, paramMap);
  }
  
  public void onDestroy()
  {
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(ProfileEditEvent paramProfileEditEvent)
  {
    switch (type)
    {
    default: 
      return;
    case 0: 
      setEditSaveMenuItemEnabled(isFormModified());
      return;
    }
    showConfirmDeleteDialog(2131232275, new ProfilePositionEditFragmentV2.1(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    try
    {
      Position.Builder localBuilder = new Position.Builder();
      populateFields(localBuilder);
      ProfilePositionEditBundleBuilder.wrap(paramBundle).setPosition(localBuilder.build(RecordTemplate.Flavor.RECORD));
      return;
    }
    catch (BuilderException paramBundle)
    {
      getContext();
      Util.safeThrow$7a8b4789(new IllegalArgumentException("Failed to build a correct Position model"));
    }
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getPositions();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null) {
        localObject = ((List)localObject).iterator();
      }
    }
    for (;;)
    {
      Position localPosition;
      if (((Iterator)localObject).hasNext())
      {
        localPosition = (Position)((Iterator)localObject).next();
        if ((position == null) || (!position.entityUrn.equals(entityUrn))) {}
      }
      else
      {
        try
        {
          originalPosition = getOriginalPosition(localPosition);
          position = localPosition;
          arrayAdapter.setValues(getViewModels());
          return;
        }
        catch (BuilderException localBuilderException)
        {
          Log.d(TAG, "Failed to build original position: " + localBuilderException.getMessage());
          goBackToPreviousFragment();
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (position == null) {
      return "profile_self_add_position";
    }
    return "profile_self_edit_position";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    Bundle localBundle = getArguments();
    position = ProfilePositionEditBundleBuilder.getPosition(localBundle);
    resetDataAfterSave = ProfilePositionEditBundleBuilder.getResetDataAfterSave(localBundle);
    originalPosition = getOriginalPosition(position);
    if (getDataProviderstate).modifiedPosition != null) {
      tempPosition = getDataProviderstate).modifiedPosition;
    }
    for (;;)
    {
      super.setFragmentData(paramBundle);
      return;
      if (tempPosition == null) {
        tempPosition = position;
      }
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Object localObject1 = getCurrentPosition();
    label442:
    JsonModel localJsonModel;
    if (position != null)
    {
      Object localObject2;
      HashMap localHashMap;
      Object localObject3;
      Object localObject4;
      for (;;)
      {
        try
        {
          localObject2 = PegasusPatchGenerator.INSTANCE.diff(position, (RecordTemplate)localObject1);
          if (((JSONObject)localObject2).length() > 0) {
            setDidUpdate$1385ff();
          }
          if (!"enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_POSITION_TREASURY))) {
            break label442;
          }
          localObject1 = position.entityUrn;
          localHashMap = new HashMap();
          localIterator = tempTreasuryMedias.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = (TreasuryMedia)localIterator.next();
          localObject4 = entityUrn.getLastId();
          if (((String)localObject4).equals("-1")) {
            addedTreasuryMedias.add(localObject3);
          } else {
            localHashMap.put(localObject4, localObject3);
          }
        }
        catch (JSONException localJSONException1)
        {
          Log.d(TAG, "Failed to generate diff for update: " + localJSONException1.getMessage());
          return;
        }
      }
      Iterator localIterator = treasuryMedias.iterator();
      while (localIterator.hasNext())
      {
        localObject4 = (TreasuryMedia)localIterator.next();
        localObject3 = entityUrn.getLastId();
        if (!localHashMap.containsKey(localObject3)) {
          deletedTreasuryMedias.add(localObject4);
        } else {
          try
          {
            localObject4 = PegasusPatchGenerator.INSTANCE.diff((RecordTemplate)localObject4, (RecordTemplate)localHashMap.get(localObject3));
            if (((JSONObject)localObject4).length() > 0) {
              updatedTreasuryMedias.put(localObject3, new JsonModel((JSONObject)localObject4));
            }
          }
          catch (JSONException localJSONException2)
          {
            getContext();
            Util.safeThrow$7a8b4789(new RuntimeException(localJSONException2.getMessage()));
          }
        }
      }
      if ((((JSONObject)localObject2).length() > 0) || (addedTreasuryMedias.size() > 0) || (updatedTreasuryMedias.size() > 0) || (deletedTreasuryMedias.size() > 0))
      {
        localObject2 = new JsonModel((JSONObject)localObject2);
        getDataProvider().postUpdateWithTreasuries(busSubscriberId, getRumSessionId(), getProfileId(), (JsonModel)localObject2, addedTreasuryMedias, updatedTreasuryMedias, deletedTreasuryMedias, localJSONException1, getDataProvider().getProfileVersionTag(), 2, Tracker.createPageInstanceHeader(getPageInstance()));
        return;
      }
      goBackToPreviousFragment();
      return;
      if (((JSONObject)localObject2).length() > 0)
      {
        localJsonModel = new JsonModel((JSONObject)localObject2);
        getDataProvider().postUpdatePosition(busSubscriberId, getRumSessionId(), getProfileId(), localJsonModel, position.entityUrn.getLastId(), getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
        return;
      }
      goBackToPreviousFragment();
      return;
    }
    setDidCreate$1385ff();
    getDataProvider().postAddPosition(busSubscriberId, getRumSessionId(), getProfileId(), localJsonModel, getDataProvider().getProfileVersionTag(), Tracker.createPageInstanceHeader(getPageInstance()));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfilePositionEditFragmentV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */