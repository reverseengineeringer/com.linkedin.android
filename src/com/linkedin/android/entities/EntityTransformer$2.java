package com.linkedin.android.entities;

import android.widget.ImageView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

final class EntityTransformer$2
  extends TrackingClosure<ImageView, Void>
{
  EntityTransformer$2(Tracker paramTracker, String paramString, boolean paramBoolean, FragmentComponent paramFragmentComponent, MiniProfile paramMiniProfile)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityTransformer.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */