package com.linkedin.android.entities.company.transformers;

import android.content.res.Resources;
import android.widget.ImageView;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.company.CompanyDataProvider;
import com.linkedin.android.entities.shared.WebViewerOnClickListener;
import com.linkedin.android.entities.viewmodels.cards.EntityListCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.entities.viewmodels.items.EntityTileViewModel;
import com.linkedin.android.entities.viewmodels.items.LinkItemViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.Link;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class CompanyItemsTransformer
{
  public static EntityListCardViewModel toCareerBrandingLinks(FragmentComponent paramFragmentComponent, List<Link> paramList)
  {
    EntityListCardViewModel localEntityListCardViewModel = new EntityListCardViewModel();
    header = paramFragmentComponent.i18NManager().getString(2131230864);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Link localLink = (Link)localIterator.next();
      LinkItemViewModel localLinkItemViewModel = new LinkItemViewModel();
      linkText = text;
      clickListener = new WebViewerOnClickListener(url, text, paramFragmentComponent, "open_link", new TrackingEventBuilder[0]);
      items.add(localLinkItemViewModel);
    }
    hideDividerAndUpdateHeaderPadding = true;
    entityListCardMaxRows = paramList.size();
    return localEntityListCardViewModel;
  }
  
  public static ParagraphCardViewModel toCareerBrandingParagraph(FragmentComponent paramFragmentComponent, String paramString1, String paramString2)
  {
    ParagraphCardViewModel localParagraphCardViewModel = new ParagraphCardViewModel();
    header = paramString1;
    body = paramString2;
    maxLinesCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558439);
    onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
    return localParagraphCardViewModel;
  }
  
  public static EntityTileViewModel toJobTile(final FragmentComponent paramFragmentComponent, final MiniJob paramMiniJob)
  {
    EntityTileViewModel localEntityTileViewModel = new EntityTileViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    icon = new ImageModel(logo, GhostImageUtils.getJob(2131492963, paramMiniJob), Util.retrieveRumSessionId(paramFragmentComponent));
    title = title;
    subtitle = location;
    if (hasListDate) {
      detail = EntityTransformer.toPostedTimeAgoString$3d933973(localI18NManager, localI18NManager.getString(2131230971), listDate, System.currentTimeMillis(), false);
    }
    onPrimaryClick = new TrackingClosure(paramFragmentComponent.tracker(), "job_link") {};
    return localEntityTileViewModel;
  }
  
  public static EntityItemViewModel toShowcaseItem(final FragmentComponent paramFragmentComponent, final BasicCompanyInfo paramBasicCompanyInfo, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    final CompanyDataProvider localCompanyDataProvider = activityactivityComponent.companyDataProvider();
    EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
    final Map localMap = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
    title = miniCompany.name;
    if (hasFollowerCount) {}
    for (String str = paramFragmentComponent.i18NManager().getString(2131230900, new Object[] { Integer.valueOf(followerCount) });; str = null)
    {
      subtitle = str;
      image = new ImageModel(miniCompany.logo, GhostImageUtils.getCompany(2131492963, miniCompany), Util.retrieveRumSessionId(paramFragmentComponent));
      onRowClick = new TrackingClosure(paramFragmentComponent.tracker(), "showcase_link") {};
      ctaButtonIcon = 2130838247;
      ctaClickedButtonIcon = 2130837936;
      isCtaButtonClicked = followingInfo.following;
      onCtaButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "company_follow_toggle") {};
      trackingEventBuilderClosure = paramClosure;
      return localEntityItemViewModel;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyItemsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */