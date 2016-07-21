package com.linkedin.messengerlib.shared;

import android.os.Bundle;

public class ToolbarBaseBundleBuilder
  extends BaseBundleBuilder
{
  public static int getToolbarLayoutResourceId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return -1;
    }
    return paramBundle.getInt("TOOLBAR_LAYOUT_RESOURCE_ID");
  }
  
  public static String getToolbarTitle(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return "";
    }
    return paramBundle.getString("TOOLBAR_TITLE");
  }
  
  public final ToolbarBaseBundleBuilder setToolbarLayoutResourceId(int paramInt)
  {
    bundle.putInt("TOOLBAR_LAYOUT_RESOURCE_ID", paramInt);
    return this;
  }
  
  public final ToolbarBaseBundleBuilder setToolbarTitle(String paramString)
  {
    bundle.putString("TOOLBAR_TITLE", paramString);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.shared.ToolbarBaseBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */