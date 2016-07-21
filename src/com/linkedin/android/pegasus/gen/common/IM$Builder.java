package com.linkedin.android.pegasus.gen.common;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class IM$Builder
  implements RecordTemplateBuilder<IM>
{
  public boolean hasId = false;
  public boolean hasProvider = false;
  public String id = null;
  public String provider = null;
  
  public final IM build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (IM.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new IM(id, provider, hasId, hasProvider);
      if (!hasId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.IM", "id");
      }
    } while (hasProvider);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.common.IM", "provider");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.common.IM.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */