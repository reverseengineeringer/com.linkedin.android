package com.linkedin.android.feed.endor.datamodel.actor;

import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.feed.ExternalAuthor;

public final class ExternalAuthorDataModel
  extends ActorDataModel<ExternalAuthor>
{
  public ExternalAuthorDataModel(ExternalAuthor paramExternalAuthor, String paramString1, String paramString2)
  {
    super(paramExternalAuthor, 0, "DEFAULT_TEXT", null, paramString1, null, paramString1, null, null, null, false, null, paramString2);
  }
  
  public final ImageModel makeFormattedImage(int paramInt, String paramString)
  {
    return new ImageModel(null, GhostImageUtils.getAnonymousPerson(paramInt), paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.ExternalAuthorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */