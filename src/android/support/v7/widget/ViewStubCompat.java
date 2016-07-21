package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.appcompat.R.styleable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.lang.ref.WeakReference;

public final class ViewStubCompat
  extends View
{
  private OnInflateListener mInflateListener;
  private int mInflatedId;
  private WeakReference<View> mInflatedViewRef;
  private LayoutInflater mInflater;
  private int mLayoutResource = 0;
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ViewStubCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViewStubCompat, paramInt, 0);
    mInflatedId = paramContext.getResourceId(R.styleable.ViewStubCompat_android_inflatedId, -1);
    mLayoutResource = paramContext.getResourceId(R.styleable.ViewStubCompat_android_layout, 0);
    setId(paramContext.getResourceId(R.styleable.ViewStubCompat_android_id, -1));
    paramContext.recycle();
    setVisibility(8);
    setWillNotDraw(true);
  }
  
  protected final void dispatchDraw(Canvas paramCanvas) {}
  
  public final void draw(Canvas paramCanvas) {}
  
  public final int getInflatedId()
  {
    return mInflatedId;
  }
  
  public final LayoutInflater getLayoutInflater()
  {
    return mInflater;
  }
  
  public final int getLayoutResource()
  {
    return mLayoutResource;
  }
  
  public final View inflate()
  {
    Object localObject = getParent();
    if ((localObject != null) && ((localObject instanceof ViewGroup)))
    {
      if (mLayoutResource != 0)
      {
        ViewGroup localViewGroup = (ViewGroup)localObject;
        int i;
        if (mInflater != null)
        {
          localObject = mInflater;
          localObject = ((LayoutInflater)localObject).inflate(mLayoutResource, localViewGroup, false);
          if (mInflatedId != -1) {
            ((View)localObject).setId(mInflatedId);
          }
          i = localViewGroup.indexOfChild(this);
          localViewGroup.removeViewInLayout(this);
          ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
          if (localLayoutParams == null) {
            break label122;
          }
          localViewGroup.addView((View)localObject, i, localLayoutParams);
        }
        for (;;)
        {
          mInflatedViewRef = new WeakReference(localObject);
          return (View)localObject;
          localObject = LayoutInflater.from(getContext());
          break;
          label122:
          localViewGroup.addView((View)localObject, i);
        }
      }
      throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
    }
    throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(0, 0);
  }
  
  public final void setInflatedId(int paramInt)
  {
    mInflatedId = paramInt;
  }
  
  public final void setLayoutInflater(LayoutInflater paramLayoutInflater)
  {
    mInflater = paramLayoutInflater;
  }
  
  public final void setLayoutResource(int paramInt)
  {
    mLayoutResource = paramInt;
  }
  
  public final void setOnInflateListener(OnInflateListener paramOnInflateListener)
  {
    mInflateListener = paramOnInflateListener;
  }
  
  public final void setVisibility(int paramInt)
  {
    if (mInflatedViewRef != null)
    {
      View localView = (View)mInflatedViewRef.get();
      if (localView != null) {
        localView.setVisibility(paramInt);
      }
    }
    do
    {
      return;
      throw new IllegalStateException("setVisibility called on un-referenced view");
      super.setVisibility(paramInt);
    } while ((paramInt != 0) && (paramInt != 4));
    inflate();
  }
  
  public static abstract interface OnInflateListener {}
}

/* Location:
 * Qualified Name:     android.support.v7.widget.ViewStubCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */