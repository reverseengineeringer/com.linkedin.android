package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.os.TraceCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.util.LongSparseArray;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.view.NestedScrollingChildHelper;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewConfigurationCompat;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.CollectionItemInfoCompat;
import android.support.v4.view.accessibility.AccessibilityRecordCompat;
import android.support.v4.widget.EdgeEffectCompat;
import android.support.v4.widget.ScrollerCompat;
import android.support.v7.recyclerview.R.styleable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecyclerView
  extends ViewGroup
  implements NestedScrollingChild, ScrollingView
{
  static final boolean ALLOW_SIZE_IN_UNSPECIFIED_SPEC;
  private static final boolean FORCE_INVALIDATE_DISPLAY_LIST;
  private static final Class<?>[] LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE;
  private static final int[] NESTED_SCROLLING_ATTRS = { 16843830 };
  private static final Interpolator sQuinticInterpolator;
  private RecyclerViewAccessibilityDelegate mAccessibilityDelegate;
  private final AccessibilityManager mAccessibilityManager;
  public OnItemTouchListener mActiveOnItemTouchListener;
  private Adapter mAdapter;
  AdapterHelper mAdapterHelper;
  private boolean mAdapterUpdateDuringMeasure;
  EdgeEffectCompat mBottomGlow;
  private ChildDrawingOrderCallback mChildDrawingOrderCallback;
  public ChildHelper mChildHelper;
  private boolean mClipToPadding;
  public boolean mDataSetHasChangedAfterLayout;
  private int mEatRequestLayout;
  private int mEatenAccessibilityChangeFlags;
  boolean mFirstLayoutComplete;
  private boolean mHasFixedSize;
  private boolean mIgnoreMotionEventTillDown;
  private int mInitialTouchX;
  private int mInitialTouchY;
  private boolean mIsAttached;
  ItemAnimator mItemAnimator;
  private RecyclerView.ItemAnimator.ItemAnimatorListener mItemAnimatorListener;
  private Runnable mItemAnimatorRunner;
  public final ArrayList<ItemDecoration> mItemDecorations;
  boolean mItemsAddedOrRemoved;
  boolean mItemsChanged;
  private int mLastTouchX;
  private int mLastTouchY;
  public LayoutManager mLayout;
  private boolean mLayoutFrozen;
  private int mLayoutOrScrollCounter;
  private boolean mLayoutRequestEaten;
  EdgeEffectCompat mLeftGlow;
  private final int mMaxFlingVelocity;
  private final int mMinFlingVelocity;
  private final int[] mMinMaxLayoutPositions;
  private final int[] mNestedOffsets;
  private final RecyclerViewDataObserver mObserver;
  public List<OnChildAttachStateChangeListener> mOnChildAttachStateListeners;
  public final ArrayList<OnItemTouchListener> mOnItemTouchListeners;
  private SavedState mPendingSavedState;
  private final boolean mPostUpdatesOnAnimation;
  private boolean mPostedAnimatorRunner;
  final Recycler mRecycler;
  private RecyclerListener mRecyclerListener;
  EdgeEffectCompat mRightGlow;
  private final int[] mScrollConsumed;
  private float mScrollFactor;
  private OnScrollListener mScrollListener;
  private List<OnScrollListener> mScrollListeners;
  private final int[] mScrollOffset;
  private int mScrollPointerId;
  private int mScrollState;
  private NestedScrollingChildHelper mScrollingChildHelper;
  final State mState;
  private final Rect mTempRect;
  EdgeEffectCompat mTopGlow;
  private int mTouchSlop;
  private final Runnable mUpdateChildViewsRunnable;
  private VelocityTracker mVelocityTracker;
  private final ViewFlinger mViewFlinger;
  private final ViewInfoStore.ProcessCallback mViewInfoProcessCallback;
  final ViewInfoStore mViewInfoStore;
  
  static
  {
    if ((Build.VERSION.SDK_INT == 18) || (Build.VERSION.SDK_INT == 19) || (Build.VERSION.SDK_INT == 20))
    {
      bool = true;
      FORCE_INVALIDATE_DISPLAY_LIST = bool;
      if (Build.VERSION.SDK_INT < 23) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      ALLOW_SIZE_IN_UNSPECIFIED_SPEC = bool;
      LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE = new Class[] { Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE };
      sQuinticInterpolator = new Interpolator()
      {
        public final float getInterpolation(float paramAnonymousFloat)
        {
          paramAnonymousFloat -= 1.0F;
          return paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat * paramAnonymousFloat + 1.0F;
        }
      };
      return;
      bool = false;
      break;
    }
  }
  
  public RecyclerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  /* Error */
  public RecyclerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: iload_3
    //   4: invokespecial 258	android/view/ViewGroup:<init>	(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    //   7: aload_0
    //   8: new 76	android/support/v7/widget/RecyclerView$RecyclerViewDataObserver
    //   11: dup
    //   12: aload_0
    //   13: iconst_0
    //   14: invokespecial 261	android/support/v7/widget/RecyclerView$RecyclerViewDataObserver:<init>	(Landroid/support/v7/widget/RecyclerView;B)V
    //   17: putfield 263	android/support/v7/widget/RecyclerView:mObserver	Landroid/support/v7/widget/RecyclerView$RecyclerViewDataObserver;
    //   20: aload_0
    //   21: new 70	android/support/v7/widget/RecyclerView$Recycler
    //   24: dup
    //   25: aload_0
    //   26: invokespecial 266	android/support/v7/widget/RecyclerView$Recycler:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   29: putfield 268	android/support/v7/widget/RecyclerView:mRecycler	Landroid/support/v7/widget/RecyclerView$Recycler;
    //   32: aload_0
    //   33: new 270	android/support/v7/widget/ViewInfoStore
    //   36: dup
    //   37: invokespecial 271	android/support/v7/widget/ViewInfoStore:<init>	()V
    //   40: putfield 273	android/support/v7/widget/RecyclerView:mViewInfoStore	Landroid/support/v7/widget/ViewInfoStore;
    //   43: aload_0
    //   44: new 10	android/support/v7/widget/RecyclerView$1
    //   47: dup
    //   48: aload_0
    //   49: invokespecial 274	android/support/v7/widget/RecyclerView$1:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   52: putfield 276	android/support/v7/widget/RecyclerView:mUpdateChildViewsRunnable	Ljava/lang/Runnable;
    //   55: aload_0
    //   56: new 278	android/graphics/Rect
    //   59: dup
    //   60: invokespecial 279	android/graphics/Rect:<init>	()V
    //   63: putfield 281	android/support/v7/widget/RecyclerView:mTempRect	Landroid/graphics/Rect;
    //   66: aload_0
    //   67: new 283	java/util/ArrayList
    //   70: dup
    //   71: invokespecial 284	java/util/ArrayList:<init>	()V
    //   74: putfield 286	android/support/v7/widget/RecyclerView:mItemDecorations	Ljava/util/ArrayList;
    //   77: aload_0
    //   78: new 283	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 284	java/util/ArrayList:<init>	()V
    //   85: putfield 288	android/support/v7/widget/RecyclerView:mOnItemTouchListeners	Ljava/util/ArrayList;
    //   88: aload_0
    //   89: iconst_0
    //   90: putfield 290	android/support/v7/widget/RecyclerView:mEatRequestLayout	I
    //   93: aload_0
    //   94: iconst_0
    //   95: putfield 292	android/support/v7/widget/RecyclerView:mDataSetHasChangedAfterLayout	Z
    //   98: aload_0
    //   99: iconst_0
    //   100: putfield 294	android/support/v7/widget/RecyclerView:mLayoutOrScrollCounter	I
    //   103: aload_0
    //   104: new 296	android/support/v7/widget/DefaultItemAnimator
    //   107: dup
    //   108: invokespecial 297	android/support/v7/widget/DefaultItemAnimator:<init>	()V
    //   111: putfield 299	android/support/v7/widget/RecyclerView:mItemAnimator	Landroid/support/v7/widget/RecyclerView$ItemAnimator;
    //   114: aload_0
    //   115: iconst_0
    //   116: putfield 301	android/support/v7/widget/RecyclerView:mScrollState	I
    //   119: aload_0
    //   120: iconst_m1
    //   121: putfield 303	android/support/v7/widget/RecyclerView:mScrollPointerId	I
    //   124: aload_0
    //   125: ldc_w 304
    //   128: putfield 306	android/support/v7/widget/RecyclerView:mScrollFactor	F
    //   131: aload_0
    //   132: new 96	android/support/v7/widget/RecyclerView$ViewFlinger
    //   135: dup
    //   136: aload_0
    //   137: invokespecial 307	android/support/v7/widget/RecyclerView$ViewFlinger:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   140: putfield 309	android/support/v7/widget/RecyclerView:mViewFlinger	Landroid/support/v7/widget/RecyclerView$ViewFlinger;
    //   143: aload_0
    //   144: new 90	android/support/v7/widget/RecyclerView$State
    //   147: dup
    //   148: invokespecial 310	android/support/v7/widget/RecyclerView$State:<init>	()V
    //   151: putfield 312	android/support/v7/widget/RecyclerView:mState	Landroid/support/v7/widget/RecyclerView$State;
    //   154: aload_0
    //   155: iconst_0
    //   156: putfield 314	android/support/v7/widget/RecyclerView:mItemsAddedOrRemoved	Z
    //   159: aload_0
    //   160: iconst_0
    //   161: putfield 316	android/support/v7/widget/RecyclerView:mItemsChanged	Z
    //   164: aload_0
    //   165: new 43	android/support/v7/widget/RecyclerView$ItemAnimatorRestoreListener
    //   168: dup
    //   169: aload_0
    //   170: iconst_0
    //   171: invokespecial 317	android/support/v7/widget/RecyclerView$ItemAnimatorRestoreListener:<init>	(Landroid/support/v7/widget/RecyclerView;B)V
    //   174: putfield 319	android/support/v7/widget/RecyclerView:mItemAnimatorListener	Landroid/support/v7/widget/RecyclerView$ItemAnimator$ItemAnimatorListener;
    //   177: aload_0
    //   178: iconst_0
    //   179: putfield 321	android/support/v7/widget/RecyclerView:mPostedAnimatorRunner	Z
    //   182: aload_0
    //   183: iconst_2
    //   184: newarray <illegal type>
    //   186: putfield 323	android/support/v7/widget/RecyclerView:mMinMaxLayoutPositions	[I
    //   189: aload_0
    //   190: iconst_2
    //   191: newarray <illegal type>
    //   193: putfield 325	android/support/v7/widget/RecyclerView:mScrollOffset	[I
    //   196: aload_0
    //   197: iconst_2
    //   198: newarray <illegal type>
    //   200: putfield 327	android/support/v7/widget/RecyclerView:mScrollConsumed	[I
    //   203: aload_0
    //   204: iconst_2
    //   205: newarray <illegal type>
    //   207: putfield 329	android/support/v7/widget/RecyclerView:mNestedOffsets	[I
    //   210: aload_0
    //   211: new 12	android/support/v7/widget/RecyclerView$2
    //   214: dup
    //   215: aload_0
    //   216: invokespecial 330	android/support/v7/widget/RecyclerView$2:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   219: putfield 332	android/support/v7/widget/RecyclerView:mItemAnimatorRunner	Ljava/lang/Runnable;
    //   222: aload_0
    //   223: new 16	android/support/v7/widget/RecyclerView$4
    //   226: dup
    //   227: aload_0
    //   228: invokespecial 333	android/support/v7/widget/RecyclerView$4:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   231: putfield 335	android/support/v7/widget/RecyclerView:mViewInfoProcessCallback	Landroid/support/v7/widget/ViewInfoStore$ProcessCallback;
    //   234: aload_0
    //   235: iconst_1
    //   236: invokevirtual 339	android/support/v7/widget/RecyclerView:setScrollContainer	(Z)V
    //   239: aload_0
    //   240: iconst_1
    //   241: invokevirtual 342	android/support/v7/widget/RecyclerView:setFocusableInTouchMode	(Z)V
    //   244: getstatic 214	android/os/Build$VERSION:SDK_INT	I
    //   247: bipush 16
    //   249: if_icmplt +379 -> 628
    //   252: iconst_1
    //   253: istore 4
    //   255: aload_0
    //   256: iload 4
    //   258: putfield 344	android/support/v7/widget/RecyclerView:mPostUpdatesOnAnimation	Z
    //   261: aload_1
    //   262: invokestatic 350	android/view/ViewConfiguration:get	(Landroid/content/Context;)Landroid/view/ViewConfiguration;
    //   265: astore 6
    //   267: aload_0
    //   268: aload 6
    //   270: invokevirtual 354	android/view/ViewConfiguration:getScaledTouchSlop	()I
    //   273: putfield 356	android/support/v7/widget/RecyclerView:mTouchSlop	I
    //   276: aload_0
    //   277: aload 6
    //   279: invokevirtual 359	android/view/ViewConfiguration:getScaledMinimumFlingVelocity	()I
    //   282: putfield 361	android/support/v7/widget/RecyclerView:mMinFlingVelocity	I
    //   285: aload_0
    //   286: aload 6
    //   288: invokevirtual 364	android/view/ViewConfiguration:getScaledMaximumFlingVelocity	()I
    //   291: putfield 366	android/support/v7/widget/RecyclerView:mMaxFlingVelocity	I
    //   294: aload_0
    //   295: invokestatic 372	android/support/v4/view/ViewCompat:getOverScrollMode	(Landroid/view/View;)I
    //   298: iconst_2
    //   299: if_icmpne +335 -> 634
    //   302: iconst_1
    //   303: istore 4
    //   305: aload_0
    //   306: iload 4
    //   308: invokevirtual 375	android/support/v7/widget/RecyclerView:setWillNotDraw	(Z)V
    //   311: aload_0
    //   312: getfield 299	android/support/v7/widget/RecyclerView:mItemAnimator	Landroid/support/v7/widget/RecyclerView$ItemAnimator;
    //   315: aload_0
    //   316: getfield 319	android/support/v7/widget/RecyclerView:mItemAnimatorListener	Landroid/support/v7/widget/RecyclerView$ItemAnimator$ItemAnimatorListener;
    //   319: putfield 378	android/support/v7/widget/RecyclerView$ItemAnimator:mListener	Landroid/support/v7/widget/RecyclerView$ItemAnimator$ItemAnimatorListener;
    //   322: aload_0
    //   323: new 380	android/support/v7/widget/AdapterHelper
    //   326: dup
    //   327: new 20	android/support/v7/widget/RecyclerView$6
    //   330: dup
    //   331: aload_0
    //   332: invokespecial 381	android/support/v7/widget/RecyclerView$6:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   335: invokespecial 384	android/support/v7/widget/AdapterHelper:<init>	(Landroid/support/v7/widget/AdapterHelper$Callback;)V
    //   338: putfield 386	android/support/v7/widget/RecyclerView:mAdapterHelper	Landroid/support/v7/widget/AdapterHelper;
    //   341: aload_0
    //   342: new 388	android/support/v7/widget/ChildHelper
    //   345: dup
    //   346: new 18	android/support/v7/widget/RecyclerView$5
    //   349: dup
    //   350: aload_0
    //   351: invokespecial 389	android/support/v7/widget/RecyclerView$5:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   354: invokespecial 392	android/support/v7/widget/ChildHelper:<init>	(Landroid/support/v7/widget/ChildHelper$Callback;)V
    //   357: putfield 394	android/support/v7/widget/RecyclerView:mChildHelper	Landroid/support/v7/widget/ChildHelper;
    //   360: aload_0
    //   361: invokestatic 397	android/support/v4/view/ViewCompat:getImportantForAccessibility	(Landroid/view/View;)I
    //   364: ifne +8 -> 372
    //   367: aload_0
    //   368: iconst_1
    //   369: invokestatic 401	android/support/v4/view/ViewCompat:setImportantForAccessibility	(Landroid/view/View;I)V
    //   372: aload_0
    //   373: aload_0
    //   374: invokevirtual 405	android/support/v7/widget/RecyclerView:getContext	()Landroid/content/Context;
    //   377: ldc_w 407
    //   380: invokevirtual 411	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   383: checkcast 413	android/view/accessibility/AccessibilityManager
    //   386: putfield 415	android/support/v7/widget/RecyclerView:mAccessibilityManager	Landroid/view/accessibility/AccessibilityManager;
    //   389: aload_0
    //   390: new 417	android/support/v7/widget/RecyclerViewAccessibilityDelegate
    //   393: dup
    //   394: aload_0
    //   395: invokespecial 418	android/support/v7/widget/RecyclerViewAccessibilityDelegate:<init>	(Landroid/support/v7/widget/RecyclerView;)V
    //   398: invokevirtual 422	android/support/v7/widget/RecyclerView:setAccessibilityDelegateCompat	(Landroid/support/v7/widget/RecyclerViewAccessibilityDelegate;)V
    //   401: iconst_1
    //   402: istore 5
    //   404: iload 5
    //   406: istore 4
    //   408: aload_2
    //   409: ifnull +212 -> 621
    //   412: aload_1
    //   413: aload_2
    //   414: getstatic 427	android/support/v7/recyclerview/R$styleable:RecyclerView	[I
    //   417: iload_3
    //   418: iconst_0
    //   419: invokevirtual 431	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   422: astore 6
    //   424: aload 6
    //   426: getstatic 434	android/support/v7/recyclerview/R$styleable:RecyclerView_layoutManager	I
    //   429: invokevirtual 440	android/content/res/TypedArray:getString	(I)Ljava/lang/String;
    //   432: astore 7
    //   434: aload 6
    //   436: invokevirtual 443	android/content/res/TypedArray:recycle	()V
    //   439: aload 7
    //   441: ifnull +145 -> 586
    //   444: aload 7
    //   446: invokevirtual 449	java/lang/String:trim	()Ljava/lang/String;
    //   449: astore 6
    //   451: aload 6
    //   453: invokevirtual 452	java/lang/String:length	()I
    //   456: ifeq +130 -> 586
    //   459: aload 6
    //   461: iconst_0
    //   462: invokevirtual 456	java/lang/String:charAt	(I)C
    //   465: bipush 46
    //   467: if_icmpne +173 -> 640
    //   470: new 458	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   477: aload_1
    //   478: invokevirtual 462	android/content/Context:getPackageName	()Ljava/lang/String;
    //   481: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   484: aload 6
    //   486: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: astore 6
    //   494: aload_0
    //   495: invokevirtual 473	android/support/v7/widget/RecyclerView:isInEditMode	()Z
    //   498: ifeq +192 -> 690
    //   501: aload_0
    //   502: invokevirtual 479	java/lang/Object:getClass	()Ljava/lang/Class;
    //   505: invokevirtual 483	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   508: astore 7
    //   510: aload 7
    //   512: aload 6
    //   514: invokevirtual 489	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   517: ldc 49
    //   519: invokevirtual 493	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   522: astore 9
    //   524: aload 9
    //   526: getstatic 232	android/support/v7/widget/RecyclerView:LAYOUT_MANAGER_CONSTRUCTOR_SIGNATURE	[Ljava/lang/Class;
    //   529: invokevirtual 497	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   532: astore 8
    //   534: iconst_4
    //   535: anewarray 475	java/lang/Object
    //   538: astore 7
    //   540: aload 7
    //   542: iconst_0
    //   543: aload_1
    //   544: aastore
    //   545: aload 7
    //   547: iconst_1
    //   548: aload_2
    //   549: aastore
    //   550: aload 7
    //   552: iconst_2
    //   553: iload_3
    //   554: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   557: aastore
    //   558: aload 7
    //   560: iconst_3
    //   561: iconst_0
    //   562: invokestatic 501	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: aastore
    //   566: aload 8
    //   568: iconst_1
    //   569: invokevirtual 506	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   572: aload_0
    //   573: aload 8
    //   575: aload 7
    //   577: invokevirtual 510	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   580: checkcast 49	android/support/v7/widget/RecyclerView$LayoutManager
    //   583: invokevirtual 514	android/support/v7/widget/RecyclerView:setLayoutManager	(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V
    //   586: iload 5
    //   588: istore 4
    //   590: getstatic 214	android/os/Build$VERSION:SDK_INT	I
    //   593: bipush 21
    //   595: if_icmplt +26 -> 621
    //   598: aload_1
    //   599: aload_2
    //   600: getstatic 209	android/support/v7/widget/RecyclerView:NESTED_SCROLLING_ATTRS	[I
    //   603: iload_3
    //   604: iconst_0
    //   605: invokevirtual 431	android/content/Context:obtainStyledAttributes	(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
    //   608: astore_1
    //   609: aload_1
    //   610: iconst_0
    //   611: iconst_1
    //   612: invokevirtual 518	android/content/res/TypedArray:getBoolean	(IZ)Z
    //   615: istore 4
    //   617: aload_1
    //   618: invokevirtual 443	android/content/res/TypedArray:recycle	()V
    //   621: aload_0
    //   622: iload 4
    //   624: invokevirtual 521	android/support/v7/widget/RecyclerView:setNestedScrollingEnabled	(Z)V
    //   627: return
    //   628: iconst_0
    //   629: istore 4
    //   631: goto -376 -> 255
    //   634: iconst_0
    //   635: istore 4
    //   637: goto -332 -> 305
    //   640: aload 6
    //   642: ldc_w 523
    //   645: invokevirtual 527	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   648: ifeq +6 -> 654
    //   651: goto -157 -> 494
    //   654: new 458	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   661: ldc 2
    //   663: invokevirtual 531	java/lang/Class:getPackage	()Ljava/lang/Package;
    //   666: invokevirtual 536	java/lang/Package:getName	()Ljava/lang/String;
    //   669: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   672: bipush 46
    //   674: invokevirtual 539	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   677: aload 6
    //   679: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: astore 6
    //   687: goto -193 -> 494
    //   690: aload_1
    //   691: invokevirtual 540	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   694: astore 7
    //   696: goto -186 -> 510
    //   699: astore 7
    //   701: aload 9
    //   703: iconst_0
    //   704: anewarray 220	java/lang/Class
    //   707: invokevirtual 497	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   710: astore 8
    //   712: aconst_null
    //   713: astore 7
    //   715: goto -149 -> 566
    //   718: astore_1
    //   719: aload_1
    //   720: aload 7
    //   722: invokevirtual 544	java/lang/NoSuchMethodException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   725: pop
    //   726: new 546	java/lang/IllegalStateException
    //   729: dup
    //   730: new 458	java/lang/StringBuilder
    //   733: dup
    //   734: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   737: aload_2
    //   738: invokeinterface 549 1 0
    //   743: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: ldc_w 551
    //   749: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   752: aload 6
    //   754: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   760: aload_1
    //   761: invokespecial 554	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   764: athrow
    //   765: astore_1
    //   766: new 546	java/lang/IllegalStateException
    //   769: dup
    //   770: new 458	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   777: aload_2
    //   778: invokeinterface 549 1 0
    //   783: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: ldc_w 556
    //   789: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload 6
    //   794: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   800: aload_1
    //   801: invokespecial 554	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   804: athrow
    //   805: astore_1
    //   806: new 546	java/lang/IllegalStateException
    //   809: dup
    //   810: new 458	java/lang/StringBuilder
    //   813: dup
    //   814: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   817: aload_2
    //   818: invokeinterface 549 1 0
    //   823: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: ldc_w 558
    //   829: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   832: aload 6
    //   834: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   840: aload_1
    //   841: invokespecial 554	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   844: athrow
    //   845: astore_1
    //   846: new 546	java/lang/IllegalStateException
    //   849: dup
    //   850: new 458	java/lang/StringBuilder
    //   853: dup
    //   854: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   857: aload_2
    //   858: invokeinterface 549 1 0
    //   863: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: ldc_w 558
    //   869: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: aload 6
    //   874: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   877: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   880: aload_1
    //   881: invokespecial 554	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   884: athrow
    //   885: astore_1
    //   886: new 546	java/lang/IllegalStateException
    //   889: dup
    //   890: new 458	java/lang/StringBuilder
    //   893: dup
    //   894: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   897: aload_2
    //   898: invokeinterface 549 1 0
    //   903: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   906: ldc_w 560
    //   909: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   912: aload 6
    //   914: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   917: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   920: aload_1
    //   921: invokespecial 554	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   924: athrow
    //   925: astore_1
    //   926: new 546	java/lang/IllegalStateException
    //   929: dup
    //   930: new 458	java/lang/StringBuilder
    //   933: dup
    //   934: invokespecial 459	java/lang/StringBuilder:<init>	()V
    //   937: aload_2
    //   938: invokeinterface 549 1 0
    //   943: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: ldc_w 562
    //   949: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   952: aload 6
    //   954: invokevirtual 466	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   957: invokevirtual 469	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   960: aload_1
    //   961: invokespecial 554	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   964: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	965	0	this	RecyclerView
    //   0	965	1	paramContext	Context
    //   0	965	2	paramAttributeSet	AttributeSet
    //   0	965	3	paramInt	int
    //   253	383	4	bool1	boolean
    //   402	185	5	bool2	boolean
    //   265	688	6	localObject1	Object
    //   432	263	7	localObject2	Object
    //   699	1	7	localNoSuchMethodException	NoSuchMethodException
    //   713	8	7	localThrowable	Throwable
    //   532	179	8	localConstructor	java.lang.reflect.Constructor
    //   522	180	9	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   524	540	699	java/lang/NoSuchMethodException
    //   550	566	699	java/lang/NoSuchMethodException
    //   701	712	718	java/lang/NoSuchMethodException
    //   494	510	765	java/lang/ClassNotFoundException
    //   510	524	765	java/lang/ClassNotFoundException
    //   524	540	765	java/lang/ClassNotFoundException
    //   550	566	765	java/lang/ClassNotFoundException
    //   566	586	765	java/lang/ClassNotFoundException
    //   690	696	765	java/lang/ClassNotFoundException
    //   701	712	765	java/lang/ClassNotFoundException
    //   719	765	765	java/lang/ClassNotFoundException
    //   494	510	805	java/lang/reflect/InvocationTargetException
    //   510	524	805	java/lang/reflect/InvocationTargetException
    //   524	540	805	java/lang/reflect/InvocationTargetException
    //   550	566	805	java/lang/reflect/InvocationTargetException
    //   566	586	805	java/lang/reflect/InvocationTargetException
    //   690	696	805	java/lang/reflect/InvocationTargetException
    //   701	712	805	java/lang/reflect/InvocationTargetException
    //   719	765	805	java/lang/reflect/InvocationTargetException
    //   494	510	845	java/lang/InstantiationException
    //   510	524	845	java/lang/InstantiationException
    //   524	540	845	java/lang/InstantiationException
    //   550	566	845	java/lang/InstantiationException
    //   566	586	845	java/lang/InstantiationException
    //   690	696	845	java/lang/InstantiationException
    //   701	712	845	java/lang/InstantiationException
    //   719	765	845	java/lang/InstantiationException
    //   494	510	885	java/lang/IllegalAccessException
    //   510	524	885	java/lang/IllegalAccessException
    //   524	540	885	java/lang/IllegalAccessException
    //   550	566	885	java/lang/IllegalAccessException
    //   566	586	885	java/lang/IllegalAccessException
    //   690	696	885	java/lang/IllegalAccessException
    //   701	712	885	java/lang/IllegalAccessException
    //   719	765	885	java/lang/IllegalAccessException
    //   494	510	925	java/lang/ClassCastException
    //   510	524	925	java/lang/ClassCastException
    //   524	540	925	java/lang/ClassCastException
    //   550	566	925	java/lang/ClassCastException
    //   566	586	925	java/lang/ClassCastException
    //   690	696	925	java/lang/ClassCastException
    //   701	712	925	java/lang/ClassCastException
    //   719	765	925	java/lang/ClassCastException
  }
  
  private void addAnimatingView(ViewHolder paramViewHolder)
  {
    View localView = itemView;
    if (localView.getParent() == this) {}
    for (int i = 1;; i = 0)
    {
      mRecycler.unscrapView(getChildViewHolder(localView));
      if (!paramViewHolder.isTmpDetached()) {
        break;
      }
      mChildHelper.attachViewToParent(localView, -1, localView.getLayoutParams(), true);
      return;
    }
    if (i == 0)
    {
      mChildHelper.addView(localView, -1, true);
      return;
    }
    paramViewHolder = mChildHelper;
    i = mCallback.indexOfChild(localView);
    if (i < 0) {
      throw new IllegalArgumentException("view is not a child, cannot hide " + localView);
    }
    mBucket.set(i);
    paramViewHolder.hideViewInternal(localView);
  }
  
  private void cancelTouch()
  {
    resetTouch();
    setScrollState(0);
  }
  
  private void clearOldPositions()
  {
    int j = 0;
    int k = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < k)
    {
      localObject = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if (!((ViewHolder)localObject).shouldIgnore()) {
        ((ViewHolder)localObject).clearOldPosition();
      }
      i += 1;
    }
    Object localObject = mRecycler;
    k = mCachedViews.size();
    i = 0;
    while (i < k)
    {
      ((ViewHolder)mCachedViews.get(i)).clearOldPosition();
      i += 1;
    }
    k = mAttachedScrap.size();
    i = 0;
    while (i < k)
    {
      ((ViewHolder)mAttachedScrap.get(i)).clearOldPosition();
      i += 1;
    }
    if (mChangedScrap != null)
    {
      k = mChangedScrap.size();
      i = j;
      while (i < k)
      {
        ((ViewHolder)mChangedScrap.get(i)).clearOldPosition();
        i += 1;
      }
    }
  }
  
  private void considerReleasingGlowsOnScroll(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (mLeftGlow != null)
    {
      bool1 = bool2;
      if (!mLeftGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt1 > 0) {
          bool1 = mLeftGlow.onRelease();
        }
      }
    }
    bool2 = bool1;
    if (mRightGlow != null)
    {
      bool2 = bool1;
      if (!mRightGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt1 < 0) {
          bool2 = bool1 | mRightGlow.onRelease();
        }
      }
    }
    bool1 = bool2;
    if (mTopGlow != null)
    {
      bool1 = bool2;
      if (!mTopGlow.isFinished())
      {
        bool1 = bool2;
        if (paramInt2 > 0) {
          bool1 = bool2 | mTopGlow.onRelease();
        }
      }
    }
    bool2 = bool1;
    if (mBottomGlow != null)
    {
      bool2 = bool1;
      if (!mBottomGlow.isFinished())
      {
        bool2 = bool1;
        if (paramInt2 < 0) {
          bool2 = bool1 | mBottomGlow.onRelease();
        }
      }
    }
    if (bool2) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private void consumePendingUpdateOperations()
  {
    int k = 0;
    if (!mFirstLayoutComplete) {}
    label160:
    label167:
    do
    {
      do
      {
        return;
        if (mDataSetHasChangedAfterLayout)
        {
          TraceCompat.beginSection("RV FullInvalidate");
          dispatchLayout();
          TraceCompat.endSection();
          return;
        }
      } while (!mAdapterHelper.hasPendingUpdates());
      if ((mAdapterHelper.hasAnyUpdateTypes(4)) && (!mAdapterHelper.hasAnyUpdateTypes(11)))
      {
        TraceCompat.beginSection("RV PartialInvalidate");
        eatRequestLayout();
        mAdapterHelper.preProcess();
        int i;
        if (!mLayoutRequestEaten)
        {
          int m = mChildHelper.getChildCount();
          i = 0;
          int j = k;
          if (i < m)
          {
            ViewHolder localViewHolder = getChildViewHolderInt(mChildHelper.getChildAt(i));
            if ((localViewHolder == null) || (localViewHolder.shouldIgnore()) || (!localViewHolder.isUpdated())) {
              break label160;
            }
            j = 1;
          }
          if (j == 0) {
            break label167;
          }
          dispatchLayout();
        }
        for (;;)
        {
          resumeRequestLayout(true);
          TraceCompat.endSection();
          return;
          i += 1;
          break;
          mAdapterHelper.consumePostponedUpdates();
        }
      }
    } while (!mAdapterHelper.hasPendingUpdates());
    TraceCompat.beginSection("RV FullInvalidate");
    dispatchLayout();
    TraceCompat.endSection();
  }
  
  private void dispatchChildDetached(View paramView)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if ((mAdapter != null) && (localViewHolder != null)) {
      mAdapter.onViewDetachedFromWindow(localViewHolder);
    }
    if (mOnChildAttachStateListeners != null)
    {
      int i = mOnChildAttachStateListeners.size() - 1;
      while (i >= 0)
      {
        ((OnChildAttachStateChangeListener)mOnChildAttachStateListeners.get(i)).onChildViewDetachedFromWindow(paramView);
        i -= 1;
      }
    }
  }
  
  private void dispatchLayout()
  {
    if (mAdapter == null) {
      Log.e("RecyclerView", "No adapter attached; skipping layout");
    }
    for (;;)
    {
      return;
      if (mLayout == null)
      {
        Log.e("RecyclerView", "No layout manager attached; skipping layout");
        return;
      }
      mState.mIsMeasuring = false;
      Object localObject1;
      long l;
      RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo;
      ViewHolder localViewHolder;
      boolean bool1;
      boolean bool2;
      Object localObject2;
      int k;
      if (mState.mLayoutStep == 1)
      {
        dispatchLayoutStep1();
        mLayout.setExactMeasureSpecsFrom(this);
        dispatchLayoutStep2();
        mState.assertLayoutStep(4);
        eatRequestLayout();
        onEnterLayoutOrScroll();
        mState.mLayoutStep = 1;
        if (!mState.mRunSimpleAnimations) {
          break label668;
        }
        i = mChildHelper.getChildCount() - 1;
        if (i < 0) {
          break label657;
        }
        localObject1 = getChildViewHolderInt(mChildHelper.getChildAt(i));
        if (!((ViewHolder)localObject1).shouldIgnore())
        {
          l = getChangedHolderKey((ViewHolder)localObject1);
          localItemHolderInfo = new RecyclerView.ItemAnimator.ItemHolderInfo().setFrom((ViewHolder)localObject1);
          localViewHolder = (ViewHolder)mViewInfoStore.mOldChangedHolders.get(l);
          if ((localViewHolder == null) || (localViewHolder.shouldIgnore())) {
            break label643;
          }
          bool1 = mViewInfoStore.isDisappearing(localViewHolder);
          bool2 = mViewInfoStore.isDisappearing((ViewHolder)localObject1);
          if ((bool1) && (localViewHolder == localObject1)) {
            break label643;
          }
          localObject2 = mViewInfoStore.popFromLayoutStep(localViewHolder, 4);
          mViewInfoStore.addToPostLayout((ViewHolder)localObject1, localItemHolderInfo);
          localItemHolderInfo = mViewInfoStore.popFromLayoutStep((ViewHolder)localObject1, 8);
          if (localObject2 != null) {
            break label548;
          }
          k = mChildHelper.getChildCount();
          j = 0;
        }
      }
      else
      {
        for (;;)
        {
          if (j >= k) {
            break label505;
          }
          localObject2 = getChildViewHolderInt(mChildHelper.getChildAt(j));
          if ((localObject2 != localObject1) && (getChangedHolderKey((ViewHolder)localObject2) == l))
          {
            if ((mAdapter != null) && (mAdapter.hasStableIds()))
            {
              throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + localObject2 + " \n View Holder 2:" + localObject1);
              localObject1 = mAdapterHelper;
              if ((!mPostponedList.isEmpty()) && (!mPendingUpdates.isEmpty())) {}
              for (i = 1;; i = 0)
              {
                if ((i == 0) && (mLayout.mWidth == getWidth()) && (mLayout.mHeight == getHeight())) {
                  break label450;
                }
                mLayout.setExactMeasureSpecsFrom(this);
                dispatchLayoutStep2();
                break;
              }
              label450:
              mLayout.setExactMeasureSpecsFrom(this);
              break;
            }
            throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + localObject2 + " \n View Holder 2:" + localObject1);
          }
          j += 1;
        }
        label505:
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + localViewHolder + " cannot be found but it is necessary for " + localObject1);
      }
      for (;;)
      {
        i -= 1;
        break;
        label548:
        localViewHolder.setIsRecyclable(false);
        if (bool1) {
          addAnimatingView(localViewHolder);
        }
        if (localViewHolder != localObject1)
        {
          if (bool2) {
            addAnimatingView((ViewHolder)localObject1);
          }
          mShadowedHolder = ((ViewHolder)localObject1);
          addAnimatingView(localViewHolder);
          mRecycler.unscrapView(localViewHolder);
          ((ViewHolder)localObject1).setIsRecyclable(false);
          mShadowingHolder = localViewHolder;
        }
        if (mItemAnimator.animateChange(localViewHolder, (ViewHolder)localObject1, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject2, localItemHolderInfo))
        {
          postAnimationRunner();
          continue;
          label643:
          mViewInfoStore.addToPostLayout((ViewHolder)localObject1, localItemHolderInfo);
        }
      }
      label657:
      mViewInfoStore.process(mViewInfoProcessCallback);
      label668:
      mLayout.removeAndRecycleScrapInt(mRecycler);
      mState.mPreviousLayoutItemCount = mState.mItemCount;
      mDataSetHasChangedAfterLayout = false;
      mState.mRunSimpleAnimations = false;
      mState.mRunPredictiveAnimations = false;
      LayoutManager.access$2602$7217d4c(mLayout);
      if (mRecycler.mChangedScrap != null) {
        mRecycler.mChangedScrap.clear();
      }
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
      mViewInfoStore.clear();
      int i = mMinMaxLayoutPositions[0];
      int j = mMinMaxLayoutPositions[1];
      if (mChildHelper.getChildCount() == 0) {
        if ((i != 0) || (j != 0)) {
          i = 1;
        }
      }
      while (i != 0)
      {
        dispatchOnScrolled(0, 0);
        return;
        i = 0;
        continue;
        findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
        if ((mMinMaxLayoutPositions[0] != i) || (mMinMaxLayoutPositions[1] != j)) {
          i = 1;
        } else {
          i = 0;
        }
      }
    }
  }
  
  private void dispatchLayoutStep1()
  {
    mState.assertLayoutStep(1);
    mState.mIsMeasuring = false;
    eatRequestLayout();
    mViewInfoStore.clear();
    onEnterLayoutOrScroll();
    processAdapterUpdatesAndSetAnimationFlags();
    Object localObject1 = mState;
    if ((mState.mRunSimpleAnimations) && (mItemsChanged)) {}
    int j;
    int i;
    Object localObject2;
    for (boolean bool = true;; bool = false)
    {
      mTrackOldChangeHolders = bool;
      mItemsChanged = false;
      mItemsAddedOrRemoved = false;
      mState.mInPreLayout = mState.mRunPredictiveAnimations;
      mState.mItemCount = mAdapter.getItemCount();
      findMinMaxChildLayoutPositions(mMinMaxLayoutPositions);
      if (!mState.mRunSimpleAnimations) {
        break;
      }
      j = mChildHelper.getChildCount();
      i = 0;
      while (i < j)
      {
        localObject1 = getChildViewHolderInt(mChildHelper.getChildAt(i));
        if ((!((ViewHolder)localObject1).shouldIgnore()) && ((!((ViewHolder)localObject1).isInvalid()) || (mAdapter.hasStableIds())))
        {
          ItemAnimator.buildAdapterChangeFlagsForAnimations((ViewHolder)localObject1);
          ((ViewHolder)localObject1).getUnmodifiedPayloads();
          localObject2 = new RecyclerView.ItemAnimator.ItemHolderInfo().setFrom((ViewHolder)localObject1);
          mViewInfoStore.addToPreLayout((ViewHolder)localObject1, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject2);
          if ((mState.mTrackOldChangeHolders) && (((ViewHolder)localObject1).isUpdated()) && (!((ViewHolder)localObject1).isRemoved()) && (!((ViewHolder)localObject1).shouldIgnore()) && (!((ViewHolder)localObject1).isInvalid()))
          {
            long l = getChangedHolderKey((ViewHolder)localObject1);
            mViewInfoStore.addToOldChangeHolders(l, (ViewHolder)localObject1);
          }
        }
        i += 1;
      }
    }
    if (mState.mRunPredictiveAnimations)
    {
      j = mChildHelper.getUnfilteredChildCount();
      i = 0;
      while (i < j)
      {
        localObject1 = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
        if (!((ViewHolder)localObject1).shouldIgnore()) {
          ((ViewHolder)localObject1).saveOldPosition();
        }
        i += 1;
      }
      bool = mState.mStructureChanged;
      mState.mStructureChanged = false;
      mLayout.onLayoutChildren(mRecycler, mState);
      mState.mStructureChanged = bool;
      i = 0;
      if (i < mChildHelper.getChildCount())
      {
        ViewHolder localViewHolder = getChildViewHolderInt(mChildHelper.getChildAt(i));
        label451:
        RecyclerView.ItemAnimator.ItemHolderInfo localItemHolderInfo;
        if (!localViewHolder.shouldIgnore())
        {
          localObject1 = (ViewInfoStore.InfoRecord)mViewInfoStore.mLayoutHolderMap.get(localViewHolder);
          if ((localObject1 == null) || ((flags & 0x4) == 0)) {
            break label509;
          }
          j = 1;
          if (j == 0)
          {
            ItemAnimator.buildAdapterChangeFlagsForAnimations(localViewHolder);
            bool = localViewHolder.hasAnyOfTheFlags(8192);
            localViewHolder.getUnmodifiedPayloads();
            localItemHolderInfo = new RecyclerView.ItemAnimator.ItemHolderInfo().setFrom(localViewHolder);
            if (!bool) {
              break label514;
            }
            recordAnimationInfoIfBouncedHiddenView(localViewHolder, localItemHolderInfo);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label509:
          j = 0;
          break label451;
          label514:
          ViewInfoStore localViewInfoStore = mViewInfoStore;
          localObject2 = (ViewInfoStore.InfoRecord)mLayoutHolderMap.get(localViewHolder);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = ViewInfoStore.InfoRecord.obtain();
            mLayoutHolderMap.put(localViewHolder, localObject1);
          }
          flags |= 0x2;
          preInfo = localItemHolderInfo;
        }
      }
      clearOldPositions();
    }
    for (;;)
    {
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
      mState.mLayoutStep = 2;
      return;
      clearOldPositions();
    }
  }
  
  private void dispatchLayoutStep2()
  {
    eatRequestLayout();
    onEnterLayoutOrScroll();
    mState.assertLayoutStep(6);
    mAdapterHelper.consumeUpdatesInOnePass();
    mState.mItemCount = mAdapter.getItemCount();
    mState.mDeletedInvisibleItemCountSincePreviousLayout = 0;
    mState.mInPreLayout = false;
    mLayout.onLayoutChildren(mRecycler, mState);
    mState.mStructureChanged = false;
    mPendingSavedState = null;
    State localState = mState;
    if ((mState.mRunSimpleAnimations) && (mItemAnimator != null)) {}
    for (boolean bool = true;; bool = false)
    {
      mRunSimpleAnimations = bool;
      mState.mLayoutStep = 4;
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
      return;
    }
  }
  
  private void findMinMaxChildLayoutPositions(int[] paramArrayOfInt)
  {
    int i3 = mChildHelper.getChildCount();
    if (i3 == 0)
    {
      paramArrayOfInt[0] = 0;
      paramArrayOfInt[1] = 0;
      return;
    }
    int i = Integer.MAX_VALUE;
    int m = Integer.MIN_VALUE;
    int k = 0;
    while (k < i3)
    {
      ViewHolder localViewHolder = getChildViewHolderInt(mChildHelper.getChildAt(k));
      int i2 = m;
      int n = i;
      if (!localViewHolder.shouldIgnore())
      {
        int i1 = localViewHolder.getLayoutPosition();
        int j = i;
        if (i1 < i) {
          j = i1;
        }
        i2 = m;
        n = j;
        if (i1 > m)
        {
          n = j;
          i2 = i1;
        }
      }
      k += 1;
      m = i2;
      i = n;
    }
    paramArrayOfInt[0] = i;
    paramArrayOfInt[1] = m;
  }
  
  private long getChangedHolderKey(ViewHolder paramViewHolder)
  {
    if (mAdapter.hasStableIds()) {
      return paramViewHolder.getItemId();
    }
    return mPosition;
  }
  
  public static int getChildAdapterPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getAdapterPosition();
    }
    return -1;
  }
  
  public static int getChildLayoutPosition(View paramView)
  {
    paramView = getChildViewHolderInt(paramView);
    if (paramView != null) {
      return paramView.getLayoutPosition();
    }
    return -1;
  }
  
  public static ViewHolder getChildViewHolderInt(View paramView)
  {
    if (paramView == null) {
      return null;
    }
    return getLayoutParamsmViewHolder;
  }
  
  private float getScrollFactor()
  {
    if (mScrollFactor == Float.MIN_VALUE)
    {
      TypedValue localTypedValue = new TypedValue();
      if (getContext().getTheme().resolveAttribute(16842829, localTypedValue, true)) {
        mScrollFactor = localTypedValue.getDimension(getContext().getResources().getDisplayMetrics());
      }
    }
    else
    {
      return mScrollFactor;
    }
    return 0.0F;
  }
  
  private NestedScrollingChildHelper getScrollingChildHelper()
  {
    if (mScrollingChildHelper == null) {
      mScrollingChildHelper = new NestedScrollingChildHelper(this);
    }
    return mScrollingChildHelper;
  }
  
  private void invalidateGlows()
  {
    mBottomGlow = null;
    mTopGlow = null;
    mRightGlow = null;
    mLeftGlow = null;
  }
  
  private boolean isComputingLayout()
  {
    return mLayoutOrScrollCounter > 0;
  }
  
  private void markKnownViewsInvalid()
  {
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      localObject = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if ((localObject != null) && (!((ViewHolder)localObject).shouldIgnore())) {
        ((ViewHolder)localObject).addFlags(6);
      }
      i += 1;
    }
    markItemDecorInsetsDirty();
    Object localObject = mRecycler;
    if ((this$0.mAdapter != null) && (this$0.mAdapter.hasStableIds()))
    {
      j = mCachedViews.size();
      i = 0;
    }
    while (i < j)
    {
      ViewHolder localViewHolder = (ViewHolder)mCachedViews.get(i);
      if (localViewHolder != null)
      {
        localViewHolder.addFlags(6);
        localViewHolder.addChangePayload(null);
      }
      i += 1;
      continue;
      ((Recycler)localObject).recycleAndClearCachedViews();
    }
  }
  
  private void onEnterLayoutOrScroll()
  {
    mLayoutOrScrollCounter += 1;
  }
  
  private void onExitLayoutOrScroll()
  {
    mLayoutOrScrollCounter -= 1;
    if (mLayoutOrScrollCounter <= 0)
    {
      mLayoutOrScrollCounter = 0;
      int i = mEatenAccessibilityChangeFlags;
      mEatenAccessibilityChangeFlags = 0;
      if ((i != 0) && (isAccessibilityEnabled()))
      {
        AccessibilityEvent localAccessibilityEvent = AccessibilityEvent.obtain();
        localAccessibilityEvent.setEventType(2048);
        AccessibilityEventCompat.setContentChangeTypes(localAccessibilityEvent, i);
        sendAccessibilityEventUnchecked(localAccessibilityEvent);
      }
    }
  }
  
  private void onPointerUp(MotionEvent paramMotionEvent)
  {
    int i = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (MotionEventCompat.getPointerId(paramMotionEvent, i) == mScrollPointerId) {
      if (i != 0) {
        break label75;
      }
    }
    label75:
    for (i = 1;; i = 0)
    {
      mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      int j = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
      mLastTouchX = j;
      mInitialTouchX = j;
      i = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
      mLastTouchY = i;
      mInitialTouchY = i;
      return;
    }
  }
  
  private void postAnimationRunner()
  {
    if ((!mPostedAnimatorRunner) && (mIsAttached))
    {
      ViewCompat.postOnAnimation(this, mItemAnimatorRunner);
      mPostedAnimatorRunner = true;
    }
  }
  
  private boolean predictiveItemAnimationsEnabled()
  {
    return (mItemAnimator != null) && (mLayout.supportsPredictiveItemAnimations());
  }
  
  private void processAdapterUpdatesAndSetAnimationFlags()
  {
    boolean bool2 = true;
    if (mDataSetHasChangedAfterLayout)
    {
      mAdapterHelper.reset();
      markKnownViewsInvalid();
      mLayout.onItemsChanged$57043c5d();
    }
    int i;
    label57:
    State localState;
    if (predictiveItemAnimationsEnabled())
    {
      mAdapterHelper.preProcess();
      if ((!mItemsAddedOrRemoved) && (!mItemsChanged)) {
        break label176;
      }
      i = 1;
      localState = mState;
      if ((!mFirstLayoutComplete) || (mItemAnimator == null) || ((!mDataSetHasChangedAfterLayout) && (i == 0) && (!mLayout.mRequestedSimpleAnimations)) || ((mDataSetHasChangedAfterLayout) && (!mAdapter.hasStableIds()))) {
        break label181;
      }
      bool1 = true;
      label117:
      mRunSimpleAnimations = bool1;
      localState = mState;
      if ((!mState.mRunSimpleAnimations) || (i == 0) || (mDataSetHasChangedAfterLayout) || (!predictiveItemAnimationsEnabled())) {
        break label186;
      }
    }
    label176:
    label181:
    label186:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      mRunPredictiveAnimations = bool1;
      return;
      mAdapterHelper.consumeUpdatesInOnePass();
      break;
      i = 0;
      break label57;
      bool1 = false;
      break label117;
    }
  }
  
  private void recordAnimationInfoIfBouncedHiddenView(ViewHolder paramViewHolder, RecyclerView.ItemAnimator.ItemHolderInfo paramItemHolderInfo)
  {
    paramViewHolder.setFlags(0, 8192);
    if ((mState.mTrackOldChangeHolders) && (paramViewHolder.isUpdated()) && (!paramViewHolder.isRemoved()) && (!paramViewHolder.shouldIgnore()))
    {
      long l = getChangedHolderKey(paramViewHolder);
      mViewInfoStore.addToOldChangeHolders(l, paramViewHolder);
    }
    mViewInfoStore.addToPreLayout(paramViewHolder, paramItemHolderInfo);
  }
  
  private void repositionShadowingViews()
  {
    int j = mChildHelper.getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = mChildHelper.getChildAt(i);
      Object localObject = getChildViewHolder(localView);
      if ((localObject != null) && (mShadowingHolder != null))
      {
        localObject = mShadowingHolder.itemView;
        int k = localView.getLeft();
        int m = localView.getTop();
        if ((k != ((View)localObject).getLeft()) || (m != ((View)localObject).getTop())) {
          ((View)localObject).layout(k, m, ((View)localObject).getWidth() + k, ((View)localObject).getHeight() + m);
        }
      }
      i += 1;
    }
  }
  
  private void resetTouch()
  {
    if (mVelocityTracker != null) {
      mVelocityTracker.clear();
    }
    stopNestedScroll();
    boolean bool2 = false;
    if (mLeftGlow != null) {
      bool2 = mLeftGlow.onRelease();
    }
    boolean bool1 = bool2;
    if (mTopGlow != null) {
      bool1 = bool2 | mTopGlow.onRelease();
    }
    bool2 = bool1;
    if (mRightGlow != null) {
      bool2 = bool1 | mRightGlow.onRelease();
    }
    bool1 = bool2;
    if (mBottomGlow != null) {
      bool1 = bool2 | mBottomGlow.onRelease();
    }
    if (bool1) {
      ViewCompat.postInvalidateOnAnimation(this);
    }
  }
  
  private boolean scrollByInternal(int paramInt1, int paramInt2, MotionEvent paramMotionEvent)
  {
    int j = 0;
    int i3 = 0;
    int n = 0;
    int i1 = 0;
    int k = 0;
    int i = 0;
    int m = 0;
    int i2 = 0;
    consumePendingUpdateOperations();
    if (mAdapter != null)
    {
      eatRequestLayout();
      onEnterLayoutOrScroll();
      TraceCompat.beginSection("RV Scroll");
      j = i3;
      if (paramInt1 != 0)
      {
        i = mLayout.scrollHorizontallyBy(paramInt1, mRecycler, mState);
        j = paramInt1 - i;
      }
      k = i2;
      m = i1;
      if (paramInt2 != 0)
      {
        k = mLayout.scrollVerticallyBy(paramInt2, mRecycler, mState);
        m = paramInt2 - k;
      }
      TraceCompat.endSection();
      repositionShadowingViews();
      onExitLayoutOrScroll();
      resumeRequestLayout(false);
      n = m;
      m = k;
      k = i;
    }
    if (!mItemDecorations.isEmpty()) {
      invalidate();
    }
    if (dispatchNestedScroll(k, m, j, n, mScrollOffset))
    {
      mLastTouchX -= mScrollOffset[0];
      mLastTouchY -= mScrollOffset[1];
      if (paramMotionEvent != null) {
        paramMotionEvent.offsetLocation(mScrollOffset[0], mScrollOffset[1]);
      }
      paramMotionEvent = mNestedOffsets;
      paramMotionEvent[0] += mScrollOffset[0];
      paramMotionEvent = mNestedOffsets;
      paramMotionEvent[1] += mScrollOffset[1];
    }
    while (ViewCompat.getOverScrollMode(this) == 2)
    {
      if ((k != 0) || (m != 0)) {
        dispatchOnScrolled(k, m);
      }
      if (!awakenScrollBars()) {
        invalidate();
      }
      if ((k == 0) && (m == 0)) {
        break;
      }
      return true;
    }
    float f1;
    float f2;
    float f3;
    float f4;
    if (paramMotionEvent != null)
    {
      f1 = paramMotionEvent.getX();
      f2 = j;
      f3 = paramMotionEvent.getY();
      f4 = n;
      j = 0;
      if (f2 >= 0.0F) {
        break label468;
      }
      ensureLeftGlow();
      i = j;
      if (mLeftGlow.onPull(-f2 / getWidth(), 1.0F - f3 / getHeight())) {
        i = 1;
      }
      label391:
      if (f4 >= 0.0F) {
        break label519;
      }
      ensureTopGlow();
      j = i;
      if (mTopGlow.onPull(-f4 / getHeight(), f1 / getWidth())) {
        j = 1;
      }
    }
    for (;;)
    {
      if ((j != 0) || (f2 != 0.0F) || (f4 != 0.0F)) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      considerReleasingGlowsOnScroll(paramInt1, paramInt2);
      break;
      label468:
      i = j;
      if (f2 <= 0.0F) {
        break label391;
      }
      ensureRightGlow();
      i = j;
      if (!mRightGlow.onPull(f2 / getWidth(), f3 / getHeight())) {
        break label391;
      }
      i = 1;
      break label391;
      label519:
      j = i;
      if (f4 > 0.0F)
      {
        ensureBottomGlow();
        j = i;
        if (mBottomGlow.onPull(f4 / getHeight(), 1.0F - f1 / getWidth())) {
          j = 1;
        }
      }
    }
    return false;
  }
  
  private void setScrollState(int paramInt)
  {
    if (paramInt == mScrollState) {}
    for (;;)
    {
      return;
      mScrollState = paramInt;
      if (paramInt != 2) {
        stopScrollersInternal();
      }
      if (mLayout != null) {
        mLayout.onScrollStateChanged(paramInt);
      }
      onScrollStateChanged(paramInt);
      if (mScrollListener != null) {
        mScrollListener.onScrollStateChanged(this, paramInt);
      }
      if (mScrollListeners != null)
      {
        int i = mScrollListeners.size() - 1;
        while (i >= 0)
        {
          ((OnScrollListener)mScrollListeners.get(i)).onScrollStateChanged(this, paramInt);
          i -= 1;
        }
      }
    }
  }
  
  private void stopScrollersInternal()
  {
    mViewFlinger.stop();
    if (mLayout != null) {
      mLayout.stopSmoothScroller();
    }
  }
  
  public void addFocusables(ArrayList<View> paramArrayList, int paramInt1, int paramInt2)
  {
    super.addFocusables(paramArrayList, paramInt1, paramInt2);
  }
  
  public final void addItemDecoration(ItemDecoration paramItemDecoration)
  {
    if (mLayout != null) {
      mLayout.assertNotInLayoutOrScroll("Cannot add item decoration during a scroll  or layout");
    }
    if (mItemDecorations.isEmpty()) {
      setWillNotDraw(false);
    }
    mItemDecorations.add(paramItemDecoration);
    markItemDecorInsetsDirty();
    requestLayout();
  }
  
  public final void addOnChildAttachStateChangeListener(OnChildAttachStateChangeListener paramOnChildAttachStateChangeListener)
  {
    if (mOnChildAttachStateListeners == null) {
      mOnChildAttachStateListeners = new ArrayList();
    }
    mOnChildAttachStateListeners.add(paramOnChildAttachStateChangeListener);
  }
  
  public final void addOnItemTouchListener(OnItemTouchListener paramOnItemTouchListener)
  {
    mOnItemTouchListeners.add(paramOnItemTouchListener);
  }
  
  public final void addOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    if (mScrollListeners == null) {
      mScrollListeners = new ArrayList();
    }
    mScrollListeners.add(paramOnScrollListener);
  }
  
  final void assertNotInLayoutOrScroll(String paramString)
  {
    if (isComputingLayout())
    {
      if (paramString == null) {
        throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling");
      }
      throw new IllegalStateException(paramString);
    }
  }
  
  protected boolean checkLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    return ((paramLayoutParams instanceof LayoutParams)) && (mLayout.checkLayoutParams((LayoutParams)paramLayoutParams));
  }
  
  public final void clearOnScrollListeners()
  {
    if (mScrollListeners != null) {
      mScrollListeners.clear();
    }
  }
  
  public int computeHorizontalScrollExtent()
  {
    if (mLayout == null) {}
    while (!mLayout.canScrollHorizontally()) {
      return 0;
    }
    return mLayout.computeHorizontalScrollExtent(mState);
  }
  
  public int computeHorizontalScrollOffset()
  {
    if (mLayout == null) {}
    while (!mLayout.canScrollHorizontally()) {
      return 0;
    }
    return mLayout.computeHorizontalScrollOffset(mState);
  }
  
  public int computeHorizontalScrollRange()
  {
    if (mLayout == null) {}
    while (!mLayout.canScrollHorizontally()) {
      return 0;
    }
    return mLayout.computeHorizontalScrollRange(mState);
  }
  
  public int computeVerticalScrollExtent()
  {
    if (mLayout == null) {}
    while (!mLayout.canScrollVertically()) {
      return 0;
    }
    return mLayout.computeVerticalScrollExtent(mState);
  }
  
  public int computeVerticalScrollOffset()
  {
    if (mLayout == null) {}
    while (!mLayout.canScrollVertically()) {
      return 0;
    }
    return mLayout.computeVerticalScrollOffset(mState);
  }
  
  public int computeVerticalScrollRange()
  {
    if (mLayout == null) {}
    while (!mLayout.canScrollVertically()) {
      return 0;
    }
    return mLayout.computeVerticalScrollRange(mState);
  }
  
  final void defaultOnMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(LayoutManager.chooseSize(paramInt1, getPaddingLeft() + getPaddingRight(), ViewCompat.getMinimumWidth(this)), LayoutManager.chooseSize(paramInt2, getPaddingTop() + getPaddingBottom(), ViewCompat.getMinimumHeight(this)));
  }
  
  public boolean dispatchNestedFling(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    return getScrollingChildHelper().dispatchNestedFling(paramFloat1, paramFloat2, paramBoolean);
  }
  
  public boolean dispatchNestedPreFling(float paramFloat1, float paramFloat2)
  {
    return getScrollingChildHelper().dispatchNestedPreFling(paramFloat1, paramFloat2);
  }
  
  public boolean dispatchNestedPreScroll(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    return getScrollingChildHelper().dispatchNestedPreScroll(paramInt1, paramInt2, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public boolean dispatchNestedScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt)
  {
    return getScrollingChildHelper().dispatchNestedScroll(paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfInt);
  }
  
  final void dispatchOnScrolled(int paramInt1, int paramInt2)
  {
    int i = getScrollX();
    int j = getScrollY();
    onScrollChanged(i, j, i, j);
    if (mScrollListener != null) {
      mScrollListener.onScrolled(this, paramInt1, paramInt2);
    }
    if (mScrollListeners != null)
    {
      i = mScrollListeners.size() - 1;
      while (i >= 0)
      {
        ((OnScrollListener)mScrollListeners.get(i)).onScrolled(this, paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  protected void dispatchRestoreInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchThawSelfOnly(paramSparseArray);
  }
  
  protected void dispatchSaveInstanceState(SparseArray<Parcelable> paramSparseArray)
  {
    dispatchFreezeSelfOnly(paramSparseArray);
  }
  
  public void draw(Canvas paramCanvas)
  {
    int k = 1;
    super.draw(paramCanvas);
    int j = mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((ItemDecoration)mItemDecorations.get(i)).onDrawOver$13fcd2ff(paramCanvas, this);
      i += 1;
    }
    i = 0;
    j = i;
    int m;
    if (mLeftGlow != null)
    {
      j = i;
      if (!mLeftGlow.isFinished())
      {
        m = paramCanvas.save();
        if (!mClipToPadding) {
          break label452;
        }
        i = getPaddingBottom();
        paramCanvas.rotate(270.0F);
        paramCanvas.translate(-getHeight() + i, 0.0F);
        if ((mLeftGlow == null) || (!mLeftGlow.draw(paramCanvas))) {
          break label457;
        }
        j = 1;
        label127:
        paramCanvas.restoreToCount(m);
      }
    }
    i = j;
    if (mTopGlow != null)
    {
      i = j;
      if (!mTopGlow.isFinished())
      {
        m = paramCanvas.save();
        if (mClipToPadding) {
          paramCanvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if ((mTopGlow == null) || (!mTopGlow.draw(paramCanvas))) {
          break label462;
        }
        i = 1;
        label201:
        i = j | i;
        paramCanvas.restoreToCount(m);
      }
    }
    j = i;
    if (mRightGlow != null)
    {
      j = i;
      if (!mRightGlow.isFinished())
      {
        m = paramCanvas.save();
        int n = getWidth();
        if (!mClipToPadding) {
          break label467;
        }
        j = getPaddingTop();
        label256:
        paramCanvas.rotate(90.0F);
        paramCanvas.translate(-j, -n);
        if ((mRightGlow == null) || (!mRightGlow.draw(paramCanvas))) {
          break label472;
        }
        j = 1;
        label294:
        j = i | j;
        paramCanvas.restoreToCount(m);
      }
    }
    i = j;
    if (mBottomGlow != null)
    {
      i = j;
      if (!mBottomGlow.isFinished())
      {
        m = paramCanvas.save();
        paramCanvas.rotate(180.0F);
        if (!mClipToPadding) {
          break label477;
        }
        paramCanvas.translate(-getWidth() + getPaddingRight(), -getHeight() + getPaddingBottom());
        label371:
        if ((mBottomGlow == null) || (!mBottomGlow.draw(paramCanvas))) {
          break label496;
        }
      }
    }
    label452:
    label457:
    label462:
    label467:
    label472:
    label477:
    label496:
    for (i = k;; i = 0)
    {
      i = j | i;
      paramCanvas.restoreToCount(m);
      j = i;
      if (i == 0)
      {
        j = i;
        if (mItemAnimator != null)
        {
          j = i;
          if (mItemDecorations.size() > 0)
          {
            j = i;
            if (mItemAnimator.isRunning()) {
              j = 1;
            }
          }
        }
      }
      if (j != 0) {
        ViewCompat.postInvalidateOnAnimation(this);
      }
      return;
      i = 0;
      break;
      j = 0;
      break label127;
      i = 0;
      break label201;
      j = 0;
      break label256;
      j = 0;
      break label294;
      paramCanvas.translate(-getWidth(), -getHeight());
      break label371;
    }
  }
  
  public boolean drawChild(Canvas paramCanvas, View paramView, long paramLong)
  {
    return super.drawChild(paramCanvas, paramView, paramLong);
  }
  
  final void eatRequestLayout()
  {
    mEatRequestLayout += 1;
    if ((mEatRequestLayout == 1) && (!mLayoutFrozen)) {
      mLayoutRequestEaten = false;
    }
  }
  
  final void ensureBottomGlow()
  {
    if (mBottomGlow != null) {
      return;
    }
    mBottomGlow = new EdgeEffectCompat(getContext());
    if (mClipToPadding)
    {
      mBottomGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    mBottomGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  final void ensureLeftGlow()
  {
    if (mLeftGlow != null) {
      return;
    }
    mLeftGlow = new EdgeEffectCompat(getContext());
    if (mClipToPadding)
    {
      mLeftGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    mLeftGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  final void ensureRightGlow()
  {
    if (mRightGlow != null) {
      return;
    }
    mRightGlow = new EdgeEffectCompat(getContext());
    if (mClipToPadding)
    {
      mRightGlow.setSize(getMeasuredHeight() - getPaddingTop() - getPaddingBottom(), getMeasuredWidth() - getPaddingLeft() - getPaddingRight());
      return;
    }
    mRightGlow.setSize(getMeasuredHeight(), getMeasuredWidth());
  }
  
  final void ensureTopGlow()
  {
    if (mTopGlow != null) {
      return;
    }
    mTopGlow = new EdgeEffectCompat(getContext());
    if (mClipToPadding)
    {
      mTopGlow.setSize(getMeasuredWidth() - getPaddingLeft() - getPaddingRight(), getMeasuredHeight() - getPaddingTop() - getPaddingBottom());
      return;
    }
    mTopGlow.setSize(getMeasuredWidth(), getMeasuredHeight());
  }
  
  public boolean fling(int paramInt1, int paramInt2)
  {
    if (mLayout == null) {
      Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
    }
    boolean bool2;
    int i;
    do
    {
      do
      {
        return false;
      } while (mLayoutFrozen);
      bool1 = mLayout.canScrollHorizontally();
      bool2 = mLayout.canScrollVertically();
      if (bool1)
      {
        i = paramInt1;
        if (Math.abs(paramInt1) >= mMinFlingVelocity) {}
      }
      else
      {
        i = 0;
      }
      if (bool2)
      {
        paramInt1 = paramInt2;
        if (Math.abs(paramInt2) >= mMinFlingVelocity) {}
      }
      else
      {
        paramInt1 = 0;
      }
    } while (((i == 0) && (paramInt1 == 0)) || (dispatchNestedPreFling(i, paramInt1)));
    if ((bool1) || (bool2)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      dispatchNestedFling(i, paramInt1, bool1);
      if (!bool1) {
        break;
      }
      paramInt2 = Math.max(-mMaxFlingVelocity, Math.min(i, mMaxFlingVelocity));
      paramInt1 = Math.max(-mMaxFlingVelocity, Math.min(paramInt1, mMaxFlingVelocity));
      ViewFlinger localViewFlinger = mViewFlinger;
      this$0.setScrollState(2);
      mLastFlingY = 0;
      mLastFlingX = 0;
      mScroller.fling$69c647f5(0, paramInt2, paramInt1, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
      localViewFlinger.postOnAnimation();
      return true;
    }
  }
  
  public View focusSearch(View paramView, int paramInt)
  {
    View localView2 = FocusFinder.getInstance().findNextFocus(this, paramView, paramInt);
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = localView2;
      if (mAdapter != null)
      {
        localView1 = localView2;
        if (mLayout != null)
        {
          localView1 = localView2;
          if (!isComputingLayout())
          {
            localView1 = localView2;
            if (!mLayoutFrozen)
            {
              eatRequestLayout();
              localView1 = mLayout.onFocusSearchFailed(paramView, paramInt, mRecycler, mState);
              resumeRequestLayout(false);
            }
          }
        }
      }
    }
    if (localView1 != null) {
      return localView1;
    }
    return super.focusSearch(paramView, paramInt);
  }
  
  protected ViewGroup.LayoutParams generateDefaultLayoutParams()
  {
    if (mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return mLayout.generateDefaultLayoutParams();
  }
  
  public ViewGroup.LayoutParams generateLayoutParams(AttributeSet paramAttributeSet)
  {
    if (mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return mLayout.generateLayoutParams(getContext(), paramAttributeSet);
  }
  
  protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    if (mLayout == null) {
      throw new IllegalStateException("RecyclerView has no LayoutManager");
    }
    return mLayout.generateLayoutParams(paramLayoutParams);
  }
  
  public Adapter getAdapter()
  {
    return mAdapter;
  }
  
  public final int getAdapterPositionFor(ViewHolder paramViewHolder)
  {
    int i;
    if ((paramViewHolder.hasAnyOfTheFlags(524)) || (!paramViewHolder.isBound())) {
      i = -1;
    }
    AdapterHelper localAdapterHelper;
    int j;
    int n;
    int m;
    do
    {
      return i;
      localAdapterHelper = mAdapterHelper;
      j = mPosition;
      n = mPendingUpdates.size();
      m = 0;
      i = j;
    } while (m >= n);
    paramViewHolder = (AdapterHelper.UpdateOp)mPendingUpdates.get(m);
    switch (cmd)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      m += 1;
      j = i;
      break;
      i = j;
      if (positionStart <= j)
      {
        i = j + itemCount;
        continue;
        i = j;
        if (positionStart <= j)
        {
          if (positionStart + itemCount > j) {
            return -1;
          }
          i = j - itemCount;
          continue;
          if (positionStart == j)
          {
            i = itemCount;
          }
          else
          {
            int k = j;
            if (positionStart < j) {
              k = j - 1;
            }
            i = k;
            if (itemCount <= k) {
              i = k + 1;
            }
          }
        }
      }
    }
  }
  
  public int getBaseline()
  {
    if (mLayout != null) {
      return -1;
    }
    return super.getBaseline();
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    if (mChildDrawingOrderCallback == null) {
      return super.getChildDrawingOrder(paramInt1, paramInt2);
    }
    return mChildDrawingOrderCallback.onGetChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public final ViewHolder getChildViewHolder(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent != null) && (localViewParent != this)) {
      throw new IllegalArgumentException("View " + paramView + " is not a direct child of " + this);
    }
    return getChildViewHolderInt(paramView);
  }
  
  public RecyclerViewAccessibilityDelegate getCompatAccessibilityDelegate()
  {
    return mAccessibilityDelegate;
  }
  
  public ItemAnimator getItemAnimator()
  {
    return mItemAnimator;
  }
  
  final Rect getItemDecorInsetsForChild(View paramView)
  {
    LayoutParams localLayoutParams = (LayoutParams)paramView.getLayoutParams();
    if (!mInsetsDirty) {
      return mDecorInsets;
    }
    Rect localRect = mDecorInsets;
    localRect.set(0, 0, 0, 0);
    int j = mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      mTempRect.set(0, 0, 0, 0);
      ((ItemDecoration)mItemDecorations.get(i)).getItemOffsets(mTempRect, paramView, this, mState);
      left += mTempRect.left;
      top += mTempRect.top;
      right += mTempRect.right;
      bottom += mTempRect.bottom;
      i += 1;
    }
    mInsetsDirty = false;
    return localRect;
  }
  
  public LayoutManager getLayoutManager()
  {
    return mLayout;
  }
  
  public int getMaxFlingVelocity()
  {
    return mMaxFlingVelocity;
  }
  
  public int getMinFlingVelocity()
  {
    return mMinFlingVelocity;
  }
  
  public RecycledViewPool getRecycledViewPool()
  {
    return mRecycler.getRecycledViewPool();
  }
  
  public int getScrollState()
  {
    return mScrollState;
  }
  
  public boolean hasNestedScrollingParent()
  {
    return getScrollingChildHelper().hasNestedScrollingParent();
  }
  
  final boolean isAccessibilityEnabled()
  {
    return (mAccessibilityManager != null) && (mAccessibilityManager.isEnabled());
  }
  
  public boolean isAttachedToWindow()
  {
    return mIsAttached;
  }
  
  public boolean isNestedScrollingEnabled()
  {
    return getScrollingChildHelpermIsNestedScrollingEnabled;
  }
  
  public final void markItemDecorInsetsDirty()
  {
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    while (i < j)
    {
      mChildHelper.getUnfilteredChildAt(i).getLayoutParams()).mInsetsDirty = true;
      i += 1;
    }
    Recycler localRecycler = mRecycler;
    j = mCachedViews.size();
    i = 0;
    while (i < j)
    {
      LayoutParams localLayoutParams = (LayoutParams)mCachedViews.get(i)).itemView.getLayoutParams();
      if (localLayoutParams != null) {
        mInsetsDirty = true;
      }
      i += 1;
    }
  }
  
  final void offsetPositionRecordsForRemove(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    int j = mChildHelper.getUnfilteredChildCount();
    int i = 0;
    if (i < j)
    {
      localObject = getChildViewHolderInt(mChildHelper.getUnfilteredChildAt(i));
      if ((localObject != null) && (!((ViewHolder)localObject).shouldIgnore()))
      {
        if (mPosition < paramInt1 + paramInt2) {
          break label82;
        }
        ((ViewHolder)localObject).offsetPosition(-paramInt2, paramBoolean);
        mState.mStructureChanged = true;
      }
      for (;;)
      {
        i += 1;
        break;
        label82:
        if (mPosition >= paramInt1)
        {
          ((ViewHolder)localObject).flagRemovedAndOffsetPosition(paramInt1 - 1, -paramInt2, paramBoolean);
          mState.mStructureChanged = true;
        }
      }
    }
    Object localObject = mRecycler;
    i = mCachedViews.size() - 1;
    if (i >= 0)
    {
      ViewHolder localViewHolder = (ViewHolder)mCachedViews.get(i);
      if (localViewHolder != null)
      {
        if (mPosition < paramInt1 + paramInt2) {
          break label184;
        }
        localViewHolder.offsetPosition(-paramInt2, paramBoolean);
      }
      for (;;)
      {
        i -= 1;
        break;
        label184:
        if (mPosition >= paramInt1)
        {
          localViewHolder.addFlags(8);
          ((Recycler)localObject).recycleCachedViewAt(i);
        }
      }
    }
    requestLayout();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    mLayoutOrScrollCounter = 0;
    mIsAttached = true;
    mFirstLayoutComplete = false;
    if (mLayout != null) {
      mLayout.mIsAttachedToWindow = true;
    }
    mPostedAnimatorRunner = false;
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (mItemAnimator != null) {
      mItemAnimator.endAnimations();
    }
    mFirstLayoutComplete = false;
    stopScroll();
    mIsAttached = false;
    if (mLayout != null) {
      mLayout.dispatchDetachedFromWindow(this, mRecycler);
    }
    removeCallbacks(mItemAnimatorRunner);
    ViewInfoStore.InfoRecord.drainCache();
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = mItemDecorations.size();
    int i = 0;
    while (i < j)
    {
      ((ItemDecoration)mItemDecorations.get(i)).onDraw$13fcd2ff(paramCanvas, this);
      i += 1;
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (mLayout == null) {}
    label110:
    label113:
    for (;;)
    {
      return false;
      if ((!mLayoutFrozen) && ((MotionEventCompat.getSource(paramMotionEvent) & 0x2) != 0) && (paramMotionEvent.getAction() == 8))
      {
        float f1;
        if (mLayout.canScrollVertically())
        {
          f1 = -MotionEventCompat.getAxisValue(paramMotionEvent, 9);
          if (!mLayout.canScrollHorizontally()) {
            break label110;
          }
        }
        for (float f2 = MotionEventCompat.getAxisValue(paramMotionEvent, 10);; f2 = 0.0F)
        {
          if ((f1 == 0.0F) && (f2 == 0.0F)) {
            break label113;
          }
          float f3 = getScrollFactor();
          scrollByInternal((int)(f2 * f3), (int)(f1 * f3), paramMotionEvent);
          return false;
          f1 = 0.0F;
          break;
        }
      }
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (mLayoutFrozen) {
      return false;
    }
    int j = paramMotionEvent.getAction();
    if ((j == 3) || (j == 0)) {
      mActiveOnItemTouchListener = null;
    }
    int k = mOnItemTouchListeners.size();
    int i = 0;
    if (i < k)
    {
      OnItemTouchListener localOnItemTouchListener = (OnItemTouchListener)mOnItemTouchListeners.get(i);
      if ((localOnItemTouchListener.onInterceptTouchEvent(this, paramMotionEvent)) && (j != 3)) {
        mActiveOnItemTouchListener = localOnItemTouchListener;
      }
    }
    for (i = 1;; i = 0)
    {
      if (i == 0) {
        break label105;
      }
      cancelTouch();
      return true;
      i += 1;
      break;
    }
    label105:
    if (mLayout == null) {
      return false;
    }
    boolean bool1 = mLayout.canScrollHorizontally();
    boolean bool2 = mLayout.canScrollVertically();
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    mVelocityTracker.addMovement(paramMotionEvent);
    j = MotionEventCompat.getActionMasked(paramMotionEvent);
    i = MotionEventCompat.getActionIndex(paramMotionEvent);
    switch (j)
    {
    }
    while (mScrollState == 1)
    {
      return true;
      if (mIgnoreMotionEventTillDown) {
        mIgnoreMotionEventTillDown = false;
      }
      mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      mLastTouchX = i;
      mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      mLastTouchY = i;
      mInitialTouchY = i;
      if (mScrollState == 2)
      {
        getParent().requestDisallowInterceptTouchEvent(true);
        setScrollState(1);
      }
      paramMotionEvent = mNestedOffsets;
      mNestedOffsets[1] = 0;
      paramMotionEvent[0] = 0;
      i = 0;
      if (bool1) {
        i = 1;
      }
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j);
      continue;
      mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, i);
      j = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
      mLastTouchX = j;
      mInitialTouchX = j;
      i = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
      mLastTouchY = i;
      mInitialTouchY = i;
      continue;
      j = MotionEventCompat.findPointerIndex(paramMotionEvent, mScrollPointerId);
      if (j < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      i = (int)(MotionEventCompat.getX(paramMotionEvent, j) + 0.5F);
      j = (int)(MotionEventCompat.getY(paramMotionEvent, j) + 0.5F);
      if (mScrollState != 1)
      {
        int m = i - mInitialTouchX;
        k = j - mInitialTouchY;
        j = 0;
        i = j;
        if (bool1)
        {
          i = j;
          if (Math.abs(m) > mTouchSlop)
          {
            j = mInitialTouchX;
            int n = mTouchSlop;
            if (m >= 0) {
              break label611;
            }
            i = -1;
            label536:
            mLastTouchX = (i * n + j);
            i = 1;
          }
        }
        j = i;
        if (bool2)
        {
          j = i;
          if (Math.abs(k) > mTouchSlop)
          {
            j = mInitialTouchY;
            m = mTouchSlop;
            if (k >= 0) {
              break label616;
            }
          }
        }
        label611:
        label616:
        for (i = -1;; i = 1)
        {
          mLastTouchY = (i * m + j);
          j = 1;
          if (j == 0) {
            break;
          }
          setScrollState(1);
          break;
          i = 1;
          break label536;
        }
        onPointerUp(paramMotionEvent);
        continue;
        mVelocityTracker.clear();
        stopNestedScroll();
        continue;
        cancelTouch();
      }
    }
    return false;
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    TraceCompat.beginSection("RV OnLayout");
    dispatchLayout();
    TraceCompat.endSection();
    mFirstLayoutComplete = true;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int j = 0;
    if (mLayout == null) {
      defaultOnMeasure(paramInt1, paramInt2);
    }
    do
    {
      int i;
      do
      {
        return;
        if (!mLayout.mAutoMeasure) {
          break;
        }
        int k = View.MeasureSpec.getMode(paramInt1);
        int m = View.MeasureSpec.getMode(paramInt2);
        i = j;
        if (k == 1073741824)
        {
          i = j;
          if (m == 1073741824) {
            i = 1;
          }
        }
        mLayout.onMeasure(mRecycler, mState, paramInt1, paramInt2);
      } while ((i != 0) || (mAdapter == null));
      if (mState.mLayoutStep == 1) {
        dispatchLayoutStep1();
      }
      mLayout.setMeasureSpecs(paramInt1, paramInt2);
      mState.mIsMeasuring = true;
      dispatchLayoutStep2();
      mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    } while (!mLayout.shouldMeasureTwice());
    mLayout.setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    mState.mIsMeasuring = true;
    dispatchLayoutStep2();
    mLayout.setMeasuredDimensionFromChildren(paramInt1, paramInt2);
    return;
    if (mHasFixedSize)
    {
      mLayout.onMeasure(mRecycler, mState, paramInt1, paramInt2);
      return;
    }
    if (mAdapterUpdateDuringMeasure)
    {
      eatRequestLayout();
      processAdapterUpdatesAndSetAnimationFlags();
      if (mState.mRunPredictiveAnimations)
      {
        mState.mInPreLayout = true;
        mAdapterUpdateDuringMeasure = false;
        resumeRequestLayout(false);
      }
    }
    else
    {
      if (mAdapter == null) {
        break label337;
      }
    }
    label337:
    for (mState.mItemCount = mAdapter.getItemCount();; mState.mItemCount = 0)
    {
      eatRequestLayout();
      mLayout.onMeasure(mRecycler, mState, paramInt1, paramInt2);
      resumeRequestLayout(false);
      mState.mInPreLayout = false;
      return;
      mAdapterHelper.consumeUpdatesInOnePass();
      mState.mInPreLayout = false;
      break;
    }
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    do
    {
      return;
      mPendingSavedState = ((SavedState)paramParcelable);
      super.onRestoreInstanceState(mPendingSavedState.getSuperState());
    } while ((mLayout == null) || (mPendingSavedState.mLayoutState == null));
    mLayout.onRestoreInstanceState(mPendingSavedState.mLayoutState);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    if (mPendingSavedState != null)
    {
      mLayoutState = mPendingSavedState;
      return localSavedState;
    }
    if (mLayout != null)
    {
      mLayoutState = mLayout.onSaveInstanceState();
      return localSavedState;
    }
    mLayoutState = null;
    return localSavedState;
  }
  
  public void onScrollStateChanged(int paramInt) {}
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4)) {
      invalidateGlows();
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((mLayoutFrozen) || (mIgnoreMotionEventTillDown)) {
      return false;
    }
    int i = paramMotionEvent.getAction();
    if (mActiveOnItemTouchListener != null)
    {
      if (i == 0) {
        mActiveOnItemTouchListener = null;
      }
    }
    else
    {
      if (i == 0) {
        break label151;
      }
      j = mOnItemTouchListeners.size();
      i = 0;
      if (i >= j) {
        break label151;
      }
      localObject = (OnItemTouchListener)mOnItemTouchListeners.get(i);
      if (!((OnItemTouchListener)localObject).onInterceptTouchEvent(this, paramMotionEvent)) {
        break label142;
      }
      mActiveOnItemTouchListener = ((OnItemTouchListener)localObject);
      i = 1;
    }
    for (;;)
    {
      if (i == 0) {
        break label157;
      }
      cancelTouch();
      return true;
      mActiveOnItemTouchListener.onTouchEvent$606727f8(paramMotionEvent);
      if ((i == 3) || (i == 1)) {
        mActiveOnItemTouchListener = null;
      }
      i = 1;
      continue;
      label142:
      i += 1;
      break;
      label151:
      i = 0;
    }
    label157:
    if (mLayout == null) {
      return false;
    }
    boolean bool1 = mLayout.canScrollHorizontally();
    boolean bool2 = mLayout.canScrollVertically();
    if (mVelocityTracker == null) {
      mVelocityTracker = VelocityTracker.obtain();
    }
    int i2 = 0;
    Object localObject = MotionEvent.obtain(paramMotionEvent);
    int k = MotionEventCompat.getActionMasked(paramMotionEvent);
    int j = MotionEventCompat.getActionIndex(paramMotionEvent);
    if (k == 0)
    {
      int[] arrayOfInt = mNestedOffsets;
      mNestedOffsets[1] = 0;
      arrayOfInt[0] = 0;
    }
    ((MotionEvent)localObject).offsetLocation(mNestedOffsets[0], mNestedOffsets[1]);
    i = i2;
    switch (k)
    {
    default: 
      i = i2;
    }
    for (;;)
    {
      if (i == 0) {
        mVelocityTracker.addMovement((MotionEvent)localObject);
      }
      ((MotionEvent)localObject).recycle();
      return true;
      mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, 0);
      i = (int)(paramMotionEvent.getX() + 0.5F);
      mLastTouchX = i;
      mInitialTouchX = i;
      i = (int)(paramMotionEvent.getY() + 0.5F);
      mLastTouchY = i;
      mInitialTouchY = i;
      i = 0;
      if (bool1) {
        i = 1;
      }
      j = i;
      if (bool2) {
        j = i | 0x2;
      }
      startNestedScroll(j);
      i = i2;
      continue;
      mScrollPointerId = MotionEventCompat.getPointerId(paramMotionEvent, j);
      i = (int)(MotionEventCompat.getX(paramMotionEvent, j) + 0.5F);
      mLastTouchX = i;
      mInitialTouchX = i;
      i = (int)(MotionEventCompat.getY(paramMotionEvent, j) + 0.5F);
      mLastTouchY = i;
      mInitialTouchY = i;
      i = i2;
      continue;
      i = MotionEventCompat.findPointerIndex(paramMotionEvent, mScrollPointerId);
      if (i < 0)
      {
        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + mScrollPointerId + " not found. Did any MotionEvents get skipped?");
        return false;
      }
      int i3 = (int)(MotionEventCompat.getX(paramMotionEvent, i) + 0.5F);
      int i4 = (int)(MotionEventCompat.getY(paramMotionEvent, i) + 0.5F);
      int m = mLastTouchX - i3;
      k = mLastTouchY - i4;
      j = m;
      i = k;
      if (dispatchNestedPreScroll(m, k, mScrollConsumed, mScrollOffset))
      {
        j = m - mScrollConsumed[0];
        i = k - mScrollConsumed[1];
        ((MotionEvent)localObject).offsetLocation(mScrollOffset[0], mScrollOffset[1]);
        paramMotionEvent = mNestedOffsets;
        paramMotionEvent[0] += mScrollOffset[0];
        paramMotionEvent = mNestedOffsets;
        paramMotionEvent[1] += mScrollOffset[1];
      }
      int n = j;
      m = i;
      if (mScrollState != 1)
      {
        n = 0;
        k = j;
        m = n;
        if (bool1)
        {
          k = j;
          m = n;
          if (Math.abs(j) > mTouchSlop)
          {
            if (j <= 0) {
              break label920;
            }
            k = j - mTouchSlop;
            label759:
            m = 1;
          }
        }
        j = i;
        int i1 = m;
        if (bool2)
        {
          j = i;
          i1 = m;
          if (Math.abs(i) > mTouchSlop)
          {
            if (i <= 0) {
              break label932;
            }
            j = i - mTouchSlop;
            label809:
            i1 = 1;
          }
        }
        n = k;
        m = j;
        if (i1 != 0)
        {
          setScrollState(1);
          m = j;
          n = k;
        }
      }
      i = i2;
      if (mScrollState == 1)
      {
        mLastTouchX = (i3 - mScrollOffset[0]);
        mLastTouchY = (i4 - mScrollOffset[1]);
        if (bool1) {
          label881:
          if (!bool2) {
            break label950;
          }
        }
        for (;;)
        {
          i = i2;
          if (!scrollByInternal(n, m, (MotionEvent)localObject)) {
            break;
          }
          getParent().requestDisallowInterceptTouchEvent(true);
          i = i2;
          break;
          label920:
          k = j + mTouchSlop;
          break label759;
          label932:
          j = i + mTouchSlop;
          break label809;
          n = 0;
          break label881;
          label950:
          m = 0;
        }
        onPointerUp(paramMotionEvent);
        i = i2;
        continue;
        mVelocityTracker.addMovement((MotionEvent)localObject);
        i = 1;
        mVelocityTracker.computeCurrentVelocity(1000, mMaxFlingVelocity);
        float f1;
        if (bool1)
        {
          f1 = -VelocityTrackerCompat.getXVelocity(mVelocityTracker, mScrollPointerId);
          label1013:
          if (!bool2) {
            break label1071;
          }
        }
        label1071:
        for (float f2 = -VelocityTrackerCompat.getYVelocity(mVelocityTracker, mScrollPointerId);; f2 = 0.0F)
        {
          if (((f1 == 0.0F) && (f2 == 0.0F)) || (!fling((int)f1, (int)f2))) {
            setScrollState(0);
          }
          resetTouch();
          break;
          f1 = 0.0F;
          break label1013;
        }
        cancelTouch();
        i = i2;
      }
    }
  }
  
  protected void removeDetachedView(View paramView, boolean paramBoolean)
  {
    ViewHolder localViewHolder = getChildViewHolderInt(paramView);
    if (localViewHolder != null)
    {
      if (!localViewHolder.isTmpDetached()) {
        break label32;
      }
      localViewHolder.clearTmpDetachFlag();
    }
    label32:
    while (localViewHolder.shouldIgnore())
    {
      dispatchChildDetached(paramView);
      super.removeDetachedView(paramView, paramBoolean);
      return;
    }
    throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + localViewHolder);
  }
  
  public final void removeOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    if (mScrollListeners != null) {
      mScrollListeners.remove(paramOnScrollListener);
    }
  }
  
  public void requestChildFocus(View paramView1, View paramView2)
  {
    boolean bool = true;
    int i;
    Object localObject;
    if ((mLayout.isSmoothScrolling()) || (isComputingLayout()))
    {
      i = 1;
      if ((i == 0) && (paramView2 != null))
      {
        mTempRect.set(0, 0, paramView2.getWidth(), paramView2.getHeight());
        localObject = paramView2.getLayoutParams();
        if ((localObject instanceof LayoutParams))
        {
          localObject = (LayoutParams)localObject;
          if (!mInsetsDirty)
          {
            localObject = mDecorInsets;
            Rect localRect = mTempRect;
            left -= left;
            localRect = mTempRect;
            right += right;
            localRect = mTempRect;
            top -= top;
            localRect = mTempRect;
            bottom += bottom;
          }
        }
        offsetDescendantRectToMyCoords(paramView2, mTempRect);
        offsetRectIntoDescendantCoords(paramView1, mTempRect);
        localObject = mTempRect;
        if (mFirstLayoutComplete) {
          break label224;
        }
      }
    }
    for (;;)
    {
      requestChildRectangleOnScreen(paramView1, (Rect)localObject, bool);
      super.requestChildFocus(paramView1, paramView2);
      return;
      i = 0;
      break;
      label224:
      bool = false;
    }
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    LayoutManager localLayoutManager = mLayout;
    int i2 = localLayoutManager.getPaddingLeft();
    int m = localLayoutManager.getPaddingTop();
    int i3 = mWidth - localLayoutManager.getPaddingRight();
    int i1 = mHeight;
    int i6 = localLayoutManager.getPaddingBottom();
    int i4 = paramView.getLeft() + left - paramView.getScrollX();
    int n = paramView.getTop() + top - paramView.getScrollY();
    int i5 = i4 + paramRect.width();
    int i7 = paramRect.height();
    int i = Math.min(0, i4 - i2);
    int j = Math.min(0, n - m);
    int k = Math.max(0, i5 - i3);
    i1 = Math.max(0, n + i7 - (i1 - i6));
    if (ViewCompat.getLayoutDirection(mRecyclerView) == 1) {
      if (k != 0)
      {
        i = k;
        if (j == 0) {
          break label232;
        }
        label170:
        if ((i == 0) && (j == 0)) {
          break label258;
        }
        if (!paramBoolean) {
          break label247;
        }
        scrollBy(i, j);
      }
    }
    for (;;)
    {
      return true;
      i = Math.max(i, i5 - i3);
      break;
      if (i != 0) {
        break;
      }
      for (;;)
      {
        i = Math.min(i4 - i2, k);
      }
      label232:
      j = Math.min(n - m, i1);
      break label170;
      label247:
      smoothScrollBy(i, j);
    }
    label258:
    return false;
  }
  
  public void requestDisallowInterceptTouchEvent(boolean paramBoolean)
  {
    int j = mOnItemTouchListeners.size();
    int i = 0;
    while (i < j)
    {
      ((OnItemTouchListener)mOnItemTouchListeners.get(i)).onRequestDisallowInterceptTouchEvent(paramBoolean);
      i += 1;
    }
    super.requestDisallowInterceptTouchEvent(paramBoolean);
  }
  
  public void requestLayout()
  {
    if ((mEatRequestLayout == 0) && (!mLayoutFrozen))
    {
      super.requestLayout();
      return;
    }
    mLayoutRequestEaten = true;
  }
  
  final void resumeRequestLayout(boolean paramBoolean)
  {
    if (mEatRequestLayout <= 0) {
      mEatRequestLayout = 1;
    }
    if (!paramBoolean) {
      mLayoutRequestEaten = false;
    }
    if (mEatRequestLayout == 1)
    {
      if ((paramBoolean) && (mLayoutRequestEaten) && (!mLayoutFrozen) && (mLayout != null) && (mAdapter != null)) {
        dispatchLayout();
      }
      if (!mLayoutFrozen) {
        mLayoutRequestEaten = false;
      }
    }
    mEatRequestLayout -= 1;
  }
  
  public void scrollBy(int paramInt1, int paramInt2)
  {
    if (mLayout == null) {}
    boolean bool1;
    boolean bool2;
    do
    {
      Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (mLayoutFrozen);
      bool1 = mLayout.canScrollHorizontally();
      bool2 = mLayout.canScrollVertically();
    } while ((!bool1) && (!bool2));
    if (bool1) {
      if (!bool2) {
        break label74;
      }
    }
    for (;;)
    {
      scrollByInternal(paramInt1, paramInt2, null);
      return;
      paramInt1 = 0;
      break;
      label74:
      paramInt2 = 0;
    }
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
  }
  
  public void scrollToPosition(int paramInt)
  {
    if (mLayoutFrozen) {
      return;
    }
    stopScroll();
    if (mLayout == null)
    {
      Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    mLayout.scrollToPosition(paramInt);
    awakenScrollBars();
  }
  
  public void sendAccessibilityEventUnchecked(AccessibilityEvent paramAccessibilityEvent)
  {
    int i = 0;
    int j = 0;
    if (isComputingLayout()) {
      if (paramAccessibilityEvent == null) {
        break label52;
      }
    }
    label52:
    for (i = AccessibilityEventCompat.getContentChangeTypes(paramAccessibilityEvent);; i = 0)
    {
      if (i == 0) {
        i = j;
      }
      for (;;)
      {
        mEatenAccessibilityChangeFlags = (i | mEatenAccessibilityChangeFlags);
        i = 1;
        if (i != 0) {
          return;
        }
        super.sendAccessibilityEventUnchecked(paramAccessibilityEvent);
        return;
      }
    }
  }
  
  public void setAccessibilityDelegateCompat(RecyclerViewAccessibilityDelegate paramRecyclerViewAccessibilityDelegate)
  {
    mAccessibilityDelegate = paramRecyclerViewAccessibilityDelegate;
    ViewCompat.setAccessibilityDelegate(this, mAccessibilityDelegate);
  }
  
  public void setAdapter(Adapter paramAdapter)
  {
    setLayoutFrozen(false);
    if (mAdapter != null)
    {
      mAdapter.unregisterAdapterDataObserver(mObserver);
      mAdapter.onDetachedFromRecyclerView(this);
    }
    if (mItemAnimator != null) {
      mItemAnimator.endAnimations();
    }
    if (mLayout != null)
    {
      mLayout.removeAndRecycleAllViews(mRecycler);
      mLayout.removeAndRecycleScrapInt(mRecycler);
    }
    mRecycler.clear();
    mAdapterHelper.reset();
    Adapter localAdapter = mAdapter;
    mAdapter = paramAdapter;
    if (paramAdapter != null)
    {
      paramAdapter.registerAdapterDataObserver(mObserver);
      paramAdapter.onAttachedToRecyclerView(this);
    }
    if (mLayout != null) {
      mLayout.onAdapterChanged$69e7eefb();
    }
    Object localObject = mRecycler;
    paramAdapter = mAdapter;
    ((Recycler)localObject).clear();
    localObject = ((Recycler)localObject).getRecycledViewPool();
    if (localAdapter != null) {
      ((RecycledViewPool)localObject).detach();
    }
    if (mAttachCount == 0) {
      mScrap.clear();
    }
    if (paramAdapter != null) {
      ((RecycledViewPool)localObject).attach$b0de1c8();
    }
    mState.mStructureChanged = true;
    markKnownViewsInvalid();
    requestLayout();
  }
  
  public void setChildDrawingOrderCallback(ChildDrawingOrderCallback paramChildDrawingOrderCallback)
  {
    if (paramChildDrawingOrderCallback == mChildDrawingOrderCallback) {
      return;
    }
    mChildDrawingOrderCallback = paramChildDrawingOrderCallback;
    if (mChildDrawingOrderCallback != null) {}
    for (boolean bool = true;; bool = false)
    {
      setChildrenDrawingOrderEnabled(bool);
      return;
    }
  }
  
  public void setClipToPadding(boolean paramBoolean)
  {
    if (paramBoolean != mClipToPadding) {
      invalidateGlows();
    }
    mClipToPadding = paramBoolean;
    super.setClipToPadding(paramBoolean);
    if (mFirstLayoutComplete) {
      requestLayout();
    }
  }
  
  public void setHasFixedSize(boolean paramBoolean)
  {
    mHasFixedSize = paramBoolean;
  }
  
  public void setItemAnimator(ItemAnimator paramItemAnimator)
  {
    if (mItemAnimator != null)
    {
      mItemAnimator.endAnimations();
      mItemAnimator.mListener = null;
    }
    mItemAnimator = paramItemAnimator;
    if (mItemAnimator != null) {
      mItemAnimator.mListener = mItemAnimatorListener;
    }
  }
  
  public void setItemViewCacheSize(int paramInt)
  {
    Recycler localRecycler = mRecycler;
    mViewCacheMax = paramInt;
    int i = mCachedViews.size() - 1;
    while ((i >= 0) && (mCachedViews.size() > paramInt))
    {
      localRecycler.recycleCachedViewAt(i);
      i -= 1;
    }
  }
  
  public void setLayoutFrozen(boolean paramBoolean)
  {
    if (paramBoolean != mLayoutFrozen)
    {
      assertNotInLayoutOrScroll("Do not setLayoutFrozen in layout or scroll");
      if (!paramBoolean)
      {
        mLayoutFrozen = false;
        if ((mLayoutRequestEaten) && (mLayout != null) && (mAdapter != null)) {
          requestLayout();
        }
        mLayoutRequestEaten = false;
      }
    }
    else
    {
      return;
    }
    long l = SystemClock.uptimeMillis();
    onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
    mLayoutFrozen = true;
    mIgnoreMotionEventTillDown = true;
    stopScroll();
  }
  
  public void setLayoutManager(LayoutManager paramLayoutManager)
  {
    if (paramLayoutManager == mLayout) {
      return;
    }
    stopScroll();
    if (mLayout != null)
    {
      if (mIsAttached) {
        mLayout.dispatchDetachedFromWindow(this, mRecycler);
      }
      mLayout.setRecyclerView(null);
    }
    mRecycler.clear();
    ChildHelper localChildHelper = mChildHelper;
    for (ChildHelper.Bucket localBucket = mBucket;; localBucket = next)
    {
      mData = 0L;
      if (next == null) {
        break;
      }
    }
    int i = mHiddenViews.size() - 1;
    while (i >= 0)
    {
      mCallback.onLeftHiddenState((View)mHiddenViews.get(i));
      mHiddenViews.remove(i);
      i -= 1;
    }
    mCallback.removeAllViews();
    mLayout = paramLayoutManager;
    if (paramLayoutManager != null)
    {
      if (mRecyclerView != null) {
        throw new IllegalArgumentException("LayoutManager " + paramLayoutManager + " is already attached to a RecyclerView: " + mRecyclerView);
      }
      mLayout.setRecyclerView(this);
      if (mIsAttached) {
        mLayout.mIsAttachedToWindow = true;
      }
    }
    requestLayout();
  }
  
  public void setNestedScrollingEnabled(boolean paramBoolean)
  {
    getScrollingChildHelper().setNestedScrollingEnabled(paramBoolean);
  }
  
  @Deprecated
  public void setOnScrollListener(OnScrollListener paramOnScrollListener)
  {
    mScrollListener = paramOnScrollListener;
  }
  
  public void setRecycledViewPool(RecycledViewPool paramRecycledViewPool)
  {
    Recycler localRecycler = mRecycler;
    if (mRecyclerPool != null) {
      mRecyclerPool.detach();
    }
    mRecyclerPool = paramRecycledViewPool;
    if (paramRecycledViewPool != null)
    {
      paramRecycledViewPool = mRecyclerPool;
      this$0.getAdapter();
      paramRecycledViewPool.attach$b0de1c8();
    }
  }
  
  public void setRecyclerListener(RecyclerListener paramRecyclerListener)
  {
    mRecyclerListener = paramRecyclerListener;
  }
  
  public void setScrollingTouchSlop(int paramInt)
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(getContext());
    switch (paramInt)
    {
    default: 
      Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + paramInt + "; using default value");
    case 0: 
      mTouchSlop = localViewConfiguration.getScaledTouchSlop();
      return;
    }
    mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(localViewConfiguration);
  }
  
  public void setViewCacheExtension(ViewCacheExtension paramViewCacheExtension)
  {
    mRecycler.mViewCacheExtension = paramViewCacheExtension;
  }
  
  public final void smoothScrollBy(int paramInt1, int paramInt2)
  {
    if (mLayout == null) {}
    do
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      do
      {
        return;
      } while (mLayoutFrozen);
      if (!mLayout.canScrollHorizontally()) {
        paramInt1 = 0;
      }
      if (!mLayout.canScrollVertically()) {
        paramInt2 = 0;
      }
    } while ((paramInt1 == 0) && (paramInt2 == 0));
    mViewFlinger.smoothScrollBy(paramInt1, paramInt2);
  }
  
  public void smoothScrollToPosition(int paramInt)
  {
    if (mLayoutFrozen) {
      return;
    }
    if (mLayout == null)
    {
      Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
      return;
    }
    mLayout.smoothScrollToPosition$7d69765f(this, paramInt);
  }
  
  public boolean startNestedScroll(int paramInt)
  {
    return getScrollingChildHelper().startNestedScroll(paramInt);
  }
  
  public void stopNestedScroll()
  {
    getScrollingChildHelper().stopNestedScroll();
  }
  
  public final void stopScroll()
  {
    setScrollState(0);
    stopScrollersInternal();
  }
  
  public static abstract class Adapter<VH extends RecyclerView.ViewHolder>
  {
    private boolean mHasStableIds = false;
    private final RecyclerView.AdapterDataObservable mObservable = new RecyclerView.AdapterDataObservable();
    
    public final void bindViewHolder(VH paramVH, int paramInt)
    {
      mPosition = paramInt;
      if (hasStableIds()) {
        mItemId = getItemId(paramInt);
      }
      paramVH.setFlags(1, 519);
      TraceCompat.beginSection("RV OnBindView");
      onBindViewHolder(paramVH, paramInt, paramVH.getUnmodifiedPayloads());
      paramVH.clearPayload();
      TraceCompat.endSection();
    }
    
    public final VH createViewHolder(ViewGroup paramViewGroup, int paramInt)
    {
      TraceCompat.beginSection("RV CreateView");
      paramViewGroup = onCreateViewHolder(paramViewGroup, paramInt);
      mItemViewType = paramInt;
      TraceCompat.endSection();
      return paramViewGroup;
    }
    
    public abstract int getItemCount();
    
    public long getItemId(int paramInt)
    {
      return -1L;
    }
    
    public int getItemViewType(int paramInt)
    {
      return 0;
    }
    
    public final boolean hasObservers()
    {
      return mObservable.hasObservers();
    }
    
    public final boolean hasStableIds()
    {
      return mHasStableIds;
    }
    
    public final void notifyDataSetChanged()
    {
      mObservable.notifyChanged();
    }
    
    public final void notifyItemChanged(int paramInt)
    {
      mObservable.notifyItemRangeChanged(paramInt, 1);
    }
    
    public final void notifyItemChanged(int paramInt, Object paramObject)
    {
      mObservable.notifyItemRangeChanged(paramInt, 1, paramObject);
    }
    
    public final void notifyItemInserted(int paramInt)
    {
      mObservable.notifyItemRangeInserted(paramInt, 1);
    }
    
    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemMoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemRangeChanged(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      mObservable.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }
    
    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemRangeInserted(paramInt1, paramInt2);
    }
    
    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      mObservable.notifyItemRangeRemoved(paramInt1, paramInt2);
    }
    
    public final void notifyItemRemoved(int paramInt)
    {
      mObservable.notifyItemRangeRemoved(paramInt, 1);
    }
    
    public void onAttachedToRecyclerView(RecyclerView paramRecyclerView) {}
    
    public abstract void onBindViewHolder(VH paramVH, int paramInt);
    
    public void onBindViewHolder(VH paramVH, int paramInt, List<Object> paramList)
    {
      onBindViewHolder(paramVH, paramInt);
    }
    
    public abstract VH onCreateViewHolder(ViewGroup paramViewGroup, int paramInt);
    
    public void onDetachedFromRecyclerView(RecyclerView paramRecyclerView) {}
    
    public boolean onFailedToRecycleView(VH paramVH)
    {
      return false;
    }
    
    public void onViewAttachedToWindow(VH paramVH) {}
    
    public void onViewDetachedFromWindow(VH paramVH) {}
    
    public void onViewRecycled(VH paramVH) {}
    
    public void registerAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      mObservable.registerObserver(paramAdapterDataObserver);
    }
    
    public void setHasStableIds(boolean paramBoolean)
    {
      if (hasObservers()) {
        throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
      }
      mHasStableIds = paramBoolean;
    }
    
    public void unregisterAdapterDataObserver(RecyclerView.AdapterDataObserver paramAdapterDataObserver)
    {
      mObservable.unregisterObserver(paramAdapterDataObserver);
    }
  }
  
  static final class AdapterDataObservable
    extends Observable<RecyclerView.AdapterDataObserver>
  {
    public final boolean hasObservers()
    {
      return !mObservers.isEmpty();
    }
    
    public final void notifyChanged()
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onChanged();
        i -= 1;
      }
    }
    
    public final void notifyItemMoved(int paramInt1, int paramInt2)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeMoved(paramInt1, paramInt2, 1);
        i -= 1;
      }
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2)
    {
      notifyItemRangeChanged(paramInt1, paramInt2, null);
    }
    
    public final void notifyItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeChanged(paramInt1, paramInt2, paramObject);
        i -= 1;
      }
    }
    
    public final void notifyItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeInserted(paramInt1, paramInt2);
        i -= 1;
      }
    }
    
    public final void notifyItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = mObservers.size() - 1;
      while (i >= 0)
      {
        ((RecyclerView.AdapterDataObserver)mObservers.get(i)).onItemRangeRemoved(paramInt1, paramInt2);
        i -= 1;
      }
    }
  }
  
  public static abstract class AdapterDataObserver
  {
    public void onChanged() {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2) {}
    
    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      onItemRangeChanged(paramInt1, paramInt2);
    }
    
    public void onItemRangeInserted(int paramInt1, int paramInt2) {}
    
    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onItemRangeRemoved(int paramInt1, int paramInt2) {}
  }
  
  public static abstract interface ChildDrawingOrderCallback
  {
    public abstract int onGetChildDrawingOrder(int paramInt1, int paramInt2);
  }
  
  public static abstract class ItemAnimator
  {
    public long mAddDuration = 120L;
    public long mChangeDuration = 250L;
    private ArrayList<Object> mFinishedListeners = new ArrayList();
    ItemAnimatorListener mListener = null;
    public long mMoveDuration = 250L;
    public long mRemoveDuration = 120L;
    
    static int buildAdapterChangeFlagsForAnimations(RecyclerView.ViewHolder paramViewHolder)
    {
      int j = RecyclerView.ViewHolder.access$6500(paramViewHolder) & 0xE;
      if (paramViewHolder.isInvalid()) {
        return 4;
      }
      int i = j;
      if ((j & 0x4) == 0)
      {
        int k = paramViewHolder.getOldPosition();
        int m = paramViewHolder.getAdapterPosition();
        i = j;
        if (k != -1)
        {
          i = j;
          if (m != -1)
          {
            i = j;
            if (k != m) {
              i = j | 0x800;
            }
          }
        }
      }
      return i;
    }
    
    public abstract boolean animateAppearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animateChange(RecyclerView.ViewHolder paramViewHolder1, RecyclerView.ViewHolder paramViewHolder2, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animateDisappearance(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
    
    public abstract boolean animatePersistence(RecyclerView.ViewHolder paramViewHolder, ItemHolderInfo paramItemHolderInfo1, ItemHolderInfo paramItemHolderInfo2);
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder)
    {
      return true;
    }
    
    public boolean canReuseUpdatedViewHolder(RecyclerView.ViewHolder paramViewHolder, List<Object> paramList)
    {
      return canReuseUpdatedViewHolder(paramViewHolder);
    }
    
    public final void dispatchAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
      if (mListener != null) {
        mListener.onAnimationFinished(paramViewHolder);
      }
    }
    
    public final void dispatchAnimationsFinished()
    {
      int j = mFinishedListeners.size();
      int i = 0;
      while (i < j)
      {
        mFinishedListeners.get(i);
        i += 1;
      }
      mFinishedListeners.clear();
    }
    
    public abstract void endAnimation(RecyclerView.ViewHolder paramViewHolder);
    
    public abstract void endAnimations();
    
    public abstract boolean isRunning();
    
    public abstract void runPendingAnimations();
    
    static abstract interface ItemAnimatorListener
    {
      public abstract void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder);
    }
    
    public static final class ItemHolderInfo
    {
      public int bottom;
      public int left;
      public int right;
      public int top;
      
      public final ItemHolderInfo setFrom(RecyclerView.ViewHolder paramViewHolder)
      {
        paramViewHolder = itemView;
        left = paramViewHolder.getLeft();
        top = paramViewHolder.getTop();
        right = paramViewHolder.getRight();
        bottom = paramViewHolder.getBottom();
        return this;
      }
    }
  }
  
  private final class ItemAnimatorRestoreListener
    implements RecyclerView.ItemAnimator.ItemAnimatorListener
  {
    private ItemAnimatorRestoreListener() {}
    
    public final void onAnimationFinished(RecyclerView.ViewHolder paramViewHolder)
    {
      paramViewHolder.setIsRecyclable(true);
      if ((mShadowedHolder != null) && (mShadowingHolder == null)) {
        mShadowedHolder = null;
      }
      mShadowingHolder = null;
      if ((!RecyclerView.ViewHolder.access$6300(paramViewHolder)) && (!RecyclerView.access$6400(RecyclerView.this, itemView)) && (paramViewHolder.isTmpDetached())) {
        removeDetachedView(itemView, false);
      }
    }
  }
  
  public static abstract class ItemDecoration
  {
    public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
    {
      getLayoutParamsmViewHolder.getLayoutPosition();
      paramRect.set(0, 0, 0, 0);
    }
    
    public void onDraw$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
    
    public void onDrawOver$13fcd2ff(Canvas paramCanvas, RecyclerView paramRecyclerView) {}
  }
  
  public static abstract class LayoutManager
  {
    public boolean mAutoMeasure = false;
    public ChildHelper mChildHelper;
    public int mHeight;
    int mHeightMode;
    boolean mIsAttachedToWindow = false;
    boolean mMeasurementCacheEnabled = true;
    public RecyclerView mRecyclerView;
    public boolean mRequestedSimpleAnimations = false;
    RecyclerView.SmoothScroller mSmoothScroller;
    public int mWidth;
    int mWidthMode;
    
    public static int chooseSize(int paramInt1, int paramInt2, int paramInt3)
    {
      int j = View.MeasureSpec.getMode(paramInt1);
      int i = View.MeasureSpec.getSize(paramInt1);
      paramInt1 = i;
      switch (j)
      {
      default: 
        paramInt1 = Math.max(paramInt2, paramInt3);
      case 1073741824: 
        return paramInt1;
      }
      return Math.min(i, Math.max(paramInt2, paramInt3));
    }
    
    private void detachViewAt(int paramInt)
    {
      getChildAt(paramInt);
      detachViewInternal$4d81c81c(paramInt);
    }
    
    public static int getBottomDecorationHeight(View paramView)
    {
      return getLayoutParamsmDecorInsets.bottom;
    }
    
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
    {
      int i = Math.max(0, paramInt1 - paramInt3);
      paramInt3 = 0;
      paramInt1 = 0;
      if (paramBoolean) {
        if (paramInt4 >= 0)
        {
          paramInt3 = paramInt4;
          paramInt1 = 1073741824;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt3, paramInt1);
        if (paramInt4 == -1)
        {
          switch (paramInt2)
          {
          default: 
            break;
          case 1073741824: 
          case -2147483648: 
            paramInt3 = i;
            paramInt1 = paramInt2;
            break;
          case 0: 
            paramInt3 = 0;
            paramInt1 = 0;
            break;
          }
        }
        else if (paramInt4 == -2)
        {
          paramInt3 = 0;
          do
          {
            paramInt1 = 0;
            break;
            if (paramInt4 >= 0)
            {
              paramInt3 = paramInt4;
              paramInt1 = 1073741824;
              break;
            }
            if (paramInt4 == -1)
            {
              paramInt3 = i;
              paramInt1 = paramInt2;
              break;
            }
            if (paramInt4 != -2) {
              break;
            }
            if (paramInt2 == Integer.MIN_VALUE) {
              break label149;
            }
            paramInt3 = i;
          } while (paramInt2 != 1073741824);
          label149:
          paramInt1 = Integer.MIN_VALUE;
          paramInt3 = i;
        }
      }
    }
    
    @Deprecated
    public static int getChildMeasureSpec(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
    {
      int i = Math.max(0, paramInt1 - paramInt2);
      paramInt2 = 0;
      paramInt1 = 0;
      if (paramBoolean) {
        if (paramInt3 >= 0)
        {
          paramInt2 = paramInt3;
          paramInt1 = 1073741824;
        }
      }
      for (;;)
      {
        return View.MeasureSpec.makeMeasureSpec(paramInt2, paramInt1);
        paramInt2 = 0;
        paramInt1 = 0;
        continue;
        if (paramInt3 >= 0)
        {
          paramInt2 = paramInt3;
          paramInt1 = 1073741824;
        }
        else if (paramInt3 == -1)
        {
          paramInt2 = i;
          paramInt1 = 1073741824;
        }
        else if (paramInt3 == -2)
        {
          paramInt2 = i;
          paramInt1 = Integer.MIN_VALUE;
        }
      }
    }
    
    public static int getLeftDecorationWidth(View paramView)
    {
      return getLayoutParamsmDecorInsets.left;
    }
    
    public static int getPosition(View paramView)
    {
      return getLayoutParamsmViewHolder.getLayoutPosition();
    }
    
    public static Properties getProperties(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
    {
      Properties localProperties = new Properties();
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.RecyclerView, paramInt1, paramInt2);
      orientation = paramContext.getInt(R.styleable.RecyclerView_android_orientation, 1);
      spanCount = paramContext.getInt(R.styleable.RecyclerView_spanCount, 1);
      reverseLayout = paramContext.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
      stackFromEnd = paramContext.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
      paramContext.recycle();
      return localProperties;
    }
    
    public static int getRightDecorationWidth(View paramView)
    {
      return getLayoutParamsmDecorInsets.right;
    }
    
    public static int getTopDecorationHeight(View paramView)
    {
      return getLayoutParamsmDecorInsets.top;
    }
    
    static boolean isMeasurementUpToDate(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = View.MeasureSpec.getMode(paramInt2);
      paramInt2 = View.MeasureSpec.getSize(paramInt2);
      if ((paramInt3 > 0) && (paramInt1 != paramInt3)) {}
      do
      {
        do
        {
          return false;
          switch (i)
          {
          default: 
            return false;
          }
        } while (paramInt2 < paramInt1);
        return true;
        return true;
      } while (paramInt2 != paramInt1);
      return true;
    }
    
    private void removeViewAt(int paramInt)
    {
      if (getChildAt(paramInt) != null) {
        mChildHelper.removeViewAt(paramInt);
      }
    }
    
    private void scrapOrRecycleView(RecyclerView.Recycler paramRecycler, int paramInt, View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.shouldIgnore()) {
        return;
      }
      if ((localViewHolder.isInvalid()) && (!localViewHolder.isRemoved()) && (!mRecyclerView.mAdapter.hasStableIds()))
      {
        removeViewAt(paramInt);
        paramRecycler.recycleViewHolderInternal(localViewHolder);
        return;
      }
      detachViewAt(paramInt);
      paramRecycler.scrapView(paramView);
      mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
    }
    
    public final void addViewInt(View paramView, int paramInt, boolean paramBoolean)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      RecyclerView.LayoutParams localLayoutParams;
      if ((paramBoolean) || (localViewHolder.isRemoved()))
      {
        mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
        localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
        if ((!localViewHolder.wasReturnedFromScrap()) && (!localViewHolder.isScrap())) {
          break label128;
        }
        if (!localViewHolder.isScrap()) {
          break label120;
        }
        localViewHolder.unScrap();
        label68:
        mChildHelper.attachViewToParent(paramView, paramInt, paramView.getLayoutParams(), false);
      }
      for (;;)
      {
        if (mPendingInvalidate)
        {
          itemView.invalidate();
          mPendingInvalidate = false;
        }
        return;
        mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
        break;
        label120:
        localViewHolder.clearReturnedFromScrapFlag();
        break label68;
        label128:
        if (paramView.getParent() == mRecyclerView)
        {
          int j = mChildHelper.indexOfChild(paramView);
          int i = paramInt;
          if (paramInt == -1) {
            i = mChildHelper.getChildCount();
          }
          if (j == -1) {
            throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + mRecyclerView.indexOfChild(paramView));
          }
          if (j != i)
          {
            paramView = mRecyclerView.mLayout;
            View localView = paramView.getChildAt(j);
            if (localView == null) {
              throw new IllegalArgumentException("Cannot move a child from non-existing index:" + j);
            }
            paramView.detachViewAt(j);
            paramView.attachView(localView, i);
          }
        }
        else
        {
          mChildHelper.addView(paramView, paramInt, false);
          mInsetsDirty = true;
          if ((mSmoothScroller != null) && (mSmoothScroller.mRunning)) {
            mSmoothScroller.onChildAttachedToWindow(paramView);
          }
        }
      }
    }
    
    public void assertNotInLayoutOrScroll(String paramString)
    {
      if (mRecyclerView != null) {
        mRecyclerView.assertNotInLayoutOrScroll(paramString);
      }
    }
    
    public final void attachView(View paramView, int paramInt)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isRemoved()) {
        mRecyclerView.mViewInfoStore.addToDisappearedInLayout(localViewHolder);
      }
      for (;;)
      {
        mChildHelper.attachViewToParent(paramView, paramInt, localLayoutParams, localViewHolder.isRemoved());
        return;
        mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(localViewHolder);
      }
    }
    
    public final void calculateItemDecorationsForChild(View paramView, Rect paramRect)
    {
      if (mRecyclerView == null)
      {
        paramRect.set(0, 0, 0, 0);
        return;
      }
      paramRect.set(mRecyclerView.getItemDecorInsetsForChild(paramView));
    }
    
    public boolean canScrollHorizontally()
    {
      return false;
    }
    
    public boolean canScrollVertically()
    {
      return false;
    }
    
    public boolean checkLayoutParams(RecyclerView.LayoutParams paramLayoutParams)
    {
      return paramLayoutParams != null;
    }
    
    public int computeHorizontalScrollExtent(RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeHorizontalScrollOffset(RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeHorizontalScrollRange(RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollExtent(RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollOffset(RecyclerView.State paramState)
    {
      return 0;
    }
    
    public int computeVerticalScrollRange(RecyclerView.State paramState)
    {
      return 0;
    }
    
    public final void detachAndScrapAttachedViews(RecyclerView.Recycler paramRecycler)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        scrapOrRecycleView(paramRecycler, i, getChildAt(i));
        i -= 1;
      }
    }
    
    public final void detachAndScrapViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
    {
      scrapOrRecycleView(paramRecycler, paramInt, getChildAt(paramInt));
    }
    
    public final void detachViewInternal$4d81c81c(int paramInt)
    {
      mChildHelper.detachViewFromParent(paramInt);
    }
    
    final void dispatchDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler)
    {
      mIsAttachedToWindow = false;
      onDetachedFromWindow(paramRecyclerView, paramRecycler);
    }
    
    public final View findContainingItemView(View paramView)
    {
      Object localObject;
      if (mRecyclerView == null) {
        localObject = null;
      }
      do
      {
        return (View)localObject;
        RecyclerView localRecyclerView = mRecyclerView;
        for (localObject = paramView.getParent(); (localObject != null) && (localObject != localRecyclerView) && ((localObject instanceof View)); localObject = paramView.getParent()) {
          paramView = (View)localObject;
        }
        if (localObject == localRecyclerView) {}
        while (paramView == null)
        {
          return null;
          paramView = null;
        }
        localObject = paramView;
      } while (!mChildHelper.isHidden(paramView));
      return null;
    }
    
    public View findViewByPosition(int paramInt)
    {
      int j = getChildCount();
      int i = 0;
      while (i < j)
      {
        View localView = getChildAt(i);
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if ((localViewHolder != null) && (localViewHolder.getLayoutPosition() == paramInt) && (!localViewHolder.shouldIgnore()) && ((mRecyclerView.mState.mInPreLayout) || (!localViewHolder.isRemoved()))) {
          return localView;
        }
        i += 1;
      }
      return null;
    }
    
    public abstract RecyclerView.LayoutParams generateDefaultLayoutParams();
    
    public RecyclerView.LayoutParams generateLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      return new RecyclerView.LayoutParams(paramContext, paramAttributeSet);
    }
    
    public RecyclerView.LayoutParams generateLayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      if ((paramLayoutParams instanceof RecyclerView.LayoutParams)) {
        return new RecyclerView.LayoutParams((RecyclerView.LayoutParams)paramLayoutParams);
      }
      if ((paramLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        return new RecyclerView.LayoutParams((ViewGroup.MarginLayoutParams)paramLayoutParams);
      }
      return new RecyclerView.LayoutParams(paramLayoutParams);
    }
    
    public final View getChildAt(int paramInt)
    {
      if (mChildHelper != null) {
        return mChildHelper.getChildAt(paramInt);
      }
      return null;
    }
    
    public final int getChildCount()
    {
      if (mChildHelper != null) {
        return mChildHelper.getChildCount();
      }
      return 0;
    }
    
    public final boolean getClipToPadding()
    {
      return (mRecyclerView != null) && (mRecyclerView.mClipToPadding);
    }
    
    public int getColumnCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      if ((mRecyclerView == null) || (mRecyclerView.mAdapter == null)) {}
      while (!canScrollHorizontally()) {
        return 1;
      }
      return mRecyclerView.mAdapter.getItemCount();
    }
    
    public int getDecoratedBottom(View paramView)
    {
      return paramView.getBottom() + getBottomDecorationHeight(paramView);
    }
    
    public int getDecoratedLeft(View paramView)
    {
      return paramView.getLeft() - getLeftDecorationWidth(paramView);
    }
    
    public int getDecoratedMeasuredHeight(View paramView)
    {
      Rect localRect = getLayoutParamsmDecorInsets;
      return paramView.getMeasuredHeight() + top + bottom;
    }
    
    public int getDecoratedMeasuredWidth(View paramView)
    {
      Rect localRect = getLayoutParamsmDecorInsets;
      return paramView.getMeasuredWidth() + left + right;
    }
    
    public int getDecoratedRight(View paramView)
    {
      return paramView.getRight() + getRightDecorationWidth(paramView);
    }
    
    public int getDecoratedTop(View paramView)
    {
      return paramView.getTop() - getTopDecorationHeight(paramView);
    }
    
    public final int getItemCount()
    {
      if (mRecyclerView != null) {}
      for (RecyclerView.Adapter localAdapter = mRecyclerView.getAdapter(); localAdapter != null; localAdapter = null) {
        return localAdapter.getItemCount();
      }
      return 0;
    }
    
    public final int getPaddingBottom()
    {
      if (mRecyclerView != null) {
        return mRecyclerView.getPaddingBottom();
      }
      return 0;
    }
    
    public final int getPaddingEnd()
    {
      if (mRecyclerView != null) {
        return ViewCompat.getPaddingEnd(mRecyclerView);
      }
      return 0;
    }
    
    public final int getPaddingLeft()
    {
      if (mRecyclerView != null) {
        return mRecyclerView.getPaddingLeft();
      }
      return 0;
    }
    
    public final int getPaddingRight()
    {
      if (mRecyclerView != null) {
        return mRecyclerView.getPaddingRight();
      }
      return 0;
    }
    
    public final int getPaddingStart()
    {
      if (mRecyclerView != null) {
        return ViewCompat.getPaddingStart(mRecyclerView);
      }
      return 0;
    }
    
    public final int getPaddingTop()
    {
      if (mRecyclerView != null) {
        return mRecyclerView.getPaddingTop();
      }
      return 0;
    }
    
    public int getRowCountForAccessibility(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      if ((mRecyclerView == null) || (mRecyclerView.mAdapter == null)) {}
      while (!canScrollVertically()) {
        return 1;
      }
      return mRecyclerView.mAdapter.getItemCount();
    }
    
    public final boolean isSmoothScrolling()
    {
      return (mSmoothScroller != null) && (mSmoothScroller.mRunning);
    }
    
    public void layoutDecorated(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      Rect localRect = getLayoutParamsmDecorInsets;
      paramView.layout(left + paramInt1, top + paramInt2, paramInt3 - right, paramInt4 - bottom);
    }
    
    public final void measureChild$17e143a3(View paramView)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = mRecyclerView.getItemDecorInsetsForChild(paramView);
      int k = left;
      int m = right;
      int i = top;
      int j = bottom;
      k = getChildMeasureSpec(mWidth, mWidthMode, getPaddingLeft() + getPaddingRight() + (k + m + 0), width, canScrollHorizontally());
      i = getChildMeasureSpec(mHeight, mHeightMode, getPaddingTop() + getPaddingBottom() + (i + j + 0), height, canScrollVertically());
      if (shouldMeasureChild(paramView, k, i, localLayoutParams)) {
        paramView.measure(k, i);
      }
    }
    
    public final void measureChildWithMargins$17e143a3(View paramView, int paramInt)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      Rect localRect = mRecyclerView.getItemDecorInsetsForChild(paramView);
      int k = left;
      int m = right;
      int i = top;
      int j = bottom;
      paramInt = getChildMeasureSpec(mWidth, mWidthMode, getPaddingLeft() + getPaddingRight() + leftMargin + rightMargin + (paramInt + (k + m)), width, canScrollHorizontally());
      i = getChildMeasureSpec(mHeight, mHeightMode, getPaddingTop() + getPaddingBottom() + topMargin + bottomMargin + (i + j + 0), height, canScrollVertically());
      if (shouldMeasureChild(paramView, paramInt, i, localLayoutParams)) {
        paramView.measure(paramInt, i);
      }
    }
    
    public void offsetChildrenHorizontal(int paramInt)
    {
      if (mRecyclerView != null)
      {
        RecyclerView localRecyclerView = mRecyclerView;
        int j = mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          mChildHelper.getChildAt(i).offsetLeftAndRight(paramInt);
          i += 1;
        }
      }
    }
    
    public void offsetChildrenVertical(int paramInt)
    {
      if (mRecyclerView != null)
      {
        RecyclerView localRecyclerView = mRecyclerView;
        int j = mChildHelper.getChildCount();
        int i = 0;
        while (i < j)
        {
          mChildHelper.getChildAt(i).offsetTopAndBottom(paramInt);
          i += 1;
        }
      }
    }
    
    public void onAdapterChanged$69e7eefb() {}
    
    public void onDetachedFromWindow(RecyclerView paramRecyclerView, RecyclerView.Recycler paramRecycler) {}
    
    public View onFocusSearchFailed(View paramView, int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return null;
    }
    
    public void onInitializeAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
    {
      boolean bool2 = true;
      Object localObject = mRecyclerView.mRecycler;
      localObject = mRecyclerView.mState;
      paramAccessibilityEvent = AccessibilityEventCompat.asRecord(paramAccessibilityEvent);
      if (mRecyclerView == null) {
        return;
      }
      boolean bool1 = bool2;
      if (!ViewCompat.canScrollVertically(mRecyclerView, 1))
      {
        bool1 = bool2;
        if (!ViewCompat.canScrollVertically(mRecyclerView, -1))
        {
          bool1 = bool2;
          if (!ViewCompat.canScrollHorizontally(mRecyclerView, -1)) {
            if (!ViewCompat.canScrollHorizontally(mRecyclerView, 1)) {
              break label115;
            }
          }
        }
      }
      label115:
      for (bool1 = bool2;; bool1 = false)
      {
        paramAccessibilityEvent.setScrollable(bool1);
        if (mRecyclerView.mAdapter == null) {
          break;
        }
        paramAccessibilityEvent.setItemCount(mRecyclerView.mAdapter.getItemCount());
        return;
      }
    }
    
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      int i;
      if (canScrollVertically())
      {
        i = getPosition(paramView);
        if (!canScrollHorizontally()) {
          break label48;
        }
      }
      label48:
      for (int j = getPosition(paramView);; j = 0)
      {
        paramAccessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain$430787b1(i, 1, j, 1, false));
        return;
        i = 0;
        break;
      }
    }
    
    final void onInitializeAccessibilityNodeInfoForItem(View paramView, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if ((localViewHolder != null) && (!localViewHolder.isRemoved()) && (!mChildHelper.isHidden(itemView))) {
        onInitializeAccessibilityNodeInfoForItem(mRecyclerView.mRecycler, mRecyclerView.mState, paramView, paramAccessibilityNodeInfoCompat);
      }
    }
    
    public void onItemsAdded$5927c743(int paramInt1, int paramInt2) {}
    
    public void onItemsChanged$57043c5d() {}
    
    public void onItemsMoved$342e6be0(int paramInt1, int paramInt2) {}
    
    public void onItemsRemoved$5927c743(int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
    
    public void onItemsUpdated$783f8c5f(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      onItemsUpdated(paramRecyclerView, paramInt1, paramInt2);
    }
    
    public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
    }
    
    public void onMeasure(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState, int paramInt1, int paramInt2)
    {
      mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
    }
    
    public void onRestoreInstanceState(Parcelable paramParcelable) {}
    
    public Parcelable onSaveInstanceState()
    {
      return null;
    }
    
    public void onScrollStateChanged(int paramInt) {}
    
    public final void removeAndRecycleAllViews(RecyclerView.Recycler paramRecycler)
    {
      int i = getChildCount() - 1;
      while (i >= 0)
      {
        if (!RecyclerView.getChildViewHolderInt(getChildAt(i)).shouldIgnore()) {
          removeAndRecycleViewAt(i, paramRecycler);
        }
        i -= 1;
      }
    }
    
    final void removeAndRecycleScrapInt(RecyclerView.Recycler paramRecycler)
    {
      int j = mAttachedScrap.size();
      int i = j - 1;
      while (i >= 0)
      {
        View localView = mAttachedScrap.get(i)).itemView;
        RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(localView);
        if (!localViewHolder.shouldIgnore())
        {
          localViewHolder.setIsRecyclable(false);
          if (localViewHolder.isTmpDetached()) {
            mRecyclerView.removeDetachedView(localView, false);
          }
          if (mRecyclerView.mItemAnimator != null) {
            mRecyclerView.mItemAnimator.endAnimation(localViewHolder);
          }
          localViewHolder.setIsRecyclable(true);
          paramRecycler.quickRecycleScrapView(localView);
        }
        i -= 1;
      }
      mAttachedScrap.clear();
      if (mChangedScrap != null) {
        mChangedScrap.clear();
      }
      if (j > 0) {
        mRecyclerView.invalidate();
      }
    }
    
    public final void removeAndRecycleView(View paramView, RecyclerView.Recycler paramRecycler)
    {
      ChildHelper localChildHelper = mChildHelper;
      int i = mCallback.indexOfChild(paramView);
      if (i >= 0)
      {
        if (mBucket.remove(i)) {
          localChildHelper.unhideViewInternal(paramView);
        }
        mCallback.removeViewAt(i);
      }
      paramRecycler.recycleView(paramView);
    }
    
    public final void removeAndRecycleViewAt(int paramInt, RecyclerView.Recycler paramRecycler)
    {
      View localView = getChildAt(paramInt);
      removeViewAt(paramInt);
      paramRecycler.recycleView(localView);
    }
    
    public final boolean removeCallbacks(Runnable paramRunnable)
    {
      if (mRecyclerView != null) {
        return mRecyclerView.removeCallbacks(paramRunnable);
      }
      return false;
    }
    
    public final void requestLayout()
    {
      if (mRecyclerView != null) {
        mRecyclerView.requestLayout();
      }
    }
    
    public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }
    
    public void scrollToPosition(int paramInt) {}
    
    public int scrollVerticallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      return 0;
    }
    
    final void setExactMeasureSpecsFrom(RecyclerView paramRecyclerView)
    {
      setMeasureSpecs(View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(paramRecyclerView.getHeight(), 1073741824));
    }
    
    final void setMeasureSpecs(int paramInt1, int paramInt2)
    {
      mWidth = View.MeasureSpec.getSize(paramInt1);
      mWidthMode = View.MeasureSpec.getMode(paramInt1);
      if ((mWidthMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        mWidth = 0;
      }
      mHeight = View.MeasureSpec.getSize(paramInt2);
      mHeightMode = View.MeasureSpec.getMode(paramInt2);
      if ((mHeightMode == 0) && (!RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC)) {
        mHeight = 0;
      }
    }
    
    public final void setMeasuredDimension(int paramInt1, int paramInt2)
    {
      mRecyclerView.setMeasuredDimension(paramInt1, paramInt2);
    }
    
    public void setMeasuredDimension(Rect paramRect, int paramInt1, int paramInt2)
    {
      int i = paramRect.width();
      int j = getPaddingLeft();
      int k = getPaddingRight();
      int m = paramRect.height();
      int n = getPaddingTop();
      int i1 = getPaddingBottom();
      setMeasuredDimension(chooseSize(paramInt1, i + j + k, ViewCompat.getMinimumWidth(mRecyclerView)), chooseSize(paramInt2, m + n + i1, ViewCompat.getMinimumHeight(mRecyclerView)));
    }
    
    final void setMeasuredDimensionFromChildren(int paramInt1, int paramInt2)
    {
      int i6 = getChildCount();
      if (i6 == 0)
      {
        mRecyclerView.defaultOnMeasure(paramInt1, paramInt2);
        return;
      }
      int i1 = Integer.MAX_VALUE;
      int j = Integer.MAX_VALUE;
      int n = Integer.MIN_VALUE;
      int i = Integer.MIN_VALUE;
      int k = 0;
      while (k < i6)
      {
        View localView = getChildAt(k);
        RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)localView.getLayoutParams();
        int i5 = getDecoratedLeft(localView) - leftMargin;
        int i2 = getDecoratedRight(localView) + rightMargin;
        int i4 = getDecoratedTop(localView) - topMargin;
        int i3 = getDecoratedBottom(localView) + bottomMargin;
        int m = i1;
        if (i5 < i1) {
          m = i5;
        }
        i1 = n;
        if (i2 > n) {
          i1 = i2;
        }
        i2 = j;
        if (i4 < j) {
          i2 = i4;
        }
        j = i;
        if (i3 > i) {
          j = i3;
        }
        k += 1;
        n = i1;
        i = j;
        i1 = m;
        j = i2;
      }
      mRecyclerView.mTempRect.set(i1, j, n, i);
      setMeasuredDimension(mRecyclerView.mTempRect, paramInt1, paramInt2);
    }
    
    final void setRecyclerView(RecyclerView paramRecyclerView)
    {
      if (paramRecyclerView == null)
      {
        mRecyclerView = null;
        mChildHelper = null;
        mWidth = 0;
      }
      for (mHeight = 0;; mHeight = paramRecyclerView.getHeight())
      {
        mWidthMode = 1073741824;
        mHeightMode = 1073741824;
        return;
        mRecyclerView = paramRecyclerView;
        mChildHelper = mChildHelper;
        mWidth = paramRecyclerView.getWidth();
      }
    }
    
    final boolean shouldMeasureChild(View paramView, int paramInt1, int paramInt2, RecyclerView.LayoutParams paramLayoutParams)
    {
      return (paramView.isLayoutRequested()) || (!mMeasurementCacheEnabled) || (!isMeasurementUpToDate(paramView.getWidth(), paramInt1, width)) || (!isMeasurementUpToDate(paramView.getHeight(), paramInt2, height));
    }
    
    boolean shouldMeasureTwice()
    {
      return false;
    }
    
    public void smoothScrollToPosition$7d69765f(RecyclerView paramRecyclerView, int paramInt)
    {
      Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
    }
    
    public final void startSmoothScroll(RecyclerView.SmoothScroller paramSmoothScroller)
    {
      if ((mSmoothScroller != null) && (paramSmoothScroller != mSmoothScroller) && (mSmoothScroller.mRunning)) {
        mSmoothScroller.stop();
      }
      mSmoothScroller = paramSmoothScroller;
      paramSmoothScroller = mSmoothScroller;
      mRecyclerView = mRecyclerView;
      mLayoutManager = this;
      if (mTargetPosition == -1) {
        throw new IllegalArgumentException("Invalid target position");
      }
      mRecyclerView.mState.mTargetPosition = mTargetPosition;
      mRunning = true;
      mPendingInitialRun = true;
      int i = mTargetPosition;
      mTargetView = mRecyclerView.mLayout.findViewByPosition(i);
      mRecyclerView.mViewFlinger.postOnAnimation();
    }
    
    final void stopSmoothScroller()
    {
      if (mSmoothScroller != null) {
        mSmoothScroller.stop();
      }
    }
    
    public boolean supportsPredictiveItemAnimations()
    {
      return false;
    }
    
    public static final class Properties
    {
      public int orientation;
      public boolean reverseLayout;
      public int spanCount;
      public boolean stackFromEnd;
    }
  }
  
  public static class LayoutParams
    extends ViewGroup.MarginLayoutParams
  {
    final Rect mDecorInsets = new Rect();
    public boolean mInsetsDirty = true;
    boolean mPendingInvalidate = false;
    RecyclerView.ViewHolder mViewHolder;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public LayoutParams(LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LayoutParams(ViewGroup.MarginLayoutParams paramMarginLayoutParams)
    {
      super();
    }
  }
  
  public static abstract interface OnChildAttachStateChangeListener
  {
    public abstract void onChildViewAttachedToWindow(View paramView);
    
    public abstract void onChildViewDetachedFromWindow(View paramView);
  }
  
  public static abstract interface OnItemTouchListener
  {
    public abstract boolean onInterceptTouchEvent(RecyclerView paramRecyclerView, MotionEvent paramMotionEvent);
    
    public abstract void onRequestDisallowInterceptTouchEvent(boolean paramBoolean);
    
    public abstract void onTouchEvent$606727f8(MotionEvent paramMotionEvent);
  }
  
  public static abstract class OnScrollListener
  {
    public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt) {}
    
    public void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2) {}
  }
  
  public static class RecycledViewPool
  {
    int mAttachCount = 0;
    private SparseIntArray mMaxScrap = new SparseIntArray();
    SparseArray<ArrayList<RecyclerView.ViewHolder>> mScrap = new SparseArray();
    
    final void attach$b0de1c8()
    {
      mAttachCount += 1;
    }
    
    final void detach()
    {
      mAttachCount -= 1;
    }
    
    public RecyclerView.ViewHolder getRecycledView(int paramInt)
    {
      ArrayList localArrayList = (ArrayList)mScrap.get(paramInt);
      if ((localArrayList != null) && (!localArrayList.isEmpty()))
      {
        paramInt = localArrayList.size() - 1;
        RecyclerView.ViewHolder localViewHolder = (RecyclerView.ViewHolder)localArrayList.get(paramInt);
        localArrayList.remove(paramInt);
        return localViewHolder;
      }
      return null;
    }
    
    public void putRecycledView(RecyclerView.ViewHolder paramViewHolder)
    {
      int i = paramViewHolder.getItemViewType();
      Object localObject = (ArrayList)mScrap.get(i);
      if (localObject == null)
      {
        ArrayList localArrayList = new ArrayList();
        mScrap.put(i, localArrayList);
        localObject = localArrayList;
        if (mMaxScrap.indexOfKey(i) < 0)
        {
          mMaxScrap.put(i, 5);
          localObject = localArrayList;
        }
      }
      for (;;)
      {
        if (mMaxScrap.get(i) <= ((ArrayList)localObject).size()) {
          return;
        }
        paramViewHolder.resetInternal();
        ((ArrayList)localObject).add(paramViewHolder);
        return;
      }
    }
  }
  
  public final class Recycler
  {
    final ArrayList<RecyclerView.ViewHolder> mAttachedScrap = new ArrayList();
    final ArrayList<RecyclerView.ViewHolder> mCachedViews = new ArrayList();
    ArrayList<RecyclerView.ViewHolder> mChangedScrap = null;
    RecyclerView.RecycledViewPool mRecyclerPool;
    final List<RecyclerView.ViewHolder> mUnmodifiableAttachedScrap = Collections.unmodifiableList(mAttachedScrap);
    RecyclerView.ViewCacheExtension mViewCacheExtension;
    int mViewCacheMax = 2;
    
    public Recycler() {}
    
    private void addViewHolderToRecycledViewPool(RecyclerView.ViewHolder paramViewHolder)
    {
      ViewCompat.setAccessibilityDelegate(itemView, null);
      if ((mRecyclerListener == null) || (mAdapter != null)) {
        mAdapter.onViewRecycled(paramViewHolder);
      }
      if (mState != null) {
        mViewInfoStore.removeViewHolder(paramViewHolder);
      }
      mOwnerRecyclerView = null;
      getRecycledViewPool().putRecycledView(paramViewHolder);
    }
    
    private void attachAccessibilityDelegate(View paramView)
    {
      if (isAccessibilityEnabled())
      {
        if (ViewCompat.getImportantForAccessibility(paramView) == 0) {
          ViewCompat.setImportantForAccessibility(paramView, 1);
        }
        if (!ViewCompat.hasAccessibilityDelegate(paramView)) {
          ViewCompat.setAccessibilityDelegate(paramView, mAccessibilityDelegate.mItemDelegate);
        }
      }
    }
    
    private RecyclerView.ViewHolder getChangedScrapViewForPosition(int paramInt)
    {
      int j;
      if (mChangedScrap != null)
      {
        j = mChangedScrap.size();
        if (j != 0) {}
      }
      else
      {
        return null;
      }
      int i = 0;
      RecyclerView.ViewHolder localViewHolder;
      while (i < j)
      {
        localViewHolder = (RecyclerView.ViewHolder)mChangedScrap.get(i);
        if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getLayoutPosition() == paramInt))
        {
          localViewHolder.addFlags(32);
          return localViewHolder;
        }
        i += 1;
      }
      if (mAdapter.hasStableIds())
      {
        paramInt = mAdapterHelper.findPositionOffset(paramInt, 0);
        if ((paramInt > 0) && (paramInt < mAdapter.getItemCount()))
        {
          long l = mAdapter.getItemId(paramInt);
          paramInt = 0;
          while (paramInt < j)
          {
            localViewHolder = (RecyclerView.ViewHolder)mChangedScrap.get(paramInt);
            if ((!localViewHolder.wasReturnedFromScrap()) && (localViewHolder.getItemId() == l))
            {
              localViewHolder.addFlags(32);
              return localViewHolder;
            }
            paramInt += 1;
          }
        }
      }
      return null;
    }
    
    private RecyclerView.ViewHolder getScrapViewForId$302a751d(long paramLong, int paramInt)
    {
      int i = mAttachedScrap.size() - 1;
      RecyclerView.ViewHolder localViewHolder;
      while (i >= 0)
      {
        localViewHolder = (RecyclerView.ViewHolder)mAttachedScrap.get(i);
        if ((localViewHolder.getItemId() == paramLong) && (!localViewHolder.wasReturnedFromScrap()))
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            localViewHolder.addFlags(32);
            if ((localViewHolder.isRemoved()) && (!mState.mInPreLayout)) {
              localViewHolder.setFlags(2, 14);
            }
            return localViewHolder;
          }
          mAttachedScrap.remove(i);
          removeDetachedView(itemView, false);
          quickRecycleScrapView(itemView);
        }
        i -= 1;
      }
      i = mCachedViews.size() - 1;
      while (i >= 0)
      {
        localViewHolder = (RecyclerView.ViewHolder)mCachedViews.get(i);
        if (localViewHolder.getItemId() == paramLong)
        {
          if (paramInt == localViewHolder.getItemViewType())
          {
            mCachedViews.remove(i);
            return localViewHolder;
          }
          recycleCachedViewAt(i);
        }
        i -= 1;
      }
      return null;
    }
    
    private RecyclerView.ViewHolder getScrapViewForPosition$6d61fdc$7d85d05d(int paramInt)
    {
      int j = mAttachedScrap.size();
      int i = 0;
      Object localObject1;
      while (i < j)
      {
        localObject1 = (RecyclerView.ViewHolder)mAttachedScrap.get(i);
        if ((!((RecyclerView.ViewHolder)localObject1).wasReturnedFromScrap()) && (((RecyclerView.ViewHolder)localObject1).getLayoutPosition() == paramInt) && (!((RecyclerView.ViewHolder)localObject1).isInvalid()) && ((mState.mInPreLayout) || (!((RecyclerView.ViewHolder)localObject1).isRemoved())))
        {
          ((RecyclerView.ViewHolder)localObject1).addFlags(32);
          return (RecyclerView.ViewHolder)localObject1;
        }
        i += 1;
      }
      Object localObject2 = mChildHelper;
      j = mHiddenViews.size();
      i = 0;
      Object localObject3;
      if (i < j)
      {
        localObject1 = (View)mHiddenViews.get(i);
        localObject3 = mCallback.getChildViewHolder((View)localObject1);
        if ((((RecyclerView.ViewHolder)localObject3).getLayoutPosition() != paramInt) || (((RecyclerView.ViewHolder)localObject3).isInvalid()) || (((RecyclerView.ViewHolder)localObject3).isRemoved())) {}
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = RecyclerView.getChildViewHolderInt((View)localObject1);
          localObject3 = mChildHelper;
          paramInt = mCallback.indexOfChild((View)localObject1);
          if (paramInt < 0)
          {
            throw new IllegalArgumentException("view is not a child, cannot hide " + localObject1);
            i += 1;
            break;
            localObject1 = null;
            continue;
          }
          if (!mBucket.get(paramInt)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + localObject1);
          }
          mBucket.clear(paramInt);
          ((ChildHelper)localObject3).unhideViewInternal((View)localObject1);
          paramInt = mChildHelper.indexOfChild((View)localObject1);
          if (paramInt == -1) {
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + localObject2);
          }
          mChildHelper.detachViewFromParent(paramInt);
          scrapView((View)localObject1);
          ((RecyclerView.ViewHolder)localObject2).addFlags(8224);
          return (RecyclerView.ViewHolder)localObject2;
        }
      }
      j = mCachedViews.size();
      i = 0;
      while (i < j)
      {
        localObject1 = (RecyclerView.ViewHolder)mCachedViews.get(i);
        if ((!((RecyclerView.ViewHolder)localObject1).isInvalid()) && (((RecyclerView.ViewHolder)localObject1).getLayoutPosition() == paramInt))
        {
          mCachedViews.remove(i);
          return (RecyclerView.ViewHolder)localObject1;
        }
        i += 1;
      }
      return null;
    }
    
    private void invalidateDisplayListInt(ViewGroup paramViewGroup, boolean paramBoolean)
    {
      int i = paramViewGroup.getChildCount() - 1;
      while (i >= 0)
      {
        View localView = paramViewGroup.getChildAt(i);
        if ((localView instanceof ViewGroup)) {
          invalidateDisplayListInt((ViewGroup)localView, true);
        }
        i -= 1;
      }
      if (!paramBoolean) {
        return;
      }
      if (paramViewGroup.getVisibility() == 4)
      {
        paramViewGroup.setVisibility(0);
        paramViewGroup.setVisibility(4);
        return;
      }
      i = paramViewGroup.getVisibility();
      paramViewGroup.setVisibility(4);
      paramViewGroup.setVisibility(i);
    }
    
    public final void bindViewToPosition(View paramView, int paramInt)
    {
      boolean bool = true;
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder == null) {
        throw new IllegalArgumentException("The view does not have a ViewHolder. You cannot pass arbitrary views to this method, they should be created by the Adapter");
      }
      int i = mAdapterHelper.findPositionOffset(paramInt);
      if ((i < 0) || (i >= mAdapter.getItemCount())) {
        throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + i + ").state:" + mState.getItemCount());
      }
      mOwnerRecyclerView = RecyclerView.this;
      mAdapter.bindViewHolder(localViewHolder, i);
      attachAccessibilityDelegate(paramView);
      if (mState.mInPreLayout) {
        mPreLayoutPosition = paramInt;
      }
      paramView = itemView.getLayoutParams();
      if (paramView == null)
      {
        paramView = (RecyclerView.LayoutParams)generateDefaultLayoutParams();
        itemView.setLayoutParams(paramView);
        mInsetsDirty = true;
        mViewHolder = localViewHolder;
        if (itemView.getParent() != null) {
          break label260;
        }
      }
      for (;;)
      {
        mPendingInvalidate = bool;
        return;
        if (!checkLayoutParams(paramView))
        {
          paramView = (RecyclerView.LayoutParams)generateLayoutParams(paramView);
          itemView.setLayoutParams(paramView);
          break;
        }
        paramView = (RecyclerView.LayoutParams)paramView;
        break;
        label260:
        bool = false;
      }
    }
    
    public final void clear()
    {
      mAttachedScrap.clear();
      recycleAndClearCachedViews();
    }
    
    public final int convertPreLayoutPositionToPostLayout(int paramInt)
    {
      if ((paramInt < 0) || (paramInt >= mState.getItemCount())) {
        throw new IndexOutOfBoundsException("invalid position " + paramInt + ". State item count is " + mState.getItemCount());
      }
      if (!mState.mInPreLayout) {
        return paramInt;
      }
      return mAdapterHelper.findPositionOffset(paramInt);
    }
    
    final RecyclerView.RecycledViewPool getRecycledViewPool()
    {
      if (mRecyclerPool == null) {
        mRecyclerPool = new RecyclerView.RecycledViewPool();
      }
      return mRecyclerPool;
    }
    
    public final View getViewForPosition(int paramInt)
    {
      boolean bool2 = true;
      if ((paramInt < 0) || (paramInt >= mState.getItemCount())) {
        throw new IndexOutOfBoundsException("Invalid item position " + paramInt + "(" + paramInt + "). Item count:" + mState.getItemCount());
      }
      Object localObject2;
      int i;
      if (mState.mInPreLayout)
      {
        localObject2 = getChangedScrapViewForPosition(paramInt);
        if (localObject2 != null) {
          i = 1;
        }
      }
      for (;;)
      {
        Object localObject1 = localObject2;
        boolean bool1;
        if (localObject2 == null)
        {
          localObject2 = getScrapViewForPosition$6d61fdc$7d85d05d(paramInt);
          localObject1 = localObject2;
          if (localObject2 != null) {
            if (((RecyclerView.ViewHolder)localObject2).isRemoved())
            {
              bool1 = mState.mInPreLayout;
              label147:
              if (bool1) {
                break label457;
              }
              ((RecyclerView.ViewHolder)localObject2).addFlags(4);
              if (!((RecyclerView.ViewHolder)localObject2).isScrap()) {
                break label441;
              }
              removeDetachedView(itemView, false);
              ((RecyclerView.ViewHolder)localObject2).unScrap();
              label184:
              recycleViewHolderInternal((RecyclerView.ViewHolder)localObject2);
              localObject1 = null;
            }
          }
        }
        for (;;)
        {
          Object localObject3 = localObject1;
          int k = i;
          label441:
          label457:
          int j;
          if (localObject1 == null)
          {
            k = mAdapterHelper.findPositionOffset(paramInt);
            if ((k < 0) || (k >= mAdapter.getItemCount()))
            {
              throw new IndexOutOfBoundsException("Inconsistency detected. Invalid item position " + paramInt + "(offset:" + k + ").state:" + mState.getItemCount());
              i = 0;
              break;
              if ((mPosition < 0) || (mPosition >= mAdapter.getItemCount())) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + localObject2);
              }
              if ((!mState.mInPreLayout) && (mAdapter.getItemViewType(mPosition) != ((RecyclerView.ViewHolder)localObject2).getItemViewType()))
              {
                bool1 = false;
                break label147;
              }
              if ((mAdapter.hasStableIds()) && (((RecyclerView.ViewHolder)localObject2).getItemId() != mAdapter.getItemId(mPosition)))
              {
                bool1 = false;
                break label147;
              }
              bool1 = true;
              break label147;
              if (!((RecyclerView.ViewHolder)localObject2).wasReturnedFromScrap()) {
                break label184;
              }
              ((RecyclerView.ViewHolder)localObject2).clearReturnedFromScrapFlag();
              break label184;
              i = 1;
              localObject1 = localObject2;
              continue;
            }
            int m = mAdapter.getItemViewType(k);
            localObject2 = localObject1;
            j = i;
            if (mAdapter.hasStableIds())
            {
              localObject1 = getScrapViewForId$302a751d(mAdapter.getItemId(k), m);
              localObject2 = localObject1;
              j = i;
              if (localObject1 != null)
              {
                mPosition = k;
                j = 1;
                localObject2 = localObject1;
              }
            }
            localObject1 = localObject2;
            if (localObject2 == null)
            {
              localObject1 = localObject2;
              if (mViewCacheExtension != null)
              {
                localObject3 = mViewCacheExtension.getViewForPositionAndType$430f8374();
                localObject1 = localObject2;
                if (localObject3 != null)
                {
                  localObject2 = getChildViewHolder((View)localObject3);
                  if (localObject2 == null) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view which does not have a ViewHolder");
                  }
                  localObject1 = localObject2;
                  if (((RecyclerView.ViewHolder)localObject2).shouldIgnore()) {
                    throw new IllegalArgumentException("getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view.");
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (localObject1 == null)
            {
              localObject2 = getRecycledViewPool().getRecycledView(m);
              if (localObject2 != null)
              {
                ((RecyclerView.ViewHolder)localObject2).resetInternal();
                if ((RecyclerView.FORCE_INVALIDATE_DISPLAY_LIST) && ((itemView instanceof ViewGroup))) {
                  invalidateDisplayListInt((ViewGroup)itemView, false);
                }
              }
            }
            localObject3 = localObject2;
            k = j;
            if (localObject2 == null) {
              localObject2 = mAdapter.createViewHolder(RecyclerView.this, m);
            }
          }
          for (i = j;; i = k)
          {
            if ((i != 0) && (!mState.mInPreLayout) && (((RecyclerView.ViewHolder)localObject2).hasAnyOfTheFlags(8192)))
            {
              ((RecyclerView.ViewHolder)localObject2).setFlags(0, 8192);
              if (mState.mRunSimpleAnimations)
              {
                RecyclerView.ItemAnimator.buildAdapterChangeFlagsForAnimations((RecyclerView.ViewHolder)localObject2);
                localObject1 = mItemAnimator;
                localObject1 = mState;
                ((RecyclerView.ViewHolder)localObject2).getUnmodifiedPayloads();
                localObject1 = new RecyclerView.ItemAnimator.ItemHolderInfo().setFrom((RecyclerView.ViewHolder)localObject2);
                RecyclerView.this.recordAnimationInfoIfBouncedHiddenView((RecyclerView.ViewHolder)localObject2, (RecyclerView.ItemAnimator.ItemHolderInfo)localObject1);
              }
            }
            if ((mState.mInPreLayout) && (((RecyclerView.ViewHolder)localObject2).isBound()))
            {
              mPreLayoutPosition = paramInt;
              paramInt = 0;
            }
            for (;;)
            {
              localObject1 = itemView.getLayoutParams();
              if (localObject1 == null)
              {
                localObject1 = (RecyclerView.LayoutParams)generateDefaultLayoutParams();
                itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                label894:
                mViewHolder = ((RecyclerView.ViewHolder)localObject2);
                if ((i == 0) || (paramInt == 0)) {
                  break label1066;
                }
              }
              label1066:
              for (bool1 = bool2;; bool1 = false)
              {
                mPendingInvalidate = bool1;
                return itemView;
                if ((((RecyclerView.ViewHolder)localObject2).isBound()) && (!((RecyclerView.ViewHolder)localObject2).needsUpdate()) && (!((RecyclerView.ViewHolder)localObject2).isInvalid())) {
                  break label1072;
                }
                j = mAdapterHelper.findPositionOffset(paramInt);
                mOwnerRecyclerView = RecyclerView.this;
                mAdapter.bindViewHolder((RecyclerView.ViewHolder)localObject2, j);
                attachAccessibilityDelegate(itemView);
                if (mState.mInPreLayout) {
                  mPreLayoutPosition = paramInt;
                }
                paramInt = 1;
                break;
                if (!checkLayoutParams((ViewGroup.LayoutParams)localObject1))
                {
                  localObject1 = (RecyclerView.LayoutParams)generateLayoutParams((ViewGroup.LayoutParams)localObject1);
                  itemView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
                  break label894;
                }
                localObject1 = (RecyclerView.LayoutParams)localObject1;
                break label894;
              }
              label1072:
              paramInt = 0;
            }
            localObject2 = localObject3;
          }
        }
        localObject2 = null;
        i = 0;
      }
    }
    
    final void quickRecycleScrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      RecyclerView.ViewHolder.access$5002(paramView, null);
      RecyclerView.ViewHolder.access$5102(paramView, false);
      paramView.clearReturnedFromScrapFlag();
      recycleViewHolderInternal(paramView);
    }
    
    final void recycleAndClearCachedViews()
    {
      int i = mCachedViews.size() - 1;
      while (i >= 0)
      {
        recycleCachedViewAt(i);
        i -= 1;
      }
      mCachedViews.clear();
    }
    
    final void recycleCachedViewAt(int paramInt)
    {
      addViewHolderToRecycledViewPool((RecyclerView.ViewHolder)mCachedViews.get(paramInt));
      mCachedViews.remove(paramInt);
    }
    
    public final void recycleView(View paramView)
    {
      RecyclerView.ViewHolder localViewHolder = RecyclerView.getChildViewHolderInt(paramView);
      if (localViewHolder.isTmpDetached()) {
        removeDetachedView(paramView, false);
      }
      if (localViewHolder.isScrap()) {
        localViewHolder.unScrap();
      }
      for (;;)
      {
        recycleViewHolderInternal(localViewHolder);
        return;
        if (localViewHolder.wasReturnedFromScrap()) {
          localViewHolder.clearReturnedFromScrapFlag();
        }
      }
    }
    
    final void recycleViewHolderInternal(RecyclerView.ViewHolder paramViewHolder)
    {
      boolean bool = true;
      if ((paramViewHolder.isScrap()) || (itemView.getParent() != null))
      {
        StringBuilder localStringBuilder = new StringBuilder("Scrapped or attached views may not be recycled. isScrap:").append(paramViewHolder.isScrap()).append(" isAttached:");
        if (itemView.getParent() != null) {}
        for (;;)
        {
          throw new IllegalArgumentException(bool);
          bool = false;
        }
      }
      if (paramViewHolder.isTmpDetached()) {
        throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + paramViewHolder);
      }
      if (paramViewHolder.shouldIgnore()) {
        throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle.");
      }
      bool = RecyclerView.ViewHolder.access$4900(paramViewHolder);
      if ((mAdapter != null) && (bool) && (mAdapter.onFailedToRecycleView(paramViewHolder))) {}
      for (int i = 1;; i = 0)
      {
        int j = 0;
        int n = 0;
        int m = 0;
        int k;
        if (i == 0)
        {
          k = m;
          if (!paramViewHolder.isRecyclable()) {}
        }
        else
        {
          i = n;
          if (!paramViewHolder.hasAnyOfTheFlags(14))
          {
            j = mCachedViews.size();
            if ((j == mViewCacheMax) && (j > 0)) {
              recycleCachedViewAt(0);
            }
            i = n;
            if (j < mViewCacheMax)
            {
              mCachedViews.add(paramViewHolder);
              i = 1;
            }
          }
          j = i;
          k = m;
          if (i == 0)
          {
            addViewHolderToRecycledViewPool(paramViewHolder);
            k = 1;
            j = i;
          }
        }
        mViewInfoStore.removeViewHolder(paramViewHolder);
        if ((j == 0) && (k == 0) && (bool)) {
          mOwnerRecyclerView = null;
        }
        return;
      }
    }
    
    final void scrapView(View paramView)
    {
      paramView = RecyclerView.getChildViewHolderInt(paramView);
      if ((paramView.hasAnyOfTheFlags(12)) || (!paramView.isUpdated()) || (RecyclerView.access$5200(RecyclerView.this, paramView)))
      {
        if ((paramView.isInvalid()) && (!paramView.isRemoved()) && (!mAdapter.hasStableIds())) {
          throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool.");
        }
        paramView.setScrapContainer(this, false);
        mAttachedScrap.add(paramView);
        return;
      }
      if (mChangedScrap == null) {
        mChangedScrap = new ArrayList();
      }
      paramView.setScrapContainer(this, true);
      mChangedScrap.add(paramView);
    }
    
    final void unscrapView(RecyclerView.ViewHolder paramViewHolder)
    {
      if (RecyclerView.ViewHolder.access$5100(paramViewHolder)) {
        mChangedScrap.remove(paramViewHolder);
      }
      for (;;)
      {
        RecyclerView.ViewHolder.access$5002(paramViewHolder, null);
        RecyclerView.ViewHolder.access$5102(paramViewHolder, false);
        paramViewHolder.clearReturnedFromScrapFlag();
        return;
        mAttachedScrap.remove(paramViewHolder);
      }
    }
  }
  
  public static abstract interface RecyclerListener {}
  
  private final class RecyclerViewDataObserver
    extends RecyclerView.AdapterDataObserver
  {
    private RecyclerViewDataObserver() {}
    
    private void triggerUpdateProcessor()
    {
      if ((mPostUpdatesOnAnimation) && (mHasFixedSize) && (mIsAttached))
      {
        ViewCompat.postOnAnimation(RecyclerView.this, mUpdateChildViewsRunnable);
        return;
      }
      RecyclerView.access$4502$767d6395(RecyclerView.this);
      requestLayout();
    }
    
    public final void onChanged()
    {
      assertNotInLayoutOrScroll(null);
      mAdapter.hasStableIds();
      mState.mStructureChanged = true;
      RecyclerView.access$4000(RecyclerView.this);
      if (!mAdapterHelper.hasPendingUpdates()) {
        requestLayout();
      }
    }
    
    public final void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      int i = 1;
      assertNotInLayoutOrScroll(null);
      AdapterHelper localAdapterHelper = mAdapterHelper;
      mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
      mExistingUpdateTypes |= 0x4;
      if (mPendingUpdates.size() == 1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          triggerUpdateProcessor();
        }
        return;
      }
    }
    
    public final void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      int i = 1;
      assertNotInLayoutOrScroll(null);
      AdapterHelper localAdapterHelper = mAdapterHelper;
      mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(1, paramInt1, paramInt2, null));
      mExistingUpdateTypes |= 0x1;
      if (mPendingUpdates.size() == 1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          triggerUpdateProcessor();
        }
        return;
      }
    }
    
    public final void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      int i = 1;
      assertNotInLayoutOrScroll(null);
      AdapterHelper localAdapterHelper = mAdapterHelper;
      if (paramInt1 != paramInt2)
      {
        if (paramInt3 != 1) {
          throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(8, paramInt1, paramInt2, null));
        mExistingUpdateTypes |= 0x8;
        if (mPendingUpdates.size() != 1) {}
      }
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          triggerUpdateProcessor();
        }
        return;
      }
    }
    
    public final void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      int i = 1;
      assertNotInLayoutOrScroll(null);
      AdapterHelper localAdapterHelper = mAdapterHelper;
      mPendingUpdates.add(localAdapterHelper.obtainUpdateOp(2, paramInt1, paramInt2, null));
      mExistingUpdateTypes |= 0x2;
      if (mPendingUpdates.size() == 1) {}
      for (paramInt1 = i;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          triggerUpdateProcessor();
        }
        return;
      }
    }
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator() {};
    Parcelable mLayoutState;
    
    SavedState(Parcel paramParcel)
    {
      super();
      mLayoutState = paramParcel.readParcelable(RecyclerView.LayoutManager.class.getClassLoader());
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeParcelable(mLayoutState, 0);
    }
  }
  
  public static abstract class SmoothScroller
  {
    public RecyclerView.LayoutManager mLayoutManager;
    boolean mPendingInitialRun;
    RecyclerView mRecyclerView;
    private final Action mRecyclingAction = new Action();
    boolean mRunning;
    public int mTargetPosition = -1;
    View mTargetView;
    
    public final int getChildCount()
    {
      return mRecyclerView.mLayout.getChildCount();
    }
    
    public void onChildAttachedToWindow(View paramView)
    {
      if (RecyclerView.getChildLayoutPosition(paramView) == mTargetPosition) {
        mTargetView = paramView;
      }
    }
    
    protected abstract void onSeekTargetStep$64702b56(int paramInt1, int paramInt2, Action paramAction);
    
    public abstract void onStop();
    
    public abstract void onTargetFound$68abd3fe(View paramView, Action paramAction);
    
    protected final void stop()
    {
      if (!mRunning) {
        return;
      }
      onStop();
      mRecyclerView.mState.mTargetPosition = -1;
      mTargetView = null;
      mTargetPosition = -1;
      mPendingInitialRun = false;
      mRunning = false;
      RecyclerView.LayoutManager.access$6000(mLayoutManager, this);
      mLayoutManager = null;
      mRecyclerView = null;
    }
    
    public static final class Action
    {
      private boolean changed = false;
      private int consecutiveUpdates = 0;
      private int mDuration = Integer.MIN_VALUE;
      private int mDx = 0;
      private int mDy = 0;
      private Interpolator mInterpolator = null;
      int mJumpToPosition = -1;
      
      public Action()
      {
        this((byte)0);
      }
      
      private Action(byte paramByte) {}
      
      public final void update(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
      {
        mDx = paramInt1;
        mDy = paramInt2;
        mDuration = paramInt3;
        mInterpolator = paramInterpolator;
        changed = true;
      }
    }
  }
  
  public static final class State
  {
    private SparseArray<Object> mData;
    int mDeletedInvisibleItemCountSincePreviousLayout = 0;
    boolean mInPreLayout = false;
    boolean mIsMeasuring = false;
    int mItemCount = 0;
    int mLayoutStep = 1;
    int mPreviousLayoutItemCount = 0;
    boolean mRunPredictiveAnimations = false;
    boolean mRunSimpleAnimations = false;
    boolean mStructureChanged = false;
    public int mTargetPosition = -1;
    boolean mTrackOldChangeHolders = false;
    
    final void assertLayoutStep(int paramInt)
    {
      if ((mLayoutStep & paramInt) == 0) {
        throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(paramInt) + " but it is " + Integer.toBinaryString(mLayoutStep));
      }
    }
    
    public final int getItemCount()
    {
      if (mInPreLayout) {
        return mPreviousLayoutItemCount - mDeletedInvisibleItemCountSincePreviousLayout;
      }
      return mItemCount;
    }
    
    public final String toString()
    {
      return "State{mTargetPosition=" + mTargetPosition + ", mData=" + mData + ", mItemCount=" + mItemCount + ", mPreviousLayoutItemCount=" + mPreviousLayoutItemCount + ", mDeletedInvisibleItemCountSincePreviousLayout=" + mDeletedInvisibleItemCountSincePreviousLayout + ", mStructureChanged=" + mStructureChanged + ", mInPreLayout=" + mInPreLayout + ", mRunSimpleAnimations=" + mRunSimpleAnimations + ", mRunPredictiveAnimations=" + mRunPredictiveAnimations + '}';
    }
  }
  
  public static abstract class ViewCacheExtension
  {
    public abstract View getViewForPositionAndType$430f8374();
  }
  
  private final class ViewFlinger
    implements Runnable
  {
    private boolean mEatRunOnAnimationRequest = false;
    private Interpolator mInterpolator = RecyclerView.sQuinticInterpolator;
    int mLastFlingX;
    int mLastFlingY;
    private boolean mReSchedulePostAnimationCallback = false;
    ScrollerCompat mScroller = ScrollerCompat.create(getContext(), RecyclerView.sQuinticInterpolator);
    
    public ViewFlinger() {}
    
    final void postOnAnimation()
    {
      if (mEatRunOnAnimationRequest)
      {
        mReSchedulePostAnimationCallback = true;
        return;
      }
      removeCallbacks(this);
      ViewCompat.postOnAnimation(RecyclerView.this, this);
    }
    
    public final void run()
    {
      if (mLayout == null)
      {
        stop();
        return;
      }
      mReSchedulePostAnimationCallback = false;
      mEatRunOnAnimationRequest = true;
      RecyclerView.this.consumePendingUpdateOperations();
      ScrollerCompat localScrollerCompat = mScroller;
      RecyclerView.SmoothScroller localSmoothScroller = mLayout.mSmoothScroller;
      int i4;
      int i5;
      int n;
      int i;
      int i3;
      int m;
      int i1;
      int j;
      int i2;
      int k;
      label348:
      label424:
      label441:
      RecyclerView localRecyclerView;
      if (localScrollerCompat.computeScrollOffset())
      {
        int i6 = localScrollerCompat.getCurrX();
        int i7 = localScrollerCompat.getCurrY();
        i4 = i6 - mLastFlingX;
        i5 = i7 - mLastFlingY;
        n = 0;
        i = 0;
        i3 = 0;
        m = 0;
        mLastFlingX = i6;
        mLastFlingY = i7;
        i1 = 0;
        j = 0;
        i2 = 0;
        k = 0;
        if (mAdapter != null)
        {
          eatRequestLayout();
          RecyclerView.this.onEnterLayoutOrScroll();
          TraceCompat.beginSection("RV Scroll");
          if (i4 != 0)
          {
            i = mLayout.scrollHorizontallyBy(i4, mRecycler, mState);
            j = i4 - i;
          }
          if (i5 != 0)
          {
            m = mLayout.scrollVerticallyBy(i5, mRecycler, mState);
            k = i5 - m;
          }
          TraceCompat.endSection();
          RecyclerView.this.repositionShadowingViews();
          RecyclerView.this.onExitLayoutOrScroll();
          resumeRequestLayout(false);
          n = i;
          i1 = j;
          i2 = k;
          i3 = m;
          if (localSmoothScroller != null)
          {
            n = i;
            i1 = j;
            i2 = k;
            i3 = m;
            if (!mPendingInitialRun)
            {
              n = i;
              i1 = j;
              i2 = k;
              i3 = m;
              if (mRunning)
              {
                n = mState.getItemCount();
                if (n != 0) {
                  break label735;
                }
                localSmoothScroller.stop();
                i3 = m;
                i2 = k;
                i1 = j;
                n = i;
              }
            }
          }
        }
        if (!mItemDecorations.isEmpty()) {
          invalidate();
        }
        if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2) {
          RecyclerView.this.considerReleasingGlowsOnScroll(i4, i5);
        }
        if ((i1 != 0) || (i2 != 0))
        {
          k = (int)localScrollerCompat.getCurrVelocity();
          i = 0;
          if (i1 != i6)
          {
            if (i1 >= 0) {
              break label783;
            }
            i = -k;
          }
          j = 0;
          if (i2 != i7)
          {
            if (i2 >= 0) {
              break label798;
            }
            j = -k;
          }
          if (ViewCompat.getOverScrollMode(RecyclerView.this) != 2)
          {
            localRecyclerView = RecyclerView.this;
            if (i >= 0) {
              break label813;
            }
            localRecyclerView.ensureLeftGlow();
            mLeftGlow.onAbsorb(-i);
            label478:
            if (j >= 0) {
              break label835;
            }
            localRecyclerView.ensureTopGlow();
            mTopGlow.onAbsorb(-j);
            label498:
            if ((i != 0) || (j != 0)) {
              ViewCompat.postInvalidateOnAnimation(localRecyclerView);
            }
          }
          if (((i != 0) || (i1 == i6) || (localScrollerCompat.getFinalX() == 0)) && ((j != 0) || (i2 == i7) || (localScrollerCompat.getFinalY() == 0))) {
            localScrollerCompat.abortAnimation();
          }
        }
        if ((n != 0) || (i3 != 0)) {
          dispatchOnScrolled(n, i3);
        }
        if (!awakenScrollBars()) {
          invalidate();
        }
        if ((i5 == 0) || (!mLayout.canScrollVertically()) || (i3 != i5)) {
          break label857;
        }
        i = 1;
        label619:
        if ((i4 == 0) || (!mLayout.canScrollHorizontally()) || (n != i4)) {
          break label862;
        }
        j = 1;
        label646:
        if (((i4 != 0) || (i5 != 0)) && (j == 0) && (i == 0)) {
          break label867;
        }
        i = 1;
        label666:
        if ((!localScrollerCompat.isFinished()) && (i != 0)) {
          break label872;
        }
        RecyclerView.this.setScrollState(0);
      }
      for (;;)
      {
        if (localSmoothScroller != null)
        {
          if (mPendingInitialRun) {
            RecyclerView.SmoothScroller.access$3500(localSmoothScroller, 0, 0);
          }
          if (!mReSchedulePostAnimationCallback) {
            localSmoothScroller.stop();
          }
        }
        mEatRunOnAnimationRequest = false;
        if (!mReSchedulePostAnimationCallback) {
          break;
        }
        postOnAnimation();
        return;
        label735:
        if (mTargetPosition >= n) {
          mTargetPosition = (n - 1);
        }
        RecyclerView.SmoothScroller.access$3500(localSmoothScroller, i4 - j, i5 - k);
        n = i;
        i1 = j;
        i2 = k;
        i3 = m;
        break label348;
        label783:
        if (i1 > 0)
        {
          i = k;
          break label424;
        }
        i = 0;
        break label424;
        label798:
        if (i2 > 0)
        {
          j = k;
          break label441;
        }
        j = 0;
        break label441;
        label813:
        if (i <= 0) {
          break label478;
        }
        localRecyclerView.ensureRightGlow();
        mRightGlow.onAbsorb(i);
        break label478;
        label835:
        if (j <= 0) {
          break label498;
        }
        localRecyclerView.ensureBottomGlow();
        mBottomGlow.onAbsorb(j);
        break label498;
        label857:
        i = 0;
        break label619;
        label862:
        j = 0;
        break label646;
        label867:
        i = 0;
        break label666;
        label872:
        postOnAnimation();
      }
    }
    
    public final void smoothScrollBy(int paramInt1, int paramInt2)
    {
      int k = Math.abs(paramInt1);
      int m = Math.abs(paramInt2);
      int n;
      int i1;
      if (k > m)
      {
        j = 1;
        n = (int)Math.sqrt(0.0D);
        i1 = (int)Math.sqrt(paramInt1 * paramInt1 + paramInt2 * paramInt2);
        if (j == 0) {
          break label157;
        }
      }
      label157:
      for (int i = getWidth();; i = getHeight())
      {
        int i2 = i / 2;
        float f3 = Math.min(1.0F, i1 * 1.0F / i);
        float f1 = i2;
        float f2 = i2;
        f3 = (float)Math.sin((float)((f3 - 0.5F) * 0.4712389167638204D));
        if (n <= 0) {
          break label169;
        }
        i = Math.round(1000.0F * Math.abs((f3 * f2 + f1) / n)) * 4;
        smoothScrollBy(paramInt1, paramInt2, Math.min(i, 2000));
        return;
        j = 0;
        break;
      }
      label169:
      if (j != 0) {}
      for (int j = k;; j = m)
      {
        i = (int)((j / i + 1.0F) * 300.0F);
        break;
      }
    }
    
    public final void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3)
    {
      smoothScrollBy(paramInt1, paramInt2, paramInt3, RecyclerView.sQuinticInterpolator);
    }
    
    public final void smoothScrollBy(int paramInt1, int paramInt2, int paramInt3, Interpolator paramInterpolator)
    {
      if (mInterpolator != paramInterpolator)
      {
        mInterpolator = paramInterpolator;
        mScroller = ScrollerCompat.create(getContext(), paramInterpolator);
      }
      RecyclerView.this.setScrollState(2);
      mLastFlingY = 0;
      mLastFlingX = 0;
      mScroller.startScroll(0, 0, paramInt1, paramInt2, paramInt3);
      postOnAnimation();
    }
    
    public final void stop()
    {
      removeCallbacks(this);
      mScroller.abortAnimation();
    }
  }
  
  public static abstract class ViewHolder
  {
    static final int FLAG_ADAPTER_FULLUPDATE = 1024;
    static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
    static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
    static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
    static final int FLAG_BOUND = 1;
    static final int FLAG_IGNORE = 128;
    static final int FLAG_INVALID = 4;
    static final int FLAG_MOVED = 2048;
    static final int FLAG_NOT_RECYCLABLE = 16;
    static final int FLAG_REMOVED = 8;
    static final int FLAG_RETURNED_FROM_SCRAP = 32;
    static final int FLAG_TMP_DETACHED = 256;
    static final int FLAG_UPDATE = 2;
    private static final List<Object> FULLUPDATE_PAYLOADS = Collections.EMPTY_LIST;
    public final View itemView;
    private int mFlags;
    private boolean mInChangeScrap = false;
    private int mIsRecyclableCount = 0;
    long mItemId = -1L;
    public int mItemViewType = -1;
    int mOldPosition = -1;
    RecyclerView mOwnerRecyclerView;
    List<Object> mPayloads = null;
    int mPosition = -1;
    int mPreLayoutPosition = -1;
    private RecyclerView.Recycler mScrapContainer = null;
    ViewHolder mShadowedHolder = null;
    ViewHolder mShadowingHolder = null;
    List<Object> mUnmodifiedPayloads = null;
    private int mWasImportantForAccessibilityBeforeHidden = 0;
    
    public ViewHolder(View paramView)
    {
      if (paramView == null) {
        throw new IllegalArgumentException("itemView may not be null");
      }
      itemView = paramView;
    }
    
    private void createPayloadsIfNeeded()
    {
      if (mPayloads == null)
      {
        mPayloads = new ArrayList();
        mUnmodifiedPayloads = Collections.unmodifiableList(mPayloads);
      }
    }
    
    private boolean doesTransientStatePreventRecycling()
    {
      return ((mFlags & 0x10) == 0) && (ViewCompat.hasTransientState(itemView));
    }
    
    private void onEnteredHiddenState()
    {
      mWasImportantForAccessibilityBeforeHidden = ViewCompat.getImportantForAccessibility(itemView);
      ViewCompat.setImportantForAccessibility(itemView, 4);
    }
    
    private void onLeftHiddenState()
    {
      ViewCompat.setImportantForAccessibility(itemView, mWasImportantForAccessibilityBeforeHidden);
      mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    private boolean shouldBeKeptAsChild()
    {
      return (mFlags & 0x10) != 0;
    }
    
    void addChangePayload(Object paramObject)
    {
      if (paramObject == null) {
        addFlags(1024);
      }
      while ((mFlags & 0x400) != 0) {
        return;
      }
      createPayloadsIfNeeded();
      mPayloads.add(paramObject);
    }
    
    void addFlags(int paramInt)
    {
      mFlags |= paramInt;
    }
    
    void clearOldPosition()
    {
      mOldPosition = -1;
      mPreLayoutPosition = -1;
    }
    
    void clearPayload()
    {
      if (mPayloads != null) {
        mPayloads.clear();
      }
      mFlags &= 0xFBFF;
    }
    
    void clearReturnedFromScrapFlag()
    {
      mFlags &= 0xFFFFFFDF;
    }
    
    void clearTmpDetachFlag()
    {
      mFlags &= 0xFEFF;
    }
    
    void flagRemovedAndOffsetPosition(int paramInt1, int paramInt2, boolean paramBoolean)
    {
      addFlags(8);
      offsetPosition(paramInt2, paramBoolean);
      mPosition = paramInt1;
    }
    
    public final int getAdapterPosition()
    {
      if (mOwnerRecyclerView == null) {
        return -1;
      }
      return mOwnerRecyclerView.getAdapterPositionFor(this);
    }
    
    public final long getItemId()
    {
      return mItemId;
    }
    
    public final int getItemViewType()
    {
      return mItemViewType;
    }
    
    public final int getLayoutPosition()
    {
      if (mPreLayoutPosition == -1) {
        return mPosition;
      }
      return mPreLayoutPosition;
    }
    
    public final int getOldPosition()
    {
      return mOldPosition;
    }
    
    @Deprecated
    public final int getPosition()
    {
      if (mPreLayoutPosition == -1) {
        return mPosition;
      }
      return mPreLayoutPosition;
    }
    
    List<Object> getUnmodifiedPayloads()
    {
      if ((mFlags & 0x400) == 0)
      {
        if ((mPayloads == null) || (mPayloads.size() == 0)) {
          return FULLUPDATE_PAYLOADS;
        }
        return mUnmodifiedPayloads;
      }
      return FULLUPDATE_PAYLOADS;
    }
    
    boolean hasAnyOfTheFlags(int paramInt)
    {
      return (mFlags & paramInt) != 0;
    }
    
    boolean isAdapterPositionUnknown()
    {
      return ((mFlags & 0x200) != 0) || (isInvalid());
    }
    
    boolean isBound()
    {
      return (mFlags & 0x1) != 0;
    }
    
    boolean isInvalid()
    {
      return (mFlags & 0x4) != 0;
    }
    
    public final boolean isRecyclable()
    {
      return ((mFlags & 0x10) == 0) && (!ViewCompat.hasTransientState(itemView));
    }
    
    public boolean isRemoved()
    {
      return (mFlags & 0x8) != 0;
    }
    
    boolean isScrap()
    {
      return mScrapContainer != null;
    }
    
    boolean isTmpDetached()
    {
      return (mFlags & 0x100) != 0;
    }
    
    boolean isUpdated()
    {
      return (mFlags & 0x2) != 0;
    }
    
    boolean needsUpdate()
    {
      return (mFlags & 0x2) != 0;
    }
    
    void offsetPosition(int paramInt, boolean paramBoolean)
    {
      if (mOldPosition == -1) {
        mOldPosition = mPosition;
      }
      if (mPreLayoutPosition == -1) {
        mPreLayoutPosition = mPosition;
      }
      if (paramBoolean) {
        mPreLayoutPosition += paramInt;
      }
      mPosition += paramInt;
      if (itemView.getLayoutParams() != null) {
        itemView.getLayoutParams()).mInsetsDirty = true;
      }
    }
    
    void resetInternal()
    {
      mFlags = 0;
      mPosition = -1;
      mOldPosition = -1;
      mItemId = -1L;
      mPreLayoutPosition = -1;
      mIsRecyclableCount = 0;
      mShadowedHolder = null;
      mShadowingHolder = null;
      clearPayload();
      mWasImportantForAccessibilityBeforeHidden = 0;
    }
    
    void saveOldPosition()
    {
      if (mOldPosition == -1) {
        mOldPosition = mPosition;
      }
    }
    
    void setFlags(int paramInt1, int paramInt2)
    {
      mFlags = (mFlags & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
    }
    
    public final void setIsRecyclable(boolean paramBoolean)
    {
      int i;
      if (paramBoolean)
      {
        i = mIsRecyclableCount - 1;
        mIsRecyclableCount = i;
        if (mIsRecyclableCount >= 0) {
          break label61;
        }
        mIsRecyclableCount = 0;
        Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
      }
      label61:
      do
      {
        return;
        i = mIsRecyclableCount + 1;
        break;
        if ((!paramBoolean) && (mIsRecyclableCount == 1))
        {
          mFlags |= 0x10;
          return;
        }
      } while ((!paramBoolean) || (mIsRecyclableCount != 0));
      mFlags &= 0xFFFFFFEF;
    }
    
    void setScrapContainer(RecyclerView.Recycler paramRecycler, boolean paramBoolean)
    {
      mScrapContainer = paramRecycler;
      mInChangeScrap = paramBoolean;
    }
    
    boolean shouldIgnore()
    {
      return (mFlags & 0x80) != 0;
    }
    
    void stopIgnoring()
    {
      mFlags &= 0xFF7F;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + mPosition + " id=" + mItemId + ", oldPos=" + mOldPosition + ", pLpos:" + mPreLayoutPosition);
      StringBuilder localStringBuilder2;
      if (isScrap())
      {
        localStringBuilder2 = localStringBuilder1.append(" scrap ");
        if (!mInChangeScrap) {
          break label289;
        }
      }
      label289:
      for (String str = "[changeScrap]";; str = "[attachedScrap]")
      {
        localStringBuilder2.append(str);
        if (isInvalid()) {
          localStringBuilder1.append(" invalid");
        }
        if (!isBound()) {
          localStringBuilder1.append(" unbound");
        }
        if (needsUpdate()) {
          localStringBuilder1.append(" update");
        }
        if (isRemoved()) {
          localStringBuilder1.append(" removed");
        }
        if (shouldIgnore()) {
          localStringBuilder1.append(" ignored");
        }
        if (isTmpDetached()) {
          localStringBuilder1.append(" tmpDetached");
        }
        if (!isRecyclable()) {
          localStringBuilder1.append(" not recyclable(" + mIsRecyclableCount + ")");
        }
        if (isAdapterPositionUnknown()) {
          localStringBuilder1.append(" undefined adapter position");
        }
        if (itemView.getParent() == null) {
          localStringBuilder1.append(" no parent");
        }
        localStringBuilder1.append("}");
        return localStringBuilder1.toString();
      }
    }
    
    void unScrap()
    {
      mScrapContainer.unscrapView(this);
    }
    
    boolean wasReturnedFromScrap()
    {
      return (mFlags & 0x20) != 0;
    }
  }
}

/* Location:
 * Qualified Name:     android.support.v7.widget.RecyclerView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */