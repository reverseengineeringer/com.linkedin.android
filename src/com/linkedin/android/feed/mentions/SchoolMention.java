package com.linkedin.android.feed.mentions;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Entity.Builder;
import com.linkedin.android.spyglass.mentions.Mentionable.MentionDeleteStyle;
import com.linkedin.data.lite.BuilderException;

public class SchoolMention
  extends MentionableImpl
{
  public static final Parcelable.Creator<SchoolMention> CREATOR = new Parcelable.Creator() {};
  
  public SchoolMention(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public SchoolMention(I18NManager paramI18NManager, MiniSchool paramMiniSchool)
    throws BuilderException
  {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    super.writeToParcel(paramParcel, paramInt);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.SchoolMention
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */