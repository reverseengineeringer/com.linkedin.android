package com.linkedin.android.growth.newtovoyager.organic;

import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class NewToVoyagerIntroFeedFragmentViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<NewToVoyagerIntroFeedFragmentViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968822;
    }
  };
  @InjectView(2131756049)
  TextView feedPostTitleTextView;
  @InjectView(2131756046)
  TextView feedTrendTitleTextView;
  @InjectView(2131756052)
  View postCardIcon;
  @InjectView(2131756048)
  CardView postCardView;
  @InjectView(2131756047)
  View trendingCardIcon;
  @InjectView(2131756045)
  CardView trendingCardView;
  
  public NewToVoyagerIntroFeedFragmentViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.organic.NewToVoyagerIntroFeedFragmentViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */