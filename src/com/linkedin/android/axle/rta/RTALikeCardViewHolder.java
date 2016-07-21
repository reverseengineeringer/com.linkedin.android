package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class RTALikeCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<RTALikeCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968613;
    }
  };
  @InjectView(2131755217)
  Button dismiss;
  @InjectView(2131755218)
  Button send;
  @InjectView(2131755216)
  TextView title;
  
  public RTALikeCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTALikeCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */