package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import com.google.android.gms.ads.internal.client.zzn;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzhb;

@zzhb
public final class zzo
  extends FrameLayout
  implements View.OnClickListener
{
  private final ImageButton zzEW;
  private final zzs zzEX;
  
  public zzo(Context paramContext, int paramInt, zzs paramzzs)
  {
    super(paramContext);
    zzEX = paramzzs;
    setOnClickListener(this);
    zzEW = new ImageButton(paramContext);
    zzEW.setImageResource(17301527);
    zzEW.setBackgroundColor(0);
    zzEW.setOnClickListener(this);
    zzEW.setPadding(0, 0, 0, 0);
    zzEW.setContentDescription("Interstitial close button");
    zzn.zzcS();
    paramInt = zza.zzb(paramContext, paramInt);
    addView(zzEW, new FrameLayout.LayoutParams(paramInt, paramInt, 17));
  }
  
  public final void onClick(View paramView)
  {
    if (zzEX != null) {
      zzEX.zzfm();
    }
  }
  
  public final void zza(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean2)
    {
      if (paramBoolean1)
      {
        zzEW.setVisibility(4);
        return;
      }
      zzEW.setVisibility(8);
      return;
    }
    zzEW.setVisibility(0);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.ads.internal.overlay.zzo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */