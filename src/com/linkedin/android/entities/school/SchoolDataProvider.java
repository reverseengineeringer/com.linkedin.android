package com.linkedin.android.entities.school;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolSupportedItems;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import java.util.Map;
import javax.inject.Inject;

public class SchoolDataProvider
  extends DataProvider<SchoolState, DataProvider.DataProviderListener>
{
  private static final String TAG = SchoolDataProvider.class.getSimpleName();
  
  @Inject
  public SchoolDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public final void fetchSchool(String paramString1, String paramString2, String paramString3, Map<String, String> paramMap)
  {
    Uri localUri = Routes.SCHOOL.buildRouteForId(paramString3);
    paramString3 = localUri.buildUpon().appendQueryParameter("supportedItems", SchoolSupportedItems.AMADEUS.toString()).build();
    localUri = Uri.withAppendedPath(localUri, "studentsAndAlumni");
    state).firstDegreeStudentsAndAlumniRoute = localUri.buildUpon().appendQueryParameter("q", "firstDegree").build().toString();
    state).nonFirstDegreeStudentsAndAlumniRoute = localUri.buildUpon().appendQueryParameter("q", "nonFirstDegree").build().toString();
    state).schoolRoute = paramString3.toString();
    performFetch(School.BUILDER, state).schoolRoute, paramString1, paramString2, paramMap);
  }
  
  public static final class SchoolConsistencyListener
    extends DefaultConsistencyListener
  {
    private Bus bus;
    private String modelKey;
    private SchoolDataProvider.SchoolState state;
    private String subscriberId;
    
    public SchoolConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, Bus paramBus, String paramString2, SchoolDataProvider.SchoolState paramSchoolState)
    {
      super();
      bus = paramBus;
      modelKey = paramString1;
      subscriberId = paramString2;
      state = paramSchoolState;
    }
    
    public final void safeModelUpdated(DataTemplate paramDataTemplate)
    {
      Bus.publish(new DataUpdatedEvent(subscriberId, modelKey));
      if (modelKey.equals(state.schoolRoute)) {
        state.schoolUpdated = true;
      }
    }
  }
  
  public static final class SchoolState
    extends DataProvider.State
  {
    public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> firstDegreeHelper;
    public String firstDegreeStudentsAndAlumniRoute;
    public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> nonFirstDegreeHelper;
    public String nonFirstDegreeStudentsAndAlumniRoute;
    public String schoolRoute;
    public TrackingObject schoolTrackingObject;
    public boolean schoolUpdated;
    
    public SchoolState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
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
        Log.e(SchoolDataProvider.TAG, "Unable to create TrackingObject for MiniSchool, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
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
          Log.e(SchoolDataProvider.TAG, "Unable to create TrackingObject for MiniSchool, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
        }
      }
    }
    
    public final School school()
    {
      return (School)getModel(schoolRoute);
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.SchoolDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */