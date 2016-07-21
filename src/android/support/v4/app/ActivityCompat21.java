package android.support.v4.app;

import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

final class ActivityCompat21
{
  static SharedElementCallback createCallback(SharedElementCallback21 paramSharedElementCallback21)
  {
    SharedElementCallbackImpl localSharedElementCallbackImpl = null;
    if (paramSharedElementCallback21 != null) {
      localSharedElementCallbackImpl = new SharedElementCallbackImpl(paramSharedElementCallback21);
    }
    return localSharedElementCallbackImpl;
  }
  
  public static abstract class SharedElementCallback21
  {
    public abstract Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF);
    
    public abstract View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable);
    
    public abstract void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2);
  }
  
  private static final class SharedElementCallbackImpl
    extends SharedElementCallback
  {
    private ActivityCompat21.SharedElementCallback21 mCallback;
    
    public SharedElementCallbackImpl(ActivityCompat21.SharedElementCallback21 paramSharedElementCallback21)
    {
      mCallback = paramSharedElementCallback21;
    }
    
    public final Parcelable onCaptureSharedElementSnapshot(View paramView, Matrix paramMatrix, RectF paramRectF)
    {
      return mCallback.onCaptureSharedElementSnapshot(paramView, paramMatrix, paramRectF);
    }
    
    public final View onCreateSnapshotView(Context paramContext, Parcelable paramParcelable)
    {
      return mCallback.onCreateSnapshotView(paramContext, paramParcelable);
    }
    
    public final void onMapSharedElements(List<String> paramList, Map<String, View> paramMap) {}
    
    public final void onRejectSharedElements(List<View> paramList) {}
    
    public final void onSharedElementEnd(List<String> paramList, List<View> paramList1, List<View> paramList2) {}
    
    public final void onSharedElementStart(List<String> paramList, List<View> paramList1, List<View> paramList2)
    {
      mCallback.onSharedElementStart(paramList, paramList1, paramList2);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.ActivityCompat21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */