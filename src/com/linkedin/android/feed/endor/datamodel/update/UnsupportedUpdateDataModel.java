package com.linkedin.android.feed.endor.datamodel.update;

import com.linkedin.android.feed.endor.datamodel.transformer.UpdateException;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Collections;

public final class UnsupportedUpdateDataModel
  extends UpdateDataModel
{
  public UpdateException reason;
  
  public UnsupportedUpdateDataModel(Update paramUpdate, UpdateException paramUpdateException)
  {
    super(paramUpdate, Collections.emptyList());
    reason = paramUpdateException;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.update.UnsupportedUpdateDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */