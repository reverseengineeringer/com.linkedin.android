package android.support.design.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.R.anim;
import android.support.design.R.dimen;
import android.support.design.R.id;
import android.support.design.R.layout;
import android.support.design.R.styleable;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.support.v4.view.ViewPropertyAnimatorListenerAdapter;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Snackbar
{
  static final int ANIMATION_DURATION = 250;
  static final int ANIMATION_FADE_DURATION = 180;
  public static final int LENGTH_INDEFINITE = -2;
  public static final int LENGTH_LONG = 0;
  public static final int LENGTH_SHORT = -1;
  private static final int MSG_DISMISS = 1;
  private static final int MSG_SHOW = 0;
  private static final Handler sHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
  {
    public final boolean handleMessage(Message paramAnonymousMessage)
    {
      switch (what)
      {
      default: 
        return false;
      case 0: 
        ((Snackbar)obj).showView();
        return true;
      }
      ((Snackbar)obj).hideView(arg1);
      return true;
    }
  });
  private final AccessibilityManager mAccessibilityManager;
  private Callback mCallback;
  private final Context mContext;
  private int mDuration;
  private final SnackbarManager.Callback mManagerCallback = new SnackbarManager.Callback()
  {
    public void dismiss(int paramAnonymousInt)
    {
      Snackbar.sHandler.sendMessage(Snackbar.sHandler.obtainMessage(1, paramAnonymousInt, 0, Snackbar.this));
    }
    
    public void show()
    {
      Snackbar.sHandler.sendMessage(Snackbar.sHandler.obtainMessage(0, Snackbar.this));
    }
  };
  private final ViewGroup mTargetParent;
  private final SnackbarLayout mView;
  
  private Snackbar(ViewGroup paramViewGroup)
  {
    mTargetParent = paramViewGroup;
    mContext = paramViewGroup.getContext();
    ThemeUtils.checkAppCompatTheme(mContext);
    mView = ((SnackbarLayout)LayoutInflater.from(mContext).inflate(R.layout.design_layout_snackbar, mTargetParent, false));
    mAccessibilityManager = ((AccessibilityManager)mContext.getSystemService("accessibility"));
  }
  
  private void animateViewIn()
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      ViewCompat.setTranslationY(mView, mView.getHeight());
      ViewCompat.animate(mView).translationY(0.0F).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        public void onAnimationEnd(View paramAnonymousView)
        {
          Snackbar.this.onViewShown();
        }
        
        public void onAnimationStart(View paramAnonymousView)
        {
          mView.animateChildrenIn(70, 180);
        }
      }).start();
      return;
    }
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_snackbar_in);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        Snackbar.this.onViewShown();
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    mView.startAnimation(localAnimation);
  }
  
  private void animateViewOut(final int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      ViewCompat.animate(mView).translationY(mView.getHeight()).setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR).setDuration(250L).setListener(new ViewPropertyAnimatorListenerAdapter()
      {
        public void onAnimationEnd(View paramAnonymousView)
        {
          Snackbar.this.onViewHidden(paramInt);
        }
        
        public void onAnimationStart(View paramAnonymousView)
        {
          mView.animateChildrenOut(0, 180);
        }
      }).start();
      return;
    }
    Animation localAnimation = android.view.animation.AnimationUtils.loadAnimation(mView.getContext(), R.anim.design_snackbar_out);
    localAnimation.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    localAnimation.setDuration(250L);
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        Snackbar.this.onViewHidden(paramInt);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    mView.startAnimation(localAnimation);
  }
  
  private void dispatchDismiss(int paramInt)
  {
    SnackbarManager.getInstance().dismiss(mManagerCallback, paramInt);
  }
  
  private static ViewGroup findSuitableParent(View paramView)
  {
    Object localObject2 = null;
    View localView = paramView;
    if ((localView instanceof CoordinatorLayout)) {
      return (ViewGroup)localView;
    }
    Object localObject1 = localObject2;
    if ((localView instanceof FrameLayout))
    {
      if (localView.getId() == 16908290) {
        return (ViewGroup)localView;
      }
      localObject1 = (ViewGroup)localView;
    }
    paramView = localView;
    if (localView != null)
    {
      paramView = localView.getParent();
      if (!(paramView instanceof View)) {
        break label78;
      }
    }
    label78:
    for (paramView = (View)paramView;; paramView = null)
    {
      localObject2 = localObject1;
      localView = paramView;
      if (paramView != null) {
        break;
      }
      return (ViewGroup)localObject1;
    }
  }
  
  public static Snackbar make(View paramView, int paramInt1, int paramInt2)
  {
    return make(paramView, paramView.getResources().getText(paramInt1), paramInt2);
  }
  
  public static Snackbar make(View paramView, CharSequence paramCharSequence, int paramInt)
  {
    paramView = new Snackbar(findSuitableParent(paramView));
    paramView.setText(paramCharSequence);
    paramView.setDuration(paramInt);
    return paramView;
  }
  
  private void onViewHidden(int paramInt)
  {
    SnackbarManager.getInstance().onDismissed(mManagerCallback);
    if (mCallback != null) {
      mCallback.onDismissed(this, paramInt);
    }
    ViewParent localViewParent = mView.getParent();
    if ((localViewParent instanceof ViewGroup)) {
      ((ViewGroup)localViewParent).removeView(mView);
    }
  }
  
  private void onViewShown()
  {
    SnackbarManager.getInstance().onShown(mManagerCallback);
    if (mCallback != null) {
      mCallback.onShown(this);
    }
  }
  
  private boolean shouldAnimate()
  {
    return !mAccessibilityManager.isEnabled();
  }
  
  public final void dismiss()
  {
    dispatchDismiss(3);
  }
  
  public final int getDuration()
  {
    return mDuration;
  }
  
  public final View getView()
  {
    return mView;
  }
  
  final void hideView(int paramInt)
  {
    if ((shouldAnimate()) && (mView.getVisibility() == 0))
    {
      animateViewOut(paramInt);
      return;
    }
    onViewHidden(paramInt);
  }
  
  public final boolean isShown()
  {
    return SnackbarManager.getInstance().isCurrent(mManagerCallback);
  }
  
  public final boolean isShownOrQueued()
  {
    return SnackbarManager.getInstance().isCurrentOrNext(mManagerCallback);
  }
  
  public final Snackbar setAction(int paramInt, View.OnClickListener paramOnClickListener)
  {
    return setAction(mContext.getText(paramInt), paramOnClickListener);
  }
  
  public final Snackbar setAction(CharSequence paramCharSequence, final View.OnClickListener paramOnClickListener)
  {
    Button localButton = mView.getActionView();
    if ((TextUtils.isEmpty(paramCharSequence)) || (paramOnClickListener == null))
    {
      localButton.setVisibility(8);
      localButton.setOnClickListener(null);
      return this;
    }
    localButton.setVisibility(0);
    localButton.setText(paramCharSequence);
    localButton.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        paramOnClickListener.onClick(paramAnonymousView);
        Snackbar.this.dispatchDismiss(1);
      }
    });
    return this;
  }
  
  public final Snackbar setActionTextColor(int paramInt)
  {
    mView.getActionView().setTextColor(paramInt);
    return this;
  }
  
  public final Snackbar setActionTextColor(ColorStateList paramColorStateList)
  {
    mView.getActionView().setTextColor(paramColorStateList);
    return this;
  }
  
  public final Snackbar setCallback(Callback paramCallback)
  {
    mCallback = paramCallback;
    return this;
  }
  
  public final Snackbar setDuration(int paramInt)
  {
    mDuration = paramInt;
    return this;
  }
  
  public final Snackbar setText(int paramInt)
  {
    return setText(mContext.getText(paramInt));
  }
  
  public final Snackbar setText(CharSequence paramCharSequence)
  {
    mView.getMessageView().setText(paramCharSequence);
    return this;
  }
  
  public final void show()
  {
    SnackbarManager.getInstance().show(mDuration, mManagerCallback);
  }
  
  final void showView()
  {
    if (mView.getParent() == null)
    {
      ViewGroup.LayoutParams localLayoutParams = mView.getLayoutParams();
      if ((localLayoutParams instanceof CoordinatorLayout.LayoutParams))
      {
        Behavior localBehavior = new Behavior();
        localBehavior.setStartAlphaSwipeDistance(0.1F);
        localBehavior.setEndAlphaSwipeDistance(0.6F);
        localBehavior.setSwipeDirection(0);
        localBehavior.setListener(new SwipeDismissBehavior.OnDismissListener()
        {
          public void onDismiss(View paramAnonymousView)
          {
            paramAnonymousView.setVisibility(8);
            Snackbar.this.dispatchDismiss(0);
          }
          
          public void onDragStateChanged(int paramAnonymousInt)
          {
            switch (paramAnonymousInt)
            {
            default: 
              return;
            case 1: 
            case 2: 
              SnackbarManager.getInstance().cancelTimeout(mManagerCallback);
              return;
            }
            SnackbarManager.getInstance().restoreTimeout(mManagerCallback);
          }
        });
        ((CoordinatorLayout.LayoutParams)localLayoutParams).setBehavior(localBehavior);
      }
      mTargetParent.addView(mView);
    }
    mView.setOnAttachStateChangeListener(new Snackbar.SnackbarLayout.OnAttachStateChangeListener()
    {
      public void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public void onViewDetachedFromWindow(View paramAnonymousView)
      {
        if (isShownOrQueued()) {
          Snackbar.sHandler.post(new Runnable()
          {
            public void run()
            {
              Snackbar.this.onViewHidden(3);
            }
          });
        }
      }
    });
    if (ViewCompat.isLaidOut(mView))
    {
      if (shouldAnimate())
      {
        animateViewIn();
        return;
      }
      onViewShown();
      return;
    }
    mView.setOnLayoutChangeListener(new Snackbar.SnackbarLayout.OnLayoutChangeListener()
    {
      public void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        mView.setOnLayoutChangeListener(null);
        if (Snackbar.this.shouldAnimate())
        {
          Snackbar.this.animateViewIn();
          return;
        }
        Snackbar.this.onViewShown();
      }
    });
  }
  
  final class Behavior
    extends SwipeDismissBehavior<Snackbar.SnackbarLayout>
  {
    Behavior() {}
    
    public final boolean canSwipeDismissView(View paramView)
    {
      return paramView instanceof Snackbar.SnackbarLayout;
    }
    
    public final boolean onInterceptTouchEvent(CoordinatorLayout paramCoordinatorLayout, Snackbar.SnackbarLayout paramSnackbarLayout, MotionEvent paramMotionEvent)
    {
      if (paramCoordinatorLayout.isPointInChildBounds(paramSnackbarLayout, (int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())) {
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        return super.onInterceptTouchEvent(paramCoordinatorLayout, paramSnackbarLayout, paramMotionEvent);
        SnackbarManager.getInstance().cancelTimeout(mManagerCallback);
        continue;
        SnackbarManager.getInstance().restoreTimeout(mManagerCallback);
      }
    }
  }
  
  public static abstract class Callback
  {
    public static final int DISMISS_EVENT_ACTION = 1;
    public static final int DISMISS_EVENT_CONSECUTIVE = 4;
    public static final int DISMISS_EVENT_MANUAL = 3;
    public static final int DISMISS_EVENT_SWIPE = 0;
    public static final int DISMISS_EVENT_TIMEOUT = 2;
    
    public void onDismissed(Snackbar paramSnackbar, int paramInt) {}
    
    public void onShown(Snackbar paramSnackbar) {}
    
    @Retention(RetentionPolicy.SOURCE)
    public static @interface DismissEvent {}
  }
  
  @Retention(RetentionPolicy.SOURCE)
  public static @interface Duration {}
  
  public static class SnackbarLayout
    extends LinearLayout
  {
    private Button mActionView;
    private int mMaxInlineActionWidth;
    private int mMaxWidth;
    private TextView mMessageView;
    private OnAttachStateChangeListener mOnAttachStateChangeListener;
    private OnLayoutChangeListener mOnLayoutChangeListener;
    
    public SnackbarLayout(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public SnackbarLayout(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SnackbarLayout);
      mMaxWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
      mMaxInlineActionWidth = paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
      if (paramAttributeSet.hasValue(R.styleable.SnackbarLayout_elevation)) {
        ViewCompat.setElevation(this, paramAttributeSet.getDimensionPixelSize(R.styleable.SnackbarLayout_elevation, 0));
      }
      paramAttributeSet.recycle();
      setClickable(true);
      LayoutInflater.from(paramContext).inflate(R.layout.design_layout_snackbar_include, this);
      ViewCompat.setAccessibilityLiveRegion$5359dc9a(this);
      ViewCompat.setImportantForAccessibility(this, 1);
    }
    
    private static void updateTopBottomPadding(View paramView, int paramInt1, int paramInt2)
    {
      if (ViewCompat.isPaddingRelative(paramView))
      {
        ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramInt1, ViewCompat.getPaddingEnd(paramView), paramInt2);
        return;
      }
      paramView.setPadding(paramView.getPaddingLeft(), paramInt1, paramView.getPaddingRight(), paramInt2);
    }
    
    private boolean updateViewsWithinLayout(int paramInt1, int paramInt2, int paramInt3)
    {
      boolean bool = false;
      if (paramInt1 != getOrientation())
      {
        setOrientation(paramInt1);
        bool = true;
      }
      if ((mMessageView.getPaddingTop() != paramInt2) || (mMessageView.getPaddingBottom() != paramInt3))
      {
        updateTopBottomPadding(mMessageView, paramInt2, paramInt3);
        bool = true;
      }
      return bool;
    }
    
    void animateChildrenIn(int paramInt1, int paramInt2)
    {
      ViewCompat.setAlpha(mMessageView, 0.0F);
      ViewCompat.animate(mMessageView).alpha(1.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
      if (mActionView.getVisibility() == 0)
      {
        ViewCompat.setAlpha(mActionView, 0.0F);
        ViewCompat.animate(mActionView).alpha(1.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
      }
    }
    
    void animateChildrenOut(int paramInt1, int paramInt2)
    {
      ViewCompat.setAlpha(mMessageView, 1.0F);
      ViewCompat.animate(mMessageView).alpha(0.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
      if (mActionView.getVisibility() == 0)
      {
        ViewCompat.setAlpha(mActionView, 1.0F);
        ViewCompat.animate(mActionView).alpha(0.0F).setDuration(paramInt2).setStartDelay(paramInt1).start();
      }
    }
    
    Button getActionView()
    {
      return mActionView;
    }
    
    TextView getMessageView()
    {
      return mMessageView;
    }
    
    protected void onAttachedToWindow()
    {
      super.onAttachedToWindow();
      if (mOnAttachStateChangeListener != null) {
        mOnAttachStateChangeListener.onViewAttachedToWindow(this);
      }
    }
    
    protected void onDetachedFromWindow()
    {
      super.onDetachedFromWindow();
      if (mOnAttachStateChangeListener != null) {
        mOnAttachStateChangeListener.onViewDetachedFromWindow(this);
      }
    }
    
    protected void onFinishInflate()
    {
      super.onFinishInflate();
      mMessageView = ((TextView)findViewById(R.id.snackbar_text));
      mActionView = ((Button)findViewById(R.id.snackbar_action));
    }
    
    protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
      if (mOnLayoutChangeListener != null) {
        mOnLayoutChangeListener.onLayoutChange(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
    
    protected void onMeasure(int paramInt1, int paramInt2)
    {
      super.onMeasure(paramInt1, paramInt2);
      int i = paramInt1;
      if (mMaxWidth > 0)
      {
        i = paramInt1;
        if (getMeasuredWidth() > mMaxWidth)
        {
          i = View.MeasureSpec.makeMeasureSpec(mMaxWidth, 1073741824);
          super.onMeasure(i, paramInt2);
        }
      }
      int j = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical_2lines);
      int k = getResources().getDimensionPixelSize(R.dimen.design_snackbar_padding_vertical);
      if (mMessageView.getLayout().getLineCount() > 1) {}
      int m;
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        m = 0;
        if ((paramInt1 == 0) || (mMaxInlineActionWidth <= 0) || (mActionView.getMeasuredWidth() <= mMaxInlineActionWidth)) {
          break;
        }
        paramInt1 = m;
        if (updateViewsWithinLayout(1, j, j - k)) {
          paramInt1 = 1;
        }
        if (paramInt1 != 0) {
          super.onMeasure(i, paramInt2);
        }
        return;
      }
      if (paramInt1 != 0) {}
      for (;;)
      {
        paramInt1 = m;
        if (!updateViewsWithinLayout(0, j, j)) {
          break;
        }
        paramInt1 = 1;
        break;
        j = k;
      }
    }
    
    void setOnAttachStateChangeListener(OnAttachStateChangeListener paramOnAttachStateChangeListener)
    {
      mOnAttachStateChangeListener = paramOnAttachStateChangeListener;
    }
    
    void setOnLayoutChangeListener(OnLayoutChangeListener paramOnLayoutChangeListener)
    {
      mOnLayoutChangeListener = paramOnLayoutChangeListener;
    }
    
    static abstract interface OnAttachStateChangeListener
    {
      public abstract void onViewAttachedToWindow(View paramView);
      
      public abstract void onViewDetachedFromWindow(View paramView);
    }
    
    static abstract interface OnLayoutChangeListener
    {
      public abstract void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    }
  }
}

/* Location:
 * Qualified Name:     android.support.design.widget.Snackbar
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */