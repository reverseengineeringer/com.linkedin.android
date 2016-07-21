package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.pegasus.gen.voyager.identity.me.Endorsement;
import java.util.Iterator;
import java.util.List;

public class PendingEndorsementActivity
  extends BaseActivity
  implements PendingEndorsedSkillsFragmentListener, PendingEndorsementsEndorserListener
{
  private PendingEndorsementFragment currentFragment;
  private boolean isEndorserCardInvisible;
  private boolean isEndorserDataReceived;
  private boolean isSkillsCardInvisible;
  private boolean isSkillsDataReceived;
  
  private void updatePendingEndorsementsPage()
  {
    if (!isResumed) {}
    Object localObject;
    do
    {
      do
      {
        return;
        if ((isSkillsCardInvisible) && (isEndorserCardInvisible))
        {
          localObject = PendingEndorsementNullStateFragment.newInstance(PendingEndorsementBundleBuilder.create());
          getSupportFragmentManager().beginTransaction().replace(2131757145, (Fragment)localObject, null).commit();
        }
      } while ((!isEndorserDataReceived) || (!isSkillsDataReceived) || (!isSkillsCardInvisible) || (isEndorserCardInvisible) || (currentFragment == null));
      localObject = (PendingEndorsementsEndorserCardFragment)currentFragment.getChildFragmentManager().findFragmentById(2131757146);
    } while (localObject == null);
    new Handler().postDelayed(new PendingEndorsementsEndorserCardFragment.1((PendingEndorsementsEndorserCardFragment)localObject), 1L);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    activityComponent.inject(this);
    setContentView(2130968929);
    if (paramBundle == null)
    {
      paramBundle = PendingEndorsementFragment.newInstance(PendingEndorsementBundleBuilder.create());
      currentFragment = paramBundle;
      getSupportFragmentManager().beginTransaction().add(2131756509, paramBundle, PendingEndorsementFragment.TAG).commit();
    }
  }
  
  public final void onEndorserCardVisibilityChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      isEndorserCardInvisible = paramBoolean;
      updatePendingEndorsementsPage();
      return;
    }
  }
  
  public final void onEndorserDataReceived()
  {
    isEndorserDataReceived = true;
    updatePendingEndorsementsPage();
  }
  
  public final void onPendingEndorsedSkillAction$2e9a7015(String paramString)
  {
    if (currentFragment != null)
    {
      PendingEndorsementsEndorserCardFragment localPendingEndorsementsEndorserCardFragment = (PendingEndorsementsEndorserCardFragment)currentFragment.getChildFragmentManager().findFragmentById(2131757146);
      if ((localPendingEndorsementsEndorserCardFragment != null) && (pendingEndorsementsEndorserCardView.getVisibility() == 0))
      {
        List localList = localPendingEndorsementsEndorserCardFragment.getDataProvider().getPendingEndorsements();
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext()) {
          if (TextUtils.equals(nextskill, paramString)) {
            if (localList.size() <= 1) {
              localPendingEndorsementsEndorserCardFragment.toggleVisibility(false);
            } else {
              localPendingEndorsementsEndorserCardFragment.fetchPendingEndorsementsEndorser();
            }
          }
        }
      }
    }
  }
  
  public final void onSkillsCardVisibilityChanged(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      isSkillsCardInvisible = paramBoolean;
      updatePendingEndorsementsPage();
      return;
    }
  }
  
  public final void onSkillsDataReceived()
  {
    isSkillsDataReceived = true;
    updatePendingEndorsementsPage();
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsementActivity
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */