package com.linkedin.android.search.resourcelist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import com.linkedin.android.infra.app.BaseActivity;

public class ResourceListActivity
  extends BaseActivity
{
  private static final String TAG = ResourceListActivity.class.getSimpleName();
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130969388);
    if (paramBundle == null)
    {
      Bundle localBundle = getIntent().getExtras();
      int i = ResourceListBundleBuilder.getType(localBundle);
      paramBundle = null;
      if (i == 1)
      {
        paramBundle = new IndustryListFragment();
        paramBundle.setArguments(localBundle);
      }
      if (paramBundle != null) {
        getSupportFragmentManager().beginTransaction().replace(2131758463, paramBundle, null).commit();
      }
    }
    else
    {
      return;
    }
    Log.e(TAG, "unsupported ResourceListActivity type");
    finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.resourcelist.ResourceListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */