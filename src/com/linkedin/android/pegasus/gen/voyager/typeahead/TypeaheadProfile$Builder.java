package com.linkedin.android.pegasus.gen.voyager.typeahead;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class TypeaheadProfile$Builder
  implements RecordTemplateBuilder<TypeaheadProfile>
{
  public Urn backendUrn = null;
  public MemberDistance distance = null;
  public boolean hasBackendUrn = false;
  public boolean hasDistance = false;
  public boolean hasId = false;
  public boolean hasMiniProfile = false;
  private boolean hasNormalizedProfile = false;
  public String id = null;
  public MiniProfile miniProfile = null;
  private Urn normalizedProfile = null;
  
  public final TypeaheadProfile build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (TypeaheadProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new TypeaheadProfile(miniProfile, id, backendUrn, distance, normalizedProfile, hasMiniProfile, hasId, hasBackendUrn, hasDistance, hasNormalizedProfile);
      if (!hasMiniProfile) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile", "miniProfile");
      }
      if (!hasId) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile", "id");
      }
    } while (hasBackendUrn);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile", "backendUrn");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */