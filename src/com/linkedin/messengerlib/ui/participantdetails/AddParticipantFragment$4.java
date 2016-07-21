package com.linkedin.messengerlib.ui.participantdetails;

import android.util.Log;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.create.EventCreate.Builder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.messengerlib.R.string;
import com.linkedin.messengerlib.consumers.ActorDataManager.ParticipantChangeEventType;
import com.linkedin.messengerlib.me.MeFetcher.Callback;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.tracking.ImpressionUtil;
import com.linkedin.messengerlib.utils.EventCreateBuilderUtil;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MessageSenderUtil;
import com.linkedin.messengerlib.utils.NameFormatter;
import com.linkedin.messengerlib.utils.PendingRemoteId;
import com.linkedin.messengerlib.utils.SnackbarBuilder;
import java.util.List;

public final class AddParticipantFragment$4
  implements MeFetcher.Callback
{
  public AddParticipantFragment$4(AddParticipantFragment paramAddParticipantFragment, List paramList) {}
  
  public final void onResponse(MiniProfile paramMiniProfile)
  {
    ImpressionUtil.trackConversationDetailAction(this$0.fragmentComponent, AddParticipantFragment.access$000(this$0), AddParticipantFragment.access$100(this$0), "add_people", 3);
    try
    {
      MessageSenderUtil localMessageSenderUtil = new MessageSenderUtil(this$0.fragmentComponent);
      this$0.getActivity();
      long l = AddParticipantFragment.access$000(this$0);
      String str = AddParticipantFragment.access$100(this$0);
      List localList = val$peopleProfileToAdd;
      boolean bool = access$400this$0).shouldIncludeConversationHistory;
      l = localMessageSenderUtil.saveParticipantsToLocal$56944751(localList, l, PendingRemoteId.newId(), paramMiniProfile, ActorDataManager.ParticipantChangeEventType.ADD);
      paramMiniProfile = EventCreateBuilderUtil.createEventCreate(localList, true, bool).build(RecordTemplate.Flavor.RECORD);
      localMessageSenderUtil.saveParticipantsToNetwork$70e7c102(new SnackbarBuilder(NameFormatter.getAddParticipantsConfirmationString(fragmentComponent.i18NManager, localList), fragmentComponent.i18NManager.getString(R.string.messenger_participant_add_dialog_error), fragmentComponent), paramMiniProfile, l, str, false);
      return;
    }
    catch (BuilderException paramMiniProfile)
    {
      Log.e(AddParticipantFragment.access$500(), "Unable to make participant change: " + paramMiniProfile.getMessage(), paramMiniProfile);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */