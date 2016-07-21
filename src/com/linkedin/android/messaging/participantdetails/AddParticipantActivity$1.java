package com.linkedin.android.messaging.participantdetails;

import android.widget.TextView;
import com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment.AddParticipantCallbacks;

final class AddParticipantActivity$1
  implements AddParticipantFragment.AddParticipantCallbacks
{
  AddParticipantActivity$1(AddParticipantActivity paramAddParticipantActivity) {}
  
  public final void onPendingParticipantsChange(boolean paramBoolean)
  {
    TextView localTextView;
    if (this$0.doneButton != null)
    {
      localTextView = this$0.doneButton;
      if (!paramBoolean) {
        break label31;
      }
    }
    label31:
    for (int i = 8;; i = 0)
    {
      localTextView.setVisibility(i);
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.AddParticipantActivity.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */