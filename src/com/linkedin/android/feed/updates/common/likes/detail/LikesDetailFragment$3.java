package com.linkedin.android.feed.updates.common.likes.detail;

import android.support.v4.app.FragmentActivity;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

final class LikesDetailFragment$3
  implements RecordTemplateListener<Update>
{
  LikesDetailFragment$3(LikesDetailFragment paramLikesDetailFragment) {}
  
  public final void onResponse(DataStoreResponse<Update> paramDataStoreResponse)
  {
    if (!this$0.isAdded()) {}
    do
    {
      return;
      if ((model != null) && (model).socialDetail != null) && (error == null) && (!LikesDetailFragment.access$100(this$0)))
      {
        LikesDetailFragment.access$602(this$0, model).tracking);
        LikesDetailFragment.access$500(this$0, model).socialDetail);
        return;
      }
    } while ((error == null) || (type != DataStore.Type.NETWORK));
    this$0.getActivity();
    Util.safeThrow$7a8b4789(new RuntimeException("We couldn't get the update or social detail! we should probably throw a toast now for the user", error));
    this$0.getActivity().onBackPressed();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.likes.detail.LikesDetailFragment.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */