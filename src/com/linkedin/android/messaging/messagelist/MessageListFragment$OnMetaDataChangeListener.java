package com.linkedin.android.messaging.messagelist;

import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.messengerlib.MessengerLibApi;
import java.util.List;

public abstract interface MessageListFragment$OnMetaDataChangeListener
{
  public abstract void participantChange(MessengerLibApi paramMessengerLibApi, List<MiniProfile> paramList);
  
  public abstract void participantChangeByName(String paramString);
  
  public abstract void participantChangeByProfiles(List<MiniProfile> paramList);
  
  public abstract void participantChangeCompany(MessengerLibApi paramMessengerLibApi, MiniCompany paramMiniCompany);
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListFragment.OnMetaDataChangeListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */