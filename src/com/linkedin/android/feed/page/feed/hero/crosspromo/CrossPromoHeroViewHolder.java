package com.linkedin.android.feed.page.feed.hero.crosspromo;

import android.view.View;
import android.view.ViewGroup;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class CrossPromoHeroViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<CrossPromoHeroViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968739;
    }
  };
  @InjectView(2131755754)
  public ViewGroup container;
  
  public CrossPromoHeroViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.crosspromo.CrossPromoHeroViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */