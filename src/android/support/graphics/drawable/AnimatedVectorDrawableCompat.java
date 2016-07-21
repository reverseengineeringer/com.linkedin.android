package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
public final class AnimatedVectorDrawableCompat
  extends VectorDrawableCommon
  implements Animatable
{
  private AnimatedVectorDrawableCompatState mAnimatedVectorState;
  private ArgbEvaluator mArgbEvaluator = null;
  private final Drawable.Callback mCallback = new Drawable.Callback()
  {
    public final void invalidateDrawable(Drawable paramAnonymousDrawable)
    {
      invalidateSelf();
    }
    
    public final void scheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable, long paramAnonymousLong)
    {
      scheduleSelf(paramAnonymousRunnable, paramAnonymousLong);
    }
    
    public final void unscheduleDrawable(Drawable paramAnonymousDrawable, Runnable paramAnonymousRunnable)
    {
      unscheduleSelf(paramAnonymousRunnable);
    }
  };
  private Context mContext;
  
  private AnimatedVectorDrawableCompat()
  {
    this(null, (byte)0);
  }
  
  private AnimatedVectorDrawableCompat(Context paramContext)
  {
    this(paramContext, (byte)0);
  }
  
  private AnimatedVectorDrawableCompat(Context paramContext, byte paramByte)
  {
    mContext = paramContext;
    mAnimatedVectorState = new AnimatedVectorDrawableCompatState();
  }
  
  public static AnimatedVectorDrawableCompat createFromXmlInner(Context paramContext, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    paramContext = new AnimatedVectorDrawableCompat(paramContext);
    paramContext.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
    return paramContext;
  }
  
  private boolean isStarted()
  {
    ArrayList localArrayList = mAnimatedVectorState.mAnimators;
    if (localArrayList == null) {
      return false;
    }
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private void setupColorAnimator(Animator paramAnimator)
  {
    Object localObject;
    if ((paramAnimator instanceof AnimatorSet))
    {
      localObject = ((AnimatorSet)paramAnimator).getChildAnimations();
      if (localObject != null)
      {
        int i = 0;
        while (i < ((List)localObject).size())
        {
          setupColorAnimator((Animator)((List)localObject).get(i));
          i += 1;
        }
      }
    }
    if ((paramAnimator instanceof ObjectAnimator))
    {
      paramAnimator = (ObjectAnimator)paramAnimator;
      localObject = paramAnimator.getPropertyName();
      if (("fillColor".equals(localObject)) || ("strokeColor".equals(localObject)))
      {
        if (mArgbEvaluator == null) {
          mArgbEvaluator = new ArgbEvaluator();
        }
        paramAnimator.setEvaluator(mArgbEvaluator);
      }
    }
  }
  
  public final void applyTheme(Resources.Theme paramTheme)
  {
    if (mDelegateDrawable != null) {
      DrawableCompat.applyTheme(mDelegateDrawable, paramTheme);
    }
  }
  
  public final boolean canApplyTheme()
  {
    if (mDelegateDrawable != null) {
      return DrawableCompat.canApplyTheme(mDelegateDrawable);
    }
    return false;
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (mDelegateDrawable != null) {
      mDelegateDrawable.draw(paramCanvas);
    }
    do
    {
      return;
      mAnimatedVectorState.mVectorDrawable.draw(paramCanvas);
    } while (!isStarted());
    invalidateSelf();
  }
  
  public final int getAlpha()
  {
    if (mDelegateDrawable != null) {
      return DrawableCompat.getAlpha(mDelegateDrawable);
    }
    return mAnimatedVectorState.mVectorDrawable.getAlpha();
  }
  
  public final int getChangingConfigurations()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getChangingConfigurations();
    }
    return super.getChangingConfigurations() | mAnimatedVectorState.mChangingConfigurations;
  }
  
  public final Drawable.ConstantState getConstantState()
  {
    if (mDelegateDrawable != null) {
      return new AnimatedVectorDrawableDelegateState(mDelegateDrawable.getConstantState());
    }
    return null;
  }
  
  public final int getIntrinsicHeight()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getIntrinsicHeight();
    }
    return mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
  }
  
  public final int getIntrinsicWidth()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getIntrinsicWidth();
    }
    return mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
  }
  
  public final int getOpacity()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.getOpacity();
    }
    return mAnimatedVectorState.mVectorDrawable.getOpacity();
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet)
    throws XmlPullParserException, IOException
  {
    inflate(paramResources, paramXmlPullParser, paramAttributeSet, null);
  }
  
  public final void inflate(Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (mDelegateDrawable != null)
    {
      DrawableCompat.inflate(mDelegateDrawable, paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    int i = paramXmlPullParser.getEventType();
    label28:
    Object localObject1;
    label77:
    Object localObject2;
    if (i != 1) {
      if (i == 2)
      {
        localObject1 = paramXmlPullParser.getName();
        if (!"animated-vector".equals(localObject1)) {
          break label177;
        }
        localObject1 = AndroidResources.styleable_AnimatedVectorDrawable;
        if (paramTheme != null) {
          break label162;
        }
        localObject1 = paramResources.obtainAttributes(paramAttributeSet, (int[])localObject1);
        i = ((TypedArray)localObject1).getResourceId(0, 0);
        if (i != 0)
        {
          localObject2 = VectorDrawableCompat.create(paramResources, i, paramTheme);
          mAllowCaching = false;
          ((VectorDrawableCompat)localObject2).setCallback(mCallback);
          if (mAnimatedVectorState.mVectorDrawable != null) {
            mAnimatedVectorState.mVectorDrawable.setCallback(null);
          }
          mAnimatedVectorState.mVectorDrawable = ((VectorDrawableCompat)localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    }
    for (;;)
    {
      i = paramXmlPullParser.next();
      break label28;
      break;
      label162:
      localObject1 = paramTheme.obtainStyledAttributes(paramAttributeSet, (int[])localObject1, 0, 0);
      break label77;
      label177:
      if ("target".equals(localObject1))
      {
        localObject1 = paramResources.obtainAttributes(paramAttributeSet, AndroidResources.styleable_AnimatedVectorDrawableTarget);
        localObject2 = ((TypedArray)localObject1).getString(0);
        i = ((TypedArray)localObject1).getResourceId(1, 0);
        if (i != 0)
        {
          if (mContext == null) {
            break label352;
          }
          Animator localAnimator = AnimatorInflater.loadAnimator(mContext, i);
          localAnimator.setTarget(mAnimatedVectorState.mVectorDrawable.mVectorState.mVPathRenderer.mVGTargetsMap.get(localObject2));
          if (Build.VERSION.SDK_INT < 21) {
            setupColorAnimator(localAnimator);
          }
          if (mAnimatedVectorState.mAnimators == null)
          {
            mAnimatedVectorState.mAnimators = new ArrayList();
            mAnimatedVectorState.mTargetNameMap = new ArrayMap();
          }
          mAnimatedVectorState.mAnimators.add(localAnimator);
          mAnimatedVectorState.mTargetNameMap.put(localAnimator, localObject2);
        }
        ((TypedArray)localObject1).recycle();
      }
    }
    label352:
    throw new IllegalStateException("Context can't be null when inflating animators");
  }
  
  public final boolean isRunning()
  {
    if (mDelegateDrawable != null) {
      return ((AnimatedVectorDrawable)mDelegateDrawable).isRunning();
    }
    ArrayList localArrayList = mAnimatedVectorState.mAnimators;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      if (((Animator)localArrayList.get(i)).isRunning()) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public final boolean isStateful()
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.isStateful();
    }
    return mAnimatedVectorState.mVectorDrawable.isStateful();
  }
  
  public final Drawable mutate()
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.mutate();
      return this;
    }
    throw new IllegalStateException("Mutate() is not supported for older platform");
  }
  
  protected final void onBoundsChange(Rect paramRect)
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.setBounds(paramRect);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setBounds(paramRect);
  }
  
  protected final boolean onLevelChange(int paramInt)
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.setLevel(paramInt);
    }
    return mAnimatedVectorState.mVectorDrawable.setLevel(paramInt);
  }
  
  protected final boolean onStateChange(int[] paramArrayOfInt)
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.setState(paramArrayOfInt);
    }
    return mAnimatedVectorState.mVectorDrawable.setState(paramArrayOfInt);
  }
  
  public final void setAlpha(int paramInt)
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.setAlpha(paramInt);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setAlpha(paramInt);
  }
  
  public final void setColorFilter(ColorFilter paramColorFilter)
  {
    if (mDelegateDrawable != null)
    {
      mDelegateDrawable.setColorFilter(paramColorFilter);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setColorFilter(paramColorFilter);
  }
  
  public final void setTint(int paramInt)
  {
    if (mDelegateDrawable != null)
    {
      DrawableCompat.setTint(mDelegateDrawable, paramInt);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setTint(paramInt);
  }
  
  public final void setTintList(ColorStateList paramColorStateList)
  {
    if (mDelegateDrawable != null)
    {
      DrawableCompat.setTintList(mDelegateDrawable, paramColorStateList);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setTintList(paramColorStateList);
  }
  
  public final void setTintMode(PorterDuff.Mode paramMode)
  {
    if (mDelegateDrawable != null)
    {
      DrawableCompat.setTintMode(mDelegateDrawable, paramMode);
      return;
    }
    mAnimatedVectorState.mVectorDrawable.setTintMode(paramMode);
  }
  
  public final boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (mDelegateDrawable != null) {
      return mDelegateDrawable.setVisible(paramBoolean1, paramBoolean2);
    }
    mAnimatedVectorState.mVectorDrawable.setVisible(paramBoolean1, paramBoolean2);
    return super.setVisible(paramBoolean1, paramBoolean2);
  }
  
  public final void start()
  {
    if (mDelegateDrawable != null) {
      ((AnimatedVectorDrawable)mDelegateDrawable).start();
    }
    while (isStarted()) {
      return;
    }
    ArrayList localArrayList = mAnimatedVectorState.mAnimators;
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      ((Animator)localArrayList.get(i)).start();
      i += 1;
    }
    invalidateSelf();
  }
  
  public final void stop()
  {
    if (mDelegateDrawable != null) {
      ((AnimatedVectorDrawable)mDelegateDrawable).stop();
    }
    for (;;)
    {
      return;
      ArrayList localArrayList = mAnimatedVectorState.mAnimators;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        ((Animator)localArrayList.get(i)).end();
        i += 1;
      }
    }
  }
  
  private static final class AnimatedVectorDrawableCompatState
    extends Drawable.ConstantState
  {
    ArrayList<Animator> mAnimators;
    int mChangingConfigurations;
    ArrayMap<Animator, String> mTargetNameMap;
    VectorDrawableCompat mVectorDrawable;
    
    public final int getChangingConfigurations()
    {
      return mChangingConfigurations;
    }
    
    public final Drawable newDrawable()
    {
      throw new IllegalStateException("No constant state support for SDK < 23.");
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      throw new IllegalStateException("No constant state support for SDK < 23.");
    }
  }
  
  private static final class AnimatedVectorDrawableDelegateState
    extends Drawable.ConstantState
  {
    private final Drawable.ConstantState mDelegateState;
    
    public AnimatedVectorDrawableDelegateState(Drawable.ConstantState paramConstantState)
    {
      mDelegateState = paramConstantState;
    }
    
    public final boolean canApplyTheme()
    {
      return mDelegateState.canApplyTheme();
    }
    
    public final int getChangingConfigurations()
    {
      return mDelegateState.getChangingConfigurations();
    }
    
    public final Drawable newDrawable()
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((byte)0);
      mDelegateDrawable = mDelegateState.newDrawable();
      mDelegateDrawable.setCallback(mCallback);
      return localAnimatedVectorDrawableCompat;
    }
    
    public final Drawable newDrawable(Resources paramResources)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((byte)0);
      mDelegateDrawable = mDelegateState.newDrawable(paramResources);
      mDelegateDrawable.setCallback(mCallback);
      return localAnimatedVectorDrawableCompat;
    }
    
    public final Drawable newDrawable(Resources paramResources, Resources.Theme paramTheme)
    {
      AnimatedVectorDrawableCompat localAnimatedVectorDrawableCompat = new AnimatedVectorDrawableCompat((byte)0);
      mDelegateDrawable = mDelegateState.newDrawable(paramResources, paramTheme);
      mDelegateDrawable.setCallback(mCallback);
      return localAnimatedVectorDrawableCompat;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.graphics.drawable.AnimatedVectorDrawableCompat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */