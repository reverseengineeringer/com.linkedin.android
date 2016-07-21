package com.linkedin.android.entities.school;

import android.util.Log;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;

public final class SchoolDataProvider$SchoolState
  extends DataProvider.State
{
  public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> firstDegreeHelper;
  public String firstDegreeStudentsAndAlumniRoute;
  public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> nonFirstDegreeHelper;
  public String nonFirstDegreeStudentsAndAlumniRoute;
  public String schoolRoute;
  public TrackingObject schoolTrackingObject;
  public boolean schoolUpdated;
  
  public SchoolDataProvider$SchoolState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
  }
  
  protected final DefaultConsistencyListener createConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, String paramString2)
  {
    return new SchoolDataProvider.SchoolConsistencyListener(paramRecordTemplate, paramString1, bus, paramString2, this);
  }
  
  public final TrackingObject initSchoolTrackingObjectFromNetwork()
  {
    Object localObject = school();
    if (localObject != null)
    {
      localObject = basicSchoolInfo.miniSchool;
      if ((objectUrn != null) && (trackingId != null)) {
        break label91;
      }
      Log.e(SchoolDataProvider.access$500(), "Unable to create TrackingObject for MiniSchool, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
      schoolTrackingObject = null;
    }
    for (;;)
    {
      return schoolTrackingObject;
      try
      {
        label91:
        schoolTrackingObject = new TrackingObject.Builder().setObjectUrn(objectUrn.toString()).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
      }
      catch (BuilderException localBuilderException)
      {
        Log.e(SchoolDataProvider.access$500(), "Unable to create TrackingObject for MiniSchool, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
      }
    }
  }
  
  public final School school()
  {
    return (School)getModel(schoolRoute);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolDataProvider.SchoolState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */