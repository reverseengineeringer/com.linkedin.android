package com.linkedin.android.growth.seo.samename;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.network.Auth;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import com.linkedin.xmsg.util.StringUtils;

public class SameNameDirectoryActivity
  extends BaseActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968871);
    if (paramBundle != null) {
      return;
    }
    Bundle localBundle = getIntent().getExtras();
    if (applicationComponent.auth().isAuthenticated())
    {
      SearchBundleBuilder localSearchBundleBuilder = SearchBundleBuilder.create();
      I18NManager localI18NManager = activityComponent.i18NManager();
      Object localObject = SameNameDirectoryBundleBuilder.getFirstName(localBundle);
      String str = SameNameDirectoryBundleBuilder.getLastName(localBundle);
      paramBundle = (Bundle)localObject;
      if (StringUtils.isBlank((String)localObject)) {
        paramBundle = "";
      }
      localObject = str;
      if (StringUtils.isBlank(str)) {
        localObject = "";
      }
      localSearchBundleBuilder.setQueryString(localI18NManager.getNamedString(2131233018, paramBundle, (String)localObject, "").trim()).setOpenSearchFragment().setSearchType(SearchType.PEOPLE).setOrigin(SearchResultPageOrigin.SAME_NAME_DIRECTORY_PAGE.toString());
      startActivity(activityComponent.intentRegistry().search.newIntent(this, localSearchBundleBuilder));
      finish();
    }
    paramBundle = new SameNameDirectoryBundleBuilder(localBundle);
    getSupportFragmentManager().beginTransaction().replace(2131756253, SameNameDirectoryFragment.newInstance(paramBundle)).commit();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.seo.samename.SameNameDirectoryActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */