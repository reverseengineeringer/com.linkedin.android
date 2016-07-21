package com.linkedin.android.feed.endor.ui.component.collapse;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;

public class FeedCollapseViewHolder
  extends BaseFeedViewHolder
{
  public static final ViewHolderCreator<FeedCollapseViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968713;
    }
  };
  @InjectView(2131755618)
  Button improveMyFeed;
  @InjectView(2131755616)
  TextView subtitle;
  @InjectView(2131755615)
  TextView title;
  @InjectView(2131755617)
  Button undo;
  
  public FeedCollapseViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.collapse.FeedCollapseViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */