package com.linkedin.android.pegasus.gen.voyager.identity.profile;

import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class IM$Builder
  implements RecordTemplateBuilder<IM>
{
  private boolean hasId = false;
  private boolean hasProvider = false;
  private String id = null;
  private IMProvider provider = null;
  
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
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.IM", "id");
      }
    } while (hasProvider);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.identity.profile.IM", "provider");
  }
  
  public final Builder setId(String paramString)
  {
    if (paramString == null)
    {
      hasId = false;
      id = null;
      return this;
    }
    hasId = true;
    id = paramString;
    return this;
  }
  
  public final Builder setProvider(IMProvider paramIMProvider)
  {
    if (paramIMProvider == null)
    {
      hasProvider = false;
      provider = null;
      return this;
    }
    hasProvider = true;
    provider = paramIMProvider;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.identity.profile.IM.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */