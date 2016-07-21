package com.linkedin.android.search.resourcelist;

import android.net.Uri;
import android.net.Uri.Builder;
import com.linkedin.android.fission.interfaces.FissileDataModelBuilder;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.search.typeahead.TypeaheadSmallNoIconViewModel;

public final class IndustryListFragment
  extends ResourceListFragment<Industry, TypeaheadSmallNoIconViewModel>
{
  protected final FissileDataModelBuilder<Industry> getDataBuilder()
  {
    return Industry.BUILDER;
  }
  
  protected final String getRoute()
  {
    return Routes.INDUSTRY.buildUponRoot().buildUpon().toString();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public final String pageKey()
  {
    String str2 = ResourceListBundleBuilder.getCustomPageKey(getArguments());
    String str1 = str2;
    if (str2 == null) {
      str1 = "industry_picker";
    }
    return str1;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.resourcelist.IndustryListFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */