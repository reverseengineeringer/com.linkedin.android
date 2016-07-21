package com.linkedin.android.pegasus.gen.voyager.search;

import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.MissingRecordFieldException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.RecordTemplateBuilder;

public final class SearchHistoryProfile$Builder
  implements RecordTemplateBuilder<SearchHistoryProfile>
{
  private Urn backendUrn = null;
  private boolean hasBackendUrn = false;
  private boolean hasProfile = false;
  private MiniProfile profile = null;
  
  public final SearchHistoryProfile build(RecordTemplate.Flavor paramFlavor)
    throws BuilderException
  {
    switch (SearchHistoryProfile.1.$SwitchMap$com$linkedin$data$lite$RecordTemplate$Flavor[paramFlavor.ordinal()])
    {
    }
    do
    {
      return new SearchHistoryProfile(profile, backendUrn, hasProfile, hasBackendUrn);
      if (!hasProfile) {
        throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile", "profile");
      }
    } while (hasBackendUrn);
    throw new MissingRecordFieldException("com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile", "backendUrn");
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
  
  public final Builder setProfile(MiniProfile paramMiniProfile)
  {
    if (paramMiniProfile == null)
    {
      hasProfile = false;
      profile = null;
      return this;
    }
    hasProfile = true;
    profile = paramMiniProfile;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.search.SearchHistoryProfile.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */