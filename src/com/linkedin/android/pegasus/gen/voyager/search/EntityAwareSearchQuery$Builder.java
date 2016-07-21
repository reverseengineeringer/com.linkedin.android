package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.pegasus.gen.voyager.typeahead.SuggestedEntity;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class EntityAwareSearchQuery$Builder
  implements RecordTemplateBuilder<EntityAwareSearchQuery>
{
  public boolean hasQuery = false;
  public boolean hasSuggestedEntities = false;
  public SearchQuery query = null;
  public List<SuggestedEntity> suggestedEntities = null;
  
  public final EntityAwareSearchQuery build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (EntityAwareSearchQuery.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (suggestedEntities != null)
    {
      paramFlavor = suggestedEntities.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((SuggestedEntity)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "suggestedEntities");
            if (!hasQuery) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "query");
            }
            if (hasSuggestedEntities) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery", "suggestedEntities");
          }
        }
      }
    }
    return new EntityAwareSearchQuery(query, suggestedEntities, hasQuery, hasSuggestedEntities);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.EntityAwareSearchQuery.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */