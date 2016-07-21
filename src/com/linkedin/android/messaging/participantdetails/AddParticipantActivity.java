package com.linkedin.android.messaging.participantdetails;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.logger.Log;
import com.linkedin.android.messaging.BaseMessengerActivity;
import com.linkedin.messengerlib.me.MeFetcher;
import com.linkedin.messengerlib.shared.BaseFragment;
import com.linkedin.messengerlib.tracking.MessengerTrackingUtils;
import com.linkedin.messengerlib.ui.PeopleSearchCompletionView;
import com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment.4;
import com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment.AddParticipantCallbacks;
import com.linkedin.messengerlib.viewmodel.ViewModelTransformer;
import com.tokenautocomplete.TokenCompleteTextView;
import com.tokenautocomplete.TokenCompleteTextView.5;
import java.util.List;

public class AddParticipantActivity
  extends BaseMessengerActivity
{
  private static final String TAG = AddParticipantActivity.class.getCanonicalName();
  @InjectView(2131756796)
  TextView doneButton;
  private AddParticipantFragment fragment;
  @InjectView(2131756795)
  Toolbar toolbar;
  
  public final Fragment buildNewChildFragment()
  {
    return new AddParticipantFragment();
  }
  
  @OnClick({2131756796})
  void doneButtonTapped()
  {
    if (fragment != null)
    {
      Object localObject = fragment;
      if (fragment != null)
      {
        localObject = fragment;
        if ((((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject).getActivity() != null) && (((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject).getMessengerLibApi() != null)) {
          break label39;
        }
      }
      label39:
      do
      {
        return;
        localList = searchBar.getObjects();
      } while ((localList == null) || (localList.isEmpty()));
      List localList = ViewModelTransformer.flattenPeopleViewModels(localList);
      MessengerTrackingUtils.sendButtonShortPressEvent(((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject).getTracker(), "done");
      PeopleSearchCompletionView localPeopleSearchCompletionView = searchBar;
      localPeopleSearchCompletionView.post(new TokenCompleteTextView.5(localPeopleSearchCompletionView));
      if (((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject).getActivity() != null) {
        ((InputMethodManager)((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject).getActivity().getSystemService("input_method")).hideSoftInputFromWindow(searchBar.getWindowToken(), 0);
      }
      MeFetcher.getMe(fragmentComponent, new AddParticipantFragment.4((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject, localList));
      ((com.linkedin.messengerlib.ui.participantdetails.AddParticipantFragment)localObject).getActivity().setResult(-1);
      return;
    }
    Log.e(TAG, "AddParticipantFragment was null and could not complete the done operation");
  }
  
  public final String getChildFragmentTag()
  {
    return "addParticipantFragmentTag";
  }
  
  public final int getContentViewResId()
  {
    return 2130969005;
  }
  
  public final int getFragmentContainerResId()
  {
    return 2131756797;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    toolbar.setTitle(activityComponent.i18NManager().getString(2131232816));
    toolbar.setNavigationOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        onNavigationClick();
      }
    });
  }
  
  public final void performInjections()
  {
    activityComponent.inject(this);
    ButterKnife.inject(this);
  }
  
  public final Fragment setupChildFragment()
  {
    fragment = ((AddParticipantFragment)super.setupChildFragment());
    fragment.addParticipantCallbacks = new AddParticipantFragment.AddParticipantCallbacks()
    {
      public final void onPendingParticipantsChange(boolean paramAnonymousBoolean)
      {
        TextView localTextView;
        if (doneButton != null)
        {
          localTextView = doneButton;
          if (!paramAnonymousBoolean) {
            break label31;
          }
        }
        label31:
        for (int i = 8;; i = 0)
        {
          localTextView.setVisibility(i);
          return;
        }
      }
    };
    return fragment;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.messaging.participantdetails.AddParticipantActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */