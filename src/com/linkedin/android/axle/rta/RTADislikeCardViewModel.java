package com.linkedin.android.axle.rta;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.simple.SimpleTextWatcher;
import com.linkedin.android.infra.viewmodel.ViewModel;

public final class RTADislikeCardViewModel
  extends ViewModel<RTADislikeCardViewHolder>
{
  public View.OnClickListener cancelOnClickListener;
  public Boolean isEdited;
  public View.OnClickListener sendOnClickListener;
  public String sendText;
  public TextWatcher textWatcher;
  public String titleText;
  
  public final ViewHolderCreator<RTADislikeCardViewHolder> getCreator()
  {
    return RTADislikeCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$62a35ce2(final RTADislikeCardViewHolder paramRTADislikeCardViewHolder)
  {
    isEdited = Boolean.valueOf(false);
    textWatcher = new SimpleTextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        paramAnonymousEditable = RTADislikeCardViewModel.this;
        if (paramRTADislikeCardViewHoldereditFeedback.getText().length() > 0) {}
        for (boolean bool = true;; bool = false)
        {
          isEdited = Boolean.valueOf(bool);
          paramRTADislikeCardViewHoldersend.setEnabled(isEdited.booleanValue());
          return;
        }
      }
    };
    dimBackground.setOnClickListener(cancelOnClickListener);
    title.setText(titleText);
    editFeedback.setText("");
    editFeedback.requestFocus();
    editFeedback.addTextChangedListener(textWatcher);
    dismissButton.setOnClickListener(cancelOnClickListener);
    dismiss.setOnClickListener(cancelOnClickListener);
    send.setText(sendText);
    send.setOnClickListener(sendOnClickListener);
    send.setEnabled(false);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.axle.rta.RTADislikeCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */