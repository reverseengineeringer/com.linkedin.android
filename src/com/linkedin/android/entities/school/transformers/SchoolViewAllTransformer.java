package com.linkedin.android.entities.school.transformers;

import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class SchoolViewAllTransformer
{
  public static List<ViewModel> toFirstDegreeStudentsAndAlumniViewAllList(FragmentComponent paramFragmentComponent, ActivityComponent paramActivityComponent, CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (CollectionUtils.isEmpty(paramCollectionTemplate))
    {
      paramCollectionTemplate = null;
      return paramCollectionTemplate;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = elements.iterator();
    for (;;)
    {
      paramCollectionTemplate = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      paramCollectionTemplate = null;
      MiniProfile localMiniProfile = miniProfile;
      if (paramTrackingObject != null) {
        paramCollectionTemplate = SchoolTransformer.newSchoolImpressionTrackingClosure(trackingId, paramTrackingObject, firstName, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(EntityTransformer.toConnectionItem(paramFragmentComponent, paramActivityComponent, localMiniProfile, distance, paramCollectionTemplate));
    }
  }
  
  public static List<ViewModel> toStudentsAndAlumniViewAllList(FragmentComponent paramFragmentComponent, CollectionTemplate<EntitiesMiniProfile, CollectionMetadata> paramCollectionTemplate, TrackingObject paramTrackingObject)
  {
    if (CollectionUtils.isEmpty(paramCollectionTemplate))
    {
      paramCollectionTemplate = null;
      return paramCollectionTemplate;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = elements.iterator();
    for (;;)
    {
      paramCollectionTemplate = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      EntitiesMiniProfile localEntitiesMiniProfile = (EntitiesMiniProfile)localIterator.next();
      paramCollectionTemplate = null;
      MiniProfile localMiniProfile = miniProfile;
      if (paramTrackingObject != null) {
        paramCollectionTemplate = SchoolTransformer.newSchoolImpressionTrackingClosure(trackingId, paramTrackingObject, firstName, Collections.singletonList(objectUrn.toString()));
      }
      localArrayList.add(EntityTransformer.toPersonItem(paramFragmentComponent, miniProfile, false, paramCollectionTemplate));
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.transformers.SchoolViewAllTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */