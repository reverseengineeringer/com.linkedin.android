package com.linkedin.android.feed.endor.datamodel.transformer;

import com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel;
import com.linkedin.android.feed.endor.datamodel.actor.ExternalCompanyActorDataModel;
import com.linkedin.android.feed.endor.datamodel.content.JobContentDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.JymbiiUpdateDataModel;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.pegasus.gen.voyager.feed.Update.Value;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.ExternalCompany;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate;
import com.linkedin.android.pegasus.gen.voyager.feed.shared.JymbiiUpdate.Company;

public final class JymbiiUpdateDataModelTransformer
{
  public static JymbiiUpdateDataModel toDataModel(FragmentComponent paramFragmentComponent, Update paramUpdate)
    throws UpdateException
  {
    int i = FeedTracking.getSponsoredRenderFormatInt(tracking, 3);
    if (value.jymbiiUpdateValue != null)
    {
      JymbiiUpdate localJymbiiUpdate = value.jymbiiUpdateValue;
      if (company.companyActorValue != null) {}
      for (Object localObject = ActorDataTransformer.toDataModel(paramFragmentComponent, company.companyActorValue);; localObject = new ExternalCompanyActorDataModel((ExternalCompany)localObject, paramFragmentComponent.i18NManager().getString(2131230829, new Object[] { companyName }), companyName, Util.retrieveRumSessionId(paramFragmentComponent)))
      {
        JobContentDataModel localJobContentDataModel = new JobContentDataModel(miniJob, miniJob.listDate, miniJob.title, miniJob.location, miniJob.logo, (ActorDataModel)localObject, null);
        return new JymbiiUpdateDataModel(paramUpdate, UpdateActionDataModelTransformer.toDataModels(paramFragmentComponent, actions, (ActorDataModel)localObject), (ActorDataModel)localObject, localJobContentDataModel, i, createdAt, flavors);
        if (company.externalCompanyValue == null) {
          break;
        }
        localObject = company.externalCompanyValue;
      }
      throw new UpdateException("Unknown actor for this jymbii update!");
    }
    throw new UpdateException("Invalid jymbii update model!");
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.JymbiiUpdateDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */