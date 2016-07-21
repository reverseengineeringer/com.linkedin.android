package com.linkedin.android.feed.shared;

import android.support.v4.app.Fragment;
import android.view.View;
import com.linkedin.android.feed.detail.FeedUpdateDetailBundleBuilder;
import com.linkedin.android.feed.detail.FeedUpdateDetailIntent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public class FeedUpdateOnClickListener
  extends TrackingOnClickListener
{
  protected final int anchor;
  public final FragmentComponent fragmentComponent;
  private final String[] highlightedCommentUrns;
  private final String[] highlightedReplyUrns;
  private final boolean openNewDetailPage;
  public Update update;
  protected final String updateUrn;
  
  public FeedUpdateOnClickListener(Update paramUpdate, FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString, TrackingEventBuilder... paramVarArgs)
  {
    this(urn.toString(), paramFragmentComponent, paramInt, paramBoolean, paramArrayOfString1, paramArrayOfString2, paramString, paramVarArgs);
    update = paramUpdate;
  }
  
  public FeedUpdateOnClickListener(String paramString1, FragmentComponent paramFragmentComponent, int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString2, paramVarArgs);
    updateUrn = paramString1;
    fragmentComponent = paramFragmentComponent;
    anchor = paramInt;
    openNewDetailPage = paramBoolean;
    highlightedCommentUrns = paramArrayOfString1;
    highlightedReplyUrns = paramArrayOfString2;
  }
  
  protected FeedUpdateDetailBundleBuilder getUpdateDetailBundleBuilder()
  {
    if (update != null) {
      FeedBundleBuilder.saveUpdateToCache(fragmentComponent.dataManager(), update);
    }
    String str = updateUrn;
    if (update != null) {}
    for (Urn localUrn = update.entityUrn;; localUrn = null) {
      return FeedUpdateDetailBundleBuilder.create(str, localUrn, update);
    }
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    fragmentComponent.eventBus();
    Bus.publish(new ClickEvent(19, updateUrn));
    paramView = getUpdateDetailBundleBuilder();
    paramView.anchor(anchor);
    if ((highlightedCommentUrns != null) && (highlightedCommentUrns.length > 0)) {
      paramView.highlightedCommentUrns(highlightedCommentUrns);
    }
    if ((highlightedReplyUrns != null) && (highlightedReplyUrns.length > 0)) {
      paramView.highlightedReplyUrns(highlightedReplyUrns);
    }
    if (openNewDetailPage)
    {
      fragmentComponent.fragment().startActivityForResult(fragmentComponent.intentRegistry().feedUpdateDetail.newIntent(fragmentComponent.fragment().getActivity(), paramView), 14);
      return;
    }
    fragmentComponent.activity().setResult(-1);
    fragmentComponent.activity().finish();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.FeedUpdateOnClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */