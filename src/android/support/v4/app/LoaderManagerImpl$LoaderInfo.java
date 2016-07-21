package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v4.content.Loader.OnLoadCanceledListener;
import android.support.v4.content.Loader.OnLoadCompleteListener;
import android.support.v4.util.DebugUtils;
import android.support.v4.util.SparseArrayCompat;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

final class LoaderManagerImpl$LoaderInfo
  implements Loader.OnLoadCanceledListener<Object>, Loader.OnLoadCompleteListener<Object>
{
  final Bundle mArgs = null;
  LoaderManager.LoaderCallbacks<Object> mCallbacks;
  Object mData;
  boolean mDeliveredData;
  boolean mDestroyed;
  boolean mHaveData;
  final int mId = 0;
  boolean mListenerRegistered;
  Loader<Object> mLoader;
  LoaderInfo mPendingLoader;
  boolean mReportNextStart;
  boolean mRetaining;
  boolean mRetainingStarted;
  boolean mStarted;
  
  public LoaderManagerImpl$LoaderInfo(int paramInt)
  {
    LoaderManager.LoaderCallbacks localLoaderCallbacks;
    mCallbacks = localLoaderCallbacks;
  }
  
  final void callOnLoadFinished(Loader<Object> paramLoader, Object paramObject)
  {
    String str;
    if (mCallbacks != null)
    {
      str = null;
      if (LoaderManagerImpl.access$000(this$0) != null)
      {
        str = access$000this$0).mFragmentManager.mNoTransactionsBecause;
        access$000this$0).mFragmentManager.mNoTransactionsBecause = "onLoadFinished";
      }
    }
    try
    {
      if (LoaderManagerImpl.DEBUG)
      {
        paramLoader = new StringBuilder("  onLoadFinished in ").append(paramLoader).append(": ");
        StringBuilder localStringBuilder = new StringBuilder(64);
        DebugUtils.buildShortClassTag(paramObject, localStringBuilder);
        localStringBuilder.append("}");
        Log.v("LoaderManager", localStringBuilder.toString());
      }
      mCallbacks.onLoadFinished$13079eae(paramObject);
      if (LoaderManagerImpl.access$000(this$0) != null) {
        access$000this$0).mFragmentManager.mNoTransactionsBecause = str;
      }
      mDeliveredData = true;
      return;
    }
    finally
    {
      if (LoaderManagerImpl.access$000(this$0) != null) {
        access$000this$0).mFragmentManager.mNoTransactionsBecause = str;
      }
    }
  }
  
  /* Error */
  final void destroy()
  {
    // Byte code:
    //   0: aload_0
    //   1: astore_2
    //   2: getstatic 76	android/support/v4/app/LoaderManagerImpl:DEBUG	Z
    //   5: ifeq +25 -> 30
    //   8: ldc 104
    //   10: new 78	java/lang/StringBuilder
    //   13: dup
    //   14: ldc 126
    //   16: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_2
    //   20: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   29: pop
    //   30: aload_2
    //   31: iconst_1
    //   32: putfield 128	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mDestroyed	Z
    //   35: aload_2
    //   36: getfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mDeliveredData	Z
    //   39: istore_1
    //   40: aload_2
    //   41: iconst_0
    //   42: putfield 122	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mDeliveredData	Z
    //   45: aload_2
    //   46: getfield 50	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mCallbacks	Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
    //   49: ifnull +123 -> 172
    //   52: aload_2
    //   53: getfield 130	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
    //   56: ifnull +116 -> 172
    //   59: aload_2
    //   60: getfield 132	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mHaveData	Z
    //   63: ifeq +109 -> 172
    //   66: iload_1
    //   67: ifeq +105 -> 172
    //   70: getstatic 76	android/support/v4/app/LoaderManagerImpl:DEBUG	Z
    //   73: ifeq +25 -> 98
    //   76: ldc 104
    //   78: new 78	java/lang/StringBuilder
    //   81: dup
    //   82: ldc -122
    //   84: invokespecial 83	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   87: aload_2
    //   88: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   91: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 114	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   97: pop
    //   98: aconst_null
    //   99: astore_3
    //   100: aload_2
    //   101: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   104: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   107: ifnull +32 -> 139
    //   110: aload_2
    //   111: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   114: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   117: getfield 65	android/support/v4/app/FragmentHostCallback:mFragmentManager	Landroid/support/v4/app/FragmentManagerImpl;
    //   120: getfield 71	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
    //   123: astore_3
    //   124: aload_2
    //   125: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   128: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   131: getfield 65	android/support/v4/app/FragmentHostCallback:mFragmentManager	Landroid/support/v4/app/FragmentManagerImpl;
    //   134: ldc -120
    //   136: putfield 71	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
    //   139: aload_2
    //   140: getfield 50	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mCallbacks	Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
    //   143: invokeinterface 139 1 0
    //   148: aload_2
    //   149: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   152: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   155: ifnull +17 -> 172
    //   158: aload_2
    //   159: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   162: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   165: getfield 65	android/support/v4/app/FragmentHostCallback:mFragmentManager	Landroid/support/v4/app/FragmentManagerImpl;
    //   168: aload_3
    //   169: putfield 71	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
    //   172: aload_2
    //   173: aconst_null
    //   174: putfield 50	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mCallbacks	Landroid/support/v4/app/LoaderManager$LoaderCallbacks;
    //   177: aload_2
    //   178: aconst_null
    //   179: putfield 141	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mData	Ljava/lang/Object;
    //   182: aload_2
    //   183: iconst_0
    //   184: putfield 132	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mHaveData	Z
    //   187: aload_2
    //   188: getfield 130	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
    //   191: ifnull +65 -> 256
    //   194: aload_2
    //   195: getfield 143	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mListenerRegistered	Z
    //   198: ifeq +24 -> 222
    //   201: aload_2
    //   202: iconst_0
    //   203: putfield 143	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mListenerRegistered	Z
    //   206: aload_2
    //   207: getfield 130	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
    //   210: aload_2
    //   211: invokevirtual 149	android/support/v4/content/Loader:unregisterListener	(Landroid/support/v4/content/Loader$OnLoadCompleteListener;)V
    //   214: aload_2
    //   215: getfield 130	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
    //   218: aload_2
    //   219: invokevirtual 153	android/support/v4/content/Loader:unregisterOnLoadCanceledListener	(Landroid/support/v4/content/Loader$OnLoadCanceledListener;)V
    //   222: aload_2
    //   223: getfield 130	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mLoader	Landroid/support/v4/content/Loader;
    //   226: astore_3
    //   227: aload_3
    //   228: invokevirtual 156	android/support/v4/content/Loader:onReset	()V
    //   231: aload_3
    //   232: iconst_1
    //   233: putfield 159	android/support/v4/content/Loader:mReset	Z
    //   236: aload_3
    //   237: iconst_0
    //   238: putfield 161	android/support/v4/content/Loader:mStarted	Z
    //   241: aload_3
    //   242: iconst_0
    //   243: putfield 164	android/support/v4/content/Loader:mAbandoned	Z
    //   246: aload_3
    //   247: iconst_0
    //   248: putfield 167	android/support/v4/content/Loader:mContentChanged	Z
    //   251: aload_3
    //   252: iconst_0
    //   253: putfield 170	android/support/v4/content/Loader:mProcessingChange	Z
    //   256: aload_2
    //   257: getfield 172	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mPendingLoader	Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
    //   260: ifnull +40 -> 300
    //   263: aload_2
    //   264: getfield 172	android/support/v4/app/LoaderManagerImpl$LoaderInfo:mPendingLoader	Landroid/support/v4/app/LoaderManagerImpl$LoaderInfo;
    //   267: astore_2
    //   268: goto -266 -> 2
    //   271: astore 4
    //   273: aload_2
    //   274: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   277: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   280: ifnull +17 -> 297
    //   283: aload_2
    //   284: getfield 41	android/support/v4/app/LoaderManagerImpl$LoaderInfo:this$0	Landroid/support/v4/app/LoaderManagerImpl;
    //   287: invokestatic 59	android/support/v4/app/LoaderManagerImpl:access$000	(Landroid/support/v4/app/LoaderManagerImpl;)Landroid/support/v4/app/FragmentHostCallback;
    //   290: getfield 65	android/support/v4/app/FragmentHostCallback:mFragmentManager	Landroid/support/v4/app/FragmentManagerImpl;
    //   293: aload_3
    //   294: putfield 71	android/support/v4/app/FragmentManagerImpl:mNoTransactionsBecause	Ljava/lang/String;
    //   297: aload 4
    //   299: athrow
    //   300: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	301	0	this	LoaderInfo
    //   39	28	1	bool	boolean
    //   1	283	2	localLoaderInfo	LoaderInfo
    //   99	195	3	localObject1	Object
    //   271	27	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   139	148	271	finally
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    String str = paramString;
    paramString = this;
    for (;;)
    {
      paramPrintWriter.print(str);
      paramPrintWriter.print("mId=");
      paramPrintWriter.print(mId);
      paramPrintWriter.print(" mArgs=");
      paramPrintWriter.println(mArgs);
      paramPrintWriter.print(str);
      paramPrintWriter.print("mCallbacks=");
      paramPrintWriter.println(mCallbacks);
      paramPrintWriter.print(str);
      paramPrintWriter.print("mLoader=");
      paramPrintWriter.println(mLoader);
      if (mLoader != null) {
        mLoader.dump(str + "  ", paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
      if ((mHaveData) || (mDeliveredData))
      {
        paramPrintWriter.print(str);
        paramPrintWriter.print("mHaveData=");
        paramPrintWriter.print(mHaveData);
        paramPrintWriter.print("  mDeliveredData=");
        paramPrintWriter.println(mDeliveredData);
        paramPrintWriter.print(str);
        paramPrintWriter.print("mData=");
        paramPrintWriter.println(mData);
      }
      paramPrintWriter.print(str);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(mStarted);
      paramPrintWriter.print(" mReportNextStart=");
      paramPrintWriter.print(mReportNextStart);
      paramPrintWriter.print(" mDestroyed=");
      paramPrintWriter.println(mDestroyed);
      paramPrintWriter.print(str);
      paramPrintWriter.print("mRetaining=");
      paramPrintWriter.print(mRetaining);
      paramPrintWriter.print(" mRetainingStarted=");
      paramPrintWriter.print(mRetainingStarted);
      paramPrintWriter.print(" mListenerRegistered=");
      paramPrintWriter.println(mListenerRegistered);
      if (mPendingLoader == null) {
        break;
      }
      paramPrintWriter.print(str);
      paramPrintWriter.println("Pending Loader ");
      paramPrintWriter.print(mPendingLoader);
      paramPrintWriter.println(":");
      paramString = mPendingLoader;
      str = str + "  ";
    }
  }
  
  public final void onLoadCanceled$5dda1f52()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadCanceled: " + this);
    }
    if (mDestroyed) {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Ignoring load canceled -- destroyed");
      }
    }
    LoaderInfo localLoaderInfo;
    do
    {
      do
      {
        return;
        if (this$0.mLoaders.get(mId) == this) {
          break;
        }
      } while (!LoaderManagerImpl.DEBUG);
      Log.v("LoaderManager", "  Ignoring load canceled -- not active");
      return;
      localLoaderInfo = mPendingLoader;
    } while (localLoaderInfo == null);
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo);
    }
    mPendingLoader = null;
    this$0.mLoaders.put(mId, null);
    destroy();
    this$0.installLoader(localLoaderInfo);
  }
  
  public final void onLoadComplete(Loader<Object> paramLoader, Object paramObject)
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "onLoadComplete: " + this);
    }
    if (mDestroyed) {
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Ignoring load complete -- destroyed");
      }
    }
    do
    {
      do
      {
        return;
        if (this$0.mLoaders.get(mId) == this) {
          break;
        }
      } while (!LoaderManagerImpl.DEBUG);
      Log.v("LoaderManager", "  Ignoring load complete -- not active");
      return;
      LoaderInfo localLoaderInfo = mPendingLoader;
      if (localLoaderInfo != null)
      {
        if (LoaderManagerImpl.DEBUG) {
          Log.v("LoaderManager", "  Switching to pending loader: " + localLoaderInfo);
        }
        mPendingLoader = null;
        this$0.mLoaders.put(mId, null);
        destroy();
        this$0.installLoader(localLoaderInfo);
        return;
      }
      if ((mData != paramObject) || (!mHaveData))
      {
        mData = paramObject;
        mHaveData = true;
        if (mStarted) {
          callOnLoadFinished(paramLoader, paramObject);
        }
      }
      paramLoader = (LoaderInfo)this$0.mInactiveLoaders.get(mId);
      if ((paramLoader != null) && (paramLoader != this))
      {
        mDeliveredData = false;
        paramLoader.destroy();
        this$0.mInactiveLoaders.remove(mId);
      }
    } while ((LoaderManagerImpl.access$000(this$0) == null) || (this$0.hasRunningLoaders()));
    access$000this$0).mFragmentManager.startPendingDeferredFragments();
  }
  
  final void start()
  {
    if ((mRetaining) && (mRetainingStarted)) {
      mStarted = true;
    }
    do
    {
      do
      {
        return;
      } while (mStarted);
      mStarted = true;
      if (LoaderManagerImpl.DEBUG) {
        Log.v("LoaderManager", "  Starting: " + this);
      }
      if ((mLoader == null) && (mCallbacks != null)) {
        mLoader = mCallbacks.onCreateLoader$e57f803(mId);
      }
    } while (mLoader == null);
    if ((mLoader.getClass().isMemberClass()) && (!Modifier.isStatic(mLoader.getClass().getModifiers()))) {
      throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + mLoader);
    }
    if (!mListenerRegistered)
    {
      localLoader = mLoader;
      int i = mId;
      if (mListener != null) {
        throw new IllegalStateException("There is already a listener registered");
      }
      mListener = this;
      mId = i;
      localLoader = mLoader;
      if (mOnLoadCanceledListener != null) {
        throw new IllegalStateException("There is already a listener registered");
      }
      mOnLoadCanceledListener = this;
      mListenerRegistered = true;
    }
    Loader localLoader = mLoader;
    mStarted = true;
    mReset = false;
    mAbandoned = false;
    localLoader.onStartLoading();
  }
  
  final void stop()
  {
    if (LoaderManagerImpl.DEBUG) {
      Log.v("LoaderManager", "  Stopping: " + this);
    }
    mStarted = false;
    if ((!mRetaining) && (mLoader != null) && (mListenerRegistered))
    {
      mListenerRegistered = false;
      mLoader.unregisterListener(this);
      mLoader.unregisterOnLoadCanceledListener(this);
      Loader localLoader = mLoader;
      mStarted = false;
      localLoader.onStopLoading();
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("LoaderInfo{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" #");
    localStringBuilder.append(mId);
    localStringBuilder.append(" : ");
    DebugUtils.buildShortClassTag(mLoader, localStringBuilder);
    localStringBuilder.append("}}");
    return localStringBuilder.toString();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.LoaderManagerImpl.LoaderInfo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */