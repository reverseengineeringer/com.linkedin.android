package com.linkedin.android.entities.school.transformers;

import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import java.util.Map;

final class SchoolTransformer$1
  extends TrackingClosure<Boolean, Void>
{
  SchoolTransformer$1(Tracker paramTracker, String paramString, SchoolDataProvider paramSchoolDataProvider, FragmentComponent paramFragmentComponent, MiniSchool paramMiniSchool, BasicSchoolInfo paramBasicSchoolInfo, Map paramMap)
  {
    super(paramTracker, paramString);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.transformers.SchoolTransformer.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */