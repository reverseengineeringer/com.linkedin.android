package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.MemberActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.SchoolActorDataModel;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager;
import com.linkedin.android.identity.profile.view.ProfilePendingConnectionRequestManager.PendingState;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor;
import com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor;
import com.linkedin.android.pegasus.gen.voyager.feed.PersonObject;
import com.linkedin.android.pegasus.gen.voyager.feed.PersonObject.Actor;
import com.linkedin.android.pegasus.gen.voyager.feed.SchoolActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.profileHighlights.SharedConnectionsInfo;
import java.util.List;

public final class ActorDataTransformer
{
  static CompanyActorDataModel getCompanyActorDataModel(FragmentComponent paramFragmentComponent, MiniCompany paramMiniCompany, FollowingInfo paramFollowingInfo, boolean paramBoolean, Urn paramUrn, List<EntitiesFlavor> paramList)
  {
    int i;
    String str;
    if (hasFollowerCount)
    {
      i = followerCount;
      str = CompanyActorDataModel.makeFormattedName(paramFragmentComponent.i18NManager(), name);
      localObject = paramFragmentComponent.i18NManager();
      boolean bool = following;
      if (i <= 0) {
        break label97;
      }
    }
    label97:
    for (Object localObject = ((I18NManager)localObject).getString(2131230900, new Object[] { Integer.valueOf(i) });; localObject = null)
    {
      return new CompanyActorDataModel(paramMiniCompany, str, (String)localObject, paramFollowingInfo, paramBoolean, paramList, paramUrn, Util.retrieveRumSessionId(paramFragmentComponent));
      i = -1;
      break;
    }
  }
  
  static MemberActorDataModel getMemberActorDataModel(FragmentComponent paramFragmentComponent, MiniProfile paramMiniProfile, GraphDistance paramGraphDistance, FollowingInfo paramFollowingInfo, boolean paramBoolean1, boolean paramBoolean2, Urn paramUrn, int paramInt)
  {
    String str1 = MemberActorDataModel.makeFormattedName(paramFragmentComponent.i18NManager(), firstName, lastName);
    paramFragmentComponent.i18NManager();
    String str2 = occupation;
    GraphDistance localGraphDistance;
    ProfilePendingConnectionRequestManager.PendingState localPendingState;
    int i;
    if (paramGraphDistance != null)
    {
      localGraphDistance = paramGraphDistance;
      localPendingState = paramFragmentComponent.profilePendingConnectionRequestManager().getPendingState(entityUrn.getId());
      if (localPendingState != ProfilePendingConnectionRequestManager.PendingState.INVITATION_SENT) {
        break label106;
      }
      i = 3;
    }
    for (;;)
    {
      return new MemberActorDataModel(paramMiniProfile, str1, str2, localGraphDistance, paramFollowingInfo, paramBoolean1, i, paramBoolean2, paramInt, paramUrn, Util.retrieveRumSessionId(paramFragmentComponent));
      localGraphDistance = GraphDistance.$UNKNOWN;
      break;
      label106:
      if (localPendingState == ProfilePendingConnectionRequestManager.PendingState.INVITATION_ACCEPTED) {
        i = 1;
      } else if ((paramGraphDistance == null) || (paramGraphDistance.equals(GraphDistance.$UNKNOWN))) {
        i = 0;
      } else if (paramGraphDistance.equals(GraphDistance.DISTANCE_1)) {
        i = 1;
      } else {
        i = 2;
      }
    }
  }
  
  public static ActorDataModel<?> toDataModel(FragmentComponent paramFragmentComponent, SocialActor paramSocialActor)
    throws UpdateException
  {
    if (memberActorValue != null) {
      return toDataModel(paramFragmentComponent, memberActorValue, null);
    }
    if (influencerActorValue != null) {
      return toDataModel(paramFragmentComponent, influencerActorValue, null);
    }
    if (companyActorValue != null) {
      return toDataModel(paramFragmentComponent, companyActorValue);
    }
    if (schoolActorValue != null)
    {
      SchoolActor localSchoolActor = schoolActorValue;
      int i;
      MiniSchool localMiniSchool;
      String str;
      if (followingInfo.hasFollowerCount)
      {
        i = followingInfo.followerCount;
        paramSocialActor = paramFragmentComponent.i18NManager();
        localMiniSchool = miniSchool;
        str = SchoolActorDataModel.makeFormattedName(paramSocialActor, miniSchool.schoolName);
        boolean bool = followingInfo.following;
        if (i <= 0) {
          break label179;
        }
      }
      label179:
      for (paramSocialActor = paramSocialActor.getString(2131230900, new Object[] { Integer.valueOf(i) });; paramSocialActor = null)
      {
        return new SchoolActorDataModel(localMiniSchool, str, paramSocialActor, followingInfo, showFollowAction, urn, Util.retrieveRumSessionId(paramFragmentComponent));
        i = -1;
        break;
      }
    }
    throw new UpdateException("unknown social actor");
  }
  
  public static CompanyActorDataModel toDataModel(FragmentComponent paramFragmentComponent, CompanyActor paramCompanyActor)
  {
    return getCompanyActorDataModel(paramFragmentComponent, miniCompany, followingInfo, showFollowAction, urn, flavors);
  }
  
  public static MemberActorDataModel toDataModel(FragmentComponent paramFragmentComponent, InfluencerActor paramInfluencerActor, SharedConnectionsInfo paramSharedConnectionsInfo)
  {
    GraphDistance localGraphDistance;
    if (distance != null)
    {
      localGraphDistance = distance.value;
      if (paramSharedConnectionsInfo == null) {
        break label58;
      }
    }
    label58:
    for (int i = totalCount;; i = -1)
    {
      return getMemberActorDataModel(paramFragmentComponent, miniProfile, localGraphDistance, followingInfo, showFollowAction, true, urn, i);
      localGraphDistance = GraphDistance.$UNKNOWN;
      break;
    }
  }
  
  public static MemberActorDataModel toDataModel(FragmentComponent paramFragmentComponent, MemberActor paramMemberActor, SharedConnectionsInfo paramSharedConnectionsInfo)
  {
    GraphDistance localGraphDistance;
    if (distance != null)
    {
      localGraphDistance = distance.value;
      if (paramSharedConnectionsInfo == null) {
        break label58;
      }
    }
    label58:
    for (int i = totalCount;; i = -1)
    {
      return getMemberActorDataModel(paramFragmentComponent, miniProfile, localGraphDistance, followingInfo, showFollowAction, false, urn, i);
      localGraphDistance = GraphDistance.$UNKNOWN;
      break;
    }
  }
  
  public static MemberActorDataModel toDataModel(FragmentComponent paramFragmentComponent, PersonObject paramPersonObject)
    throws UpdateException
  {
    if (actor.memberActorValue != null) {
      return toDataModel(paramFragmentComponent, actor.memberActorValue, mutualConnections);
    }
    if (actor.influencerActorValue != null) {
      return toDataModel(paramFragmentComponent, actor.influencerActorValue, mutualConnections);
    }
    throw new UpdateException("unknown person actor");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.ActorDataTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */