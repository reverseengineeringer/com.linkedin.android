package com.linkedin.android.feed.endor.datamodel.transformer.service;

import com.linkedin.android.feed.viewmodels.models.CommentActionModel;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.pegasus.gen.voyager.feed.CommentAction;

public final class CommentActionDataModelTransformer
{
  public static CommentActionModel toDataModel(I18NManager paramI18NManager, CommentAction paramCommentAction, boolean paramBoolean)
  {
    Object localObject = null;
    int i;
    switch (com.linkedin.android.feed.transformer.CommentActionTransformerHelpers.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$feed$CommentAction[paramCommentAction.ordinal()])
    {
    default: 
      i = 0;
    }
    while (i == 0)
    {
      return null;
      i = 1;
      continue;
      i = 2;
    }
    int j;
    switch (com.linkedin.android.feed.transformer.CommentActionTransformerHelpers.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$feed$CommentAction[paramCommentAction.ordinal()])
    {
    default: 
      paramI18NManager = (I18NManager)localObject;
      switch (com.linkedin.android.feed.transformer.CommentActionTransformerHelpers.1.$SwitchMap$com$linkedin$android$pegasus$gen$voyager$feed$CommentAction[paramCommentAction.ordinal()])
      {
      default: 
        j = -1;
      }
      break;
    }
    for (;;)
    {
      return new CommentActionModel(i, paramI18NManager, j);
      if (paramBoolean) {}
      for (j = 2131231139;; j = 2131231132)
      {
        paramI18NManager = paramI18NManager.getString(j);
        break;
      }
      if (paramBoolean) {}
      for (j = 2131231141;; j = 2131231147)
      {
        paramI18NManager = paramI18NManager.getString(j);
        break;
      }
      j = 2130838373;
      continue;
      j = 2130838012;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.transformer.service.CommentActionDataModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */