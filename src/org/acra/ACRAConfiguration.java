package org.acra;

import java.lang.annotation.Annotation;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.acra.annotation.ReportsCrashes;
import org.acra.log.ACRALog;
import org.acra.sender.HttpSender.Method;
import org.acra.sender.HttpSender.Type;

public final class ACRAConfiguration
  implements ReportsCrashes
{
  private String[] mAdditionalDropboxTags = null;
  private String[] mAdditionalSharedPreferences = null;
  private String mApplicationLogFile = null;
  private Integer mApplicationLogFileLines = null;
  private Class mBuildConfigClass;
  private Integer mConnectionTimeout = null;
  private ReportField[] mCustomReportContent = null;
  private Boolean mDeleteOldUnsentReportsOnApplicationStart = null;
  private Boolean mDeleteUnapprovedReportsOnApplicationStart = null;
  private Integer mDropboxCollectionMinutes = null;
  private String[] mExcludeMatchingSettingsKeys = null;
  private String[] mExcludeMatchingSharedPreferencesKeys = null;
  private Boolean mForceCloseDialogAfterToast = null;
  private String mFormUri = null;
  private String mFormUriBasicAuthLogin = null;
  private String mFormUriBasicAuthPassword = null;
  public Map<String, String> mHttpHeaders;
  private HttpSender.Method mHttpMethod = null;
  private Boolean mIncludeDropboxSystemTags = null;
  public KeyStore mKeyStore;
  private String[] mLogcatArguments = null;
  private Boolean mLogcatFilterByPid = null;
  private String mMailTo = null;
  private ReportingInteractionMode mMode = null;
  private Class<? extends BaseCrashReportDialog> mReportDialogClass = null;
  private HttpSender.Type mReportType = null;
  private ReportsCrashes mReportsCrashes = null;
  private Integer mResDialogCommentPrompt = null;
  private Integer mResDialogEmailPrompt = null;
  private Integer mResDialogIcon = null;
  private Integer mResDialogNegativeButtonText = null;
  private Integer mResDialogOkToast = null;
  private Integer mResDialogPositiveButtonText = null;
  private Integer mResDialogText = null;
  private Integer mResDialogTitle = null;
  private Integer mResNotifIcon = null;
  private Integer mResNotifText = null;
  private Integer mResNotifTickerText = null;
  private Integer mResNotifTitle = null;
  private Integer mResToastText = null;
  private Boolean mSendReportsAtShutdown = null;
  private Boolean mSendReportsInDevMode = null;
  private Integer mSharedPreferenceMode = null;
  private String mSharedPreferenceName = null;
  private Integer mSocketTimeout = null;
  
  public ACRAConfiguration()
  {
    this(null);
  }
  
  public ACRAConfiguration(ReportsCrashes paramReportsCrashes)
  {
    mReportsCrashes = paramReportsCrashes;
  }
  
  public static boolean isNull(String paramString)
  {
    return (paramString == null) || ("ACRA-NULL-STRING".equals(paramString));
  }
  
  public final String[] additionalDropBoxTags()
  {
    if (mAdditionalDropboxTags != null) {
      return mAdditionalDropboxTags;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.additionalDropBoxTags();
    }
    return new String[0];
  }
  
  public final String[] additionalSharedPreferences()
  {
    if (mAdditionalSharedPreferences != null) {
      return mAdditionalSharedPreferences;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.additionalSharedPreferences();
    }
    return new String[0];
  }
  
  public final Class<? extends Annotation> annotationType()
  {
    return mReportsCrashes.annotationType();
  }
  
  public final String applicationLogFile()
  {
    if (mApplicationLogFile != null) {
      return mApplicationLogFile;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.applicationLogFile();
    }
    return "";
  }
  
  public final int applicationLogFileLines()
  {
    if (mApplicationLogFileLines != null) {
      return mApplicationLogFileLines.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.applicationLogFileLines();
    }
    return 100;
  }
  
  public final Class buildConfigClass()
  {
    if (mBuildConfigClass != null) {
      return mBuildConfigClass;
    }
    if ((mReportsCrashes != null) && (mReportsCrashes.buildConfigClass() != null)) {
      return mReportsCrashes.buildConfigClass();
    }
    return null;
  }
  
  public final int connectionTimeout()
  {
    if (mConnectionTimeout != null) {
      return mConnectionTimeout.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.connectionTimeout();
    }
    return 5000;
  }
  
  public final ReportField[] customReportContent()
  {
    if (mCustomReportContent != null) {
      return mCustomReportContent;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.customReportContent();
    }
    return new ReportField[0];
  }
  
  public final boolean deleteOldUnsentReportsOnApplicationStart()
  {
    if (mDeleteOldUnsentReportsOnApplicationStart != null) {
      return mDeleteOldUnsentReportsOnApplicationStart.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.deleteOldUnsentReportsOnApplicationStart();
    }
    return true;
  }
  
  public final boolean deleteUnapprovedReportsOnApplicationStart()
  {
    if (mDeleteUnapprovedReportsOnApplicationStart != null) {
      return mDeleteUnapprovedReportsOnApplicationStart.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.deleteUnapprovedReportsOnApplicationStart();
    }
    return true;
  }
  
  public final int dropboxCollectionMinutes()
  {
    if (mDropboxCollectionMinutes != null) {
      return mDropboxCollectionMinutes.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.dropboxCollectionMinutes();
    }
    return 5;
  }
  
  public final String[] excludeMatchingSettingsKeys()
  {
    if (mExcludeMatchingSettingsKeys != null) {
      return mExcludeMatchingSettingsKeys;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.excludeMatchingSettingsKeys();
    }
    return new String[0];
  }
  
  public final String[] excludeMatchingSharedPreferencesKeys()
  {
    if (mExcludeMatchingSharedPreferencesKeys != null) {
      return mExcludeMatchingSharedPreferencesKeys;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.excludeMatchingSharedPreferencesKeys();
    }
    return new String[0];
  }
  
  public final boolean forceCloseDialogAfterToast()
  {
    if (mForceCloseDialogAfterToast != null) {
      return mForceCloseDialogAfterToast.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.forceCloseDialogAfterToast();
    }
    return false;
  }
  
  public final String formUri()
  {
    if (mFormUri != null) {
      return mFormUri;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.formUri();
    }
    return "";
  }
  
  public final String formUriBasicAuthLogin()
  {
    if (mFormUriBasicAuthLogin != null) {
      return mFormUriBasicAuthLogin;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.formUriBasicAuthLogin();
    }
    return "ACRA-NULL-STRING";
  }
  
  public final String formUriBasicAuthPassword()
  {
    if (mFormUriBasicAuthPassword != null) {
      return mFormUriBasicAuthPassword;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.formUriBasicAuthPassword();
    }
    return "ACRA-NULL-STRING";
  }
  
  public final List<ReportField> getReportFields()
  {
    ReportField[] arrayOfReportField = customReportContent();
    if (arrayOfReportField.length != 0) {
      ACRA.log.d(ACRA.LOG_TAG, "Using custom Report Fields");
    }
    for (;;)
    {
      return Arrays.asList(arrayOfReportField);
      if ((mailTo() == null) || ("".equals(mailTo())))
      {
        ACRA.log.d(ACRA.LOG_TAG, "Using default Report Fields");
        arrayOfReportField = ACRAConstants.DEFAULT_REPORT_FIELDS;
      }
      else
      {
        ACRA.log.d(ACRA.LOG_TAG, "Using default Mail Report Fields");
        arrayOfReportField = ACRAConstants.DEFAULT_MAIL_REPORT_FIELDS;
      }
    }
  }
  
  public final HttpSender.Method httpMethod()
  {
    if (mHttpMethod != null) {
      return mHttpMethod;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.httpMethod();
    }
    return HttpSender.Method.POST;
  }
  
  public final boolean includeDropBoxSystemTags()
  {
    if (mIncludeDropboxSystemTags != null) {
      return mIncludeDropboxSystemTags.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.includeDropBoxSystemTags();
    }
    return false;
  }
  
  public final String[] logcatArguments()
  {
    if (mLogcatArguments != null) {
      return mLogcatArguments;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.logcatArguments();
    }
    return new String[] { "-t", Integer.toString(100), "-v", "time" };
  }
  
  public final boolean logcatFilterByPid()
  {
    if (mLogcatFilterByPid != null) {
      return mLogcatFilterByPid.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.logcatFilterByPid();
    }
    return false;
  }
  
  public final String mailTo()
  {
    if (mMailTo != null) {
      return mMailTo;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.mailTo();
    }
    return "";
  }
  
  public final ReportingInteractionMode mode()
  {
    if (mMode != null) {
      return mMode;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.mode();
    }
    return ReportingInteractionMode.SILENT;
  }
  
  public final Class<? extends BaseCrashReportDialog> reportDialogClass()
  {
    if (mReportDialogClass != null) {
      return mReportDialogClass;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.reportDialogClass();
    }
    return CrashReportDialog.class;
  }
  
  public final HttpSender.Type reportType()
  {
    if (mReportType != null) {
      return mReportType;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.reportType();
    }
    return HttpSender.Type.FORM;
  }
  
  public final int resDialogCommentPrompt()
  {
    if (mResDialogCommentPrompt != null) {
      return mResDialogCommentPrompt.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogCommentPrompt();
    }
    return 0;
  }
  
  public final int resDialogEmailPrompt()
  {
    if (mResDialogEmailPrompt != null) {
      return mResDialogEmailPrompt.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogEmailPrompt();
    }
    return 0;
  }
  
  public final int resDialogIcon()
  {
    if (mResDialogIcon != null) {
      return mResDialogIcon.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogIcon();
    }
    return 17301543;
  }
  
  public final int resDialogNegativeButtonText()
  {
    if (mResDialogNegativeButtonText != null) {
      return mResDialogNegativeButtonText.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogNegativeButtonText();
    }
    return 0;
  }
  
  public final int resDialogOkToast()
  {
    if (mResDialogOkToast != null) {
      return mResDialogOkToast.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogOkToast();
    }
    return 0;
  }
  
  public final int resDialogPositiveButtonText()
  {
    if (mResDialogPositiveButtonText != null) {
      return mResDialogPositiveButtonText.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogPositiveButtonText();
    }
    return 0;
  }
  
  public final int resDialogText()
  {
    if (mResDialogText != null) {
      return mResDialogText.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogText();
    }
    return 0;
  }
  
  public final int resDialogTitle()
  {
    if (mResDialogTitle != null) {
      return mResDialogTitle.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resDialogTitle();
    }
    return 0;
  }
  
  public final int resNotifIcon()
  {
    if (mResNotifIcon != null) {
      return mResNotifIcon.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resNotifIcon();
    }
    return 17301624;
  }
  
  public final int resNotifText()
  {
    if (mResNotifText != null) {
      return mResNotifText.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resNotifText();
    }
    return 0;
  }
  
  public final int resNotifTickerText()
  {
    if (mResNotifTickerText != null) {
      return mResNotifTickerText.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resNotifTickerText();
    }
    return 0;
  }
  
  public final int resNotifTitle()
  {
    if (mResNotifTitle != null) {
      return mResNotifTitle.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resNotifTitle();
    }
    return 0;
  }
  
  public final int resToastText()
  {
    if (mResToastText != null) {
      return mResToastText.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.resToastText();
    }
    return 0;
  }
  
  public final boolean sendReportsAtShutdown()
  {
    if (mSendReportsAtShutdown != null) {
      return mSendReportsAtShutdown.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.sendReportsAtShutdown();
    }
    return true;
  }
  
  public final boolean sendReportsInDevMode()
  {
    if (mSendReportsInDevMode != null) {
      return mSendReportsInDevMode.booleanValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.sendReportsInDevMode();
    }
    return true;
  }
  
  public final int sharedPreferencesMode()
  {
    if (mSharedPreferenceMode != null) {
      return mSharedPreferenceMode.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.sharedPreferencesMode();
    }
    return 0;
  }
  
  public final String sharedPreferencesName()
  {
    if (mSharedPreferenceName != null) {
      return mSharedPreferenceName;
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.sharedPreferencesName();
    }
    return "";
  }
  
  public final int socketTimeout()
  {
    if (mSocketTimeout != null) {
      return mSocketTimeout.intValue();
    }
    if (mReportsCrashes != null) {
      return mReportsCrashes.socketTimeout();
    }
    return 8000;
  }
}

/* Location:
 * Qualified Name:     org.acra.ACRAConfiguration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */