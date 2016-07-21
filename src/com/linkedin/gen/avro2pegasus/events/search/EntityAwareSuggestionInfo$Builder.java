package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class EntityAwareSuggestionInfo$Builder
  implements RecordTemplateBuilder<EntityAwareSuggestionInfo>
{
  public boolean hasSuggestedEntities = false;
  public List<SuggestedEntityType> suggestedEntities = null;
  
  public final EntityAwareSuggestionInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EntityAwareSuggestionInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (suggestedEntities != null)
    {
      paramFlavor = suggestedEntities.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((SuggestedEntityType)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo", "suggestedEntities");
            if (hasSuggestedEntities) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo", "suggestedEntities");
          }
        }
      }
    }
    return new EntityAwareSuggestionInfo(suggestedEntities, hasSuggestedEntities);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.EntityAwareSuggestionInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */