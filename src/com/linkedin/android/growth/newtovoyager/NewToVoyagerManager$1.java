package com.linkedin.android.growth.newtovoyager;

import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.RecordTemplateListener;
import com.linkedin.android.infra.data.FlagshipSharedPreferences;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.GroupContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.PageContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.SlotContent;
import com.linkedin.android.pegasus.gen.voyager.growth.lego.WidgetContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class NewToVoyagerManager$1
  implements RecordTemplateListener<PageContent>
{
  public NewToVoyagerManager$1(NewToVoyagerManager paramNewToVoyagerManager) {}
  
  public final void onResponse(DataStoreResponse<PageContent> paramDataStoreResponse)
  {
    if (model != null)
    {
      Object localObject = new NewToVoyagerPageContent((PageContent)model);
      paramDataStoreResponse = new ArrayList();
      if (pageContent.slots.containsKey("default"))
      {
        localObject = pageContent.slots.get("default")).groups.iterator();
        while (((Iterator)localObject).hasNext()) {
          paramDataStoreResponse.addAll(nextwidgets);
        }
      }
      localObject = paramDataStoreResponse.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramDataStoreResponse = (WidgetContent)((Iterator)localObject).next();
      } while (!widgetId.equals("voyager-new-to-voyager-feed"));
    }
    while (paramDataStoreResponse == null)
    {
      this$0.flagshipSharedPreferences.resetNewToVoyagerLegoTrackingToken();
      return;
      paramDataStoreResponse = null;
    }
    this$0.flagshipSharedPreferences.setNewToVoyagerLegoTrackingToken(trackingToken);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.newtovoyager.NewToVoyagerManager.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */