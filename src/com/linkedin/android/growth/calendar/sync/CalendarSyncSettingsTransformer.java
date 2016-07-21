package com.linkedin.android.growth.calendar.sync;

import com.linkedin.android.growth.calendar.CalendarAccountViewModel;
import com.linkedin.android.growth.calendar.CalendarEmptyViewModel;
import com.linkedin.android.growth.calendar.CalendarToggleRowViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.infra.viewmodel.ViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class CalendarSyncSettingsTransformer
{
  public static List<ViewModel> toViewModels(BaseActivity paramBaseActivity)
  {
    ActivityComponent localActivityComponent = activityComponent;
    FlagshipSharedPreferences localFlagshipSharedPreferences = localActivityComponent.flagshipSharedPreferences();
    Object localObject = localFlagshipSharedPreferences.getCalendarSyncPreferences();
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList = new ArrayList();
    String str1 = paramBaseActivity.getLocalizedString(2131231395);
    int i = 0;
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      paramBaseActivity = (CalendarMetadata)localIterator.next();
      String str2 = accountName;
      if (!localHashSet.contains(str2))
      {
        localHashSet.add(str2);
        i = localArrayList.size();
        localArrayList.add(new CalendarAccountViewModel(str2));
      }
      String str3 = accountType;
      String str4 = name;
      boolean bool = shouldSync;
      localObject = displayName;
      paramBaseActivity = (BaseActivity)localObject;
      if (((String)localObject).equals(str2)) {
        paramBaseActivity = str1;
      }
      localObject = new CalendarToggleRowViewModel(bool, localFlagshipSharedPreferences, str3, str2, str4, paramBaseActivity, localActivityComponent.tracker());
      if (paramBaseActivity.equals(str1)) {
        localArrayList.add(i + 1, localObject);
      } else {
        localArrayList.add(localObject);
      }
    }
    if (localArrayList.isEmpty()) {
      localArrayList.add(new CalendarEmptyViewModel());
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.calendar.sync.CalendarSyncSettingsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */