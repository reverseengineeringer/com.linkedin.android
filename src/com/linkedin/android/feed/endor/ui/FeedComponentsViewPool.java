package com.linkedin.android.feed.endor.ui;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.Util;
import java.util.Locale;

public final class FeedComponentsViewPool
  extends RecyclerView.RecycledViewPool
{
  private static RecyclerView.ViewHolder ensureNoParent(RecyclerView.ViewHolder paramViewHolder)
  {
    Object localObject1 = null;
    Object localObject2;
    if (paramViewHolder != null)
    {
      localObject2 = itemView.getParent();
      if (localObject2 == null) {
        localObject1 = paramViewHolder;
      }
    }
    else
    {
      return (RecyclerView.ViewHolder)localObject1;
    }
    localObject1 = getResourceName(itemView.getResources(), itemView.getId());
    Resources localResources = itemView.getResources();
    if ((localObject2 instanceof View)) {}
    for (int i = ((View)localObject2).getId();; i = -1)
    {
      localObject2 = getResourceName(localResources, i);
      localObject1 = new RuntimeException(String.format(Locale.US, "ViewHolder is attached to a parent, dropping it!\nview holder class: %s\nview holder itemView layout: %s\nview holder itemView ViewParent layout: %s", new Object[] { paramViewHolder.getClass().getName(), localObject1, localObject2 }));
      itemView.getContext();
      Util.safeThrow$7a8b4789((RuntimeException)localObject1);
      CrashReporter.reportNonFatal((Throwable)localObject1);
      return null;
    }
  }
  
  private static String getResourceName(Resources paramResources, int paramInt)
  {
    try
    {
      paramResources = paramResources.getResourceName(paramInt);
      return paramResources;
    }
    catch (Resources.NotFoundException paramResources) {}
    return String.valueOf(paramInt);
  }
  
  public final RecyclerView.ViewHolder getRecycledView(int paramInt)
  {
    for (RecyclerView.ViewHolder localViewHolder = super.getRecycledView(paramInt); localViewHolder != null; localViewHolder = super.getRecycledView(paramInt))
    {
      localViewHolder = ensureNoParent(localViewHolder);
      if (localViewHolder != null) {
        return localViewHolder;
      }
    }
    return null;
  }
  
  public final void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
  {
    if (ensureNoParent(paramViewHolder) != null) {
      super.putRecycledView(paramViewHolder);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedComponentsViewPool
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */