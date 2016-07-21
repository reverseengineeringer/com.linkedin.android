package com.linkedin.android.entities.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class PeopleCarouselViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<PeopleCarouselViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968669;
    }
  };
  @InjectView(2131755434)
  public TextView captionView;
  @InjectView(2131755428)
  public TextView cardTitleView;
  @InjectView(2131755435)
  public TextView ctaButton;
  @InjectView(2131755432)
  public TextView headlineView;
  @InjectView(2131755430)
  public View infoContainer;
  @InjectView(2131755431)
  public TextView nameView;
  @InjectView(2131755429)
  public RecyclerView recyclerView;
  @InjectView(2131755433)
  public ImageView separator;
  
  public PeopleCarouselViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.PeopleCarouselViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */