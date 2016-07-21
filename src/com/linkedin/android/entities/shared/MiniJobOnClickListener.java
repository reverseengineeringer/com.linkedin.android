package com.linkedin.android.entities.shared;

import android.os.Bundle;
import android.view.View;
import com.linkedin.android.entities.job.JobBundleBuilder;
import com.linkedin.android.entities.job.JobIntent;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class MiniJobOnClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  public boolean fromPromo;
  private final MiniJob miniJob;
  
  public MiniJobOnClickListener(MiniJob paramMiniJob, FragmentComponent paramFragmentComponent, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    miniJob = paramMiniJob;
    fragmentComponent = paramFragmentComponent;
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = fragmentComponent.activity();
    JobBundleBuilder localJobBundleBuilder = JobBundleBuilder.create(miniJob);
    if (fromPromo) {
      bundle.putBoolean("fromPromo", true);
    }
    paramView.startActivity(fragmentComponent.intentRegistry().job.newIntent(paramView, localJobBundleBuilder));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.shared.MiniJobOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */