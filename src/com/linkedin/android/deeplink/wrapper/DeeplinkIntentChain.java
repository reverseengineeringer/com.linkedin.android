package com.linkedin.android.deeplink.wrapper;

import android.content.Intent;
import java.util.ArrayList;

public final class DeeplinkIntentChain
{
  public final DeeplinkIntent deeplinkIntent;
  public final ArrayList<Intent> followupIntents;
  
  public DeeplinkIntentChain(DeeplinkIntent paramDeeplinkIntent, ArrayList<Intent> paramArrayList)
  {
    deeplinkIntent = paramDeeplinkIntent;
    if (paramArrayList == null)
    {
      followupIntents = new ArrayList();
      return;
    }
    followupIntents = paramArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.deeplink.wrapper.DeeplinkIntentChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */