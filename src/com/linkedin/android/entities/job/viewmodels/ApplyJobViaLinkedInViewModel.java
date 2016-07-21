package com.linkedin.android.entities.job.viewmodels;

import android.support.v4.util.Pair;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.linkedin.android.entities.viewholders.ApplyJobViaLinkedInViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ApplyJobViaLinkedInViewModel
  extends ViewModel<ApplyJobViaLinkedInViewHolder>
{
  public ImageModel actorImageModel;
  public String email;
  public String headline;
  public String location;
  public String name;
  public Closure<Void, Void> onCloseModalClick;
  public TrackingClosure<Void, Void> onEditProfileClick;
  public TrackingClosure<Pair<String, String>, Void> onSubmitApplicationClick;
  public String phone;
  
  public final void enableSubmitButton(Button paramButton)
  {
    if ((!TextUtils.isEmpty(phone)) && (!TextUtils.isEmpty(email)) && (Patterns.EMAIL_ADDRESS.matcher(email).matches())) {}
    for (boolean bool = true;; bool = false)
    {
      paramButton.setEnabled(bool);
      return;
    }
  }
  
  public final ViewHolderCreator<ApplyJobViaLinkedInViewHolder> getCreator()
  {
    return ApplyJobViaLinkedInViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$646df37b(MediaCenter paramMediaCenter, final ApplyJobViaLinkedInViewHolder paramApplyJobViaLinkedInViewHolder)
  {
    actorImageModel.setImageView(paramMediaCenter, actorImage);
    name.setText(name);
    headline.setText(headline);
    ViewUtils.setTextAndUpdateVisibility(location, location);
    emailInput.setText(email);
    emailInput.addTextChangedListener(new TextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        email = paramAnonymousEditable.toString();
        enableSubmitButton(paramApplyJobViaLinkedInViewHoldersubmitApplicationButton);
      }
      
      public final void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public final void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    });
    phoneInput.setText(phone);
    phoneInput.addTextChangedListener(new PhoneNumberFormattingTextWatcher()
    {
      public final void afterTextChanged(Editable paramAnonymousEditable)
      {
        super.afterTextChanged(paramAnonymousEditable);
        phone = paramAnonymousEditable.toString();
        enableSubmitButton(paramApplyJobViaLinkedInViewHoldersubmitApplicationButton);
      }
    });
    enableSubmitButton(submitApplicationButton);
    submitApplicationButton.setOnClickListener(new TrackingOnClickListener(onSubmitApplicationClick.tracker, onSubmitApplicationClick.controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAnonymousView = paramApplyJobViaLinkedInViewHolder;
        submitApplicationButton.setEnabled(false);
        editProfileButton.setEnabled(false);
        emailInput.setEnabled(false);
        phoneInput.setEnabled(false);
        loadingOverlay.setVisibility(0);
        loadingSpinner.setVisibility(0);
        onSubmitApplicationClick.apply(new Pair(email, phone));
      }
    });
    editProfileButton.setOnClickListener(new TrackingOnClickListener(onEditProfileClick.tracker, onEditProfileClick.controlName, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        onEditProfileClick.apply(null);
      }
    });
    closeModalButton.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        onCloseModalClick.apply(null);
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.job.viewmodels.ApplyJobViaLinkedInViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */