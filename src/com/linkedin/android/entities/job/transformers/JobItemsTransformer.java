package com.linkedin.android.entities.job.transformers;

import android.widget.ImageView;
import com.linkedin.android.entities.job.JobDataProvider;
import com.linkedin.android.entities.viewmodels.items.EntityItemViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.CompanyRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.job.analytics.SchoolRanking;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.Map;

public final class JobItemsTransformer
{
  static EntityItemViewModel toCompanyRankingItem(final FragmentComponent paramFragmentComponent, CompanyRanking paramCompanyRanking, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
    final MiniCompany localMiniCompany = miniCompany;
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    String str2 = Util.retrieveRumSessionId(paramFragmentComponent);
    title = name;
    if (viewerFromCompany) {}
    for (String str1 = localI18NManager.getString(2131230994);; str1 = null)
    {
      superTitle = str1;
      subtitle = localI18NManager.getString(2131231071, new Object[] { Long.valueOf(count) });
      image = new ImageModel(logo, GhostImageUtils.getCompany(2131492963, localMiniCompany), str2);
      isImageOval = false;
      onRowClick = new TrackingClosure(paramFragmentComponent.tracker(), "company_link") {};
      trackingEventBuilderClosure = paramClosure;
      return localEntityItemViewModel;
    }
  }
  
  static EntityItemViewModel toSchoolRankingItem(final FragmentComponent paramFragmentComponent, SchoolRanking paramSchoolRanking, Closure<ImpressionData, TrackingEventBuilder> paramClosure)
  {
    EntityItemViewModel localEntityItemViewModel = new EntityItemViewModel();
    final MiniSchool localMiniSchool = miniSchool;
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    String str2 = Util.retrieveRumSessionId(paramFragmentComponent);
    title = schoolName;
    if (viewerFromSchool) {}
    for (String str1 = localI18NManager.getString(2131230995);; str1 = null)
    {
      superTitle = str1;
      subtitle = localI18NManager.getString(2131231071, new Object[] { Long.valueOf(count) });
      image = new ImageModel(logo, GhostImageUtils.getSchool(2131492963, localMiniSchool), str2);
      isImageOval = false;
      onRowClick = new TrackingClosure(paramFragmentComponent.tracker(), "school_link") {};
      trackingEventBuilderClosure = paramClosure;
      return localEntityItemViewModel;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobItemsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */