package com.linkedin.android.infra;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.litrackinglib.TrackingEventListener;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.common.ActionCategory;

public class TrackingOverlayService
  extends Service
{
  private int counterOfEvents;
  private View root;
  @InjectView(2131756571)
  ScrollView scrollView;
  private Tracker tracker;
  @InjectView(2131756572)
  TextView trackingDataTextView;
  
  private void appendData(String paramString, int paramInt)
  {
    if (trackingDataTextView == null) {
      return;
    }
    ForegroundColorSpan localForegroundColorSpan = new ForegroundColorSpan(ContextCompat.getColor(getBaseContext(), paramInt));
    paramString = new StringBuilder().append(paramString).append(" ");
    paramInt = counterOfEvents + 1;
    counterOfEvents = paramInt;
    paramString = new SpannableString(paramInt + "\n");
    paramString.setSpan(localForegroundColorSpan, 0, paramString.length(), 33);
    trackingDataTextView.append(paramString);
    scrollView.post(new Runnable()
    {
      public final void run()
      {
        if (scrollView != null) {
          scrollView.fullScroll(130);
        }
      }
    });
  }
  
  private static String getFormattedMessage(String paramString1, ActionCategory paramActionCategory, String paramString2, String paramString3)
  {
    return paramString1 + " - " + paramActionCategory + ", " + paramString2 + ", " + paramString3;
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }
  
  @SuppressLint({"InflateParams"})
  public void onCreate()
  {
    super.onCreate();
    root = ((LayoutInflater)getSystemService("layout_inflater")).inflate(2130968953, null);
    ButterKnife.inject(this, root);
    Object localObject = new WindowManager.LayoutParams(-1, -1, 2006, 40, -3);
    ((WindowManager)getSystemService("window")).addView(root, (ViewGroup.LayoutParams)localObject);
    localObject = new TrackingEventListener()
    {
      public final void onTrackingEventReceived(TrackingEventBuilder paramAnonymousTrackingEventBuilder)
      {
        try
        {
          TrackingOverlayService.access$000(TrackingOverlayService.this, TrackingOverlayService.access$100$5a17cfa9(paramAnonymousTrackingEventBuilder.build()), 2131623940);
          return;
        }
        catch (BuilderException paramAnonymousTrackingEventBuilder)
        {
          TrackingOverlayService.access$000(TrackingOverlayService.this, paramAnonymousTrackingEventBuilder.getMessage(), 2131623940);
        }
      }
      
      public final void onTrackingEventReceived(String paramAnonymousString)
      {
        TrackingOverlayService.access$000(TrackingOverlayService.this, paramAnonymousString, 2131623943);
      }
    };
    trackingDataTextView.setMovementMethod(new ScrollingMovementMethod());
    tracker = ((FlagshipApplication)getApplication()).getAppComponent().tracker();
    tracker.trackingEventListener = ((TrackingEventListener)localObject);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    tracker.trackingEventListener = null;
    if (root != null) {
      ((WindowManager)getSystemService("window")).removeView(root);
    }
    trackingDataTextView = null;
    scrollView = null;
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.infra.TrackingOverlayService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */