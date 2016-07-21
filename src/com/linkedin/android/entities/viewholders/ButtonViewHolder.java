package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class ButtonViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968662;
    }
  };
  @InjectView(2131755404)
  public Button button;
  
  private ButtonViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.ButtonViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */