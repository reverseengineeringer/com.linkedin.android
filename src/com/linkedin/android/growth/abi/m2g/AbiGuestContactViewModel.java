package com.linkedin.android.growth.abi.m2g;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.support.v7.widget.AppCompatImageButton;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.ui.TintableImageView;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class AbiGuestContactViewModel
  extends ViewModel<AbiGuestContactViewHolder>
{
  public String contactInfo;
  public String contactInitials;
  public int invitationIconInternationalResource = Integer.MIN_VALUE;
  public boolean isSmsContact;
  public String name;
  public TrackingClosure<Void, Void> onItemClickClosure;
  public boolean selected;
  public boolean shouldAddContactInitialsPicture;
  public boolean shouldHighlight;
  
  static void setupInviteClickedButton(AbiGuestContactViewHolder paramAbiGuestContactViewHolder)
  {
    inviteButtonInternational.setVisibility(8);
    inviteButtonInternationalClicked.setVisibility(0);
    inviteButtonInternationalClicked.setSupportBackgroundTintList(ColorStateList.valueOf(inviteButtonInternationalClicked.getResources().getColor(2131623990)));
  }
  
  public final ViewHolderCreator<AbiGuestContactViewHolder> getCreator()
  {
    return AbiGuestContactViewHolder.CREATOR;
  }
  
  public final String toString()
  {
    return name;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.m2g.AbiGuestContactViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */