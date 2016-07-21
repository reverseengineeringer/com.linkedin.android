package com.linkedin.android.entities.group;

import android.content.Context;
import android.text.TextUtils;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.infra.EndlessViewModelAdapter;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class GroupsViewModelAdapter
  extends EndlessViewModelAdapter<ViewModel>
{
  public int discussionStartPosition;
  private final Map<String, FeedUpdateViewModel> feedUpdateViewModelMap = new HashMap();
  
  public GroupsViewModelAdapter(Context paramContext, MediaCenter paramMediaCenter, List<ViewModel> paramList)
  {
    super(paramContext, paramMediaCenter, paramList);
  }
  
  private void insertValue(int paramInt, ViewModel paramViewModel)
  {
    if ((paramViewModel instanceof FeedUpdateViewModel)) {
      feedUpdateViewModelMap.put(updateUrn, (FeedUpdateViewModel)paramViewModel);
    }
    super.insertValue(paramInt, paramViewModel);
  }
  
  private void removeValue(ViewModel paramViewModel)
  {
    if ((paramViewModel instanceof FeedUpdateViewModel)) {
      feedUpdateViewModelMap.remove(updateUrn);
    }
    super.removeValue(paramViewModel);
  }
  
  public final void prependOrRelayoutDiscussionUpdateIfNecessary(FeedUpdateViewModel paramFeedUpdateViewModel, String paramString)
  {
    if (feedUpdateViewModelMap.containsKey(paramString))
    {
      changeViewModel((ViewModel)feedUpdateViewModelMap.get(paramString), paramFeedUpdateViewModel);
      return;
    }
    insertValue(discussionStartPosition, paramFeedUpdateViewModel);
  }
  
  public final void removeDiscussionUpdateIfExist(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (feedUpdateViewModelMap.containsKey(paramString))) {
      removeValue((ViewModel)feedUpdateViewModelMap.get(paramString));
    }
  }
  
  public final void setValues(List<? extends ViewModel> paramList)
  {
    super.setValues(paramList);
    if (!CollectionUtils.isEmpty(paramList))
    {
      int i = 0;
      while (i < paramList.size())
      {
        if ((paramList.get(i) instanceof FeedUpdateViewModel))
        {
          FeedUpdateViewModel localFeedUpdateViewModel = (FeedUpdateViewModel)paramList.get(i);
          feedUpdateViewModelMap.put(updateUrn, localFeedUpdateViewModel);
        }
        i += 1;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.group.GroupsViewModelAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */