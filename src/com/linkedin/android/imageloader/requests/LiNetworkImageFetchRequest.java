package com.linkedin.android.imageloader.requests;

import android.content.Context;
import android.support.v4.util.ArrayMap;
import com.linkedin.android.imageloader.Utils;
import com.linkedin.android.imageloader.interfaces.ImageDecoder;
import com.linkedin.android.imageloader.interfaces.ImageFetchRequest;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ImageTransformer;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.networking.request.AbstractRequest;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class LiNetworkImageFetchRequest
  extends AbstractRequest
  implements ImageFetchRequest
{
  private static final String TAG = LiNetworkImageFetchRequest.class.getSimpleName();
  private final Context mContext;
  private final com.linkedin.android.imageloader.interfaces.PerfEventListener mPerfEventListener;
  
  public LiNetworkImageFetchRequest(Context paramContext, String paramString, ImageDecoder paramImageDecoder, ImageTransformer paramImageTransformer, ImageListener paramImageListener, com.linkedin.android.imageloader.interfaces.PerfEventListener paramPerfEventListener)
  {
    super(0, paramString, new ImageNetworkResponseListener(paramString, paramPerfEventListener, paramImageListener, paramImageTransformer, paramImageDecoder), null);
    isCacheable = true;
    socketTimeoutMillis = 20000;
    mContext = paramContext;
    mPerfEventListener = paramPerfEventListener;
    if (mPerfEventListener != null) {
      perfEventListener = new com.linkedin.android.networking.interfaces.PerfEventListener()
      {
        public final void didReceiveFirstChunk(String paramAnonymousString)
        {
          mPerfEventListener.didReceiveFirstChunk(paramAnonymousString);
        }
        
        public final void dnsLookupDidEnd(String paramAnonymousString)
        {
          mPerfEventListener.dnsLookupDidEnd(paramAnonymousString);
        }
        
        public final void dnsLookupWillStart(String paramAnonymousString)
        {
          mPerfEventListener.dnsLookupWillStart(paramAnonymousString);
        }
        
        public final void requestDidEnd(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2)
        {
          mPerfEventListener.requestDidEnd(paramAnonymousString1, paramAnonymousLong1, paramAnonymousLong2, paramAnonymousString2);
        }
        
        public final void requestWillStart(String paramAnonymousString)
        {
          mPerfEventListener.networkRequestWillStart(paramAnonymousString);
        }
        
        public final void setCDNProvider$16da05f7(String paramAnonymousString) {}
        
        public final void setPopId(String paramAnonymousString)
        {
          mPerfEventListener.setPopId(paramAnonymousString);
        }
      };
    }
  }
  
  public final Map<String, String> getHeaders()
  {
    ArrayMap localArrayMap = new ArrayMap();
    localArrayMap.putAll(super.getHeaders());
    label95:
    for (;;)
    {
      try
      {
        String str = new URL(getUrl()).getHost();
        if (!str.startsWith("media.licdn.com")) {
          if (str.startsWith("media.licdn-ei.com"))
          {
            break label95;
            if (i != 0) {
              localArrayMap.put("Referer", Utils.getRefererHeader(mContext));
            }
            return localArrayMap;
          }
          else
          {
            i = 0;
            continue;
          }
        }
        int i = 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        Log.e(TAG, localMalformedURLException.getMessage());
        return localArrayMap;
      }
    }
  }
  
  private static final class ImageNetworkResponseListener
    implements ResponseListener<ManagedBitmap, Object>
  {
    private final ImageDecoder mImageDecoder;
    private final ImageTransformer mImageTransformer;
    private final ImageListener mListener;
    private final com.linkedin.android.imageloader.interfaces.PerfEventListener mPerfEventListener;
    private final String mUrl;
    
    ImageNetworkResponseListener(String paramString, com.linkedin.android.imageloader.interfaces.PerfEventListener paramPerfEventListener, ImageListener paramImageListener, ImageTransformer paramImageTransformer, ImageDecoder paramImageDecoder)
    {
      mUrl = paramString;
      mPerfEventListener = paramPerfEventListener;
      mListener = paramImageListener;
      mImageTransformer = paramImageTransformer;
      mImageDecoder = paramImageDecoder;
    }
    
    /* Error */
    private ManagedBitmap parseSuccessResponse(RawResponse paramRawResponse)
      throws IOException
    {
      // Byte code:
      //   0: getstatic 50	com/linkedin/android/imageloader/LiImageDecoder:sDecodeLock	Ljava/lang/Object;
      //   3: astore_3
      //   4: aload_3
      //   5: monitorenter
      //   6: aconst_null
      //   7: astore_2
      //   8: aload_0
      //   9: getfield 31	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest$ImageNetworkResponseListener:mListener	Lcom/linkedin/android/imageloader/interfaces/ImageListener;
      //   12: ifnull +13 -> 25
      //   15: aload_0
      //   16: getfield 31	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest$ImageNetworkResponseListener:mListener	Lcom/linkedin/android/imageloader/interfaces/ImageListener;
      //   19: invokeinterface 56 1 0
      //   24: astore_2
      //   25: aload_1
      //   26: iconst_0
      //   27: invokeinterface 62 2 0
      //   32: astore 4
      //   34: aload 4
      //   36: ifnonnull +68 -> 104
      //   39: new 40	java/io/IOException
      //   42: dup
      //   43: ldc 64
      //   45: invokespecial 67	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   48: athrow
      //   49: astore_2
      //   50: invokestatic 71	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest:access$100	()Ljava/lang/String;
      //   53: new 73	java/lang/StringBuilder
      //   56: dup
      //   57: ldc 75
      //   59: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   62: aload_1
      //   63: invokeinterface 80 1 0
      //   68: invokevirtual 84	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   71: ldc 86
      //   73: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   76: aload_0
      //   77: getfield 27	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest$ImageNetworkResponseListener:mUrl	Ljava/lang/String;
      //   80: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   83: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   86: invokestatic 98	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
      //   89: pop
      //   90: new 40	java/io/IOException
      //   93: dup
      //   94: aload_2
      //   95: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
      //   98: athrow
      //   99: astore_1
      //   100: aload_3
      //   101: monitorexit
      //   102: aload_1
      //   103: athrow
      //   104: aload_0
      //   105: getfield 35	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest$ImageNetworkResponseListener:mImageDecoder	Lcom/linkedin/android/imageloader/interfaces/ImageDecoder;
      //   108: aload 4
      //   110: aload_2
      //   111: aload_0
      //   112: getfield 33	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest$ImageNetworkResponseListener:mImageTransformer	Lcom/linkedin/android/imageloader/interfaces/ImageTransformer;
      //   115: aload_0
      //   116: getfield 29	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest$ImageNetworkResponseListener:mPerfEventListener	Lcom/linkedin/android/imageloader/interfaces/PerfEventListener;
      //   119: invokeinterface 107 5 0
      //   124: astore_2
      //   125: aload_2
      //   126: ifnonnull +36 -> 162
      //   129: new 40	java/io/IOException
      //   132: dup
      //   133: ldc 109
      //   135: invokespecial 67	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   138: athrow
      //   139: astore_1
      //   140: invokestatic 71	com/linkedin/android/imageloader/requests/LiNetworkImageFetchRequest:access$100	()Ljava/lang/String;
      //   143: ldc 111
      //   145: aload_1
      //   146: invokestatic 114	com/linkedin/android/logger/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
      //   149: pop
      //   150: aload_1
      //   151: instanceof 40
      //   154: ifeq +12 -> 166
      //   157: aload_1
      //   158: checkcast 40	java/io/IOException
      //   161: athrow
      //   162: aload_3
      //   163: monitorexit
      //   164: aload_2
      //   165: areturn
      //   166: new 40	java/io/IOException
      //   169: dup
      //   170: aload_1
      //   171: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
      //   174: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	175	0	this	ImageNetworkResponseListener
      //   0	175	1	paramRawResponse	RawResponse
      //   7	18	2	localPair	android.util.Pair
      //   49	62	2	localOutOfMemoryError	OutOfMemoryError
      //   124	41	2	localManagedBitmap	ManagedBitmap
      //   3	160	3	localObject	Object
      //   32	77	4	localInputStream	java.io.InputStream
      // Exception table:
      //   from	to	target	type
      //   8	25	49	java/lang/OutOfMemoryError
      //   25	34	49	java/lang/OutOfMemoryError
      //   39	49	49	java/lang/OutOfMemoryError
      //   104	125	49	java/lang/OutOfMemoryError
      //   129	139	49	java/lang/OutOfMemoryError
      //   8	25	99	finally
      //   25	34	99	finally
      //   39	49	99	finally
      //   50	99	99	finally
      //   100	102	99	finally
      //   104	125	99	finally
      //   129	139	99	finally
      //   140	162	99	finally
      //   162	164	99	finally
      //   166	175	99	finally
      //   8	25	139	java/lang/Exception
      //   25	34	139	java/lang/Exception
      //   39	49	139	java/lang/Exception
      //   104	125	139	java/lang/Exception
      //   129	139	139	java/lang/Exception
    }
    
    public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
    {
      if (mListener != null) {
        mListener.onErrorResponse(mUrl, paramIOException);
      }
    }
    
    public final Object parseErrorResponse(RawResponse paramRawResponse)
      throws IOException
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.imageloader.requests.LiNetworkImageFetchRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */