package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class RTAFirstCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<RTAFirstCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968611;
    }
  };
  @InjectView(2131755204)
  RelativeLayout cancel;
  @InjectView(2131755205)
  ImageButton cancelButton;
  @InjectView(2131755200)
  ImageView icon;
  @InjectView(2131755202)
  Button leftButton;
  @InjectView(2131755203)
  Button rightButton;
  @InjectView(2131755201)
  TextView title;
  
  public RTAFirstCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTAFirstCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */