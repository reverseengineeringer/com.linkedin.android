package com.linkedin.android.infra.shared;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AlertDialog.Builder;
import android.view.View;
import com.linkedin.android.cropphotoview.PhotoView;
import com.linkedin.android.identity.edit.ProfileEditListener;
import com.linkedin.android.identity.shared.ProfilePhotoViewFragment;
import com.linkedin.android.identity.shared.asyncTasks.DeleteFilesAsyncTask;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.cropoverlay.edge.Edge;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ImageCropInfo.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Picture.Builder;
import com.linkedin.android.tracking.v2.event.PageViewEvent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.inject.Inject;

public class PhotoUtils
{
  public static final String[] ACCEPT_MIME_TYPES = { "image/*" };
  @SuppressLint({"InlinedApi"})
  public static final String IMAGE_CHOOSER_ACTION;
  private static final String TAG;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    for (String str = "android.intent.action.OPEN_DOCUMENT";; str = "android.intent.action.GET_CONTENT")
    {
      IMAGE_CHOOSER_ACTION = str;
      TAG = PhotoUtils.class.getSimpleName();
      return;
    }
  }
  
  public static void closeSilently(Closeable... paramVarArgs)
  {
    int i = 0;
    while (i <= 0)
    {
      Closeable localCloseable = paramVarArgs[0];
      if (localCloseable != null) {}
      try
      {
        localCloseable.close();
        i += 1;
      }
      catch (IOException paramVarArgs)
      {
        Log.e(TAG, "Failed to close a stream." + paramVarArgs.getLocalizedMessage());
      }
    }
  }
  
  public static Picture createPicture(String paramString1, String paramString2)
    throws BuilderException
  {
    Picture.Builder localBuilder = new Picture.Builder();
    if (paramString2 == null)
    {
      hasCroppedImage = false;
      croppedImage = null;
      if (paramString1 != null) {
        break label163;
      }
      hasMasterImage = false;
      masterImage = null;
      label36:
      paramString1 = new ImageCropInfo.Builder();
      paramString2 = Integer.valueOf(0);
      if (paramString2 != null) {
        break label176;
      }
      hasX = false;
      x = 0;
      label63:
      paramString2 = Integer.valueOf(0);
      if (paramString2 != null) {
        break label192;
      }
      hasY = false;
      y = 0;
      label82:
      paramString2 = Integer.valueOf(400);
      if (paramString2 != null) {
        break label208;
      }
      hasWidth = false;
      width = 0;
      label103:
      paramString2 = Integer.valueOf(400);
      if (paramString2 != null) {
        break label224;
      }
      hasHeight = false;
    }
    for (height = 0;; height = paramString2.intValue())
    {
      paramString1 = paramString1.build(RecordTemplate.Flavor.RECORD);
      hasCropInfo = true;
      cropInfo = paramString1;
      return localBuilder.build(RecordTemplate.Flavor.RECORD);
      hasCroppedImage = true;
      croppedImage = paramString2;
      break;
      label163:
      hasMasterImage = true;
      masterImage = paramString1;
      break label36;
      label176:
      hasX = true;
      x = paramString2.intValue();
      break label63;
      label192:
      hasY = true;
      y = paramString2.intValue();
      break label82;
      label208:
      hasWidth = true;
      width = paramString2.intValue();
      break label103;
      label224:
      hasHeight = true;
    }
  }
  
  public static File createTempImageFile(Context paramContext)
    throws IOException
  {
    String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
    str = "temp_image_" + str + "_";
    paramContext = paramContext.getExternalCacheDir();
    if ((paramContext == null) || (!isExternalStorageWritable())) {
      throw new IOException("couldn't access the external cache directory");
    }
    paramContext = new File(paramContext.getAbsolutePath() + "/.temp/");
    if ((!paramContext.exists()) && (!paramContext.mkdir())) {
      throw new IOException();
    }
    return File.createTempFile(str, ".jpg", paramContext);
  }
  
  public static boolean deviceHasCamera(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    return (paramContext.hasSystemFeature("android.hardware.camera")) || (paramContext.hasSystemFeature("android.hardware.camera.front"));
  }
  
  public static Bitmap getCroppedImage(PhotoView paramPhotoView)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramPhotoView.getWidth(), paramPhotoView.getHeight(), Bitmap.Config.RGB_565);
    paramPhotoView.draw(new Canvas(localBitmap));
    int j = localBitmap.getWidth();
    int k = localBitmap.getHeight();
    int m = paramPhotoView.getWidth();
    int i = paramPhotoView.getHeight();
    double d1 = Double.POSITIVE_INFINITY;
    double d2 = Double.POSITIVE_INFINITY;
    if (m < j) {
      d1 = m / j;
    }
    if (i < k) {
      d2 = i / k;
    }
    if ((d1 != Double.POSITIVE_INFINITY) || (d2 != Double.POSITIVE_INFINITY)) {
      if (d1 <= d2)
      {
        d2 = m;
        d1 = k * d2 / j;
        if (d2 != m) {
          break label411;
        }
        j = 0;
        i = (int)Math.round((i - d1) / 2.0D);
      }
    }
    for (;;)
    {
      paramPhotoView = new Rect(j, i, (int)Math.ceil(d2) + j, (int)Math.ceil(d1) + i);
      float f2 = localBitmap.getWidth();
      float f6 = f2 / paramPhotoView.width();
      float f1 = localBitmap.getHeight();
      float f4 = f1 / paramPhotoView.height();
      float f3 = LEFTcoordinate;
      float f10 = left;
      float f8 = TOPcoordinate;
      float f9 = top;
      float f7 = Edge.getWidth();
      float f5 = Edge.getHeight();
      f3 = (f3 - f10) * f6;
      f8 = (f8 - f9) * f4;
      f6 = f7 * f6;
      f4 = f5 * f4;
      if (f3 + f6 > f2) {
        CrashReporter.reportNonFatal(new IllegalArgumentException("crop x + crop width > image width"));
      }
      if (f8 + f4 > f1) {
        CrashReporter.reportNonFatal(new IllegalArgumentException("crop y + crop height > image height"));
      }
      f2 = Math.min(f6, f2 - f3);
      f1 = Math.min(f4, f1 - f8);
      return Bitmap.createBitmap(localBitmap, (int)f3, (int)f8, (int)f2, (int)f1);
      d1 = i;
      d2 = j * d1 / k;
      break;
      d1 = k;
      d2 = j;
      break;
      label411:
      if (d1 == i)
      {
        j = (int)Math.round((m - d2) / 2.0D);
        i = 0;
      }
      else
      {
        j = (int)Math.round((m - d2) / 2.0D);
        i = (int)Math.round((i - d1) / 2.0D);
      }
    }
  }
  
  public static boolean isExternalStorageWritable()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public static Bitmap replaceBitmapColor(Bitmap paramBitmap, int paramInt)
  {
    paramBitmap = paramBitmap.copy(paramBitmap.getConfig(), true);
    Paint localPaint = new Paint();
    localPaint.setColorFilter(new PorterDuffColorFilter(paramInt, PorterDuff.Mode.SRC_IN));
    new Canvas(paramBitmap).drawBitmap(paramBitmap, 0.0F, 0.0F, localPaint);
    return paramBitmap;
  }
  
  public static File saveImageFileToPicturesDirectory()
    throws IOException
  {
    String str = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(new Date());
    str = "image_" + str + ".jpg";
    File localFile = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
    if ((localFile == null) || (!isExternalStorageWritable())) {
      throw new IOException("couldn't access the external storage directory");
    }
    localFile = new File(localFile.getAbsolutePath());
    if ((!localFile.exists()) && (!localFile.mkdirs())) {
      throw new IOException();
    }
    return new File(localFile, str);
  }
  
  public static void setPhotoViewScale(PhotoView paramPhotoView, float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    paramPhotoView.setMinimumScale(paramFloat);
    paramPhotoView.setMediumScale(2.0F * paramFloat);
    paramPhotoView.setMaximumScale(3.0F * paramFloat);
  }
  
  public static void showCameraCouldNotBeOpenedAlert(Fragment paramFragment)
  {
    if (paramFragment.getActivity() != null) {
      new AlertDialog.Builder(paramFragment.getActivity()).setMessage(2131230815).setNeutralButton$2cf0b439().show();
    }
  }
  
  private static void showGalleryCouldNotBeOpenedAlert(BaseFragment paramBaseFragment)
  {
    if (paramBaseFragment.getActivity() != null) {
      new AlertDialog.Builder(paramBaseFragment.getActivity()).setMessage(paramBaseFragment.getLocalizedString(2131231331)).setNeutralButton$2cf0b439().show();
    }
  }
  
  public static boolean startFileChooserForResult$5725b7b8(Fragment paramFragment)
  {
    if (paramFragment.getActivity() == null)
    {
      paramFragment.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Activity is null, cannot do anything. Will not start image chooser for result"));
    }
    Intent localIntent;
    do
    {
      return false;
      localIntent = new Intent(IMAGE_CHOOSER_ACTION);
      localIntent.addCategory("android.intent.category.OPENABLE");
      localIntent.putExtra("android.intent.extra.LOCAL_ONLY", true);
      localIntent.setType("*/*");
      if (Build.VERSION.SDK_INT >= 19) {
        localIntent.putExtra("android.intent.extra.MIME_TYPES", ACCEPT_MIME_TYPES);
      }
    } while (localIntent.resolveActivity(paramFragment.getActivity().getPackageManager()) == null);
    paramFragment.startActivityForResult(localIntent, 43);
    return true;
  }
  
  public static boolean startImageChooserForResult(Fragment paramFragment)
  {
    if (paramFragment.getActivity() == null)
    {
      paramFragment.getContext();
      Util.safeThrow$7a8b4789(new RuntimeException("Activity is null, cannot do anything. Will not start image chooser for result"));
    }
    Intent localIntent;
    do
    {
      return false;
      localIntent = new Intent(IMAGE_CHOOSER_ACTION);
      localIntent.addCategory("android.intent.category.OPENABLE");
      localIntent.putExtra("android.intent.extra.LOCAL_ONLY", true);
      localIntent.setType("image/*");
    } while (localIntent.resolveActivity(paramFragment.getActivity().getPackageManager()) == null);
    paramFragment.startActivityForResult(localIntent, 11);
    return true;
  }
  
  public final void deleteTempFiles(Context paramContext)
  {
    new DeleteFilesAsyncTask(this).execute(new Context[] { paramContext });
  }
  
  public final void onUserSelection(int paramInt, ProfileEditListener paramProfileEditListener, BaseFragment paramBaseFragment, UriListener paramUriListener, Tracker paramTracker, String paramString)
  {
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
        } while (paramProfileEditListener == null);
        paramProfileEditListener.startEditFragment(ProfilePhotoViewFragment.newInstance());
      } while ((paramTracker == null) || (paramString == null));
      new PageViewEvent(paramTracker, paramString, false).send();
      return;
      new PhotoUtils.3(this, paramBaseFragment, paramUriListener).execute(new Fragment[] { paramBaseFragment });
      return;
    } while ((!startImageChooserForResult(paramBaseFragment)) || (paramTracker == null) || (paramString == null));
    new PageViewEvent(paramTracker, paramString, false).send();
  }
  
  public final void startCameraForResult(Fragment paramFragment, UriListener paramUriListener)
  {
    new PhotoUtils.2(this, paramFragment, paramUriListener).execute(new Fragment[] { paramFragment });
  }
  
  public final void startImageChooserOrCameraForResult(BaseFragment paramBaseFragment, UriListener paramUriListener, Tracker paramTracker, String paramString1, String paramString2)
  {
    startImageChooserOrCameraForResult(paramBaseFragment, paramUriListener, paramTracker, paramString1, paramString2, null, null);
  }
  
  public final void startImageChooserOrCameraForResult(BaseFragment paramBaseFragment, UriListener paramUriListener, Tracker paramTracker, String paramString1, String paramString2, String paramString3, Closure<Void, Void> paramClosure)
  {
    Object localObject = paramBaseFragment.getActivity();
    if (localObject == null) {
      Log.e(TAG, "Can't capture an image, this fragment has no activity");
    }
    do
    {
      return;
      if (deviceHasCamera((Context)localObject)) {
        break;
      }
    } while (startImageChooserForResult(paramBaseFragment));
    showGalleryCouldNotBeOpenedAlert(paramBaseFragment);
    return;
    CharSequence[] arrayOfCharSequence;
    if (paramClosure == null)
    {
      arrayOfCharSequence = new CharSequence[2];
      arrayOfCharSequence[0] = ((Context)localObject).getString(2131233712);
      arrayOfCharSequence[1] = ((Context)localObject).getString(2131230819);
    }
    for (;;)
    {
      localObject = new AlertDialog.Builder((Context)localObject);
      ((AlertDialog.Builder)localObject).setItems(arrayOfCharSequence, new PhotoUtils.1(this, paramTracker, paramString1, paramBaseFragment, paramUriListener, paramString2, paramClosure, paramString3));
      ((AlertDialog.Builder)localObject).show();
      return;
      arrayOfCharSequence = new CharSequence[3];
      arrayOfCharSequence[0] = ((Context)localObject).getString(2131233712);
      arrayOfCharSequence[1] = ((Context)localObject).getString(2131230819);
      arrayOfCharSequence[2] = ((Context)localObject).getString(2131230844);
    }
  }
  
  public static abstract interface UriListener
  {
    public abstract void onCameraDestinationUri(Uri paramUri);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.shared.PhotoUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */