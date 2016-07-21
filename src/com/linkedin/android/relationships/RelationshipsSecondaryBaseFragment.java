package com.linkedin.android.relationships;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import butterknife.InjectView;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public abstract class RelationshipsSecondaryBaseFragment
  extends PageFragment
{
  @InjectView(2131755468)
  protected Toolbar toolbar;
  
  public abstract int getTitleRes();
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    int i = getTitleRes();
    if (i != 0) {
      toolbar.setTitle(i);
    }
    toolbar.setNavigationOnClickListener(new RelationshipsSecondaryBaseFragment.1(this, tracker, "close", new TrackingEventBuilder[0]));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.RelationshipsSecondaryBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */