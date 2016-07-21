package com.linkedin.android.entities.job.transformers;

import android.widget.ImageView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Job;

final class JobTransformer$1
  extends TrackingClosure<ImageView, Void>
{
  JobTransformer$1(Tracker paramTracker, String paramString, Job paramJob, FragmentComponent paramFragmentComponent)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */