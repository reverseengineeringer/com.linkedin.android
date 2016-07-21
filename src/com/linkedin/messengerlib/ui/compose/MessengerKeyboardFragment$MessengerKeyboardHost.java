package com.linkedin.messengerlib.ui.compose;

import android.text.Editable;
import com.linkedin.messengerlib.sticker.LocalSticker;

public abstract interface MessengerKeyboardFragment$MessengerKeyboardHost
{
  public abstract boolean composeMessage(String paramString);
  
  public abstract void onCameraButtonTapped();
  
  public abstract void onComposeTextChanged(Editable paramEditable);
  
  public abstract void onStickerPreview(LocalSticker paramLocalSticker);
  
  public abstract void onStickerSend(LocalSticker paramLocalSticker);
  
  public abstract void onStickerView(LocalSticker paramLocalSticker);
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.ui.compose.MessengerKeyboardFragment.MessengerKeyboardHost
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */