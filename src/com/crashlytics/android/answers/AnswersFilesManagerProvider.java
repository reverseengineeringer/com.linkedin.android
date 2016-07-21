package com.crashlytics.android.answers;

import android.content.Context;
import io.fabric.sdk.android.services.persistence.FileStore;

final class AnswersFilesManagerProvider
{
  final Context context;
  final FileStore fileStore;
  
  public AnswersFilesManagerProvider(Context paramContext, FileStore paramFileStore)
  {
    context = paramContext;
    fileStore = paramFileStore;
  }
}

/* Location:
 * Qualified Name:     com.crashlytics.android.answers.AnswersFilesManagerProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */