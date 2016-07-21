package com.linkedin.android.feed.shared.imageviewer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import com.linkedin.android.infra.FragmentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.shared.OnBackPressedListener;
import com.linkedin.android.infra.shared.OnWindowFocusChangedListener;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.common.Image;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public class ImageViewerActivity
  extends BaseActivity
{
  public void onBackPressed()
  {
    Fragment localFragment = getSupportFragmentManager().findFragmentById(16908290);
    if (((localFragment instanceof OnBackPressedListener)) && (((OnBackPressedListener)localFragment).onBackPressed())) {
      return;
    }
    super.onBackPressed();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null) {
      return;
    }
    setContentView(2130968943);
    paramBundle = getIntent().getExtras();
    Update localUpdate = ImageViewerBundle.getUpdate(paramBundle);
    String str1 = ImageViewerBundle.getUpdateUrn(paramBundle);
    String str2 = paramBundle.getString("updateEntityUrn");
    Image localImage = ImageViewerBundle.getPlaceholderImage(paramBundle);
    boolean bool = paramBundle.getBoolean("backWhenReply");
    paramBundle = null;
    if (localUpdate != null) {
      paramBundle = ImageViewerBundle.create(localUpdate, bool);
    }
    while (paramBundle != null)
    {
      if (localImage != null) {
        paramBundle.setPlaceholderImage(localImage);
      }
      paramBundle = fragmentRegistry.imageViewer.newFragment(paramBundle);
      getSupportFragmentManager().beginTransaction().add(16908290, paramBundle).commit();
      return;
      if (!TextUtils.isEmpty(str1)) {
        paramBundle = ImageViewerBundle.create(str1, str2, bool);
      }
    }
    Util.safeThrow(new RuntimeException("Can't open an ImageViewer without an update ID"));
    finish();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    Fragment localFragment = getSupportFragmentManager().findFragmentById(16908290);
    if ((localFragment instanceof OnWindowFocusChangedListener)) {
      ((OnWindowFocusChangedListener)localFragment).onWindowFocusChanged$1385ff();
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.shared.imageviewer.ImageViewerActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */