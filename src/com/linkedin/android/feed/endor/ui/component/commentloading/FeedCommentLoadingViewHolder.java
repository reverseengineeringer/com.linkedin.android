package com.linkedin.android.feed.endor.ui.component.commentloading;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedCommentLoadingViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedCommentLoadingViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968715;
    }
  };
  @InjectView(2131755640)
  public View bottomDivider;
  @InjectView(2131755641)
  public ProgressBar progressBar;
  @InjectView(2131755642)
  public ProgressBar spinner;
  @InjectView(2131755638)
  public TextView title;
  @InjectView(2131755639)
  public View topDivider;
  
  public FeedCommentLoadingViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */