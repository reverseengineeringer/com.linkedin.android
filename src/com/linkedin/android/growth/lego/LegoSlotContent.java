package com.linkedin.android.growth.lego;

import com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class LegoSlotContent
{
  public final List<LegoGroupContent> groups;
  public LegoSlotContent next;
  public final LegoPageContent page;
  public LegoSlotContent previous;
  public final String slotId;
  
  public LegoSlotContent(LegoPageContent paramLegoPageContent, SlotContent paramSlotContent)
  {
    page = paramLegoPageContent;
    slotId = slotId;
    groups = new ArrayList();
    paramLegoPageContent = groups.iterator();
    while (paramLegoPageContent.hasNext())
    {
      paramSlotContent = (GroupContent)paramLegoPageContent.next();
      groups.add(new LegoGroupContent(this, paramSlotContent));
    }
  }
  
  public final String toString()
  {
    return slotId;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoSlotContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */