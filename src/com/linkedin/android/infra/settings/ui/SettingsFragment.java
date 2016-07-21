package com.linkedin.android.infra.settings.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.settings.SettingsAdapter;
import com.linkedin.android.infra.settings.SettingsTransformerHelper;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.ui.ViewPager;

public class SettingsFragment
  extends PageFragment
  implements OnBackPressedListener
{
  @InjectView(2131758572)
  TabLayout tabLayout;
  @InjectView(2131758580)
  Toolbar toolbar;
  @InjectView(2131758573)
  ViewPager viewPager;
  
  private void extractData(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("settingsTabType", 0);
      paramBundle = paramBundle.getString("settingsType");
      viewPager.setCurrentItem(i);
      if (paramBundle != null)
      {
        Resources localResources = getResources();
        ApplicationComponent localApplicationComponent = applicationComponent;
        FragmentComponent localFragmentComponent = fragmentComponent;
        if (paramBundle.equalsIgnoreCase("email_management")) {
          SettingsTransformerHelper.openUrlInApp(SettingsTransformerHelper.getFullUrl("/psettings/email", localApplicationComponent), localResources.getString(2131233598), "email_management", localFragmentComponent);
        }
      }
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean onBackPressed()
  {
    return fragmentComponent.activity().getFragmentManager().popBackStackImmediate();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969417, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    if (toolbar != null)
    {
      toolbar.setTitle(getResources().getString(2131233647));
      toolbar.setNavigationOnClickListener(new SettingsFragment.1(this));
    }
    if (tabLayout != null) {
      tabLayout.setTabTextColors(getResources().getColor(2131624081), getResources().getColor(2131623940));
    }
    paramView = new SettingsAdapter(fragmentComponent, getChildFragmentManager(), applicationComponent);
    viewPager.setAdapter(paramView);
    tabLayout.setTabsFromPagerAdapter(paramView);
    tabLayout.setHorizontalScrollBarEnabled(true);
    tabLayout.setFillViewport(false);
    tabLayout.setTabMode(0);
    if (ViewCompat.isLaidOut(tabLayout)) {
      tabLayout.setupWithViewPager(viewPager);
    }
    for (;;)
    {
      extractData(paramBundle);
      paramView = ((BaseActivity)getActivity()).getIntent();
      if (paramView != null) {
        extractData(paramView.getExtras());
      }
      return;
      tabLayout.addOnLayoutChangeListener(new SettingsFragment.2(this));
    }
  }
  
  public final String pageKey()
  {
    return "settings";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.settings.ui.SettingsFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */