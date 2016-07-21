package com.linkedin.android.identity.edit.treasury;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import butterknife.InjectView;
import com.linkedin.android.identity.edit.ProfileEditBaseFragment;
import com.linkedin.android.identity.edit.ProfileTreasuryEditBundleBuilder;
import com.linkedin.android.identity.edit.editComponents.EditComponentTransformer;
import com.linkedin.android.identity.profile.ProfileState;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.data.RecordParceler;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.mediaupload.MediaUploader;
import com.linkedin.android.infra.mediaupload.SlideShareResponse;
import com.linkedin.android.infra.mediaupload.SlideShareResponse.AvailableSizes;
import com.linkedin.android.infra.mediaupload.SlideShareResponse.Size;
import com.linkedin.android.infra.mediaupload.SlideShareUploadFinishedEvent;
import com.linkedin.android.infra.mediaupload.UploadFailedEvent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.ViewModelArrayAdapter;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage;
import com.linkedin.android.pegasus.gen.voyager.common.MediaProxyImage.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Link;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.RichText;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia.Data;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.TreasuryMedia.Data.Builder;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.treasury.Video;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.data.lite.UnionMemberCountException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.greenrobot.eventbus.Subscribe;

public class ProfileTreasuryEditFragment
  extends ProfileEditBaseFragment
{
  private static final String TAG = ProfileTreasuryEditFragment.class.getSimpleName();
  private ViewModelArrayAdapter<ViewModel> arrayAdapter;
  @Inject
  Bus eventBus;
  @Inject
  MediaUploader mediaUploader;
  @InjectView(2131757584)
  RecyclerView recyclerView;
  private TreasuryMedia.Builder tempTreasuryMediaBuilder;
  private TreasuryMedia treasuryMedia;
  private List<TreasuryMedia> treasuryMedias;
  private TreasuryUpdateViewModel treasuryUpdateViewModel;
  
  private TreasuryMedia getCurrentTreasury()
    throws BuilderException
  {
    TreasuryUpdateViewModel localTreasuryUpdateViewModel = treasuryUpdateViewModel;
    TreasuryMedia.Builder localBuilder = tempTreasuryMediaBuilder;
    if (!TextUtils.isEmpty(title))
    {
      localBuilder.setCustomTitle(title);
      if (TextUtils.isEmpty(description)) {
        break label68;
      }
      localBuilder.setCustomDescription(description);
    }
    for (;;)
    {
      return tempTreasuryMediaBuilder.build(RecordTemplate.Flavor.RECORD);
      localBuilder.setCustomTitle(null);
      break;
      label68:
      localBuilder.setCustomDescription(null);
    }
  }
  
  public static ProfileTreasuryEditFragment newInstance(ProfileTreasuryEditBundleBuilder paramProfileTreasuryEditBundleBuilder)
  {
    ProfileTreasuryEditFragment localProfileTreasuryEditFragment = new ProfileTreasuryEditFragment();
    localProfileTreasuryEditFragment.setArguments(paramProfileTreasuryEditBundleBuilder.build());
    return localProfileTreasuryEditFragment;
  }
  
  protected final boolean enableProgressDialogOnUpdate()
  {
    return false;
  }
  
  public final String getCancelTrackingControlName()
  {
    return "dismiss";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969200;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return -1;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "save";
  }
  
  public final String getTitle()
  {
    if (Util.isEnglish(getContext())) {}
    for (int i = 2131232584;; i = 2131232718) {
      return i18NManager.getString(i);
    }
  }
  
  protected final void initializeFields() {}
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    try
    {
      boolean bool = getCurrentTreasury().equals(treasuryMedia);
      return !bool;
    }
    catch (BuilderException localBuilderException)
    {
      Log.d(TAG, "Failed to build treasury: " + localBuilderException.getMessage());
    }
    return true;
  }
  
  protected final boolean isFormValid()
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
    Bus.subscribe(this);
  }
  
  public void onDestroy()
  {
    Bus.unsubscribe(this);
    super.onDestroy();
  }
  
  @Subscribe
  public void onEvent(TreasuryEditEvent paramTreasuryEditEvent)
  {
    switch (type)
    {
    default: 
      return;
    case 0: 
      if ((!treasuryUpdateViewModel.isNewTreasury) && (isFormModified())) {}
      for (boolean bool = true;; bool = false)
      {
        setEditSaveMenuItemEnabled(bool);
        return;
      }
    }
    showConfirmDeleteDialog(2131232278, new ProfileTreasuryEditFragment.1(this));
  }
  
  @Subscribe
  public void onEvent(SlideShareUploadFinishedEvent paramSlideShareUploadFinishedEvent)
  {
    int j = 0;
    if (!"uploadTreasury".equals(uploadId)) {
      return;
    }
    treasuryUpdateViewModel.isNewTreasury = false;
    treasuryUpdateViewModel.previewImage = new ImageModel(responseModel.getUrl("original"), 2130837812);
    treasuryUpdateViewModel.updateViewHolder();
    Object localObject2 = responseModel;
    paramSlideShareUploadFinishedEvent = tempTreasuryMediaBuilder;
    Object localObject1 = new MediaProxyImage.Builder().setUrl(((SlideShareResponse)localObject2).getUrl("original"));
    if ((availableSizes != null) && (availableSizes.original != null))
    {
      localObject2 = availableSizes.original;
      ((MediaProxyImage.Builder)localObject1).setOriginalWidth(Integer.valueOf(width));
      ((MediaProxyImage.Builder)localObject1).setOriginalHeight(Integer.valueOf(height));
    }
    try
    {
      localObject2 = new TreasuryMedia.Data.Builder();
      localObject1 = ((MediaProxyImage.Builder)localObject1).build(RecordTemplate.Flavor.RECORD);
      hasMediaProxyImageValue = true;
      mediaProxyImageValue = ((MediaProxyImage)localObject1);
      if (hasVideoValue) {
        j = 1;
      }
      int i = j;
      if (hasMediaProxyImageValue) {
        i = j + 1;
      }
      j = i;
      if (hasRichTextValue) {
        j = i + 1;
      }
      i = j;
      if (hasLinkValue) {
        i = j + 1;
      }
      if (i > 1) {
        throw new UnionMemberCountException("Data", i);
      }
    }
    catch (BuilderException paramSlideShareUploadFinishedEvent)
    {
      Util.safeThrow$7a8b4789(new IllegalArgumentException("treasury build failed" + paramSlideShareUploadFinishedEvent));
    }
    for (;;)
    {
      setEditSaveMenuItemEnabled(true);
      return;
      localObject1 = new TreasuryMedia.Data(videoValue, mediaProxyImageValue, richTextValue, linkValue, hasVideoValue, hasMediaProxyImageValue, hasRichTextValue, hasLinkValue);
      hasData = true;
      data = ((TreasuryMedia.Data)localObject1);
    }
  }
  
  @Subscribe
  public void onEvent(UploadFailedEvent paramUploadFailedEvent)
  {
    treasuryUpdateViewModel.isNewTreasury = false;
    treasuryUpdateViewModel.updateViewHolder();
    new AlertDialog.Builder(getActivity()).setTitle(error.toString()).show();
  }
  
  protected final void optimisticLockingUpdateForm() {}
  
  public final String pageKey()
  {
    return "profile_self_edit_treasury";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    Object localObject = getArguments();
    treasuryMedia = ((TreasuryMedia)RecordParceler.quietUnparcel(TreasuryMedia.BUILDER, "treasuryData", (Bundle)localObject));
    localObject = (Uri)((Bundle)localObject).getParcelable("treasuryUri");
    super.setFragmentData(paramBundle);
    TreasuryUpdateViewModel localTreasuryUpdateViewModel;
    if (treasuryMedia != null)
    {
      localObject = fragmentComponent;
      paramBundle = treasuryMedia;
      localTreasuryUpdateViewModel = new TreasuryUpdateViewModel();
      isNewTreasury = false;
      if (customTitle != null)
      {
        title = customTitle;
        if (customDescription == null) {
          break label327;
        }
        description = customDescription;
        label98:
        if (!hasData) {
          break label532;
        }
        if ((!data.hasLinkValue) || (!data.linkValue.hasPreviewImages)) {
          break label345;
        }
        paramBundle = new ImageModel((MediaProxyImage)data.linkValue.previewImages.get(0));
      }
    }
    for (;;)
    {
      label155:
      previewImage = paramBundle;
      onFieldEdited = new TreasuryTransformer.3((FragmentComponent)localObject);
      treasuryUpdateViewModel = localTreasuryUpdateViewModel;
      tempTreasuryMediaBuilder = new TreasuryMedia.Builder(treasuryMedia);
      for (;;)
      {
        treasuryMedias = getDataProviderstate).modifiedTreasuryList;
        paramBundle = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(paramBundle);
        arrayAdapter = new ViewModelArrayAdapter(getActivity(), applicationComponent.mediaCenter(), null);
        recyclerView.setAdapter(arrayAdapter);
        paramBundle = new ArrayList();
        paramBundle.add(treasuryUpdateViewModel);
        paramBundle.add(EditComponentTransformer.toDeleteButtonViewModel(false, 4, fragmentComponent));
        arrayAdapter.setValues(paramBundle);
        return;
        if (title == null) {
          break;
        }
        title = title;
        break;
        label327:
        if (description == null) {
          break label98;
        }
        description = description;
        break label98;
        label345:
        if ((data.hasVideoValue) && (data.videoValue.hasPreviewImages))
        {
          paramBundle = new ImageModel((MediaProxyImage)data.videoValue.previewImages.get(0));
          break label155;
        }
        if ((data.hasRichTextValue) && (data.richTextValue.hasPreviewImages))
        {
          paramBundle = new ImageModel((MediaProxyImage)data.richTextValue.previewImages.get(0));
          break label155;
        }
        if (!data.hasMediaProxyImageValue) {
          break label532;
        }
        paramBundle = new ImageModel(data.mediaProxyImageValue);
        break label155;
        if (localObject != null)
        {
          treasuryUpdateViewModel = TreasuryTransformer.toTreasuryUpdateViewModel(fragmentComponent, (Uri)localObject);
          tempTreasuryMediaBuilder = new TreasuryMedia.Builder();
          tempTreasuryMediaBuilder.setEntityUrn(ProfileUtil.getDummyMockUrn());
          mediaUploader.submitSlideShareUpload("uploadTreasury", (Uri)localObject, null, null);
        }
      }
      label532:
      paramBundle = null;
    }
  }
  
  protected final void updateProfileData()
  {
    try
    {
      TreasuryMedia localTreasuryMedia = getCurrentTreasury();
      if (treasuryMedia != null)
      {
        int i = treasuryMedias.indexOf(treasuryMedia);
        treasuryMedias.set(i, localTreasuryMedia);
        getDataProviderstate).modifiedTreasuryList = treasuryMedias;
      }
      for (;;)
      {
        goBackToPreviousFragment();
        return;
        treasuryMedias.add(localTreasuryMedia);
        getDataProviderstate).modifiedTreasuryList = treasuryMedias;
        getDataProviderstate).isTreasuryAdded = true;
      }
    }
    catch (BuilderException localBuilderException)
    {
      for (;;)
      {
        Log.d(TAG, "cannot build the updated treasury" + localBuilderException.getMessage());
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.treasury.ProfileTreasuryEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */