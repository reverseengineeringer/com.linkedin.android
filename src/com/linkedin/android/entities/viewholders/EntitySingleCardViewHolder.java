package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class EntitySingleCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968665;
    }
  };
  @InjectView(2131755396)
  public TextView cardHeader;
  @InjectView(2131755416)
  public ImageView divider;
  @InjectView(2131755419)
  public TextView peopleInCommonCaption;
  @InjectView(2131755417)
  public LinearLayout peopleInCommonContainer;
  @InjectView(2131755418)
  public RoundedImageView peopleInCommonImage1;
  @InjectView(2131755414)
  public ViewGroup profileLayout;
  @InjectView(2131755420)
  public Button viewAllButton;
  @InjectView(2131755399)
  public ImageView viewAllDivider;
  
  private EntitySingleCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.EntitySingleCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */