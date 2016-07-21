package com.linkedin.android.entities;

import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

final class EntityTransformer$1
  extends TrackingClosure<Boolean, Void>
{
  EntityTransformer$1(Tracker paramTracker, String paramString, ActivityComponent paramActivityComponent, MiniProfile paramMiniProfile)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */