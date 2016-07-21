package com.linkedin.android.pegasus.gen.voyager.entities.incommon;

import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Iterator;
import java.util.List;

public final class InCommonPersonCollection$Builder
  implements RecordTemplateBuilder<InCommonPersonCollection>
{
  public boolean hasItems = false;
  public boolean hasPagingInfo = false;
  public List<InCommonPerson> items = null;
  public PagingInfo pagingInfo = null;
  
  public final InCommonPersonCollection build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (InCommonPersonCollection.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (items != null)
    {
      paramFlavor = items.iterator();
      for (;;)
      {
        if (paramFlavor.hasNext()) {
          if ((InCommonPerson)paramFlavor.next() == null)
          {
            throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection", "items");
            if (!hasItems) {
              throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection", "items");
            }
            if (hasPagingInfo) {
              break;
            }
            throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection", "pagingInfo");
          }
        }
      }
    }
    return new InCommonPersonCollection(items, pagingInfo, hasItems, hasPagingInfo);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPersonCollection.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */