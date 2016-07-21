package com.linkedin.android.pegasus.gen.voyager.messaging.create.message;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class ShareCreate$Builder
  implements RecordTemplateBuilder<ShareCreate>
{
  public boolean hasShare = false;
  public Urn share = null;
  
  public final ShareCreate build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (ShareCreate.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new ShareCreate(share, hasShare);
    } while (hasShare);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreate", "share");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.messaging.create.message.ShareCreate.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */