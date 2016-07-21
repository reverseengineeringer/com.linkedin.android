package com.linkedin.android.pegasus.gen.voyager.growth.abi;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.NullArrayItemException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class MiniProfileUrns$Builder
  implements RecordTemplateBuilder<MiniProfileUrns>
{
  public boolean hasMiniProfileUrns = false;
  public List<Urn> miniProfileUrns = null;
  
  public final MiniProfileUrns build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (MiniProfileUrns.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    while (miniProfileUrns != null)
    {
      paramFlavor = miniProfileUrns.iterator();
      do
      {
        if (!paramFlavor.hasNext()) {
          break;
        }
      } while ((Urn)paramFlavor.next() != null);
      throw new NullArrayItemException("com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns", "miniProfileUrns");
      if (!hasMiniProfileUrns) {
        miniProfileUrns = Collections.emptyList();
      }
    }
    return new MiniProfileUrns(miniProfileUrns, hasMiniProfileUrns);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.growth.abi.MiniProfileUrns.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */