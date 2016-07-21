package com.linkedin.android.feed.endor.datamodel.content;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.AnnotatedText;

public final class JobContentDataModel
  extends AnnotatedTextContentDataModel
{
  public ActorDataModel company;
  public long listDate;
  public String location;
  public Image logo;
  public MiniJob metadata;
  public String title;
  
  public JobContentDataModel(MiniJob paramMiniJob, long paramLong, String paramString1, String paramString2, Image paramImage, ActorDataModel paramActorDataModel, AnnotatedText paramAnnotatedText)
  {
    super(paramAnnotatedText);
    metadata = paramMiniJob;
    listDate = paramLong;
    title = paramString1;
    location = paramString2;
    logo = paramImage;
    company = paramActorDataModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.content.JobContentDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */