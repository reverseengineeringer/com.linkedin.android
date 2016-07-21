package android.support.v4.app;

import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Log;

public final class RemoteInput
  extends RemoteInputCompatBase.RemoteInput
{
  public static final RemoteInputCompatBase.RemoteInput.Factory FACTORY;
  private static final Impl IMPL;
  private final boolean mAllowFreeFormInput;
  private final CharSequence[] mChoices;
  private final Bundle mExtras;
  private final CharSequence mLabel;
  private final String mResultKey;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 20) {
      IMPL = new ImplApi20();
    }
    for (;;)
    {
      FACTORY = new RemoteInputCompatBase.RemoteInput.Factory() {};
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        IMPL = new ImplJellybean();
      } else {
        IMPL = new ImplBase();
      }
    }
  }
  
  private RemoteInput(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    mResultKey = paramString;
    mLabel = paramCharSequence;
    mChoices = paramArrayOfCharSequence;
    mAllowFreeFormInput = paramBoolean;
    mExtras = paramBundle;
  }
  
  public static Bundle getResultsFromIntent(Intent paramIntent)
  {
    return IMPL.getResultsFromIntent(paramIntent);
  }
  
  public final boolean getAllowFreeFormInput()
  {
    return mAllowFreeFormInput;
  }
  
  public final CharSequence[] getChoices()
  {
    return mChoices;
  }
  
  public final Bundle getExtras()
  {
    return mExtras;
  }
  
  public final CharSequence getLabel()
  {
    return mLabel;
  }
  
  public final String getResultKey()
  {
    return mResultKey;
  }
  
  public static final class Builder
  {
    public boolean mAllowFreeFormInput = true;
    public CharSequence[] mChoices;
    public Bundle mExtras = new Bundle();
    public CharSequence mLabel;
    public final String mResultKey;
    
    public Builder(String paramString)
    {
      mResultKey = paramString;
    }
  }
  
  static abstract interface Impl
  {
    public abstract Bundle getResultsFromIntent(Intent paramIntent);
  }
  
  static final class ImplApi20
    implements RemoteInput.Impl
  {
    public final Bundle getResultsFromIntent(Intent paramIntent)
    {
      return android.app.RemoteInput.getResultsFromIntent(paramIntent);
    }
  }
  
  static final class ImplBase
    implements RemoteInput.Impl
  {
    public final Bundle getResultsFromIntent(Intent paramIntent)
    {
      Log.w("RemoteInput", "RemoteInput is only supported from API Level 16");
      return null;
    }
  }
  
  static final class ImplJellybean
    implements RemoteInput.Impl
  {
    public final Bundle getResultsFromIntent(Intent paramIntent)
    {
      paramIntent = paramIntent.getClipData();
      if (paramIntent != null)
      {
        ClipDescription localClipDescription = paramIntent.getDescription();
        if ((localClipDescription.hasMimeType("text/vnd.android.intent")) && (localClipDescription.getLabel().equals("android.remoteinput.results"))) {
          return (Bundle)paramIntent.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
        }
      }
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.RemoteInput
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */