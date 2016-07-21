package android.support.v4.content;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.support.v4.util.DebugUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class Loader<D>
{
  public boolean mAbandoned = false;
  public boolean mContentChanged = false;
  public Context mContext;
  public int mId;
  public OnLoadCompleteListener<D> mListener;
  public OnLoadCanceledListener<D> mOnLoadCanceledListener;
  public boolean mProcessingChange = false;
  public boolean mReset = true;
  public boolean mStarted = false;
  
  public Loader(Context paramContext)
  {
    mContext = paramContext.getApplicationContext();
  }
  
  public final boolean cancelLoad()
  {
    return onCancelLoad();
  }
  
  public void deliverResult(D paramD)
  {
    if (mListener != null) {
      mListener.onLoadComplete(this, paramD);
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mId=");
    paramPrintWriter.print(mId);
    paramPrintWriter.print(" mListener=");
    paramPrintWriter.println(mListener);
    if ((mStarted) || (mContentChanged) || (mProcessingChange))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mStarted=");
      paramPrintWriter.print(mStarted);
      paramPrintWriter.print(" mContentChanged=");
      paramPrintWriter.print(mContentChanged);
      paramPrintWriter.print(" mProcessingChange=");
      paramPrintWriter.println(mProcessingChange);
    }
    if ((mAbandoned) || (mReset))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("mAbandoned=");
      paramPrintWriter.print(mAbandoned);
      paramPrintWriter.print(" mReset=");
      paramPrintWriter.println(mReset);
    }
  }
  
  public final void forceLoad()
  {
    onForceLoad();
  }
  
  protected boolean onCancelLoad()
  {
    return false;
  }
  
  public final void onContentChanged()
  {
    if (mStarted)
    {
      onForceLoad();
      return;
    }
    mContentChanged = true;
  }
  
  protected void onForceLoad() {}
  
  public void onReset() {}
  
  public void onStartLoading() {}
  
  public void onStopLoading() {}
  
  public final boolean takeContentChanged()
  {
    boolean bool = mContentChanged;
    mContentChanged = false;
    mProcessingChange |= bool;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    DebugUtils.buildShortClassTag(this, localStringBuilder);
    localStringBuilder.append(" id=");
    localStringBuilder.append(mId);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  public final void unregisterListener(OnLoadCompleteListener<D> paramOnLoadCompleteListener)
  {
    if (mListener == null) {
      throw new IllegalStateException("No listener register");
    }
    if (mListener != paramOnLoadCompleteListener) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    mListener = null;
  }
  
  public final void unregisterOnLoadCanceledListener(OnLoadCanceledListener<D> paramOnLoadCanceledListener)
  {
    if (mOnLoadCanceledListener == null) {
      throw new IllegalStateException("No listener register");
    }
    if (mOnLoadCanceledListener != paramOnLoadCanceledListener) {
      throw new IllegalArgumentException("Attempting to unregister the wrong listener");
    }
    mOnLoadCanceledListener = null;
  }
  
  public final class ForceLoadContentObserver
    extends ContentObserver
  {
    public ForceLoadContentObserver()
    {
      super();
    }
    
    public final boolean deliverSelfNotifications()
    {
      return true;
    }
    
    public final void onChange(boolean paramBoolean)
    {
      onContentChanged();
    }
  }
  
  public static abstract interface OnLoadCanceledListener<D>
  {
    public abstract void onLoadCanceled$5dda1f52();
  }
  
  public static abstract interface OnLoadCompleteListener<D>
  {
    public abstract void onLoadComplete(Loader<D> paramLoader, D paramD);
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.Loader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */