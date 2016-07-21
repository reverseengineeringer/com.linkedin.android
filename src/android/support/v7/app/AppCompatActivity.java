package android.support.v7.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.app.TaskStackBuilder.SupportParentable;
import android.support.v4.view.KeyEventCompat;
import android.support.v7.view.ActionMode;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.VectorEnabledTintResources;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity
  extends FragmentActivity
  implements TaskStackBuilder.SupportParentable, AppCompatCallback
{
  private AppCompatDelegate mDelegate;
  private boolean mEatKeyUpEvent;
  private Resources mResources;
  private int mThemeId = 0;
  
  public void addContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().addContentView(paramView, paramLayoutParams);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    if ((KeyEventCompat.hasModifiers(paramKeyEvent, 4096)) && (paramKeyEvent.getUnicodeChar(paramKeyEvent.getMetaState() & 0x8FFF) == 60))
    {
      int i = paramKeyEvent.getAction();
      if (i == 0)
      {
        ActionBar localActionBar = getSupportActionBar();
        if ((localActionBar != null) && (localActionBar.isShowing()) && (localActionBar.requestFocus()))
        {
          mEatKeyUpEvent = true;
          return true;
        }
      }
      else if ((i == 1) && (mEatKeyUpEvent))
      {
        mEatKeyUpEvent = false;
        return true;
      }
    }
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  public View findViewById(int paramInt)
  {
    return getDelegate().findViewById(paramInt);
  }
  
  public AppCompatDelegate getDelegate()
  {
    if (mDelegate == null) {
      mDelegate = AppCompatDelegate.create(this, this);
    }
    return mDelegate;
  }
  
  public ActionBarDrawerToggle.Delegate getDrawerToggleDelegate()
  {
    return getDelegate().getDrawerToggleDelegate();
  }
  
  public MenuInflater getMenuInflater()
  {
    return getDelegate().getMenuInflater();
  }
  
  public Resources getResources()
  {
    if ((mResources == null) && (VectorEnabledTintResources.shouldBeUsed())) {
      mResources = new VectorEnabledTintResources(this, super.getResources());
    }
    if (mResources == null) {
      return super.getResources();
    }
    return mResources;
  }
  
  public ActionBar getSupportActionBar()
  {
    return getDelegate().getSupportActionBar();
  }
  
  public Intent getSupportParentActivityIntent()
  {
    return NavUtils.getParentActivityIntent(this);
  }
  
  public void invalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    getDelegate().onConfigurationChanged(paramConfiguration);
    if (mResources != null)
    {
      DisplayMetrics localDisplayMetrics = super.getResources().getDisplayMetrics();
      mResources.updateConfiguration(paramConfiguration, localDisplayMetrics);
    }
  }
  
  public void onContentChanged()
  {
    onSupportContentChanged();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppCompatDelegate localAppCompatDelegate = getDelegate();
    localAppCompatDelegate.installViewFactory();
    localAppCompatDelegate.onCreate(paramBundle);
    if ((localAppCompatDelegate.applyDayNight()) && (mThemeId != 0))
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label55;
      }
      onApplyThemeResource(getTheme(), mThemeId, false);
    }
    for (;;)
    {
      super.onCreate(paramBundle);
      return;
      label55:
      setTheme(mThemeId);
    }
  }
  
  public void onCreateSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder)
  {
    Intent localIntent = null;
    if ((this instanceof TaskStackBuilder.SupportParentable)) {
      localIntent = ((TaskStackBuilder.SupportParentable)this).getSupportParentActivityIntent();
    }
    if (localIntent == null) {
      localIntent = NavUtils.getParentActivityIntent(this);
    }
    for (;;)
    {
      if (localIntent != null)
      {
        ComponentName localComponentName2 = localIntent.getComponent();
        ComponentName localComponentName1 = localComponentName2;
        if (localComponentName2 == null) {
          localComponentName1 = localIntent.resolveActivity(mSourceContext.getPackageManager());
        }
        paramTaskStackBuilder.addParentStack(localComponentName1);
        paramTaskStackBuilder.addNextIntent(localIntent);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    getDelegate().onDestroy();
  }
  
  public final boolean onMenuItemSelected(int paramInt, MenuItem paramMenuItem)
  {
    if (super.onMenuItemSelected(paramInt, paramMenuItem)) {
      return true;
    }
    ActionBar localActionBar = getSupportActionBar();
    if ((paramMenuItem.getItemId() == 16908332) && (localActionBar != null) && ((localActionBar.getDisplayOptions() & 0x4) != 0)) {
      return onSupportNavigateUp();
    }
    return false;
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    return super.onMenuOpened(paramInt, paramMenu);
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
  }
  
  protected void onPostCreate(Bundle paramBundle)
  {
    super.onPostCreate(paramBundle);
    getDelegate().onPostCreate$79e5e33f();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    getDelegate().onPostResume();
  }
  
  public void onPrepareSupportNavigateUpTaskStack(TaskStackBuilder paramTaskStackBuilder) {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    getDelegate().onSaveInstanceState(paramBundle);
  }
  
  protected void onStop()
  {
    super.onStop();
    getDelegate().onStop();
  }
  
  public void onSupportActionModeFinished(ActionMode paramActionMode) {}
  
  public void onSupportActionModeStarted(ActionMode paramActionMode) {}
  
  @Deprecated
  public void onSupportContentChanged() {}
  
  public boolean onSupportNavigateUp()
  {
    Object localObject = getSupportParentActivityIntent();
    if (localObject != null)
    {
      if (supportShouldUpRecreateTask((Intent)localObject))
      {
        localObject = TaskStackBuilder.create(this);
        onCreateSupportNavigateUpTaskStack((TaskStackBuilder)localObject);
        onPrepareSupportNavigateUpTaskStack((TaskStackBuilder)localObject);
        ((TaskStackBuilder)localObject).startActivities();
        try
        {
          if (Build.VERSION.SDK_INT >= 16) {
            finishAffinity();
          } else {
            finish();
          }
        }
        catch (IllegalStateException localIllegalStateException)
        {
          finish();
        }
      }
      supportNavigateUpTo(localIllegalStateException);
    }
    else
    {
      return false;
    }
    return true;
  }
  
  protected void onTitleChanged(CharSequence paramCharSequence, int paramInt)
  {
    super.onTitleChanged(paramCharSequence, paramInt);
    getDelegate().setTitle(paramCharSequence);
  }
  
  public ActionMode onWindowStartingSupportActionMode(ActionMode.Callback paramCallback)
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    getDelegate().setContentView(paramInt);
  }
  
  public void setContentView(View paramView)
  {
    getDelegate().setContentView(paramView);
  }
  
  public void setContentView(View paramView, ViewGroup.LayoutParams paramLayoutParams)
  {
    getDelegate().setContentView(paramView, paramLayoutParams);
  }
  
  public void setSupportActionBar(Toolbar paramToolbar)
  {
    getDelegate().setSupportActionBar(paramToolbar);
  }
  
  @Deprecated
  public void setSupportProgress(int paramInt) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminate(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarIndeterminateVisibility(boolean paramBoolean) {}
  
  @Deprecated
  public void setSupportProgressBarVisibility(boolean paramBoolean) {}
  
  public void setTheme(int paramInt)
  {
    super.setTheme(paramInt);
    mThemeId = paramInt;
  }
  
  public ActionMode startSupportActionMode(ActionMode.Callback paramCallback)
  {
    return getDelegate().startSupportActionMode(paramCallback);
  }
  
  public void supportInvalidateOptionsMenu()
  {
    getDelegate().invalidateOptionsMenu();
  }
  
  public void supportNavigateUpTo(Intent paramIntent)
  {
    NavUtils.navigateUpTo(this, paramIntent);
  }
  
  public boolean supportRequestWindowFeature(int paramInt)
  {
    return getDelegate().requestWindowFeature(paramInt);
  }
  
  public boolean supportShouldUpRecreateTask(Intent paramIntent)
  {
    return NavUtils.shouldUpRecreateTask(this, paramIntent);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.AppCompatActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */