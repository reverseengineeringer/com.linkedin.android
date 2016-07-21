package com.linkedin.messengerlib.viewmodel;

import android.util.Log;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.Conversation;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedMember;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipient;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientList;
import com.linkedin.android.pegasus.gen.voyager.messaging.peripheral.recipientsuggestions.SuggestedRecipientProfile;
import com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.MessagingTypeaheadResult;
import com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.MessagingTypeaheadResult.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.messaging.typeahead.ThreadTypeaheadResult;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile;
import com.linkedin.messengerlib.utils.I18NManager;
import com.linkedin.messengerlib.utils.MiniProfileUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ViewModelTransformer
{
  private static final String TAG = ViewModelTransformer.class.getSimpleName();
  
  public static List<MiniProfile> flattenPeopleViewModels(List<ViewModel> paramList)
  {
    return flattenViewModelsByClass(paramList, PeopleViewModel.class);
  }
  
  public static <T> List<T> flattenViewModelsByClass(List<ViewModel> paramList, Class<? extends ViewModel<T>> paramClass)
  {
    if (paramList.isEmpty())
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (ViewModel)localIterator.next();
      if (paramClass.isInstance(paramList)) {
        localArrayList.add(castdelegateObject);
      }
    }
  }
  
  public static List<ViewModel> fromMessagingTypeaheadToViewModel(List<MessagingTypeaheadResult> paramList, I18NManager paramI18NManager, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (MessagingTypeaheadResult)localIterator.next();
      if (hitInfo.typeaheadHitValue != null)
      {
        paramList = hitInfo.typeaheadHitValue;
        if ((paramList != null) && (hitInfo != null) && (hitInfo.typeaheadProfileValue != null)) {}
        for (paramList = hitInfo.typeaheadProfileValue.miniProfile;; paramList = null)
        {
          if (paramList == null) {
            break label120;
          }
          localArrayList.add(new PeopleViewModel(paramList, paramI18NManager, paramBoolean));
          break;
        }
      }
      else
      {
        label120:
        if (hitInfo.threadTypeaheadResultValue != null)
        {
          paramList = hitInfo.threadTypeaheadResultValue.conversation;
          localArrayList.add(new GroupViewModel(paramList, paramI18NManager, paramBoolean));
          Log.e(TAG, "Thread typeahead title: " + name);
        }
      }
    }
    return localArrayList;
  }
  
  public static List<ViewModel> fromMiniProfileToViewModels$18a2b177(List<MiniProfile> paramList, I18NManager paramI18NManager)
  {
    if (paramList.isEmpty())
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = (MiniProfile)localIterator.next();
      if (paramList != null) {
        localArrayList.add(new PeopleViewModel(paramList, paramI18NManager, false));
      }
    }
  }
  
  public static List<ViewModel> fromProfileStringToDelegates(List<String> paramList, I18NManager paramI18NManager, boolean paramBoolean)
  {
    if (paramList == null)
    {
      paramList = Collections.emptyList();
      return paramList;
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      paramList = localArrayList;
      if (!localIterator.hasNext()) {
        break;
      }
      paramList = MiniProfileUtil.getMiniProfileFromJsonString((String)localIterator.next());
      if (paramList != null) {
        localArrayList.add(new PeopleViewModel(paramList, paramI18NManager, paramBoolean));
      }
    }
  }
  
  public static List<ViewModel> fromSuggestedRecipientToViewModel(List<SuggestedRecipientList> paramList, I18NManager paramI18NManager)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      fromSuggestedRecipientToViewModel((SuggestedRecipientList)paramList.next(), paramI18NManager, localArrayList);
    }
    return localArrayList;
  }
  
  private static void fromSuggestedRecipientToViewModel(SuggestedRecipientList paramSuggestedRecipientList, I18NManager paramI18NManager, List<ViewModel> paramList)
  {
    paramList.add(new HeaderViewModel(title));
    paramSuggestedRecipientList = suggestedRecipients.iterator();
    while (paramSuggestedRecipientList.hasNext())
    {
      SuggestedMember localSuggestedMember = nextsuggestedRecipientProfile.suggestedMemberValue;
      if (localSuggestedMember != null) {
        paramList.add(new PeopleViewModel(miniProfile, paramI18NManager, true));
      }
    }
  }
  
  public static List<ViewModel> fromTypeaheadHitListToViewModel(List<TypeaheadHit> paramList, I18NManager paramI18NManager, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TypeaheadHit localTypeaheadHit = (TypeaheadHit)paramList.next();
      if ((hitInfo != null) && (hitInfo.typeaheadProfileValue != null)) {
        localArrayList.add(new PeopleViewModel(hitInfo.typeaheadProfileValue.miniProfile, paramI18NManager, paramBoolean));
      }
    }
    return localArrayList;
  }
  
  public static ViewModel getFirstViewModel(List<ViewModel> paramList, ViewModel.Filter paramFilter)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ViewModel localViewModel = (ViewModel)paramList.next();
      if (paramFilter.filter(localViewModel)) {
        return localViewModel;
      }
    }
    return null;
  }
  
  public static String getTrackingsForAdd(ViewModel paramViewModel, boolean paramBoolean)
  {
    if ((paramViewModel instanceof PeopleViewModel))
    {
      if (paramBoolean) {
        return "quick_add";
      }
      return "search_add";
    }
    if ((paramViewModel instanceof GroupViewModel))
    {
      if (paramBoolean) {
        return "quick_add_group";
      }
      return "search_add_group";
    }
    return null;
  }
  
  public static void setSelectableViewModelDisableValue(boolean paramBoolean, List<ViewModel> paramList, ViewModel.Filter paramFilter)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ViewModel localViewModel = (ViewModel)paramList.next();
      if ((paramFilter.filter(localViewModel)) && ((localViewModel instanceof SelectableViewModel))) {
        disabled = paramBoolean;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.messengerlib.viewmodel.ViewModelTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */