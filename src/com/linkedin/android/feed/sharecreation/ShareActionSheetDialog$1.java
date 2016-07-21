package com.linkedin.android.feed.sharecreation;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.util.Pair;
import com.linkedin.android.feed.shared.SaveImageAsyncTask;
import com.linkedin.android.imageloader.interfaces.ImageListener;
import com.linkedin.android.imageloader.interfaces.ManagedBitmap;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.SnackbarUtil;

final class ShareActionSheetDialog$1
  implements ImageListener
{
  ShareActionSheetDialog$1(ShareActionSheetDialog paramShareActionSheetDialog) {}
  
  public final Pair<Integer, Integer> getTargetDimensions()
  {
    return null;
  }
  
  public final void onErrorResponse(String paramString, Exception paramException)
  {
    Log.e(ShareActionSheetDialog.access$100(), "Error loading image", paramException);
    paramString = ShareActionSheetDialog.access$000(this$0).activity();
    paramString = new SnackbarUtil(paramString).make(paramString.getString(2131231252), 0);
    if (paramString != null) {
      paramString.show();
    }
  }
  
  public final void onResponse(String paramString, ManagedBitmap paramManagedBitmap, boolean paramBoolean)
  {
    paramString = paramManagedBitmap.getBitmap().getConfig();
    paramString = paramManagedBitmap.getBitmap().copy(paramString, false);
    new SaveImageAsyncTask(ShareActionSheetDialog.access$000(this$0).context(), ShareActionSheetDialog.access$000(this$0).photoUtils(), paramString).executeOnExecutor(SaveImageAsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.sharecreation.ShareActionSheetDialog.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */