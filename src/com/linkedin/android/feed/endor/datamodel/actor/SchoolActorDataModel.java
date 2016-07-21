package com.linkedin.android.feed.endor.datamodel.actor;

import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;

public final class SchoolActorDataModel
  extends ActorDataModel<MiniSchool>
{
  public SchoolActorDataModel(MiniSchool paramMiniSchool, String paramString1, String paramString2, FollowingInfo paramFollowingInfo, boolean paramBoolean, Urn paramUrn, String paramString3)
  {
    super(paramMiniSchool, 1, "SCHOOL", entityUrn.getId(), paramString1, paramString2, schoolName, logo, null, paramFollowingInfo, paramBoolean, paramUrn, paramString3);
  }
  
  public static String makeFormattedName(I18NManager paramI18NManager, String paramString)
  {
    return paramI18NManager.getString(2131230829, new Object[] { paramString });
  }
  
  public final ImageModel makeFormattedImage(int paramInt, String paramString)
  {
    return new ImageModel(image, GhostImageUtils.getSchool(paramInt, (MiniSchool)metadata), paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.SchoolActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */