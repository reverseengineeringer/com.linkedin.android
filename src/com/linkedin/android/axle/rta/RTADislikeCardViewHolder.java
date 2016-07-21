package com.linkedin.android.axle.rta;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class RTADislikeCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<RTADislikeCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968609;
    }
  };
  @InjectView(2131755189)
  ImageView dimBackground;
  @InjectView(2131755193)
  RelativeLayout dismiss;
  @InjectView(2131755194)
  ImageButton dismissButton;
  @InjectView(2131755195)
  EditText editFeedback;
  @InjectView(2131755196)
  Button send;
  @InjectView(2131755192)
  TextView title;
  
  public RTADislikeCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */