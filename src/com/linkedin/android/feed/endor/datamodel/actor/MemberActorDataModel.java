package com.linkedin.android.feed.endor.datamodel.actor;

import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public final class MemberActorDataModel
  extends ActorDataModel<MiniProfile>
{
  public int connectionStatus;
  public String firstName;
  public boolean isInfluencer;
  public boolean isSelf;
  public String lastName;
  public GraphDistance memberDistance;
  public int numMutualConnections;
  public String occupation;
  public String publicIdentifier;
  
  public MemberActorDataModel(MiniProfile paramMiniProfile, String paramString1, String paramString2, GraphDistance paramGraphDistance, FollowingInfo paramFollowingInfo, boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, Urn paramUrn, String paramString3)
  {
    super(paramMiniProfile, 2, "MEMBER", entityUrn.getId(), paramString1, paramString2, firstName, picture, backgroundImage, paramFollowingInfo, paramBoolean1, paramUrn, paramString3);
    publicIdentifier = publicIdentifier;
    firstName = firstName;
    lastName = lastName;
    occupation = occupation;
    memberDistance = paramGraphDistance;
    connectionStatus = paramInt1;
    isInfluencer = paramBoolean2;
    if (paramGraphDistance == GraphDistance.SELF) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      isSelf = paramBoolean1;
      numMutualConnections = paramInt2;
      return;
    }
  }
  
  public static String makeFormattedName(I18NManager paramI18NManager, String paramString1, String paramString2)
  {
    if (paramString2 != null) {}
    for (;;)
    {
      return paramI18NManager.getString(2131233236, new Object[] { I18NManager.getName(paramString1, paramString2) });
      paramString2 = "";
    }
  }
  
  public final ImageModel makeFormattedImage(int paramInt, String paramString)
  {
    return new ImageModel(image, GhostImageUtils.getPerson(paramInt, (MiniProfile)metadata), paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */