package com.linkedin.android.entities.viewmodels.cards;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.linkedin.android.entities.viewholders.ParagraphCardViewHolder;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.ui.EllipsizeTextView.OnEllipsizeListener;
import com.linkedin.android.infra.ui.ExpandableTextView;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class ParagraphCardViewModel
  extends EntityBaseCardViewModel<ParagraphCardViewHolder>
{
  public CharSequence body;
  public boolean expandInNewPage;
  public boolean hasChildCards;
  protected boolean isBodyExpanded;
  public int maxLinesCollapsed;
  public TrackingClosure<Void, Void> onExpandButtonClick;
  public String seeMoreButtonText;
  
  static void resetExpandButtons(ParagraphCardViewHolder paramParagraphCardViewHolder)
  {
    readMoreButton.setText(null);
    readMoreButton.setVisibility(8);
    button.setVisibility(8);
    divider.setVisibility(8);
  }
  
  public final ViewHolderCreator<ParagraphCardViewHolder> getCreator()
  {
    return ParagraphCardViewHolder.CREATOR;
  }
  
  public final void onBindViewHolder$25123f24(final ParagraphCardViewHolder paramParagraphCardViewHolder)
  {
    if (hasChildCards)
    {
      setupExpandButton(paramParagraphCardViewHolder, true);
      header.setText(header);
      if (!isBodyExpanded) {
        break label128;
      }
      body.expand(false);
    }
    for (;;)
    {
      body.setMaxLinesWhenCollapsed(maxLinesCollapsed);
      body.setText(body);
      if (onExpandButtonClick != null)
      {
        if (!expandInNewPage) {
          break label139;
        }
        readMoreButton.setOnClickListener(new TrackingOnClickListener(onExpandButtonClick.tracker, onExpandButtonClick.controlName, new TrackingEventBuilder[0])
        {
          public final void onClick(View paramAnonymousView)
          {
            super.onClick(paramAnonymousView);
            onExpandButtonClick.apply(null);
          }
        });
      }
      return;
      body.setOnEllipsizeListener(new EllipsizeTextView.OnEllipsizeListener()
      {
        public final void onEllipsize(boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            setupExpandButton(paramParagraphCardViewHolder, expandInNewPage);
            return;
          }
          ParagraphCardViewModel.resetExpandButtons(paramParagraphCardViewHolder);
        }
      });
      break;
      label128:
      body.collapse(false);
    }
    label139:
    Tracker localTracker = onExpandButtonClick.tracker;
    String str = onExpandButtonClick.controlName;
    button.setOnClickListener(new TrackingOnClickListener(localTracker, str, new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramParagraphCardViewHolderbody.expand(false);
      }
    });
  }
  
  public final void onRecycleViewHolder(ParagraphCardViewHolder paramParagraphCardViewHolder)
  {
    isBodyExpanded = body.isExpanded();
    button.setOnClickListener(null);
    readMoreButton.setOnClickListener(null);
    resetExpandButtons(paramParagraphCardViewHolder);
    super.onRecycleViewHolder(paramParagraphCardViewHolder);
  }
  
  final void setupExpandButton(ParagraphCardViewHolder paramParagraphCardViewHolder, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      readMoreButton.setText(seeMoreButtonText);
      readMoreButton.setVisibility(0);
    }
    for (;;)
    {
      divider.setVisibility(0);
      return;
      button.setVisibility(0);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */