package com.linkedin.android.entities.viewholders;

import android.view.View;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.ui.expandableview.ExpandableView;

public class MultiHeadlineCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<MultiHeadlineCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968666;
    }
  };
  @InjectView(2131755422)
  public ExpandableView multiHeadlineView;
  
  public MultiHeadlineCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.MultiHeadlineCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */