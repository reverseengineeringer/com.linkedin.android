package com.linkedin.messengerlib.readreceipt;

import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class ConversationReadReceipts
{
  public Map<String, List<MiniProfile>> events = new HashMap();
  
  @Deprecated
  public static String stripLeadingChar(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 1) {
      str = paramString.substring(1);
    }
    return str;
  }
  
  public final List<MiniProfile> getEventReadReceipts(String paramString)
  {
    return (List)events.get(stripLeadingChar(paramString));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.readreceipt.ConversationReadReceipts
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */