package com.linkedin.android.feed.actions;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.support.v7.app.AlertDialog.Builder;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.SortOrder;
import com.linkedin.android.pegasus.gen.voyager.feed.TrackingData;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public abstract class BaseFeedToggleOrderingDialog
  implements DialogInterface.OnClickListener
{
  protected final FragmentComponent fragmentComponent;
  protected final SortOrder sortOrder;
  protected final TrackingData trackingData;
  protected final Urn updateUrn;
  
  public BaseFeedToggleOrderingDialog(FragmentComponent paramFragmentComponent, TrackingData paramTrackingData, Urn paramUrn, SortOrder paramSortOrder)
  {
    fragmentComponent = paramFragmentComponent;
    trackingData = paramTrackingData;
    updateUrn = paramUrn;
    sortOrder = paramSortOrder;
  }
  
  protected abstract int getCheckedItem();
  
  protected abstract CharSequence[] getItems(I18NManager paramI18NManager);
  
  protected abstract SortOrder getSortOrder(int paramInt);
  
  protected abstract String getTrackingActionType(int paramInt);
  
  protected abstract String getTrackingControlName(int paramInt);
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    new ControlInteractionEvent(fragmentComponent.tracker(), getTrackingControlName(paramInt), ControlType.BUTTON, InteractionType.SHORT_PRESS).send();
    if ((trackingData != null) && (updateUrn != null)) {
      FeedTracking.trackFAE(fragmentComponent.tracker(), getTrackingControlName(paramInt), ActionCategory.EXPAND, getTrackingActionType(paramInt), trackingData, updateUrn, fragmentComponent);
    }
    paramDialogInterface.dismiss();
  }
  
  public final void show()
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(fragmentComponent.context());
    localBuilder.setSingleChoiceItems(getItems(fragmentComponent.i18NManager()), getCheckedItem(), this);
    localBuilder.show();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.BaseFeedToggleOrderingDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */