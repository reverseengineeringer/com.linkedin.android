package com.linkedin.android.feed.mentions;

import java.lang.ref.WeakReference;

final class MentionsPresenter$TypeaheadRunnable
  implements Runnable
{
  private boolean isExplicitMentionQuery;
  private boolean isGroupsDetailPage;
  private boolean isRecentMentionsQuery;
  private WeakReference<MentionsPresenter> mentionsPresenterWeakReference;
  private String query;
  
  private MentionsPresenter$TypeaheadRunnable(MentionsPresenter paramMentionsPresenter, String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    mentionsPresenterWeakReference = new WeakReference(paramMentionsPresenter);
    query = paramString;
    isRecentMentionsQuery = paramBoolean1;
    isExplicitMentionQuery = paramBoolean2;
    isGroupsDetailPage = paramBoolean3;
  }
  
  public final void run()
  {
    MentionsPresenter localMentionsPresenter = (MentionsPresenter)mentionsPresenterWeakReference.get();
    if (localMentionsPresenter != null)
    {
      if (isGroupsDetailPage) {
        MentionsPresenter.access$600(localMentionsPresenter, query);
      }
    }
    else {
      return;
    }
    if (isExplicitMentionQuery)
    {
      MentionsPresenter.access$700(localMentionsPresenter, query, isRecentMentionsQuery);
      return;
    }
    MentionsPresenter.access$800(localMentionsPresenter, query);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsPresenter.TypeaheadRunnable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */