package com.linkedin.android.feed.promptresponselist;

import android.os.Bundle;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;

public final class PromptResponseListBundleBuilder
  implements BundleBuilder
{
  private final Bundle bundle;
  
  public PromptResponseListBundleBuilder(Bundle paramBundle)
  {
    bundle = paramBundle;
  }
  
  public final Bundle build()
  {
    return bundle;
  }
  
  public final PromptResponseListBundleBuilder prompt(Prompt paramPrompt)
  {
    RecordParceler.quietParcel(paramPrompt, "prompt", bundle);
    return this;
  }
  
  public final PromptResponseListBundleBuilder update(Update paramUpdate)
  {
    RecordParceler.quietParcel(paramUpdate, "update", bundle);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.PromptResponseListBundleBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */