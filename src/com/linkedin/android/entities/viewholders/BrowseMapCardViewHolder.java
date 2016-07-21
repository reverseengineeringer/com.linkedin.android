package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.entities.cards.BrowseMapTileView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class BrowseMapCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968661;
    }
  };
  @InjectView(2131755403)
  public BrowseMapTileView browseMapTileView;
  @InjectView(2131755402)
  public TextView header;
  
  private BrowseMapCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.BrowseMapCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */