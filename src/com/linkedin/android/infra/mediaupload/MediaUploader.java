package com.linkedin.android.infra.mediaupload;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.os.Looper;
import android.webkit.MimeTypeMap;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.network.NetworkClient;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RequestDelegate;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.request.LinkedInRequestBodyFactory;
import com.linkedin.android.networking.request.RequestDelegateBuilder;
import com.linkedin.android.pegasus.gen.voyager.common.FileUploadToken;
import com.linkedin.android.pegasus.gen.voyager.common.FileUploadTokenType;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import javax.inject.Inject;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.RequestBody;

public class MediaUploader
{
  private static final String TAG = MediaUploader.class.getSimpleName();
  private final Bus bus;
  private final Context context;
  private final FlagshipDataManager dataManager;
  final Handler handler;
  private final NetworkClient networkClient;
  private final FlagshipSharedPreferences sharedPreferences;
  
  @Inject
  public MediaUploader(Bus paramBus, NetworkClient paramNetworkClient, FlagshipDataManager paramFlagshipDataManager, FlagshipSharedPreferences paramFlagshipSharedPreferences, Context paramContext)
  {
    bus = paramBus;
    context = paramContext;
    handler = new Handler(Looper.getMainLooper());
    networkClient = paramNetworkClient;
    dataManager = paramFlagshipDataManager;
    sharedPreferences = paramFlagshipSharedPreferences;
  }
  
  private static RequestBody createProgressRequestBody(MediaType paramMediaType, InputStream paramInputStream, long paramLong, Bus paramBus, Handler paramHandler, String paramString)
  {
    return new MediaUploader.5(paramMediaType, paramLong, paramInputStream, paramHandler, paramBus, paramString);
  }
  
  /* Error */
  private static long getContentLength(Context paramContext, Uri paramUri)
  {
    // Byte code:
    //   0: ldc2_w 288
    //   3: lstore 4
    //   5: ldc_w 291
    //   8: aload_1
    //   9: invokevirtual 294	android/net/Uri:getScheme	()Ljava/lang/String;
    //   12: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   15: ifeq +203 -> 218
    //   18: aconst_null
    //   19: astore 9
    //   21: aconst_null
    //   22: astore 10
    //   24: aconst_null
    //   25: astore 8
    //   27: aload_0
    //   28: invokevirtual 304	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   31: aload_1
    //   32: ldc_w 306
    //   35: invokevirtual 312	android/content/ContentResolver:openAssetFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/res/AssetFileDescriptor;
    //   38: astore_0
    //   39: lload 4
    //   41: lstore_2
    //   42: aload_0
    //   43: ifnull +20 -> 63
    //   46: aload_0
    //   47: astore 8
    //   49: aload_0
    //   50: astore 9
    //   52: aload_0
    //   53: astore 10
    //   55: aload_0
    //   56: invokevirtual 318	android/content/res/AssetFileDescriptor:getParcelFileDescriptor	()Landroid/os/ParcelFileDescriptor;
    //   59: invokevirtual 324	android/os/ParcelFileDescriptor:getStatSize	()J
    //   62: lstore_2
    //   63: lload_2
    //   64: lstore 6
    //   66: aload_0
    //   67: ifnull +10 -> 77
    //   70: aload_0
    //   71: invokevirtual 327	android/content/res/AssetFileDescriptor:close	()V
    //   74: lload_2
    //   75: lstore 6
    //   77: lload 6
    //   79: lreturn
    //   80: astore_0
    //   81: new 97	java/lang/StringBuilder
    //   84: dup
    //   85: ldc_w 329
    //   88: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_1
    //   92: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload_0
    //   99: invokestatic 341	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   102: pop
    //   103: lload_2
    //   104: lreturn
    //   105: astore_0
    //   106: aload 8
    //   108: astore 9
    //   110: new 97	java/lang/StringBuilder
    //   113: dup
    //   114: ldc_w 343
    //   117: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   120: aload_1
    //   121: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   124: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   127: aload_0
    //   128: invokestatic 341	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   131: pop
    //   132: lload 4
    //   134: lstore 6
    //   136: aload 8
    //   138: ifnull -61 -> 77
    //   141: aload 8
    //   143: invokevirtual 327	android/content/res/AssetFileDescriptor:close	()V
    //   146: ldc2_w 288
    //   149: lreturn
    //   150: astore_0
    //   151: new 97	java/lang/StringBuilder
    //   154: dup
    //   155: ldc_w 329
    //   158: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_1
    //   162: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: aload_0
    //   169: invokestatic 341	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   172: pop
    //   173: ldc2_w 288
    //   176: lreturn
    //   177: astore_0
    //   178: aload 9
    //   180: ifnull +8 -> 188
    //   183: aload 9
    //   185: invokevirtual 327	android/content/res/AssetFileDescriptor:close	()V
    //   188: aload_0
    //   189: athrow
    //   190: astore 8
    //   192: new 97	java/lang/StringBuilder
    //   195: dup
    //   196: ldc_w 329
    //   199: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   202: aload_1
    //   203: invokevirtual 335	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   206: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: aload 8
    //   211: invokestatic 341	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   214: pop
    //   215: goto -27 -> 188
    //   218: lload 4
    //   220: lstore 6
    //   222: ldc 102
    //   224: aload_1
    //   225: invokevirtual 294	android/net/Uri:getScheme	()Ljava/lang/String;
    //   228: invokevirtual 298	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq -154 -> 77
    //   234: new 345	java/io/File
    //   237: dup
    //   238: aload_1
    //   239: invokevirtual 348	android/net/Uri:getPath	()Ljava/lang/String;
    //   242: invokespecial 349	java/io/File:<init>	(Ljava/lang/String;)V
    //   245: astore_0
    //   246: lload 4
    //   248: lstore 6
    //   250: aload_0
    //   251: invokevirtual 353	java/io/File:exists	()Z
    //   254: ifeq -177 -> 77
    //   257: aload_0
    //   258: invokevirtual 356	java/io/File:length	()J
    //   261: lreturn
    //   262: astore_0
    //   263: aload 10
    //   265: astore 8
    //   267: goto -161 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	270	0	paramContext	Context
    //   0	270	1	paramUri	Uri
    //   41	63	2	l1	long
    //   3	244	4	l2	long
    //   64	185	6	l3	long
    //   25	117	8	localContext1	Context
    //   190	20	8	localIOException	java.io.IOException
    //   265	1	8	localContext2	Context
    //   19	165	9	localObject	Object
    //   22	242	10	localContext3	Context
    // Exception table:
    //   from	to	target	type
    //   70	74	80	java/io/IOException
    //   27	39	105	java/io/FileNotFoundException
    //   55	63	105	java/io/FileNotFoundException
    //   141	146	150	java/io/IOException
    //   27	39	177	finally
    //   55	63	177	finally
    //   110	132	177	finally
    //   183	188	190	java/io/IOException
    //   27	39	262	java/lang/IllegalStateException
    //   55	63	262	java/lang/IllegalStateException
  }
  
  private static InputStream getInputStream(Context paramContext, Uri paramUri)
  {
    try
    {
      if ("content".equals(paramUri.getScheme())) {
        return paramContext.getContentResolver().openInputStream(paramUri);
      }
      if ("file".equals(paramUri.getScheme()))
      {
        paramContext = new File(paramUri.getPath());
        if (paramContext.exists())
        {
          paramContext = new FileInputStream(paramContext);
          return paramContext;
        }
      }
    }
    catch (FileNotFoundException paramContext)
    {
      Log.e("Uri unable to open input stream: " + paramUri, paramContext);
      return null;
      return null;
      Log.e(TAG, "Uri scheme is not supported: " + paramUri.getScheme());
      return null;
    }
    catch (IllegalStateException paramContext)
    {
      for (;;) {}
    }
  }
  
  private static String getMimeType(Context paramContext, Uri paramUri, String paramString)
  {
    if ("content".equals(paramUri.getScheme())) {
      return paramContext.getContentResolver().getType(paramUri);
    }
    if ("file".equals(paramUri.getScheme())) {
      return MimeTypeMap.getSingleton().getMimeTypeFromExtension(paramString);
    }
    Log.e(TAG, "Uri scheme is not supported: " + paramUri.getScheme());
    return null;
  }
  
  private static String parseExtension(Context paramContext, Uri paramUri)
  {
    Object localObject = null;
    if ("content".equals(paramUri.getScheme()))
    {
      paramContext = paramContext.getContentResolver();
      paramContext = MimeTypeMap.getSingleton().getExtensionFromMimeType(paramContext.getType(paramUri));
    }
    int i;
    do
    {
      return paramContext;
      if (!"file".equals(paramUri.getScheme())) {
        break;
      }
      paramUri = paramUri.toString();
      i = paramUri.lastIndexOf('.');
      paramContext = (Context)localObject;
    } while (i == -1);
    return paramUri.substring(i + 1);
    Log.e(TAG, "Uri scheme not supported: " + paramUri.getScheme());
    return null;
  }
  
  public final void submitMediaUpload(String paramString, Uri paramUri, FileUploadTokenType paramFileUploadTokenType)
  {
    String str = Routes.FILE_UPLOAD_TOKEN.buildUponRoot().buildUpon().appendQueryParameter("type", paramFileUploadTokenType.toString()).toString();
    paramString = Request.get().url(str).builder(FileUploadToken.BUILDER).listener(new MediaUploader.3(this, paramString, paramUri, paramFileUploadTokenType)).filter(DataManager.DataStoreFilter.NETWORK_ONLY);
    dataManager.submit(paramString);
  }
  
  public final void submitSlideShareUpload(String paramString1, Uri paramUri, String paramString2, Map<String, String> paramMap)
  {
    String str = parseExtension(context, paramUri);
    Object localObject = getMimeType(context, paramUri, str);
    if (localObject != null) {}
    for (;;)
    {
      localObject = MediaType.parse((String)localObject);
      MultipartBody.Builder localBuilder = new MultipartBody.Builder();
      localBuilder.setType(MultipartBody.FORM).addPart(Headers.of(new String[] { "Content-Disposition", "form-data; filename=\"name." + str + "\"" }), createProgressRequestBody((MediaType)localObject, getInputStream(context, paramUri), getContentLength(context, paramUri), bus, handler, paramString2));
      localObject = createsetBodycreateWrapperMultipartbuildrequestDelegate;
      paramString1 = new MediaUploader.1(this, paramString1, paramUri, paramString2, paramMap);
      paramString1 = networkClient.factory.getAbsoluteRequest$3868be9b(1, "https://slideshare.www.linkedin.com/upload", paramString1, (RequestDelegate)localObject);
      networkClient.add(paramString1);
      return;
      localObject = "image/jpeg";
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.mediaupload.MediaUploader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */