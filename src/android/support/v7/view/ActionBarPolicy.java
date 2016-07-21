package android.support.v7.view;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.support.v7.appcompat.R.bool;

public final class ActionBarPolicy
{
  public Context mContext;
  
  private ActionBarPolicy(Context paramContext)
  {
    mContext = paramContext;
  }
  
  public static ActionBarPolicy get(Context paramContext)
  {
    return new ActionBarPolicy(paramContext);
  }
  
  public final boolean hasEmbeddedTabs()
  {
    if (mContext.getApplicationInfo().targetSdkVersion >= 16) {
      return mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs);
    }
    return mContext.getResources().getBoolean(R.bool.abc_action_bar_embed_tabs_pre_jb);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.view.ActionBarPolicy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */