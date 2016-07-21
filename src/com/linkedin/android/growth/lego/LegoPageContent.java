package com.linkedin.android.growth.lego;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent;
import java.util.LinkedHashMap;
import java.util.Map;

public final class LegoPageContent
{
  public final Urn entityUrn;
  public final Map<String, LegoSlotContent> slots;
  
  public LegoPageContent(PageContent paramPageContent)
  {
    entityUrn = entityUrn;
    slots = new LinkedHashMap();
    SlotContent localSlotContent = (SlotContent)slots.get("flow1");
    if (localSlotContent != null) {
      slots.put("flow1", new LegoSlotContent(this, localSlotContent));
    }
    localSlotContent = (SlotContent)slots.get("flow2");
    if (localSlotContent != null) {
      slots.put("flow2", new LegoSlotContent(this, localSlotContent));
    }
    localSlotContent = (SlotContent)slots.get("abi_views");
    if (localSlotContent != null) {
      slots.put("abi_views", new LegoSlotContent(this, localSlotContent));
    }
    paramPageContent = (SlotContent)slots.get("abi_past_imported_contacts_views");
    if (paramPageContent != null) {
      slots.put("abi_past_imported_contacts_views", new LegoSlotContent(this, paramPageContent));
    }
  }
  
  public final String toString()
  {
    return entityUrn.toString();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.lego.LegoPageContent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */