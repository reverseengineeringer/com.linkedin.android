package com.linkedin.android.infra.events;

import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.growth.interests.Channel;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;

public final class ClickableSpanClickEvent
{
  public Channel channel;
  public MiniCompany miniCompany;
  public MiniGroup miniGroup;
  public MiniProfile miniProfile;
  public MiniSchool miniSchool;
  public Update update;
  public String url;
  public int webViewerUsage;
  
  public ClickableSpanClickEvent(MiniCompany paramMiniCompany)
  {
    miniCompany = paramMiniCompany;
  }
  
  public ClickableSpanClickEvent(MiniGroup paramMiniGroup)
  {
    miniGroup = paramMiniGroup;
  }
  
  public ClickableSpanClickEvent(MiniSchool paramMiniSchool)
  {
    miniSchool = paramMiniSchool;
  }
  
  public ClickableSpanClickEvent(Channel paramChannel)
  {
    channel = paramChannel;
  }
  
  public ClickableSpanClickEvent(MiniProfile paramMiniProfile)
  {
    miniProfile = paramMiniProfile;
  }
  
  public ClickableSpanClickEvent(String paramString, Update paramUpdate, int paramInt)
  {
    url = paramString;
    update = paramUpdate;
    webViewerUsage = paramInt;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.events.ClickableSpanClickEvent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */