package com.linkedin.android.feed.viewmodels.models;

import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;

public final class UpdateActionModel
  extends BaseActionModel
{
  public final String actorId;
  public final String actorName;
  public final FollowingInfo followingInfo;
  public final String groupId;
  public final String groupName;
  public final String mentionedEntityUrn;
  public final String permalink;
  public final String reason;
  public final boolean self;
  
  public UpdateActionModel(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2, String paramString1, String paramString2, String paramString3, FollowingInfo paramFollowingInfo, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    super(paramInt1, paramCharSequence1, paramCharSequence2, paramInt2);
    actorId = paramString1;
    actorName = paramString2;
    reason = paramString3;
    followingInfo = paramFollowingInfo;
    mentionedEntityUrn = paramString4;
    self = paramBoolean;
    groupId = paramString5;
    groupName = paramString6;
    permalink = paramString7;
  }
  
  public static boolean isUnfollowAction(int paramInt)
  {
    return (6 == paramInt) || (4 == paramInt) || (7 == paramInt) || (8 == paramInt) || (5 == paramInt);
  }
  
  public final String getControlName()
  {
    switch (type)
    {
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    default: 
      return "";
    case 2: 
      return "control_menu_reasoning";
    case 3: 
      return "control_menu_feedback";
    case 4: 
    case 5: 
    case 6: 
    case 7: 
    case 8: 
      return "control_menu_unfollow";
    case 14: 
      return "control_menu_report";
    case 20: 
      return "control_menu_survey";
    case 21: 
    case 22: 
      return "control_menu_wrong_entity";
    case 23: 
      return "control_menu_group_leave";
    case 24: 
      return "control_menu_share_via";
    }
    return "control_menu_edit_share";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.viewmodels.models.UpdateActionModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */