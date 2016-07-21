package com.linkedin.android.feed.mentions;

import android.support.v4.app.Fragment;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataRequestWrapper;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

final class MentionsPresenter$TypeaheadHitModelListener
  implements RecordTemplateListener<CollectionTemplate<TypeaheadHit, CollectionMetadata>>
{
  private WeakReference<Fragment> fragmentWeakReference;
  private boolean isExplicit;
  private WeakReference<MentionsPresenter> mentionsPresenterWeakReference;
  
  private MentionsPresenter$TypeaheadHitModelListener(MentionsPresenter paramMentionsPresenter, Fragment paramFragment, boolean paramBoolean)
  {
    mentionsPresenterWeakReference = new WeakReference(paramMentionsPresenter);
    fragmentWeakReference = new WeakReference(paramFragment);
    isExplicit = paramBoolean;
  }
  
  public final void onResponse(DataStoreResponse<CollectionTemplate<TypeaheadHit, CollectionMetadata>> paramDataStoreResponse)
  {
    MentionsPresenter localMentionsPresenter = (MentionsPresenter)mentionsPresenterWeakReference.get();
    Object localObject = (Fragment)fragmentWeakReference.get();
    if ((localObject == null) || (!((Fragment)localObject).isAdded()) || (localMentionsPresenter == null)) {}
    do
    {
      return;
      if (model == null) {
        break;
      }
      List localList = model).elements;
      localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      MentionsPresenter.access$200(localMentionsPresenter, (List)localObject, isExplicit, type, request.trackingSessionId);
    } while (!MentionsPresenter.access$300(localMentionsPresenter));
    MentionsPresenter.access$400(localMentionsPresenter);
    return;
    Log.e(MentionsPresenter.access$500(), "Failed to get typeahead data: " + error.getClass().getName() + "; " + error.getMessage());
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsPresenter.TypeaheadHitModelListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */