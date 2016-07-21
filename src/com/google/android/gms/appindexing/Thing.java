package com.google.android.gms.appindexing;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

public class Thing
{
  public final Bundle zzUG;
  
  Thing(Bundle paramBundle)
  {
    zzUG = paramBundle;
  }
  
  public static class Builder
  {
    final Bundle zzUH = new Bundle();
    
    public Thing build()
    {
      return new Thing(zzUH);
    }
    
    public Builder put(String paramString, Thing paramThing)
    {
      zzx.zzz(paramString);
      if (paramThing != null) {
        zzUH.putParcelable(paramString, zzUG);
      }
      return this;
    }
    
    public Builder put(String paramString1, String paramString2)
    {
      zzx.zzz(paramString1);
      if (paramString2 != null) {
        zzUH.putString(paramString1, paramString2);
      }
      return this;
    }
    
    public Builder setName(String paramString)
    {
      zzx.zzz(paramString);
      put("name", paramString);
      return this;
    }
    
    public Builder setUrl(Uri paramUri)
    {
      zzx.zzz(paramUri);
      put("url", paramUri.toString());
      return this;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appindexing.Thing
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */