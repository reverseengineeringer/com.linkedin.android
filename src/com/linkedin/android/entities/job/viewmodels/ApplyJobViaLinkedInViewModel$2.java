package com.linkedin.android.entities.job.viewmodels;

import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder;

final class ApplyJobViaLinkedInViewModel$2
  extends PhoneNumberFormattingTextWatcher
{
  ApplyJobViaLinkedInViewModel$2(ApplyJobViaLinkedInViewModel paramApplyJobViaLinkedInViewModel, ApplyJobViaLinkedInViewHolder paramApplyJobViaLinkedInViewHolder) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    super.afterTextChanged(paramEditable);
    this$0.phone = paramEditable.toString();
    this$0.enableSubmitButton(val$holder.submitApplicationButton);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.viewmodels.ApplyJobViaLinkedInViewModel.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */