package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TypeaheadTitle$Builder
  implements RecordTemplateBuilder<TypeaheadTitle>
{
  public Urn backendUrn = null;
  public boolean hasBackendUrn = false;
  public boolean hasId = false;
  public String id = null;
  
  public final TypeaheadTitle build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (TypeaheadTitle.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new TypeaheadTitle(id, backendUrn, hasId, hasBackendUrn);
      if (!hasId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadTitle", "id");
      }
    } while (hasBackendUrn);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadTitle", "backendUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadTitle.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */