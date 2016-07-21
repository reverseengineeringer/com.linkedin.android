package com.linkedin.android.feed.mentions;

import android.os.Parcel;
import com.linkedin.android.datamanager.DataManager;
import com.linkedin.android.infra.data.UnionParceler;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedString.Entity;
import com.linkedin.android.spyglass.mentions.Mentionable;
import com.linkedin.android.spyglass.mentions.Mentionable.MentionDeleteStyle;
import com.linkedin.android.spyglass.mentions.Mentionable.MentionDisplayMode;
import com.linkedin.data.lite.JsonGenerator;
import com.linkedin.data.lite.JsonGeneratorException;
import com.linkedin.data.lite.JsonGeneratorFactory;
import java.io.StringWriter;

public abstract class MentionableImpl
  implements Mentionable
{
  private Mentionable.MentionDeleteStyle deleteStyle;
  public AnnotatedString.Entity entity;
  public String entityUrn;
  String lastName;
  String name;
  private String primaryText;
  
  public MentionableImpl(Parcel paramParcel)
  {
    deleteStyle = Mentionable.MentionDeleteStyle.values()[paramParcel.readInt()];
    name = paramParcel.readString();
    lastName = paramParcel.readString();
    primaryText = paramParcel.readString();
    entityUrn = paramParcel.readString();
    entity = ((AnnotatedString.Entity)UnionParceler.quietReadFromParcel(AnnotatedString.Entity.BUILDER, paramParcel));
  }
  
  public MentionableImpl(I18NManager paramI18NManager, Mentionable.MentionDeleteStyle paramMentionDeleteStyle, String paramString1, String paramString2, AnnotatedString.Entity paramEntity, String paramString3)
  {
    deleteStyle = paramMentionDeleteStyle;
    name = paramString1;
    lastName = paramString2;
    entity = paramEntity;
    primaryText = getPrimaryText(paramI18NManager);
    entityUrn = paramString3;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final Mentionable.MentionDeleteStyle getDeleteStyle()
  {
    return deleteStyle;
  }
  
  protected String getPrimaryText(I18NManager paramI18NManager)
  {
    return name;
  }
  
  public final String getSuggestiblePrimaryText()
  {
    return primaryText;
  }
  
  public final String getTextForDisplayMode(Mentionable.MentionDisplayMode paramMentionDisplayMode)
  {
    switch (paramMentionDisplayMode)
    {
    default: 
      return "";
    case ???: 
      return primaryText;
    }
    return name;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(deleteStyle.ordinal());
    paramParcel.writeString(name);
    paramParcel.writeString(lastName);
    paramParcel.writeString(primaryText);
    paramParcel.writeString(entityUrn);
    AnnotatedString.Entity localEntity = entity;
    try
    {
      StringWriter localStringWriter = new StringWriter();
      DataManager.GENERATOR_FACTORY.createJsonGenerator().generate(localEntity, localStringWriter);
      paramParcel.writeString(localStringWriter.toString());
      return;
    }
    catch (JsonGeneratorException paramParcel)
    {
      Util.safeThrow(new RuntimeException("couldn't write to parcel", paramParcel));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionableImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */