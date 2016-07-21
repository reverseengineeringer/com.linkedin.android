package com.linkedin.gen.avro2pegasus.events.search;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SecondarySearchResultInfo$Builder
  implements RecordTemplateBuilder<SecondarySearchResultInfo>
{
  public boolean hasVertical = false;
  public SearchVertical vertical = null;
  
  public final SecondarySearchResultInfo build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SecondarySearchResultInfo.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SecondarySearchResultInfo(vertical, hasVertical);
    } while (hasVertical);
    throw new MissingRecordFieldException("com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfo", "vertical");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.gen.avro2pegasus.events.search.SecondarySearchResultInfo.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */