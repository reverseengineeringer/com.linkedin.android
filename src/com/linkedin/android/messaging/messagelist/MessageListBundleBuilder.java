package com.linkedin.android.messaging.messagelist;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;

public final class MessageListBundleBuilder
  extends com.linkedin.messengerlib.ui.messagelist.MessageListBundleBuilder
  implements BundleBuilder
{
  public MessageListBundleBuilder() {}
  
  public MessageListBundleBuilder(Bundle paramBundle)
  {
    super(paramBundle);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */