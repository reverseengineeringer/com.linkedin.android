package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class RTADislikeCardViewHolder$$ViewInjector<T extends RTADislikeCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    dimBackground = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755189, "field 'dimBackground'"), 2131755189, "field 'dimBackground'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755192, "field 'title'"), 2131755192, "field 'title'"));
    editFeedback = ((EditText)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755195, "field 'editFeedback'"), 2131755195, "field 'editFeedback'"));
    dismissButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755194, "field 'dismissButton'"), 2131755194, "field 'dismissButton'"));
    dismiss = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755193, "field 'dismiss'"), 2131755193, "field 'dismiss'"));
    send = ((Button)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755196, "field 'send'"), 2131755196, "field 'send'"));
  }
  
  public void reset(T paramT)
  {
    dimBackground = null;
    title = null;
    editFeedback = null;
    dismissButton = null;
    dismiss = null;
    send = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */