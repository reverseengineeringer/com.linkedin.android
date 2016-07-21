package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntityInsightViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968686;
    }
  };
  @InjectView(2131755503)
  public LinearLayout container;
  @InjectView(2131755504)
  public RoundedImageView image;
  @InjectView(2131755505)
  public TextView title;
  
  private EntityInsightViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntityInsightViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */