package com.linkedin.android.liauthlib.thirdparty;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;
import android.widget.TextView;
import com.linkedin.android.liauthlib.LiAuth;
import com.linkedin.android.liauthlib.LiAuthProvider;
import com.linkedin.android.liauthlib.R.dimen;
import com.linkedin.android.liauthlib.R.id;
import com.linkedin.android.liauthlib.R.layout;
import com.linkedin.android.liauthlib.R.string;
import com.linkedin.android.liauthlib.common.LiSSOInfo;
import com.linkedin.android.liauthlib.network.HttpStack;
import com.linkedin.android.liauthlib.sso.LiSSOServiceBindingListener;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class LiThirdPartyAuthorizeActivity
  extends Activity
{
  public static final Set<String> APPS_NEEDING_EXTRA_POLICY = new HashSet(Arrays.asList(new String[] { "com.android.calendar", "com.android.email", "com.sonymobile.linkedin" }));
  Handler m_appInfoHandler = null;
  LiAuth m_auth;
  View m_authView;
  String m_callerPackage;
  String m_callerSignature;
  String m_callerSignatureHash;
  ExternalCallStatus m_externalCallStatus = new ExternalCallStatus((byte)0);
  String m_locale;
  String m_scope;
  String m_serverData;
  String m_state;
  
  protected static Bitmap downloadImage(String paramString)
  {
    try
    {
      paramString = BitmapFactory.decodeStream(new URL(paramString).openStream());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.getMessage();
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void finishWithError$6ef37c42(String paramString1, String paramString2)
  {
    Intent localIntent = getReturnIntent("content://result");
    localIntent.putExtra("com.linkedin.thirdparty.authorize.RESULT_ACTION_ERROR_INFO", paramString1);
    localIntent.putExtra("com.linkedin.thirdparty.authorize.RESULT_ACTION_ERROR_DESCRIPTION", paramString2);
    setResult(2, localIntent);
    finish();
  }
  
  private void getApplicationAndScopeData()
  {
    m_auth.thirdPartyAuthorize(getApplicationContext(), m_scope, m_locale, m_callerPackage, m_callerSignatureHash, m_serverData, false, new LiThirdPartyAuthorizeResponse.AuthListener()
    {
      public final void onResponse(LiThirdPartyAuthorizeResponse paramAnonymousLiThirdPartyAuthorizeResponse)
      {
        LiThirdPartyAuthorizeActivity localLiThirdPartyAuthorizeActivity = LiThirdPartyAuthorizeActivity.this;
        new StringBuilder("response received for authorize view ").append(statusCode).append(" ").append(m_appName);
        if (statusCode / 100 != 2)
        {
          if ((statusCode == 400) && (errorInfo.equals("unauthorized_client")))
          {
            localLiThirdPartyAuthorizeActivity.startLoginActivity(true);
            return;
          }
          localLiThirdPartyAuthorizeActivity.finishWithError$5647b3fe(LiThirdPartyErrorCode.fromMobileSDKUasCode(errorInfo), errorDescription);
          return;
        }
        if (m_accessToken != null)
        {
          localLiThirdPartyAuthorizeActivity.finishWithAccessToken(m_accessToken, m_expiresOn);
          return;
        }
        paramAnonymousLiThirdPartyAuthorizeResponse = m_appInfoHandler.obtainMessage(1000, paramAnonymousLiThirdPartyAuthorizeResponse);
        m_appInfoHandler.sendMessage(paramAnonymousLiThirdPartyAuthorizeResponse);
        m_auth.startSSOService(new LiThirdPartyAuthorizeActivity.7(localLiThirdPartyAuthorizeActivity));
      }
    });
  }
  
  private static int getMaxPermissionSize(List<LiThirdPartyPermissionInfo> paramList, TextView paramTextView)
  {
    int i = 0;
    Object localObject = null;
    if (paramList == null) {}
    label20:
    do
    {
      return 0;
      Iterator localIterator = paramList.iterator();
      for (paramList = (List<LiThirdPartyPermissionInfo>)localObject; localIterator.hasNext(); paramList = m_title)
      {
        localObject = (LiThirdPartyPermissionInfo)localIterator.next();
        if ((m_title.length() <= i) || (m_title == null)) {
          break label20;
        }
        i = m_title.length();
      }
    } while (paramList == null);
    localObject = new Rect();
    paramTextView.getPaint().getTextBounds(paramList, 0, paramList.length(), (Rect)localObject);
    return ((Rect)localObject).width();
  }
  
  private static Intent getReturnIntent(String paramString)
  {
    if (paramString != null) {}
    for (paramString = new Intent("com.linkedin.thirdparty.authorize.RESULT_ACTION", Uri.parse(paramString));; paramString = new Intent("com.linkedin.thirdparty.authorize.RESULT_ACTION"))
    {
      paramString.putExtra("sdkAuthorize", true);
      return paramString;
    }
  }
  
  private boolean isUserLoggedIn()
  {
    LiAuth localLiAuth = LiAuthProvider.getInstance(getApplicationContext());
    getApplicationContext();
    return !localLiAuth.needsAuth$faab209();
  }
  
  final void finishWithAccessToken(String paramString, long paramLong)
  {
    Intent localIntent = getReturnIntent(null);
    localIntent.putExtra("token", paramString);
    localIntent.putExtra("expiresOn", paramLong);
    localIntent.putExtra("state", m_state);
    setResult(-1, localIntent);
    finish();
  }
  
  final void finishWithError$5647b3fe(LiThirdPartyErrorCode paramLiThirdPartyErrorCode, String paramString)
  {
    finishWithError$6ef37c42(paramLiThirdPartyErrorCode.name(), paramString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    new StringBuilder("onActivityResult called ").append(paramInt1).append(" result = ").append(paramInt2);
    if (paramInt1 == 135)
    {
      if (isUserLoggedIn()) {
        getApplicationAndScopeData();
      }
    }
    else
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    finishWithError$5647b3fe(LiThirdPartyErrorCode.INTERNAL_ERROR, "login was unsuccessful");
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setContentView(R.layout.activity_third_party_authorize);
    if ((getIntent() == null) || (getIntent().getExtras() == null))
    {
      finishWithError$5647b3fe(LiThirdPartyErrorCode.INVALID_REQUEST, "Not properly called. Required extras are missing");
      return;
    }
    paramBundle = getIntent().getExtras();
    m_scope = paramBundle.getString("com.linkedin.thirdpartysdk.SCOPE_DATA");
    m_state = paramBundle.getString("com.linkedin.thirdpartysdk.STATE_DATA");
    m_locale = paramBundle.getString("com.linkedin.thirdpartysdk.LOCALE_DATA");
    m_serverData = paramBundle.getString("com.linkedin.thirdpartysdk.DATA");
    try
    {
      m_scope = URLEncoder.encode(m_scope, "UTF-8");
      new StringBuilder("scope is ").append(m_scope);
      MessageDigest localMessageDigest;
      startLoginActivity(false);
    }
    catch (UnsupportedEncodingException paramBundle)
    {
      try
      {
        m_callerPackage = getCallingPackage();
        paramBundle = getApplicationContextgetPackageManagergetPackageInfogetCallingPackage64signatures;
        m_callerSignature = paramBundle[0].toCharsString();
        localMessageDigest = MessageDigest.getInstance("SHA");
        localMessageDigest.update(paramBundle[0].toByteArray());
        m_callerSignatureHash = Base64.encodeToString(localMessageDigest.digest(), 2);
        m_appInfoHandler = new Handler(Looper.getMainLooper())
        {
          public final void handleMessage(Message paramAnonymousMessage)
          {
            new StringBuilder("got message to update ").append(what).append(" ").append(paramAnonymousMessage.toString());
            switch (what)
            {
            default: 
              super.handleMessage(paramAnonymousMessage);
              return;
            case 1000: 
              paramAnonymousMessage = (LiThirdPartyAuthorizeResponse)obj;
              updateAppInfo(m_appName, m_permissionInfoList, m_logo);
              return;
            }
            Object localObject = (LiSSOInfo)obj;
            new StringBuilder("updating member info ").append(fullName).append("<end>");
            paramAnonymousMessage = LiThirdPartyAuthorizeActivity.this;
            ViewStub localViewStub = (ViewStub)paramAnonymousMessage.findViewById(R.id.member_info_viewstub);
            Bitmap localBitmap = LiSSOInfo.loadPicture(paramAnonymousMessage.getApplicationContext());
            if (localBitmap != null)
            {
              m_externalCallStatus.m_hasMemberPic = true;
              localViewStub.setLayoutResource(R.layout.member_logo);
              localViewStub.setVisibility(0);
              localObject = (ImageView)paramAnonymousMessage.findViewById(R.id.member_pic);
              if ((localBitmap.getHeight() > getLayoutParamsheight) || (localBitmap.getWidth() > getLayoutParamswidth)) {
                ((ImageView)localObject).setScaleType(ImageView.ScaleType.FIT_CENTER);
              }
              ((ImageView)localObject).setImageBitmap(localBitmap);
            }
            for (;;)
            {
              m_externalCallStatus.m_memberPicResolved = true;
              paramAnonymousMessage.updateLogoDisplay();
              return;
              localViewStub.setLayoutResource(R.layout.member_name);
              localViewStub.setVisibility(0);
              ((TextView)paramAnonymousMessage.findViewById(R.id.member_name)).setText(fullName);
            }
          }
        };
        m_auth = LiAuthProvider.getInstance(this);
        if (!isUserLoggedIn()) {
          break label335;
        }
        getApplicationAndScopeData();
        return;
      }
      catch (PackageManager.NameNotFoundException paramBundle)
      {
        new StringBuilder("Unable to get calling signature ").append(paramBundle.toString());
        finishWithError$5647b3fe(LiThirdPartyErrorCode.INTERNAL_ERROR, "Unable to get caller info");
        return;
      }
      catch (NoSuchAlgorithmException paramBundle)
      {
        new StringBuilder("Unable to hash signature ").append(paramBundle.toString());
        finishWithError$5647b3fe(LiThirdPartyErrorCode.INTERNAL_ERROR, "Unable to hash signature");
        return;
      }
      paramBundle = paramBundle;
      new StringBuilder("Unable to encode scope ").append(paramBundle.toString()).append(" : ").append(m_scope);
      finishWithError$5647b3fe(LiThirdPartyErrorCode.INVALID_REQUEST, "Unable to encode scope");
      return;
    }
    label335:
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return false;
  }
  
  protected void onDestroy()
  {
    if (m_appInfoHandler != null) {
      m_appInfoHandler.removeCallbacksAndMessages(null);
    }
    super.onDestroy();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  final void startLoginActivity(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("com.linkedin.android.auth.AUTHORIZE_APP_LOGIN");
    localIntent.addCategory("com.linkedin.android.auth.thirdpartylogin");
    localIntent.putExtra("com.linkedin.android.FinishAfterLogin", true);
    localIntent.putExtra("src", "sdk_sso");
    localIntent.putExtra("callerPackageName", m_callerPackage);
    localIntent.putExtra("callerSignatureHash", m_callerSignatureHash);
    if (paramBoolean) {
      localIntent.putExtra("com.linkedin.android.SDKAuthFailed", true);
    }
    try
    {
      startActivityForResult(localIntent, 135);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      finishWithError$6ef37c42("LINKEDIN_APP_NOT_FOUND", "No LI Login Activity");
    }
  }
  
  protected final void updateAppInfo(String paramString1, List<LiThirdPartyPermissionInfo> paramList, String paramString2)
  {
    Object localObject1 = (ViewStub)findViewById(R.id.third_party_activation_viewstub);
    m_authView = ((ViewStub)localObject1).inflate();
    ((ViewStub)localObject1).setVisibility(0);
    ((Button)m_authView.findViewById(R.id.authorize_ok_button)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = LiThirdPartyAuthorizeActivity.this;
        String str = m_auth.getHttpStack().getCookie("li_at", Uri.parse(m_auth.getBaseHost()).getHost());
        if (str != null) {
          str.length();
        }
        m_auth.thirdPartyAuthorize(paramAnonymousView.getApplicationContext(), m_scope, m_locale, m_callerPackage, m_callerSignatureHash, m_serverData, true, new LiThirdPartyAuthorizeActivity.4(paramAnonymousView));
      }
    });
    ((Button)m_authView.findViewById(R.id.authorize_cancel_button)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        LiThirdPartyAuthorizeActivity.access$100(LiThirdPartyAuthorizeActivity.this);
      }
    });
    ((TextView)m_authView.findViewById(R.id.authorize_privacy_textview)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        paramAnonymousView = new Intent(getApplicationContext(), LiThirdPartyViewUrlActivity.class);
        paramAnonymousView.putExtra("url", "https://www.linkedin.com/legal/pop/pop-privacy-policy");
        startActivity(paramAnonymousView);
      }
    });
    if (APPS_NEEDING_EXTRA_POLICY.contains(m_callerPackage))
    {
      localObject1 = (ViewStub)findViewById(R.id.extra_policy_viewstub);
      Object localObject2 = ((ViewStub)localObject1).inflate();
      ((ViewStub)localObject1).setLayoutResource(R.layout.extra_policy);
      ((ViewStub)localObject1).setVisibility(0);
      ((TextView)((View)localObject2).findViewById(R.id.extra_policy_textview)).setText(R.string.extra_policy);
      localObject1 = new SpannableString(getResources().getString(R.string.learn_more));
      ((SpannableString)localObject1).setSpan(new UnderlineSpan(), 0, ((SpannableString)localObject1).length(), 0);
      localObject2 = (ViewStub)findViewById(R.id.learn_more_viewstub);
      View localView = ((ViewStub)localObject2).inflate();
      ((ViewStub)localObject2).setLayoutResource(R.layout.learn_more);
      ((ViewStub)localObject2).setVisibility(0);
      localObject2 = (TextView)localView.findViewById(R.id.learn_more_textview);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          paramAnonymousView = new Intent(getApplicationContext(), LiThirdPartyViewUrlActivity.class);
          paramAnonymousView.putExtra("url", "https://www.linkedin.com/legal/mobile/sony");
          startActivity(paramAnonymousView);
        }
      });
    }
    ((TextView)findViewById(R.id.authorize_app_name_text)).setText(Html.fromHtml(getString(R.string.usage, new Object[] { paramString1 })));
    localObject1 = (ListView)findViewById(R.id.authorize_perm_list);
    ((ListView)localObject1).setDivider(null);
    ((ListView)localObject1).setAdapter(new PermissionListAdapter(getApplicationContext(), paramList));
    if ((paramString2 == null) || (paramString2.length() == 0))
    {
      updateCompanyLogo(null, paramString1);
      m_externalCallStatus.m_companyLogoResolved = true;
    }
    for (;;)
    {
      int i = getMaxPermissionSize(paramList, (TextView)findViewById(R.id.dummy_title_view));
      paramString1 = new DisplayMetrics();
      getWindowManager().getDefaultDisplay().getMetrics(paramString1);
      int j = getResources().getDimensionPixelSize(R.dimen.iconWidth);
      int k = getResources().getDimensionPixelSize(R.dimen.mainWindowPadding);
      int m = getResources().getDimensionPixelSize(R.dimen.scrollbarWidth);
      new StringBuilder("maxwidth=").append(i).append(" window width=").append(widthPixels).append(" iconwidth=").append(j).append(" paddingWidth=").append(k);
      i = (widthPixels - (i + j + k + m)) / 2;
      ((ListView)findViewById(R.id.authorize_perm_list)).setPadding(i, 0, 0, 0);
      return;
      new DownloadImageTask(paramString1).execute(new String[] { paramString2 });
    }
  }
  
  protected final void updateCompanyLogo(Bitmap paramBitmap, String paramString)
  {
    ViewStub localViewStub = (ViewStub)m_authView.findViewById(R.id.company_info_viewstub);
    if (paramBitmap != null)
    {
      m_externalCallStatus.m_hasCompanyLogo = true;
      localViewStub.setLayoutResource(R.layout.company_logo);
      localViewStub.setVisibility(0);
      ((ImageView)m_authView.findViewById(R.id.company_info_image)).setImageBitmap(paramBitmap);
    }
    for (;;)
    {
      m_externalCallStatus.m_companyLogoResolved = true;
      updateLogoDisplay();
      return;
      localViewStub.setLayoutResource(R.layout.company_name);
      localViewStub.setVisibility(0);
      ((TextView)m_authView.findViewById(R.id.company_info_name)).setText(paramString);
    }
  }
  
  final void updateLogoDisplay()
  {
    Object localObject = m_externalCallStatus;
    if ((m_memberPicResolved) && (m_companyLogoResolved)) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    localObject = m_authView.findViewById(R.id.centerSpace);
    if ((!m_externalCallStatus.m_hasCompanyLogo) && (!m_externalCallStatus.m_hasMemberPic))
    {
      ((View)localObject).setVisibility(0);
      if ((m_externalCallStatus.m_hasCompanyLogo) && (m_externalCallStatus.m_hasMemberPic)) {
        break label162;
      }
    }
    label162:
    for (i = getResources().getDimensionPixelSize(R.dimen.noImageInnerMargin);; i = getResources().getDimensionPixelSize(R.dimen.withImageInnerMargin))
    {
      localObject = findViewById(R.id.member_pic_container);
      View localView = findViewById(R.id.company_info_container);
      if (localObject != null) {
        ((View)localObject).setPadding(0, 0, i, 0);
      }
      if (localView != null) {
        localView.setPadding(i, 0, 0, 0);
      }
      ((ImageView)findViewById(R.id.transition_view)).setVisibility(8);
      return;
      ((View)localObject).setVisibility(4);
      break;
    }
  }
  
  private final class DownloadImageTask
    extends AsyncTask<String, Void, Bitmap>
  {
    String companyName;
    
    public DownloadImageTask(String paramString)
    {
      companyName = paramString;
    }
  }
  
  private final class ExternalCallStatus
  {
    public boolean m_companyLogoResolved = false;
    public boolean m_hasCompanyLogo = false;
    public boolean m_hasMemberPic = false;
    public boolean m_memberPicResolved = false;
    
    private ExternalCallStatus() {}
  }
  
  private final class PermissionListAdapter
    extends ArrayAdapter<LiThirdPartyPermissionInfo>
  {
    public PermissionListAdapter(List<LiThirdPartyPermissionInfo> paramList) {}
    
    public final boolean areAllItemsEnabled()
    {
      return false;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = getLayoutInflater().inflate(R.layout.permission_list_item, null);
      }
      paramView = (LiThirdPartyPermissionInfo)getItem(paramInt);
      ((ImageView)paramViewGroup.findViewById(R.id.perm_list_pic)).setImageResource(LiThirdPartyPermissionInfo.getPermissionImageResource(m_name));
      ((TextView)paramViewGroup.findViewById(R.id.perm_list_item_title_text)).setText(m_title);
      return paramViewGroup;
    }
    
    public final boolean isEnabled(int paramInt)
    {
      return false;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.liauthlib.thirdparty.LiThirdPartyAuthorizeActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */