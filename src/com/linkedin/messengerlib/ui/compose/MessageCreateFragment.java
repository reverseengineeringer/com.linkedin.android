package com.linkedin.messengerlib.ui.compose;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.File;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.messengerlib.MessengerLibApi;
import com.linkedin.messengerlib.MessengerLixManager;
import com.linkedin.messengerlib.R.string;
import com.linkedin.messengerlib.attachment.AttachmentFactory;
import com.linkedin.messengerlib.attachment.AttachmentFileType;
import com.linkedin.messengerlib.attachment.AttachmentUploadState;
import com.linkedin.messengerlib.attachment.PendingAttachment;
import com.linkedin.messengerlib.camera.ImageUtils;
import com.linkedin.messengerlib.database.MessengerProvider;
import com.linkedin.messengerlib.downloads.MessengerFileTransferManager;
import com.linkedin.messengerlib.downloads.MessengerFileTransferManager.OnUploadFinishedListener;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.shared.BaseFragment.BaseFragmentApi;
import com.linkedin.messengerlib.shared.FragmentComponent;
import com.linkedin.messengerlib.shared.MessengerTrackableInterface;
import com.linkedin.messengerlib.shared.StickerUtils.DownloadStickerPackParams;
import com.linkedin.messengerlib.shared.StickerUtils.DownloadStickerPackTask;
import com.linkedin.messengerlib.sticker.DefaultStickerPacks;
import com.linkedin.messengerlib.sticker.LocalSticker;
import com.linkedin.messengerlib.tracking.MessengerTrackingUtils;
import com.linkedin.messengerlib.ui.dialogs.AlertDialogFragment;
import com.linkedin.messengerlib.ui.dialogs.SendImageApprovalDialogFragment;
import com.linkedin.messengerlib.ui.messagelist.MessageListKeyboardManager;
import com.linkedin.messengerlib.ui.messagelist.StickerTrayAdapter;
import com.linkedin.messengerlib.ui.messagelist.StickerTrayFragment.OnStickerActionListener;
import com.linkedin.messengerlib.ui.messagelist.StickerTraySlidingTabLayout;
import com.linkedin.messengerlib.ui.messagelist.StickerTrayView;
import com.linkedin.messengerlib.utils.BackPressListener;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.SoftKeyboardStateHelper;
import java.util.Map;
import java.util.UUID;

public abstract class MessageCreateFragment
  extends BaseFragment
  implements BaseFragment.BaseFragmentApi, MessengerTrackableInterface, BackPressListener
{
  private static final String TAG = MessageCreateFragment.class.getCanonicalName();
  public final MessengerFileTransferManager fileTransferManager = new MessengerFileTransferManager(this);
  private boolean hasConfirmedMessageDelete;
  MessageListKeyboardManager messageListKeyboardManager;
  public MessageCreateFragment.OnCameraClickListener onCameraClickListener;
  public final PendingAttachment pendingAttachment = new PendingAttachment();
  public Uri pendingPhotoPath;
  private ContentObserver stickerPacksContentObserver;
  
  private void approveImage()
  {
    pendingAttachment.isApproved = true;
    onSendAttachmentApproved(AttachmentFactory.newAttachment(pendingAttachment), pendingAttachment);
  }
  
  private void persistFilePermissions(Uri paramUri, Intent paramIntent)
  {
    int i;
    if ((Build.VERSION.SDK_INT >= 19) && (paramIntent != null)) {
      i = paramIntent.getFlags();
    }
    try
    {
      getActivity().getContentResolver().takePersistableUriPermission(paramUri, i & 0x3);
      return;
    }
    catch (SecurityException paramIntent)
    {
      Log.w(TAG, "Could not persist permission grants for " + paramUri);
    }
  }
  
  private void updatePhotoFromPhotoCaptureManager(Uri paramUri)
  {
    if (getActivity() == null) {
      return;
    }
    MessengerTrackingUtils.sendEvent(getTracker(), "image_upload", ControlType.PICKER, InteractionType.SHORT_PRESS);
    pendingAttachment.clear();
    pendingAttachment.uri = paramUri;
    pendingAttachment.updateMediaType(getActivity());
    pendingAttachment.uploadState = AttachmentUploadState.PENDING;
  }
  
  public final StickerTrayFragment.OnStickerActionListener buildOnStickerActionListener()
  {
    return new MessageCreateFragment.6(this);
  }
  
  public final MessageCreateFragment.OnCameraClickListener getOnCameraClickListener()
  {
    if (onCameraClickListener == null) {
      onCameraClickListener = new MessageCreateFragment.DefaultOnCameraClickListener(this);
    }
    return onCameraClickListener;
  }
  
  public final Tracker getParentFragmentTracker()
  {
    return getTracker();
  }
  
  public abstract EditText getRecipientsView();
  
  public abstract ImageButton getStickerButton();
  
  public abstract boolean handleOnBackPressed();
  
  public abstract boolean hasRecipients();
  
  public final boolean isStickerKeyboardShown()
  {
    if (messageListKeyboardManager != null) {
      return messageListKeyboardManager.isStickerKeyboardShown();
    }
    return false;
  }
  
  @Deprecated
  public final View.OnClickListener newCameraButtonOnClickListener()
  {
    return new MessageCreateFragment.2(this, getTracker(), "image_select", new TrackingEventBuilder[0]);
  }
  
  public final View.OnClickListener newOnStickerButtonClickListener()
  {
    return new MessageCreateFragment.3(this, getTracker(), "sticker_keyboard", new TrackingEventBuilder[0]);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Uri localUri = null;
    if ((paramInt2 == -1) && (paramInt1 == 1001)) {
      if (pendingPhotoPath != null)
      {
        MessengerTrackingUtils.sendButtonShortPressEvent(getTracker(), "take_photo");
        trackAttachAction("take_photo");
        persistFilePermissions(pendingPhotoPath, paramIntent);
        updatePhotoFromPhotoCaptureManager(pendingPhotoPath);
        pendingPhotoPath = null;
      }
    }
    for (;;)
    {
      return;
      if ((paramInt2 != -1) || (paramInt1 != 1002)) {
        break;
      }
      if (paramIntent == null) {}
      while (localUri != null)
      {
        MessengerTrackingUtils.sendButtonShortPressEvent(getTracker(), "select_photo");
        trackAttachAction("select_photo");
        persistFilePermissions(localUri, paramIntent);
        updatePhotoFromPhotoCaptureManager(localUri);
        return;
        localUri = paramIntent.getData();
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (stickerPacksContentObserver == null) {
      stickerPacksContentObserver = new MessageCreateFragment.1(this, new Handler());
    }
    paramActivity.getContentResolver().registerContentObserver(MessengerProvider.STICKER_PACKS_URI, true, stickerPacksContentObserver);
  }
  
  public final boolean onBackPressed()
  {
    if ((messageListKeyboardManager != null) && (messageListKeyboardManager.isStickerKeyboardShown()))
    {
      messageListKeyboardManager.hideStickerKeyboard();
      return true;
    }
    if ((shouldShowDeleteWarningOnBack()) && (!hasConfirmedMessageDelete))
    {
      showDialog(AlertDialogFragment.newInstance$3ae4fc0d(fragmentComponent.i18NManager.getString(R.string.messenger_delete_message_dialog_title), fragmentComponent.i18NManager.getString(R.string.messenger_delete_message_dialog_message), fragmentComponent.i18NManager.getString(R.string.messenger_delete_message_dialog_positive_button), new MessageCreateFragment.8(this), fragmentComponent.i18NManager.getString(R.string.messenger_delete_message_dialog_negative_button)), "delete_message");
      return true;
    }
    if (shouldShowPendingMessagesWarningOnBack())
    {
      showDialog(AlertDialogFragment.newInstance$3ae4fc0d(fragmentComponent.i18NManager.getString(R.string.messenger_pending_message_dialog_title), fragmentComponent.i18NManager.getString(R.string.messenger_pending_message_dialog_message), fragmentComponent.i18NManager.getString(R.string.messenger_pending_message_dialog_positive_button), new MessageCreateFragment.9(this), fragmentComponent.i18NManager.getString(R.string.messenger_pending_message_dialog_negative_button)), "confirm_exit_with_pending_messages");
      return true;
    }
    return handleOnBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Object localObject = getMessengerLibApi().getInstalledStickerPackIds();
    paramBundle = (Bundle)localObject;
    if (localObject.length == 0) {
      paramBundle = DefaultStickerPacks.getDefaultStickerPacks();
    }
    int j = paramBundle.length;
    int i = 0;
    while (i < j)
    {
      localObject = new StickerUtils.DownloadStickerPackParams(paramBundle[i]);
      new StickerUtils.DownloadStickerPackTask(fragmentComponent).execute(new StickerUtils.DownloadStickerPackParams[] { localObject });
      i += 1;
    }
  }
  
  public void onDestroy()
  {
    if (messageListKeyboardManager != null)
    {
      Object localObject = messageListKeyboardManager;
      stickerTrayAdapter.closeCursor();
      localObject = stickerKeyboard.tabLayout;
      if ((viewPager != null) && (viewPager.getAdapter() != null)) {
        viewPager.getAdapter().unregisterDataSetObserver(dataSetObserver);
      }
      messageListKeyboardManager = null;
    }
    super.onDestroy();
  }
  
  public void onDetach()
  {
    if ((getActivity() != null) && (stickerPacksContentObserver != null))
    {
      getActivity().getContentResolver().unregisterContentObserver(stickerPacksContentObserver);
      stickerPacksContentObserver = null;
    }
    super.onDetach();
  }
  
  public void onResume()
  {
    super.onResume();
    if (isDetached()) {}
    while ((pendingAttachment.uploadState != AttachmentUploadState.PENDING) || (pendingAttachment.isApproved)) {
      return;
    }
    showDialog(SendImageApprovalDialogFragment.newInstance(pendingAttachment.uri.toString()), "send_image");
  }
  
  public abstract void onSendAttachmentApproved(File paramFile, PendingAttachment paramPendingAttachment);
  
  public final void onSendImageAction(ManagedBitmap paramManagedBitmap)
  {
    if (pendingAttachment.uri == null) {
      return;
    }
    if (supportsMessageQueue())
    {
      localAttachmentFileType = AttachmentFileType.getFileType(pendingAttachment.mediaType);
      localMessengerLixManager = getLixManager();
      MessengerLibApi localMessengerLibApi = getMessengerLibApi();
      if ((localMessengerLixManager != null) && (localMessengerLibApi != null) && (localMessengerLixManager.isImageAttachmentCompressionEnabled()) && (localAttachmentFileType != AttachmentFileType.GIF) && (paramManagedBitmap != null))
      {
        localMessengerLibApi.compressImage(ImageUtils.copy(paramManagedBitmap.getBitmap()), new MessageCreateFragment.7(this));
        return;
      }
      approveImage();
      return;
    }
    AttachmentFileType localAttachmentFileType = AttachmentFileType.getFileType(pendingAttachment.mediaType);
    MessengerLixManager localMessengerLixManager = getLixManager();
    if ((localMessengerLixManager != null) && (localMessengerLixManager.isImageAttachmentCompressionEnabled()) && (localAttachmentFileType != AttachmentFileType.GIF) && (paramManagedBitmap != null))
    {
      paramManagedBitmap = ImageUtils.copy(paramManagedBitmap.getBitmap());
      getMessengerLibApi().compressImage(paramManagedBitmap, new MessageCreateFragment.4(this));
    }
    for (;;)
    {
      pendingAttachment.isApproved = true;
      onSendAttachmentApproved(AttachmentFactory.newAttachment(pendingAttachment), pendingAttachment);
      return;
      uploadPhoto(pendingAttachment.uri, null);
    }
  }
  
  public abstract void onSendStickerApproved(LocalSticker paramLocalSticker);
  
  public abstract void onUploadAttachmentFailure(File paramFile, boolean paramBoolean);
  
  public abstract void onUploadAttachmentSuccess(File paramFile, boolean paramBoolean);
  
  public abstract void refreshStickersFromCursor();
  
  public final void setupStickerKeyboard(View paramView, StickerTrayView paramStickerTrayView, EditText paramEditText)
  {
    FragmentActivity localFragmentActivity = getActivity();
    MessengerLixManager localMessengerLixManager = getLixManager();
    if ((localMessengerLixManager != null) && (localMessengerLixManager.isStickerManagerEnabled())) {}
    for (boolean bool = true;; bool = false)
    {
      paramStickerTrayView.setStickerTabVisible(bool);
      messageListKeyboardManager = new MessageListKeyboardManager(localFragmentActivity, getFragmentManager(), paramStickerTrayView, paramEditText, getRecipientsView(), getStickerButton(), new SoftKeyboardStateHelper(paramView, getActivity()), buildOnStickerActionListener(), fragmentComponent);
      messageListKeyboardManager.refreshRecentStickersFromCursor();
      messageListKeyboardManager.refreshStickerPacksFromCursor();
      return;
    }
  }
  
  public abstract boolean shouldShowDeleteWarningOnBack();
  
  public abstract boolean shouldShowPendingMessagesWarningOnBack();
  
  public final void showDialog(DialogFragment paramDialogFragment, String paramString)
  {
    if ((getMessengerLibApi() == null) || (!getMessengerLibApi().isSafeToExecuteTransaction())) {
      return;
    }
    FragmentTransaction localFragmentTransaction = getFragmentManager().beginTransaction();
    Fragment localFragment = getFragmentManager().findFragmentByTag(paramString);
    if (localFragment != null) {
      localFragmentTransaction.remove(localFragment);
    }
    localFragmentTransaction.addToBackStack(null);
    paramDialogFragment.show(localFragmentTransaction, paramString);
  }
  
  public abstract boolean supportsMessageQueue();
  
  public abstract void trackAttachAction(String paramString);
  
  public abstract void trackStickerAction(LocalSticker paramLocalSticker);
  
  public abstract void trackStickerImpression(LocalSticker paramLocalSticker);
  
  protected final void updateStickerKeyboardRecipients(boolean paramBoolean)
  {
    Object localObject;
    StickerTrayView localStickerTrayView;
    if (messageListKeyboardManager != null)
    {
      localObject = messageListKeyboardManager;
      localStickerTrayView = stickerKeyboard;
      localObject = fragmentComponent.i18NManager;
      if (!paramBoolean) {
        break label59;
      }
    }
    label59:
    for (int i = R.string.messenger_sticker_preview_send;; i = R.string.messenger_sticker_preview_choose_recipient)
    {
      stickerPreviewAction.setText(((I18NManager)localObject).getString(i));
      stickerPreviewImageContainer.setEnabled(paramBoolean);
      return;
    }
  }
  
  public final void uploadPhoto(Uri paramUri, MessengerFileTransferManager.OnUploadFinishedListener paramOnUploadFinishedListener)
  {
    if (getMessengerLibApi() == null) {
      return;
    }
    MessengerFileTransferManager localMessengerFileTransferManager = fileTransferManager;
    MessengerLibApi localMessengerLibApi = getMessengerLibApi();
    paramOnUploadFinishedListener = new MessageCreateFragment.5(this, paramOnUploadFinishedListener);
    String str = "MESSENGER_" + UUID.randomUUID().toString();
    localMessengerLibApi.uploadPhoto(str, paramUri);
    uploadListeners.put(str, paramOnUploadFinishedListener);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.compose.MessageCreateFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */