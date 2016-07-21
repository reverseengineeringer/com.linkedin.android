package com.linkedin.android.identity.me.shared.actions.events;

import com.linkedin.android.identity.me.shared.actions.MeActionBundleBuilder;
import com.linkedin.android.infra.events.Bus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MePostExecuteActionEvent
  extends MeBaseActionEvent
{
  public MePostExecuteActionEvent(String paramString)
  {
    super(paramString);
  }
  
  public MePostExecuteActionEvent(String paramString, MeActionBundleBuilder paramMeActionBundleBuilder)
  {
    super(paramString, paramMeActionBundleBuilder);
  }
  
  public static void replaceCardClickPostExecuteActions$14130d1(List<MeActionBundleBuilder> paramList)
  {
    MePostExecuteActionEvent localMePostExecuteActionEvent = (MePostExecuteActionEvent)Bus.getStickyEvent(MePostExecuteActionEvent.class);
    if (localMePostExecuteActionEvent == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(((MeActionBundleBuilder)paramList.next()).build());
    }
    actionBundles = localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.shared.actions.events.MePostExecuteActionEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */