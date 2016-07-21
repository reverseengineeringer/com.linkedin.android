package com.linkedin.android.feed.updates.common.likes.detail;

import android.content.Context;
import com.linkedin.android.feed.endor.ui.component.likerow.FeedLikeRowViewModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.network.MediaCenter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class LikesDetailAdapter
  extends EndlessViewModelAdapter<FeedLikeRowViewModel>
{
  private Set<String> likeActorIds = new HashSet();
  
  public LikesDetailAdapter(Context paramContext, MediaCenter paramMediaCenter)
  {
    super(paramContext, paramMediaCenter, null);
  }
  
  private <V extends FeedLikeRowViewModel> List<V> filterAlreadySeenValues(List<V> paramList)
  {
    Object localObject;
    if (paramList == null) {
      localObject = null;
    }
    do
    {
      return (List<V>)localObject;
      localObject = paramList;
    } while (likeActorIds == null);
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      localObject = paramList;
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = (FeedLikeRowViewModel)localIterator.next();
      if (likeActorIds.contains(likeActorId)) {
        localIterator.remove();
      } else {
        likeActorIds.add(likeActorId);
      }
    }
  }
  
  public final void appendValues(List<? extends FeedLikeRowViewModel> paramList)
  {
    super.appendValues(filterAlreadySeenValues(paramList));
  }
  
  public final void prependValues(List<? extends FeedLikeRowViewModel> paramList)
  {
    super.prependValues(filterAlreadySeenValues(paramList));
  }
  
  public final void setValues(List<? extends FeedLikeRowViewModel> paramList)
  {
    if (likeActorIds != null) {
      likeActorIds.clear();
    }
    super.setValues(filterAlreadySeenValues(paramList));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */