package com.linkedin.android.feed.endor.datamodel.actor;

import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.ExternalCompany;

public final class ExternalCompanyActorDataModel
  extends ActorDataModel<ExternalCompany>
{
  public ExternalCompanyActorDataModel(ExternalCompany paramExternalCompany, String paramString1, String paramString2, String paramString3)
  {
    super(paramExternalCompany, 1, "COMPANY", null, paramString1, null, paramString2, null, null, null, false, null, paramString3);
  }
  
  public final ImageModel makeFormattedImage(int paramInt, String paramString)
  {
    return new ImageModel(image, GhostImageUtils.getUnstructuredCompany(paramInt), paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.ExternalCompanyActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */