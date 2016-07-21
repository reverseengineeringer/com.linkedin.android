package com.linkedin.android.publishing.sharing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.shared.OnBackPressedListener;

public class ShareActivity
  extends BaseActivity
{
  private ShareFragment shareFragment;
  
  public void onBackPressed()
  {
    Fragment localFragment;
    if (shareFragment != null)
    {
      localFragment = shareFragment.viewPagerAdapter.currentPrimaryItem;
      if (!(localFragment instanceof OnBackPressedListener)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = ((OnBackPressedListener)localFragment).onBackPressed();; bool = false)
    {
      if (!bool) {
        super.onBackPressed();
      }
      return;
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969431);
    shareFragment = ((ShareFragment)getSupportFragmentManager().findFragmentById(2131758609));
    if (shareFragment == null)
    {
      shareFragment = new ShareFragment();
      shareFragment.setArguments(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().add(2131758609, shareFragment).commit();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.ShareActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */