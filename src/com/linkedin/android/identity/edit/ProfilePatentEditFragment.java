package com.linkedin.android.identity.edit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.identity.edit.patent.PatentTransformer.1;
import com.linkedin.android.identity.edit.patent.PatentTransformer.2;
import com.linkedin.android.identity.edit.patent.PatentViewHolder;
import com.linkedin.android.identity.edit.patent.PatentViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.CustomArrayAdapter;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUrnUtil;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.PatentValidator;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate.CollectionTemplateJsonParser;
import com.linkedin.android.pegasus.gen.common.Date;
import com.linkedin.android.pegasus.gen.common.Date.Builder;
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.Country;
import com.linkedin.android.pegasus.gen.voyager.common.Country.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormContributor.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPatent.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Patent;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnItemSelectedListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfilePatentEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfilePatentEditFragment.class.getSimpleName();
  private int dateDayOfMonth;
  @InjectView(2131757691)
  TextInputLayout dateEditLayout;
  private int dateMonth = -1;
  private int dateYear;
  @InjectView(2131757699)
  Button deleteLink;
  @InjectView(2131757695)
  TextInputLayout descriptionEditLayout;
  @InjectView(2131757676)
  LinearLayout formLayout;
  @InjectView(2131757675)
  ScrollView formScrollView;
  @Inject
  IntentRegistry intentRegistry;
  @InjectView(2131757681)
  TextInputLayout numberEditLayout;
  @InjectView(2131757680)
  TextView officeErrorTextView;
  private NormPatent originalPatent;
  private Patent patent;
  private ArrayList<ProfileEditContributor> patentInventors;
  @Inject
  ProfileUtil profileUtil;
  private final BroadcastReceiver receiver = new ProfilePatentEditFragment.1(this);
  @InjectView(2131757677)
  TextInputLayout titleEditLayout;
  @InjectView(2131757693)
  TextInputLayout urlEditLayout;
  private PatentValidator validator;
  private PatentViewHolder viewHolder;
  private PatentViewModel viewModel;
  
  private List<Country> countriesWithEurope(List<Country> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Country.Builder localBuilder = new Country.Builder();
      localBuilder.setCountryCode("eu");
      localBuilder.setCountryName(i18NManager.getString(2131232493));
      localArrayList.add(localBuilder.build(RecordTemplate.Flavor.RECORD));
      if (paramList != null) {
        localArrayList.addAll(paramList);
      }
      return localArrayList;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Log.d("Failed to build country for EU: " + localBuilderException.getMessage());
      }
    }
  }
  
  public static ProfilePatentEditFragment newInstance(ProfilePatentEditBundleBuilder paramProfilePatentEditBundleBuilder)
  {
    ProfilePatentEditFragment localProfilePatentEditFragment = new ProfilePatentEditFragment();
    localProfilePatentEditFragment.setArguments(paramProfilePatentEditBundleBuilder.build());
    return localProfilePatentEditFragment;
  }
  
  private NormPatent normalizePatent(Patent paramPatent)
    throws BuilderException
  {
    NormPatent.Builder localBuilder = new NormPatent.Builder();
    ArrayList localArrayList = new ArrayList(inventors.size());
    Iterator localIterator = inventors.iterator();
    while (localIterator.hasNext())
    {
      Contributor localContributor = (Contributor)localIterator.next();
      Urn localUrn = entityUrn;
      if (localUrn != null) {
        localArrayList.add(new NormContributor.Builder().setProfileUrn(profileUrn).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { localUrn.getLastId() })).setName(profileUtil.getDisplayNameString(localContributor)).build(RecordTemplate.Flavor.RECORD));
      }
    }
    if (localArrayList.size() > 0) {
      localBuilder.setInventors(localArrayList);
    }
    localBuilder.setEntityUrn(entityUrn).setIssuer(issuer).setTitle(title).setPending(Boolean.valueOf(pending)).setUrl(url).setDescription(description);
    if (hasIssueDate) {
      localBuilder.setIssueDate(issueDate);
    }
    if (hasFilingDate) {
      localBuilder.setFilingDate(filingDate);
    }
    if (hasApplicationNumber) {
      localBuilder.setApplicationNumber(applicationNumber);
    }
    if (hasNumber) {
      localBuilder.setNumber(number);
    }
    return localBuilder.build();
  }
  
  private void populateFields(NormPatent.Builder paramBuilder)
    throws BuilderException
  {
    Object localObject1;
    Object localObject3;
    Object localObject2;
    if (patent == null)
    {
      localObject1 = ProfileUtil.getMockUrn();
      paramBuilder.setEntityUrn((Urn)localObject1);
      paramBuilder.setTitle(viewHolder.title.getText().toString());
      boolean bool = viewModel.pending.booleanValue();
      paramBuilder.setPending(Boolean.valueOf(bool));
      if (viewHolder.url.getText() != null)
      {
        localObject3 = viewHolder.url.getText().toString();
        localObject2 = "";
        localObject1 = localObject2;
        if (patent != null)
        {
          localObject1 = localObject2;
          if (patent.url != null) {
            localObject1 = patent.url;
          }
        }
        if (((patent == null) && (((String)localObject3).length() > 0)) || ((patent != null) && (!((String)localObject1).equals(localObject3)))) {
          paramBuilder.setUrl((String)localObject3);
        }
      }
      if (viewHolder.number.getText() != null)
      {
        localObject1 = viewHolder.number.getText().toString();
        if (!bool) {
          break label585;
        }
        paramBuilder.setApplicationNumber((String)localObject1);
      }
      label194:
      if (viewHolder.office.getSelectedItem() == null) {
        break label606;
      }
      localObject1 = (String)viewHolder.office.getSelectedItem();
      localObject2 = viewModel;
      if (localObject1 == null) {
        break label594;
      }
      localObject2 = countries.iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (Country)((Iterator)localObject2).next();
          if ((localObject1 != null) && (localObject1 == countryName))
          {
            localObject1 = countryCode;
            label284:
            if (localObject1 == null) {
              break label599;
            }
            label288:
            paramBuilder.setIssuer((String)localObject1);
            label294:
            if (viewHolder.description.getText() != null)
            {
              localObject1 = viewHolder.description.getText().toString();
              if (((patent == null) && (((String)localObject1).length() > 0)) || (patent != null)) {
                paramBuilder.setDescription((String)localObject1);
              }
            }
            if (viewModel.year > 0)
            {
              localObject1 = new Date.Builder();
              ((Date.Builder)localObject1).setYear(Integer.valueOf(viewModel.year));
              if (viewModel.month >= 0) {
                ((Date.Builder)localObject1).setMonth(Integer.valueOf(viewModel.month + 1));
              }
              if (viewModel.dayOfMonth > 0) {
                ((Date.Builder)localObject1).setDay(Integer.valueOf(viewModel.dayOfMonth));
              }
              if (!bool) {
                break label617;
              }
              paramBuilder.setFilingDate(((Date.Builder)localObject1).build(RecordTemplate.Flavor.RECORD));
            }
          }
        }
      }
    }
    for (;;)
    {
      label449:
      if ((viewModel != null) && (viewModel.inventors != null) && (viewModel.inventors.size() > 0))
      {
        localObject1 = new ArrayList();
        localObject2 = viewModel.inventors.iterator();
        for (;;)
        {
          if (((Iterator)localObject2).hasNext())
          {
            localObject3 = (ProfileEditContributor)((Iterator)localObject2).next();
            ((List)localObject1).add(new NormContributor.Builder().setEntityUrn(ProfileEditContributor.asUrn(entityUrn)).setProfileUrn(ProfileEditContributor.asUrn(profileUrn)).setName(name).build(RecordTemplate.Flavor.RECORD));
            continue;
            localObject1 = patent.entityUrn;
            break;
            label585:
            paramBuilder.setNumber((String)localObject1);
            break label194;
            label594:
            localObject1 = null;
            break label284;
            label599:
            localObject1 = "";
            break label288;
            label606:
            paramBuilder.setIssuer("");
            break label294;
            label617:
            paramBuilder.setIssueDate(((Date.Builder)localObject1).build(RecordTemplate.Flavor.RECORD));
            break label449;
          }
        }
        paramBuilder.setInventors((List)localObject1);
      }
    }
  }
  
  private void setFormData(Patent paramPatent)
    throws BuilderException
  {
    Object localObject2 = null;
    Object localObject3 = patentInventors;
    FragmentComponent localFragmentComponent = fragmentComponent;
    I18NManager localI18NManager = i18NManager;
    Object localObject1 = profileUtil;
    Object localObject4 = memberUtil;
    PatentViewModel localPatentViewModel = new PatentViewModel();
    i18NManager = localI18NManager;
    fragmentComponent = localFragmentComponent;
    profileUtil = ((ProfileUtil)localObject1);
    if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty()))
    {
      if (paramPatent != null)
      {
        entityUrn = entityUrn;
        pending = Boolean.valueOf(pending);
        if (pending) {}
        for (localObject1 = applicationNumber;; localObject1 = number)
        {
          number = ProfileUtil.truncate((String)localObject1, 60);
          office = issuer;
          title = ProfileUtil.truncate(title, 255);
          url = ProfileUtil.truncate(url, 262);
          description = description;
          inventors = ProfileEditUtils.toContributorViewModel(inventors, localI18NManager, localFragmentComponent);
          onEditOfficeClick = new TrackingOnItemSelectedListener(localFragmentComponent.tracker(), "patent_office", new TrackingEventBuilder[0]);
          onEditDateClick = new PatentTransformer.1(localFragmentComponent.tracker(), "patent_date");
          onAddInventorClick = new PatentTransformer.2(localFragmentComponent.tracker(), "patent_add_inventor", new TrackingEventBuilder[0], localFragmentComponent, localI18NManager);
          onStatusClick = new TrackingOnClickListener(localFragmentComponent.tracker(), "patent_status", new TrackingEventBuilder[0]);
          if (paramPatent != null)
          {
            if ((!pending) || (!hasFilingDate)) {
              break;
            }
            localObject1 = filingDate;
            label312:
            if (localObject1 != null)
            {
              if (hasYear) {
                year = year;
              }
              if (hasMonth) {
                month = (month - 1);
              }
              if (hasDay) {
                dayOfMonth = day;
              }
            }
          }
          viewModel = localPatentViewModel;
          if (dateYear > 0) {
            viewModel.year = dateYear;
          }
          if (dateMonth >= 0) {
            viewModel.month = dateMonth;
          }
          if (dateDayOfMonth > 0) {
            viewModel.dayOfMonth = dateDayOfMonth;
          }
          viewModel.onContributorsChangedListener = new ProfilePatentEditFragment.2(this);
          viewModel.onPatentStatusChangedListener = new ProfilePatentEditFragment.3(this);
          if (paramPatent != null) {
            deleteLink.setOnClickListener(new ProfilePatentEditFragment.4(this, tracker, "delete", new TrackingEventBuilder[0], paramPatent));
          }
          paramPatent = (BaseActivity)getActivity();
          if (paramPatent != null)
          {
            localObject1 = viewModel;
            paramPatent.getLayoutInflater();
            applicationComponent.mediaCenter();
            ((PatentViewModel)localObject1).onBindViewHolder$37cf18d4(viewHolder);
          }
          paramPatent = viewModel;
          getActivity();
          paramPatent.onBindContributors$43f08a9f(fragmentComponent, ((BaseActivity)getActivity()).getLayoutInflater(), viewHolder, viewModel.inventors);
          return;
        }
      }
      pending = Boolean.valueOf(false);
      localObject3 = ((MemberUtil)localObject4).getMiniProfile();
      if (localObject3 == null) {
        break label705;
      }
      localObject4 = ((ProfileUtil)localObject1).getDisplayNameString((MiniProfile)localObject3);
      String str = entityUrn.getLastId();
      localObject3 = new ProfileEditContributor(((ProfileUtil)localObject1).getMockCompoundUrn("fs_contributor", "-1"), ProfileUrnUtil.createMiniProfileUrn(str), (String)localObject4, ProfileEditUtils.getImageUri((MiniProfile)localObject3));
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localObject3);
    }
    for (;;)
    {
      inventors = ((ArrayList)localObject1);
      break;
      inventors = ((ArrayList)localObject3);
      break;
      localObject1 = localObject2;
      if (pending) {
        break label312;
      }
      localObject1 = localObject2;
      if (!hasIssueDate) {
        break label312;
      }
      localObject1 = issueDate;
      break label312;
      label705:
      localObject1 = null;
    }
  }
  
  public final void doPause()
  {
    super.doPause();
    LocalBroadcastManager.getInstance(getActivity()).unregisterReceiver(receiver);
  }
  
  public final void doResume()
  {
    super.doResume();
    IntentFilter localIntentFilter = new IntentFilter("datePicked");
    LocalBroadcastManager.getInstance(getActivity()).registerReceiver(receiver, localIntentFilter);
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757675;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969219;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232482;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (patent == null) {
        i = 2131232234;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232478;
      continue;
      i = 2131232644;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    Object localObject;
    if (typeahead == ProfileTypeahead.TYPEAHEAD_PICKER_PEOPLE)
    {
      if (paramProfileTypeaheadResult.getMiniProfile() == null) {
        break label235;
      }
      localObject = viewModel.inventors.iterator();
      Urn localUrn;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = ProfileEditContributor.asUrn(nextprofileUrn);
      } while ((localUrn == null) || (!localUrn.equals(urn)));
    }
    label235:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        return;
      }
      if (paramProfileTypeaheadResult.getMiniProfile() != null)
      {
        paramProfileTypeaheadResult = paramProfileTypeaheadResult.getMiniProfile();
        localObject = profileUtil.getDisplayNameString(paramProfileTypeaheadResult);
      }
      for (paramProfileTypeaheadResult = new ProfileEditContributor(profileUtil.getMockCompoundUrn("fs_contributor", "-1"), entityUrn, (String)localObject, ProfileEditUtils.getImageUri(paramProfileTypeaheadResult));; paramProfileTypeaheadResult = new ProfileEditContributor(profileUtil.getMockCompoundUrn("fs_contributor", "-1"), null, paramProfileTypeaheadResult, null))
      {
        if (paramProfileTypeaheadResult.isValid())
        {
          viewModel.inventors.add(paramProfileTypeaheadResult);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramProfileTypeaheadResult);
          paramProfileTypeaheadResult = (BaseActivity)getActivity();
          if (paramProfileTypeaheadResult != null) {
            viewModel.onBindContributors$43f08a9f(fragmentComponent, paramProfileTypeaheadResult.getLayoutInflater(), viewHolder, (List)localObject);
          }
        }
        setEditSaveMenuItemEnabled(isFormModified());
        return;
        paramProfileTypeaheadResult = text;
      }
    }
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    getActivityComponent().profileDataProvider().getCountries(busSubscriberId, rumSessionId, Tracker.createPageInstanceHeader(getPageInstance()));
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      Object localObject = new NormPatent.Builder();
      populateFields((NormPatent.Builder)localObject);
      localObject = ((NormPatent.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalPatent == null)
      {
        NormPatent.Builder localBuilder = new NormPatent.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalPatent.equals(localObject);
        return !bool;
      }
    }
    catch (BuilderException localBuilderException)
    {
      Log.d(TAG, "Failed to populate fields: " + localBuilderException.getMessage());
      return true;
    }
    return false;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    if (validator == null) {
      return false;
    }
    if (patent != null)
    {
      localObject = new NormPatent.Builder(normalizePatent(patent));
      populateFields((NormPatent.Builder)localObject);
      localObject = ((NormPatent.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormPatent)localObject);
    }
    Object localObject = new NormPatent.Builder();
    populateFields((NormPatent.Builder)localObject);
    localObject = ((NormPatent.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormPatent)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    dateMonth = -1;
    if (paramBundle != null)
    {
      patentInventors = paramBundle.getParcelableArrayList("inventors");
      dateYear = paramBundle.getInt("dateYear");
      dateMonth = paramBundle.getInt("dateMonth");
      dateDayOfMonth = paramBundle.getInt("dateDay");
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((paramType == DataStore.Type.LOCAL) && (dataResponseHandler.isInitialLoadRoutes(paramSet))) {
      return;
    }
    if ((paramSet != null) && (paramSet.contains(Routes.COUNTRY.buildUponRoot().toString())))
    {
      paramSet = viewModel;
      Object localObject = viewHolder;
      paramMap = countriesWithEurope(getActivityComponentprofileDataProviderstate).countries().elements);
      if (patent != null) {}
      ArrayList localArrayList;
      for (paramType = patent.issuer;; paramType = null)
      {
        countries = paramMap;
        localObject = office;
        localArrayList = new ArrayList(paramMap.size() + 1);
        localArrayList.add("-");
        paramMap = paramMap.iterator();
        while (paramMap.hasNext()) {
          localArrayList.add(nextcountryName);
        }
      }
      paramMap = new CustomArrayAdapter(fragmentComponent.context(), localArrayList);
      paramMap.setDropDownViewResource(17367049);
      ((Spinner)localObject).setAdapter(paramMap);
      ((Spinner)localObject).setSelection(paramSet.findCountryIndex(paramType));
      return;
    }
    dataResponseHandler.handleOnDataReady(paramType, paramSet, paramMap);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("inventors", viewModel.inventors);
    paramBundle.putInt("dateYear", viewModel.year);
    paramBundle.putInt("dateMonth", viewModel.month);
    paramBundle.putInt("dateDay", viewModel.dayOfMonth);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getPatents();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Patent localPatent = (Patent)((Iterator)localObject).next();
          if ((patent != null) && (patent.entityUrn != null) && (patent.entityUrn.equals(entityUrn))) {
            try
            {
              setFormData(localPatent);
            }
            catch (BuilderException localBuilderException)
            {
              Log.d(TAG, "Failed to set form data: " + localBuilderException.getMessage());
            }
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (patent == null) {
      return "profile_self_add_patent";
    }
    return "profile_self_edit_patent";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    patent = ProfilePatentEditBundleBuilder.getPatent(getArguments());
    super.setFragmentData(paramBundle);
    viewHolder = ((PatentViewHolder)PatentViewHolder.CREATOR.createViewHolder(formScrollView));
    paramBundle = new PatentValidator();
    titleTextLayout = titleEditLayout;
    numberTextLayout = numberEditLayout;
    urlTextLayout = urlEditLayout;
    descriptionTextLayout = descriptionEditLayout;
    officeErrorTextView = officeErrorTextView;
    dateEditLayout = dateEditLayout;
    validator = paramBundle;
    validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil);
    setFormData(patent);
    paramBundle = new NormPatent.Builder();
    populateFields(paramBundle);
    if (patent != null) {
      paramBundle.setIssuer(patent.issuer);
    }
    originalPatent = paramBundle.build(RecordTemplate.Flavor.RECORD);
    ProfileUtil.setLimit(viewHolder.title, 255);
    ProfileUtil.setLimit(viewHolder.number, 60);
    ProfileUtil.setLimit(viewHolder.url, 262);
    viewHolder.description.addTextChangedListener(new SizeLimitWatcher(viewHolder.description, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 2000, 20, i18NManager));
    addEditTextWatchList(new EditText[] { viewHolder.title, viewHolder.number, viewHolder.dateEdit, viewHolder.url, viewHolder.description });
    addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.description });
    addSpinnerWatchList(new Spinner[] { viewHolder.office });
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    if (patent != null) {
      try
      {
        localObject = new NormPatent.Builder(normalizePatent(patent));
        populateFields((NormPatent.Builder)localObject);
        localObject = ((NormPatent.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
        localObject = PegasusPatchGenerator.INSTANCE.diff(patent, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = ProfileRoutes.buildEditEntityRoute("normPatents", str3, patent.entityUrn.getLastId(), getDataProvider().getProfileVersionTag()).toString();
          state).patentsRoute = ProfileRoutes.buildPatentsRoute(str3).toString();
          state).allPatentsRoute = state).patentsRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).patentsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Patent.BUILDER, CollectionMetadata.BUILDER))));
          return;
        }
        goBackToPreviousFragment();
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.d(TAG, "Failed to generate diff: " + localJSONException.getMessage());
        return;
      }
    }
    Object localObject = new NormPatent.Builder();
    populateFields((NormPatent.Builder)localObject);
    localObject = ((NormPatent.Builder)localObject).build();
    setDidCreate$1385ff();
    ProfileDataProvider localProfileDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = getProfileId();
    String str4 = ProfileRoutes.buildAddEntityRoute("normPatents", str3, getDataProvider().getProfileVersionTag()).toString();
    state).patentsRoute = ProfileRoutes.buildPatentsRoute(str3).toString();
    state).allPatentsRoute = state).patentsRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localJSONException, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).patentsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Patent.BUILDER, CollectionMetadata.BUILDER))));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfilePatentEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */