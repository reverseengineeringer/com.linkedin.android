package android.support.v7.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

final class CardView$1
  implements CardViewDelegate
{
  private Drawable mCardBackground;
  
  CardView$1(CardView paramCardView) {}
  
  public final Drawable getCardBackground()
  {
    return mCardBackground;
  }
  
  public final View getCardView()
  {
    return this$0;
  }
  
  public final boolean getPreventCornerOverlap()
  {
    return this$0.getPreventCornerOverlap();
  }
  
  public final boolean getUseCompatPadding()
  {
    return this$0.getUseCompatPadding();
  }
  
  public final void setCardBackground(Drawable paramDrawable)
  {
    mCardBackground = paramDrawable;
    this$0.setBackgroundDrawable(paramDrawable);
  }
  
  public final void setMinWidthHeightInternal(int paramInt1, int paramInt2)
  {
    if (paramInt1 > CardView.access$300(this$0)) {
      CardView.access$401(this$0, paramInt1);
    }
    if (paramInt2 > CardView.access$500(this$0)) {
      CardView.access$601(this$0, paramInt2);
    }
  }
  
  public final void setShadowPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    CardView.access$000(this$0).set(paramInt1, paramInt2, paramInt3, paramInt4);
    CardView.access$201(this$0, access$100this$0).left + paramInt1, access$100this$0).top + paramInt2, access$100this$0).right + paramInt3, access$100this$0).bottom + paramInt4);
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.CardView.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */