package com.linkedin.android.feed.page.feed.hero;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class FeedHeroViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<FeedHeroViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968752;
    }
  };
  @InjectView(2131755806)
  public ViewGroup boltOns;
  @InjectView(2131755809)
  public Button dismiss;
  @InjectView(2131755807)
  public View div1;
  @InjectView(2131755812)
  public View div2;
  @InjectView(2131755803)
  public ImageView logo;
  @InjectView(2131755810)
  public Button prompt;
  @InjectView(2131755805)
  public TextView text;
  @InjectView(2131755804)
  public TextView title;
  
  public FeedHeroViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.hero.FeedHeroViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */