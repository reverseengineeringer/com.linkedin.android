package com.linkedin.android.growth.abi;

import android.text.TextUtils;
import android.view.View;
import com.linkedin.android.growth.abi.m2g.AbiGuestContactViewModel;
import com.linkedin.android.growth.abi.m2m.AbiMemberContactViewModel;
import com.linkedin.android.growth.abi.splash.AbiSocialProofSplashViewModel;
import com.linkedin.android.growth.abi.splash.AbiSplashBaseLegoWidget;
import com.linkedin.android.growth.abi.splash.MainAbiSplashViewModel;
import com.linkedin.android.growth.utils.ContactUtils;
import com.linkedin.android.growth.utils.GrowthLixHelper;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.MemberUtil;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.GuestContact.Handle;
import com.linkedin.android.pegasus.gen.voyager.growth.abi.MemberContact;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.connection.Connection;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.xmsg.util.StringUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class AbiTransformer
{
  private static String getFormattedName(String paramString1, String paramString2, I18NManager paramI18NManager, boolean paramBoolean)
  {
    if (paramString1 != null) {
      if (paramString2 == null) {
        break label47;
      }
    }
    for (;;)
    {
      paramString2 = paramI18NManager.getNamedString(2131231365, paramString1, paramString2, "");
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2))
      {
        if (!paramBoolean) {
          break label53;
        }
        paramString1 = paramI18NManager.getString(2131232803);
      }
      return paramString1;
      paramString1 = "";
      break;
      label47:
      paramString2 = "";
    }
    label53:
    return "";
  }
  
  private static void setUpContactInitialsForGuestModel(AbiGuestContactViewModel paramAbiGuestContactViewModel, GuestContact paramGuestContact)
  {
    shouldAddContactInitialsPicture = true;
    String str = firstName;
    paramGuestContact = lastName;
    contactInitials = (ContactUtils.toLatinInitial(str) + ContactUtils.toLatinInitial(paramGuestContact));
  }
  
  private static boolean shouldHighlight(int paramInt, AbiDataProvider paramAbiDataProvider)
  {
    return (state).shouldHighlightRecentContacts) && (paramInt < 3);
  }
  
  public static AbiSocialProofSplashViewModel toAbiSocialProofSplashViewModel(AbiSplashBaseLegoWidget paramAbiSplashBaseLegoWidget, FragmentComponent paramFragmentComponent, List<Connection> paramList)
  {
    AbiSocialProofSplashViewModel localAbiSocialProofSplashViewModel = new AbiSocialProofSplashViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    Object localObject2 = localI18NManager.getString(2131231375);
    MiniProfile localMiniProfile = paramFragmentComponent.memberUtil().getMiniProfile();
    Object localObject1 = localObject2;
    String str;
    if (localMiniProfile != null)
    {
      str = paramFragmentComponent.lixManager().getTreatment(Lix.LIX_ABI_TAKEOVER_SOCIALPROOF_COPY);
      if (!"v1".equalsIgnoreCase(str)) {
        break label153;
      }
      localObject1 = localI18NManager.getString(2131231382, new Object[] { I18NManager.getName(localMiniProfile) });
    }
    for (;;)
    {
      localObject2 = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localMiniProfile = nextminiProfile;
        if (hasPicture) {
          ((List)localObject2).add(localMiniProfile);
        }
      }
      label153:
      if ("v2".equalsIgnoreCase(str))
      {
        localObject1 = localI18NManager.getString(2131231383, new Object[] { I18NManager.getName(localMiniProfile) });
      }
      else
      {
        localObject1 = localObject2;
        if ("v3".equalsIgnoreCase(str)) {
          localObject1 = localI18NManager.getString(2131231384, new Object[] { I18NManager.getName(localMiniProfile) });
        }
      }
    }
    Collections.shuffle((List)localObject2);
    paramList = new ArrayList();
    int i = 0;
    while ((i < ((List)localObject2).size()) && (i < 5))
    {
      localMiniProfile = (MiniProfile)((List)localObject2).get(i);
      paramList.add(new ImageModel(picture, GhostImageUtils.getPerson(2131492967, localMiniProfile), Util.retrieveRumSessionId(paramFragmentComponent)));
      i += 1;
    }
    socialProofImages = paramList;
    if ((CollectionUtils.isNonEmpty(socialProofImages)) && (CollectionUtils.isNonEmpty((Collection)localObject2))) {}
    for (subheaderText = localI18NManager.getString(2131231385, new Object[] { I18NManager.getName((MiniProfile)((List)localObject2).get(0)) });; subheaderText = localI18NManager.getString(2131231386))
    {
      mainAbiSplashViewModel = toMainAbiSplashViewModel(paramAbiSplashBaseLegoWidget, paramFragmentComponent, (String)localObject1);
      return localAbiSocialProofSplashViewModel;
    }
  }
  
  private static AbiGuestContactViewModel toInviteGuestModel(final FragmentComponent paramFragmentComponent, final GuestContact paramGuestContact, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject = paramFragmentComponent.i18NManager();
    final AbiGuestContactViewModel localAbiGuestContactViewModel = new AbiGuestContactViewModel();
    boolean bool;
    int i;
    label43:
    int j;
    label56:
    label87:
    label132:
    String str;
    if (handle.phoneNumberValue != null)
    {
      bool = true;
      if (handle.phoneNumberValue == null) {
        break label261;
      }
      i = 1;
      if (handle.stringValue == null) {
        break label267;
      }
      j = 1;
      switch (paramInt)
      {
      default: 
        i = 0;
      case 1: 
        if (i == 0) {
          break label329;
        }
        isSmsContact = bool;
        switch (paramInt)
        {
        default: 
          paramInt = Integer.MIN_VALUE;
          invitationIconInternationalResource = paramInt;
          str = getFormattedName(firstName, lastName, (I18NManager)localObject, false);
          if (bool)
          {
            localObject = handle.phoneNumberValue.number;
            label171:
            if (!TextUtils.isEmpty(str)) {
              break label319;
            }
          }
          break;
        }
        break;
      }
    }
    label261:
    label267:
    label319:
    for (name = ((String)localObject);; name = str)
    {
      contactInfo = ((String)localObject);
      selected = paramBoolean1;
      shouldHighlight = paramBoolean2;
      onItemClickClosure = new TrackingClosure(paramFragmentComponent.tracker(), "invite") {};
      if (GrowthLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.GROWTH_ABI_M2G_INITIALS_IMAGE)) {
        setUpContactInitialsForGuestModel(localAbiGuestContactViewModel, paramGuestContact);
      }
      return localAbiGuestContactViewModel;
      bool = false;
      break;
      i = 0;
      break label43;
      j = 0;
      break label56;
      i = j;
      break label87;
      i = 1;
      break label87;
      paramInt = 2130838130;
      break label132;
      paramInt = 2130837998;
      break label132;
      paramInt = 2130837974;
      break label132;
      localObject = handle.stringValue;
      break label171;
    }
    label329:
    return null;
  }
  
  public static MainAbiSplashViewModel toMainAbiSplashViewModel(final AbiSplashBaseLegoWidget paramAbiSplashBaseLegoWidget, FragmentComponent paramFragmentComponent, String paramString)
  {
    MainAbiSplashViewModel localMainAbiSplashViewModel = new MainAbiSplashViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    headingText = paramString;
    disclaimerText = localI18NManager.getString(2131231374);
    learnMoreListener = new TrackingOnClickListener(paramFragmentComponent.tracker(), "learn_more", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        paramAbiSplashBaseLegoWidget.showLearnMoreFragment();
      }
    };
    return localMainAbiSplashViewModel;
  }
  
  public static List<AbiGuestContactViewModel> transformGuestModelCollection(FragmentComponent paramFragmentComponent, AbiDataProvider paramAbiDataProvider, int paramInt, List<GuestContact> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramList = Util.safeGet(paramList).iterator();
    while (paramList.hasNext())
    {
      Object localObject = (GuestContact)paramList.next();
      boolean bool = shouldHighlight(i, paramAbiDataProvider);
      localObject = toInviteGuestModel(paramFragmentComponent, (GuestContact)localObject, paramInt, paramAbiDataProvider.isGuestContactInvited((GuestContact)localObject), bool);
      if (localObject != null)
      {
        localArrayList.add(localObject);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  @Deprecated
  public static List<AbiGuestContactViewModel> transformGuestModelCollection(final FragmentComponent paramFragmentComponent, AbiDataProvider paramAbiDataProvider, boolean paramBoolean, List<GuestContact> paramList)
  {
    int i;
    if (GrowthLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.LIX_ABI_UNIFIED_SMS_EMAIL_FOR_M2G_SCREEN)) {
      if (paramBoolean)
      {
        i = 1;
        paramList = transformGuestModelCollection(paramFragmentComponent, paramAbiDataProvider, i, paramList);
      }
    }
    ArrayList localArrayList;
    Iterator localIterator;
    do
    {
      return paramList;
      i = 0;
      break;
      localArrayList = new ArrayList();
      i = 0;
      localIterator = Util.safeGet(paramList).iterator();
      paramList = localArrayList;
    } while (!localIterator.hasNext());
    final GuestContact localGuestContact = (GuestContact)localIterator.next();
    boolean bool2 = shouldHighlight(i, paramAbiDataProvider);
    boolean bool3 = paramAbiDataProvider.isGuestContactInvited(localGuestContact);
    if (GrowthLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.LIX_ABI_UNIFIED_SMS_EMAIL_FOR_M2G_SCREEN))
    {
      if (paramBoolean) {}
      for (int j = 1;; j = 0)
      {
        paramList = toInviteGuestModel(paramFragmentComponent, localGuestContact, j, bool3, bool2);
        label138:
        if (paramList == null) {
          break label340;
        }
        localArrayList.add(paramList);
        i += 1;
        break;
      }
    }
    paramList = paramFragmentComponent.i18NManager();
    final AbiGuestContactViewModel localAbiGuestContactViewModel = new AbiGuestContactViewModel();
    if (handle.phoneNumberValue != null) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      isSmsContact = bool1;
      if (bool1 == paramBoolean) {
        break label220;
      }
      paramList = null;
      break;
    }
    label220:
    String str = getFormattedName(firstName, lastName, paramList, false);
    if (bool1)
    {
      paramList = handle.phoneNumberValue.number;
      label254:
      if (!StringUtils.isBlank(str)) {
        break label354;
      }
    }
    label340:
    label354:
    for (name = paramList;; name = str)
    {
      contactInfo = paramList;
      selected = bool3;
      shouldHighlight = bool2;
      onItemClickClosure = new TrackingClosure(paramFragmentComponent.tracker(), "invite") {};
      if (GrowthLixHelper.isEnabled(paramFragmentComponent.lixManager(), Lix.GROWTH_ABI_M2G_INITIALS_IMAGE)) {
        setUpContactInitialsForGuestModel(localAbiGuestContactViewModel, localGuestContact);
      }
      paramList = localAbiGuestContactViewModel;
      break label138;
      break;
      paramList = handle.stringValue;
      break label254;
    }
  }
  
  public static List<AbiMemberContactViewModel> transformMemberModelCollection(final FragmentComponent paramFragmentComponent, AbiDataProvider paramAbiDataProvider, List<MemberContact> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    paramList = Util.safeGet(paramList).iterator();
    if (paramList.hasNext())
    {
      final MemberContact localMemberContact = (MemberContact)paramList.next();
      boolean bool2 = shouldHighlight(i, paramAbiDataProvider);
      if ((localMemberContact != null) && (invitedMembers.contains(AbiDataProvider.getMemberUniqueIdentifier(localMemberContact)))) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        I18NManager localI18NManager = paramFragmentComponent.i18NManager();
        final AbiMemberContactViewModel localAbiMemberContactViewModel = new AbiMemberContactViewModel();
        MiniProfile localMiniProfile = miniProfile;
        name = getFormattedName(firstName, lastName, localI18NManager, true);
        headline = occupation;
        picture = new ImageModel(picture, GhostImageUtils.getPerson(2131492963, localMiniProfile), Util.retrieveRumSessionId(paramFragmentComponent));
        selected = bool1;
        shouldHighlight = bool2;
        onItemClickClosure = new TrackingClosure(paramFragmentComponent.tracker(), "connect") {};
        localArrayList.add(localAbiMemberContactViewModel);
        i += 1;
        break;
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.abi.AbiTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */