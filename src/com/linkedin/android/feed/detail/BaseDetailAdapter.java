package com.linkedin.android.feed.detail;

import android.content.Context;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModel;
import com.linkedin.android.feed.endor.ui.component.comment.FeedCommentViewModelUtils;
import com.linkedin.android.feed.endor.ui.component.commentloading.FeedCommentLoadingViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class BaseDetailAdapter
  extends ViewModelArrayAdapter<FeedComponentViewModel>
{
  public BaseDetailAdapter(Context paramContext, MediaCenter paramMediaCenter, FeedComponentsViewPool paramFeedComponentsViewPool)
  {
    super(paramContext, paramMediaCenter, null);
    insertValue(0, new FeedComponentListViewModel(paramFeedComponentsViewPool, new ArrayList()));
  }
  
  private int getIndexOfCommentWithId(String paramString, List<FeedComponentViewModel> paramList)
  {
    int i = 0;
    int j = paramList.size();
    while (i < j)
    {
      FeedComponentViewModel localFeedComponentViewModel = (FeedComponentViewModel)paramList.get(i);
      if ((localFeedComponentViewModel instanceof FeedCommentViewModel))
      {
        if (!paramString.equals(commentUrn)) {}
      }
      else {
        while (((localFeedComponentViewModel instanceof FeedComponentListViewModel)) && (getIndexOfCommentWithId(paramString, components) != -1)) {
          return i;
        }
      }
      i += 1;
    }
    return -1;
  }
  
  private FeedCommentLoadingViewModel getLoadNextViewModel()
  {
    int i = values.size();
    if ((i > 0) && ((values.get(i - 1) instanceof FeedCommentLoadingViewModel)) && (values.get(i - 1)).loadType == 1)) {
      return (FeedCommentLoadingViewModel)values.get(i - 1);
    }
    return null;
  }
  
  private FeedCommentLoadingViewModel getLoadPreviousViewModel()
  {
    if ((values.size() > 1) && ((values.get(1) instanceof FeedCommentLoadingViewModel)) && (values.get(1)).loadType == 0)) {
      return (FeedCommentLoadingViewModel)values.get(1);
    }
    return null;
  }
  
  private void showLoadingViews(FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    if ((hasPreviousComments()) && (getLoadPreviousViewModel() == null))
    {
      FeedCommentLoadingViewModel localFeedCommentLoadingViewModel = toLoadPreviousViewModel(paramFragmentComponent, paramUpdate, false);
      if (localFeedCommentLoadingViewModel != null) {
        insertValue(1, localFeedCommentLoadingViewModel);
      }
    }
    if ((hasNextComments()) && (getLoadNextViewModel() == null))
    {
      paramFragmentComponent = toLoadNextViewModel$638ce296(paramFragmentComponent, paramUpdate);
      if (paramFragmentComponent != null) {
        appendValue(paramFragmentComponent);
      }
    }
  }
  
  public final void addNewComments(List<FeedComponentViewModel> paramList, int paramInt, FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    hideLoadingViews();
    Object localObject2;
    Object localObject1;
    label59:
    int i;
    if ((paramInt == 2) || (paramInt == 3))
    {
      localObject2 = paramList.iterator();
      label94:
      label98:
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = FeedCommentViewModelUtils.getCommentViewModel((FeedComponentViewModel)((Iterator)localObject2).next());
        if (localObject1 != null)
        {
          localObject1 = commentUrn;
          if (localObject1 == null) {
            break label94;
          }
        }
        for (i = getIndexOfCommentWithId((String)localObject1);; i = -1)
        {
          if (i == -1) {
            break label98;
          }
          ((Iterator)localObject2).remove();
          break;
          localObject1 = null;
          break label59;
        }
      }
    }
    if ((paramInt == 0) || (paramInt == 1)) {
      if (values.size() <= 0) {
        Util.safeThrow$7a8b4789(new RuntimeException("There should always be a view model for the update in pos 0."));
      }
    }
    for (;;)
    {
      showLoadingViews(paramFragmentComponent, paramUpdate);
      return;
      localObject2 = new ArrayList(paramList.size() + 1);
      if (values.size() > 0) {}
      for (localObject1 = (FeedComponentViewModel)values.get(0);; localObject1 = null)
      {
        if (localObject1 != null) {
          ((List)localObject2).add(localObject1);
        }
        ((List)localObject2).addAll(paramList);
        renderViewModelChanges((List)localObject2);
        break;
      }
      if (paramInt == 2)
      {
        if (getLoadPreviousViewModel() != null) {}
        for (paramInt = 2;; paramInt = 1)
        {
          insertValues(paramList, paramInt);
          break;
        }
      }
      if (paramInt == 3)
      {
        i = getItemCount();
        paramInt = i;
        if (getLoadNextViewModel() != null) {
          paramInt = i - 1;
        }
        insertValues(paramList, paramInt);
      }
    }
  }
  
  public final void addNewUserComment(FeedComponentViewModel paramFeedComponentViewModel, SocialDetail paramSocialDetail)
  {
    int j = 1;
    int i = 1;
    if (paramSocialDetail == null)
    {
      Util.safeThrow$7a8b4789(new RuntimeException("Cannot add comment to an update without a social detail."));
      return;
    }
    switch (com.linkedin.android.feed.utils.FeedUpdateUtils.getCommentsSortOrder(paramSocialDetail))
    {
    default: 
      j = values.size();
      if (getLoadNextViewModel() == null) {
        break;
      }
    }
    for (;;)
    {
      insertValue(j - i, paramFeedComponentViewModel);
      return;
      i = j;
      if (getLoadPreviousViewModel() != null) {
        i = 2;
      }
      insertValue(i, paramFeedComponentViewModel);
      return;
      i = 0;
    }
  }
  
  public final void animateLoadingViews(FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    if (getLoadPreviousViewModel() != null) {
      changeViewModel(1, toLoadPreviousViewModel(paramFragmentComponent, paramUpdate, true));
    }
  }
  
  public final int changeCommentWithId(String paramString, FeedComponentViewModel paramFeedComponentViewModel)
  {
    int i = getIndexOfCommentWithId(paramString);
    if (i >= 0) {
      return changeViewModel(i, paramFeedComponentViewModel);
    }
    return 0;
  }
  
  public final boolean deleteCommentWithId(String paramString)
  {
    int i = getIndexOfCommentWithId(paramString);
    if (i >= 0)
    {
      removeValueAtPosition(i);
      return true;
    }
    return false;
  }
  
  public final int getIndexOfCommentWithId(String paramString)
  {
    return getIndexOfCommentWithId(paramString, values);
  }
  
  public boolean hasNextComments()
  {
    return false;
  }
  
  public boolean hasPreviousComments()
  {
    return false;
  }
  
  public final boolean hasRenderedComponents()
  {
    if (super.isEmpty()) {}
    FeedComponentViewModel localFeedComponentViewModel;
    do
    {
      return false;
      localFeedComponentViewModel = (FeedComponentViewModel)values.get(0);
      if (!(localFeedComponentViewModel instanceof FeedComponentListViewModel)) {
        return true;
      }
    } while (CollectionUtils.isEmpty(components));
    return true;
  }
  
  public final void hideLoadingViews()
  {
    if (getLoadPreviousViewModel() != null) {
      removeValueAtPosition(1);
    }
    if (getLoadNextViewModel() != null) {
      removeValueAtPosition(values.size() - 1);
    }
  }
  
  public final void resetLoadingViews(FragmentComponent paramFragmentComponent, Update paramUpdate)
  {
    hideLoadingViews();
    showLoadingViews(paramFragmentComponent, paramUpdate);
  }
  
  public abstract FeedCommentLoadingViewModel toLoadNextViewModel$638ce296(FragmentComponent paramFragmentComponent, Update paramUpdate);
  
  public abstract FeedCommentLoadingViewModel toLoadPreviousViewModel(FragmentComponent paramFragmentComponent, Update paramUpdate, boolean paramBoolean);
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.BaseDetailAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */