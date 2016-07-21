package com.linkedin.android.entities.group.transformers;

import android.widget.ImageView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;

final class GroupHighlightsTransformer$2
  extends TrackingClosure<ImageView, Void>
{
  GroupHighlightsTransformer$2(Tracker paramTracker, String paramString, MiniGroup paramMiniGroup, FragmentComponent paramFragmentComponent)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.transformers.GroupHighlightsTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */