package com.linkedin.android.publishing.sharing.compose;

import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.LeadingMarginSpan;
import android.text.style.LeadingMarginSpan.Standard;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.feed.endor.ui.FeedBorderManager;
import com.linkedin.android.feed.endor.ui.FeedComponentsView;
import com.linkedin.android.feed.endor.ui.FeedComponentsViewPool;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailTransformer;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailViewModel;
import com.linkedin.android.feed.endor.ui.component.contentdetail.layouts.FeedContentDetailArticleLayout;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaTransformer;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaViewModel;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaArticleLayout;
import com.linkedin.android.feed.endor.ui.component.richmedia.layouts.FeedRichMediaImageLayout;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.mentions.MentionsPresenter;
import com.linkedin.android.feed.mentions.MentionsPresenter.MentionsResultListener;
import com.linkedin.android.feed.mentions.MentionsWordTokenizer;
import com.linkedin.android.feed.shared.HashtagUtils;
import com.linkedin.android.feed.shared.HashtagUtils.Hashtag;
import com.linkedin.android.feed.shared.LinkUtils;
import com.linkedin.android.feed.shared.LinkUtils.Link;
import com.linkedin.android.feed.shared.UrlPreviewGetter;
import com.linkedin.android.feed.tracking.MentionsTracking;
import com.linkedin.android.feed.utils.FeedLixHelper;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.app.ViewPagerFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.events.ImageLoadFailedEvent;
import com.linkedin.android.infra.events.MeUpdatedEvent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest.BusImageRequestListener;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImage;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.PhotoUtils.UriListener;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.shared.ViewUtils;
import com.linkedin.android.infra.ui.TintableImageButton;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.common.Me;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.PreviewImage;
import com.linkedin.android.pegasus.gen.voyager.feed.urlpreview.UrlPreviewData;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.PublicContactInfo;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.TwitterHandle;
import com.linkedin.android.publishing.sharing.linkpicker.LinkPickerBundle;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.spyglass.suggestions.interfaces.SuggestionsVisibilityManager;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingDialogInterfaceOnClickListener;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;
import com.linkedin.gen.avro2pegasus.events.mentions.MentionActionType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public abstract class BaseShareComposeFragment
  extends ViewPagerFragment
  implements MentionsPresenter.MentionsResultListener, OnBackPressedListener, PhotoUtils.UriListener, ShareComposeEditorBar.CharacterCountMessageVisibilityManager, ShareComposeEditorBar.OnShareVisibilityChangedListener, SuggestionsVisibilityManager
{
  private static final String TAG = BaseShareComposeFragment.class.getSimpleName();
  @InjectView(2131758623)
  ImageView actorImage;
  private int attachmentType;
  private Uri cameraPhotoUri;
  @InjectView(2131758624)
  TextView characterCountMessage;
  @InjectView(2131758613)
  LinearLayout characterCountMessageContainer;
  @InjectView(2131758617)
  TintableImageButton clearMentionBar;
  private final int clearMentionButtonRotationAngle = 45;
  @InjectView(2131758622)
  ImageButton clearPreview;
  @InjectView(2131758612)
  ScrollView contentScrollView;
  UrlPreviewData currentUrlPreview;
  @Inject
  FlagshipDataManager dataManager;
  @InjectView(2131758621)
  FeedComponentsView detailPreview;
  @InjectView(2131758611)
  ShareComposeEditorBar editorBar;
  protected boolean enableFyiMentions;
  @InjectView(2131758618)
  FrameLayout mentionBar;
  @InjectView(2131758619)
  TextView mentionBarConnector;
  private boolean mentionBarConnectorHighlighted;
  @InjectView(2131758620)
  TextView mentionBarInput;
  private boolean mentionBarInputHighlighted;
  protected CharSequence mentionBarInputText;
  protected String mentionWorkFlowId;
  @Inject
  MentionsPresenter mentionsPresenter;
  @InjectView(2131758625)
  RecyclerView mentionsRecyclerView;
  protected MiniProfile miniProfile;
  private ShareComposeEditText.PasteListener pasteListener;
  protected Uri selectedImageUri;
  @Inject
  FeedSharePublisher sharePublisher;
  @InjectView(2131758616)
  ShareComposeEditText textInput;
  protected FeedComponentsViewPool viewPool = new FeedComponentsViewPool();
  
  static void addStylingToHashtags(CharSequence paramCharSequence, int paramInt)
  {
    List localList = HashtagUtils.getHashtags(paramCharSequence);
    int i = 0;
    if (i < localList.size())
    {
      HashtagUtils.Hashtag localHashtag = (HashtagUtils.Hashtag)localList.get(i);
      if (start >= paramInt - 1) {
        ((Spannable)paramCharSequence).setSpan(new StyleSpan(1), start, end, 33);
      }
      for (;;)
      {
        i += 1;
        break;
        if (end >= paramInt) {
          ((Spannable)paramCharSequence).setSpan(new StyleSpan(1), paramInt, end, 33);
        }
      }
    }
  }
  
  private int getMaximumCharacterCount(Resources paramResources)
  {
    return paramResources.getInteger(getMaximumCharacterCountResource());
  }
  
  private void reIndentMentionBarInputText(int paramInt)
  {
    Editable localEditable = mentionBarInput.getEditableText();
    if (!TextUtils.isEmpty(localEditable))
    {
      LeadingMarginSpan[] arrayOfLeadingMarginSpan = (LeadingMarginSpan[])localEditable.getSpans(0, localEditable.length(), LeadingMarginSpan.class);
      int j = arrayOfLeadingMarginSpan.length;
      int i = 0;
      while (i < j)
      {
        localEditable.removeSpan(arrayOfLeadingMarginSpan[i]);
        i += 1;
      }
      if (mentionBarConnector.length() != 0) {
        localEditable.setSpan(new LeadingMarginSpan.Standard(paramInt, 0), 0, mentionBarInput.length(), 0);
      }
    }
    if ((mentionBarConnector.length() > 0) && (mentionBarInput.length() == 0))
    {
      ViewUtils.setStartMargin(mentionBarInput, paramInt);
      return;
    }
    ViewUtils.setStartMargin(mentionBarInput, 0);
  }
  
  private void removeMediaPreview()
  {
    clearPreview.setVisibility(8);
    detailPreview.setVisibility(8);
    contentScrollView.setFillViewport(true);
    detailPreview.clearComponents(viewPool);
    selectedImageUri = null;
    currentUrlPreview = null;
    if ((enableFyiMentions) && (TextUtils.isEmpty(mentionBarInputText)))
    {
      clearMentionBar.setVisibility(8);
      showMentionBarConnectorText(false);
      showMentionBarInputText(false);
    }
    if (!ShareComposeBundle.isReshare(getArguments())) {
      listenForPastedLinks();
    }
    updateTextCharacterCount(getResources(), i18NManager);
    editorBar.setIconState(getShareType());
  }
  
  private void showClearPreviewButton(boolean paramBoolean)
  {
    ImageButton localImageButton = clearPreview;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
  
  private void showMentionBarConnectorText(boolean paramBoolean)
  {
    label41:
    TextView localTextView;
    if (paramBoolean) {
      if (attachmentType == 2)
      {
        i = 2131233896;
        mentionBarConnector.setText(i);
        mentionBarConnector.setBackgroundColor(ContextCompat.getColor(getActivity(), 2131624051));
        localTextView = mentionBarConnector;
        if (!paramBoolean) {
          break label78;
        }
      }
    }
    label78:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
      i = 2131233898;
      break;
      mentionBarConnector.setText("");
      break label41;
    }
  }
  
  private void showMentionBarInputText(boolean paramBoolean)
  {
    label41:
    TextView localTextView;
    if (paramBoolean) {
      if (attachmentType == 2)
      {
        i = 2131233897;
        mentionBarInput.setHint(i);
        mentionBarInput.setBackgroundColor(ContextCompat.getColor(getActivity(), 2131624051));
        localTextView = mentionBarInput;
        if (!paramBoolean) {
          break label85;
        }
      }
    }
    label85:
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      return;
      i = 2131233899;
      break;
      mentionBarInput.setText("");
      mentionBarInputText = "";
      break label41;
    }
  }
  
  final int computeCharacterCount()
  {
    Object localObject = textInput.getText().toString();
    int n = ((String)localObject).length();
    int i = 0;
    int k = 0;
    int j = 0;
    boolean bool1 = false;
    boolean bool2 = false;
    LinkUtils.Link localLink;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = LinkUtils.getWebLinks((CharSequence)localObject);
      Iterator localIterator = ((List)localObject).iterator();
      bool1 = bool2;
      i = k;
      while (localIterator.hasNext())
      {
        localLink = (LinkUtils.Link)localIterator.next();
        j = i + (end - start);
        i = j;
        if (!bool1) {
          if (currentUrlPreview == null) {
            break label219;
          }
        }
      }
    }
    label196:
    label210:
    label219:
    for (bool1 = url.equalsIgnoreCase(currentUrlPreview.url);; bool1 = false)
    {
      i = j;
      break;
      j = ((List)localObject).size() * 24;
      if ((!bool1) && (hasShareItem()))
      {
        k = 24;
        if (!enableFyiMentions) {
          break label210;
        }
        if (!TextUtils.isEmpty(mentionBarInputText)) {
          break label196;
        }
      }
      for (int m = 0;; m = getFyiMentionsTextToAppend().length())
      {
        return n - i + k + j + m;
        k = 0;
        break;
      }
      return n - i + k + j;
    }
  }
  
  public final void displaySuggestions(boolean paramBoolean)
  {
    if ((mentionsRecyclerView == null) || (textInput == null)) {
      return;
    }
    if ((isDisplayingSuggestions()) && (!paramBoolean) && (mentionsPresenter != null)) {
      MentionsTracking.fireMentionSuggestionActionEvent(fragmentComponent, mentionsPresenter.query, mentionWorkFlowId, MentionActionType.DISMISS, null);
    }
    Object localObject = mentionsRecyclerView;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      ((RecyclerView)localObject).setVisibility(i);
      if (!paramBoolean) {
        break label135;
      }
      localObject = textInput.getLayout();
      if (localObject == null) {
        break;
      }
      i = ((Layout)localObject).getLineTop(((Layout)localObject).getLineForOffset(textInput.getSelectionStart()));
      int j = contentScrollView.getScrollY();
      textInput.scrollTo(0, i - j);
      return;
    }
    label135:
    textInput.scrollTo(0, 0);
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
    updateTextCharacterCount(getResources(), i18NManager);
  }
  
  protected TrackingEventBuilder getAlertDialogTracking(ActionCategory paramActionCategory, String paramString1, String paramString2)
  {
    return null;
  }
  
  protected final DataProvider getDataProvider(ActivityComponent paramActivityComponent)
  {
    return paramActivityComponent.connectionsV2DataProvider();
  }
  
  protected final CharSequence getFyiMentionsTextToAppend()
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(mentionBarInputText))
    {
      localSpannableStringBuilder.append("\n");
      localSpannableStringBuilder.append(mentionBarConnector.getText());
      localSpannableStringBuilder.append(" ");
      localSpannableStringBuilder.append(mentionBarInputText);
    }
    return localSpannableStringBuilder;
  }
  
  protected abstract int getMaximumCharacterCountResource();
  
  protected abstract int getShareType();
  
  protected abstract void handlePostTapped();
  
  protected boolean hasShareItem()
  {
    return (selectedImageUri != null) || (currentUrlPreview != null);
  }
  
  public final void hideCharacterCountMessage()
  {
    characterCountMessageContainer.setVisibility(8);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final boolean isDisplayingSuggestions()
  {
    return mentionsRecyclerView.getVisibility() == 0;
  }
  
  protected boolean isEmptyShare()
  {
    return (TextUtils.isEmpty(textInput.getText())) && (!hasShareItem());
  }
  
  protected boolean isValidShare(int paramInt)
  {
    return (!isEmptyShare()) && (!editorBar.hasCharacterCountReached(paramInt));
  }
  
  protected final void listenForPastedLinks()
  {
    if (pasteListener != null) {
      return;
    }
    pasteListener = new BaseShareComposeFragment.13(this);
    textInput.setOnPasteListener(pasteListener);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 != -1) {
      if (paramInt1 == 11) {
        trackButtonShortPress("cancel_insert_media");
      }
    }
    do
    {
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (paramInt1 != 11) {
              break;
            }
            trackButtonShortPress("select_photo");
            if (paramIntent == null) {}
            for (paramIntent = null; paramIntent != null; paramIntent = paramIntent.getData())
            {
              previewOriginalImage(paramIntent);
              return;
            }
          }
          if (paramInt1 != 12) {
            break;
          }
          trackButtonShortPress("take_photo");
          paramIntent = cameraPhotoUri;
        } while (paramIntent == null);
        previewOriginalImage(paramIntent);
        return;
        if ((paramInt1 != 13) || (paramIntent == null)) {
          break;
        }
        paramIntent = LinkPickerBundle.getUrlPreviewData(paramIntent.getBundleExtra("BUNDLE_URL_PREVIEW_DATA"));
      } while (paramIntent == null);
      previewUrl(paramIntent, false);
      return;
    } while ((paramInt1 != 17) || (paramIntent == null));
    mentionBarInputText = paramIntent.getCharSequenceExtra("MentionPickerInputText");
    mentionBarInput.setText(mentionBarInputText, TextView.BufferType.EDITABLE);
    reIndentMentionBarInputText(mentionBarConnector.getWidth());
    updateTextCharacterCount(getResources(), i18NManager);
  }
  
  public final boolean onBackPressed()
  {
    displaySuggestions(false);
    ShareComposeEditText.hideKeyboard(getActivity());
    if (isEmptyShare()) {
      return false;
    }
    BaseShareComposeFragment.TrackingDialogDismissClickListener localTrackingDialogDismissClickListener = new BaseShareComposeFragment.TrackingDialogDismissClickListener(getActivity(), tracker, "discard", new TrackingEventBuilder[0]);
    Object localObject = getAlertDialogTracking(ActionCategory.DISMISS, "discard", "cancelShare");
    if (localObject != null) {
      localTrackingDialogDismissClickListener.addCustomTrackingEventBuilderBuilder((TrackingEventBuilder)localObject);
    }
    localObject = new TrackingDialogInterfaceOnClickListener(tracker, "continue", new TrackingEventBuilder[0]);
    TrackingEventBuilder localTrackingEventBuilder = getAlertDialogTracking(ActionCategory.DISMISS, "continue", "continueShare");
    if (localTrackingEventBuilder != null) {
      ((TrackingDialogInterfaceOnClickListener)localObject).addCustomTrackingEventBuilderBuilder(localTrackingEventBuilder);
    }
    new android.app.AlertDialog.Builder(getActivity()).setTitle(2131233661).setMessage(2131233660).setPositiveButton(2131233658, localTrackingDialogDismissClickListener).setNegativeButton(2131233659, (DialogInterface.OnClickListener)localObject).show();
    return true;
  }
  
  public final void onCameraDestinationUri(Uri paramUri)
  {
    cameraPhotoUri = paramUri;
  }
  
  @OnClick({2131758622})
  void onClearPreviewClicked()
  {
    if (selectedImageUri != null) {
      trackButtonShortPress("remove_media_preview");
    }
    for (;;)
    {
      removeMediaPreview();
      return;
      if (currentUrlPreview != null) {
        trackButtonShortPress("remove_article_preview");
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    mentionWorkFlowId = String.valueOf(System.currentTimeMillis());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969432, paramViewGroup, false);
  }
  
  public void onDestroy()
  {
    mentionsPresenter.cleanUp();
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(ImageLoadFailedEvent paramImageLoadFailedEvent)
  {
    if (Util.safeEquals(url, selectedImageUri.toString()))
    {
      SnackbarUtil.showWithErrorTracking$6c58675c(fragmentComponent.snackbarUtil().make(2131233664, 0), tracker, getPageInstance(), "Failed to attach image to share");
      removeMediaPreview();
    }
  }
  
  @Subscribe
  public void onEvent(MeUpdatedEvent paramMeUpdatedEvent)
  {
    miniProfile = me.miniProfile;
  }
  
  @Subscribe
  public void onEvent(ClickEvent paramClickEvent)
  {
    mentionsRecyclerView.setVisibility(8);
    textInput.insertMention(mentionsPresenter.getMentionable(paramClickEvent));
    updateTextCharacterCount(getResources(), i18NManager);
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putParcelable("CameraPhotoUri", cameraPhotoUri);
    paramBundle.putParcelable("SelectedImageUri", selectedImageUri);
    if (currentUrlPreview != null)
    {
      Bundle localBundle = new Bundle();
      RecordParceler.quietParcel(currentUrlPreview, "UrlPreviewData", localBundle);
      paramBundle.putBundle("UrlPreviewBundle", localBundle);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    FragmentComponent localFragmentComponent = fragmentComponent;
    miniProfile = localFragmentComponent.memberUtil().getMiniProfile();
    Object localObject;
    if (miniProfile != null)
    {
      paramView = miniProfile.picture;
      if (miniProfile == null) {
        break label484;
      }
      localObject = GhostImageUtils.getPerson(2131492962, miniProfile);
      label59:
      new ImageModel(paramView, (GhostImage)localObject, Util.retrieveRumSessionId(localFragmentComponent)).setImageView(applicationComponent.mediaCenter(), actorImage);
      actorImage.setOnTouchListener(new BaseShareComposeFragment.1(this));
      setupTextInput();
      setupMentions();
      enableFyiMentions = "mentionsButtonAndFyiMentions".equals(applicationComponent.lixManager().getTreatment(Lix.SHARE_FYI_MENTIONS));
      if (enableFyiMentions)
      {
        mentionBar.setOnClickListener(new BaseShareComposeFragment.5(this, tracker, "insert_mention", new TrackingEventBuilder[0]));
        mentionBarConnector.addOnLayoutChangeListener(new BaseShareComposeFragment.6(this));
        clearMentionBar.setOnClickListener(new BaseShareComposeFragment.7(this));
      }
      editorBar.setMaximiumCharacterCount(getMaximumCharacterCount(getResources()));
      editorBar.setIconState(getShareType());
      localObject = editorBar;
      localFragmentComponent = fragmentComponent;
      if (getShareType() != 2) {
        break label494;
      }
      paramView = ContextCompat.getDrawable(((ShareComposeEditorBar)localObject).getContext(), 2130838118);
      shareVisibilityButton.setImageDrawable(paramView);
      shareVisibility = 3;
      editorBar.setCharacterCountMessageVisibilityManager(this);
      editorBar.setShareVisibilityChangedListener(this);
      editorBar.setShareVisibilityButtonClickListener(new BaseShareComposeFragment.8(this));
      editorBar.setPostButtonClickListener(new BaseShareComposeFragment.9(this));
      editorBar.setCameraButtonClickListener(new BaseShareComposeFragment.10(this, tracker, "insert_media", new TrackingEventBuilder[0]));
      editorBar.setLinkButtonClickListener(new BaseShareComposeFragment.11(this, tracker, "insert_link", new TrackingEventBuilder[0]));
      editorBar.setMentionsButtonClickListener(new BaseShareComposeFragment.12(this, tracker, "insert_mention", new TrackingEventBuilder[0]));
      ViewCompat.setElevation(editorBar, getResources().getDimension(2131493543));
      if (paramBundle != null)
      {
        selectedImageUri = ((Uri)paramBundle.getParcelable("SelectedImageUri"));
        paramView = paramBundle.getBundle("UrlPreviewBundle");
        if (selectedImageUri == null) {
          break label624;
        }
        previewOriginalImage(selectedImageUri);
      }
    }
    for (;;)
    {
      cameraPhotoUri = ((Uri)paramBundle.getParcelable("CameraPhotoUri"));
      editorBar.setIconState(getShareType());
      return;
      paramView = null;
      break;
      label484:
      localObject = GhostImageUtils.getAnonymousPerson(2131492962);
      break label59;
      label494:
      paramView = localFragmentComponent.memberUtil();
      if ((meModel != null) && (meModel.publicContactInfo.twitterHandles != null)) {}
      for (paramView = meModel.publicContactInfo.twitterHandles;; paramView = Collections.emptyList())
      {
        twitterHandles = paramView;
        prefs = localFragmentComponent.flagshipSharedPreferences();
        shareVisibility = prefs.getPreferences().getInt("defaultShareVisibility", 1);
        if ((shareVisibility == 0) && (CollectionUtils.isEmpty(twitterHandles)))
        {
          shareVisibility = 1;
          prefs.setDefaultShareVisibility(shareVisibility);
        }
        ((ShareComposeEditorBar)localObject).setVisibilityForIndex(((ShareComposeEditorBar)localObject).getIndexForVisibility(shareVisibility));
        break;
      }
      label624:
      if (paramView != null)
      {
        currentUrlPreview = ((UrlPreviewData)RecordParceler.quietUnparcel(UrlPreviewData.BUILDER, "UrlPreviewData", paramView));
        if (currentUrlPreview != null) {
          previewUrl(currentUrlPreview, false);
        }
      }
    }
  }
  
  protected void onVisibilityButtonClick()
  {
    trackClickAndCustomEvent("change_visibility", ActionCategory.EXPAND, "expandShareVisibility");
    ShareComposeEditorBar localShareComposeEditorBar = editorBar;
    I18NManager localI18NManager = i18NManager;
    Object localObject = new ArrayList();
    ((List)localObject).add(localShareComposeEditorBar.getResources().getString(2131233687));
    if ((!CollectionUtils.isEmpty(twitterHandles)) && (localI18NManager != null)) {
      ((List)localObject).add(localI18NManager.getString(2131233688, new Object[] { twitterHandles.get(0)).name }));
    }
    ((List)localObject).add(localShareComposeEditorBar.getResources().getString(2131233685));
    int i = localShareComposeEditorBar.getIndexForVisibility(shareVisibility);
    localObject = (String[])((List)localObject).toArray(new String[((List)localObject).size()]);
    new android.support.v7.app.AlertDialog.Builder(localShareComposeEditorBar.getContext()).setTitle(2131233686).setSingleChoiceItems((CharSequence[])localObject, i, new ShareComposeEditorBar.1(localShareComposeEditorBar, localI18NManager)).show();
    updateTextCharacterCount(getResources(), i18NManager);
  }
  
  protected final void parseLink(CharSequence paramCharSequence)
  {
    paramCharSequence = LinkUtils.getWebLinks(paramCharSequence);
    if (paramCharSequence.size() > 0)
    {
      previewArticleUrl(get0url);
      textInput.removePasteListener(pasteListener);
      pasteListener = null;
    }
  }
  
  protected final void previewArticleUrl(String paramString)
  {
    Map localMap = Tracker.createPageInstanceHeader(getPageInstance());
    UrlPreviewGetter.get(localMap, paramString, new BaseShareComposeFragment.UrlPreviewListener(localMap, fragmentComponent, paramString, false), fragmentComponent.dataManager());
  }
  
  protected final void previewOriginalImage(Uri paramUri)
  {
    selectedImageUri = paramUri;
    currentUrlPreview = null;
    detailPreview.setVisibility(0);
    contentScrollView.setFillViewport(false);
    FragmentComponent localFragmentComponent = fragmentComponent;
    FeedComponentsViewPool localFeedComponentsViewPool = viewPool;
    ArrayList localArrayList = new ArrayList(1);
    FeedRichMediaViewModel localFeedRichMediaViewModel = new FeedRichMediaViewModel(new FeedRichMediaImageLayout(localFragmentComponent, false, false, false));
    ImageRequest.BusImageRequestListener localBusImageRequestListener = new ImageRequest.BusImageRequestListener(localFragmentComponent);
    paramUri = new ImageModel(paramUri);
    listener = localBusImageRequestListener;
    image = paramUri;
    ShareComposePreviewTransformer.safeAdd(localArrayList, localFeedRichMediaViewModel);
    paramUri = new FeedSingleUpdateViewModel(null, localFragmentComponent, localFeedComponentsViewPool, localArrayList, null);
    FeedBorderManager.applyBorders$2d7435b4(localFeedComponentsViewPool, paramUri);
    detailPreview.renderComponents(paramUri.getComponents(), viewPool, applicationComponent.mediaCenter());
    showClearPreviewButton(true);
    if (enableFyiMentions) {
      showMentionBar(2);
    }
  }
  
  protected final void previewUrl(UrlPreviewData paramUrlPreviewData)
  {
    previewUrl(paramUrlPreviewData, false);
  }
  
  protected final void previewUrl(UrlPreviewData paramUrlPreviewData, boolean paramBoolean)
  {
    currentUrlPreview = paramUrlPreviewData;
    selectedImageUri = null;
    detailPreview.setVisibility(0);
    contentScrollView.setFillViewport(false);
    FragmentComponent localFragmentComponent = fragmentComponent;
    FeedComponentsViewPool localFeedComponentsViewPool = viewPool;
    Object localObject1 = Util.safeGet(previewImages);
    int j = ((List)localObject1).size();
    int i = 0;
    Object localObject2;
    if (i < j)
    {
      localObject2 = (PreviewImage)((List)localObject1).get(i);
      if (localObject2 == null) {}
    }
    for (localObject1 = mediaProxyImage;; localObject1 = null)
    {
      ArrayList localArrayList = new ArrayList(2);
      if ((localObject1 != null) && (FeedRichMediaTransformer.shouldDisplayImageOfSize(localFragmentComponent, mediaProxyImageValue.originalWidth)))
      {
        localObject2 = new FeedRichMediaViewModel(new FeedRichMediaArticleLayout(localFragmentComponent, false, false));
        image = new ImageModel((Image)localObject1, 2130837812, Util.retrieveRumSessionId(localFragmentComponent));
        label162:
        ShareComposePreviewTransformer.safeAdd(localArrayList, localObject2);
        localObject2 = new FeedContentDetailViewModel(new FeedContentDetailArticleLayout(false, false, true));
        title = title;
        subtitle = source;
        if ((localObject1 != null) && (FeedContentDetailTransformer.shouldDisplayImageOfSize(localFragmentComponent, mediaProxyImageValue.originalWidth))) {
          image = new ImageModel((Image)localObject1, 2130837812, Util.retrieveRumSessionId(localFragmentComponent));
        }
        ShareComposePreviewTransformer.safeAdd(localArrayList, localObject2);
        paramUrlPreviewData = new FeedSingleUpdateViewModel(null, localFragmentComponent, localFeedComponentsViewPool, localArrayList, null);
        FeedBorderManager.applyBorders$2d7435b4(localFeedComponentsViewPool, paramUrlPreviewData);
        detailPreview.renderComponents(paramUrlPreviewData.getComponents(), viewPool, applicationComponent.mediaCenter());
        if (paramBoolean) {
          break label349;
        }
      }
      label349:
      for (paramBoolean = true;; paramBoolean = false)
      {
        showClearPreviewButton(paramBoolean);
        editorBar.setPostButtonEnabled(true);
        if (enableFyiMentions) {
          showMentionBar(1);
        }
        return;
        i += 1;
        break;
        localObject2 = null;
        break label162;
      }
    }
  }
  
  protected void setupMentions()
  {
    mentionsPresenter.bind(mentionsRecyclerView);
    textInput.setTokenizer(new MentionsWordTokenizer());
    textInput.setQueryTokenReceiver(mentionsPresenter);
    mentionsPresenter.mentionsResultListener = this;
    textInput.setSuggestionsVisibilityManager(this);
  }
  
  protected void setupTextInput()
  {
    textInput.setOnClickListener(new BaseShareComposeFragment.2(this));
    boolean bool = FeedLixHelper.isEnabled(Util.getAppComponent(getActivity()).lixManager(), Lix.SHARING_BOLD_HASHTAG);
    if (bool) {
      textInput.setText(textInput.getText(), TextView.BufferType.SPANNABLE);
    }
    textInput.addTextChangedListener(new BaseShareComposeFragment.3(this, bool));
    textInput.setOnEditTextImeBackListener(new BaseShareComposeFragment.4(this));
    mentionsPresenter.mentionWorkFlowId = mentionWorkFlowId;
    textInput.addMentionWatcher(mentionsPresenter);
  }
  
  public void showCharacterCountMessageForCount(Resources paramResources, I18NManager paramI18NManager, int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (editorBar.hasCharacterCountReached(paramInt)) {
      localObject1 = paramI18NManager.getString(2131233657, new Object[] { Integer.valueOf(paramInt - getMaximumCharacterCount(paramResources)) });
    }
    while (TextUtils.isEmpty((CharSequence)localObject1))
    {
      hideCharacterCountMessage();
      return;
      localObject1 = localObject2;
      if (editorBar.isSharedWithTwitter())
      {
        if ((paramInt > paramResources.getInteger(2131558496)) && (paramInt < paramResources.getInteger(2131558497))) {}
        for (paramInt = 1;; paramInt = 0)
        {
          localObject1 = localObject2;
          if (paramInt == 0) {
            break;
          }
          localObject1 = paramI18NManager.getString(2131233684, new Object[] { Integer.valueOf(paramResources.getInteger(2131558496)) });
          break;
        }
      }
    }
    characterCountMessage.setText((CharSequence)localObject1);
    characterCountMessageContainer.setVisibility(0);
  }
  
  protected final void showMentionBar(int paramInt)
  {
    attachmentType = paramInt;
    showMentionBarConnectorText(true);
    showMentionBarInputText(true);
    mentionBar.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432578));
    clearMentionBar.setRotation(0.0F);
    clearMentionBar.setDrawableTintColor(ContextCompat.getColor(getContext(), 2131623957));
    clearMentionBar.setVisibility(0);
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, 1.0F);
    localAlphaAnimation.setStartOffset(getResources().getInteger(2131558491));
    localAlphaAnimation.setDuration(getResources().getInteger(2131558490));
    clearMentionBar.startAnimation(localAlphaAnimation);
  }
  
  protected void trackClickAndCustomEvent(String paramString1, ActionCategory paramActionCategory, String paramString2)
  {
    trackButtonShortPress(paramString1);
  }
  
  final void updateTextCharacterCount(Resources paramResources, I18NManager paramI18NManager)
  {
    int i = computeCharacterCount();
    boolean bool = isValidShare(i);
    editorBar.updateTextCharacterCountAndPostButtonState(paramResources, paramI18NManager, i, bool);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.publishing.sharing.compose.BaseShareComposeFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */