package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.DataProcessor;
import com.linkedin.data.lite.DataProcessorException;
import com.linkedin.data.lite.RecordTemplate;

public final class DialogTrackingCodes
  implements RecordTemplate<DialogTrackingCodes>
{
  public static final DialogTrackingCodesBuilder BUILDER = DialogTrackingCodesBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final String blockProfileDialogCancel;
  public final String blockProfileDialogOpen;
  public final String dialogBackButton;
  public final String dialogCancel;
  public final String dialogClose;
  public final String dialogOpen;
  public final boolean hasBlockProfileDialogCancel;
  public final boolean hasBlockProfileDialogOpen;
  public final boolean hasDialogBackButton;
  public final boolean hasDialogCancel;
  public final boolean hasDialogClose;
  public final boolean hasDialogOpen;
  
  DialogTrackingCodes(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    dialogCancel = paramString1;
    dialogOpen = paramString2;
    dialogClose = paramString3;
    dialogBackButton = paramString4;
    blockProfileDialogOpen = paramString5;
    blockProfileDialogCancel = paramString6;
    hasDialogCancel = paramBoolean1;
    hasDialogOpen = paramBoolean2;
    hasDialogClose = paramBoolean3;
    hasDialogBackButton = paramBoolean4;
    hasBlockProfileDialogOpen = paramBoolean5;
    hasBlockProfileDialogCancel = paramBoolean6;
  }
  
  public final DialogTrackingCodes accept(DataProcessor paramDataProcessor)
    throws DataProcessorException
  {
    paramDataProcessor.startRecord();
    if (hasDialogCancel)
    {
      paramDataProcessor.startRecordField$505cff1c("dialogCancel");
      paramDataProcessor.processString(dialogCancel);
    }
    if (hasDialogOpen)
    {
      paramDataProcessor.startRecordField$505cff1c("dialogOpen");
      paramDataProcessor.processString(dialogOpen);
    }
    if (hasDialogClose)
    {
      paramDataProcessor.startRecordField$505cff1c("dialogClose");
      paramDataProcessor.processString(dialogClose);
    }
    if (hasDialogBackButton)
    {
      paramDataProcessor.startRecordField$505cff1c("dialogBackButton");
      paramDataProcessor.processString(dialogBackButton);
    }
    if (hasBlockProfileDialogOpen)
    {
      paramDataProcessor.startRecordField$505cff1c("blockProfileDialogOpen");
      paramDataProcessor.processString(blockProfileDialogOpen);
    }
    if (hasBlockProfileDialogCancel)
    {
      paramDataProcessor.startRecordField$505cff1c("blockProfileDialogCancel");
      paramDataProcessor.processString(blockProfileDialogCancel);
    }
    paramDataProcessor.endRecord();
    if (paramDataProcessor.shouldReturnProcessedTemplate()) {
      return new DialogTrackingCodes(dialogCancel, dialogOpen, dialogClose, dialogBackButton, blockProfileDialogOpen, blockProfileDialogCancel, hasDialogCancel, hasDialogOpen, hasDialogClose, hasDialogBackButton, hasBlockProfileDialogOpen, hasBlockProfileDialogCancel);
    }
    return null;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (DialogTrackingCodes)paramObject;
      if (dialogCancel != null)
      {
        if (dialogCancel.equals(dialogCancel)) {}
      }
      else {
        while (dialogCancel != null) {
          return false;
        }
      }
      if (dialogOpen != null)
      {
        if (dialogOpen.equals(dialogOpen)) {}
      }
      else {
        while (dialogOpen != null) {
          return false;
        }
      }
      if (dialogClose != null)
      {
        if (dialogClose.equals(dialogClose)) {}
      }
      else {
        while (dialogClose != null) {
          return false;
        }
      }
      if (dialogBackButton != null)
      {
        if (dialogBackButton.equals(dialogBackButton)) {}
      }
      else {
        while (dialogBackButton != null) {
          return false;
        }
      }
      if (blockProfileDialogOpen != null)
      {
        if (blockProfileDialogOpen.equals(blockProfileDialogOpen)) {}
      }
      else {
        while (blockProfileDialogOpen != null) {
          return false;
        }
      }
      if (blockProfileDialogCancel == null) {
        break;
      }
    } while (blockProfileDialogCancel.equals(blockProfileDialogCancel));
    for (;;)
    {
      return false;
      if (blockProfileDialogCancel == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int i1 = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i;
    int j;
    label45:
    int k;
    label60:
    int m;
    if (dialogCancel != null)
    {
      i = dialogCancel.hashCode();
      if (dialogOpen == null) {
        break label154;
      }
      j = dialogOpen.hashCode();
      if (dialogClose == null) {
        break label159;
      }
      k = dialogClose.hashCode();
      if (dialogBackButton == null) {
        break label164;
      }
      m = dialogBackButton.hashCode();
      label76:
      if (blockProfileDialogOpen == null) {
        break label170;
      }
    }
    label154:
    label159:
    label164:
    label170:
    for (int n = blockProfileDialogOpen.hashCode();; n = 0)
    {
      if (blockProfileDialogCancel != null) {
        i1 = blockProfileDialogCancel.hashCode();
      }
      i = (n + (m + (k + (j + (i + 527) * 31) * 31) * 31) * 31) * 31 + i1;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label45;
      k = 0;
      break label60;
      m = 0;
      break label76;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.DialogTrackingCodes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */