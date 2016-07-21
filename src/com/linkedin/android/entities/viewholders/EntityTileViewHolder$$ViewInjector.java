package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntityTileViewHolder$$ViewInjector<T extends EntityTileViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    root = ((RelativeLayout)paramFinder.castView((View)paramFinder.findOptionalView(paramObject, 2131755545, null), 2131755545, "field 'root'"));
    icon = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755546, "field 'icon'"), 2131755546, "field 'icon'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755547, "field 'title'"), 2131755547, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755548, "field 'subtitle'"), 2131755548, "field 'subtitle'"));
    detail = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755552, "field 'detail'"), 2131755552, "field 'detail'"));
    detailIcon = ((RoundedImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755551, "field 'detailIcon'"), 2131755551, "field 'detailIcon'"));
    detailDivider = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755550, "field 'detailDivider'"), 2131755550, "field 'detailDivider'"));
  }
  
  public void reset(T paramT)
  {
    root = null;
    icon = null;
    title = null;
    subtitle = null;
    detail = null;
    detailIcon = null;
    detailDivider = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityTileViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */