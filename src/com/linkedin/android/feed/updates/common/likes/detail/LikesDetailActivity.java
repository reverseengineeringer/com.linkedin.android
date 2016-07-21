package com.linkedin.android.feed.updates.common.likes.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.Util;

public class LikesDetailActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968758);
    paramBundle = getSupportFragmentManager().findFragmentById(2131755822);
    String str = LikesDetailBundleBuilder.getUpdateUrnString(getIntent().getExtras());
    if (paramBundle == null)
    {
      if (str != null)
      {
        paramBundle = activityComponent.fragmentRegistry().feedLikesDetail.newFragment(new LikesDetailBundleBuilder(getIntent().getExtras()));
        getSupportFragmentManager().beginTransaction().add(2131755822, paramBundle).commit();
      }
    }
    else {
      return;
    }
    Util.safeThrow$7a8b4789(new RuntimeException("can't open likes detail without an update urn!"));
    finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */