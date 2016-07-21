package com.linkedin.android.growth.login.prereg.intro;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.ButterKnife.Finder;
import com.linkedin.android.artdeco.components.HorizontalViewPagerCarousel;
import com.linkedin.android.growth.login.prereg.PreRegPropFragment..ViewInjector;

public class PreRegIntroFragment$$ViewInjector<T extends PreRegIntroFragment>
  extends PreRegPropFragment..ViewInjector<T>
{
  public void inject(ButterKnife.Finder paramFinder, T paramT, Object paramObject)
  {
    super.inject(paramFinder, paramT, paramObject);
    linearLayout = ((LinearLayout)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756189, "field 'linearLayout'"), 2131756189, "field 'linearLayout'"));
    scrollView = ((ScrollView)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756188, "field 'scrollView'"), 2131756188, "field 'scrollView'"));
    carousel = ((HorizontalViewPagerCarousel)paramFinder.castView((View)paramFinder.findRequiredView(paramObject, 2131756193, "field 'carousel'"), 2131756193, "field 'carousel'"));
  }
  
  public void reset(T paramT)
  {
    super.reset(paramT);
    linearLayout = null;
    scrollView = null;
    carousel = null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.prereg.intro.PreRegIntroFragment..ViewInjector
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */