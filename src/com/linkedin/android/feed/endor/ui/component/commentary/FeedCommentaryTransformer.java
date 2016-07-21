package com.linkedin.android.feed.endor.ui.component.commentary;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import com.linkedin.android.feed.endor.datamodel.content.AnnotatedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.AttributedTextContentDataModel;
import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.endor.datamodel.social.SocialDetailDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.utils.FeedTextUtils;
import com.linkedin.android.feed.utils.FeedUpdateUtils;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class FeedCommentaryTransformer
{
  @Deprecated
  private static void sendToDetailPage(FragmentComponent paramFragmentComponent, FeedCommentaryViewModel paramFeedCommentaryViewModel, SingleUpdateDataModel paramSingleUpdateDataModel, Update paramUpdate, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    String[] arrayOfString;
    if (socialDetail == null)
    {
      arrayOfString = null;
      if (socialDetail != null) {
        break label84;
      }
    }
    label84:
    for (paramSingleUpdateDataModel = null;; paramSingleUpdateDataModel = socialDetail.highlightedReplyUrns)
    {
      updateClickListener = FeedTracking.newUpdateClickListener(paramUpdate, paramString, paramFragmentComponent, 0, paramBoolean1, arrayOfString, paramSingleUpdateDataModel, "object_description", "viewUpdateDetail");
      if (!paramBoolean2) {
        break label95;
      }
      disableExpandOnEllipsisClick = true;
      commentaryEllipsisTextClickListener = FeedTracking.newUpdateClickListener(paramUpdate, paramString, paramFragmentComponent, 0, paramBoolean1, arrayOfString, paramSingleUpdateDataModel, "expand", "viewUpdateDetail");
      return;
      arrayOfString = socialDetail.highlightedCommentUrns;
      break;
    }
    label95:
    commentaryEllipsisTextClickListener = FeedTracking.newEllipsisTextListener(paramFragmentComponent, paramUpdate, "expandUpdateText");
  }
  
  private static void sendToDetailPage(FragmentComponent paramFragmentComponent, FeedCommentaryViewModel paramFeedCommentaryViewModel, SingleUpdateDataModel paramSingleUpdateDataModel, Update paramUpdate, boolean paramBoolean1, boolean paramBoolean2)
  {
    String[] arrayOfString;
    if (socialDetail == null)
    {
      arrayOfString = null;
      if (socialDetail != null) {
        break label80;
      }
    }
    label80:
    for (paramSingleUpdateDataModel = null;; paramSingleUpdateDataModel = socialDetail.highlightedReplyUrns)
    {
      updateClickListener = FeedTracking.newUpdateClickListener(paramUpdate, paramFragmentComponent, 0, paramBoolean1, arrayOfString, paramSingleUpdateDataModel, "object_description", "viewUpdateDetail");
      if (!paramBoolean2) {
        break label91;
      }
      disableExpandOnEllipsisClick = true;
      commentaryEllipsisTextClickListener = FeedTracking.newUpdateClickListener(paramUpdate, paramFragmentComponent, 0, paramBoolean1, arrayOfString, paramSingleUpdateDataModel, "expand", "viewUpdateDetail");
      return;
      arrayOfString = socialDetail.highlightedCommentUrns;
      break;
    }
    label91:
    commentaryEllipsisTextClickListener = FeedTracking.newEllipsisTextListener(paramFragmentComponent, paramUpdate, "expandUpdateText");
  }
  
  private static void sendToLandingPage(FragmentComponent paramFragmentComponent, FeedCommentaryViewModel paramFeedCommentaryViewModel, Update paramUpdate, String paramString, boolean paramBoolean)
  {
    updateClickListener = FeedTracking.newSponsoredLandingPageClickListener(paramUpdate, "object_description", paramString, "viewContent", paramFragmentComponent);
    if (paramBoolean)
    {
      disableExpandOnEllipsisClick = true;
      commentaryEllipsisTextClickListener = FeedTracking.newSponsoredLandingPageClickListener(paramUpdate, "expand", paramString, "viewContent", paramFragmentComponent);
      return;
    }
    commentaryEllipsisTextClickListener = FeedTracking.newEllipsisTextListener(paramFragmentComponent, paramUpdate, "expandUpdateText");
  }
  
  public static FeedCommentaryViewModel toViewModel(SingleUpdateDataModel paramSingleUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    Object localObject1 = null;
    boolean bool1;
    boolean bool2;
    label70:
    int i;
    label92:
    FeedCommentaryViewModel localFeedCommentaryViewModel;
    boolean bool3;
    label143:
    Object localObject2;
    label158:
    String str1;
    if (content.hasNonEmptyText())
    {
      if ((!FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager())) || (paramFragmentComponent.lixManager().getTreatment(Lix.FEED_SPONSORED_COMMENTARY).equals("treatment_B"))) {
        break label442;
      }
      bool1 = true;
      if ((!FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) && (!FeedViewTransformerHelpers.isPromptResponseListPage(paramFragmentComponent))) {
        break label447;
      }
      bool2 = true;
      if (!FeedViewTransformerHelpers.isImageViewerPage(paramFragmentComponent)) {
        break label453;
      }
      i = paramFragmentComponent.context().getResources().getInteger(2131558450);
      localFeedCommentaryViewModel = new FeedCommentaryViewModel(new FeedCommentaryLayout(bool1, bool2, i));
      bool3 = FeedTracking.isSponsored(pegasusUpdate, paramFragmentComponent.lixManager());
      if (!(paramSingleUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
        break label472;
      }
      localObject1 = urn;
      bool2 = true;
      if (paramFragmentComponent.fragment() != null) {
        break label478;
      }
      localObject2 = null;
      bool1 = bool2;
      if (localObject2 != null)
      {
        bool1 = bool2;
        if (((Bundle)localObject2).getBoolean("backWhenReply")) {
          bool1 = false;
        }
      }
      if (!FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent))
      {
        if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_USE_VIRAL_UPDATE_IN_DETAIL)) {
          break label557;
        }
        localObject1 = pegasusUpdate;
        localObject2 = FeedTracking.getSponsoredLandingPageUrl(tracking);
        str1 = paramFragmentComponent.lixManager().getTreatment(Lix.FEED_SPONSORED_COMMENTARY);
        if ((!bool3) || (TextUtils.isEmpty((CharSequence)localObject2)) || (!str1.equals("treatment_A"))) {
          break label492;
        }
        sendToLandingPage(paramFragmentComponent, localFeedCommentaryViewModel, (Update)localObject1, (String)localObject2, true);
      }
      label269:
      localObject1 = content;
      if (!(localObject1 instanceof AttributedTextContentDataModel)) {
        break label695;
      }
    }
    label442:
    label447:
    label453:
    label472:
    label478:
    label492:
    label557:
    label695:
    for (commentary = ((AttributedTextContentDataModel)localObject1).getText(paramFragmentComponent.context());; commentary = ((AnnotatedTextContentDataModel)localObject1).getSpannableTextFromAnnotatedText$6e69c961(pegasusUpdate, paramFragmentComponent, true, true))
    {
      if (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_HASHTAGS)) {
        commentary = FeedTextUtils.getTextWithHashtagSpans(paramFragmentComponent, commentary, pegasusUpdate, null);
      }
      if (isEdited)
      {
        paramSingleUpdateDataModel = commentary;
        localObject1 = paramFragmentComponent.i18NManager().getString(2131231312, new Object[] { paramSingleUpdateDataModel });
        localObject2 = new SpannableStringBuilder((CharSequence)localObject1);
        ((SpannableStringBuilder)localObject2).setSpan(new ForegroundColorSpan(ContextCompat.getColor(paramFragmentComponent.context(), 2131624083)), paramSingleUpdateDataModel.length() + 1, ((String)localObject1).length(), 18);
        commentary = ((CharSequence)localObject2);
      }
      isCommentaryExpanded = FeedViewTransformerHelpers.isDetailPage(paramFragmentComponent);
      localObject1 = localFeedCommentaryViewModel;
      return (FeedCommentaryViewModel)localObject1;
      bool1 = false;
      break;
      bool2 = false;
      break label70;
      i = paramFragmentComponent.context().getResources().getInteger(2131558457);
      break label92;
      localObject1 = null;
      break label143;
      localObject2 = paramFragmentComponent.fragment().getArguments();
      break label158;
      if ((bool3) && (str1.equals("treatment_B")))
      {
        sendToDetailPage(paramFragmentComponent, localFeedCommentaryViewModel, paramSingleUpdateDataModel, (Update)localObject1, bool1, true);
        break label269;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        sendToLandingPage(paramFragmentComponent, localFeedCommentaryViewModel, (Update)localObject1, (String)localObject2, false);
        break label269;
      }
      sendToDetailPage(paramFragmentComponent, localFeedCommentaryViewModel, paramSingleUpdateDataModel, (Update)localObject1, bool1, false);
      break label269;
      localObject2 = FeedUpdateUtils.getOriginalPegasusUpdate(paramSingleUpdateDataModel);
      str1 = FeedTracking.getSponsoredLandingPageUrl(tracking);
      String str2 = paramFragmentComponent.lixManager().getTreatment(Lix.FEED_SPONSORED_COMMENTARY);
      if ((bool3) && (!TextUtils.isEmpty(str1)) && (str2.equals("treatment_A")))
      {
        sendToLandingPage(paramFragmentComponent, localFeedCommentaryViewModel, (Update)localObject2, str1, true);
        break label269;
      }
      if ((bool3) && (str2.equals("treatment_B")))
      {
        sendToDetailPage(paramFragmentComponent, localFeedCommentaryViewModel, paramSingleUpdateDataModel, (Update)localObject2, (String)localObject1, bool1, true);
        break label269;
      }
      if (!TextUtils.isEmpty(str1))
      {
        sendToLandingPage(paramFragmentComponent, localFeedCommentaryViewModel, (Update)localObject2, str1, false);
        break label269;
      }
      sendToDetailPage(paramFragmentComponent, localFeedCommentaryViewModel, paramSingleUpdateDataModel, (Update)localObject2, (String)localObject1, bool1, false);
      break label269;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentary.FeedCommentaryTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */