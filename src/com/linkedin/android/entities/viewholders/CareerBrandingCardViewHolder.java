package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.entities.shared.InterceptOnTouchEventLayout;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;

public class CareerBrandingCardViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968663;
    }
  };
  public EntityListCardViewHolder entityListCardViewHolder;
  @InjectView(2131755410)
  public ImageView image;
  @InjectView(2131755412)
  public View linksView;
  public ParagraphCardViewHolder paragraphCardViewHolder;
  @InjectView(2131755411)
  public View paragraphView;
  @InjectView(2131755409)
  public TextView subtitle;
  @InjectView(2131755408)
  public TextView title;
  @InjectView(2131755407)
  public WebView webView;
  @InjectView(2131755406)
  public InterceptOnTouchEventLayout webviewContainer;
  
  private CareerBrandingCardViewHolder(View paramView)
  {
    super(paramView);
    paragraphCardViewHolder = new ParagraphCardViewHolder(paramView);
    entityListCardViewHolder = new EntityListCardViewHolder(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.CareerBrandingCardViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */