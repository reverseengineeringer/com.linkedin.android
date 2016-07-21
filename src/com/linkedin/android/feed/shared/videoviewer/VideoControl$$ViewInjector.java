package com.linkedin.android.feed.shared.videoviewer;

import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class VideoControl$$ViewInjector<T extends VideoControl>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    container = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755876, "field 'container'"), 2131755876, "field 'container'"));
    header = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755877, "field 'header'"), 2131755877, "field 'header'"));
    rewButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755878, "field 'rewButton'"), 2131755878, "field 'rewButton'"));
    pauseButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755879, "field 'pauseButton'"), 2131755879, "field 'pauseButton'"));
    ffwdButton = ((ImageButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755880, "field 'ffwdButton'"), 2131755880, "field 'ffwdButton'"));
    footer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755881, "field 'footer'"), 2131755881, "field 'footer'"));
    currentTimeText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755882, "field 'currentTimeText'"), 2131755882, "field 'currentTimeText'"));
    seekBar = ((SeekBar)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755883, "field 'seekBar'"), 2131755883, "field 'seekBar'"));
    endTimeText = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755884, "field 'endTimeText'"), 2131755884, "field 'endTimeText'"));
  }
  
  public void reset(T paramT)
  {
    container = null;
    header = null;
    rewButton = null;
    pauseButton = null;
    ffwdButton = null;
    footer = null;
    currentTimeText = null;
    seekBar = null;
    endTimeText = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.videoviewer.VideoControl..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */