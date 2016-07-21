package com.linkedin.android.feed.mentions;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Entity.Builder;
import com.linkedin.android.spyglass.mentions.Mentionable.MentionDeleteStyle;
import com.linkedin.data.lite.BuilderException;

public class CompanyMention
  extends MentionableImpl
{
  public static final Parcelable.Creator<CompanyMention> CREATOR = new Parcelable.Creator() {};
  
  public CompanyMention(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public CompanyMention(I18NManager paramI18NManager, MiniCompany paramMiniCompany)
    throws BuilderException
  {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.CompanyMention
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */