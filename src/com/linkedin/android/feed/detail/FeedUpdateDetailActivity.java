package com.linkedin.android.feed.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.feed.updates.common.comment.detail.CommentDetailFragment;
import com.linkedin.android.infra.app.BaseActivity;

public class FeedUpdateDetailActivity
  extends BaseActivity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968742);
    paramBundle = getSupportFragmentManager().findFragmentById(2131755759);
    int i = FeedUpdateDetailBundleBuilder.getFeedType(getIntent().getExtras());
    if (paramBundle == null) {
      if (i != 13) {
        break label79;
      }
    }
    label79:
    for (paramBundle = new CommentDetailFragment();; paramBundle = new FeedUpdateDetailFragment())
    {
      paramBundle.setArguments(getIntent().getExtras());
      getSupportFragmentManager().beginTransaction().replace(2131755759, paramBundle).commit();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */