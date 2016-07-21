package com.linkedin.android.identity.edit;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import butterknife.InjectView;
import com.linkedin.android.identity.shared.ProfileTypeahead;
import com.linkedin.android.identity.shared.ProfileTypeaheadResult;
import com.linkedin.android.identity.shared.ProfileUtil;
import com.linkedin.android.identity.shared.SwipeDeleteUndoHelper;
import com.linkedin.android.infra.IntentRegistry;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.DrawableHelper;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Contributor.Builder;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadType;
import com.linkedin.android.search.SearchBundleBuilder;
import com.linkedin.android.search.SearchIntent;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;

public class ProfileProjectMemberEditFragment
  extends ProfileEditBaseFragment
  implements ProfileEditBaseFragment.TypeaheadListener
{
  @Inject
  FragmentComponent fragmentComponent;
  @Inject
  IntentRegistry intentRegistry;
  private List<Contributor> listData;
  private ProfileProjectEditFragment.OnProjectMemberEditListener onProjectMemberEditListener = new ProfileProjectMemberEditFragment.1(this);
  @Inject
  ProfileUtil profileUtil;
  @InjectView(2131757505)
  RecyclerView recyclerView;
  private SwipeDeleteUndoHelper swipeDeleteUndoHelper;
  
  protected final void createMenu()
  {
    super.createMenu();
    toolbar.getMenu().removeItem(2131758751);
    toolbar.inflateMenu(2131820554);
    MenuItem localMenuItem = toolbar.getMenu().findItem(2131758752);
    localMenuItem.setIcon(DrawableHelper.setTint(localMenuItem.getIcon(), ContextCompat.getColor(getActivity(), 2131624058)));
  }
  
  protected final boolean enableProgressDialogOnUpdate()
  {
    return false;
  }
  
  public final String getCancelTrackingControlName()
  {
    return "";
  }
  
  protected final int getContentViewId()
  {
    return -1;
  }
  
  protected final int getContentViewResourceId()
  {
    return 2130969179;
  }
  
  protected final int getOptimisticLockingDeleteMessage()
  {
    return 2131233272;
  }
  
  public final String getSaveTrackingControlName()
  {
    return "";
  }
  
  public final String getTitle()
  {
    return i18NManager.getString(2131232539);
  }
  
  public final void handleTypeaheadResult(ProfileTypeaheadResult paramProfileTypeaheadResult)
  {
    if (typeahead == ProfileTypeahead.TYPEAHEAD_PICKER_PEOPLE)
    {
      Contributor localContributor = null;
      try
      {
        if (paramProfileTypeaheadResult.getMiniProfile() != null)
        {
          int j = 0;
          Iterator localIterator = listData.iterator();
          do
          {
            i = j;
            if (!localIterator.hasNext()) {
              break;
            }
          } while (!nextentityUrn.equals(urn));
          int i = 1;
          if (i != 0) {}
        }
        for (localContributor = new Contributor.Builder().setMember(paramProfileTypeaheadResult.getMiniProfile()).setEntityUrn(urn).build(RecordTemplate.Flavor.RECORD); localContributor != null; localContributor = new Contributor.Builder().setName(text).setEntityUrn(ProfileUtil.getMockUrn()).build(RecordTemplate.Flavor.RECORD))
        {
          listData.add(localContributor);
          recyclerView.getAdapter().notifyDataSetChanged();
          return;
        }
        return;
      }
      catch (BuilderException paramProfileTypeaheadResult)
      {
        Util.safeThrow(new RuntimeException("Failed to create Contributor object: " + paramProfileTypeaheadResult.getMessage()));
      }
    }
  }
  
  protected final void initializeFields()
  {
    setEditSaveMenuItemEnabled(true);
    ProfileProjectMemberEditFragment.2 local2 = new ProfileProjectMemberEditFragment.2(this);
    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    recyclerView.setAdapter(local2);
    swipeDeleteUndoHelper = new SwipeDeleteUndoHelper(2131232530, new ProfileProjectMemberEditFragment.3(this), fragmentComponent.tracker(), "background_details");
    swipeDeleteUndoHelper.attachToRecyclerView(recyclerView);
  }
  
  public final boolean isAnchorPage()
  {
    return true;
  }
  
  protected final boolean isFormModified()
  {
    return false;
  }
  
  protected final boolean isFormValid()
    throws BuilderException
  {
    return true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    fragmentComponent.inject(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    swipeDeleteUndoHelper.dismissUndoBar();
  }
  
  protected final boolean onMenuClick(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131758752)
    {
      startActivityForResult(intentRegistry.search.newIntent(getActivity(), SearchBundleBuilder.create().setPickerMode$6c621e23().setTypeaheadType(TypeaheadType.PEOPLE).setSearchBarHintText(getLocalizedString(2131232585)).setInputMaxLength$fdadbae().setFakeHitAtTop$6c621e23()), TYPEAHEAD_PICKER_PEOPLErequestId);
      return true;
    }
    return super.onMenuClick(paramMenuItem);
  }
  
  protected final void optimisticLockingUpdateForm() {}
  
  public final String pageKey()
  {
    return "profile_self_edit_projectmember";
  }
  
  protected final void setFragmentData(Bundle paramBundle)
    throws BuilderException
  {
    listData = ProfileProjectMemberBundleBuilder.getProjectMembers(getArguments());
    super.setFragmentData(paramBundle);
  }
  
  protected final void updateProfileData()
  {
    new ArrayList(listData);
    onProjectMemberEditListener = null;
    listData = null;
    onFormSubmitSuccess();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileProjectMemberEditFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */