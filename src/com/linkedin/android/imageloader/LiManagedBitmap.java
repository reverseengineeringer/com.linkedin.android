package com.linkedin.android.imageloader;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.linkedin.android.imageloader.interfaces.IBitmapFactory;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.logger.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LiManagedBitmap
  implements ManagedBitmap
{
  static volatile boolean DEBUG_RETAIN_RELEASE = false;
  private static final String TAG = LiManagedBitmap.class.getSimpleName();
  protected Bitmap mBitmap;
  protected IBitmapFactory mBitmapFactory;
  protected volatile int mBitmapSize;
  protected volatile int mRefCount = 1;
  final List<String> mRetainReleaseTraces;
  
  public LiManagedBitmap(Bitmap paramBitmap, IBitmapFactory paramIBitmapFactory)
  {
    mBitmap = paramBitmap;
    mBitmapFactory = paramIBitmapFactory;
    if (DEBUG_RETAIN_RELEASE)
    {
      mRetainReleaseTraces = new ArrayList();
      return;
    }
    mRetainReleaseTraces = null;
  }
  
  private static String getExceptionTrace(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static void setDebugRetainRelease$1385ff()
  {
    DEBUG_RETAIN_RELEASE = false;
  }
  
  protected void finalize()
    throws Throwable
  {
    if ((mBitmap != null) && (mBitmapFactory != null))
    {
      if (DEBUG_RETAIN_RELEASE)
      {
        Log.e(TAG, "RefCount: " + mRefCount + "\n");
        Iterator localIterator = mRetainReleaseTraces.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.e(TAG, str + "\n");
        }
      }
      throw new RuntimeException("Bitmap was non-null when managed bitmap was finalized");
    }
    super.finalize();
  }
  
  public Bitmap getBitmap()
  {
    return mBitmap;
  }
  
  public int getSize()
  {
    if (mBitmapSize > 0) {
      return mBitmapSize;
    }
    if (mBitmap != null)
    {
      if (Build.VERSION.SDK_INT < 21) {
        break label47;
      }
      mBitmapSize = (mBitmap.getAllocationByteCount() / 1024);
    }
    for (;;)
    {
      return mBitmapSize;
      label47:
      if (Build.VERSION.SDK_INT >= 12) {
        mBitmapSize = (mBitmap.getByteCount() / 1024);
      } else {
        mBitmapSize = (mBitmap.getRowBytes() * mBitmap.getHeight() / 1024);
      }
    }
  }
  
  public boolean isGif()
  {
    return false;
  }
  
  void recycle()
  {
    if ((mBitmap == null) || (mBitmapFactory == null))
    {
      if (DEBUG_RETAIN_RELEASE)
      {
        Log.e(TAG, "RefCount: " + mRefCount + "\n");
        Iterator localIterator = mRetainReleaseTraces.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Log.e(TAG, str + "\n");
        }
      }
      throw new RuntimeException("Bitmap was null when recycle was called");
    }
    mBitmapFactory.recycle(mBitmap);
    mBitmap = null;
    mBitmapFactory = null;
  }
  
  public final void release()
  {
    try
    {
      int i = mRefCount - 1;
      mRefCount = i;
      if (i == 0) {
        recycle();
      }
      if (DEBUG_RETAIN_RELEASE) {
        mRetainReleaseTraces.add(getExceptionTrace(new Exception("RELEASED RefCount: " + mRefCount)));
      }
      return;
    }
    finally {}
  }
  
  public final ManagedBitmap retain()
  {
    try
    {
      mRefCount += 1;
      if (DEBUG_RETAIN_RELEASE) {
        mRetainReleaseTraces.add(getExceptionTrace(new Exception("RETAINED RefCount: " + mRefCount)));
      }
      return this;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.LiManagedBitmap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */