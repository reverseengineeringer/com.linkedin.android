package com.linkedin.android.feed.actorlist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.feed.actorlist.connectionsdetail.FeedConnectionUpdatesDetailFragmentFactory;
import com.linkedin.android.feed.actorlist.pymkdetail.FeedPymkUpdatesDetailFragmentFactory;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.Util;

public class FeedActorListActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968943);
    paramBundle = getSupportFragmentManager().findFragmentById(16908290);
    Object localObject = getIntent().getExtras();
    int i;
    FeedActorListBundleBuilder localFeedActorListBundleBuilder;
    if (localObject == null)
    {
      i = 0;
      if (paramBundle == null)
      {
        localObject = activityComponent.fragmentRegistry();
        localFeedActorListBundleBuilder = new FeedActorListBundleBuilder(getIntent().getExtras());
        if (i != 1) {
          break label112;
        }
        paramBundle = connectionUpdates.newFragment(localFeedActorListBundleBuilder);
      }
    }
    for (;;)
    {
      if (paramBundle == null) {
        break label130;
      }
      getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
      return;
      i = ((Bundle)localObject).getInt("listType");
      break;
      label112:
      if (i == 2) {
        paramBundle = pymkUpdates.newFragment(localFeedActorListBundleBuilder);
      }
    }
    label130:
    Util.safeThrow$7a8b4789(new RuntimeException("trying to open an unknown list detail page!"));
    finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actorlist.FeedActorListActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */