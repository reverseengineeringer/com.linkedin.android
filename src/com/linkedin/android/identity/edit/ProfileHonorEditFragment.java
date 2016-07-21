package com.linkedin.android.identity.edit;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.identity.edit.honors.HonorTransformer.1;
import com.linkedin.android.identity.edit.honors.HonorTransformer.2;
import com.linkedin.android.identity.edit.honors.HonorTransformer.3;
import com.linkedin.android.identity.edit.honors.HonorTransformer.4;
import com.linkedin.android.identity.edit.honors.HonorTransformer.5;
import com.linkedin.android.identity.edit.honors.HonorViewHolder;
import com.linkedin.android.identity.edit.honors.HonorViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.OccupationArrayAdapter;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.HonorValidator;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.PegasusPatchGenerator;
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
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Honor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormHonor.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileHonorEditFragment
  extends ProfileEditBaseFragment
{
  private static final String TAG = ProfileHonorEditFragment.class.getSimpleName();
  @InjectView(2131757644)
  TextInputLayout dateTextLayout;
  @InjectView(2131757648)
  TextView deleteLink;
  @InjectView(2131757646)
  TextInputLayout descriptionTextLayout;
  private List<Education> educations;
  @InjectView(2131757636)
  LinearLayout formLayout;
  @InjectView(2131757635)
  ScrollView formScrollView;
  private Honor honor;
  @InjectView(2131757642)
  TextInputLayout issuerTextLayout;
  private OccupationArrayAdapter occupationArrayAdapter;
  @InjectView(2131757641)
  Spinner occupationSpinner;
  @InjectView(2131757639)
  TextInputLayout occupationTextLayout;
  private NormHonor originalHonor;
  private List<Position> positions;
  @Inject
  ProfileUtil profileUtil;
  private final BroadcastReceiver receiver = new ProfileHonorEditFragment.1(this);
  @InjectView(2131757637)
  TextInputLayout titleTextLayout;
  private HonorValidator validator;
  private HonorViewHolder viewHolder;
  private HonorViewModel viewModel;
  
  private NormHonor getNormFormHonor()
    throws BuilderException
  {
    if (honor != null)
    {
      localBuilder = new NormHonor.Builder(normalizeHonor(honor));
      populateFields(localBuilder);
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
    }
    NormHonor.Builder localBuilder = new NormHonor.Builder();
    populateFields(localBuilder);
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  public static ProfileHonorEditFragment newInstance(ProfileHonorEditBundleBuilder paramProfileHonorEditBundleBuilder)
  {
    ProfileHonorEditFragment localProfileHonorEditFragment = new ProfileHonorEditFragment();
    localProfileHonorEditFragment.setArguments(paramProfileHonorEditBundleBuilder.build());
    return localProfileHonorEditFragment;
  }
  
  public static ProfileHonorEditFragment newInstance(ProfileHonorEditBundleBuilder paramProfileHonorEditBundleBuilder, ProfileViewListener paramProfileViewListener)
  {
    ProfileHonorEditFragment localProfileHonorEditFragment = new ProfileHonorEditFragment();
    profileViewListener = paramProfileViewListener;
    localProfileHonorEditFragment.setArguments(paramProfileHonorEditBundleBuilder.build());
    return localProfileHonorEditFragment;
  }
  
  private static NormHonor normalizeHonor(Honor paramHonor)
    throws BuilderException
  {
    NormHonor.Builder localBuilder = new NormHonor.Builder();
    localBuilder.setEntityUrn(entityUrn);
    localBuilder.setTitle(title);
    if (hasIssuer) {
      localBuilder.setIssuer(issuer);
    }
    if (hasOccupation) {
      localBuilder.setOccupation(occupation);
    }
    if (hasIssueDate) {
      localBuilder.setIssueDate(issueDate);
    }
    if (hasDescription) {
      localBuilder.setDescription(description);
    }
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormHonor.Builder paramBuilder)
    throws BuilderException
  {
    if (honor == null) {}
    for (Object localObject = ProfileUtil.getMockUrn();; localObject = honor.entityUrn)
    {
      paramBuilder.setEntityUrn((Urn)localObject);
      paramBuilder.setTitle(viewHolder.titleEdit.getText().toString());
      paramBuilder.setIssuer(viewHolder.issuerEdit.getText().toString());
      int i = viewHolder.occupationSpinner.getSelectedItemPosition();
      if ((educations != null) && (positions != null) && (i > 0) && (i <= educations.size() + positions.size())) {
        paramBuilder.setOccupation(occupationArrayAdapter.getOccupationUrn(i));
      }
      String str = viewHolder.descriptionEditText.getText().toString();
      localObject = str;
      if (str.isEmpty()) {
        localObject = null;
      }
      paramBuilder.setDescription((String)localObject);
      if (viewModel.year > 0)
      {
        localObject = new Date.Builder();
        ((Date.Builder)localObject).setYear(Integer.valueOf(viewModel.year));
        if (viewModel.month >= 0) {
          ((Date.Builder)localObject).setMonth(Integer.valueOf(viewModel.month + 1));
        }
        paramBuilder.setIssueDate(((Date.Builder)localObject).build(RecordTemplate.Flavor.RECORD));
      }
      return;
    }
  }
  
  private void setFormData(Honor paramHonor)
  {
    Object localObject = fragmentComponent;
    I18NManager localI18NManager = i18NManager;
    ProfileUtil localProfileUtil = profileUtil;
    HonorViewModel localHonorViewModel = new HonorViewModel();
    i18NManager = localI18NManager;
    fragmentComponent = ((FragmentComponent)localObject);
    profileUtil = localProfileUtil;
    if (paramHonor != null)
    {
      title = ProfileUtil.truncate(title, 255);
      issuer = ProfileUtil.truncate(issuer, 255);
      date = issueDate;
      description = ProfileUtil.truncate(description, 2000);
    }
    if ((paramHonor != null) && (hasIssueDate) && (issueDate != null))
    {
      paramHonor = issueDate;
      if (hasYear) {
        year = year;
      }
      if (hasMonth) {
        month = (month - 1);
      }
    }
    onTitleEditTouched = new HonorTransformer.1((FragmentComponent)localObject);
    onIssuerEditTouched = new HonorTransformer.2((FragmentComponent)localObject);
    onDescriptionEditTouched = new HonorTransformer.3((FragmentComponent)localObject);
    onDateEditClickTrackingClosure = new HonorTransformer.4(((FragmentComponent)localObject).tracker(), "honor_date");
    onOccupationClickTrackingClosure = new HonorTransformer.5(((FragmentComponent)localObject).tracker(), "honor_association");
    viewModel = localHonorViewModel;
    paramHonor = (BaseActivity)getActivity();
    if (paramHonor != null)
    {
      localObject = viewModel;
      paramHonor.getLayoutInflater();
      applicationComponent.mediaCenter();
      ((HonorViewModel)localObject).onBindViewHolder$42ed07cf(viewHolder);
    }
  }
  
  protected final void addTrackedListeners()
  {
    deleteLink.setOnClickListener(new ProfileHonorEditFragment.2(this, tracker, "delete", new TrackingEventBuilder[0]));
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
    return 2131757635;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969209;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232410;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (honor == null) {
        i = 2131232232;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232409;
      continue;
      i = 2131232611;
    }
  }
  
  protected final void initializeFields()
  {
    educations = getEducations();
    positions = getPositions();
    occupationArrayAdapter = new OccupationArrayAdapter(getActivity());
    OccupationArrayAdapter localOccupationArrayAdapter = occupationArrayAdapter;
    Object localObject1 = educations;
    Object localObject2 = positions;
    ProfileUtil localProfileUtil = profileUtil;
    occupationUrns = new ArrayList();
    occupationUrns.add(null);
    occupationUrns.add(null);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("");
    localArrayList.add("-");
    if (localObject2 != null)
    {
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Position localPosition = (Position)((Iterator)localObject2).next();
        occupationUrns.add(entityUrn);
        localArrayList.add(localProfileUtil.getOccupationString(localPosition));
      }
    }
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Education)((Iterator)localObject1).next();
        occupationUrns.add(entityUrn);
        localArrayList.add(localProfileUtil.getFullOccupationString((Education)localObject2));
      }
    }
    localOccupationArrayAdapter.setObjects(localArrayList);
    occupationSpinner.setAdapter(occupationArrayAdapter);
    if ((honor != null) && (honor.hasOccupation) && (honor.occupation != null)) {
      occupationSpinner.setSelection(occupationArrayAdapter.getSelectedUrn(honor.occupation));
    }
    formLayout.requestFocus();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      Object localObject = new NormHonor.Builder();
      populateFields((NormHonor.Builder)localObject);
      localObject = ((NormHonor.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalHonor == null)
      {
        NormHonor.Builder localBuilder = new NormHonor.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalHonor.equals(localObject);
        return !bool;
      }
    }
    catch (BuilderException localBuilderException)
    {
      Log.e(TAG, "Failed to populate fields: " + localBuilderException.getMessage(), localBuilderException);
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
    if (honor != null)
    {
      localObject = new NormHonor.Builder(normalizeHonor(honor));
      populateFields((NormHonor.Builder)localObject);
      localObject = ((NormHonor.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormHonor)localObject);
    }
    Object localObject = new NormHonor.Builder();
    populateFields((NormHonor.Builder)localObject);
    localObject = ((NormHonor.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormHonor)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getHonors();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Honor localHonor = (Honor)((Iterator)localObject).next();
          if ((honor != null) && (honor.entityUrn != null) && (honor.entityUrn.equals(entityUrn))) {
            setFormData(localHonor);
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (honor == null) {
      return "profile_self_add_honor";
    }
    return "profile_self_edit_honor";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    honor = ProfileHonorEditBundleBuilder.getHonor(getArguments());
    super.setFragmentData(paramBundle);
    viewHolder = ((HonorViewHolder)HonorViewHolder.CREATOR.createViewHolder(formScrollView));
    paramBundle = deleteLink;
    if (honor == null) {}
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      ProfileUtil.setLimit(viewHolder.titleEdit, 255);
      ProfileUtil.setLimit(viewHolder.issuerEdit, 255);
      viewHolder.descriptionEditText.addTextChangedListener(new SizeLimitWatcher(viewHolder.descriptionEditText, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 2000, 20, i18NManager));
      validator = new HonorValidator();
      paramBundle = validator;
      titleTextLayout = titleTextLayout;
      issuerTextLayout = issuerTextLayout;
      dateEditLayout = dateTextLayout;
      descriptionTextLayout = descriptionTextLayout;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setProfileUtil(profileUtil).setFormScrollView(formScrollView);
      setFormData(honor);
      addEditTextWatchList(new EditText[] { viewHolder.titleEdit, viewHolder.issuerEdit, viewHolder.descriptionEditText, viewHolder.dateEdit, viewHolder.occupationEdit });
      originalHonor = getNormFormHonor();
      return;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Object localObject = getNormFormHonor();
    if (honor != null) {
      try
      {
        localObject = PegasusPatchGenerator.INSTANCE.diff(honor, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          if (honor.entityUrn == null) {
            return;
          }
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = honor.entityUrn.getLastId();
          String str5 = getDataProvider().getProfileVersionTag();
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          str4 = ProfileRoutes.buildEditEntityRoute("normHonors", str3, str4, str5).toString();
          state).honorsRoute = ProfileRoutes.buildHonorsRoute(str3).toString();
          state).allHonorsRoute = state).honorsRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).honorsRoute).builder(Honor.BUILDER), true));
          return;
        }
        goBackToPreviousFragment();
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e(TAG, "Failed to generate diff for update: " + localJSONException.getMessage(), localJSONException);
        return;
      }
    }
    setDidCreate$1385ff();
    ProfileDataProvider localProfileDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = getProfileId();
    String str4 = getDataProvider().getProfileVersionTag();
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    str4 = ProfileRoutes.buildAddEntityRoute("normHonors", str3, str4).toString();
    state).honorsRoute = ProfileRoutes.buildHonorsRoute(str3).toString();
    state).allHonorsRoute = state).honorsRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, localJSONException, Request.get().url(state).honorsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Honor.BUILDER, CollectionMetadata.BUILDER))));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileHonorEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */