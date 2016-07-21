package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class EmptyStateViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<EmptyStateViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968677;
    }
  };
  @InjectView(2131755462)
  public ImageView image;
  @InjectView(2131755463)
  public TextView message;
  
  public EmptyStateViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EmptyStateViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */