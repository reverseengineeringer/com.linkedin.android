package com.linkedin.android.entities.jymbii;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.view.animation.AnimationUtils;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.EntityViewAllListBaseFragment.DataLoadListener;
import com.linkedin.android.entities.jymbii.transformers.JymbiiTransformer.1;
import com.linkedin.android.entities.jymbii.transformers.JymbiiTransformer.2;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.feed.endor.ui.component.insight.FeedInsightTransformer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesFlavor;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.ExternalCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate.Company;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

final class JymbiiFragment$3
  extends EntityViewAllListBaseFragment.DataLoadListener<Jymbii>
{
  JymbiiFragment$3(JymbiiFragment paramJymbiiFragment)
  {
    super(paramJymbiiFragment);
  }
  
  protected final List<EntityItemViewModel> transformModels(CollectionTemplate<Jymbii, CollectionMetadata> paramCollectionTemplate)
  {
    FragmentComponent localFragmentComponent = this$0.fragmentComponent;
    if (CollectionUtils.isEmpty(paramCollectionTemplate)) {
      return null;
    }
    boolean bool2 = EntityUtils.isLixEnabled(localFragmentComponent.lixManager(), Lix.ENTITIES_JYMBII_NEW_TAG);
    boolean bool3 = EntityUtils.isLixEnabled(localFragmentComponent.lixManager(), Lix.ENTITIES_JYMBII_SUBTITLE_CHANGE);
    ArrayList localArrayList = new ArrayList();
    paramCollectionTemplate = elements.iterator();
    if (paramCollectionTemplate.hasNext())
    {
      Jymbii localJymbii = (Jymbii)paramCollectionTemplate.next();
      Object localObject = localFragmentComponent.context();
      MiniJob localMiniJob = jymbiiUpdate.miniJob;
      EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
      title = title;
      label220:
      label258:
      boolean bool1;
      if (bool3)
      {
        subtitle = jymbiiUpdate.company.externalCompanyValue.companyName;
        if (hasLocation)
        {
          subtitle2 = location;
          subtitle2Icon = DrawableHelper.setTint(ContextCompat.getDrawable((Context)localObject, 2130838119), ResourcesCompat.getColor(((Context)localObject).getResources(), 2131624084, ((Context)localObject).getTheme()));
          i = ((Context)localObject).getResources().getDimensionPixelSize(2131493082);
          subtitle2Icon.setBounds(0, 0, i, i);
        }
        if (hasListedAt)
        {
          localFragmentComponent.timeWrapper();
          if ((System.currentTimeMillis() - listedAt) / 3600000L >= 24L) {
            break label639;
          }
          i = 1;
          if ((!bool2) || (i == 0)) {
            break label644;
          }
          bool1 = true;
          label269:
          showNewBadge = bool1;
          if (!showNewBadge)
          {
            badge = DateUtils.getTimestampText(listedAt, localFragmentComponent.i18NManager());
            badgeContentDescription = DateUtils.getTimeAgoContentDescription(listedAt, localFragmentComponent.i18NManager());
          }
        }
        if (linkedInApplication)
        {
          footerText = localFragmentComponent.i18NManager().getString(2131230947);
          footerIcon = DrawableHelper.setTint(ContextCompat.getDrawable((Context)localObject, 2130838557), ResourcesCompat.getColor(((Context)localObject).getResources(), 2131623968, ((Context)localObject).getTheme()));
          i = footerIcon.getIntrinsicWidth();
          footerIcon.setBounds(0, 0, i, i);
        }
        image = new ImageModel(logo, GhostImageUtils.getJob(2131492963, localMiniJob), Util.retrieveRumSessionId(localFragmentComponent));
        onRowClick = new JymbiiTransformer.1(localFragmentComponent.tracker(), "job_link", localMiniJob, localFragmentComponent);
        localObject = jymbiiUpdate.flavors;
        if (CollectionUtils.isNonEmpty((Collection)localObject))
        {
          insight = FeedInsightTransformer.toInsightViewModel((EntitiesFlavor)((List)localObject).get(0), localFragmentComponent, null, 2);
          if (localFragmentComponent.deviceClass() < 2012) {
            break label649;
          }
        }
      }
      label639:
      label644:
      label649:
      for (int i = 1;; i = 0)
      {
        if ((i != 0) && (EntityUtils.isLixEnabled(localFragmentComponent.lixManager(), Lix.ENTITIES_ANIMATED_FLAVORS))) {
          insightAnimation = AnimationUtils.loadAnimation(localFragmentComponent.context(), 2131034128);
        }
        trackingEventBuilderClosure = new JymbiiTransformer.2(localJymbii, localFragmentComponent);
        localArrayList.add(localEntityItemViewModel);
        break;
        subtitle = localFragmentComponent.i18NManager().getString(2131230969, new Object[] { jymbiiUpdate.company.externalCompanyValue.companyName, Boolean.valueOf(hasLocation), location });
        break label220;
        i = 0;
        break label258;
        bool1 = false;
        break label269;
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.JymbiiFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */