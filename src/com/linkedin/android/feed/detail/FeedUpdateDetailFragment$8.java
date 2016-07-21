package com.linkedin.android.feed.detail;

import android.content.Intent;
import android.os.Bundle;
import com.linkedin.android.feed.actions.ControlMenuBundleBuilder;
import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.actions.UpdateActionPublisher.DeleteUpdateActionListener;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class FeedUpdateDetailFragment$8
  implements UpdateActionPublisher.DeleteUpdateActionListener
{
  FeedUpdateDetailFragment$8(FeedUpdateDetailFragment paramFeedUpdateDetailFragment, FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel) {}
  
  public final void onDeleteUpdateAction()
  {
    UpdateActionPublisher.publishUpdateAction(Tracker.createPageInstanceHeader(this$0.getPageInstance()), val$fragmentComponent, val$update.urn.toString(), val$updateAction, val$update);
    Intent localIntent = new Intent();
    Bundle localBundle = new ControlMenuBundleBuilder(val$update.urn.toString()).build();
    localBundle.putString("viralUpdateUrn", FeedUpdateDetailFragment.access$2200(this$0));
    localIntent.putExtras(localBundle);
    val$fragmentComponent.activity().setResult(-1, localIntent);
    val$fragmentComponent.activity().finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.FeedUpdateDetailFragment.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */