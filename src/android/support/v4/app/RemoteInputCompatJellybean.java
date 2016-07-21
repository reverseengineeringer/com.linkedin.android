package android.support.v4.app;

import android.os.Bundle;

final class RemoteInputCompatJellybean
{
  static Bundle[] toBundleArray(RemoteInputCompatBase.RemoteInput[] paramArrayOfRemoteInput)
  {
    Object localObject;
    if (paramArrayOfRemoteInput == null)
    {
      localObject = null;
      return (Bundle[])localObject;
    }
    Bundle[] arrayOfBundle = new Bundle[paramArrayOfRemoteInput.length];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfBundle;
      if (i >= paramArrayOfRemoteInput.length) {
        break;
      }
      localObject = paramArrayOfRemoteInput[i];
      Bundle localBundle = new Bundle();
      localBundle.putString("resultKey", ((RemoteInputCompatBase.RemoteInput)localObject).getResultKey());
      localBundle.putCharSequence("label", ((RemoteInputCompatBase.RemoteInput)localObject).getLabel());
      localBundle.putCharSequenceArray("choices", ((RemoteInputCompatBase.RemoteInput)localObject).getChoices());
      localBundle.putBoolean("allowFreeFormInput", ((RemoteInputCompatBase.RemoteInput)localObject).getAllowFreeFormInput());
      localBundle.putBundle("extras", ((RemoteInputCompatBase.RemoteInput)localObject).getExtras());
      arrayOfBundle[i] = localBundle;
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.RemoteInputCompatJellybean
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */