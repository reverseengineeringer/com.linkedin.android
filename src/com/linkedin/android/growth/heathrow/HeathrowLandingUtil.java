package com.linkedin.android.growth.heathrow;

import android.text.Spanned;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.heathrow.UserActionType;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.relationships.connectFlow.ConnectFlowActionHelper;
import com.linkedin.android.relationships.connectFlow.ConnectFlowMiniTopCardViewHolder;
import com.linkedin.android.relationships.connectFlow.ConnectFlowMiniTopCardViewModel;

public final class HeathrowLandingUtil
{
  public static Spanned getContextualLandingText(HeathrowSource paramHeathrowSource, I18NManager paramI18NManager, MiniProfile paramMiniProfile)
  {
    paramMiniProfile = I18NManager.getName(paramMiniProfile);
    switch (paramHeathrowSource.getUserActionType())
    {
    default: 
      return paramI18NManager.getSpannedString(2131231416, new Object[] { paramMiniProfile });
    case ???: 
      return paramI18NManager.getSpannedString(2131231417, new Object[] { paramMiniProfile });
    case ???: 
      return paramI18NManager.getSpannedString(2131231416, new Object[] { paramMiniProfile });
    }
    return paramI18NManager.getSpannedString(2131231418, new Object[] { paramMiniProfile });
  }
  
  public static void setupTopCard$21706835(FragmentComponent paramFragmentComponent, MediaCenter paramMediaCenter, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, MiniProfile paramMiniProfile, boolean paramBoolean, HeathrowSource paramHeathrowSource)
  {
    if ((paramMiniProfile != null) && (paramHeathrowSource != null))
    {
      paramRelativeLayout = (ConnectFlowMiniTopCardViewHolder)ConnectFlowMiniTopCardViewHolder.CREATOR.createViewHolder(paramRelativeLayout);
      ConnectFlowMiniTopCardViewModel localConnectFlowMiniTopCardViewModel = new ConnectFlowMiniTopCardViewModel();
      headline = getContextualLandingText(paramHeathrowSource, paramFragmentComponent.i18NManager(), paramMiniProfile);
      profileImage = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, paramMiniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
      cellClickListener = ConnectFlowActionHelper.createViewProfileClickListener(paramFragmentComponent, paramMiniProfile);
      if (paramHeathrowSource.getUserActionType() == UserActionType.CONNECT) {
        showMessageButton = false;
      }
      for (;;)
      {
        localConnectFlowMiniTopCardViewModel.onBindViewHolder$30e3123a(paramMediaCenter, paramRelativeLayout);
        if (!paramBoolean) {
          itemView.setEnabled(false);
        }
        paramLinearLayout.setVisibility(0);
        return;
        showMessageButton = true;
        messageButtonClickListener = ConnectFlowActionHelper.createOpenMessageClickListener(paramFragmentComponent, paramMiniProfile);
      }
    }
    paramLinearLayout.setVisibility(8);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.heathrow.HeathrowLandingUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */