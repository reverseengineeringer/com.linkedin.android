package com.linkedin.android.feed.endor.ui;

import android.content.Context;
import android.view.View;
import com.linkedin.android.feed.FeedTrackableFragment;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewHolder;
import com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewHolder;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.viewmodels.models.FeedItemViewModel;
import com.linkedin.android.infra.app.BaseViewHolder;
import com.linkedin.android.infra.components.ApplicationComponent;
import java.util.Iterator;
import java.util.List;

public final class FeedPromptResponseListAdapter
  extends FeedAdapter
{
  public boolean playFirstVideo = true;
  
  public FeedPromptResponseListAdapter(Context paramContext, ApplicationComponent paramApplicationComponent, FeedTrackableFragment paramFeedTrackableFragment)
  {
    super(paramContext, paramApplicationComponent, paramFeedTrackableFragment);
  }
  
  public final void onBindViewHolder(BaseViewHolder paramBaseViewHolder, int paramInt)
  {
    super.onBindViewHolder(paramBaseViewHolder, paramInt);
    Object localObject1 = (FeedItemViewModel)getItemAtPosition(paramInt);
    if (((localObject1 instanceof FeedSingleUpdateViewModel)) && (paramInt == 0) && (playFirstVideo))
    {
      playFirstVideo = false;
      paramBaseViewHolder = (FeedSingleUpdateViewHolder)paramBaseViewHolder;
      localObject1 = components.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (FeedComponentViewModel)((Iterator)localObject1).next();
        if ((localObject2 instanceof FeedNativeVideoViewModel))
        {
          localObject2 = (FeedNativeVideoViewModel)localObject2;
          FeedNativeVideoViewHolder localFeedNativeVideoViewHolder = (FeedNativeVideoViewHolder)componentsView.getViewHolder((FeedComponentViewModel)localObject2);
          if (localFeedNativeVideoViewHolder != null) {
            ((FeedNativeVideoViewModel)localObject2).playVideo(localFeedNativeVideoViewHolder, itemView.getContext());
          }
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedPromptResponseListAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */