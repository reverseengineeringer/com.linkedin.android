package com.linkedin.android.feed.detail;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import com.linkedin.android.feed.endor.ui.FeedViewTransformerHelpers;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.mentions.MentionsPresenter.MentionsResultListener;
import com.linkedin.android.feed.mentions.MentionsUtils;
import com.linkedin.android.feed.mentions.MentionsWordTokenizer;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.tracking.MentionsTracking;
import com.linkedin.android.feed.updates.common.comment.CommentPublisher;
import com.linkedin.android.feed.updates.common.footer.SocialFooterViewHolder;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.simple.SimpleTextWatcher;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents.EditTextImeBackListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.spyglass.suggestions.interfaces.SuggestionsVisibilityManager;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionActionType;
import java.lang.ref.WeakReference;
import org.greenrobot.eventbus.Subscribe;

public class BaseSocialFooterManager
  implements MentionsPresenter.MentionsResultListener, SuggestionsVisibilityManager
{
  protected final Context appContext;
  public final CommentPublisher commentPublisher;
  protected int currentState = 0;
  protected final Bus eventBus;
  protected WeakReference<SocialFooterStateChangeListener> footerStateChangeListener;
  public final WeakReference<FragmentComponent> fragmentComponent;
  public final MiniProfile memberMiniProfile;
  protected final String mentionWorkFlowId;
  protected final WeakReference<MentionsPresenter> mentionsPresenter;
  protected final WeakReference<RecyclerView> mentionsRecyclerView;
  public final WeakReference<MentionsEditTextWithBackEvents> replyEditText;
  public final WeakReference<SocialFooterViewHolder> socialFooterViewHolder;
  public final Tracker tracker;
  public Update update;
  
  public BaseSocialFooterManager(FragmentComponent paramFragmentComponent, MentionsPresenter paramMentionsPresenter, RecyclerView paramRecyclerView, SocialFooterViewHolder paramSocialFooterViewHolder, String paramString)
  {
    mentionWorkFlowId = paramString;
    appContext = paramFragmentComponent.context().getApplicationContext();
    eventBus = paramFragmentComponent.eventBus();
    commentPublisher = paramFragmentComponent.commentPublisher();
    tracker = paramFragmentComponent.tracker();
    fragmentComponent = new WeakReference(paramFragmentComponent);
    memberMiniProfile = paramFragmentComponent.memberUtil().getMiniProfile();
    mentionsPresenter = new WeakReference(paramMentionsPresenter);
    socialFooterViewHolder = new WeakReference(paramSocialFooterViewHolder);
    mentionsRecyclerView = new WeakReference(paramRecyclerView);
    replyEditText = new WeakReference(reply);
    paramMentionsPresenter = (RecyclerView)mentionsRecyclerView.get();
    paramFragmentComponent = (MentionsPresenter)mentionsPresenter.get();
    if ((paramMentionsPresenter != null) && (paramFragmentComponent != null))
    {
      paramFragmentComponent.bind(paramMentionsPresenter);
      mentionsResultListener = this;
      paramMentionsPresenter = (MentionsEditTextWithBackEvents)replyEditText.get();
      if (paramMentionsPresenter != null)
      {
        paramMentionsPresenter.setTokenizer(new MentionsWordTokenizer());
        paramMentionsPresenter.setQueryTokenReceiver(paramFragmentComponent);
      }
      paramFragmentComponent = (MentionsEditTextWithBackEvents)replyEditText.get();
      if (paramFragmentComponent != null) {
        paramFragmentComponent.setSuggestionsVisibilityManager(this);
      }
    }
    setupSendButton();
    paramFragmentComponent = (MentionsEditTextWithBackEvents)replyEditText.get();
    if (paramFragmentComponent != null)
    {
      paramFragmentComponent.setOnFocusChangeListener(new View.OnFocusChangeListener()
      {
        public final void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean)
          {
            BaseSocialFooterManager localBaseSocialFooterManager = BaseSocialFooterManager.this;
            FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
            String str = "comment";
            paramAnonymousView = "expandCommentBox";
            if (FeedViewTransformerHelpers.isCommentDetailPage(localFragmentComponent))
            {
              str = "reply";
              paramAnonymousView = "expandReplyBox";
            }
            localBaseSocialFooterManager.trackFAE(localFragmentComponent, str, ActionCategory.EXPAND, paramAnonymousView);
          }
          paramAnonymousView = BaseSocialFooterManager.this;
          if (paramAnonymousBoolean) {}
          for (int i = 1;; i = 0)
          {
            paramAnonymousView.setupSocialFooterState(i);
            return;
          }
        }
      });
      paramFragmentComponent.addTextChangedListener(new SimpleTextWatcher()
      {
        public final void afterTextChanged(Editable paramAnonymousEditable)
        {
          if ((paramAnonymousEditable != null) && (paramAnonymousEditable.toString().trim().length() > 0) && (memberMiniProfile != null)) {}
          for (boolean bool = true;; bool = false)
          {
            paramAnonymousEditable = (SocialFooterViewHolder)socialFooterViewHolder.get();
            if (paramAnonymousEditable != null) {
              send.setEnabled(bool);
            }
            return;
          }
        }
      });
      paramFragmentComponent.setOnEditTextImeBackListener(new MentionsEditTextWithBackEvents.EditTextImeBackListener()
      {
        public final void onImeBack$621954f1()
        {
          if (currentState == 1) {
            setupSocialFooterState(0);
          }
        }
      });
      paramFragmentComponent.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          int i = paramAnonymousMotionEvent.getActionMasked();
          paramAnonymousView = (MentionsEditTextWithBackEvents)replyEditText.get();
          if ((i == 1) && (paramAnonymousView != null))
          {
            Rect localRect = new Rect();
            paramAnonymousView.getHitRect(localRect);
            if (localRect.contains((int)paramAnonymousMotionEvent.getX(), (int)paramAnonymousMotionEvent.getY())) {
              if (!FeedViewTransformerHelpers.isCommentDetailPage((FragmentComponent)fragmentComponent.get())) {
                break label109;
              }
            }
          }
          label109:
          for (paramAnonymousView = "reply";; paramAnonymousView = "comment")
          {
            new ControlInteractionEvent(tracker, paramAnonymousView, ControlType.TEXTFIELD, InteractionType.SHORT_PRESS).send();
            return false;
          }
        }
      });
      paramMentionsPresenter = (MentionsPresenter)mentionsPresenter.get();
      if (paramMentionsPresenter != null)
      {
        mentionWorkFlowId = mentionWorkFlowId;
        paramFragmentComponent.addMentionWatcher(paramMentionsPresenter);
      }
      setupReplyEditTextHint();
    }
  }
  
  public final void displaySuggestions(boolean paramBoolean)
  {
    RecyclerView localRecyclerView = (RecyclerView)mentionsRecyclerView.get();
    if (localRecyclerView != null)
    {
      if ((isDisplayingSuggestions()) && (!paramBoolean))
      {
        FragmentComponent localFragmentComponent = (FragmentComponent)fragmentComponent.get();
        MentionsPresenter localMentionsPresenter = (MentionsPresenter)mentionsPresenter.get();
        if ((localFragmentComponent != null) && (localMentionsPresenter != null)) {
          MentionsTracking.fireMentionSuggestionActionEvent(localFragmentComponent, query, mentionWorkFlowId, MentionActionType.DISMISS, null);
        }
      }
      if (!paramBoolean) {
        break label90;
      }
    }
    label90:
    for (int i = 0;; i = 8)
    {
      localRecyclerView.setVisibility(i);
      return;
    }
  }
  
  public final boolean isDisplayingSuggestions()
  {
    RecyclerView localRecyclerView = (RecyclerView)mentionsRecyclerView.get();
    return (localRecyclerView != null) && (localRecyclerView.getVisibility() == 0);
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    Object localObject = (RecyclerView)mentionsRecyclerView.get();
    if (localObject != null)
    {
      ((RecyclerView)localObject).setVisibility(8);
      localObject = (MentionsPresenter)mentionsPresenter.get();
      if (localObject != null)
      {
        paramClickEvent = ((MentionsPresenter)localObject).getMentionable(paramClickEvent);
        localObject = (MentionsEditTextWithBackEvents)replyEditText.get();
        if ((paramClickEvent != null) && (localObject != null)) {
          ((MentionsEditTextWithBackEvents)localObject).insertMention(paramClickEvent);
        }
      }
    }
  }
  
  public final void onResume()
  {
    if (!Bus.isSubscribed(this)) {
      Bus.subscribe(this);
    }
  }
  
  public final void populateMention(Comment paramComment)
  {
    MentionsEditTextWithBackEvents localMentionsEditTextWithBackEvents = (MentionsEditTextWithBackEvents)replyEditText.get();
    if ((localMentionsEditTextWithBackEvents == null) || (fragmentComponent.get() == null)) {}
    do
    {
      return;
      localMentionsEditTextWithBackEvents.setText("");
      paramComment = MentionsUtils.getMentionable((FragmentComponent)fragmentComponent.get(), paramComment);
    } while (paramComment == null);
    localMentionsEditTextWithBackEvents.insertMentionWithoutToken(paramComment);
  }
  
  public final void setSocialFooterStateChangeListener(SocialFooterStateChangeListener paramSocialFooterStateChangeListener)
  {
    footerStateChangeListener = new WeakReference(paramSocialFooterStateChangeListener);
  }
  
  protected void setupMentionsPresenter() {}
  
  public void setupReplyEditTextHint() {}
  
  public void setupSendButton() {}
  
  public final void setupSocialFooter(Update paramUpdate)
  {
    SocialFooterViewHolder localSocialFooterViewHolder = (SocialFooterViewHolder)socialFooterViewHolder.get();
    if (localSocialFooterViewHolder == null) {
      return;
    }
    if (socialDetail == null)
    {
      localSocialFooterViewHolder.hide();
      return;
    }
    update = paramUpdate;
    closeDiscussion.setVisibility(8);
    socialActionsView.setVisibility(0);
    itemView.setClickable(true);
    setupSocialFooterState(currentState);
    setupReplyEditTextHint();
    setupMentionsPresenter();
  }
  
  public final void setupSocialFooterState(int paramInt)
  {
    if (currentState == paramInt) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
          currentState = paramInt;
          localObject = (MentionsEditTextWithBackEvents)replyEditText.get();
        } while (localObject == null);
        if (paramInt != 1) {
          break;
        }
        if (!((MentionsEditTextWithBackEvents)localObject).hasFocus())
        {
          ((MentionsEditTextWithBackEvents)localObject).requestFocus();
          ((InputMethodManager)appContext.getSystemService("input_method")).showSoftInput((View)localObject, 1);
        }
        localObject = (SocialFooterStateChangeListener)footerStateChangeListener.get();
      } while (localObject == null);
      ((SocialFooterStateChangeListener)localObject).onSocialFooterComposeState();
      return;
      if (((MentionsEditTextWithBackEvents)localObject).hasFocus())
      {
        ((MentionsEditTextWithBackEvents)localObject).clearFocus();
        ((InputMethodManager)appContext.getSystemService("input_method")).hideSoftInputFromWindow(((MentionsEditTextWithBackEvents)localObject).getWindowToken(), 0);
      }
      localObject = (SocialFooterStateChangeListener)footerStateChangeListener.get();
    } while (localObject == null);
    ((SocialFooterStateChangeListener)localObject).onSocialFooterDefaultState();
  }
  
  public void trackFAE(FragmentComponent paramFragmentComponent, String paramString1, ActionCategory paramActionCategory, String paramString2)
  {
    if ((update != null) && (update.tracking != null) && (paramFragmentComponent != null)) {
      FeedTracking.trackFAE(tracker, paramString1, paramActionCategory, paramString2, update.tracking, update.urn, paramFragmentComponent);
    }
  }
  
  public static abstract interface SocialFooterStateChangeListener
  {
    public abstract void onSocialFooterComposeState();
    
    public abstract void onSocialFooterDefaultState();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.detail.BaseSocialFooterManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */