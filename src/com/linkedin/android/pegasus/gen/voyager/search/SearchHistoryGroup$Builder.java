package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHistoryGroup$Builder
  implements RecordTemplateBuilder<SearchHistoryGroup>
{
  private Urn backendUrn = null;
  private MiniGroup group = null;
  private boolean hasBackendUrn = false;
  private boolean hasGroup = false;
  
  public final SearchHistoryGroup build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchHistoryGroup.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchHistoryGroup(backendUrn, group, hasBackendUrn, hasGroup);
      if (!hasBackendUrn) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryGroup", "backendUrn");
      }
    } while (hasGroup);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryGroup", "group");
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
  
  public final Builder setGroup(MiniGroup paramMiniGroup)
  {
    if (paramMiniGroup == null)
    {
      hasGroup = false;
      group = null;
      return this;
    }
    hasGroup = true;
    group = paramMiniGroup;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryGroup.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */