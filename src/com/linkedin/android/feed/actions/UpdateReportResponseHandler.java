package com.linkedin.android.feed.actions;

import android.support.design.widget.Snackbar;
import com.linkedin.android.feed.events.UpdateActionEvent;
import com.linkedin.android.feed.transformer.UpdateActionTransformerHelpers;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.SnackbarUtil;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.semaphore.api.ResponseListener;
import com.linkedin.semaphore.client.android.ReportEntityClientAction;
import com.linkedin.semaphore.client.android.ReportEntityResponse;
import com.linkedin.semaphore.client.android.ReportEntityResponseCode;
import com.linkedin.semaphore.client.android.ReportEntityResponseStatus;
import java.util.List;

public final class UpdateReportResponseHandler
  implements ResponseListener
{
  private final FragmentComponent fragmentComponent;
  private final Update update;
  private final UpdateActionModel updateActionModel;
  
  public UpdateReportResponseHandler(FragmentComponent paramFragmentComponent, Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    fragmentComponent = paramFragmentComponent;
    update = paramUpdate;
    updateActionModel = paramUpdateActionModel;
  }
  
  private void showSnackbar(int paramInt)
  {
    Snackbar localSnackbar = fragmentComponent.snackbarUtil().make(fragmentComponent.i18NManager().getString(paramInt), 0);
    if (localSnackbar != null) {
      localSnackbar.show();
    }
  }
  
  public final void errorFetchingMenu$508f4980(String paramString)
  {
    Log.i("Feed Logging", paramString);
    showSnackbar(2131233721);
  }
  
  public final void processCancelResponse$3a729177()
  {
    Log.i("Feed Logging", "Report flow canceled.");
  }
  
  public final void processErrorResponse$3a729177(ReportEntityResponse paramReportEntityResponse)
  {
    if (status == ReportEntityResponseStatus.FAILURE)
    {
      Log.i("Feed Logging", "Report response error");
      showSnackbar(2131233721);
    }
  }
  
  public final void processSuccessResponse$3a729177(ReportEntityResponse paramReportEntityResponse)
  {
    if ((status == ReportEntityResponseStatus.SUCCESS) && (clientAction != null) && (clientAction.reportAction != null))
    {
      paramReportEntityResponse = (ReportEntityResponseCode)clientAction.reportAction.get(0);
      if (paramReportEntityResponse != ReportEntityResponseCode.HIDE_CONTENT) {
        break label93;
      }
      paramReportEntityResponse = UpdateActionTransformerHelpers.toUpdateActionModel(updateActionModel, 15);
    }
    for (;;)
    {
      if (paramReportEntityResponse != null)
      {
        paramReportEntityResponse = new UpdateActionEvent(update, paramReportEntityResponse);
        fragmentComponent.eventBus();
        Bus.publish(paramReportEntityResponse);
      }
      return;
      label93:
      if (paramReportEntityResponse == ReportEntityResponseCode.BLOCK_PROFILE)
      {
        if (fragmentComponent.lixManager().getTreatment(Lix.LIX_SEMAPHORE_SHOW_ADDITIONAL_ACTION_TOAST).equals("enabled")) {
          showSnackbar(2131231188);
        }
        paramReportEntityResponse = UpdateActionTransformerHelpers.toUpdateActionModel(updateActionModel, 16);
      }
      else if (paramReportEntityResponse == ReportEntityResponseCode.REMOVE_CONNECTION)
      {
        paramReportEntityResponse = UpdateActionTransformerHelpers.toUpdateActionModel(updateActionModel, 17);
      }
      else if (paramReportEntityResponse == ReportEntityResponseCode.UNFOLLOW)
      {
        paramReportEntityResponse = UpdateActionTransformerHelpers.toUpdateActionModel(updateActionModel, 18);
      }
      else
      {
        paramReportEntityResponse = UpdateActionTransformerHelpers.toUpdateActionModel(updateActionModel, 19);
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.actions.UpdateReportResponseHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */