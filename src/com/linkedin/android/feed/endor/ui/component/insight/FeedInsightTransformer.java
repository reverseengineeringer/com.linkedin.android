package com.linkedin.android.feed.endor.ui.component.insight;

import android.content.Context;
import com.linkedin.android.feed.endor.datamodel.actor.CompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.JobContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.ViralSingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.CompanyRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor.Reason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.InNetworkReason;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.SchoolRecruitReason;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class FeedInsightTransformer
{
  public static FeedInsightViewModel toInsightViewModel(EntitiesFlavor paramEntitiesFlavor, FragmentComponent paramFragmentComponent, TrackingOnClickListener paramTrackingOnClickListener, int paramInt)
  {
    Object localObject2 = null;
    Object localObject3 = reason;
    int i;
    switch (paramInt)
    {
    default: 
      paramEntitiesFlavor = null;
      localObject1 = localObject2;
      if (paramEntitiesFlavor != null)
      {
        if (companyRecruitReasonValue == null) {
          break label425;
        }
        localObject2 = companyRecruitReasonValue;
        localObject1 = new FeedInsightViewModel(paramEntitiesFlavor);
        paramEntitiesFlavor = currentCompany;
        if ((paramInt != 4) || (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMPANY_UPDATE_INSIGHT_DISPLAY_COMPANY_LOGO))) {
          break label301;
        }
        i = 1;
        label108:
        localObject3 = Util.retrieveRumSessionId(paramFragmentComponent);
        if (i == 0) {
          break label307;
        }
        paramEntitiesFlavor = new ImageModel(null, new GhostImage(2131493129, 2131624051, 2130837960, 2131623957, 1), (String)localObject3);
        label146:
        images = Collections.singletonList(paramEntitiesFlavor);
        paramEntitiesFlavor = paramFragmentComponent.i18NManager();
        i = totalNumberOfPastCoworkers;
        switch (paramInt)
        {
        case 3: 
        default: 
          text = paramEntitiesFlavor.getSpannedString(2131230903, new Object[] { Integer.valueOf(i) });
        }
      }
      break;
    }
    label301:
    label307:
    label425:
    label454:
    label484:
    label532:
    label616:
    label621:
    label834:
    do
    {
      for (;;)
      {
        if ((localObject1 != null) && (paramTrackingOnClickListener != null)) {
          containerClickListener = paramTrackingOnClickListener;
        }
        return (FeedInsightViewModel)localObject1;
        paramEntitiesFlavor = new FeedInsightLayout(paramFragmentComponent.context().getResources());
        break;
        paramEntitiesFlavor = new EntityInsightLayout(paramFragmentComponent.context().getResources());
        break;
        paramEntitiesFlavor = new FeedActorInsightLayout(paramFragmentComponent.context().getResources());
        break;
        i = 0;
        break label108;
        paramEntitiesFlavor = new ImageModel(logo, GhostImageUtils.getCompany(2131493129, paramEntitiesFlavor), (String)localObject3);
        break label146;
        text = paramEntitiesFlavor.getSpannedString(2131230904, new Object[] { Integer.valueOf(i) });
        continue;
        boolean bool = FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.ENTITIES_COMPANY_RECRUIT_INSIGHT_ALT_TEXT);
        if ((paramInt == 4) && (bool)) {}
        for (paramInt = 2131230902;; paramInt = 2131230901)
        {
          text = paramEntitiesFlavor.getSpannedString(paramInt, new Object[] { Integer.valueOf(i), currentCompany.name });
          break;
        }
        if (inNetworkReasonValue == null) {
          break label834;
        }
        localObject2 = inNetworkReasonValue;
        if (totalNumberOfConnections > 0) {
          break label454;
        }
        localObject1 = null;
      }
      localObject1 = new FeedInsightViewModel(paramEntitiesFlavor);
      paramEntitiesFlavor = paramFragmentComponent.i18NManager();
      int j = 2131230934;
      if (paramInt == 2)
      {
        i = 2131230936;
        text = paramEntitiesFlavor.getSpannedString(i, new Object[] { Integer.valueOf(totalNumberOfConnections) });
        if ((paramInt != 4) || (FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.FEED_COMPANY_UPDATE_INSIGHT_DISPLAY_PROFILE_PICTURES))) {
          break label616;
        }
        paramInt = 1;
        if (paramInt == 0) {
          break label621;
        }
        images = Collections.singletonList(new ImageModel(null, new GhostImage(2131493129, 2131624051, 2130838228, 2131623957, 0), Util.retrieveRumSessionId(paramFragmentComponent)));
      }
      for (;;)
      {
        isImageOval = true;
        break;
        i = j;
        if (paramInt != 4) {
          break label484;
        }
        i = j;
        if (!FeedLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.ENTITIES_COMPANY_RECRUIT_INSIGHT_ALT_TEXT)) {
          break label484;
        }
        i = 2131230935;
        break label484;
        paramInt = 0;
        break label532;
        images = new ArrayList();
        paramEntitiesFlavor = images;
        localObject3 = topConnections;
        if (!((List)localObject3).isEmpty())
        {
          EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)((List)localObject3).get(0);
          localObject2 = GhostImageUtils.getPerson(2131493129, miniProfile);
          paramFragmentComponent = Util.retrieveRumSessionId(paramFragmentComponent);
          paramEntitiesFlavor.add(new ImageModel(miniProfile.picture, (GhostImage)localObject2, paramFragmentComponent));
          if (((List)localObject3).size() >= 2)
          {
            localEntitiesMiniProfile = (EntitiesMiniProfile)((List)localObject3).get(1);
            if (miniProfile.picture != null) {
              paramEntitiesFlavor.add(0, new ImageModel(miniProfile.picture, (GhostImage)localObject2, paramFragmentComponent));
            }
          }
          if (((List)localObject3).size() >= 3)
          {
            localObject3 = (EntitiesMiniProfile)((List)localObject3).get(2);
            if (miniProfile.picture != null) {
              paramEntitiesFlavor.add(0, new ImageModel(miniProfile.picture, (GhostImage)localObject2, paramFragmentComponent));
            }
          }
        }
      }
      localObject1 = localObject2;
    } while (schoolRecruitReasonValue == null);
    localObject2 = schoolRecruitReasonValue;
    Object localObject1 = new FeedInsightViewModel(paramEntitiesFlavor);
    paramEntitiesFlavor = paramFragmentComponent.i18NManager();
    localObject3 = mostRecentSchool;
    images = Collections.singletonList(new ImageModel(logo, GhostImageUtils.getSchool(2131493129, (MiniSchool)localObject3), Util.retrieveRumSessionId(paramFragmentComponent)));
    if (paramInt == 2) {}
    for (paramInt = 2131231022;; paramInt = 2131231021)
    {
      text = paramEntitiesFlavor.getSpannedString(paramInt, new Object[] { Integer.valueOf(totalNumberOfAlumni) });
      break;
    }
  }
  
  public static FeedInsightViewModel toViewModel(UpdateDataModel paramUpdateDataModel, FragmentComponent paramFragmentComponent)
  {
    if ((paramUpdateDataModel instanceof JymbiiUpdateDataModel))
    {
      JobContentDataModel localJobContentDataModel = (JobContentDataModel)UpdateDataModel.getContentDataModel(paramUpdateDataModel);
      JymbiiUpdateDataModel localJymbiiUpdateDataModel = (JymbiiUpdateDataModel)paramUpdateDataModel;
      if (CollectionUtils.isNonEmpty(insights)) {
        return toInsightViewModel((EntitiesFlavor)insights.get(0), paramFragmentComponent, FeedTracking.newJobClickListener(metadata, paramFragmentComponent, pegasusUpdate), 1);
      }
    }
    else if ((paramUpdateDataModel instanceof SingleUpdateDataModel))
    {
      if ((paramUpdateDataModel instanceof ViralSingleUpdateDataModel)) {
        paramUpdateDataModel = originalUpdate;
      }
      while ((primaryActor instanceof CompanyActorDataModel)) {
        if (FeedViewTransformerHelpers.getFeedType(paramFragmentComponent) == 7)
        {
          return null;
          paramUpdateDataModel = (SingleUpdateDataModel)paramUpdateDataModel;
        }
        else
        {
          paramUpdateDataModel = (CompanyActorDataModel)primaryActor;
          if (CollectionUtils.isNonEmpty(insights)) {
            return toInsightViewModel((EntitiesFlavor)insights.get(0), paramFragmentComponent, null, 4);
          }
        }
      }
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.insight.FeedInsightTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */