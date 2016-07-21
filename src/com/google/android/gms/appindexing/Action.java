package com.google.android.gms.appindexing;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;

public final class Action
  extends Thing
{
  private Action(Bundle paramBundle)
  {
    super(paramBundle);
  }
  
  public static final class Builder
    extends Thing.Builder
  {
    public Builder(String paramString)
    {
      zzx.zzz(paramString);
      super.put("type", paramString);
    }
    
    public final Action build()
    {
      zzx.zzb(zzUH.get("object"), "setObject is required before calling build().");
      zzx.zzb(zzUH.get("type"), "setType is required before calling build().");
      Bundle localBundle = (Bundle)zzUH.getParcelable("object");
      zzx.zzb(localBundle.get("name"), "Must call setObject() with a valid name. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
      zzx.zzb(localBundle.get("url"), "Must call setObject() with a valid app URI. Example: setObject(new Thing.Builder().setName(name).setUrl(url))");
      return new Action(zzUH, (byte)0);
    }
    
    public final Builder setActionStatus(String paramString)
    {
      zzx.zzz(paramString);
      return (Builder)super.put("actionStatus", paramString);
    }
    
    public final Builder setObject(Thing paramThing)
    {
      zzx.zzz(paramThing);
      return (Builder)super.put("object", paramThing);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.appindexing.Action
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */