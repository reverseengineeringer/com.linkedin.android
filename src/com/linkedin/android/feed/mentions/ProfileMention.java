package com.linkedin.android.feed.mentions;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Entity.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.spyglass.mentions.Mentionable.MentionDeleteStyle;
import com.linkedin.data.lite.BuilderException;

public class ProfileMention
  extends MentionableImpl
{
  public static final Parcelable.Creator<ProfileMention> CREATOR = new Parcelable.Creator() {};
  
  public ProfileMention(Parcel paramParcel)
  {
    super(paramParcel);
  }
  
  public ProfileMention(I18NManager paramI18NManager, MiniProfile paramMiniProfile)
    throws BuilderException
  {}
  
  protected final String getPrimaryText(I18NManager paramI18NManager)
  {
    if (!TextUtils.isEmpty(lastName)) {
      return paramI18NManager.getString(2131233236, new Object[] { I18NManager.getName(name, lastName) });
    }
    return super.getPrimaryText(paramI18NManager);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.ProfileMention
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */