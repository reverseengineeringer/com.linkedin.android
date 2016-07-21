package com.linkedin.android.entities.group.transformers;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import com.linkedin.android.entities.group.GroupUpdatesBundleBuilder;
import com.linkedin.android.entities.group.controllers.GroupUpdatesFragment;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.group.BasicGroupInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.group.Group;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class GroupHighlightsTransformer$1
  extends TrackingOnClickListener
{
  public GroupHighlightsTransformer$1(Tracker paramTracker, String paramString, TrackingEventBuilder[] paramArrayOfTrackingEventBuilder, FragmentComponent paramFragmentComponent, Group paramVarArgs)
  {
    super(paramTracker, paramString, paramArrayOfTrackingEventBuilder);
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = val$fragmentComponent.activity().getPageFragmentTransaction();
    String str1 = val$group.basicGroupInfo.miniGroup.entityUrn.getId();
    String str2 = val$group.basicGroupInfo.miniGroup.groupName;
    Bundle localBundle = new Bundle();
    localBundle.putString("groupId", str1);
    localBundle.putString("groupName", str2);
    paramView.replace(2131756509, GroupUpdatesFragment.newInstance(new GroupUpdatesBundleBuilder(localBundle))).addToBackStack(null).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */