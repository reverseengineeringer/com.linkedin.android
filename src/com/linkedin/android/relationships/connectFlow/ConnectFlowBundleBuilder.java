package com.linkedin.android.relationships.connectFlow;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class ConnectFlowBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public ConnectFlowBundleBuilder(String paramString, int paramInt)
  {
    bundle.putString("key_profile_id", paramString);
    bundle.putInt("key_connect_action", paramInt);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.relationships.connectFlow.ConnectFlowBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */