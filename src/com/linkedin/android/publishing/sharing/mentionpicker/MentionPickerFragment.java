package com.linkedin.android.publishing.sharing.mentionpicker;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.feed.mentions.MentionableImpl;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.mentions.MentionsUtils;
import com.linkedin.android.feed.mentions.StatefulWordTokenizer;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.ui.MentionsEditTextWithBackEvents;
import com.linkedin.android.infra.ui.TintableImageView;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.spyglass.mentions.MentionSpan;
import com.linkedin.android.spyglass.mentions.Mentionable;
import com.linkedin.android.spyglass.tokenization.QueryToken;
import com.linkedin.android.spyglass.tokenization.impl.WordTokenizerConfig.Builder;
import java.util.Arrays;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class MentionPickerFragment
  extends PageFragment
{
  private static final String TAG = MentionPickerFragment.class.getSimpleName();
  @InjectView(2131758603)
  Button doneButton;
  @InjectView(2131758605)
  TextView mentionConnectorText;
  @InjectView(2131758608)
  RecyclerView mentionSuggestionsView;
  private String mentionWorkFlowId;
  @InjectView(2131758606)
  MentionsEditTextWithBackEvents mentionsInput;
  @Inject
  MentionsPresenter mentionsPresenter;
  private CharSequence previouslyAddedMentionsText;
  @InjectView(2131758604)
  TintableImageView searchIcon;
  @InjectView(2131758602)
  Toolbar toolbar;
  
  private MentionSpan getMentionSpanWithProfileId(String paramString)
  {
    Object localObject = mentionsInput.getText();
    localObject = (MentionSpan[])((Editable)localObject).getSpans(0, ((Editable)localObject).length(), MentionSpan.class);
    int i = 0;
    while (i < localObject.length)
    {
      MentionSpan localMentionSpan = localObject[i];
      Mentionable localMentionable = mention;
      if (((localMentionable instanceof MentionableImpl)) && (paramString.equals(entityUrn))) {
        return localMentionSpan;
      }
      i += 1;
    }
    return null;
  }
  
  public final void doPause()
  {
    super.doPause();
    fragmentComponent.eventBus();
    Bus.unsubscribe(this);
  }
  
  public final void doResume()
  {
    super.doResume();
    fragmentComponent.eventBus();
    Bus.subscribe(this);
    mentionsPresenter.selectedMentionList = MentionsUtils.getMentionableList(mentionsInput.getText());
    mentionsInput.setSelection(mentionsInput.length());
  }
  
  final void ensureMentionsInputHasCorrectFormat()
  {
    Editable localEditable = mentionsInput.getText();
    MentionSpan[] arrayOfMentionSpan = (MentionSpan[])localEditable.getSpans(0, localEditable.length(), MentionSpan.class);
    Arrays.sort(arrayOfMentionSpan, new MentionPickerFragment.4(this, localEditable));
    int i = 0;
    if (i < arrayOfMentionSpan.length)
    {
      if (isSelected)
      {
        isSelected = false;
        arrayOfMentionSpan[i].updateDrawState(new TextPaint());
      }
      int k = localEditable.getSpanEnd(arrayOfMentionSpan[i]);
      if (i == arrayOfMentionSpan.length - 1) {}
      for (int j = localEditable.length();; j = localEditable.getSpanStart(arrayOfMentionSpan[(i + 1)]))
      {
        localEditable.replace(k, j, ", ");
        i += 1;
        break;
      }
    }
    if (arrayOfMentionSpan.length > 0)
    {
      i = localEditable.getSpanStart(arrayOfMentionSpan[0]);
      if (i > 0) {
        localEditable.delete(0, i);
      }
      i = localEditable.getSpanEnd(arrayOfMentionSpan[(arrayOfMentionSpan.length - 1)]);
      if (localEditable.length() > i) {
        localEditable.delete(i - 1, localEditable.length());
      }
    }
    for (;;)
    {
      mentionsInput.setText(localEditable);
      mentionsInput.setSelection(mentionsInput.length());
      return;
      localEditable.delete(0, localEditable.length());
    }
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    mentionWorkFlowId = String.valueOf(System.currentTimeMillis());
    previouslyAddedMentionsText = getArguments().getCharSequence("existing_mention_text");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969430, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    mentionsPresenter.cleanUp();
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    Object localObject2 = clickedItem;
    int i = type;
    String str = "";
    Object localObject1;
    if ((i == 1) && ((localObject2 instanceof MiniProfile)))
    {
      localObject1 = entityUrn.toString();
      paramClickEvent = mentionsPresenter.getMentionable(paramClickEvent);
      if (getMentionSpanWithProfileId((String)localObject1) == null) {
        break label205;
      }
      i = 1;
      label62:
      if (i == 0) {
        break label286;
      }
      paramClickEvent = getMentionSpanWithProfileId((String)localObject1);
      if (paramClickEvent != null)
      {
        if (paramClickEvent.getDisplayString().length() != mentionsInput.length()) {
          break label210;
        }
        mentionsInput.setText("");
        mentionsPresenter.removeMentionFromSelection(mention);
      }
    }
    for (;;)
    {
      ensureMentionsInputHasCorrectFormat();
      if (mentionsInput.length() > 0) {
        mentionsInput.append(", ");
      }
      return;
      if ((i == 3) && ((localObject2 instanceof MiniCompany)))
      {
        localObject1 = entityUrn.toString();
        break;
      }
      localObject1 = str;
      if (i != 2) {
        break;
      }
      localObject1 = str;
      if (!(localObject2 instanceof MiniSchool)) {
        break;
      }
      localObject1 = entityUrn.toString();
      break;
      label205:
      i = 0;
      break label62;
      label210:
      localObject1 = mentionsInput.getText();
      int j = ((Editable)localObject1).getSpanStart(paramClickEvent);
      int k = ((Editable)localObject1).getSpanEnd(paramClickEvent);
      if (j == 0) {}
      for (i = mentionsInput.length();; i = 0)
      {
        mentionsInput.setSelection(i);
        ((Editable)localObject1).delete(j, k);
        mentionsInput.setText((CharSequence)localObject1);
        break;
      }
      label286:
      if (paramClickEvent != null) {
        if (mentionsInput.getCurrentTokenString().length() > 0) {
          mentionsInput.insertMention(paramClickEvent);
        } else {
          mentionsInput.insertMentionWithoutToken(paramClickEvent);
        }
      }
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    toolbar.setNavigationOnClickListener(new MentionPickerFragment.1(this));
    doneButton.setOnClickListener(new MentionPickerFragment.2(this));
    int i = getArguments().getInt("attachment_type");
    if (i == 1)
    {
      mentionConnectorText.setHint(getResources().getString(2131233898));
      mentionsInput.setHint(getResources().getString(2131233899));
    }
    for (;;)
    {
      mentionsInput.addTextChangedListener(new MentionPickerFragment.3(this));
      if (!TextUtils.isEmpty(previouslyAddedMentionsText))
      {
        mentionsInput.setText(previouslyAddedMentionsText);
        mentionsInput.append(", ");
        mentionsInput.setSelection(mentionsInput.length());
      }
      mentionsInput.addMentionWatcher(mentionsPresenter);
      mentionsPresenter.mentionWorkFlowId = mentionWorkFlowId;
      mentionsPresenter.shouldShowMentionSelectionState = true;
      if (previouslyAddedMentionsText != null) {
        mentionsPresenter.selectedMentionList = MentionsUtils.getMentionableList(previouslyAddedMentionsText);
      }
      mentionsPresenter.bind(mentionSuggestionsView);
      mentionsPresenter.alwaysExplicit = true;
      mentionsPresenter.onQueryReceived(new QueryToken(""));
      paramView = new WordTokenizerConfig.Builder();
      threshold = 1;
      maxNumKeywords = 2;
      explicitChars = ",";
      paramView = paramView.build();
      mentionsInput.setTokenizer(new StatefulWordTokenizer(paramView));
      mentionsInput.setQueryTokenReceiver(mentionsPresenter);
      return;
      if (i == 2)
      {
        mentionConnectorText.setHint(getResources().getString(2131233896));
        mentionsInput.setHint(getResources().getString(2131233897));
      }
    }
  }
  
  public final String pageKey()
  {
    return "feed_share_mention";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.mentionpicker.MentionPickerFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */