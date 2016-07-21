package com.linkedin.android.infra.mergeAdapter;

import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.ViewGroup;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.viewport.ImpressionAdapter;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.litrackinglib.viewport.Mapper;
import com.linkedin.android.litrackinglib.viewport.ViewPortAwareAdapter;
import com.linkedin.android.litrackinglib.viewport.ViewPortManager;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.inject.Inject;

public final class MergeAdapter
  extends RecyclerView.Adapter<RecyclerView.ViewHolder>
  implements ViewPortAwareAdapter<RecyclerView.ViewHolder>
{
  private final Map<RecyclerView.ViewHolder, LocalAdapter> adapterViewHolderMapping = new HashMap();
  private final List<LocalAdapter> adapters = new ArrayList();
  private int currentMergedViewType;
  private ViewPortManager viewPortManager;
  
  private LocalAdapter getAdapterContainingAbsolutePosition(int paramInt)
  {
    int i = paramInt;
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext())
    {
      LocalAdapter localLocalAdapter = (LocalAdapter)localIterator.next();
      int j = adapter.getItemCount();
      if (i < j) {
        return localLocalAdapter;
      }
      i -= j;
    }
    Util.safeThrow(new IllegalStateException("Can't find LocalAdapter containing absolute position:" + paramInt));
    return (LocalAdapter)adapters.get(0);
  }
  
  private int getRelativePosition(int paramInt, LocalAdapter paramLocalAdapter)
  {
    int i = paramInt;
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext())
    {
      LocalAdapter localLocalAdapter = (LocalAdapter)localIterator.next();
      if (localLocalAdapter == paramLocalAdapter) {
        return i;
      }
      i -= adapter.getItemCount();
    }
    Util.safeThrow(new IllegalStateException("Can't get relative position for absolutePosition:" + paramInt));
    return paramInt;
  }
  
  private Mapper onBindTrackableViews(Mapper paramMapper, RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    LocalAdapter localLocalAdapter = getAdapterContainingAbsolutePosition(paramInt);
    if (!(adapter instanceof ImpressionAdapter)) {
      return paramMapper;
    }
    paramInt = getRelativePosition(paramInt, localLocalAdapter);
    return ((ImpressionAdapter)adapter).onBindTrackableViews(paramMapper, paramViewHolder, paramInt);
  }
  
  private void resetHasStableIds()
  {
    if (hasObservers())
    {
      Util.safeThrow(new IllegalStateException("Cannot reset hasStableIds once observers are attached"));
      return;
    }
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext()) {
      if (!nextadapter.hasStableIds())
      {
        setHasStableIds(false);
        return;
      }
    }
    setHasStableIds(true);
  }
  
  public final void addAdapter(RecyclerView.Adapter paramAdapter)
  {
    int j = adapters.size();
    int i = 0;
    while (i < adapters.size())
    {
      if (adapters.get(i)).adapter == paramAdapter)
      {
        Util.safeThrow(new IllegalStateException("Cannot add the same adapter twice"));
        return;
      }
      i += 1;
    }
    LocalAdapter localLocalAdapter = new LocalAdapter(paramAdapter, this);
    adapters.add(j, localLocalAdapter);
    resetHasStableIds();
    paramAdapter.registerAdapterDataObserver(observer);
    notifyItemRangeInserted(getAbsolutePosition(0, localLocalAdapter), adapter.getItemCount());
  }
  
  public final int getAbsolutePosition(int paramInt, RecyclerView.Adapter paramAdapter)
  {
    int i = 0;
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext())
    {
      LocalAdapter localLocalAdapter = (LocalAdapter)localIterator.next();
      if (paramAdapter == adapter) {
        return i + paramInt;
      }
      i += adapter.getItemCount();
    }
    return -1;
  }
  
  final int getAbsolutePosition(int paramInt, LocalAdapter paramLocalAdapter)
  {
    int i = 0;
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext())
    {
      LocalAdapter localLocalAdapter = (LocalAdapter)localIterator.next();
      if (paramLocalAdapter == localLocalAdapter) {
        return i + paramInt;
      }
      i += adapter.getItemCount();
    }
    Util.safeThrow(new IllegalStateException("Can't get absolute position for relative position:" + paramInt));
    return 0;
  }
  
  public final int getItemCount()
  {
    int i = 0;
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext()) {
      i += nextadapter.getItemCount();
    }
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    LocalAdapter localLocalAdapter = getAdapterContainingAbsolutePosition(paramInt);
    paramInt = adapter.getItemViewType(getRelativePosition(paramInt, localLocalAdapter));
    if (localViewTypes.containsValue(Integer.valueOf(paramInt)))
    {
      Iterator localIterator = localViewTypes.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Integer)localEntry.getValue()).intValue() == paramInt) {
          return ((Integer)localEntry.getKey()).intValue();
        }
      }
    }
    currentMergedViewType += 1;
    localViewTypes.put(Integer.valueOf(currentMergedViewType), Integer.valueOf(paramInt));
    return currentMergedViewType;
  }
  
  public final void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    Object localObject = getAdapterContainingAbsolutePosition(paramInt);
    adapter.onBindViewHolder(paramViewHolder, getRelativePosition(paramInt, (LocalAdapter)localObject));
    adapterViewHolderMapping.put(paramViewHolder, localObject);
    if (viewPortManager != null)
    {
      localObject = onBindTrackableViews(viewPortManager.getMapper(), paramViewHolder, paramInt);
      viewPortManager.index(paramInt, itemView, (Mapper)localObject);
    }
  }
  
  public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    Iterator localIterator = adapters.iterator();
    while (localIterator.hasNext())
    {
      LocalAdapter localLocalAdapter = (LocalAdapter)localIterator.next();
      if (localViewTypes.containsKey(Integer.valueOf(paramInt))) {
        return adapter.onCreateViewHolder(paramViewGroup, ((Integer)localViewTypes.get(Integer.valueOf(paramInt))).intValue());
      }
    }
    Util.safeThrow(new RuntimeException(String.format(Locale.US, "No localViewType found for viewType %d", new Object[] { Integer.valueOf(paramInt) })));
    return new MergeAdapter.1(this, new View(paramViewGroup.getContext()));
  }
  
  public final void onEnterViewPort(int paramInt, View paramView)
  {
    LocalAdapter localLocalAdapter = getAdapterContainingAbsolutePosition(paramInt);
    if (!(adapter instanceof ViewPortAwareAdapter)) {
      return;
    }
    paramInt = getRelativePosition(paramInt, localLocalAdapter);
    ((ViewPortAwareAdapter)adapter).onEnterViewPort(paramInt, paramView);
  }
  
  public final void onLeaveViewPort(int paramInt1, int paramInt2)
  {
    LocalAdapter localLocalAdapter = getAdapterContainingAbsolutePosition(paramInt1);
    if (!(adapter instanceof ViewPortAwareAdapter)) {
      return;
    }
    paramInt1 = getRelativePosition(paramInt1, localLocalAdapter);
    ((ViewPortAwareAdapter)adapter).onLeaveViewPort(paramInt1, paramInt2);
  }
  
  public final void onLeaveViewPortViaScroll(int paramInt, View paramView)
  {
    LocalAdapter localLocalAdapter = getAdapterContainingAbsolutePosition(paramInt);
    if (!(adapter instanceof ViewPortAwareAdapter)) {
      return;
    }
    paramInt = getRelativePosition(paramInt, localLocalAdapter);
    ((ViewPortAwareAdapter)adapter).onLeaveViewPortViaScroll(paramInt, paramView);
  }
  
  public final TrackingEventBuilder onTrackImpression(ImpressionData paramImpressionData)
  {
    Object localObject = getAdapterContainingAbsolutePosition(position);
    if (!(adapter instanceof ImpressionAdapter)) {
      return null;
    }
    int i = getRelativePosition(position, (LocalAdapter)localObject);
    localObject = (ImpressionAdapter)adapter;
    paramImpressionData = new ImpressionData(paramImpressionData);
    position = i;
    return ((ImpressionAdapter)localObject).onTrackImpression(paramImpressionData);
  }
  
  public final void onViewRecycled(RecyclerView.ViewHolder paramViewHolder)
  {
    super.onViewRecycled(paramViewHolder);
    LocalAdapter localLocalAdapter = (LocalAdapter)adapterViewHolderMapping.remove(paramViewHolder);
    if (localLocalAdapter != null)
    {
      adapter.onViewRecycled(paramViewHolder);
      return;
    }
    Util.safeThrow(new RuntimeException(String.format("No adapter found for view holder! [%s]", new Object[] { paramViewHolder })));
  }
  
  public final MergeAdapter setViewPortManager(ViewPortManager paramViewPortManager)
  {
    viewPortManager = paramViewPortManager;
    viewPortManager.adapter = this;
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.mergeAdapter.MergeAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */