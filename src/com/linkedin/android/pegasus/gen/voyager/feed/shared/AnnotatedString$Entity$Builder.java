package com.linkedin.android.pegasus.gen.voyager.feed.shared;

import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.UnionMemberCountException;

public final class AnnotatedString$Entity$Builder
{
  private Channel channelValue = null;
  private boolean hasChannelValue = false;
  public boolean hasMiniCompanyValue = false;
  public boolean hasMiniProfileValue = false;
  public boolean hasMiniSchoolValue = false;
  public MiniCompany miniCompanyValue = null;
  public MiniProfile miniProfileValue = null;
  public MiniSchool miniSchoolValue = null;
  
  public final AnnotatedString.Entity build()
    throws BuilderException
  {
    int j = 0;
    if (hasMiniProfileValue) {
      j = 0 + 1;
    }
    int i = j;
    if (hasMiniCompanyValue) {
      i = j + 1;
    }
    j = i;
    if (hasMiniSchoolValue) {
      j = i + 1;
    }
    i = j;
    if (hasChannelValue) {
      i = j + 1;
    }
    if (i > 1) {
      throw new UnionMemberCountException("Entity", i);
    }
    return new AnnotatedString.Entity(miniProfileValue, miniCompanyValue, miniSchoolValue, channelValue, hasMiniProfileValue, hasMiniCompanyValue, hasMiniSchoolValue, hasChannelValue);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Entity.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */