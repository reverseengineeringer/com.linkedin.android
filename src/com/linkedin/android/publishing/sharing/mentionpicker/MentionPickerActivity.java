package com.linkedin.android.publishing.sharing.mentionpicker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.app.BaseActivity;

public class MentionPickerActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      return;
    }
    paramBundle = getIntent().getExtras();
    MentionPickerFragment localMentionPickerFragment = new MentionPickerFragment();
    localMentionPickerFragment.setArguments(paramBundle);
    getSupportFragmentManager().beginTransaction().add(16908290, localMentionPickerFragment).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */