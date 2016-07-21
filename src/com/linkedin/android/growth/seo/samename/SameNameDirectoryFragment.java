package com.linkedin.android.growth.seo.samename;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.InjectView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.common.api.GoogleApiClient;
import com.linkedin.android.datamanager.DataManagerException;
import com.linkedin.android.datamanager.DataStoreResponse;
import com.linkedin.android.datamanager.interfaces.DataStore.Type;
import com.linkedin.android.growth.seo.appindexing.GoogleAppIndexingManager;
import com.linkedin.android.identity.profile.ProfileBundleBuilder;
import com.linkedin.android.identity.profile.ProfileViewIntent;
import com.linkedin.android.identity.profile.view.ProfileViewTransformer;
import com.linkedin.android.identity.shared.MiniProfileOnClickListener;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.KeyboardUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.growth.seo.SameNameProfileResult;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.xmsg.util.StringUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SameNameDirectoryFragment
  extends PageFragment
{
  private Action action;
  @InjectView(2131756262)
  LinearLayout dataError;
  @InjectView(2131756259)
  View divider;
  private String firstName;
  @InjectView(2131756258)
  EditText firstNameEditText;
  @InjectView(2131756255)
  LinearLayout focusLinearLayout;
  private GoogleApiClient googleApiClient;
  private KeyboardUtil keyboardUtil;
  private String lastName;
  @InjectView(2131756260)
  EditText lastNameEditText;
  @InjectView(2131756261)
  LinearLayout noResults;
  private String region;
  private SameNameDirectoryDataProvider sameNameDirectoryDataProvider;
  @InjectView(2131756274)
  LinearLayout sameNameProfilesLinearLayout;
  @InjectView(2131756256)
  LinearLayout searchBar;
  @InjectView(2131756257)
  TextView searchPeopleTextView;
  @InjectView(2131756263)
  LinearLayout stickyBottomCta;
  @InjectView(2131756264)
  TextView stickyBottomCtaText;
  
  public static SameNameDirectoryFragment newInstance(SameNameDirectoryBundleBuilder paramSameNameDirectoryBundleBuilder)
  {
    SameNameDirectoryFragment localSameNameDirectoryFragment = new SameNameDirectoryFragment();
    localSameNameDirectoryFragment.setArguments(paramSameNameDirectoryBundleBuilder.build());
    return localSameNameDirectoryFragment;
  }
  
  public static void sendSearchTrackingEvent(Tracker paramTracker, String paramString)
  {
    new ControlInteractionEvent(paramTracker, paramString, ControlType.TYPEAHEAD, InteractionType.KEYBOARD_SUBMIT).send();
  }
  
  public final void doLeave()
  {
    if (lastNameEditText != null) {
      KeyboardUtil.hideKeyboard(lastNameEditText);
    }
    super.doLeave();
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    keyboardUtil = new KeyboardUtil();
    sameNameDirectoryDataProvider = getActivityactivityComponent.sameNameDirectoryDataProvider();
    googleApiClient = GoogleAppIndexingManager.createGoogleApiClient(getContext());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(2130968872, paramViewGroup, false);
  }
  
  protected final void onDataError(DataStore.Type paramType, Set<String> paramSet, DataManagerException paramDataManagerException)
  {
    if (paramType == DataStore.Type.NETWORK)
    {
      sameNameProfilesLinearLayout.setVisibility(8);
      noResults.setVisibility(8);
      dataError.setVisibility(0);
    }
  }
  
  protected final void onDataReady(DataStore.Type paramType, Set<String> paramSet, Map<String, DataStoreResponse> paramMap)
  {
    if ((sameNameDirectoryDataProvider != null) && (sameNameDirectoryDataProvider.isDataAvailable()))
    {
      paramType = sameNameDirectoryDataProvider;
      if (paramType.isDataAvailable()) {
        break label102;
      }
      paramType = null;
    }
    while (CollectionUtils.isNonEmpty(paramType)) {
      if (elements.size() == 1)
      {
        paramType = ProfileBundleBuilder.createFromProfileId(elements.get(0)).miniProfile.entityUrn.getId());
        startActivity(fragmentComponent.intentRegistry().profileView.newIntent(getActivity(), paramType));
        return;
        label102:
        paramType = SameNameDirectoryDataProvider.SameNameState.access$100((SameNameDirectoryDataProvider.SameNameState)state);
      }
      else
      {
        int i;
        label229:
        Object localObject2;
        label266:
        Object localObject1;
        label278:
        Object localObject3;
        if ((paging != null) && (paging.hasTotal))
        {
          i = paging.total;
          sameNameProfilesLinearLayout.setVisibility(0);
          stickyBottomCtaText.setText(fragmentComponent.i18NManager().getString(2131231725, new Object[] { Integer.valueOf(i) }));
          stickyBottomCta.setOnClickListener(new SameNameDirectoryFragment.3(this, tracker, "same_name_cta", new TrackingEventBuilder[0]));
          stickyBottomCta.setVisibility(0);
          paramSet = getArguments();
          if (paramSet != null) {
            break label723;
          }
          paramSet = null;
          if (paramSet != null)
          {
            localObject2 = fragmentComponent.i18NManager();
            j = elements.size();
            if (firstName != null) {
              break label734;
            }
            paramMap = "";
            if (lastName != null) {
              break label742;
            }
            localObject1 = "";
            localObject3 = ((I18NManager)localObject2).getString(2131231726, new Object[] { Integer.valueOf(j), I18NManager.getName(paramMap, (String)localObject1) });
            if (firstName != null) {
              break label751;
            }
            paramMap = "";
            label320:
            if (lastName != null) {
              break label759;
            }
            localObject1 = "";
            label332:
            paramMap = ((I18NManager)localObject2).getString(2131231721, new Object[] { I18NManager.getName(paramMap, (String)localObject1), Integer.valueOf(i) });
            action = GoogleAppIndexingManager.getAction(Uri.parse(paramSet), (String)localObject3, paramMap);
            GoogleAppIndexingManager.startAppIndexing(googleApiClient, action);
          }
          paramMap = firstName;
          localObject1 = lastName;
          localObject2 = fragmentComponent;
          localObject3 = new SameNameDirectoryCardViewModel();
          I18NManager localI18NManager = ((FragmentComponent)localObject2).i18NManager();
          paramSet = paramMap;
          if (paramMap == null) {
            paramSet = "";
          }
          paramMap = (Map<String, DataStoreResponse>)localObject1;
          if (localObject1 == null) {
            paramMap = "";
          }
          header = localI18NManager.getSpannedString(2131231717, new Object[] { I18NManager.getName(paramSet, paramMap) });
          int j = elements.size();
          paramType = elements.iterator();
          i = 0;
          label493:
          if (!paramType.hasNext()) {
            break label774;
          }
          paramSet = (SameNameProfileResult)paramType.next();
          if (i == j - 1) {
            break label768;
          }
        }
        label723:
        label734:
        label742:
        label751:
        label759:
        label768:
        for (boolean bool = true;; bool = false)
        {
          paramMap = entryViewModels;
          localObject1 = new SameNameDirectoryCardEntryViewModel();
          name = ProfileViewTransformer.getFormattedFullName(miniProfile, ((FragmentComponent)localObject2).i18NManager());
          image = new ImageModel(miniProfile.picture, GhostImageUtils.getPerson(2131492963, miniProfile), Util.retrieveRumSessionId((FragmentComponent)localObject2));
          onClickListener = new MiniProfileOnClickListener(miniProfile, (FragmentComponent)localObject2, "same_name_profile_click", new TrackingEventBuilder[0]);
          headline = miniProfile.occupation;
          location = location;
          if ((hasPastPositions) && (CollectionUtils.isNonEmpty(pastPositions))) {
            pastExperience = ((FragmentComponent)localObject2).i18NManager().getString(2131231716, new Object[] { pastPositions });
          }
          showDivider = bool;
          paramMap.add(localObject1);
          i += 1;
          break label493;
          i = elements.size();
          break;
          paramSet = paramSet.getString("originalUrl");
          break label229;
          paramMap = firstName;
          break label266;
          localObject1 = lastName;
          break label278;
          paramMap = firstName;
          break label320;
          localObject1 = lastName;
          break label332;
        }
        label774:
        ((SameNameDirectoryCardViewModel)localObject3).onBindViewHolder(((BaseActivity)getActivity()).getLayoutInflater(), applicationComponent.mediaCenter(), (SameNameDirectoryCardViewHolder)SameNameDirectoryCardViewHolder.CREATOR.createViewHolder(sameNameProfilesLinearLayout));
        return;
      }
    }
    sameNameProfilesLinearLayout.setVisibility(8);
    dataError.setVisibility(8);
    noResults.setVisibility(0);
  }
  
  public void onDestroy()
  {
    if (lastNameEditText != null) {
      KeyboardUtil.hideKeyboard(lastNameEditText);
    }
    super.onDestroy();
  }
  
  public void onStop()
  {
    GoogleAppIndexingManager.stopAppIndexing(googleApiClient, action);
    super.onStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    firstName = SameNameDirectoryBundleBuilder.getFirstName(getArguments());
    lastName = SameNameDirectoryBundleBuilder.getLastName(getArguments());
    region = SameNameDirectoryBundleBuilder.getRegion(getArguments());
    searchPeopleTextView.setOnClickListener(new SameNameDirectoryFragment.1(this));
    lastNameEditText.setOnEditorActionListener(new SameNameDirectoryFragment.2(this));
    if ((StringUtils.isBlank(firstName)) && (StringUtils.isBlank(lastName)))
    {
      Toast.makeText(getActivity(), fragmentComponent.i18NManager().getString(2131231720), 0).show();
      return;
    }
    sameNameDirectoryDataProvider.fetchData(busSubscriberId, getRumSessionId(), firstName, lastName, SameNameDirectoryBundleBuilder.getRegion(getArguments()));
  }
  
  public final String pageKey()
  {
    return "same_name_directory";
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.seo.samename.SameNameDirectoryFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */