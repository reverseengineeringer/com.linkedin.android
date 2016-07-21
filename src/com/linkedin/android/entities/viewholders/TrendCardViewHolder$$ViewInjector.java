package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.LineChart;

public class TrendCardViewHolder$$ViewInjector<T extends TrendCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    header = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755396, "field 'header'"), 2131755396, "field 'header'"));
    insightText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755449, "field 'insightText'"), 2131755449, "field 'insightText'"));
    footerText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755457, "field 'footerText'"), 2131755457, "field 'footerText'"));
    divider = ((View)paramFinder.findRequiredView(paramObject, 2131755456, "field 'divider'"));
    lineChart = ((LineChart)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755450, "field 'lineChart'"), 2131755450, "field 'lineChart'"));
    yAxisTop = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755451, "field 'yAxisTop'"), 2131755451, "field 'yAxisTop'"));
    yAxisBottom = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755452, "field 'yAxisBottom'"), 2131755452, "field 'yAxisBottom'"));
    startDate = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755454, "field 'startDate'"), 2131755454, "field 'startDate'"));
    endDate = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755455, "field 'endDate'"), 2131755455, "field 'endDate'"));
  }
  
  public void reset(T paramT)
  {
    header = null;
    insightText = null;
    footerText = null;
    divider = null;
    lineChart = null;
    yAxisTop = null;
    yAxisBottom = null;
    startDate = null;
    endDate = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.TrendCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */