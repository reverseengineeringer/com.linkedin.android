package com.linkedin.android.axle.rta;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import com.linkedin.android.infra.simple.SimpleTextWatcher;

final class RTADislikeCardViewModel$1
  extends SimpleTextWatcher
{
  RTADislikeCardViewModel$1(RTADislikeCardViewModel paramRTADislikeCardViewModel, RTADislikeCardViewHolder paramRTADislikeCardViewHolder) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this$0;
    if (val$holder.editFeedback.getText().length() > 0) {}
    for (boolean bool = true;; bool = false)
    {
      isEdited = Boolean.valueOf(bool);
      val$holder.send.setEnabled(this$0.isEdited.booleanValue());
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeCardViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */