package com.linkedin.android.identity.profile.view.connections;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class ConnectionsContainerFragmentBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle = new Bundle();
  
  public static ConnectionsContainerFragmentBundleBuilder create(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ConnectionsContainerFragmentBundleBuilder localConnectionsContainerFragmentBundleBuilder = new ConnectionsContainerFragmentBundleBuilder();
    bundle.putString("profileId", paramString1);
    bundle.putString("toolbarTitle", paramString2);
    bundle.putInt("tabDisplayMode", paramInt1);
    bundle.putInt("activeTab", paramInt2);
    bundle.putInt("allConnectionsCount", paramInt3);
    bundle.putInt("commonConnectionsCount", paramInt4);
    return localConnectionsContainerFragmentBundleBuilder;
  }
  
  public static String getProfileId(Bundle paramBundle)
  {
    return paramBundle.getString("profileId", "");
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.view.connections.ConnectionsContainerFragmentBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */