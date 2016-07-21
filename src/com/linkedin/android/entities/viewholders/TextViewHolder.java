package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class TextViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<TextViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968698;
    }
  };
  @InjectView(2131755544)
  public TextView text;
  
  public TextViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.TextViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */