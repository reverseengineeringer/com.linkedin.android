package com.linkedin.android.identity.guidededit.pendingendorsement;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.TrackableFragment;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.CoreSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.Endorsement;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorserMiniProfile;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.PendingEndorsedSkill;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class PendingEndorsedSkillsTransformer
{
  private static View.OnClickListener buildAcceptButtonListner(PendingEndorsedSkillViewModel paramPendingEndorsedSkillViewModel, PendingEndorsedSkillsCardFragment paramPendingEndorsedSkillsCardFragment)
  {
    try
    {
      paramPendingEndorsedSkillViewModel = new PendingEndorsedSkillsTransformer.1(tracker, "pending_endorsements:accept", new TrackingEventBuilder[0], paramPendingEndorsedSkillViewModel, paramPendingEndorsedSkillsCardFragment);
      return paramPendingEndorsedSkillViewModel;
    }
    finally
    {
      paramPendingEndorsedSkillViewModel = finally;
      throw paramPendingEndorsedSkillViewModel;
    }
  }
  
  private static View.OnClickListener buildRejectButtonListner(PendingEndorsedSkillViewModel paramPendingEndorsedSkillViewModel, PendingEndorsedSkillsCardFragment paramPendingEndorsedSkillsCardFragment)
  {
    try
    {
      paramPendingEndorsedSkillViewModel = new PendingEndorsedSkillsTransformer.2(tracker, "pending_endorsements:reject", new TrackingEventBuilder[0], paramPendingEndorsedSkillViewModel, paramPendingEndorsedSkillsCardFragment);
      return paramPendingEndorsedSkillViewModel;
    }
    finally
    {
      paramPendingEndorsedSkillViewModel = finally;
      throw paramPendingEndorsedSkillViewModel;
    }
  }
  
  private static void setMessageView(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    paramViewHolder = ((ViewGroup)itemView).findViewById(paramInt);
    if (paramViewHolder == null) {
      throw new IllegalStateException("View " + paramInt + "message view should exist.");
    }
    paramViewHolder.setVisibility(0);
  }
  
  public static List<PendingEndorsedSkillViewModel> toViewModelList(List<PendingEndorsedSkill> paramList, PendingEndorsedSkillsCardFragment paramPendingEndorsedSkillsCardFragment)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      paramList = (PendingEndorsedSkill)localIterator.next();
      PendingEndorsedSkillViewModel localPendingEndorsedSkillViewModel = new PendingEndorsedSkillViewModel();
      skillName = skill.name;
      endorsements = endorsements;
      rumSessionId = Util.retrieveRumSessionId(fragmentComponent);
      acceptButtonListener = buildAcceptButtonListner(localPendingEndorsedSkillViewModel, paramPendingEndorsedSkillsCardFragment);
      rejectButtonListener = buildRejectButtonListner(localPendingEndorsedSkillViewModel, paramPendingEndorsedSkillsCardFragment);
      Object localObject = (Endorsement)endorsements.get(0);
      int i = endorsementCount;
      paramList = endorser.miniProfile;
      localObject = i18NManager;
      if (i > 2) {
        paramList = ((I18NManager)localObject).getString(2131233028, new Object[] { I18NManager.getName(paramList), Integer.valueOf(i - 1) });
      }
      for (;;)
      {
        endorsersSubhead = paramList;
        localArrayList.add(localPendingEndorsedSkillViewModel);
        break;
        if (i == 2) {
          paramList = ((I18NManager)localObject).getString(2131233029, new Object[] { I18NManager.getName(paramList) });
        } else {
          paramList = ((I18NManager)localObject).getString(2131233027, new Object[] { I18NManager.getName(paramList) });
        }
      }
    }
    return localArrayList;
  }
  
  public static enum PendingEndorsementsAction
  {
    ACCEPT,  REJECT;
    
    private PendingEndorsementsAction() {}
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.guidededit.pendingendorsement.PendingEndorsedSkillsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */