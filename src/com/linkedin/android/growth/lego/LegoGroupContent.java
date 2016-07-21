package com.linkedin.android.growth.lego;

import com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class LegoGroupContent
{
  public final String groupId;
  public LegoGroupContent next;
  public LegoGroupContent previous;
  public final LegoSlotContent slot;
  public final List<LegoWidgetContent> widgets;
  
  public LegoGroupContent(LegoSlotContent paramLegoSlotContent, GroupContent paramGroupContent)
  {
    slot = paramLegoSlotContent;
    groupId = groupId;
    widgets = new ArrayList();
    paramLegoSlotContent = widgets.iterator();
    while (paramLegoSlotContent.hasNext())
    {
      paramGroupContent = (WidgetContent)paramLegoSlotContent.next();
      widgets.add(new LegoWidgetContent(this, paramGroupContent));
    }
  }
  
  public final String toString()
  {
    return groupId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoGroupContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */