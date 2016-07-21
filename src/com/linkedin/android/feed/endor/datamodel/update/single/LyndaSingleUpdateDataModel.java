package com.linkedin.android.feed.endor.datamodel.update.single;

import com.linkedin.android.feed.endor.datamodel.content.ContentDataModel;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.List;

public final class LyndaSingleUpdateDataModel
  extends SingleUpdateDataModel
{
  public CharSequence headerText;
  
  public LyndaSingleUpdateDataModel(Update paramUpdate, List<UpdateActionModel> paramList, int paramInt, ContentDataModel paramContentDataModel, CharSequence paramCharSequence)
  {
    super(paramUpdate, paramList, paramInt, -1L, null, paramContentDataModel, null);
    headerText = paramCharSequence;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.single.LyndaSingleUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */