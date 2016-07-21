package com.linkedin.android.identity.edit;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.InjectView;
import com.linkedin.android.identity.edit.publications.PublicationViewHolder;
import com.linkedin.android.identity.edit.publications.PublicationViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUrnUtil;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SizeLimitWatcher;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.PublicationValidator;
import com.linkedin.android.infra.IntentRegistry;
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
import com.linkedin.android.infra.shared.MemberUtil;
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
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormContributor.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormPublication.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Publication;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
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

public class ProfilePublicationEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  private static final String TAG = ProfilePublicationEditFragment.class.getSimpleName();
  private int dateDayOfMonth;
  @InjectView(2131757770)
  TextInputLayout dateEditLayout;
  private int dateMonth = -1;
  private int dateYear;
  @InjectView(2131757777)
  TextInputLayout descriptionEditLayout;
  @InjectView(2131757765)
  LinearLayout formLayout;
  @InjectView(2131757764)
  ScrollView formScrollView;
  @Inject
  IntentRegistry intentRegistry;
  private NormPublication originalPublication;
  @Inject
  ProfileUtil profileUtil;
  private Publication publication;
  private ArrayList<ProfileEditContributor> publicationAuthors;
  @InjectView(2131757768)
  TextInputLayout publisherEditLayout;
  private final BroadcastReceiver receiver = new ProfilePublicationEditFragment.1(this);
  @InjectView(2131757766)
  TextInputLayout titleEditLayout;
  @InjectView(2131757775)
  TextInputLayout urlEditLayout;
  private PublicationValidator validator;
  private PublicationViewHolder viewHolder;
  private PublicationViewModel viewModel;
  
  public static ProfilePublicationEditFragment newInstance(ProfilePublicationEditBundleBuilder paramProfilePublicationEditBundleBuilder)
  {
    ProfilePublicationEditFragment localProfilePublicationEditFragment = new ProfilePublicationEditFragment();
    localProfilePublicationEditFragment.setArguments(paramProfilePublicationEditBundleBuilder.build());
    return localProfilePublicationEditFragment;
  }
  
  private NormPublication normalizePublication(Publication paramPublication)
    throws BuilderException
  {
    NormPublication.Builder localBuilder = new NormPublication.Builder();
    ArrayList localArrayList = new ArrayList(authors.size());
    Iterator localIterator = authors.iterator();
    while (localIterator.hasNext())
    {
      Contributor localContributor = (Contributor)localIterator.next();
      localArrayList.add(new NormContributor.Builder().setProfileUrn(profileUrn).setEntityUrn(Urn.createFromTuple("mockurn", new Object[] { entityUrn.getLastId() })).setName(profileUtil.getDisplayNameString(localContributor)).build(RecordTemplate.Flavor.RECORD));
    }
    if (localArrayList.size() > 0) {
      localBuilder.setAuthors(localArrayList);
    }
    return localBuilder.setEntityUrn(entityUrn).setName(name).setDate(date).setUrl(url).setDescription(description).setPublisher(publisher).build();
  }
  
  private void populateFields(NormPublication.Builder paramBuilder)
    throws BuilderException
  {
    if (publication == null) {}
    for (Object localObject1 = ProfileUtil.getMockUrn();; localObject1 = publication.entityUrn)
    {
      paramBuilder.setEntityUrn((Urn)localObject1);
      paramBuilder.setName(viewHolder.title.getText().toString());
      if (viewHolder.publisher.getText() != null)
      {
        localObject1 = viewHolder.publisher.getText().toString();
        if (((publication == null) && (((String)localObject1).length() > 0)) || (publication != null)) {
          paramBuilder.setPublisher((String)localObject1);
        }
      }
      Object localObject3;
      if (viewHolder.url.getText() != null)
      {
        localObject3 = viewHolder.url.getText().toString();
        localObject2 = "";
        localObject1 = localObject2;
        if (publication != null)
        {
          localObject1 = localObject2;
          if (publication.url != null) {
            localObject1 = publication.url;
          }
        }
        if (((publication == null) && (((String)localObject3).length() > 0)) || ((publication != null) && (!((String)localObject1).equals(localObject3)))) {
          paramBuilder.setUrl((String)localObject3);
        }
      }
      if (viewHolder.description.getText() != null)
      {
        localObject1 = viewHolder.description.getText().toString();
        if (((publication == null) && (((String)localObject1).length() > 0)) || (publication != null)) {
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
        paramBuilder.setDate(((Date.Builder)localObject1).build(RecordTemplate.Flavor.RECORD));
      }
      if ((viewModel == null) || (viewModel.authors == null) || (viewModel.authors.size() <= 0)) {
        return;
      }
      localObject1 = new ArrayList();
      Object localObject2 = viewModel.authors.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ProfileEditContributor)((Iterator)localObject2).next();
        ((List)localObject1).add(new NormContributor.Builder().setEntityUrn(ProfileEditContributor.asUrn(entityUrn)).setProfileUrn(ProfileEditContributor.asUrn(profileUrn)).setName(name).build(RecordTemplate.Flavor.RECORD));
      }
    }
    paramBuilder.setAuthors((List)localObject1);
  }
  
  private void setFormData(Publication paramPublication)
    throws BuilderException
  {
    Object localObject1 = publicationAuthors;
    Object localObject4 = fragmentComponent;
    I18NManager localI18NManager = i18NManager;
    Object localObject2 = profileUtil;
    Object localObject3 = memberUtil;
    PublicationViewModel localPublicationViewModel = new PublicationViewModel();
    i18NManager = localI18NManager;
    fragmentComponent = ((FragmentComponent)localObject4);
    profileUtil = ((ProfileUtil)localObject2);
    if ((localObject1 == null) || (((ArrayList)localObject1).isEmpty())) {
      if (paramPublication != null)
      {
        entityUrn = entityUrn;
        title = ProfileUtil.truncate(name, 255);
        publisher = ProfileUtil.truncate(publisher, 100);
        url = ProfileUtil.truncate(url, 100);
        description = description;
        authors = ProfileEditUtils.toContributorViewModel(authors, localI18NManager, (FragmentComponent)localObject4);
      }
    }
    for (;;)
    {
      if ((paramPublication != null) && (hasDate))
      {
        localObject1 = date;
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
      viewModel = localPublicationViewModel;
      if (dateYear > 0) {
        viewModel.year = dateYear;
      }
      if (dateMonth >= 0) {
        viewModel.month = dateMonth;
      }
      if (dateDayOfMonth > 0) {
        viewModel.dayOfMonth = dateDayOfMonth;
      }
      viewModel.onDateEditClick = new ProfilePublicationEditFragment.2(this, tracker, "publication_date");
      viewModel.onAddCoauthorClick = new ProfilePublicationEditFragment.3(this, tracker, "publication_add_coauthor");
      viewModel.onContributorsChangedListener = new ProfilePublicationEditFragment.4(this);
      if (paramPublication != null) {
        viewModel.onDeletePublicationClick = new ProfilePublicationEditFragment.5(this, tracker, "delete", paramPublication);
      }
      paramPublication = viewModel;
      ((BaseActivity)getActivity()).getLayoutInflater();
      applicationComponent.mediaCenter();
      paramPublication.onBindViewHolder$5538b60f(viewHolder);
      paramPublication = viewModel;
      getActivity();
      paramPublication.onBindContributors$36fe46c4(fragmentComponent, ((BaseActivity)getActivity()).getLayoutInflater(), viewHolder, viewModel.authors);
      return;
      localObject1 = null;
      localObject3 = ((MemberUtil)localObject3).getMiniProfile();
      if (localObject3 != null)
      {
        localObject1 = ((ProfileUtil)localObject2).getDisplayNameString((MiniProfile)localObject3);
        localObject4 = entityUrn.getLastId();
        localObject2 = new ProfileEditContributor(((ProfileUtil)localObject2).getMockCompoundUrn("fs_contributor", "-1"), ProfileUrnUtil.createMiniProfileUrn((String)localObject4), (String)localObject1, ProfileEditUtils.getImageUri((MiniProfile)localObject3));
        localObject1 = new ArrayList();
        ((ArrayList)localObject1).add(localObject2);
      }
      authors = ((ArrayList)localObject1);
      continue;
      authors = ((ArrayList)localObject1);
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
    return 2131757764;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969228;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232551;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (publication == null) {
        i = 2131232237;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232542;
      continue;
      i = 2131232667;
    }
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    Object localObject;
    if (typeahead == ProfileTypeahead.TYPEAHEAD_PICKER_PEOPLE)
    {
      if (paramProfileTypeaheadResult.getMiniProfile() == null) {
        break label236;
      }
      localObject = viewModel.authors.iterator();
      Urn localUrn;
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localUrn = ProfileEditContributor.asUrn(nextprofileUrn);
      } while ((localUrn == null) || (!localUrn.equals(urn)));
    }
    label236:
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
          viewModel.authors.add(paramProfileTypeaheadResult);
          localObject = new ArrayList();
          ((ArrayList)localObject).add(paramProfileTypeaheadResult);
          paramProfileTypeaheadResult = viewModel;
          getActivity();
          paramProfileTypeaheadResult.onBindContributors$36fe46c4(fragmentComponent, ((BaseActivity)getActivity()).getLayoutInflater(), viewHolder, (List)localObject);
        }
        setEditSaveMenuItemEnabled(isFormModified());
        return;
        paramProfileTypeaheadResult = text;
      }
    }
  }
  
  protected final void initializeFields()
    throws BuilderException
  {}
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      Object localObject = new NormPublication.Builder();
      populateFields((NormPublication.Builder)localObject);
      localObject = ((NormPublication.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalPublication == null)
      {
        NormPublication.Builder localBuilder = new NormPublication.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalPublication.equals(localObject);
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
    if (publication != null)
    {
      localObject = new NormPublication.Builder(normalizePublication(publication));
      populateFields((NormPublication.Builder)localObject);
      localObject = ((NormPublication.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormPublication)localObject);
    }
    Object localObject = new NormPublication.Builder();
    populateFields((NormPublication.Builder)localObject);
    localObject = ((NormPublication.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormPublication)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    dateMonth = -1;
    if (paramBundle != null)
    {
      publicationAuthors = paramBundle.getParcelableArrayList("coauthors");
      dateYear = paramBundle.getInt("dateYear");
      dateMonth = paramBundle.getInt("dateMonth");
      dateDayOfMonth = paramBundle.getInt("dateDay");
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelableArrayList("coauthors", viewModel.authors);
    paramBundle.putInt("dateYear", viewModel.year);
    paramBundle.putInt("dateMonth", viewModel.month);
    paramBundle.putInt("dateDay", viewModel.dayOfMonth);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getPublications();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Publication localPublication = (Publication)((Iterator)localObject).next();
          if ((publication != null) && (publication.entityUrn.equals(entityUrn))) {
            try
            {
              setFormData(localPublication);
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
    if (publication == null) {
      return "profile_self_add_publication";
    }
    return "profile_self_edit_publication";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    publication = ProfilePublicationEditBundleBuilder.getPublication(getArguments());
    super.setFragmentData(paramBundle);
    viewHolder = ((PublicationViewHolder)PublicationViewHolder.CREATOR.createViewHolder(formScrollView));
    ProfileUtil.setLimit(viewHolder.title, 255);
    ProfileUtil.setLimit(viewHolder.publisher, 100);
    ProfileUtil.setLimit(viewHolder.url, 100);
    viewHolder.description.addTextChangedListener(new SizeLimitWatcher(viewHolder.description, viewHolder.descriptionExceedLimit, viewHolder.descriptionChars, 2000, 20, i18NManager));
    paramBundle = new PublicationValidator();
    titleTextLayout = titleEditLayout;
    publisherTextLayout = publisherEditLayout;
    urlTextLayout = urlEditLayout;
    descriptionTextLayout = descriptionEditLayout;
    dateEditLayout = dateEditLayout;
    validator = paramBundle;
    validator.setActivity(getActivity()).setI18NManager(i18NManager).setFormScrollView(formScrollView).setProfileUtil(profileUtil);
    setFormData(publication);
    addEditTextWatchList(new EditText[] { viewHolder.title, viewHolder.publisher, viewHolder.dateEdit, viewHolder.url, viewHolder.description });
    addMultilineEditTextOnFocusChangeWatchList(new EditText[] { viewHolder.description });
    paramBundle = new NormPublication.Builder();
    populateFields(paramBundle);
    originalPublication = paramBundle.build(RecordTemplate.Flavor.RECORD);
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    if (publication != null) {
      try
      {
        localObject = new NormPublication.Builder(normalizePublication(publication));
        populateFields((NormPublication.Builder)localObject);
        localObject = ((NormPublication.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
        localObject = PegasusPatchGenerator.INSTANCE.diff(publication, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = ProfileRoutes.buildEditEntityRoute("normPublications", str3, publication.entityUrn.getLastId(), getDataProvider().getProfileVersionTag()).toString();
          state).publicationsRoute = ProfileRoutes.buildPublicationsRoute(str3).toString();
          state).allPublicationsRoute = state).publicationsRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).publicationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Publication.BUILDER, CollectionMetadata.BUILDER))));
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
    Object localObject = new NormPublication.Builder();
    populateFields((NormPublication.Builder)localObject);
    localObject = ((NormPublication.Builder)localObject).build();
    setDidCreate$1385ff();
    ProfileDataProvider localProfileDataProvider = getDataProvider();
    String str1 = busSubscriberId;
    String str2 = getRumSessionId();
    String str3 = getProfileId();
    String str4 = ProfileRoutes.buildAddEntityRoute("normPublications", str3, getDataProvider().getProfileVersionTag()).toString();
    state).publicationsRoute = ProfileRoutes.buildPublicationsRoute(str3).toString();
    state).allPublicationsRoute = state).publicationsRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localJSONException, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).publicationsRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Publication.BUILDER, CollectionMetadata.BUILDER))));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfilePublicationEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */