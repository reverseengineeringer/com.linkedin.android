package com.linkedin.messengerlib.ui.participantdetails;

import android.os.Bundle;
import com.linkedin.messengerlib.shared.ToolbarBaseBundleBuilder;

public class ParticipantDetailsBundleBuilder
  extends ToolbarBaseBundleBuilder
{
  static boolean containsKey(Bundle paramBundle, String paramString)
  {
    return (paramBundle != null) && (paramBundle.containsKey(paramString));
  }
  
  public static long getConversationId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return -1L;
    }
    return paramBundle.getLong("CONVERSATION_ID");
  }
  
  public static String getConversationRemoteId(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getString("CONVERSATION_REMOTE_ID");
  }
  
  public static boolean isGroupConversation(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("IS_GROUP_CONVERSATION", true));
  }
  
  public static void setConversation(Bundle paramBundle, long paramLong, String paramString)
  {
    paramBundle.putLong("CONVERSATION_ID", paramLong);
    paramBundle.putString("CONVERSATION_REMOTE_ID", paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.participantdetails.ParticipantDetailsBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */