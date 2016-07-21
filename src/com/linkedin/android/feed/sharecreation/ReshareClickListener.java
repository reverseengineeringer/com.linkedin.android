package com.linkedin.android.feed.sharecreation;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import com.linkedin.android.feed.endor.datamodel.content.ImageContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.publishing.sharing.ShareBundle;
import com.linkedin.android.publishing.sharing.ShareIntent;
import com.linkedin.android.publishing.sharing.compose.ShareComposeBundle;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingDialogOnDismissListener;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.lang.ref.WeakReference;

public final class ReshareClickListener
  extends TrackingOnClickListener
{
  private final boolean enabledActionSheet;
  private final WeakReference<FragmentComponent> fragmentComponentReference;
  private final Update update;
  
  public ReshareClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent, boolean paramBoolean, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString, paramVarArgs);
    update = paramUpdate;
    fragmentComponentReference = new WeakReference(paramFragmentComponent);
    enabledActionSheet = paramBoolean;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = (FragmentComponent)fragmentComponentReference.get();
    Object localObject1;
    boolean bool;
    int i;
    label74:
    Object localObject2;
    if (paramView != null)
    {
      if (!enabledActionSheet) {
        break label202;
      }
      localObject1 = new ShareActionSheetDialog(paramView, update);
      if (!(updateDataModel instanceof SingleUpdateDataModel)) {
        break label191;
      }
      bool = updateDataModel).content instanceof ImageContentDataModel;
      if (!bool) {
        break label196;
      }
      i = 2131296261;
      localObject2 = fragmentComponent.context().getResources().getStringArray(i);
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(fragmentComponent.context());
      localBuilder.setItems((CharSequence[])localObject2, (DialogInterface.OnClickListener)localObject1);
      localBuilder.setOnDismissListener(new TrackingDialogOnDismissListener(fragmentComponent.tracker(), "reshare_actionsheet_cancel", new TrackingEventBuilder[0]));
      localBuilder.show();
    }
    for (;;)
    {
      if (paramView != null)
      {
        paramView.eventBus();
        Bus.publish(new ClickEvent(19, update.urn.toString()));
      }
      return;
      label191:
      bool = false;
      break;
      label196:
      i = 2131296260;
      break label74;
      label202:
      localObject1 = paramView.activity();
      localObject2 = ShareBundle.createFeedShare(ShareComposeBundle.createReshare(update.urn.toString(), update.entityUrn, update.tracking, false));
      localObject2 = intentRegistryshare.newIntent((Context)localObject1, (BundleBuilder)localObject2);
      FeedBundleBuilder.saveUpdateToCache(paramView.dataManager(), update);
      ((Context)localObject1).startActivity((Intent)localObject2);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.sharecreation.ReshareClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */