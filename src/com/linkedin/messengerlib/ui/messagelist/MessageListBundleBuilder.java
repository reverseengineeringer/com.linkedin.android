package com.linkedin.messengerlib.ui.messagelist;

import android.os.Bundle;
import com.linkedin.messengerlib.shared.BaseBundleBuilder;

public class MessageListBundleBuilder
  extends BaseBundleBuilder
{
  public MessageListBundleBuilder() {}
  
  public MessageListBundleBuilder(Bundle paramBundle)
  {
    if (paramBundle.containsKey("CONVERSATION_ID")) {
      bundle.putLong("CONVERSATION_ID", paramBundle.getLong("CONVERSATION_ID"));
    }
    if (paramBundle.containsKey("CONVERSATION_REMOTE_ID")) {
      bundle.putString("CONVERSATION_REMOTE_ID", paramBundle.getString("CONVERSATION_REMOTE_ID"));
    }
    if (paramBundle.containsKey("SHARE_UPDATE_URN")) {
      bundle.putString("SHARE_UPDATE_URN", paramBundle.getString("SHARE_UPDATE_URN"));
    }
    if (paramBundle.containsKey("IS_SPINMAIL")) {
      bundle.putBoolean("IS_SPINMAIL", paramBundle.getBoolean("IS_SPINMAIL"));
    }
    if (paramBundle.containsKey("IS_EMBEDDED_IN_COMPOSE")) {
      bundle.putBoolean("IS_EMBEDDED_IN_COMPOSE", paramBundle.getBoolean("IS_EMBEDDED_IN_COMPOSE"));
    }
  }
  
  public static long getConversationId(Bundle paramBundle, long paramLong)
  {
    if (paramBundle == null) {
      return paramLong;
    }
    return paramBundle.getLong("CONVERSATION_ID", paramLong);
  }
  
  public static String getConversationRemoteId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("CONVERSATION_REMOTE_ID");
  }
  
  public final void setConversationId(long paramLong)
  {
    bundle.putLong("CONVERSATION_ID", paramLong);
  }
  
  public final void setConversationRemoteId(String paramString)
  {
    bundle.putString("CONVERSATION_REMOTE_ID", paramString);
  }
  
  public final void setIsEmbeddedInCompose$1385ff()
  {
    bundle.putBoolean("IS_EMBEDDED_IN_COMPOSE", true);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.messagelist.MessageListBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */