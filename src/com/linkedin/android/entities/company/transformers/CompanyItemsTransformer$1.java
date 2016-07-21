package com.linkedin.android.entities.company.transformers;

import android.widget.ImageView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;

final class CompanyItemsTransformer$1
  extends TrackingClosure<ImageView, Void>
{
  CompanyItemsTransformer$1(Tracker paramTracker, String paramString, MiniCompany paramMiniCompany, FragmentComponent paramFragmentComponent)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.transformers.CompanyItemsTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */