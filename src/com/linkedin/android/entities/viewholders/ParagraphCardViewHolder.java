package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.ui.ExpandableTextView;

public class ParagraphCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<ParagraphCardViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968668;
    }
  };
  @InjectView(2131755538)
  public ExpandableTextView body;
  @InjectView(2131755539)
  public ImageButton button;
  @InjectView(2131755399)
  public ImageView divider;
  @InjectView(2131755537)
  public TextView header;
  @InjectView(2131755400)
  public Button readMoreButton;
  
  public ParagraphCardViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.ParagraphCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */