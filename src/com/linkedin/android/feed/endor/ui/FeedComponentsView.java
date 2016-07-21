package com.linkedin.android.feed.endor.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.util.SimpleArrayMap;
import android.support.v7.widget.RecyclerView.RecycledViewPool;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.linkedin.android.feed.BaseFeedViewHolder;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelDiffUtils;
import com.linkedin.android.infra.viewmodel.ViewModelDiffUtils.ViewModelDiffRenderer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class FeedComponentsView
  extends LinearLayout
{
  private final List<FeedComponentViewModel> components = new ArrayList();
  private final SimpleArrayMap<FeedComponentViewModel, BaseFeedViewHolder> renderedViewHolders = new SimpleArrayMap();
  
  public FeedComponentsView(Context paramContext)
  {
    super(paramContext);
    setOrientation(1);
  }
  
  public FeedComponentsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
  }
  
  public FeedComponentsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setOrientation(1);
  }
  
  @TargetApi(21)
  public FeedComponentsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    setOrientation(1);
  }
  
  private void createAndBindView(FeedComponentViewModel paramFeedComponentViewModel, int paramInt, LayoutInflater paramLayoutInflater, FeedComponentsViewPool paramFeedComponentsViewPool, MediaCenter paramMediaCenter)
  {
    ViewHolderCreator localViewHolderCreator = paramFeedComponentViewModel.getCreator();
    int i = localViewHolderCreator.getLayoutId();
    Object localObject = null;
    paramFeedComponentsViewPool = paramFeedComponentsViewPool.getRecycledView(i);
    if ((paramFeedComponentsViewPool instanceof BaseFeedViewHolder))
    {
      paramFeedComponentsViewPool = (BaseFeedViewHolder)paramFeedComponentsViewPool;
      if (paramFeedComponentsViewPool == null) {
        break label196;
      }
      paramFeedComponentViewModel.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedComponentsViewPool);
      if (paramInt != -1) {
        break label183;
      }
      addView(itemView);
    }
    for (;;)
    {
      renderedViewHolders.put(paramFeedComponentViewModel, paramFeedComponentsViewPool);
      return;
      if (paramFeedComponentsViewPool != null)
      {
        itemView.getContext();
        Util.safeThrow$7a8b4789(new RuntimeException("Tried to render a non-Feed view holder in a FeedComponentsView!"));
      }
      paramFeedComponentsViewPool = localViewHolderCreator.createViewHolder(paramLayoutInflater.inflate(i, this, false));
      mItemViewType = localViewHolderCreator.getLayoutId();
      if ((paramFeedComponentsViewPool instanceof BaseFeedViewHolder))
      {
        paramFeedComponentsViewPool = (BaseFeedViewHolder)paramFeedComponentsViewPool;
        break;
      }
      paramFeedComponentsViewPool = new RuntimeException("Encountered a non BaseFeedViewHolder from a FeedComponentViewModel!");
      getContext();
      Util.safeThrow$7a8b4789(paramFeedComponentsViewPool);
      paramFeedComponentsViewPool = (FeedComponentsViewPool)localObject;
      break;
      label183:
      addView(itemView, paramInt);
    }
    label196:
    paramFeedComponentViewModel = new RuntimeException("Unable to create a valid view holder to render this view model into!\n" + paramFeedComponentViewModel.toString());
    getContext();
    Util.safeThrow$7a8b4789(paramFeedComponentViewModel);
  }
  
  private int recycleComponentAt(int paramInt, RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)components.get(paramInt);
    BaseFeedViewHolder localBaseFeedViewHolder = (BaseFeedViewHolder)renderedViewHolders.remove(localFeedComponentViewModel);
    if (localFeedComponentViewModel == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("No previously rendered component at this position!"));
      return -1;
    }
    if (localBaseFeedViewHolder == null)
    {
      getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("No previously rendered view at this position!"));
      return -1;
    }
    paramInt = indexOfChild(itemView);
    localFeedComponentViewModel.onRecycleViewHolder(localBaseFeedViewHolder);
    if (paramInt != -1) {
      removeViewAt(paramInt);
    }
    paramRecycledViewPool.putRecycledView(localBaseFeedViewHolder);
    return paramInt;
  }
  
  public final void clearComponents(RecyclerView.RecycledViewPool paramRecycledViewPool)
  {
    removeAllViews();
    int i = 0;
    int j = components.size();
    while (i < j)
    {
      recycleComponentAt(i, paramRecycledViewPool);
      i += 1;
    }
    components.clear();
  }
  
  public final BaseFeedViewHolder getViewHolder(FeedComponentViewModel paramFeedComponentViewModel)
  {
    return (BaseFeedViewHolder)renderedViewHolders.get(paramFeedComponentViewModel);
  }
  
  public final List<FeedComponentViewModel> renderComponentChanges(List<FeedComponentViewModel> paramList, LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedComponentsViewPool paramFeedComponentsViewPool)
  {
    return ViewModelDiffUtils.renderViewModelChanges(paramList, new ComponentsViewDiffRenderer(paramLayoutInflater, paramMediaCenter, paramFeedComponentsViewPool, (byte)0));
  }
  
  public final void renderComponents(List<FeedComponentViewModel> paramList, FeedComponentsViewPool paramFeedComponentsViewPool, MediaCenter paramMediaCenter)
  {
    clearComponents(paramFeedComponentsViewPool);
    components.addAll(paramList);
    LayoutInflater localLayoutInflater = LayoutInflater.from(getContext());
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      createAndBindView((FeedComponentViewModel)paramList.get(i), -1, localLayoutInflater, paramFeedComponentsViewPool, paramMediaCenter);
      i += 1;
    }
  }
  
  private final class ComponentsViewDiffRenderer
    implements ViewModelDiffUtils.ViewModelDiffRenderer<FeedComponentViewModel>
  {
    private final WeakReference<LayoutInflater> layoutInflater;
    private final MediaCenter mediaCenter;
    private final WeakReference<FeedComponentsViewPool> viewPool;
    
    private ComponentsViewDiffRenderer(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, FeedComponentsViewPool paramFeedComponentsViewPool)
    {
      mediaCenter = paramMediaCenter;
      layoutInflater = new WeakReference(paramLayoutInflater);
      viewPool = new WeakReference(paramFeedComponentsViewPool);
    }
    
    public final int getCurrentItemCount()
    {
      return components.size();
    }
    
    public final List<FeedComponentViewModel> getCurrentViewModels()
    {
      return components;
    }
    
    public final void remove(int paramInt)
    {
      RecyclerView.RecycledViewPool localRecycledViewPool = (RecyclerView.RecycledViewPool)viewPool.get();
      if (localRecycledViewPool != null)
      {
        FeedComponentsView.this.recycleComponentAt(paramInt, localRecycledViewPool);
        components.remove(paramInt);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedComponentsView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */