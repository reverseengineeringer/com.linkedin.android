package com.linkedin.semaphore.models.android;

import com.linkedin.data.lite.RecordTemplate;
import java.util.Collections;
import java.util.List;

public final class Menu
  implements RecordTemplate<Menu>
{
  public static final MenuBuilder BUILDER = MenuBuilder.INSTANCE;
  private volatile int _cachedHashCode = -1;
  public final BlockConfirmationScreenText blockConfirmationScreen;
  public final DialogTrackingCodes dialogTrackingCodes;
  public final boolean hasBlockConfirmationScreen;
  public final boolean hasDialogTrackingCodes;
  public final boolean hasHeadings;
  public final boolean hasNumberOfSteps;
  public final boolean hasOptions;
  public final boolean hasResultScreen;
  public final HeadingsText headings;
  public final int numberOfSteps;
  public final List<Option> options;
  public final ResultScreenText resultScreen;
  
  Menu(int paramInt, List<Option> paramList, ResultScreenText paramResultScreenText, HeadingsText paramHeadingsText, BlockConfirmationScreenText paramBlockConfirmationScreenText, DialogTrackingCodes paramDialogTrackingCodes, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6)
  {
    numberOfSteps = paramInt;
    if (paramList == null) {}
    for (paramList = null;; paramList = Collections.unmodifiableList(paramList))
    {
      options = paramList;
      resultScreen = paramResultScreenText;
      headings = paramHeadingsText;
      blockConfirmationScreen = paramBlockConfirmationScreenText;
      dialogTrackingCodes = paramDialogTrackingCodes;
      hasNumberOfSteps = paramBoolean1;
      hasOptions = paramBoolean2;
      hasResultScreen = paramBoolean3;
      hasHeadings = paramBoolean4;
      hasBlockConfirmationScreen = paramBoolean5;
      hasDialogTrackingCodes = paramBoolean6;
      return;
    }
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
      paramObject = (Menu)paramObject;
      if (numberOfSteps != numberOfSteps) {
        return false;
      }
      if (options != null)
      {
        if (options.equals(options)) {}
      }
      else {
        while (options != null) {
          return false;
        }
      }
      if (resultScreen != null)
      {
        if (resultScreen.equals(resultScreen)) {}
      }
      else {
        while (resultScreen != null) {
          return false;
        }
      }
      if (headings != null)
      {
        if (headings.equals(headings)) {}
      }
      else {
        while (headings != null) {
          return false;
        }
      }
      if (blockConfirmationScreen != null)
      {
        if (blockConfirmationScreen.equals(blockConfirmationScreen)) {}
      }
      else {
        while (blockConfirmationScreen != null) {
          return false;
        }
      }
      if (dialogTrackingCodes == null) {
        break;
      }
    } while (dialogTrackingCodes.equals(dialogTrackingCodes));
    for (;;)
    {
      return false;
      if (dialogTrackingCodes == null) {
        break;
      }
    }
  }
  
  public final int hashCode()
  {
    int n = 0;
    if (_cachedHashCode > 0) {
      return _cachedHashCode;
    }
    int i1 = numberOfSteps;
    int i;
    int j;
    label53:
    int k;
    if (options != null)
    {
      i = options.hashCode();
      if (resultScreen == null) {
        break label146;
      }
      j = resultScreen.hashCode();
      if (headings == null) {
        break label151;
      }
      k = headings.hashCode();
      label68:
      if (blockConfirmationScreen == null) {
        break label156;
      }
    }
    label146:
    label151:
    label156:
    for (int m = blockConfirmationScreen.hashCode();; m = 0)
    {
      if (dialogTrackingCodes != null) {
        n = dialogTrackingCodes.hashCode();
      }
      i = (m + (k + (j + (i + (i1 + 527) * 31) * 31) * 31) * 31) * 31 + n;
      _cachedHashCode = i;
      return i;
      i = 0;
      break;
      j = 0;
      break label53;
      k = 0;
      break label68;
    }
  }
  
  public final String id()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.semaphore.models.android.Menu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */