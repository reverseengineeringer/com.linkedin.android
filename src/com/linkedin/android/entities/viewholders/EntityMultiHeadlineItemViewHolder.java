package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class EntityMultiHeadlineItemViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968688;
    }
  };
  @InjectView(2131755508)
  public TextView body;
  @InjectView(2131755507)
  public TextView header;
  
  public EntityMultiHeadlineItemViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityMultiHeadlineItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */