package com.linkedin.android.infra.ui.lightbox;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import butterknife.InjectView;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.Util;

@Deprecated
public abstract class LightboxFragment
  extends PageFragment
  implements OnBackPressedListener, LightboxLayout.LightboxAdapter
{
  private boolean downGestureEnabled = true;
  private float gestureCompletionThreshold;
  private LightboxListener lightboxListener;
  @InjectView(2131755468)
  protected Toolbar toolbar;
  private boolean upGestureEnabled = true;
  
  public abstract LightboxLayout getLightboxLayout();
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof LightboxListener))
    {
      lightboxListener = ((LightboxListener)paramActivity);
      return;
    }
    lightboxListener = null;
    Util.safeThrow(new RuntimeException("Activity containing a LightboxFragment does not implement LightboxListener"));
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    getLightboxLayout().setAdapter(this);
    toolbar.setNavigationOnClickListener(new LightboxFragment.1(this));
    getLightboxLayout().getViewTreeObserver().addOnGlobalLayoutListener(new LightboxFragment.2(this));
  }
  
  public static abstract interface LightboxListener {}
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.ui.lightbox.LightboxFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */