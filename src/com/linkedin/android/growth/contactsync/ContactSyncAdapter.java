package com.linkedin.android.growth.contactsync;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SyncResult;
import android.content.SyncStats;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import android.text.TextUtils;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.app.FlagshipApplication;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.network.ImageRequest;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.performance.CrashReporter;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.logger.Log;
import com.linkedin.android.networking.AbstractNetworkClient;
import com.linkedin.android.networking.interfaces.RawResponse;
import com.linkedin.android.networking.interfaces.RequestFactory;
import com.linkedin.android.networking.interfaces.ResponseListener;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.ContactSyncConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ContactSyncAdapter
  extends AbstractThreadedSyncAdapter
{
  private static final ExecutorService PERSISTENCE_EXECUTOR = Executors.newSingleThreadExecutor();
  private static final String TAG = ContactSyncAdapter.class.getSimpleName();
  private final ApplicationComponent appComponent;
  private final ContentResolver contentResolver;
  private final List<ContactSyncConnection> pendingPhotoDownloadConnections;
  private volatile boolean shouldCancelSync;
  
  public ContactSyncAdapter(Context paramContext)
  {
    super(paramContext, true, false);
    appComponent = ((FlagshipApplication)paramContext.getApplicationContext()).getAppComponent();
    contentResolver = paramContext.getApplicationContext().getContentResolver();
    pendingPhotoDownloadConnections = new ArrayList();
  }
  
  private static Uri addCallerIsSyncAdapterParameter$7abf6c27(Uri paramUri)
  {
    return paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build();
  }
  
  public static void addLinkedInAccount(final Context paramContext, final LixManager paramLixManager, Auth paramAuth)
  {
    paramContext = paramContext.getApplicationContext();
    PERSISTENCE_EXECUTOR.submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          if (!val$auth.isAuthenticated())
          {
            Log.v(ContactSyncAdapter.TAG, "Not adding account because app is not authenticated");
            return;
          }
          Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(paramContext);
          if ((arrayOfAccount != null) && (arrayOfAccount.length > 0))
          {
            Log.v(ContactSyncAdapter.TAG, "Not adding account because it already exists");
            return;
          }
        }
        catch (Exception localException)
        {
          Log.e(ContactSyncAdapter.TAG, "Exception adding LinkedIn account", localException);
          CrashReporter.reportNonFatal(new Throwable("Exception adding LinkedIn account", localException));
          return;
        }
        Log.v(ContactSyncAdapter.TAG, "Adding new LinkedIn account");
        Account localAccount = new Account(paramContext.getResources().getString(2131233769), paramContext.getPackageName());
        if (!AccountManager.get(paramContext).addAccountExplicitly(localAccount, null, null))
        {
          Log.e(ContactSyncAdapter.TAG, "Failed to add LinkedIn account. AccountManager returned false");
          return;
        }
        ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", false);
        ContentResolver.setIsSyncable(localAccount, "com.android.contacts", 1);
        int i = ContactSyncAdapter.getSyncFrequency(paramLixManager);
        if (i > 0)
        {
          Log.v(ContactSyncAdapter.TAG, "Setup periodic sync once every " + i + " days");
          ContentResolver.addPeriodicSync(localAccount, "com.android.contacts", new Bundle(), TimeUnit.DAYS.toSeconds(i));
        }
        ContactSyncAdapter.access$900(localAccount);
      }
    });
  }
  
  public static void adjustSyncFrequency(final Context paramContext, final FlagshipSharedPreferences paramFlagshipSharedPreferences, final LixManager paramLixManager, final Auth paramAuth)
  {
    Context localContext = paramContext.getApplicationContext();
    PERSISTENCE_EXECUTOR.submit(new Runnable()
    {
      public final void run()
      {
        int i = 0;
        for (;;)
        {
          try
          {
            Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
            if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
            {
              Log.v(ContactSyncAdapter.TAG, "No LinkedIn accounts found. Perhaps adding accounts failed? Try adding again");
              ContactSyncAdapter.addLinkedInAccount(paramContext, paramLixManager, paramAuth);
              return;
            }
            Bundle localBundle = new Bundle();
            int j = arrayOfAccount.length;
            if (i < j)
            {
              Account localAccount = arrayOfAccount[i];
              ContentResolver.setSyncAutomatically(localAccount, "com.android.contacts", false);
              int k = ContactSyncAdapter.getSyncFrequency(paramLixManager);
              if (k > 0)
              {
                Log.v(ContactSyncAdapter.TAG, "Setup periodic sync once every " + k + " days");
                ContentResolver.addPeriodicSync(localAccount, "com.android.contacts", new Bundle(), TimeUnit.DAYS.toSeconds(k));
                long l = paramFlagshipSharedPreferences.getPreferences().getLong("lastContactSyncTimestamp", 0L);
                if (System.currentTimeMillis() - l >= TimeUnit.DAYS.toMillis(k)) {
                  ContactSyncAdapter.access$900(localAccount);
                }
              }
              else
              {
                Log.v(ContactSyncAdapter.TAG, "Removed periodic contact sync");
                ContentResolver.removePeriodicSync(localAccount, "com.android.contacts", localBundle);
              }
            }
          }
          catch (Exception localException)
          {
            Log.e(ContactSyncAdapter.TAG, "Exception when requesting account sync", localException);
            CrashReporter.reportNonFatal(new Throwable("Exception when requesting account sync", localException));
          }
          return;
          i += 1;
        }
      }
    });
  }
  
  private void commitOperationList(Account paramAccount, ArrayList<ContentProviderOperation> paramArrayList, boolean paramBoolean)
  {
    if (!appComponent.auth().isAuthenticated()) {
      Log.e(TAG, "Not committing operations list since app is not authenticated!");
    }
    while ((!paramBoolean) && (paramArrayList.size() < 25)) {
      return;
    }
    try
    {
      contentResolver.applyBatch("com.android.contacts", paramArrayList);
      Log.v(TAG, "Batch committed successfully. Batch size: " + paramArrayList.size());
      if ("enabled".equals(appComponent.lixManager().getTreatment(Lix.MYNETWORK_CONTACT_PHOTO_DOWNLOAD)))
      {
        Log.v(TAG, "Kicking off connection photo download for " + pendingPhotoDownloadConnections.size() + " contacts");
        Iterator localIterator = pendingPhotoDownloadConnections.iterator();
        while (localIterator.hasNext())
        {
          Object localObject1 = (ContactSyncConnection)localIterator.next();
          Object localObject2 = appComponent.mediaCenter().load(miniProfile.picture).getLoadUrl(null);
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new ImageDownloader(paramAccount, miniProfile.entityUrn.getId(), (String)localObject2);
            localObject2 = this$0.appComponent.networkClient();
            RequestFactory localRequestFactory = ((AbstractNetworkClient)localObject2).getRequestFactory();
            String str = url;
            this$0.appComponent.appContext();
            ((AbstractNetworkClient)localObject2).add(localRequestFactory.getAbsoluteRequest$3868be9b(0, str, (ResponseListener)localObject1, null));
            continue;
            paramArrayList.clear();
          }
        }
      }
    }
    catch (Exception paramAccount)
    {
      Log.e(TAG, "Could not commit operationList!", paramAccount);
      CrashReporter.reportNonFatal(new Throwable("Could not commit operationList!", paramAccount));
    }
    for (;;)
    {
      return;
      pendingPhotoDownloadConnections.clear();
    }
  }
  
  private void downloadContacts(final int paramInt1, final Account paramAccount, final ArrayList<ContentProviderOperation> paramArrayList, final String paramString1, final int paramInt2, final String paramString2, final int paramInt3)
  {
    if (shouldCancelSync)
    {
      Log.v(TAG, "Sync cancelled manually by user. Aborting sync!");
      return;
    }
    int i = appComponent.flagshipSharedPreferences().getContactAddressBookSyncType();
    if (i != paramInt2)
    {
      Log.v(TAG, "Sync type changed from " + paramInt2 + " to " + i + ". Aborting sync!");
      return;
    }
    String str = Routes.CONTACT_SYNC_CONNECTIONS.buildPagedRouteUponRoot(paramInt1, paramInt3).toString();
    Log.v(TAG, "Downloading contacts from URL: " + str);
    appComponent.dataManager().submit(Request.get().url(str).builder(CollectionTemplate.of(ContactSyncConnection.BUILDER)).filter(DataManager.DataStoreFilter.NETWORK_ONLY).timeout(60000).listener(new RecordTemplateListener()
    {
      public final void onResponse(final DataStoreResponse<CollectionTemplate<ContactSyncConnection, CollectionMetadata>> paramAnonymousDataStoreResponse)
      {
        if (error != null)
        {
          Log.e(ContactSyncAdapter.TAG, "Error fetching response", error);
          return;
        }
        int i = appComponent.flagshipSharedPreferences().getContactAddressBookSyncType();
        if (i != paramInt2)
        {
          Log.v(ContactSyncAdapter.TAG, "Sync type changed from " + paramInt2 + " to " + i + ". Aborting sync!");
          return;
        }
        ContactSyncAdapter.PERSISTENCE_EXECUTOR.submit(new Runnable()
        {
          public final void run()
          {
            ContactSyncAdapter.access$1000(ContactSyncAdapter.this, val$startIndex, (CollectionTemplate)paramAnonymousDataStoreResponsemodel, val$account, val$operationList, val$snapshotValue, val$syncType, val$meProfileId, val$batchSize);
          }
        });
      }
    }));
  }
  
  public static Account[] getAllLinkedInAccounts(Context paramContext)
  {
    try
    {
      paramContext = AccountManager.get(paramContext).getAccountsByType(paramContext.getPackageName());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Log.e(TAG, "Exception when retrieving account list", paramContext);
      CrashReporter.reportNonFatal(new Throwable("Exception when retrieving account list", paramContext));
    }
    return null;
  }
  
  private static int getBatchSize(LixManager paramLixManager)
  {
    paramLixManager = paramLixManager.getTreatment(Lix.MYNETWORK_CONTACT_SYNC_BATCH_SIZE);
    if (!paramLixManager.startsWith("COUNT_")) {
      return 100;
    }
    paramLixManager = paramLixManager.substring(6);
    try
    {
      int i = Integer.parseInt(paramLixManager);
      return i;
    }
    catch (NumberFormatException paramLixManager)
    {
      Log.e(TAG, "Error in parsing value for lix " + Lix.MYNETWORK_CONTACT_SYNC_BATCH_SIZE + ". Falling back to default value.");
    }
    return 100;
  }
  
  private static int getSyncFrequency(LixManager paramLixManager)
  {
    paramLixManager = paramLixManager.getTreatment(Lix.MYNETWORK_CONTACT_SYNC_FREQ);
    if (!paramLixManager.startsWith("DAYS_")) {
      return 14;
    }
    paramLixManager = paramLixManager.substring(5);
    try
    {
      int i = Integer.parseInt(paramLixManager);
      return i;
    }
    catch (NumberFormatException paramLixManager)
    {
      Log.e(TAG, "Error in parsing value for lix " + Lix.MYNETWORK_CONTACT_SYNC_FREQ + ". Falling back to default value.");
    }
    return 14;
  }
  
  private void insertContact(Account paramAccount, ContactSyncConnection paramContactSyncConnection, ArrayList<ContentProviderOperation> paramArrayList, String paramString)
  {
    ContentProviderOperation.Builder localBuilder = ContentProviderOperation.newInsert(addCallerIsSyncAdapterParameter$7abf6c27(ContactsContract.RawContacts.CONTENT_URI));
    localBuilder.withValue("account_name", name);
    localBuilder.withValue("account_type", type);
    localBuilder.withValue("raw_contact_is_read_only", Integer.valueOf(1));
    localBuilder.withValue("sync1", appComponent.memberUtil().getProfileId());
    localBuilder.withValue("sync2", miniProfile.entityUrn.getId());
    localBuilder.withValue("sync3", paramString);
    paramArrayList.add(localBuilder.build());
    int i = paramArrayList.size() - 1;
    paramAccount = ContentProviderOperation.newInsert(addCallerIsSyncAdapterParameter$7abf6c27(ContactsContract.Data.CONTENT_URI));
    paramAccount.withValueBackReference("raw_contact_id", i);
    paramAccount.withValue("mimetype", "vnd.android.cursor.item/name");
    if (!TextUtils.isEmpty(miniProfile.firstName)) {
      paramAccount.withValue("data2", miniProfile.firstName);
    }
    if (!TextUtils.isEmpty(miniProfile.lastName)) {
      paramAccount.withValue("data3", miniProfile.lastName);
    }
    paramAccount.withValue("data1", appComponent.i18NManager().getString(2131233236, new Object[] { I18NManager.getName(miniProfile) }));
    paramArrayList.add(paramAccount.build());
    if (phoneNumbers != null)
    {
      paramAccount = phoneNumbers.iterator();
      while (paramAccount.hasNext())
      {
        paramString = (PhoneNumber)paramAccount.next();
        localBuilder = ContentProviderOperation.newInsert(addCallerIsSyncAdapterParameter$7abf6c27(ContactsContract.Data.CONTENT_URI));
        localBuilder.withValueBackReference("raw_contact_id", i);
        localBuilder.withValue("mimetype", "vnd.android.cursor.item/phone_v2");
        localBuilder.withValue("data1", number);
        localBuilder.withValue("data2", Integer.valueOf(7));
        localBuilder.withYieldAllowed(true);
        paramArrayList.add(localBuilder.build());
      }
    }
    Log.v(TAG, "No phone numbers");
    if (hasEmailAddress)
    {
      paramAccount = ContentProviderOperation.newInsert(addCallerIsSyncAdapterParameter$7abf6c27(ContactsContract.Data.CONTENT_URI));
      paramAccount.withValueBackReference("raw_contact_id", i);
      paramAccount.withValue("mimetype", "vnd.android.cursor.item/email_v2");
      paramAccount.withValue("data1", emailAddress);
      paramAccount.withValue("data2", Integer.valueOf(3));
      paramArrayList.add(paramAccount.build());
      paramString = ContentProviderOperation.newInsert(addCallerIsSyncAdapterParameter$7abf6c27(ContactsContract.Data.CONTENT_URI));
      paramString.withValueBackReference("raw_contact_id", i);
      paramString.withValue("mimetype", "vnd.android.cursor.item/vnd.com.linkedin.android.profile");
      paramString.withValue("data1", miniProfile.entityUrn.getId());
      paramString.withValue("data2", getContext().getResources().getString(2131231390));
      if (!miniProfile.hasOccupation) {
        break label586;
      }
    }
    label586:
    for (paramAccount = miniProfile.occupation;; paramAccount = "")
    {
      paramString.withValue("data3", paramAccount);
      paramString.withYieldAllowed(true);
      paramArrayList.add(paramString.build());
      return;
      Log.v(TAG, "No email address");
      break;
    }
  }
  
  public static void removeAllLinkedInAccounts(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    PERSISTENCE_EXECUTOR.submit(new Runnable()
    {
      public final void run()
      {
        for (;;)
        {
          int i;
          try
          {
            Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
            if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
            {
              Log.v(ContactSyncAdapter.TAG, "No LinkedIn accounts found to remove");
              return;
            }
            int j = arrayOfAccount.length;
            i = 0;
            if (i < j)
            {
              Account localAccount = arrayOfAccount[i];
              Log.v(ContactSyncAdapter.TAG, "Removing linkedin account");
              Context localContext = val$applicationContext;
              if (Build.VERSION.SDK_INT >= 22) {
                AccountManager.get(localContext).removeAccount(localAccount, null, null, null);
              } else {
                AccountManager.get(localContext).removeAccount(localAccount, null, null);
              }
            }
          }
          catch (Exception localException)
          {
            Log.e(ContactSyncAdapter.TAG, "Exception when removing accounts", localException);
            CrashReporter.reportNonFatal(new Throwable("Exception when removing accounts", localException));
          }
          return;
          i += 1;
        }
      }
    });
  }
  
  public static void requestAccountSync(Context paramContext)
  {
    Log.v(TAG, "Requesting manual account sync");
    paramContext = paramContext.getApplicationContext();
    PERSISTENCE_EXECUTOR.submit(new Runnable()
    {
      public final void run()
      {
        try
        {
          Account[] arrayOfAccount = ContactSyncAdapter.getAllLinkedInAccounts(val$applicationContext);
          if ((arrayOfAccount == null) || (arrayOfAccount.length == 0))
          {
            Log.v(ContactSyncAdapter.TAG, "No LinkedIn accounts found to sync");
            return;
          }
          int j = arrayOfAccount.length;
          int i = 0;
          while (i < j)
          {
            ContactSyncAdapter.access$900(arrayOfAccount[i]);
            i += 1;
          }
          return;
        }
        catch (Exception localException)
        {
          Log.e(ContactSyncAdapter.TAG, "Exception when requesting account sync", localException);
          CrashReporter.reportNonFatal(new Throwable("Exception when requesting account sync", localException));
        }
      }
    });
  }
  
  public void onPerformSync(final Account paramAccount, Bundle paramBundle, final String paramString, ContentProviderClient paramContentProviderClient, final SyncResult paramSyncResult)
  {
    Log.v(TAG, "Performing contact sync " + paramBundle);
    try
    {
      appComponent.flagshipSharedPreferences().getPreferences().edit().putLong("lastContactSyncTimestamp", System.currentTimeMillis()).apply();
      final int i = appComponent.flagshipSharedPreferences().getContactAddressBookSyncType();
      boolean bool1 = PermissionRequester.hasPermission(getContext(), "android.permission.READ_CONTACTS");
      boolean bool2 = PermissionRequester.hasPermission(getContext(), "android.permission.WRITE_CONTACTS");
      if ((!bool1) || (!bool2))
      {
        Log.v(TAG, "Aborting sync due to lack of read/write contact permissions");
        return;
      }
      PERSISTENCE_EXECUTOR.submit(new Runnable()
      {
        public final void run()
        {
          for (;;)
          {
            try
            {
              if (shouldCancelSync)
              {
                Log.v(ContactSyncAdapter.TAG, "Sync cancelled manually by user. Aborting sync!");
                return;
              }
              if (ContentResolver.getIsSyncable(paramAccount, paramString) > 0)
              {
                i = 1;
                if ((i != 0) && (ContactSyncAdapter.getSyncFrequency(appComponent.lixManager()) > 0)) {
                  break;
                }
                SyncStats localSyncStats = paramSyncResultstats;
                numSkippedEntries += 1L;
                Log.v(ContactSyncAdapter.TAG, "Contact sync disabled. Doing nothing");
                return;
              }
            }
            catch (Exception localException)
            {
              Log.e(ContactSyncAdapter.TAG, "Exception when syncing contacts", localException);
              CrashReporter.reportNonFatal(new Throwable("Exception when syncing contacts", localException));
              return;
            }
            int i = 0;
          }
          String str = appComponent.memberUtil().getProfileId();
          if ((!appComponent.auth().isAuthenticated()) || (str == null) || (i == 2))
          {
            ContactSyncAdapter.access$400(getContext(), paramAccount);
            Log.v(ContactSyncAdapter.TAG, "Contact sync finished. Sync type for this sync was: " + i);
            return;
          }
          long l = System.currentTimeMillis();
          ContactSyncAdapter.access$600(contentResolver, paramAccount, i);
          ContactSyncAdapter.access$800$140481d3(ContactSyncAdapter.this, paramAccount, new ArrayList(), String.valueOf(l), i, str, ContactSyncAdapter.getBatchSize(appComponent.lixManager()));
        }
      });
      return;
    }
    catch (Exception paramAccount)
    {
      Log.e(TAG, "Exception when syncing contacts", paramAccount);
      CrashReporter.reportNonFatal(new Throwable("Exception when syncing contacts", paramAccount));
    }
  }
  
  public void onSyncCanceled()
  {
    shouldCancelSync = true;
    super.onSyncCanceled();
  }
  
  public void onSyncCanceled(Thread paramThread)
  {
    shouldCancelSync = true;
    super.onSyncCanceled(paramThread);
  }
  
  private final class ImageDownloader
    implements ResponseListener<byte[], Object>
  {
    private final Account account;
    private final String profileId;
    final String url;
    
    public ImageDownloader(Account paramAccount, String paramString1, String paramString2)
    {
      account = paramAccount;
      profileId = paramString1;
      url = paramString2;
    }
    
    public final void onFailure(int paramInt, Object paramObject, Map<String, List<String>> paramMap, IOException paramIOException)
    {
      Log.v(ContactSyncAdapter.TAG, "Failed to download photo for " + profileId, paramIOException);
    }
    
    public final Object parseErrorResponse(RawResponse paramRawResponse)
      throws IOException
    {
      return null;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.contactsync.ContactSyncAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */