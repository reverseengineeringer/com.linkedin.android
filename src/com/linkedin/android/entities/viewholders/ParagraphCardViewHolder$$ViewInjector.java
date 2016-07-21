package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.infra.ui.ExpandableTextView;

public class ParagraphCardViewHolder$$ViewInjector<T extends ParagraphCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    header = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755537, "field 'header'"), 2131755537, "field 'header'"));
    body = ((ExpandableTextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755538, "field 'body'"), 2131755538, "field 'body'"));
    button = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755539, "field 'button'"), 2131755539, "field 'button'"));
    readMoreButton = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755400, "field 'readMoreButton'"), 2131755400, "field 'readMoreButton'"));
    divider = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755399, "field 'divider'"), 2131755399, "field 'divider'"));
  }
  
  public void reset(T paramT)
  {
    header = null;
    body = null;
    button = null;
    readMoreButton = null;
    divider = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.ParagraphCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */