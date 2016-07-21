package com.linkedin.android.growth.lego;

import com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class LegoPageContentWithParser
{
  private final PageContent pageContent;
  
  public LegoPageContentWithParser(PageContent paramPageContent)
  {
    pageContent = paramPageContent;
  }
  
  public final WidgetContent findFirstWidgetContent(String paramString1, String paramString2)
  {
    Object localObject = new ArrayList();
    if (pageContent.slots.containsKey(paramString2))
    {
      paramString2 = pageContent.slots.get(paramString2)).groups.iterator();
      while (paramString2.hasNext()) {
        ((List)localObject).addAll(nextwidgets);
      }
    }
    paramString2 = ((List)localObject).iterator();
    while (paramString2.hasNext())
    {
      localObject = (WidgetContent)paramString2.next();
      if (widgetId.equals(paramString1)) {
        return (WidgetContent)localObject;
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoPageContentWithParser
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */