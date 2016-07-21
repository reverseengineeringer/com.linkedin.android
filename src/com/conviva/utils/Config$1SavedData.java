package com.conviva.utils;

import com.conviva.api.system.ICallbackInterface;

public final class Config$1SavedData
  implements ICallbackInterface
{
  public Config$1SavedData(Config paramConfig) {}
  
  public final void done(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this$0._logger.debug("save(): configuration successfully saved to local storage.");
      return;
    }
    this$0._logger.error("save(): error saving configuration to local storage: " + paramString);
  }
}

/* Location:
 * Qualified Name:     com.conviva.utils.Config.1SavedData
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */