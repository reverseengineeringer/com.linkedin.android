package com.linkedin.android.identity.edit;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.identity.edit.courses.CourseTransformer.1;
import com.linkedin.android.identity.edit.courses.CourseTransformer.2;
import com.linkedin.android.identity.edit.courses.CourseViewHolder;
import com.linkedin.android.identity.edit.courses.CourseViewModel;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileRoutes;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.OccupationArrayAdapter;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.multilistenerwidget.MultiListenerSpinner;
import com.linkedin.android.identity.shared.validators.forms.BaseFormValidator;
import com.linkedin.android.identity.shared.validators.forms.CourseValidator;
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
import com.linkedin.android.pegasus.gen.common.JsonModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Course;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCourse;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.NormCourse.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnItemSelectedListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.json.JSONException;
import org.json.JSONObject;

public class ProfileCourseEditFragment
  extends ProfileEditBaseFragment
{
  private static final String TAG = ProfileCourseEditFragment.class.getSimpleName();
  private Course course;
  @InjectView(2131757478)
  TextInputLayout courseNameTextLayout;
  @InjectView(2131757480)
  TextInputLayout courseNumberTextLayout;
  @InjectView(2131757482)
  TextView deleteLink;
  private List<Education> educations;
  @InjectView(2131757477)
  LinearLayout formLayout;
  @InjectView(2131757476)
  ScrollView formScrollView;
  private OccupationArrayAdapter occupationArrayAdapter;
  private NormCourse originalCourse;
  private List<Position> positions;
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757504)
  MultiListenerSpinner selectOccupationSpinner;
  private CourseValidator validator;
  private CourseViewHolder viewHolder;
  private CourseViewModel viewModel;
  
  private NormCourse getNormFormCourse()
    throws BuilderException
  {
    if (course != null)
    {
      localBuilder = new NormCourse.Builder(normalizeCourse(course));
      populateFields(localBuilder);
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
    }
    NormCourse.Builder localBuilder = new NormCourse.Builder();
    populateFields(localBuilder);
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  public static ProfileCourseEditFragment newInstance(ProfileCourseEditBundleBuilder paramProfileCourseEditBundleBuilder)
  {
    ProfileCourseEditFragment localProfileCourseEditFragment = new ProfileCourseEditFragment();
    localProfileCourseEditFragment.setArguments(paramProfileCourseEditBundleBuilder.build());
    return localProfileCourseEditFragment;
  }
  
  public static ProfileCourseEditFragment newInstance(ProfileCourseEditBundleBuilder paramProfileCourseEditBundleBuilder, ProfileViewListener paramProfileViewListener)
  {
    ProfileCourseEditFragment localProfileCourseEditFragment = new ProfileCourseEditFragment();
    profileViewListener = paramProfileViewListener;
    localProfileCourseEditFragment.setArguments(paramProfileCourseEditBundleBuilder.build());
    return localProfileCourseEditFragment;
  }
  
  private static NormCourse normalizeCourse(Course paramCourse)
    throws BuilderException
  {
    NormCourse.Builder localBuilder = new NormCourse.Builder();
    localBuilder.setEntityUrn(entityUrn);
    localBuilder.setName(name);
    if (hasNumber) {
      localBuilder.setNumber(number);
    }
    if (hasOccupation) {
      localBuilder.setOccupation(occupation);
    }
    return localBuilder.build(RecordTemplate.Flavor.RECORD);
  }
  
  private void populateFields(NormCourse.Builder paramBuilder)
    throws BuilderException
  {
    if (course == null) {}
    for (Urn localUrn = ProfileUtil.getMockUrn();; localUrn = course.entityUrn)
    {
      paramBuilder.setEntityUrn(localUrn);
      paramBuilder.setName(viewHolder.nameEdit.getText().toString());
      paramBuilder.setNumber(viewHolder.numberEdit.getText().toString());
      int i = viewHolder.occupationSpinner.getSelectedItemPosition();
      if ((educations != null) && (positions != null))
      {
        if ((i <= 0) || (i > educations.size() + positions.size())) {
          break;
        }
        paramBuilder.setOccupation(occupationArrayAdapter.getOccupationUrn(i));
      }
      return;
    }
    paramBuilder.setOccupation(null);
  }
  
  private void setFormData(Course paramCourse)
  {
    FragmentComponent localFragmentComponent = fragmentComponent;
    CourseViewModel localCourseViewModel = new CourseViewModel();
    onNameTouched = new CourseTransformer.1(localFragmentComponent);
    onNumberTouched = new CourseTransformer.2(localFragmentComponent);
    onAssociationSelected = new TrackingOnItemSelectedListener(localFragmentComponent.tracker(), "course_association", new TrackingEventBuilder[0]);
    if (paramCourse != null)
    {
      name = name;
      number = number;
    }
    viewModel = localCourseViewModel;
    paramCourse = viewModel;
    ((BaseActivity)getActivity()).getLayoutInflater();
    applicationComponent.mediaCenter();
    paramCourse.onBindViewHolder$619db921(viewHolder);
  }
  
  protected final void addTrackedListeners()
  {
    deleteLink.setOnClickListener(new ProfileCourseEditFragment.1(this, tracker, "delete", new TrackingEventBuilder[0]));
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return 2131757476;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969173;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131232371;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    int i;
    if (Util.isEnglish(getContext())) {
      if (course == null) {
        i = 2131232230;
      }
    }
    for (;;)
    {
      return i18NManager.getString(i);
      i = 2131232370;
      continue;
      i = 2131232281;
    }
  }
  
  protected final void initializeFields()
    throws BuilderException
  {
    educations = getEducations();
    positions = getPositions();
    occupationArrayAdapter = new OccupationArrayAdapter(getActivity());
    occupationArrayAdapter.setOccupations(educations, positions, profileUtil, getString(2131232559), getString(2131232560));
    selectOccupationSpinner.setAdapter(occupationArrayAdapter);
    MultiListenerSpinner localMultiListenerSpinner = selectOccupationSpinner;
    if ((course != null) && (course.hasOccupation)) {}
    for (int i = occupationArrayAdapter.getSelectedUrn(course.occupation);; i = 0)
    {
      localMultiListenerSpinner.setSelection(i);
      formLayout.requestFocus();
      return;
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      Object localObject = new NormCourse.Builder();
      populateFields((NormCourse.Builder)localObject);
      localObject = ((NormCourse.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      if (originalCourse == null)
      {
        NormCourse.Builder localBuilder = new NormCourse.Builder();
        populateFields(localBuilder);
        if (!localBuilder.build(RecordTemplate.Flavor.RECORD).equals(localObject)) {
          return true;
        }
      }
      else
      {
        boolean bool = originalCourse.equals(localObject);
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
    if (course != null)
    {
      localObject = new NormCourse.Builder(normalizeCourse(course));
      populateFields((NormCourse.Builder)localObject);
      localObject = ((NormCourse.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
      return validator.isValid((NormCourse)localObject);
    }
    Object localObject = new NormCourse.Builder();
    populateFields((NormCourse.Builder)localObject);
    localObject = ((NormCourse.Builder)localObject).build(RecordTemplate.Flavor.RECORD);
    return validator.isValid((NormCourse)localObject);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  protected final void optimisticLockingUpdateForm()
  {
    Object localObject = getDataProvider().getCourses();
    if (localObject != null)
    {
      localObject = elements;
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          Course localCourse = (Course)((Iterator)localObject).next();
          if ((course != null) && (course.entityUrn.equals(entityUrn))) {
            setFormData(localCourse);
          }
        }
      }
    }
  }
  
  public final String pageKey()
  {
    if (course == null) {
      return "profile_self_add_course";
    }
    return "profile_self_edit_course";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    course = ProfileCourseEditBundleBuilder.getCourse(getArguments());
    super.setFragmentData(paramBundle);
    viewHolder = ((CourseViewHolder)CourseViewHolder.CREATOR.createViewHolder(formScrollView));
    paramBundle = deleteLink;
    if (course == null) {}
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      ProfileUtil.setLimit(viewHolder.nameEdit, 255);
      ProfileUtil.setLimit(viewHolder.numberEdit, 25);
      paramBundle = new CourseValidator();
      nameTextLayout = courseNameTextLayout;
      numberTextLayout = courseNumberTextLayout;
      validator = paramBundle;
      validator.setActivity(getActivity()).setI18NManager(i18NManager).setProfileUtil(profileUtil).setFormScrollView(formScrollView);
      setFormData(course);
      addEditTextWatchList(new EditText[] { viewHolder.nameEdit, viewHolder.numberEdit });
      addSpinnerWatchList(new Spinner[] { selectOccupationSpinner });
      originalCourse = getNormFormCourse();
      return;
    }
  }
  
  protected final void updateProfileData()
    throws BuilderException
  {
    Object localObject = getNormFormCourse();
    if (course != null) {
      try
      {
        localObject = PegasusPatchGenerator.INSTANCE.diff(course, (RecordTemplate)localObject);
        if ((localObject != null) && (((JSONObject)localObject).length() > 0))
        {
          setDidUpdate$1385ff();
          localObject = new JsonModel((JSONObject)localObject);
          localProfileDataProvider = getDataProvider();
          str1 = busSubscriberId;
          str2 = getRumSessionId();
          str3 = getProfileId();
          str4 = course.entityUrn.getLastId();
          String str5 = getDataProvider().getProfileVersionTag();
          localMap = Tracker.createPageInstanceHeader(getPageInstance());
          str4 = ProfileRoutes.buildEditEntityRoute("normCourses", str3, str4, str5).toString();
          state).coursesRoute = ProfileRoutes.buildCoursesRoute(str3).toString();
          state).allCoursesRoute = state).coursesRoute;
          localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, (RecordTemplate)localObject, Request.get().url(state).coursesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Course.BUILDER, CollectionMetadata.BUILDER))));
          return;
        }
        goBackToPreviousFragment();
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.d(TAG, "Failed to generate diff for update: " + localJSONException.getMessage());
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
    str4 = ProfileRoutes.buildAddEntityRoute("normCourses", str3, str4).toString();
    state).coursesRoute = ProfileRoutes.buildCoursesRoute(str3).toString();
    state).allCoursesRoute = state).coursesRoute;
    localProfileDataProvider.performMultiplexedFetch(str1, str2, localMap, localProfileDataProvider.getPostRequestBuilder(str4, str3, localJSONException, Request.get().url(state).coursesRoute).builder(new CollectionTemplate.CollectionTemplateJsonParser(Course.BUILDER, CollectionMetadata.BUILDER))));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileCourseEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */