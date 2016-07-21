package com.linkedin.android.feed.actions;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class ControlMenuBundleBuilder
  implements BundleBuilder
{
  protected final Bundle bundle = new Bundle();
  
  public ControlMenuBundleBuilder(String paramString)
  {
    bundle.putString("UPDATE_URN", paramString);
    bundle.putInt("UPDATE_ACTION_TYPE", 1);
  }
  
  private ControlMenuBundleBuilder(String paramString1, int paramInt, Update paramUpdate, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    bundle.putString("UPDATE_URN", paramString1);
    bundle.putInt("UPDATE_ACTION_TYPE", paramInt);
    bundle.putString("UPDATE_ACTOR_ID", paramString2);
    bundle.putString("UPDATE_ACTOR_NAME", paramString3);
    bundle.putString("MENTIONED_ENTITY", paramString4);
    bundle.putBoolean("REPORTED_BY_ME", paramBoolean);
    bundle.putString("GROUP_NAME", paramString5);
    RecordParceler.quietParcel(paramUpdate, "UPDATE_DATA", bundle);
  }
  
  public static ControlMenuBundleBuilder create(String paramString1, int paramInt, Update paramUpdate, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    return new ControlMenuBundleBuilder(paramString1, paramInt, paramUpdate, paramString2, paramString3, paramString4, paramBoolean, paramString5);
  }
  
  public static Update getUpdate(Bundle paramBundle)
  {
    return (Update)RecordParceler.quietUnparcel(Update.BUILDER, "UPDATE_DATA", paramBundle);
  }
  
  public final Bundle build()
  {
    return bundle;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ControlMenuBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */