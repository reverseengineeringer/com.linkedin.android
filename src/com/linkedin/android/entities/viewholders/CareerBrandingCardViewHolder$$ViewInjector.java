package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;
import com.linkedin.android.entities.shared.InterceptOnTouchEventLayout;

public class CareerBrandingCardViewHolder$$ViewInjector<T extends CareerBrandingCardViewHolder>
  implements ButterKnife.Injector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    image = ((ImageView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755410, "field 'image'"), 2131755410, "field 'image'"));
    webView = ((WebView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755407, "field 'webView'"), 2131755407, "field 'webView'"));
    title = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755408, "field 'title'"), 2131755408, "field 'title'"));
    subtitle = ((TextView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755409, "field 'subtitle'"), 2131755409, "field 'subtitle'"));
    webviewContainer = ((InterceptOnTouchEventLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131755406, "field 'webviewContainer'"), 2131755406, "field 'webviewContainer'"));
    paragraphView = ((View)paramFinder.findRequiredView(paramObject, 2131755411, "field 'paragraphView'"));
    linksView = ((View)paramFinder.findRequiredView(paramObject, 2131755412, "field 'linksView'"));
  }
  
  public void reset(T paramT)
  {
    image = null;
    webView = null;
    title = null;
    subtitle = null;
    webviewContainer = null;
    paragraphView = null;
    linksView = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.CareerBrandingCardViewHolder..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */