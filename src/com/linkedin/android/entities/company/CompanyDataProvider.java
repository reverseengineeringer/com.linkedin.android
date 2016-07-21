package com.linkedin.android.entities.company;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.shared.events.DataUpdatedEvent;
import com.linkedin.android.feed.actions.UpdateActionPublisher;
import com.linkedin.android.feed.events.FollowRequestedEvent;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.DataProvider.DataProviderListener;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.Routes;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniJobsCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.MiniProfilesCollection;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanySections;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanySupportedItems;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Showcases;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.incommon.InCommonPerson;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.consistency.DefaultConsistencyListener;
import com.linkedin.crosspromo.fe.api.android.Promo;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.DataTemplate;
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

public class CompanyDataProvider
  extends DataProvider<CompanyState, DataProvider.DataProviderListener>
{
  private static final String TAG = CompanyDataProvider.class.getSimpleName();
  
  @Inject
  public CompanyDataProvider(ActivityComponent paramActivityComponent)
  {
    super(paramActivityComponent);
  }
  
  public static Uri buildWithSupportedItems(Uri paramUri)
  {
    return paramUri.buildUpon().appendQueryParameter("supportedItems", CompanySupportedItems.CHOPIN.toString()).build();
  }
  
  public static String crossPromoPath(String paramString)
  {
    return new Uri.Builder().path("/cross-promo-fe/api/promo").appendPath(paramString).build().toString();
  }
  
  public static void handleUpdateOverflowAction(FragmentComponent paramFragmentComponent, UpdateActionEvent paramUpdateActionEvent, Map<String, String> paramMap, boolean paramBoolean)
  {
    if (!paramBoolean) {
      return;
    }
    Update localUpdate = update;
    paramUpdateActionEvent = updateAction;
    switch (type)
    {
    default: 
      return;
    }
    UpdateActionPublisher.publishUpdateAction(paramMap, paramFragmentComponent, urn.toString(), paramUpdateActionEvent, localUpdate);
  }
  
  public final void fetchInitialCompanyUpdates(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    RecordTemplateListener localRecordTemplateListener = collectionCompletionCallback(paramString1, paramString2, paramString3, 2);
    CollectionTemplateHelper localCollectionTemplateHelper = state).allUpdatesHelper;
    paramString1 = localCollectionTemplateHelper;
    if (localCollectionTemplateHelper == null)
    {
      paramString1 = new CollectionTemplateHelper(activityComponent.dataManager(), null, Update.BUILDER, CollectionMetadata.BUILDER);
      state).allUpdatesHelper = paramString1;
    }
    paramString1.fetchInitialData(paramMap, 2, paramString3, localRecordTemplateListener, paramString2);
  }
  
  public final void initRoutesGivenCompanyId(String paramString)
  {
    paramString = Routes.COMPANY.buildRouteForId(paramString);
    state).companyRoute = buildWithSupportedItems(paramString).toString();
    state).allJobsRoute = Uri.withAppendedPath(paramString, "jobs").toString();
    state).matchedJobsRoute = Uri.withAppendedPath(paramString, "matchedJobs").toString();
    state).immediateConnectionsRoute = Uri.withAppendedPath(paramString, "immediateConnections").toString();
    state).introducersRoute = Uri.withAppendedPath(paramString, "inCommonPeople").toString();
    state).employeesRoute = Uri.withAppendedPath(paramString, "companyEmployees").toString();
    state).commonCompaniesAlumniRoute = Uri.withAppendedPath(paramString, "inCommonCompanies").toString();
  }
  
  public final boolean isDataAvailable()
  {
    return ((CompanyState)state).company() != null;
  }
  
  public final void setupAllJobsHelper(MiniJobsCollection paramMiniJobsCollection)
  {
    Object localObject = null;
    if (state).allJobsHelper == null)
    {
      List localList;
      if (paramMiniJobsCollection == null)
      {
        localList = null;
        if (paramMiniJobsCollection != null) {
          break label76;
        }
      }
      for (paramMiniJobsCollection = (MiniJobsCollection)localObject;; paramMiniJobsCollection = pagingInfo)
      {
        try
        {
          paramMiniJobsCollection = EntityUtils.createDefaultCollection(localList, paramMiniJobsCollection);
          state).allJobsHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramMiniJobsCollection, MiniJob.BUILDER, CollectionMetadata.BUILDER);
          return;
        }
        catch (BuilderException paramMiniJobsCollection)
        {
          label76:
          activityComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException(paramMiniJobsCollection));
        }
        localList = items;
        break;
      }
    }
  }
  
  public final void setupImmediateConnectionsHelper(MiniProfilesCollection paramMiniProfilesCollection)
  {
    Object localObject = null;
    if (state).immediateConnectionsHelper == null)
    {
      List localList;
      if (paramMiniProfilesCollection == null)
      {
        localList = null;
        if (paramMiniProfilesCollection != null) {
          break label76;
        }
      }
      for (paramMiniProfilesCollection = (MiniProfilesCollection)localObject;; paramMiniProfilesCollection = pagingInfo)
      {
        try
        {
          paramMiniProfilesCollection = EntityUtils.createDefaultCollection(localList, paramMiniProfilesCollection);
          state).immediateConnectionsHelper = new CollectionTemplateHelper(activityComponent.dataManager(), null, paramMiniProfilesCollection, EntitiesMiniProfile.BUILDER, CollectionMetadata.BUILDER);
          return;
        }
        catch (BuilderException paramMiniProfilesCollection)
        {
          label76:
          activityComponent.context();
          Util.safeThrow$7a8b4789(new RuntimeException(paramMiniProfilesCollection));
        }
        localList = items;
        break;
      }
    }
  }
  
  public final void toggleFollow(String paramString, FollowingInfo paramFollowingInfo, Map<String, String> paramMap)
  {
    paramString = new FollowRequestedEvent(paramString, Routes.COMPANY, paramFollowingInfo, paramMap);
    activityComponent.eventBus();
    Bus.publish(paramString);
  }
  
  public static final class CompanyConsistencyListener
    extends DefaultConsistencyListener
  {
    private Bus bus;
    private String modelKey;
    private CompanyDataProvider.CompanyState state;
    private String subscriberId;
    
    public CompanyConsistencyListener(DataTemplate paramDataTemplate, String paramString1, Bus paramBus, String paramString2, CompanyDataProvider.CompanyState paramCompanyState)
    {
      super();
      bus = paramBus;
      modelKey = paramString1;
      subscriberId = paramString2;
      state = paramCompanyState;
    }
    
    public final void safeModelUpdated(DataTemplate paramDataTemplate)
    {
      Bus.publish(new DataUpdatedEvent(subscriberId, modelKey));
      if (modelKey.equals(state.companyRoute)) {
        state.companyUpdated = true;
      }
    }
  }
  
  public static final class CompanyState
    extends DataProvider.State
  {
    public CollectionTemplateHelper<MiniJob, CollectionMetadata> allJobsHelper;
    public String allJobsRoute;
    public CollectionTemplateHelper<Update, CollectionMetadata> allUpdatesHelper;
    public CollectionTemplateHelper<InCommonCompany, CollectionMetadata> commonCompaniesAlumniHelper;
    public String commonCompaniesAlumniRoute;
    public String companyRecruitsRoute;
    public String companyRoute;
    public TrackingObject companyTrackingObject;
    public boolean companyUpdated;
    public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> employeesHelper;
    public String employeesRoute;
    public String findCompanyByNameRoute;
    public boolean fromSubEntityPage;
    public CollectionTemplateHelper<EntitiesMiniProfile, CollectionMetadata> immediateConnectionsHelper;
    public String immediateConnectionsRoute;
    public List<MiniProfile> inCommonPeople;
    public CollectionTemplateHelper<InCommonPerson, CollectionMetadata> introducersHelper;
    public String introducersRoute;
    public CollectionTemplateHelper<MiniJob, CollectionMetadata> matchedJobsHelper;
    public String matchedJobsRoute;
    public Showcases showcases;
    public boolean toastDisplayed;
    
    public CompanyState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
    {
      super(paramBus);
    }
    
    public final Company company()
    {
      if ((companyRoute != null) && (getModel(companyRoute) != null)) {
        return (Company)getModel(companyRoute);
      }
      if (findCompanyByNameRoute != null)
      {
        CollectionTemplate localCollectionTemplate = (CollectionTemplate)getModel(findCompanyByNameRoute);
        if (CollectionUtils.isNonEmpty(localCollectionTemplate)) {
          return (Company)elements.get(0);
        }
      }
      return null;
    }
    
    protected final DefaultConsistencyListener createConsistencyListener(RecordTemplate paramRecordTemplate, String paramString1, String paramString2)
    {
      return new CompanyDataProvider.CompanyConsistencyListener(paramRecordTemplate, paramString1, bus, paramString2, this);
    }
    
    public final Promo getCrossPromo(String paramString)
    {
      return (Promo)getModel(CompanyDataProvider.crossPromoPath(paramString));
    }
    
    public final List<Section.Items> highlightsItems()
    {
      Company localCompany = company();
      if ((localCompany == null) || (sections == null) || (sections.highlights == null)) {
        return null;
      }
      return sections.highlights.items;
    }
    
    public final TrackingObject initCompanyTrackingObjectFromNetwork()
    {
      Object localObject = company();
      if (localObject != null)
      {
        localObject = basicCompanyInfo.miniCompany;
        if ((objectUrn != null) && (trackingId != null)) {
          break label91;
        }
        Log.e(CompanyDataProvider.access$1500(), "Unable to create TrackingObject for MiniCompany, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
        companyTrackingObject = null;
      }
      for (;;)
      {
        return companyTrackingObject;
        try
        {
          label91:
          companyTrackingObject = new TrackingObject.Builder().setObjectUrn(objectUrn.toString()).setTrackingId(trackingId).build(RecordTemplate.Flavor.RECORD);
        }
        catch (BuilderException localBuilderException)
        {
          Log.e(CompanyDataProvider.access$1500(), "Unable to create TrackingObject for MiniCompany, id = " + _cachedId + ", objectUrn = " + objectUrn + ", trackingId = " + trackingId);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyDataProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */