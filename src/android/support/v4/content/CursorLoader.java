package android.support.v4.content;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.v4.os.CancellationSignal;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Arrays;

public final class CursorLoader
  extends AsyncTaskLoader<Cursor>
{
  CancellationSignal mCancellationSignal;
  Cursor mCursor;
  final Loader<Cursor>.android.support.v4.content.Loader.android.support.v4.content.Loader.android.support.v4.content.Loader.android.support.v4.content.Loader.android.support.v4.content.Loader.android.support.v4.content.Loader.ForceLoadContentObserver mObserver = new Loader.ForceLoadContentObserver(this);
  String[] mProjection;
  String mSelection;
  String[] mSelectionArgs;
  String mSortOrder;
  Uri mUri;
  
  public CursorLoader(Context paramContext, Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    super(paramContext);
    mUri = paramUri;
    mProjection = null;
    mSelection = paramString;
    mSelectionArgs = paramArrayOfString;
    mSortOrder = null;
  }
  
  private void deliverResult(Cursor paramCursor)
  {
    if (mReset) {
      if (paramCursor != null) {
        paramCursor.close();
      }
    }
    Cursor localCursor;
    do
    {
      return;
      localCursor = mCursor;
      mCursor = paramCursor;
      if (mStarted) {
        super.deliverResult(paramCursor);
      }
    } while ((localCursor == null) || (localCursor == paramCursor) || (localCursor.isClosed()));
    localCursor.close();
  }
  
  /* Error */
  private Cursor loadInBackground()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 77	android/support/v4/content/AsyncTaskLoader:mCancellingTask	Landroid/support/v4/content/AsyncTaskLoader$LoadTask;
    //   6: ifnull +22 -> 28
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: ifeq +21 -> 33
    //   15: new 79	android/support/v4/os/OperationCanceledException
    //   18: dup
    //   19: invokespecial 81	android/support/v4/os/OperationCanceledException:<init>	()V
    //   22: athrow
    //   23: astore_2
    //   24: aload_0
    //   25: monitorexit
    //   26: aload_2
    //   27: athrow
    //   28: iconst_0
    //   29: istore_1
    //   30: goto -19 -> 11
    //   33: aload_0
    //   34: new 83	android/support/v4/os/CancellationSignal
    //   37: dup
    //   38: invokespecial 84	android/support/v4/os/CancellationSignal:<init>	()V
    //   41: putfield 86	android/support/v4/content/CursorLoader:mCancellationSignal	Landroid/support/v4/os/CancellationSignal;
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_0
    //   47: getfield 90	android/support/v4/content/Loader:mContext	Landroid/content/Context;
    //   50: invokevirtual 96	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   53: aload_0
    //   54: getfield 34	android/support/v4/content/CursorLoader:mUri	Landroid/net/Uri;
    //   57: aload_0
    //   58: getfield 36	android/support/v4/content/CursorLoader:mProjection	[Ljava/lang/String;
    //   61: aload_0
    //   62: getfield 38	android/support/v4/content/CursorLoader:mSelection	Ljava/lang/String;
    //   65: aload_0
    //   66: getfield 40	android/support/v4/content/CursorLoader:mSelectionArgs	[Ljava/lang/String;
    //   69: aload_0
    //   70: getfield 42	android/support/v4/content/CursorLoader:mSortOrder	Ljava/lang/String;
    //   73: aload_0
    //   74: getfield 86	android/support/v4/content/CursorLoader:mCancellationSignal	Landroid/support/v4/os/CancellationSignal;
    //   77: invokestatic 102	android/support/v4/content/ContentResolverCompat:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Landroid/support/v4/os/CancellationSignal;)Landroid/database/Cursor;
    //   80: astore_2
    //   81: aload_2
    //   82: ifnull +20 -> 102
    //   85: aload_2
    //   86: invokeinterface 106 1 0
    //   91: pop
    //   92: aload_2
    //   93: aload_0
    //   94: getfield 32	android/support/v4/content/CursorLoader:mObserver	Landroid/support/v4/content/Loader$ForceLoadContentObserver;
    //   97: invokeinterface 110 2 0
    //   102: aload_0
    //   103: monitorenter
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 86	android/support/v4/content/CursorLoader:mCancellationSignal	Landroid/support/v4/os/CancellationSignal;
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_2
    //   112: areturn
    //   113: astore_3
    //   114: aload_2
    //   115: invokeinterface 57 1 0
    //   120: aload_3
    //   121: athrow
    //   122: astore_2
    //   123: aload_0
    //   124: monitorenter
    //   125: aload_0
    //   126: aconst_null
    //   127: putfield 86	android/support/v4/content/CursorLoader:mCancellationSignal	Landroid/support/v4/os/CancellationSignal;
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_2
    //   133: athrow
    //   134: astore_2
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    //   139: astore_2
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_2
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	CursorLoader
    //   10	20	1	i	int
    //   23	4	2	localObject1	Object
    //   80	35	2	localCursor	Cursor
    //   122	11	2	localObject2	Object
    //   134	4	2	localObject3	Object
    //   139	4	2	localObject4	Object
    //   113	8	3	localRuntimeException	RuntimeException
    // Exception table:
    //   from	to	target	type
    //   2	9	23	finally
    //   15	23	23	finally
    //   24	26	23	finally
    //   33	46	23	finally
    //   85	102	113	java/lang/RuntimeException
    //   46	81	122	finally
    //   85	102	122	finally
    //   114	122	122	finally
    //   104	111	134	finally
    //   135	137	134	finally
    //   125	132	139	finally
    //   140	142	139	finally
  }
  
  /* Error */
  public final void cancelLoadInBackground()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 113	android/support/v4/content/AsyncTaskLoader:cancelLoadInBackground	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 86	android/support/v4/content/CursorLoader:mCancellationSignal	Landroid/support/v4/os/CancellationSignal;
    //   10: ifnull +19 -> 29
    //   13: aload_0
    //   14: getfield 86	android/support/v4/content/CursorLoader:mCancellationSignal	Landroid/support/v4/os/CancellationSignal;
    //   17: astore_1
    //   18: aload_1
    //   19: monitorenter
    //   20: aload_1
    //   21: getfield 116	android/support/v4/os/CancellationSignal:mIsCanceled	Z
    //   24: ifeq +8 -> 32
    //   27: aload_1
    //   28: monitorexit
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: iconst_1
    //   34: putfield 116	android/support/v4/os/CancellationSignal:mIsCanceled	Z
    //   37: aload_1
    //   38: iconst_1
    //   39: putfield 119	android/support/v4/os/CancellationSignal:mCancelInProgress	Z
    //   42: aload_1
    //   43: getfield 123	android/support/v4/os/CancellationSignal:mCancellationSignalObj	Ljava/lang/Object;
    //   46: astore_2
    //   47: aload_1
    //   48: monitorexit
    //   49: aload_2
    //   50: ifnull +10 -> 60
    //   53: aload_2
    //   54: checkcast 125	android/os/CancellationSignal
    //   57: invokevirtual 128	android/os/CancellationSignal:cancel	()V
    //   60: aload_1
    //   61: monitorenter
    //   62: aload_1
    //   63: iconst_0
    //   64: putfield 119	android/support/v4/os/CancellationSignal:mCancelInProgress	Z
    //   67: aload_1
    //   68: invokevirtual 133	java/lang/Object:notifyAll	()V
    //   71: aload_1
    //   72: monitorexit
    //   73: goto -44 -> 29
    //   76: astore_2
    //   77: aload_1
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    //   81: astore_1
    //   82: aload_0
    //   83: monitorexit
    //   84: aload_1
    //   85: athrow
    //   86: astore_2
    //   87: aload_1
    //   88: monitorexit
    //   89: aload_2
    //   90: athrow
    //   91: astore_2
    //   92: aload_1
    //   93: monitorenter
    //   94: aload_1
    //   95: iconst_0
    //   96: putfield 119	android/support/v4/os/CancellationSignal:mCancelInProgress	Z
    //   99: aload_1
    //   100: invokevirtual 133	java/lang/Object:notifyAll	()V
    //   103: aload_1
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    //   107: astore_2
    //   108: aload_1
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	CursorLoader
    //   17	61	1	localCancellationSignal	CancellationSignal
    //   81	28	1	localObject1	Object
    //   46	8	2	localObject2	Object
    //   76	4	2	localObject3	Object
    //   86	4	2	localObject4	Object
    //   91	15	2	localObject5	Object
    //   107	4	2	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   62	73	76	finally
    //   77	79	76	finally
    //   6	20	81	finally
    //   29	31	81	finally
    //   60	62	81	finally
    //   79	81	81	finally
    //   82	84	81	finally
    //   89	91	81	finally
    //   92	94	81	finally
    //   105	107	81	finally
    //   110	112	81	finally
    //   20	29	86	finally
    //   32	49	86	finally
    //   87	89	86	finally
    //   53	60	91	finally
    //   94	105	107	finally
    //   108	110	107	finally
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mUri=");
    paramPrintWriter.println(mUri);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mProjection=");
    paramPrintWriter.println(Arrays.toString(mProjection));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelection=");
    paramPrintWriter.println(mSelection);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSelectionArgs=");
    paramPrintWriter.println(Arrays.toString(mSelectionArgs));
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mSortOrder=");
    paramPrintWriter.println(mSortOrder);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mCursor=");
    paramPrintWriter.println(mCursor);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("mContentChanged=");
    paramPrintWriter.println(mContentChanged);
  }
  
  protected final void onReset()
  {
    super.onReset();
    cancelLoad();
    if ((mCursor != null) && (!mCursor.isClosed())) {
      mCursor.close();
    }
    mCursor = null;
  }
  
  protected final void onStartLoading()
  {
    if (mCursor != null) {
      deliverResult(mCursor);
    }
    if ((takeContentChanged()) || (mCursor == null)) {
      forceLoad();
    }
  }
  
  protected final void onStopLoading()
  {
    cancelLoad();
  }
}

/* Location:
 * Qualified Name:     android.support.v4.content.CursorLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */