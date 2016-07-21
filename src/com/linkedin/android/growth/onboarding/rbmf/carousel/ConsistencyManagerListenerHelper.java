package com.linkedin.android.growth.onboarding.rbmf.carousel;

import android.support.v4.util.ArrayMap;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.consistency.ConsistencyManager;
import com.linkedin.consistency.ConsistencyManagerListener;
import java.util.Map;

@Deprecated
public final class ConsistencyManagerListenerHelper
{
  public ConsistencyManager consistencyManager;
  public Map<Urn, ConsistencyManagerListener> listeners = new ArrayMap();
  
  public ConsistencyManagerListenerHelper(ConsistencyManager paramConsistencyManager)
  {
    consistencyManager = paramConsistencyManager;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.rbmf.carousel.ConsistencyManagerListenerHelper
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */