package com.linkedin.android.feed.utils;

import android.text.TextUtils;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedNestedSingleUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedSingleUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.Comments;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor;
import com.linkedin.android.pegasus.gen.voyager.feed.DiscussionUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.InfluencerActor;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor;
import com.linkedin.android.pegasus.gen.voyager.feed.Metadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Reshare;
import com.linkedin.android.pegasus.gen.voyager.feed.SchoolActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.ViralUpdate;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.List;

public final class FeedUpdateUtils
{
  public static SortOrder getCommentsSortOrder(SocialDetail paramSocialDetail)
  {
    if ((paramSocialDetail != null) && (comments.metadata != null) && (comments.metadata.sort != null)) {
      return comments.metadata.sort;
    }
    return SortOrder.$UNKNOWN;
  }
  
  public static DiscussionUpdate getGroupDiscussionUpdate(Update paramUpdate)
  {
    return getOriginalPegasusUpdatevalue.discussionUpdateValue;
  }
  
  public static Update getOriginalPegasusUpdate(UpdateDataModel paramUpdateDataModel)
  {
    if ((paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
      return originalUpdate.pegasusUpdate;
    }
    return pegasusUpdate;
  }
  
  public static Update getOriginalPegasusUpdate(Update paramUpdate)
  {
    for (;;)
    {
      if (value.viralUpdateValue != null)
      {
        paramUpdate = value.viralUpdateValue.originalUpdate;
      }
      else
      {
        if (value.reshareValue == null) {
          break;
        }
        paramUpdate = value.reshareValue.originalUpdate;
      }
    }
    return paramUpdate;
  }
  
  public static String getSocialActorId(SocialActor paramSocialActor)
  {
    if (memberActorValue != null) {
      return memberActorValue.miniProfile.entityUrn.getId();
    }
    if (companyActorValue != null) {
      return companyActorValue.miniCompany.entityUrn.getId();
    }
    if (schoolActorValue != null) {
      return schoolActorValue.miniSchool.entityUrn.getId();
    }
    if (influencerActorValue != null) {
      return influencerActorValue.miniProfile.entityUrn.getId();
    }
    return null;
  }
  
  public static Urn getSocialActorUrn(SocialActor paramSocialActor)
  {
    if (memberActorValue != null) {
      return memberActorValue.urn;
    }
    if (companyActorValue != null) {
      return companyActorValue.urn;
    }
    if (schoolActorValue != null) {
      return schoolActorValue.urn;
    }
    if (influencerActorValue != null) {
      return influencerActorValue.urn;
    }
    return null;
  }
  
  public static <T extends ViewModel> FeedUpdateViewModel getUpdateViewModel(List<T> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (ViewModel)paramList.get(i);
      if ((localObject instanceof FeedUpdateViewModel))
      {
        localObject = (FeedUpdateViewModel)localObject;
        if (TextUtils.equals(updateUrn, paramString)) {
          return (FeedUpdateViewModel)localObject;
        }
        if ((localObject instanceof FeedAggregatedSingleUpdateViewModel))
        {
          List localList = updateViewModels;
          int j = 0;
          int k = localList.size();
          for (;;)
          {
            if (j >= k) {
              break label120;
            }
            if (TextUtils.equals(getwrappedUpdate.updateUrn, paramString)) {
              break;
            }
            j += 1;
          }
        }
      }
      label120:
      i += 1;
    }
    return null;
  }
  
  public static boolean isGroupDiscussionUpdate(Update paramUpdate)
  {
    return getGroupDiscussionUpdate(paramUpdate) != null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.utils.FeedUpdateUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */