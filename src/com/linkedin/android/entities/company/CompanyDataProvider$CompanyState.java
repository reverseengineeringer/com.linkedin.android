package com.linkedin.android.entities.company;

import android.util.Log;
import com.linkedin.android.infra.app.DataProvider.State;
import com.linkedin.android.infra.collections.CollectionTemplateHelper;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items;
import com.linkedin.android.pegasus.gen.voyager.entities.company.BasicCompanyInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.company.Company;
import com.linkedin.android.pegasus.gen.voyager.entities.company.CompanySections;
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
import com.linkedin.data.lite.RecordTemplate;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import java.util.List;

public final class CompanyDataProvider$CompanyState
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
  
  public CompanyDataProvider$CompanyState(FlagshipDataManager paramFlagshipDataManager, Bus paramBus)
  {
    super(paramFlagshipDataManager, paramBus);
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
    return (Promo)getModel(CompanyDataProvider.access$1600(paramString));
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

/* Location:
 * Qualified Name:     com.linkedin.android.entities.company.CompanyDataProvider.CompanyState
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */