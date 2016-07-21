package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.ImageView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class PeopleCarouselItemViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<PeopleCarouselItemViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968670;
    }
  };
  @InjectView(2131755436)
  public ImageView profileImage;
  
  public PeopleCarouselItemViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PeopleCarouselItemViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */