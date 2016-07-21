package com.linkedin.android.feed.updates.common.comment;

import android.content.Context;
import android.widget.Toast;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.feed.events.FeedCommentUpdateEvent;
import com.linkedin.android.feed.events.FeedReplyUpdateEvent;
import com.linkedin.android.feed.page.feed.FeedBundleBuilder;
import com.linkedin.android.feed.utils.CommentModelUtils;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.OptimisticWrite;
import com.linkedin.android.infra.data.OptimisticWrite.PreWriteModelTransformer;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialDetail.Builder;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.VoidRecord;
import java.net.URISyntaxException;

public final class CommentPublisher
{
  private final Bus bus;
  public final FlagshipDataManager dataManager;
  public final LixManager lixManager;
  
  public CommentPublisher(FlagshipDataManager paramFlagshipDataManager, Bus paramBus, LixManager paramLixManager)
  {
    dataManager = paramFlagshipDataManager;
    bus = paramBus;
    lixManager = paramLixManager;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.updates.common.comment.CommentPublisher
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */