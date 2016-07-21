package com.linkedin.android.infra.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.ButterKnife;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Optional;
import com.squareup.leakcanary.RefWatcher;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.inject.Inject;

public abstract class BaseFragment
  extends Fragment
{
  public ApplicationComponent applicationComponent;
  public FragmentComponent fragmentComponent;
  @Inject
  public I18NManager i18NManager;
  private boolean isResumed;
  private Runnable onResumeRunnable;
  private PermissionRequester.PermissionRequestCallback permissionRequestCallback;
  public PermissionRequester.PermissionRequestCallback permissionRequestListener;
  protected PermissionRequester permissionRequester;
  
  private void handlePermissionsResult(final Set<String> paramSet1, final Set<String> paramSet2)
  {
    if (isResumed)
    {
      onRequestPermissionsResult(paramSet1, paramSet2);
      return;
    }
    onResumeRunnable = new Runnable()
    {
      public final void run()
      {
        onRequestPermissionsResult(paramSet1, paramSet2);
      }
    };
  }
  
  public DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return null;
  }
  
  public final String getLocalizedString(int paramInt)
  {
    return i18NManager.getString(paramInt);
  }
  
  public final String getLocalizedString(int paramInt, Object... paramVarArgs)
  {
    return i18NManager.getString(paramInt, paramVarArgs);
  }
  
  public String getTitle()
  {
    return null;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    BaseActivity localBaseActivity = (BaseActivity)paramActivity;
    paramActivity.getApplication();
    fragmentComponent = FlagshipApplication.fragmentComponent$2dbaac8a(activityComponent, this);
    applicationComponent = ((FlagshipApplication)paramActivity.getApplication()).getAppComponent();
    paramActivity = getDataProvider(activityComponent);
    if (paramActivity != null) {
      paramActivity.register(this);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setHasOptionsMenu(true);
    permissionRequester = new PermissionRequester(this);
    permissionRequestCallback = new PermissionRequester.PermissionRequestCallback()
    {
      public final void permissionsResult(Set<String> paramAnonymousSet1, Set<String> paramAnonymousSet2)
      {
        BaseFragment.this.handlePermissionsResult(paramAnonymousSet1, paramAnonymousSet2);
      }
    };
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    permissionRequestCallback = null;
    Optional localOptional = fragmentComponent.refWatcher();
    if (localOptional.isPresent()) {
      ((RefWatcher)localOptional.get()).watch(this);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    ButterKnife.reset(this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    DataProvider localDataProvider = getDataProvider(getActivityactivityComponent);
    if (localDataProvider != null) {
      localDataProvider.unregister(this);
    }
  }
  
  public void onPause()
  {
    super.onPause();
    isResumed = false;
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    if (!permissionRequester.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt, permissionRequestCallback)) {
      super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    if (permissionRequestListener != null) {
      permissionRequester.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt, permissionRequestListener);
    }
  }
  
  public void onRequestPermissionsResult(Set<String> paramSet1, Set<String> paramSet2) {}
  
  public void onResume()
  {
    super.onResume();
    isResumed = true;
    if (onResumeRunnable != null)
    {
      onResumeRunnable.run();
      onResumeRunnable = null;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ButterKnife.inject(this, paramView);
  }
  
  public final void requestPermission(String paramString, int paramInt1, int paramInt2)
  {
    if (permissionRequester.requestPermissions(new String[] { paramString }, paramInt1, paramInt2)) {
      handlePermissionsResult(new HashSet(Arrays.asList(new String[] { paramString })), Collections.emptySet());
    }
  }
  
  public final void requestPermissions(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    if (permissionRequester.requestPermissions(paramArrayOfString, paramInt1, paramInt2)) {
      handlePermissionsResult(new HashSet(Arrays.asList(paramArrayOfString)), Collections.emptySet());
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.app.BaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */