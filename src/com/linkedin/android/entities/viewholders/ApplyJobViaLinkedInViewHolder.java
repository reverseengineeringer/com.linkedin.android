package com.linkedin.android.entities.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.makeramen.roundedimageview.RoundedImageView;

public class ApplyJobViaLinkedInViewHolder
  extends BaseViewHolder
{
  public static final ViewHolderCreator<ApplyJobViaLinkedInViewHolder> CREATOR = new ViewHolderCreator()
  {
    public final int getLayoutId()
    {
      return 2130968694;
    }
  };
  @InjectView(2131755535)
  public RoundedImageView actorImage;
  @InjectView(2131755536)
  public ImageButton closeModalButton;
  @InjectView(2131755532)
  public Button editProfileButton;
  @InjectView(2131755526)
  public EditText emailInput;
  @InjectView(2131755524)
  public TextView headline;
  @InjectView(2131755533)
  public View loadingOverlay;
  @InjectView(2131755534)
  public ProgressBar loadingSpinner;
  @InjectView(2131755525)
  public TextView location;
  @InjectView(2131755523)
  public TextView name;
  @InjectView(2131755528)
  public EditText phoneInput;
  @InjectView(2131755531)
  public Button submitApplicationButton;
  
  private ApplyJobViaLinkedInViewHolder(View paramView)
  {
    super(paramView);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */