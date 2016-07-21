package com.linkedin.android.feed.aggregate;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class AggregateBundle
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public AggregateBundle(Update paramUpdate)
  {
    RecordParceler.quietParcel(paramUpdate, "update", bundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.aggregate.AggregateBundle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */