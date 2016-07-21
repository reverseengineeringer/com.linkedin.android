package com.linkedin.android.growth.lego;

import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class LegoManager
{
  public LegoWidgetContent currentWidget;
  LegoDataProvider legoDataProvider;
  public LegoPageContent page;
  
  public LegoManager(LegoDataProvider paramLegoDataProvider)
  {
    legoDataProvider = paramLegoDataProvider;
  }
  
  public static LegoWidgetContent getFirstNonNullWidget(LegoPageContent paramLegoPageContent)
    throws LegoManager.LegoNoWidgetsException
  {
    int i = 0;
    while (i < slots.size())
    {
      Object localObject1 = (LegoSlotContent[])slots.values().toArray(new LegoSlotContent[slots.values().size()]);
      if ((i < 0) || (i >= localObject1.length)) {
        Util.safeThrow(new IllegalArgumentException("Position " + i + " is outside of LegoSlotContent size: " + localObject1.length));
      }
      for (localObject1 = null; localObject1 != null; localObject1 = localObject1[i])
      {
        LegoWidgetContent localLegoWidgetContent;
        do
        {
          localObject1 = groups.iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              localObject2 = (LegoGroupContent)((Iterator)localObject1).next();
            } while (localObject2 == null);
            localObject2 = widgets.iterator();
          }
          localLegoWidgetContent = (LegoWidgetContent)((Iterator)localObject2).next();
        } while (localLegoWidgetContent == null);
        return localLegoWidgetContent;
      }
      i += 1;
    }
    throw new LegoNoWidgetsException();
  }
  
  private void updateCurrentWidget()
    throws LegoManager.LegoNoWidgetsException
  {
    if (currentWidget == null) {
      currentWidget = getFirstNonNullWidget(page);
    }
    Iterator localIterator2;
    do
    {
      return;
      Iterator localIterator1;
      while (!localIterator1.hasNext()) {
        localIterator1 = page.slots.values().iterator();
      }
      localIterator2 = nextgroups.iterator();
    } while (!localIterator2.hasNext());
    Iterator localIterator3 = nextwidgets.iterator();
    label92:
    LegoWidgetContent localLegoWidgetContent;
    while (localIterator3.hasNext())
    {
      localLegoWidgetContent = (LegoWidgetContent)localIterator3.next();
      if (currentWidget != null) {
        if (!currentWidget.equals(localLegoWidgetContent)) {
          break label139;
        }
      }
    }
    for (;;)
    {
      currentWidget = localLegoWidgetContent;
      break label92;
      break;
      label139:
      localLegoWidgetContent = currentWidget;
    }
  }
  
  public final void buildFlow(PageContent paramPageContent, boolean paramBoolean)
    throws LegoManager.LegoNoWidgetsException
  {
    Object localObject2 = new LegoPageContent(paramPageContent);
    Iterator localIterator1 = slots.values().iterator();
    Object localObject1;
    LegoGroupContent localLegoGroupContent;
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = nextgroups.iterator();
      paramPageContent = null;
      for (localObject1 = null; localIterator2.hasNext(); localObject1 = localLegoGroupContent)
      {
        localLegoGroupContent = (LegoGroupContent)localIterator2.next();
        previous = ((LegoGroupContent)localObject1);
        if (localObject1 != null) {
          next = localLegoGroupContent;
        }
        Iterator localIterator3 = widgets.iterator();
        while (localIterator3.hasNext())
        {
          localObject1 = (LegoWidgetContent)localIterator3.next();
          previous = paramPageContent;
          if (paramPageContent != null) {
            next = ((LegoWidgetContent)localObject1);
          }
          paramPageContent = (PageContent)localObject1;
        }
      }
    }
    int i;
    if (!paramBoolean)
    {
      i = 1;
      if (i == 0) {
        break label433;
      }
      page = ((LegoPageContent)localObject2);
      label182:
      localIterator1 = page.slots.keySet().iterator();
      paramPageContent = null;
      label203:
      if (!localIterator1.hasNext()) {
        break label637;
      }
      localObject1 = (String)localIterator1.next();
      localObject2 = (LegoSlotContent)page.slots.get(localObject1);
      previous = paramPageContent;
      if (paramPageContent != null) {
        next = ((LegoSlotContent)localObject2);
      }
      if (paramPageContent != null)
      {
        if (groups.size() != 0) {
          break label453;
        }
        Util.safeThrow(new IllegalStateException("Slot should not have empty list of groups"));
        localObject1 = null;
        label291:
        if (groups.size() != 0) {
          break label481;
        }
        Util.safeThrow(new IllegalStateException("Slot should not have empty list of groups"));
        localLegoGroupContent = null;
        label319:
        if ((localObject1 != null) && (localLegoGroupContent != null))
        {
          next = localLegoGroupContent;
          previous = ((LegoGroupContent)localObject1);
        }
      }
      if (paramPageContent != null)
      {
        if (groups.size() != 0) {
          break label500;
        }
        Util.safeThrow(new IllegalStateException("Slot should not have empty list of groups"));
        paramPageContent = null;
        label373:
        if (groups.size() != 0) {
          break label574;
        }
        Util.safeThrow(new IllegalStateException("Slot should not have empty list of groups"));
        localObject1 = null;
      }
    }
    for (;;)
    {
      if ((paramPageContent != null) && (localObject1 != null))
      {
        next = ((LegoWidgetContent)localObject1);
        previous = paramPageContent;
      }
      paramPageContent = (PageContent)localObject2;
      break label203;
      i = 0;
      break;
      label433:
      page.slots.putAll(slots);
      break label182;
      label453:
      localObject1 = (LegoGroupContent)groups.get(groups.size() - 1);
      break label291;
      label481:
      localLegoGroupContent = (LegoGroupContent)groups.get(0);
      break label319;
      label500:
      paramPageContent = groups.get(groups.size() - 1)).widgets;
      if (paramPageContent.size() == 0)
      {
        Util.safeThrow(new IllegalStateException("Group should not have empty list of widgets"));
        paramPageContent = null;
        break label373;
      }
      paramPageContent = (LegoWidgetContent)paramPageContent.get(paramPageContent.size() - 1);
      break label373;
      label574:
      localObject1 = groups.get(0)).widgets;
      if (((List)localObject1).size() == 0)
      {
        Util.safeThrow(new IllegalStateException("Group should not have empty list of widgets"));
        localObject1 = null;
      }
      else
      {
        localObject1 = (LegoWidgetContent)((List)localObject1).get(0);
      }
    }
    label637:
    updateCurrentWidget();
  }
  
  public final WidgetContent goToNextLegoWidget()
  {
    currentWidget = currentWidget.next;
    if (currentWidget == null) {
      return null;
    }
    return currentWidget.widgetContent;
  }
  
  public final void prefetchData(boolean paramBoolean)
  {
    Iterator localIterator1 = page.slots.values().iterator();
    if (localIterator1.hasNext())
    {
      Iterator localIterator2 = nextgroups.iterator();
      while (localIterator2.hasNext())
      {
        Iterator localIterator3 = nextwidgets.iterator();
        while (localIterator3.hasNext())
        {
          LegoWidgetContent localLegoWidgetContent = (LegoWidgetContent)localIterator3.next();
          legoDataProvider.prefetchData(widgetContent, paramBoolean);
        }
      }
    }
  }
  
  public final WidgetContent skipToWidget(String paramString)
  {
    Iterator localIterator1 = page.slots.values().iterator();
    label18:
    if (localIterator1.hasNext())
    {
      label73:
      LegoWidgetContent localLegoWidgetContent;
      do
      {
        Iterator localIterator2 = nextgroups.iterator();
        break label73;
        if (!localIterator2.hasNext()) {
          break label18;
        }
        Iterator localIterator3 = nextwidgets.iterator();
        if (!localIterator3.hasNext()) {
          break;
        }
        localLegoWidgetContent = (LegoWidgetContent)localIterator3.next();
      } while (!paramString.equals(widgetContent.widgetId));
      currentWidget = localLegoWidgetContent;
      return currentWidget.widgetContent;
    }
    return null;
  }
  
  public static final class LegoNoWidgetsException
    extends Exception
  {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */