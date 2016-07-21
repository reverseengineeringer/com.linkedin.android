package com.linkedin.android.feed.transformer;

import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;

public final class UpdateActionTransformerHelpers
{
  public static UpdateActionModel toUpdateActionModel(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2, String paramString1, String paramString2, String paramString3, FollowingInfo paramFollowingInfo, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7)
  {
    if (paramInt1 == 0) {
      return null;
    }
    return new UpdateActionModel(paramInt1, paramCharSequence1, paramCharSequence2, paramInt2, paramString1, paramString2, paramString3, paramFollowingInfo, paramString4, paramBoolean, paramString5, paramString6, paramString7);
  }
  
  public static UpdateActionModel toUpdateActionModel(UpdateActionModel paramUpdateActionModel, int paramInt)
  {
    if (paramInt == 19) {
      return null;
    }
    return new UpdateActionModel(paramInt, null, null, -1, actorId, actorName, null, null, null, false, null, null, null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.transformer.UpdateActionTransformerHelpers
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */