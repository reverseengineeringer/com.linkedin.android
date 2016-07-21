package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class RTADislikeConfirmCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<RTADislikeConfirmCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968610;
    }
  };
  @InjectView(2131755192)
  TextView title;
  
  public RTADislikeConfirmCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeConfirmCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */