package com.linkedin.android.shaky;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DrawFragment
  extends Fragment
{
  public static final String ACTION_DRAWING_COMPLETE = "ActionDrawingComplete";
  private static final String KEY_IMAGE_URI = "imageUri";
  private static final String TAG = DrawFragment.class.getSimpleName();
  private Uri imageUri;
  private Paper paper;
  
  private View.OnClickListener createBrushClickListener()
  {
    return new DrawFragment.2(this);
  }
  
  private View.OnClickListener createClearClickListener()
  {
    return new DrawFragment.1(this);
  }
  
  private View.OnClickListener createSaveClickListener()
  {
    return new DrawFragment.3(this);
  }
  
  public static DrawFragment newInstance(Uri paramUri)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("imageUri", paramUri);
    paramUri = new DrawFragment();
    paramUri.setArguments(localBundle);
    return paramUri;
  }
  
  private void saveBitmap(Bitmap paramBitmap)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    for (;;)
    {
      try
      {
        localOutputStream = getActivity().getContentResolver().openOutputStream(imageUri);
        localObject1 = localOutputStream;
        localObject2 = localOutputStream;
        paramBitmap.compress(Bitmap.CompressFormat.PNG, 100, localOutputStream);
      }
      catch (FileNotFoundException paramBitmap)
      {
        OutputStream localOutputStream;
        localObject2 = localObject1;
        Log.e(TAG, "Failed to write updated bitmap to disk", paramBitmap);
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((OutputStream)localObject1).close();
          return;
        }
        catch (IOException paramBitmap)
        {
          Log.e(TAG, "Failed to close output stream", paramBitmap);
          return;
        }
      }
      finally
      {
        if (localObject2 == null) {
          break label104;
        }
      }
      try
      {
        localOutputStream.close();
        return;
      }
      catch (IOException paramBitmap)
      {
        Log.e(TAG, "Failed to close output stream", paramBitmap);
        return;
      }
    }
    try
    {
      ((OutputStream)localObject2).close();
      label104:
      throw paramBitmap;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e(TAG, "Failed to close output stream", localIOException);
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.shaky_draw, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    Object localObject4 = null;
    imageUri = ((Uri)getArguments().getParcelable("imageUri"));
    Object localObject2 = localObject4;
    Object localObject1;
    if (imageUri != null)
    {
      localObject2 = null;
      localObject1 = null;
    }
    for (;;)
    {
      try
      {
        localInputStream = getActivity().getContentResolver().openInputStream(imageUri);
        localObject1 = localInputStream;
        localObject2 = localInputStream;
        Bitmap localBitmap = BitmapFactory.decodeStream(localInputStream);
        localObject1 = localBitmap;
        localObject2 = localObject1;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        InputStream localInputStream;
        localObject3 = localObject1;
        Log.e(TAG, "Could not open input stream for uri", localFileNotFoundException);
        localObject3 = localObject4;
        if (localObject1 == null) {
          continue;
        }
        try
        {
          ((InputStream)localObject1).close();
          localObject3 = localObject4;
        }
        catch (IOException localIOException1)
        {
          Log.e(TAG, "Failed to close input stream", localIOException1);
          localObject3 = localObject4;
        }
        continue;
      }
      finally
      {
        if (localObject3 == null) {
          break label261;
        }
      }
      try
      {
        localInputStream.close();
        localObject2 = localObject1;
      }
      catch (IOException localIOException2)
      {
        Log.e(TAG, "Failed to close input stream", localIOException2);
        localObject3 = localObject1;
      }
    }
    paper = ((Paper)paramView.findViewById(R.id.paper));
    paper.setImage((Bitmap)localObject2);
    paramView.findViewById(R.id.button_clear).setOnClickListener(createClearClickListener());
    paramView.findViewById(R.id.button_save).setOnClickListener(createSaveClickListener());
    paramView.findViewById(R.id.button_brush).setOnClickListener(createBrushClickListener());
    if (paramBundle == null) {
      Toast.makeText(getActivity(), getString(R.string.draw_hint), 0).show();
    }
    return;
    try
    {
      Object localObject3;
      ((InputStream)localObject3).close();
      label261:
      throw paramView;
    }
    catch (IOException paramBundle)
    {
      for (;;)
      {
        Log.e(TAG, "Failed to close input stream", paramBundle);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.shaky.DrawFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */