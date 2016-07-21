package com.linkedin.android.entities.school.transformers;

import android.widget.ImageView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;

final class SchoolItemsTransformer$1
  extends TrackingClosure<ImageView, Void>
{
  SchoolItemsTransformer$1(Tracker paramTracker, String paramString, MiniSchool paramMiniSchool, FragmentComponent paramFragmentComponent)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.transformers.SchoolItemsTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */