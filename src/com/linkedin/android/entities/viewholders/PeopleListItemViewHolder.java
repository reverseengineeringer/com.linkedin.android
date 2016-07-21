package com.linkedin.android.entities.viewholders;

import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class PeopleListItemViewHolder
  extends BaseViewHolder
{
  @InjectView(2131755510)
  public Button cta;
  @InjectView(2131755512)
  public TextView headline;
  @InjectView(2131755509)
  public RoundedImageView icon;
  @InjectView(2131755511)
  public TextView name;
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PeopleListItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */