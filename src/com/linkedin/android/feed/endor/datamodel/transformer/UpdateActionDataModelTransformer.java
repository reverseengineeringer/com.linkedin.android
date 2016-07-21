package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.transformer.UpdateActionTransformerHelpers;
import com.linkedin.android.feed.utils.FeedI18NUtils;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction;
import com.linkedin.android.pegasus.gen.voyager.feed.UpdateAction.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.IncorrectlyMentionedMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.LeaveGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.Reasoning;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.ShareVia;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowChannel;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowGroup;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowMember;
import com.linkedin.android.pegasus.gen.voyager.feed.actions.UnfollowSchool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class UpdateActionDataModelTransformer
{
  public static List<UpdateActionModel> toDataModels(FragmentComponent paramFragmentComponent, List<UpdateAction> paramList, ActorDataModel paramActorDataModel)
    throws UpdateException
  {
    Object localObject1;
    if (paramList == null) {
      localObject1 = Collections.emptyList();
    }
    int m;
    ArrayList localArrayList;
    int k;
    do
    {
      return (List<UpdateActionModel>)localObject1;
      m = paramList.size();
      if (m <= 0) {
        return Collections.emptyList();
      }
      localArrayList = new ArrayList(m);
      k = 0;
      localObject1 = localArrayList;
    } while (k >= m);
    Object localObject7 = (UpdateAction)paramList.get(k);
    Object localObject3;
    label74:
    Object localObject2;
    label81:
    int i;
    if (paramActorDataModel == null)
    {
      localObject3 = null;
      if (paramActorDataModel != null) {
        break label138;
      }
      localObject2 = null;
      localObject1 = value;
      if (deleteValue == null) {
        break label147;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0) {
        break label414;
      }
      localObject1 = null;
      if (localObject1 != null) {
        localArrayList.add(localObject1);
      }
      k += 1;
      break;
      localObject3 = id;
      break label74;
      label138:
      localObject2 = formattedName;
      break label81;
      label147:
      if (feedbackValue != null) {
        i = 3;
      } else if (reasoningValue != null) {
        i = 2;
      } else if (reportValue != null) {
        i = 14;
      } else if (surveyValue != null) {
        i = 20;
      } else if (unfollowGroupValue != null) {
        i = 8;
      } else if (unfollowMemberValue != null) {
        i = 4;
      } else if (unfollowChannelValue != null) {
        i = 6;
      } else if (unfollowCompanyValue != null) {
        i = 5;
      } else if (unfollowSchoolValue != null) {
        i = 7;
      } else if (followChannelValue != null) {
        i = 11;
      } else if (followCompanyValue != null) {
        i = 10;
      } else if (followGroupValue != null) {
        i = 13;
      } else if (followMemberValue != null) {
        i = 9;
      } else if (followSchoolValue != null) {
        i = 12;
      } else if (incorrectlyMentionedCompanyValue != null) {
        i = 21;
      } else if (incorrectlyMentionedMemberValue != null) {
        i = 22;
      } else if (leaveGroupValue != null) {
        i = 23;
      } else if (shareViaValue != null) {
        i = 24;
      } else if (editShareValue != null) {
        i = 25;
      } else {
        i = 0;
      }
    }
    label414:
    if (value.unfollowGroupValue != null)
    {
      localObject1 = value.unfollowGroupValue.groupUrn.getId();
      label441:
      if (localObject1 != null) {
        break label2058;
      }
    }
    label474:
    label519:
    label551:
    label570:
    label594:
    label618:
    label645:
    label670:
    label700:
    label727:
    label1084:
    label1426:
    label1627:
    label1857:
    label1863:
    label1977:
    label2013:
    label2040:
    label2046:
    label2052:
    label2058:
    for (Object localObject4 = localObject3;; localObject4 = localObject1)
    {
      Object localObject5;
      int j;
      String str2;
      String str1;
      Object localObject6;
      boolean bool;
      String str3;
      if (value.unfollowGroupValue != null)
      {
        localObject1 = value.unfollowGroupValue.displayName;
        localObject5 = localObject1;
        if (localObject1 == null) {
          localObject5 = localObject2;
        }
        localObject1 = paramFragmentComponent.i18NManager();
        localObject2 = value;
        if (deleteValue == null) {
          break label1084;
        }
        localObject1 = ((I18NManager)localObject1).getString(2131231171);
        localObject2 = paramFragmentComponent.i18NManager();
        localObject3 = value;
        if (feedbackValue == null) {
          break label1426;
        }
        localObject2 = ((I18NManager)localObject2).getString(2131231176);
        localObject3 = value;
        if (deleteValue == null) {
          break label1627;
        }
        j = 2130838373;
        if (value.reasoningValue == null) {
          break label1857;
        }
        str2 = value.reasoningValue.reason;
        if (value.unfollowGroupValue == null) {
          break label1863;
        }
        localObject3 = value.unfollowGroupValue.followingInfo;
        if (value.incorrectlyMentionedCompanyValue == null) {
          break label1977;
        }
        str1 = value.incorrectlyMentionedCompanyValue.companyUrn.toString();
        localObject6 = value;
        if (incorrectlyMentionedCompanyValue == null) {
          break label2013;
        }
        bool = incorrectlyMentionedCompanyValue.self;
        if (value.leaveGroupValue == null) {
          break label2040;
        }
        localObject6 = value.leaveGroupValue.miniGroup.entityUrn.getId();
        if (value.leaveGroupValue == null) {
          break label2046;
        }
        str3 = value.leaveGroupValue.miniGroup.groupName;
        if (value.shareViaValue == null) {
          break label2052;
        }
      }
      for (localObject7 = value.shareViaValue.permalink;; localObject7 = null)
      {
        localObject1 = UpdateActionTransformerHelpers.toUpdateActionModel(i, (CharSequence)localObject1, (CharSequence)localObject2, j, (String)localObject4, (String)localObject5, str2, (FollowingInfo)localObject3, str1, bool, (String)localObject6, str3, (String)localObject7);
        break;
        if (value.unfollowCompanyValue != null)
        {
          localObject1 = value.unfollowCompanyValue.companyUrn.getId();
          break label441;
        }
        if (value.unfollowSchoolValue != null)
        {
          localObject1 = value.unfollowSchoolValue.schoolUrn.getId();
          break label441;
        }
        if (value.unfollowChannelValue != null)
        {
          localObject1 = value.unfollowChannelValue.channelUrn.getId();
          break label441;
        }
        if (value.unfollowMemberValue != null)
        {
          localObject1 = value.unfollowMemberValue.profileUrn.getId();
          break label441;
        }
        if (value.incorrectlyMentionedCompanyValue != null)
        {
          localObject1 = value.incorrectlyMentionedCompanyValue.companyUrn.getId();
          break label441;
        }
        if (value.incorrectlyMentionedMemberValue != null)
        {
          localObject1 = value.incorrectlyMentionedMemberValue.profileUrn.getId();
          break label441;
        }
        localObject1 = null;
        break label441;
        if (value.unfollowCompanyValue != null)
        {
          localObject1 = value.unfollowCompanyValue.displayName;
          break label474;
        }
        if (value.unfollowSchoolValue != null)
        {
          localObject1 = value.unfollowSchoolValue.displayName;
          break label474;
        }
        if (value.unfollowChannelValue != null)
        {
          localObject1 = value.unfollowChannelValue.displayName;
          break label474;
        }
        if (value.unfollowMemberValue != null)
        {
          localObject1 = value.unfollowMemberValue.displayName;
          break label474;
        }
        localObject1 = null;
        break label474;
        if (feedbackValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231177);
          break label519;
        }
        if (reasoningValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231185);
          break label519;
        }
        if (reportValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231186);
          break label519;
        }
        if (surveyValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231194);
          break label519;
        }
        if (unfollowGroupValue != null)
        {
          localObject1 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject1, 2131231198, unfollowGroupValue.displayName, "GROUP");
          break label519;
        }
        if (unfollowCompanyValue != null)
        {
          localObject1 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject1, 2131231198, unfollowCompanyValue.displayName, "COMPANY");
          break label519;
        }
        if (unfollowSchoolValue != null)
        {
          localObject1 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject1, 2131231198, unfollowSchoolValue.displayName, "SCHOOL");
          break label519;
        }
        if (unfollowChannelValue != null)
        {
          localObject1 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject1, 2131231198, unfollowChannelValue.displayName, "CHANNEL");
          break label519;
        }
        if (unfollowMemberValue != null)
        {
          localObject1 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject1, 2131231198, unfollowMemberValue.displayName, "MEMBER");
          break label519;
        }
        if (incorrectlyMentionedCompanyValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231200);
          break label519;
        }
        if (incorrectlyMentionedMemberValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231203);
          break label519;
        }
        if (leaveGroupValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231181);
          break label519;
        }
        if (shareViaValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231193);
          break label519;
        }
        if (editShareValue != null)
        {
          localObject1 = ((I18NManager)localObject1).getString(2131231174);
          break label519;
        }
        localObject1 = null;
        break label519;
        if (unfollowGroupValue != null)
        {
          localObject2 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject2, 2131231196, unfollowGroupValue.displayName, "GROUP");
          break label551;
        }
        if (unfollowCompanyValue != null)
        {
          localObject2 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject2, 2131231196, unfollowCompanyValue.displayName, "COMPANY");
          break label551;
        }
        if (unfollowSchoolValue != null)
        {
          localObject2 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject2, 2131231196, unfollowSchoolValue.displayName, "SCHOOL");
          break label551;
        }
        if (unfollowChannelValue != null)
        {
          localObject2 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject2, 2131231196, unfollowChannelValue.displayName, "CHANNEL");
          break label551;
        }
        if (unfollowMemberValue != null)
        {
          localObject2 = FeedI18NUtils.translateActorString$4fa0acfe((I18NManager)localObject2, 2131231196, unfollowMemberValue.displayName, "MEMBER");
          break label551;
        }
        if (leaveGroupValue != null)
        {
          localObject2 = ((I18NManager)localObject2).getString(2131231180, new Object[] { leaveGroupValue.miniGroup.groupName });
          break label551;
        }
        localObject2 = null;
        break label551;
        if (feedbackValue != null)
        {
          j = 2130838000;
          break label570;
        }
        if (reasoningValue != null)
        {
          j = 2130838281;
          break label570;
        }
        if (reportValue != null)
        {
          j = 2130838012;
          break label570;
        }
        if (surveyValue != null)
        {
          j = 2130838010;
          break label570;
        }
        if (unfollowGroupValue != null)
        {
          j = 2130837916;
          break label570;
        }
        if (unfollowMemberValue != null)
        {
          j = 2130837916;
          break label570;
        }
        if (unfollowChannelValue != null)
        {
          j = 2130837916;
          break label570;
        }
        if (unfollowSchoolValue != null)
        {
          j = 2130837916;
          break label570;
        }
        if (unfollowCompanyValue != null)
        {
          j = 2130837916;
          break label570;
        }
        if (incorrectlyMentionedCompanyValue != null)
        {
          j = 2130838281;
          break label570;
        }
        if (incorrectlyMentionedMemberValue != null)
        {
          j = 2130838281;
          break label570;
        }
        if (leaveGroupValue != null)
        {
          j = 2130837901;
          break label570;
        }
        if (shareViaValue != null)
        {
          j = 2130838112;
          break label570;
        }
        if (editShareValue != null)
        {
          j = 2130838216;
          break label570;
        }
        j = -1;
        break label570;
        str2 = null;
        break label594;
        if (value.unfollowCompanyValue != null)
        {
          localObject3 = value.unfollowCompanyValue.followingInfo;
          break label618;
        }
        if (value.unfollowSchoolValue != null)
        {
          localObject3 = value.unfollowSchoolValue.followingInfo;
          break label618;
        }
        if (value.unfollowChannelValue != null)
        {
          localObject3 = value.unfollowChannelValue.followingInfo;
          break label618;
        }
        if (value.unfollowMemberValue != null)
        {
          localObject3 = value.unfollowMemberValue.followingInfo;
          break label618;
        }
        localObject3 = null;
        break label618;
        if (value.incorrectlyMentionedMemberValue != null)
        {
          str1 = value.incorrectlyMentionedMemberValue.profileUrn.toString();
          break label645;
        }
        str1 = null;
        break label645;
        if (incorrectlyMentionedMemberValue != null)
        {
          bool = incorrectlyMentionedMemberValue.self;
          break label670;
        }
        bool = false;
        break label670;
        localObject6 = null;
        break label700;
        str3 = null;
        break label727;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.UpdateActionDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */