package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHistorySchool$Builder
  implements RecordTemplateBuilder<SearchHistorySchool>
{
  private Urn backendUrn = null;
  private boolean hasBackendUrn = false;
  private boolean hasSchool = false;
  private MiniSchool school = null;
  
  public final SearchHistorySchool build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchHistorySchool.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchHistorySchool(backendUrn, school, hasBackendUrn, hasSchool);
      if (!hasBackendUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool", "backendUrn");
      }
    } while (hasSchool);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool", "school");
  }
  
  public final Builder setBackendUrn(Urn paramUrn)
  {
    if (paramUrn == null)
    {
      hasBackendUrn = false;
      backendUrn = null;
      return this;
    }
    hasBackendUrn = true;
    backendUrn = paramUrn;
    return this;
  }
  
  public final Builder setSchool(MiniSchool paramMiniSchool)
  {
    if (paramMiniSchool == null)
    {
      hasSchool = false;
      school = null;
      return this;
    }
    hasSchool = true;
    school = paramMiniSchool;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistorySchool.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */