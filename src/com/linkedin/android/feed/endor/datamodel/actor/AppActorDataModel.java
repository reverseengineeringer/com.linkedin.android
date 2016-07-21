package com.linkedin.android.feed.endor.datamodel.actor;

import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.AppActor;

public final class AppActorDataModel
  extends ActorDataModel<AppActor>
{
  public String appUrl;
  
  public AppActorDataModel(AppActor paramAppActor, String paramString1, String paramString2, String paramString3, String paramString4, Image paramImage, String paramString5, String paramString6)
  {
    super(paramAppActor, 3, "APPLICATION", paramString1, paramString2, paramString3, paramString4, paramImage, null, null, false, null, paramString6);
    appUrl = paramString5;
  }
  
  public final ImageModel makeFormattedImage(int paramInt, String paramString)
  {
    return new ImageModel(image, 2130837794, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.AppActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */