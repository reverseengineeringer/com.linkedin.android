package com.linkedin.messengerlib.ui.messagelist;

import android.database.Cursor;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.messengerlib.consumers.ActorDataManager;
import com.linkedin.messengerlib.consumers.ActorDataManager.ActorsForConversationCursor;
import com.linkedin.messengerlib.consumers.DataManager;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.ui.compose.MessageCreateFragment;
import com.linkedin.messengerlib.utils.NameFormatter;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public abstract class MessageListBaseFragment
  extends MessageCreateFragment
{
  protected MessageListBaseFragment.OnMetaDataChangeListener onMetaDataChangeListener;
  
  protected final void onConversationNameAndParticipantChange(String paramString, List<MiniProfile> paramList)
  {
    if (onMetaDataChangeListener == null) {}
    do
    {
      return;
      if (paramList != null) {
        onMetaDataChangeListener.onParticipantChange(paramList);
      }
      if (StringUtils.isNotEmpty(paramString))
      {
        onMetaDataChangeListener.onConversationNameChange(paramString);
        return;
      }
    } while ((paramList == null) || (paramList.isEmpty()));
    onMetaDataChangeListener.onConversationNameChangeByParticipants(paramList);
  }
  
  protected final void refreshConversationAndParticipantsFromCursor(long paramLong)
  {
    String str1 = NameFormatter.buildNameFromConversationId(fragmentComponent, paramLong);
    Cursor localCursor = fragmentComponent.dataManager.actorDataManager.getActorsForConversation(paramLong);
    if (localCursor != null)
    {
      try
      {
        ArrayList localArrayList = new ArrayList();
        while (localCursor.moveToNext()) {
          localArrayList.add(ActorDataManager.ActorsForConversationCursor.miniProfileForActor(localCursor));
        }
        onConversationNameAndParticipantChange(str2, localArrayList);
      }
      finally
      {
        localCursor.close();
      }
      localCursor.close();
    }
  }
  
  public void setOnMetaDataChangeListener(MessageListBaseFragment.OnMetaDataChangeListener paramOnMetaDataChangeListener)
  {
    onMetaDataChangeListener = paramOnMetaDataChangeListener;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.messagelist.MessageListBaseFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */