package com.linkedin.android.messaging.messagelist;

import android.support.v7.widget.Toolbar;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.ui.messagelist.LinearFacepileView;
import java.util.List;

final class MessageListActivity$1
  implements MessageListFragment.OnMetaDataChangeListener
{
  MessageListActivity$1(MessageListActivity paramMessageListActivity) {}
  
  public final void participantChange(MessengerLibApi paramMessengerLibApi, List<MiniProfile> paramList)
  {
    if (!MessageListActivity.access$000(this$0).isAdded()) {
      return;
    }
    LinearFacepileView localLinearFacepileView = this$0.facepileImage;
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramMessengerLibApi = this$0;
      if (paramList.size() <= 1) {
        break label290;
      }
    }
    label290:
    for (boolean bool = true;; bool = false)
    {
      MessageListActivity.access$102(paramMessengerLibApi, bool);
      return;
      face1.setOval(true);
      face2.setOval(true);
      face3.setOval(true);
      face1.setVisibility(8);
      face2.setVisibility(8);
      face3.setVisibility(8);
      if (paramList.size() == 1)
      {
        localLinearFacepileView.loadImage(paramMessengerLibApi, face3, get0picture);
        break;
      }
      if (paramList.size() == 2)
      {
        localLinearFacepileView.loadImage(paramMessengerLibApi, face2, get1picture);
        localLinearFacepileView.loadImage(paramMessengerLibApi, face3, get0picture);
        break;
      }
      localLinearFacepileView.loadImage(paramMessengerLibApi, face1, get2picture);
      localLinearFacepileView.loadImage(paramMessengerLibApi, face2, get1picture);
      localLinearFacepileView.loadImage(paramMessengerLibApi, face3, get0picture);
      break;
    }
  }
  
  public final void participantChangeByName(String paramString)
  {
    if (this$0.toolbar != null) {
      this$0.toolbar.setTitle(paramString);
    }
  }
  
  public final void participantChangeByProfiles(List<MiniProfile> paramList)
  {
    if (this$0.toolbar != null) {
      this$0.toolbar.setTitle(MessageListActivity.access$200(this$0, paramList));
    }
  }
  
  public final void participantChangeCompany(MessengerLibApi paramMessengerLibApi, MiniCompany paramMiniCompany)
  {
    if (!MessageListActivity.access$000(this$0).isAdded()) {}
    do
    {
      return;
      LinearFacepileView localLinearFacepileView = this$0.facepileImage;
      if (paramMiniCompany != null)
      {
        face1.setOval(false);
        face2.setOval(false);
        face3.setOval(false);
        face1.setVisibility(8);
        face2.setVisibility(8);
        face3.setVisibility(8);
        localLinearFacepileView.loadImage(paramMessengerLibApi, face3, logo);
      }
      MessageListActivity.access$102(this$0, false);
    } while (this$0.toolbar == null);
    this$0.toolbar.setTitle(name);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.messagelist.MessageListActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */