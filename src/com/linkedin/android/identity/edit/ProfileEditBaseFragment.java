package com.linkedin.android.identity.edit;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Spinner;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.home.HomeActivity;
import com.linkedin.android.identity.edit.treasury.ProfileTreasuryEditFragment;
import com.linkedin.android.identity.profile.ProfileDataProvider;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.profile.ProfileViewListenerImpl;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.identity.shared.ProfileTypeahead.TypeaheadResultConverter;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Education;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Position;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Profile;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;

public abstract class ProfileEditBaseFragment
  extends PageFragment
  implements OnBackPressedListener
{
  private static final String TAG = ProfileEditBaseFragment.class.getSimpleName();
  ProfileEditBaseFragment.CheckBoxChangeWatcher checkboxChangeWatcher = new ProfileEditBaseFragment.CheckBoxChangeWatcher(this, (byte)0);
  protected DataResponseHandler dataResponseHandler;
  protected boolean didCreate;
  protected boolean didDelete;
  protected boolean didUpdate;
  ProfileEditBaseFragment.EditTextChangeWatcher editTextChangeWatcher = new ProfileEditBaseFragment.EditTextChangeWatcher(this);
  public boolean enableEditSave;
  ViewStub errorViewStub;
  public boolean isSaveButtonVisible = true;
  @Inject
  KeyboardUtil keyboardUtil;
  protected MediaCenter mediaCenter;
  @Inject
  MediaUploader mediaUploader;
  @Inject
  protected MemberUtil memberUtil;
  ProfileEditBaseFragment.MultilineEditTextOnFocusChangeWatcher multilineEditTextOnFocusChangeWatcher = new ProfileEditBaseFragment.MultilineEditTextOnFocusChangeWatcher(this);
  boolean networkErrorHandlingEnabled;
  protected ProfileEditListener profileEditListener;
  public ProfileViewListener profileViewListener;
  private ProgressDialog progressDialog;
  ProfileEditBaseFragment.RadioGroupChangeWatcher radioGroupChangeWatcher = new ProfileEditBaseFragment.RadioGroupChangeWatcher(this, (byte)0);
  ProfileEditBaseFragment.SpinnerChangeWatcher spinnerChangeWatcher = new ProfileEditBaseFragment.SpinnerChangeWatcher(this, (byte)0);
  @InjectView(2131755468)
  Toolbar toolbar;
  ProfileEditBaseFragment.VisibilityChangeWatcher visibilityChangeWatcher = new ProfileEditBaseFragment.VisibilityChangeWatcher(this, (byte)0);
  
  protected static boolean checkResponseMapStatus(Map<String, DataStoreResponse> paramMap)
  {
    boolean bool = true;
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext())
    {
      DataStoreResponse localDataStoreResponse = (DataStoreResponse)paramMap.next();
      if (((statusCode >= 400) || (statusCode >= 500)) && (!"GET".equals(request.method))) {
        bool = false;
      }
    }
    return bool;
  }
  
  protected final void addEditTextDoneListener(EditText paramEditText, String paramString)
  {
    paramEditText.setOnEditorActionListener(new ProfileEditBaseFragment.5(this, paramString));
  }
  
  protected final void addEditTextWatchList(List<EditText> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      ((EditText)paramList.next()).addTextChangedListener(editTextChangeWatcher);
    }
  }
  
  protected final void addEditTextWatchList(EditText... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].addTextChangedListener(editTextChangeWatcher);
      i += 1;
    }
  }
  
  protected final void addMultilineEditTextOnFocusChangeWatchList(EditText... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setOnFocusChangeListener(multilineEditTextOnFocusChangeWatcher);
      i += 1;
    }
  }
  
  protected final void addNewEducation()
  {
    if (profileViewListener != null)
    {
      ProfileEditFragmentUtils.startAddEducation(profileViewListener, true, fragmentComponent);
      return;
    }
    ProfileEditFragmentUtils.startAddEducation(profileEditListener, true);
  }
  
  protected final void addNewPosition()
  {
    if (profileViewListener != null)
    {
      ProfileEditFragmentUtils.startAddPosition(profileViewListener, true, fragmentComponent);
      return;
    }
    ProfileEditFragmentUtils.startAddPosition(profileEditListener, true);
  }
  
  protected final void addSpinnerWatchList(Spinner... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setOnItemSelectedListener(spinnerChangeWatcher);
      i += 1;
    }
  }
  
  protected void addTrackedListeners() {}
  
  protected void createMenu()
  {
    toolbar.getMenu().clear();
    toolbar.inflateMenu(2131820553);
    toolbar.getMenu().findItem(2131758751).setEnabled(enableEditSave);
    toolbar.setOnMenuItemClickListener(new ProfileEditBaseFragment.3(this));
    updateOptionsMenu();
  }
  
  public final void dismissSubmitProgressDialog()
  {
    if (progressDialog != null) {
      progressDialog.dismiss();
    }
  }
  
  public void doResume()
  {
    super.doResume();
    if ((BaseActivity)getActivity() != null)
    {
      toolbar.setNavigationOnClickListener(new ProfileEditBaseFragment.2(this, getActivityactivityComponent.tracker(), getCancelTrackingControlName(), new TrackingEventBuilder[0]));
      toolbar.setTitle(getTitle());
    }
  }
  
  public boolean enableProgressDialogOnUpdate()
  {
    return true;
  }
  
  protected final ActivityComponent getActivityComponent()
  {
    BaseActivity localBaseActivity = (BaseActivity)getActivity();
    if (localBaseActivity != null) {
      return activityComponent;
    }
    return null;
  }
  
  public String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  public abstract int getContentViewId();
  
  public abstract int getContentViewResourceId();
  
  public final ProfileDataProvider getDataProvider()
  {
    return fragmentComponent.activity().activityComponent.profileDataProvider();
  }
  
  protected final List<Education> getEducations()
  {
    ArrayList localArrayList = new ArrayList();
    CollectionTemplate localCollectionTemplate = getDataProvider().getEducationsForBackgroundDetail();
    Object localObject = localArrayList;
    if (localCollectionTemplate != null)
    {
      localObject = localArrayList;
      if (elements != null) {
        localObject = elements;
      }
    }
    return (List<Education>)localObject;
  }
  
  public abstract int getOptimisticLockingDeleteMessage();
  
  protected final List<Position> getPositions()
  {
    ArrayList localArrayList = new ArrayList();
    CollectionTemplate localCollectionTemplate = getDataProvider().getPositionsForBackgroundDetail();
    Object localObject = localArrayList;
    if (localCollectionTemplate != null)
    {
      localObject = localArrayList;
      if (elements != null) {
        localObject = elements;
      }
    }
    return (List<Position>)localObject;
  }
  
  protected final Profile getProfile()
  {
    if (getDataProvider().isDataAvailable()) {
      return getDataProvider().getProfileModel();
    }
    return null;
  }
  
  public final String getProfileId()
  {
    ActivityComponent localActivityComponent = getActivityComponent();
    if (localActivityComponent != null) {
      return localActivityComponent.memberUtil().getProfileId();
    }
    return "";
  }
  
  public String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final void goBack()
  {
    if (isFormModified())
    {
      new AlertDialog.Builder(getActivity()).setMessage(2131232726).setPositiveButton(2131232724, null).setNegativeButton(2131232725, new ProfileEditBaseFragment.4(this)).setIcon$38a3bc68().show();
      return;
    }
    goBackToPreviousFragment();
  }
  
  public void goBackToPreviousFragment()
  {
    if (getActivity() != null)
    {
      View localView = getActivity().getCurrentFocus();
      if (localView != null)
      {
        InputMethodManager localInputMethodManager = KeyboardUtil.fetchKeyboard(localView.getContext());
        if (localInputMethodManager != null) {
          localInputMethodManager.hideSoftInputFromWindow(localView.getWindowToken(), 0);
        }
      }
    }
    profileEditListener.onExitEdit();
  }
  
  public abstract void initializeFields()
    throws BuilderException;
  
  protected final void initializeFieldsWithDataProvider()
  {
    try
    {
      initializeFields();
      addTrackedListeners();
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Util.safeThrow(new RuntimeException("Failed to initialize fields: " + localBuilderException.getMessage()));
      }
    }
  }
  
  public abstract boolean isFormModified();
  
  public abstract boolean isFormValid()
    throws BuilderException;
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 != -1) {}
    do
    {
      for (;;)
      {
        return;
        if (paramInt1 != 43) {
          break;
        }
        if (paramIntent == null) {}
        for (paramIntent = null; paramIntent != null; paramIntent = paramIntent.getData())
        {
          ProfileViewListener localProfileViewListener = profileViewListener;
          ProfileTreasuryEditBundleBuilder localProfileTreasuryEditBundleBuilder = new ProfileTreasuryEditBundleBuilder();
          bundle.putParcelable("treasuryUri", paramIntent);
          localProfileViewListener.startEditFragment(ProfileTreasuryEditFragment.newInstance(localProfileTreasuryEditBundleBuilder));
          return;
        }
      }
    } while (!(this instanceof ProfileEditBaseFragment.TypeaheadListener));
    paramIntent = paramIntent.getExtras();
    ((ProfileEditBaseFragment.TypeaheadListener)this).handleTypeaheadResult(fromRequestIdconverter.getResult(paramIntent));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((getParentFragment() instanceof ProfileEditListener))
    {
      profileEditListener = ((ProfileEditListener)getParentFragment());
      return;
    }
    if ((paramActivity instanceof ProfileEditListener))
    {
      profileEditListener = ((ProfileEditListener)getActivity());
      return;
    }
    if ((paramActivity instanceof HomeActivity))
    {
      profileViewListener = new ProfileViewListenerImpl((BaseActivity)getActivity());
      profileEditListener = profileViewListener;
      return;
    }
    throw new IllegalStateException("Activity must implement ProfileEditListener");
  }
  
  public final boolean onBackPressed()
  {
    sendCustomShortPressTrackingEvent(getCancelTrackingControlName());
    goBack();
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if ((paramBundle != null) && (!getDataProvider().isDataAvailable())) {
      getDataProvider().loadProfileFromCache(busSubscriberId, getRumSessionId(), getProfileId());
    }
    paramLayoutInflater = paramLayoutInflater.inflate(getContentViewResourceId(), paramViewGroup, false);
    paramLayoutInflater.setMinimumHeight(getResourcesgetDisplayMetricsheightPixels);
    paramLayoutInflater.setFocusable(true);
    paramLayoutInflater.setFocusableInTouchMode(true);
    return paramLayoutInflater;
  }
  
  protected void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    paramDataManagerException = dataResponseHandler;
    if (paramType == DataStore.Type.NETWORK)
    {
      if (!paramSet.isEmpty()) {
        break label155;
      }
      profileEditBaseFragment.dismissSubmitProgressDialog();
      paramType = profileEditBaseFragment;
      if ((paramType.getView() != null) && (errorViewStub != null) && (paramType.getContentViewId() > 0))
      {
        paramType.getActivity().findViewById(paramType.getContentViewId()).setVisibility(8);
        paramSet = new ErrorPageViewModel(errorViewStub);
        paramDataManagerException = (ErrorPageViewHolder)paramSet.getCreator().createViewHolder(paramType.getView());
        errorDescriptionText = i18NManager.getString(2131233325);
        errorImage = 2130838622;
        LayoutInflater localLayoutInflater = paramType.getActivity().getLayoutInflater();
        applicationComponent.mediaCenter();
        paramSet.onBindViewHolderWithErrorTracking$18b8048(localLayoutInflater, paramDataManagerException, tracker, paramType.getPageInstance());
      }
    }
    return;
    label155:
    profileEditBaseFragment.onFormSubmitFailure();
  }
  
  public void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    dataResponseHandler.handleOnDataReady(paramType, paramSet, paramMap);
  }
  
  public void onFormSubmitFailure()
  {
    dismissSubmitProgressDialog();
    new AlertDialog.Builder(getActivity()).setTitle(2131232575).setPositiveButton(2131232576, new ProfileEditBaseFragment.1(this)).show();
  }
  
  public void onFormSubmitSuccess()
  {
    dismissSubmitProgressDialog();
    goBackToPreviousFragment();
  }
  
  protected boolean onMenuClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131758751)
    {
      if (isAdded())
      {
        onToolbarSaveClick();
        sendCustomShortPressTrackingEvent(getSaveTrackingControlName());
      }
      return true;
    }
    return false;
  }
  
  public void onStop()
  {
    super.onStop();
    toolbar.setNavigationOnClickListener(null);
  }
  
  public final void onToolbarSaveClick()
  {
    try
    {
      if (isFormValid())
      {
        if (enableProgressDialogOnUpdate())
        {
          FragmentActivity localFragmentActivity = getActivity();
          if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing())) {
            progressDialog = ProgressDialog.show(localFragmentActivity, "", getString(2131232577));
          }
        }
        updateProfileData();
      }
      return;
    }
    catch (BuilderException localBuilderException)
    {
      Util.safeThrow(new RuntimeException("Failed to update profile: " + localBuilderException.getMessage()));
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    errorViewStub = ((ViewStub)paramView.findViewById(2131756773));
    networkErrorHandlingEnabled = "enabled".equals(fragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_NETWORK_ERROR_HANDLING));
    dataResponseHandler = new DataResponseHandler(this, (BaseActivity)getActivity());
    mediaCenter = applicationComponent.mediaCenter();
    for (;;)
    {
      try
      {
        setFragmentData(paramBundle);
        if (getDataProvider().isDataAvailable())
        {
          paramView = getDataProvider();
          if ((paramView.isDataAvailable()) && (((ProfileState)state).allPositions() != null) && (((ProfileState)state).allEducations() != null))
          {
            i = 1;
            if (i != 0) {
              break label212;
            }
          }
        }
        else
        {
          paramView = getActivityComponent().memberUtil().getProfileId();
          if (!TextUtils.isEmpty(paramView)) {
            getDataProvider().fetchProfileOnlyData(busSubscriberId, getRumSessionId(), paramView, Tracker.createPageInstanceHeader(getPageInstance()));
          }
          createMenu();
          return;
        }
      }
      catch (BuilderException paramView)
      {
        getActivity();
        Util.safeThrow$7a8b4789(new RuntimeException("Failed to set fragment data", paramView));
        return;
      }
      int i = 0;
      continue;
      label212:
      initializeFieldsWithDataProvider();
    }
  }
  
  public abstract void optimisticLockingUpdateForm();
  
  protected final void resetFormActionFlags()
  {
    didCreate = false;
    didDelete = false;
    didUpdate = false;
  }
  
  protected final void sendCustomShortPressTrackingEvent(String paramString)
  {
    ProfileUtil.sendCustomShortPressTrackingEvent(paramString, fragmentComponent);
  }
  
  protected final void setDidCreate$1385ff()
  {
    didCreate = true;
  }
  
  protected final void setDidDelete$1385ff()
  {
    didDelete = true;
  }
  
  protected final void setDidUpdate$1385ff()
  {
    didUpdate = true;
  }
  
  public final void setEditSaveMenuItemEnabled(boolean paramBoolean)
  {
    if (enableEditSave != paramBoolean)
    {
      enableEditSave = paramBoolean;
      updateOptionsMenu();
    }
  }
  
  public void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    refreshRUMSessionId();
  }
  
  public final void showConfirmDeleteDialog(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    new AlertDialog.Builder(getActivity()).setMessage(paramInt).setPositiveButton(2131232268, paramOnClickListener).setNegativeButton(2131232267, null).setIcon$38a3bc68().show();
  }
  
  public final void updateOptionsMenu()
  {
    if (toolbar == null) {}
    MenuItem localMenuItem;
    do
    {
      return;
      localMenuItem = toolbar.getMenu().findItem(2131758751);
    } while (localMenuItem == null);
    if (!isSaveButtonVisible)
    {
      localMenuItem.setVisible(false);
      return;
    }
    localMenuItem.setEnabled(enableEditSave);
  }
  
  public abstract void updateProfileData()
    throws BuilderException;
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileEditBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */