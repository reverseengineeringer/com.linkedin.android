package com.linkedin.android.entities.job.transformers;

import android.content.res.Resources;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.AttributedTextUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.pegasus.gen.voyager.jobs.JobDetails;

public final class JobCardsTransformerV2
{
  public static ParagraphCardViewModel toJobDescriptionCard(FragmentComponent paramFragmentComponent, JobDetails paramJobDetails)
  {
    ParagraphCardViewModel localParagraphCardViewModel = new ParagraphCardViewModel();
    header = paramFragmentComponent.i18NManager().getString(2131230957);
    body = AttributedTextUtils.getAttributedString(description, paramFragmentComponent.context(), null, null, true);
    seeMoreButtonText = paramFragmentComponent.i18NManager().getString(2131231017);
    maxLinesCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558438);
    onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
    return localParagraphCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.transformers.JobCardsTransformerV2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */