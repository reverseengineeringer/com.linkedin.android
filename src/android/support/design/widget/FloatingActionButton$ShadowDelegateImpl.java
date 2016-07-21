package android.support.design.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

class FloatingActionButton$ShadowDelegateImpl
  implements ShadowViewDelegate
{
  private FloatingActionButton$ShadowDelegateImpl(FloatingActionButton paramFloatingActionButton) {}
  
  public float getRadius()
  {
    return this$0.getSizeDimension() / 2.0F;
  }
  
  public boolean isCompatPaddingEnabled()
  {
    return FloatingActionButton.access$600(this$0);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    FloatingActionButton.access$501(this$0, paramDrawable);
  }
  
  public void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    FloatingActionButton.access$200(this$0).set(paramInt1, paramInt2, paramInt3, paramInt4);
    this$0.setPadding(FloatingActionButton.access$400(this$0) + paramInt1, FloatingActionButton.access$400(this$0) + paramInt2, FloatingActionButton.access$400(this$0) + paramInt3, FloatingActionButton.access$400(this$0) + paramInt4);
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.FloatingActionButton.ShadowDelegateImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */