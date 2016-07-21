package com.linkedin.android.entities.job.viewmodels;

import android.text.Editable;
import android.text.TextWatcher;
import com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder;

final class ApplyJobViaLinkedInViewModel$1
  implements TextWatcher
{
  ApplyJobViaLinkedInViewModel$1(ApplyJobViaLinkedInViewModel paramApplyJobViaLinkedInViewModel, ApplyJobViaLinkedInViewHolder paramApplyJobViaLinkedInViewHolder) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this$0.email = paramEditable.toString();
    this$0.enableSubmitButton(val$holder.submitApplicationButton);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.viewmodels.ApplyJobViaLinkedInViewModel.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */