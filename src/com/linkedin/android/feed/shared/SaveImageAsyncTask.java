package com.linkedin.android.feed.shared;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.linkedin.android.infra.shared.PhotoUtils;

public class SaveImageAsyncTask
  extends AsyncTask<Void, Void, Uri>
{
  private static final String TAG = SaveImageAsyncTask.class.getSimpleName();
  private final Bitmap bitmap;
  private final Context context;
  private final PhotoUtils photoUtils;
  
  public SaveImageAsyncTask(Context paramContext, PhotoUtils paramPhotoUtils, Bitmap paramBitmap)
  {
    context = paramContext;
    photoUtils = paramPhotoUtils;
    bitmap = paramBitmap;
  }
  
  /* Error */
  private Uri doInBackground$34e9db1e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: aload_2
    //   5: astore_1
    //   6: invokestatic 44	com/linkedin/android/infra/shared/PhotoUtils:saveImageFileToPicturesDirectory	()Ljava/io/File;
    //   9: invokestatic 50	android/net/Uri:fromFile	(Ljava/io/File;)Landroid/net/Uri;
    //   12: astore 4
    //   14: aload_2
    //   15: astore_1
    //   16: new 52	java/io/BufferedOutputStream
    //   19: dup
    //   20: aload_0
    //   21: getfield 30	com/linkedin/android/feed/shared/SaveImageAsyncTask:context	Landroid/content/Context;
    //   24: invokevirtual 58	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   27: aload 4
    //   29: invokevirtual 64	android/content/ContentResolver:openOutputStream	(Landroid/net/Uri;)Ljava/io/OutputStream;
    //   32: invokespecial 67	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   35: astore_2
    //   36: aload_0
    //   37: getfield 34	com/linkedin/android/feed/shared/SaveImageAsyncTask:bitmap	Landroid/graphics/Bitmap;
    //   40: getstatic 73	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   43: bipush 90
    //   45: aload_2
    //   46: invokevirtual 79	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   49: pop
    //   50: iconst_1
    //   51: anewarray 81	java/io/Closeable
    //   54: dup
    //   55: iconst_0
    //   56: aload_2
    //   57: aastore
    //   58: invokestatic 85	com/linkedin/android/infra/shared/PhotoUtils:closeSilently	([Ljava/io/Closeable;)V
    //   61: aload 4
    //   63: areturn
    //   64: astore_1
    //   65: aload_3
    //   66: astore_2
    //   67: aload_1
    //   68: astore_3
    //   69: aload_2
    //   70: astore_1
    //   71: getstatic 23	com/linkedin/android/feed/shared/SaveImageAsyncTask:TAG	Ljava/lang/String;
    //   74: ldc 87
    //   76: aload_3
    //   77: invokestatic 93	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   80: pop
    //   81: iconst_1
    //   82: anewarray 81	java/io/Closeable
    //   85: dup
    //   86: iconst_0
    //   87: aload_2
    //   88: aastore
    //   89: invokestatic 85	com/linkedin/android/infra/shared/PhotoUtils:closeSilently	([Ljava/io/Closeable;)V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_2
    //   95: iconst_1
    //   96: anewarray 81	java/io/Closeable
    //   99: dup
    //   100: iconst_0
    //   101: aload_1
    //   102: aastore
    //   103: invokestatic 85	com/linkedin/android/infra/shared/PhotoUtils:closeSilently	([Ljava/io/Closeable;)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_3
    //   109: aload_2
    //   110: astore_1
    //   111: aload_3
    //   112: astore_2
    //   113: goto -18 -> 95
    //   116: astore_3
    //   117: goto -48 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	120	0	this	SaveImageAsyncTask
    //   5	11	1	localObject1	Object
    //   64	4	1	localIOException1	java.io.IOException
    //   70	41	1	localObject2	Object
    //   1	87	2	localObject3	Object
    //   94	16	2	localObject4	Object
    //   112	1	2	localObject5	Object
    //   3	74	3	localObject6	Object
    //   108	4	3	localObject7	Object
    //   116	1	3	localIOException2	java.io.IOException
    //   12	50	4	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   6	14	64	java/io/IOException
    //   16	36	64	java/io/IOException
    //   6	14	94	finally
    //   16	36	94	finally
    //   71	81	94	finally
    //   36	50	108	finally
    //   36	50	116	java/io/IOException
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.SaveImageAsyncTask
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */