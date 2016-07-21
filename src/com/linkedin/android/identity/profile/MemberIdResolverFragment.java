package com.linkedin.android.identity.profile;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ProgressBar;
import butterknife.InjectView;
import com.linkedin.android.datamanager.DataManager.DataStoreFilter;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.FlagshipDataManager;
import com.linkedin.android.infra.data.Request;
import com.linkedin.android.infra.data.Request.Builder;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.ErrorPageViewHolder;
import com.linkedin.android.infra.shared.ErrorPageViewModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import java.util.Map;
import java.util.Set;

public class MemberIdResolverFragment
  extends PageFragment
{
  @InjectView(2131758000)
  ViewStub errorViewStub;
  private ProfileDataProvider profileDataProvider;
  @InjectView(2131757999)
  ProgressBar progressBar;
  
  public static MemberIdResolverFragment newInstance(ProfileBundleBuilder paramProfileBundleBuilder)
  {
    MemberIdResolverFragment localMemberIdResolverFragment = new MemberIdResolverFragment();
    localMemberIdResolverFragment.setArguments(paramProfileBundleBuilder.build());
    return localMemberIdResolverFragment;
  }
  
  private void showError()
  {
    Object localObject1 = getView();
    if (localObject1 != null)
    {
      Object localObject2 = fragmentComponent.i18NManager();
      ErrorPageViewModel localErrorPageViewModel = new ErrorPageViewModel(errorViewStub);
      errorHeaderText = ((I18NManager)localObject2).getString(2131232638);
      errorDescriptionText = ((I18NManager)localObject2).getString(2131232637);
      errorImage = 2130838622;
      localObject1 = (ErrorPageViewHolder)localErrorPageViewModel.getCreator().createViewHolder((View)localObject1);
      localObject2 = getActivity().getLayoutInflater();
      applicationComponent.mediaCenter();
      localErrorPageViewModel.onBindViewHolder$49e9e35b((LayoutInflater)localObject2, (ErrorPageViewHolder)localObject1);
      progressBar.setVisibility(8);
      errorViewStub.setVisibility(0);
    }
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130969276, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK) {
      showError();
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    paramType = (ProfileState)profileDataProvider.state;
    paramType = (MiniProfile)paramType.getModel(miniProfileRoute);
    if (paramType != null)
    {
      paramType = ProfileBundleBuilder.createFromProfileId(entityUrn.getId());
      paramSet = fragmentComponent.activity();
      if ((paramSet instanceof ProfileViewActivity)) {
        ((ProfileViewActivity)paramSet).startViewFragment(paramType.build());
      }
      return;
    }
    showError();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    fragmentComponent.inject(this);
    profileDataProvider = fragmentComponent.activity().activityComponent.profileDataProvider();
    progressBar.setVisibility(0);
    paramBundle = getArguments().getString("memberId");
    if ((profileDataProvider != null) && (paramBundle != null))
    {
      paramView = profileDataProvider;
      String str = busSubscriberId;
      state).miniProfileRoute = ProfileRoutes.buildMiniProfileRoute(paramBundle).toString();
      paramBundle = paramView.newModelListener(str, null);
      paramBundle = Request.get().url(state).miniProfileRoute).customHeaders(null).builder(MiniProfile.BUILDER).listener(paramBundle).filter(DataManager.DataStoreFilter.ALL);
      activityComponent.dataManager().submit(paramBundle);
      return;
    }
    showError();
  }
  
  public final String pageKey()
  {
    return "profile_view_member_id_resolver_loading_screen";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.profile.MemberIdResolverFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */