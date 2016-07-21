package com.linkedin.android.growth.login.smartlock;

import android.os.Bundle;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequest.Builder;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.lix.LixManager.TreatmentListener;
import com.linkedin.android.infra.lix.PreAuthLix;
import com.linkedin.android.infra.lix.PreAuthLixManager;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.MultipleTrackingEventSender;
import javax.inject.Inject;

public class SmartLockManager
{
  public static final String TAG = SmartLockManager.class.getSimpleName();
  public BaseActivity activity;
  public String credentialEmail;
  public String credentialPassword;
  public GoogleApiClient credentialsApiClient;
  public boolean isSmartLockOn = true;
  private LixManager.TreatmentListener treatmentListener;
  
  @Inject
  public SmartLockManager(BaseActivity paramBaseActivity)
  {
    activity = paramBaseActivity;
  }
  
  public static void sendTrackingEvent(Tracker paramTracker, String paramString)
  {
    new MultipleTrackingEventSender(paramTracker, new ControlInteractionEvent(paramTracker, paramString, ControlType.TYPEAHEAD, InteractionType.FOCUS), new TrackingEventBuilder[0]).sendAll();
  }
  
  public final void connect(final SmartLockConnectListener paramSmartLockConnectListener)
  {
    if ((credentialsApiClient == null) || (!credentialsApiClient.isConnecting()))
    {
      credentialsApiClient = new GoogleApiClient.Builder(activity).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks()
      {
        public final void onConnected(Bundle paramAnonymousBundle)
        {
          paramSmartLockConnectListener.onConnectSucceed();
        }
        
        public final void onConnectionSuspended(int paramAnonymousInt)
        {
          credentialsApiClient.reconnect();
        }
      }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener()
      {
        public final void onConnectionFailed(ConnectionResult paramAnonymousConnectionResult)
        {
          Log.e(SmartLockManager.TAG, "onConnectionFailed:" + paramAnonymousConnectionResult);
          paramSmartLockConnectListener.onConnectFailed();
        }
      }).addApi(Auth.CREDENTIALS_API).build();
      credentialsApiClient.connect();
    }
  }
  
  public final LixManager.TreatmentListener getTreatmentListener()
  {
    if (treatmentListener == null) {
      treatmentListener = new LixManager.TreatmentListener()
      {
        public final void onChange(String paramAnonymousString)
        {
          if (paramAnonymousString.equals("enabled")) {
            connect(new SmartLockConnectListener()
            {
              public final void onConnectFailed() {}
              
              public final void onConnectSucceed() {}
            });
          }
        }
      };
    }
    return treatmentListener;
  }
  
  public final boolean isConnected()
  {
    return (credentialsApiClient != null) && (credentialsApiClient.isConnected());
  }
  
  public final boolean isSmartLockOn()
  {
    return (isSmartLockOn) && (activity.applicationComponent.preAuthLixManager().getTreatment(PreAuthLix.LIX_SMART_LOCK).equals("enabled"));
  }
  
  public final void loadCredentials(final SmartLockCredentialRequestListener paramSmartLockCredentialRequestListener)
  {
    Object localObject = new CredentialRequest.Builder();
    zzWd = true;
    if (zzWe == null) {
      zzWe = new String[0];
    }
    if ((!zzWd) && (zzWe.length == 0)) {
      throw new IllegalStateException("At least one authentication method must be specified");
    }
    localObject = new CredentialRequest((CredentialRequest.Builder)localObject, (byte)0);
    Auth.CredentialsApi.request(credentialsApiClient, (CredentialRequest)localObject).setResultCallback(new ResultCallback() {});
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.login.smartlock.SmartLockManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */