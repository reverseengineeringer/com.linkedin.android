package com.linkedin.android.feed.promptresponselist;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.linkedin.android.infra.BundleBuilder;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.pegasus.gen.voyager.feed.Prompt;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;

public final class PromptResponseUpdateClickListener
  extends TrackingOnClickListener
{
  private final FragmentComponent fragmentComponent;
  private final Prompt prompt;
  private final Update update = null;
  private final String videoMetadataUrn;
  
  public PromptResponseUpdateClickListener(Prompt paramPrompt, String paramString1, FragmentComponent paramFragmentComponent, String paramString2, TrackingEventBuilder... paramVarArgs)
  {
    super(paramFragmentComponent.tracker(), paramString2, paramVarArgs);
    prompt = paramPrompt;
    videoMetadataUrn = paramString1;
    fragmentComponent = paramFragmentComponent;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    paramView = update;
    Prompt localPrompt = prompt;
    Object localObject = videoMetadataUrn;
    FragmentComponent localFragmentComponent = fragmentComponent;
    Context localContext = localFragmentComponent.context();
    Bundle localBundle = new Bundle();
    localBundle.putString("videoMetadataUrn", (String)localObject);
    localObject = new PromptResponseListBundleBuilder(localBundle);
    if (localPrompt != null) {
      ((PromptResponseListBundleBuilder)localObject).prompt(localPrompt);
    }
    if (paramView != null) {
      ((PromptResponseListBundleBuilder)localObject).update(paramView);
    }
    localContext.startActivity(intentRegistryfeedPromptResponseListIntent.newIntent(localContext, (BundleBuilder)localObject));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.promptresponselist.PromptResponseUpdateClickListener
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */