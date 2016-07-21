package com.linkedin.android.infra.shared;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.artdeco.ArtDeco;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.networking.util.NetworkUtils;
import com.linkedin.android.tracking.v2.event.MobileApplicationErrorEvent;
import com.linkedin.android.tracking.v2.event.PageInstance;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.gen.avro2pegasus.events.ApplicationBuildType;
import com.linkedin.gen.avro2pegasus.events.ErrorType;
import java.lang.ref.WeakReference;

public final class ErrorPageViewModel
  extends ViewModel<ErrorPageViewHolder>
{
  public String errorButtonText;
  public String errorDescriptionText;
  public String errorHeaderText;
  public int errorImage;
  private ViewStub errorViewStub;
  private WeakReference<View> inflatedView;
  public TrackingClosure<Void, Void> onErrorButtonClick;
  
  public ErrorPageViewModel(ViewStub paramViewStub)
  {
    errorViewStub = paramViewStub;
  }
  
  public final ViewHolderCreator<ErrorPageViewHolder> getCreator()
  {
    if (errorViewStub != null)
    {
      if (errorViewStub.getParent() == null) {
        break label39;
      }
      inflatedView = new WeakReference(errorViewStub.inflate());
    }
    for (;;)
    {
      return ErrorPageViewHolder.CREATOR;
      label39:
      if ((inflatedView != null) && (inflatedView.get() != null)) {
        errorViewStub.setVisibility(0);
      }
    }
  }
  
  public final void onBindViewHolder$49e9e35b(LayoutInflater paramLayoutInflater, ErrorPageViewHolder paramErrorPageViewHolder)
  {
    errorImage.setImageResource(errorImage);
    ViewUtils.setTextAndUpdateVisibility(errorHeaderTextView, errorHeaderText);
    if ((errorHeaderText != null) && (errorHeaderText.length() >= 40)) {
      ArtDeco.setTextViewAppearance(errorHeaderTextView, 2131361814, paramLayoutInflater.getContext());
    }
    ViewUtils.setTextAndUpdateVisibility(errorDescriptionTextView, errorDescriptionText);
    if ((errorDescriptionText != null) && (errorDescriptionText.length() >= 60)) {
      ArtDeco.setTextViewAppearance(errorDescriptionTextView, 2131361796, paramLayoutInflater.getContext());
    }
    if (onErrorButtonClick != null)
    {
      errorActionButton.setText(errorButtonText);
      errorActionButton.setOnClickListener(new ErrorPageViewModel.1(this, onErrorButtonClick.tracker, onErrorButtonClick.controlName, new TrackingEventBuilder[0]));
      errorActionButton.setVisibility(0);
      return;
    }
    errorActionButton.setVisibility(4);
  }
  
  public final void onBindViewHolderWithErrorTracking$18b8048(LayoutInflater paramLayoutInflater, ErrorPageViewHolder paramErrorPageViewHolder, Tracker paramTracker, PageInstance paramPageInstance)
  {
    onBindViewHolder$49e9e35b(paramLayoutInflater, paramErrorPageViewHolder);
    new MobileApplicationErrorEvent(paramTracker, ApplicationBuildType.PRODUCTION, "Voyager", "0.21.208", errorHeaderTextView.getText().toString() + ". " + errorDescriptionTextView.getText().toString(), null, ErrorType.LOGGED_ERROR, paramPageInstance).send();
  }
  
  public final void remove()
  {
    if ((errorViewStub != null) && (inflatedView != null) && (inflatedView.get() != null)) {
      errorViewStub.setVisibility(8);
    }
  }
  
  public final int setupDefaultErrorConfiguration(Context paramContext, TrackingClosure<Void, Void> paramTrackingClosure)
  {
    if (NetworkUtils.hasActiveInternetConnection(paramContext) == 0)
    {
      errorHeaderText = paramContext.getString(2131232788);
      errorDescriptionText = paramContext.getString(2131232784);
      errorButtonText = paramContext.getString(2131232786);
      onErrorButtonClick = paramTrackingClosure;
      errorImage = 2130838584;
      return 0;
    }
    errorHeaderText = paramContext.getString(2131232787);
    errorDescriptionText = paramContext.getString(2131232785);
    errorButtonText = paramContext.getString(2131232786);
    onErrorButtonClick = paramTrackingClosure;
    errorImage = 2130838622;
    return 1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.ErrorPageViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */