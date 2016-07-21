package com.linkedin.android.feed.actions;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.feed.viewmodels.models.BaseActionModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ControlPanelDialog<T extends BaseActionModel>
  extends PanelDialog
{
  protected OnActionItemClickListener<T> itemClickListener;
  public Update update;
  
  public ControlPanelDialog(FragmentComponent paramFragmentComponent)
  {
    super(paramFragmentComponent);
  }
  
  public final ControlPanelDialog setOnActionItemClickListener(OnActionItemClickListener<T> paramOnActionItemClickListener)
  {
    itemClickListener = paramOnActionItemClickListener;
    return this;
  }
  
  public final ControlPanelDialog setUpdateActions(List<T> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    final Object localObject1;
    Object localObject2;
    if ((FeedLixHelper.isEnabled(fragmentComponent.lixManager(), Lix.FEED_CONTROL_MENU_DEBUG_INFO)) && (update != null))
    {
      final Object localObject3 = fragmentComponent.context().getResources();
      localObject1 = (ClipboardManager)fragmentComponent.activity().getSystemService("clipboard");
      localObject2 = ((Resources)localObject3).getString(2131233819);
      localObject3 = ((Resources)localObject3).getString(2131233821);
      final SnackbarUtil localSnackbarUtil = fragmentComponent.snackbarUtil();
      localArrayList.add(new PanelDialog.PanelDialogItem((CharSequence)localObject2, update.urn.toString(), 2130838350, new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = ClipData.newPlainText(localObject3, update.urn.toString());
          localObject1.setPrimaryClip(paramAnonymousView);
          localSnackbarUtil.make(2131233820, 0).show();
        }
      }));
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localObject1 = (BaseActionModel)paramList.next();
      if (localObject1 != null)
      {
        localObject2 = new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (itemClickListener != null) {
              itemClickListener.onActionPerformed$23f734e3(update, localObject1);
            }
            dismiss();
          }
        };
        localArrayList.add(new PanelDialog.PanelDialogItem(title, subtitle, iconResId, (View.OnClickListener)localObject2));
      }
    }
    setPanelItems(localArrayList);
    return this;
  }
  
  public static abstract interface OnActionItemClickListener<T extends BaseActionModel>
  {
    public abstract void onActionPerformed$23f734e3(Update paramUpdate, T paramT);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.ControlPanelDialog
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */