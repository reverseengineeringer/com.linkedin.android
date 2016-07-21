package android.support.v7.app;

import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.support.v7.view.ActionMode.Callback;
import android.support.v7.widget.ActionBarContainer;
import android.view.View;

final class WindowDecorActionBar$1
  extends ViewPropertyAnimatorListenerAdapter
{
  WindowDecorActionBar$1(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public final void onAnimationEnd(View paramView)
  {
    if ((WindowDecorActionBar.access$000(this$0)) && (WindowDecorActionBar.access$100(this$0) != null))
    {
      ViewCompat.setTranslationY(WindowDecorActionBar.access$100(this$0), 0.0F);
      ViewCompat.setTranslationY(WindowDecorActionBar.access$200(this$0), 0.0F);
    }
    WindowDecorActionBar.access$200(this$0).setVisibility(8);
    WindowDecorActionBar.access$200(this$0).setTransitioning(false);
    WindowDecorActionBar.access$302$78e390dc(this$0);
    paramView = this$0;
    if (mDeferredModeDestroyCallback != null)
    {
      mDeferredModeDestroyCallback.onDestroyActionMode(mDeferredDestroyActionMode);
      mDeferredDestroyActionMode = null;
      mDeferredModeDestroyCallback = null;
    }
    if (WindowDecorActionBar.access$400(this$0) != null) {
      ViewCompat.requestApplyInsets(WindowDecorActionBar.access$400(this$0));
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.app.WindowDecorActionBar.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */