package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.entities.shared.AutofitTextButton;

public class EntityDetailedTopCardViewHolder$$ViewInjector<T extends EntityDetailedTopCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    coverView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755554, "field 'coverView'"), 2131755554, "field 'coverView'"));
    coverImageTopGradientView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755556, "field 'coverImageTopGradientView'"), 2131755556, "field 'coverImageTopGradientView'"));
    coverImageBottomGradientView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755557, "field 'coverImageBottomGradientView'"), 2131755557, "field 'coverImageBottomGradientView'"));
    iconView = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755562, "field 'iconView'"), 2131755562, "field 'iconView'"));
    titleView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755564, "field 'titleView'"), 2131755564, "field 'titleView'"));
    subtitleView1 = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755565, "field 'subtitleView1'"), 2131755565, "field 'subtitleView1'"));
    subtitleView2 = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755566, "field 'subtitleView2'"), 2131755566, "field 'subtitleView2'"));
    overlayContainer = ((RelativeLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755558, "field 'overlayContainer'"), 2131755558, "field 'overlayContainer'"));
    detailView = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755571, "field 'detailView'"), 2131755571, "field 'detailView'"));
    buttonContainer = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755567, "field 'buttonContainer'"), 2131755567, "field 'buttonContainer'"));
    primaryButton = ((AutofitTextButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755569, "field 'primaryButton'"), 2131755569, "field 'primaryButton'"));
    primaryButtonClicked = ((AutofitTextButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755570, "field 'primaryButtonClicked'"), 2131755570, "field 'primaryButtonClicked'"));
    secondaryButton = ((AutofitTextButton)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755568, "field 'secondaryButton'"), 2131755568, "field 'secondaryButton'"));
  }
  
  public void reset(T paramT)
  {
    coverView = null;
    coverImageTopGradientView = null;
    coverImageBottomGradientView = null;
    iconView = null;
    titleView = null;
    subtitleView1 = null;
    subtitleView2 = null;
    overlayContainer = null;
    detailView = null;
    buttonContainer = null;
    primaryButton = null;
    primaryButtonClicked = null;
    secondaryButton = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityDetailedTopCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */