package com.linkedin.android.identity.me.shared.actions.events;

import android.os.Bundle;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder;
import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder.Action;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class MeBaseActionEvent
{
  public List<Bundle> actionBundles;
  public String entityUrn;
  
  public MeBaseActionEvent(String paramString)
  {
    this(paramString, MeActionBundleBuilder.create(MeActionBundleBuilder.Action.NONE));
  }
  
  public MeBaseActionEvent(String paramString, MeActionBundleBuilder paramMeActionBundleBuilder)
  {
    this(paramString, Collections.singletonList(paramMeActionBundleBuilder));
  }
  
  private MeBaseActionEvent(String paramString, List<MeActionBundleBuilder> paramList)
  {
    entityUrn = paramString;
    paramString = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      paramString.add(((MeActionBundleBuilder)paramList.next()).build());
    }
    actionBundles = paramString;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actions.events.MeBaseActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */