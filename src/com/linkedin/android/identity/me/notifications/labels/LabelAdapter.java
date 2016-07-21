package com.linkedin.android.identity.me.notifications.labels;

import com.linkedin.android.infra.app.BaseAdapter;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.DateUtils;
import javax.inject.Inject;

public final class LabelAdapter
  extends BaseAdapter<LabelViewHolder>
{
  private boolean display;
  private final FragmentComponent fragmentComponent;
  private LabelViewModel labelViewModel;
  private final MediaCenter mediaCenter;
  private int numNew;
  public int numTotal;
  public long timestamp;
  private LabelAdapter.Type type;
  
  @Inject
  public LabelAdapter(FragmentComponent paramFragmentComponent, LabelAdapter.Type paramType)
  {
    fragmentComponent = paramFragmentComponent;
    mediaCenter = paramFragmentComponent.mediaCenter();
    type = paramType;
    setHasStableIds(true);
    display = false;
  }
  
  private LabelViewModel toViewModel()
  {
    switch (LabelAdapter.1.$SwitchMap$com$linkedin$android$identity$me$notifications$labels$LabelAdapter$Type[type.ordinal()])
    {
    default: 
      localObject1 = fragmentComponent.i18NManager();
      localObject2 = new LabelViewModel();
      labelHeadline = ((I18NManager)localObject1).getString(2131232094);
      return (LabelViewModel)localObject2;
    }
    Object localObject1 = fragmentComponent;
    int i = numNew;
    int j = numTotal;
    long l1 = timestamp;
    Object localObject2 = ((FragmentComponent)localObject1).i18NManager();
    LabelViewModel localLabelViewModel = new LabelViewModel();
    if (j > 0)
    {
      localObject1 = ((I18NManager)localObject2).getString(2131232129, new Object[] { Integer.valueOf(j) });
      labelHeadline = ((String)localObject1);
      if (i <= 0) {
        break label193;
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      hasUnread = bool;
      long l2 = System.currentTimeMillis();
      labelTime = DateUtils.getTimestampText(l2, l1, (I18NManager)localObject2);
      labelTimeContentDescription = DateUtils.getTimeAgoContentDescription(l2, l1, (I18NManager)localObject2);
      return localLabelViewModel;
      localObject1 = ((I18NManager)localObject2).getString(2131232128);
      break;
    }
  }
  
  public final int getItemCount()
  {
    if (display) {
      return 1;
    }
    return 0;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final void notifyLabelChange()
  {
    if (display)
    {
      labelViewModel = toViewModel();
      notifyItemChanged(0);
    }
  }
  
  public final void setNumNew(int paramInt)
  {
    numNew = paramInt;
    notifyLabelChange();
  }
  
  public final void setNumTotal(int paramInt)
  {
    numTotal = paramInt;
    notifyLabelChange();
  }
  
  public final void setVisible(boolean paramBoolean)
  {
    if (display != paramBoolean)
    {
      display = paramBoolean;
      if (paramBoolean) {
        notifyItemInserted(0);
      }
    }
    else
    {
      return;
    }
    notifyItemRemoved(0);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.me.notifications.labels.LabelAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */