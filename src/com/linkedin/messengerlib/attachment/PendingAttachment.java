package com.linkedin.messengerlib.attachment;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.util.Log;
import android.webkit.MimeTypeMap;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class PendingAttachment
{
  private static final String TAG = PendingAttachment.class.getCanonicalName();
  public String fileId;
  public String fileName;
  public boolean isApproved;
  public String mediaType;
  public AttachmentUploadState uploadState;
  public Uri uri;
  
  public PendingAttachment()
  {
    clear();
  }
  
  public final void clear()
  {
    uri = null;
    mediaType = GENERIC_FILEmediaType;
    uploadState = AttachmentUploadState.EMPTY;
    isApproved = false;
    fileId = null;
    fileName = null;
  }
  
  public final void updateMediaType(Context paramContext)
  {
    Object localObject3 = null;
    String str = null;
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localInputStream = paramContext.getContentResolver().openInputStream(uri);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        inJustDecodeBounds = true;
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        BitmapFactory.decodeStream(localInputStream, null, localOptions);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        if (outMimeType != null)
        {
          localObject1 = localInputStream;
          localObject2 = localInputStream;
          str = outMimeType;
        }
        localObject2 = str;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        InputStream localInputStream;
        localObject2 = localIOException1;
        Log.e(TAG, "Error getting mediaType for : " + uri.toString(), localFileNotFoundException);
        localObject2 = localObject3;
        if (localIOException1 == null) {
          continue;
        }
        try
        {
          localIOException1.close();
          localObject2 = localObject3;
        }
        catch (IOException localIOException2)
        {
          Log.e(TAG, "Error closing stream for : " + uri.toString(), localIOException2);
          localObject2 = localObject3;
        }
        continue;
      }
      finally
      {
        if (localObject2 == null) {
          break label302;
        }
      }
      try
      {
        localInputStream.close();
        localObject2 = str;
      }
      catch (IOException localIOException1)
      {
        Log.e(TAG, "Error closing stream for : " + uri.toString(), localIOException1);
        localObject2 = str;
      }
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramContext.getContentResolver().getType(uri);
    }
    paramContext = (Context)localObject1;
    if (localObject1 == null)
    {
      localObject2 = MimeTypeMap.getFileExtensionFromUrl(uri.toString());
      paramContext = (Context)localObject1;
      if (localObject2 != null) {
        paramContext = MimeTypeMap.getSingleton().getMimeTypeFromExtension((String)localObject2);
      }
    }
    if (paramContext != null) {
      mediaType = paramContext;
    }
    return;
    try
    {
      ((InputStream)localObject2).close();
      label302:
      throw paramContext;
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e(TAG, "Error closing stream for : " + uri.toString(), localIOException3);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.attachment.PendingAttachment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */