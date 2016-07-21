package com.linkedin.android.growth.abi;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.growth.utils.OwlTrackingUtils;
import com.linkedin.android.infra.app.PermissionRequester;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.shared.AsyncTaskCallback;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.TimeWrapper;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.RawContact;
import com.linkedin.data.lite.VoidRecord;
import com.linkedin.gen.avro2pegasus.events.abook.AbookImportInvitationDiscardReason;
import java.util.List;
import javax.inject.Inject;

public class AbiAutoSyncManager
  implements AsyncTaskCallback<List<RawContact>>
{
  private static final String TAG = AbiAutoSyncManager.class.getSimpleName();
  @Inject
  AbiContactsReader abiContactsReader;
  protected final long abiTryAutoSyncThresholdMilliseconds;
  protected Context context;
  @Inject
  FlagshipDataManager dataManager;
  @Inject
  FlagshipSharedPreferences flagshipSharedPreferences;
  @Inject
  LixManager lixManager;
  @Inject
  MemberUtil memberUtil;
  @Inject
  TimeWrapper timeWrapper;
  @Inject
  Tracker tracker;
  
  @Inject
  public AbiAutoSyncManager(FlagshipSharedPreferences paramFlagshipSharedPreferences, TimeWrapper paramTimeWrapper, FlagshipDataManager paramFlagshipDataManager, MemberUtil paramMemberUtil, Tracker paramTracker, LixManager paramLixManager)
  {
    flagshipSharedPreferences = paramFlagshipSharedPreferences;
    timeWrapper = paramTimeWrapper;
    dataManager = paramFlagshipDataManager;
    memberUtil = paramMemberUtil;
    tracker = paramTracker;
    lixManager = paramLixManager;
    abiTryAutoSyncThresholdMilliseconds = 43200000L;
  }
  
  public final void doAbiAutoSync(Context paramContext)
  {
    context = paramContext;
    boolean bool = PermissionRequester.hasPermission(paramContext, "android.permission.READ_CONTACTS");
    long l;
    if ((flagshipSharedPreferences.isAbiAutoSync(memberUtil.getProfileId())) && (bool))
    {
      l = flagshipSharedPreferences.getPreferences().getLong("last_check_for_contacts_changed_timestamp", 0L);
      if (System.currentTimeMillis() - l <= abiTryAutoSyncThresholdMilliseconds) {
        break label151;
      }
    }
    label151:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramContext = new AbiContactsReadTask(abiContactsReader);
        asyncTaskCallback = this;
        paramContext.execute(new Void[0]);
        paramContext = flagshipSharedPreferences;
        l = System.currentTimeMillis();
        paramContext.getPreferences().edit().putLong("last_check_for_contacts_changed_timestamp", l).apply();
      }
      if (!bool) {
        flagshipSharedPreferences.setAbiAutoSync(false, memberUtil.getProfileId());
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiAutoSyncManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */