package com.linkedin.android.feed.mentions;

import android.text.Spanned;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.feed.Comment;
import com.linkedin.android.pegasus.gen.voyager.feed.CompanyActor;
import com.linkedin.android.pegasus.gen.voyager.feed.MemberActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SchoolActor;
import com.linkedin.android.pegasus.gen.voyager.feed.SocialActor;
import com.linkedin.android.pegasus.gen.voyager.identity.shared.MiniProfile;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadCompany;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadProfile;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadSchool;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.spyglass.mentions.MentionSpan;
import com.linkedin.android.spyglass.mentions.Mentionable;
import com.linkedin.data.lite.BuilderException;
import java.util.ArrayList;
import java.util.List;

public final class MentionsUtils
{
  public static String getEntityUrn(TypeaheadHit.HitInfo paramHitInfo)
  {
    if (typeaheadProfileValue != null) {
      return typeaheadProfileValue.miniProfile.entityUrn.toString();
    }
    if (typeaheadCompanyValue != null) {
      return typeaheadCompanyValue.company.entityUrn.toString();
    }
    if (typeaheadSchoolValue != null) {
      return typeaheadSchoolValue.school.entityUrn.toString();
    }
    return null;
  }
  
  public static Mentionable getMentionable(FragmentComponent paramFragmentComponent, Comment paramComment)
  {
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    try
    {
      if (commenter.schoolActorValue != null) {
        return new SchoolMention(localI18NManager, commenter.schoolActorValue.miniSchool);
      }
      if (commenter.memberActorValue != null) {
        return new ProfileMention(localI18NManager, commenter.memberActorValue.miniProfile);
      }
      if (commenter.companyActorValue != null)
      {
        paramComment = new CompanyMention(localI18NManager, commenter.companyActorValue.miniCompany);
        return paramComment;
      }
    }
    catch (BuilderException paramComment)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramComment));
    }
    return null;
  }
  
  public static Mentionable getMentionable(FragmentComponent paramFragmentComponent, ClickEvent paramClickEvent)
  {
    Object localObject = clickedItem;
    int i = type;
    try
    {
      paramClickEvent = paramFragmentComponent.i18NManager();
      if ((i == 1) && ((localObject instanceof MiniProfile))) {
        return new ProfileMention(paramClickEvent, (MiniProfile)localObject);
      }
      if ((i == 3) && ((localObject instanceof MiniCompany))) {
        return new CompanyMention(paramClickEvent, (MiniCompany)localObject);
      }
      if ((i == 2) && ((localObject instanceof MiniSchool)))
      {
        paramClickEvent = new SchoolMention(paramClickEvent, (MiniSchool)localObject);
        return paramClickEvent;
      }
    }
    catch (BuilderException paramClickEvent)
    {
      paramFragmentComponent.context();
      Util.safeThrow$7a8b4789(new RuntimeException(paramClickEvent));
    }
    return null;
  }
  
  public static List<Mentionable> getMentionableList(CharSequence paramCharSequence)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramCharSequence instanceof Spanned))
    {
      paramCharSequence = (MentionSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), MentionSpan.class);
      int i = 0;
      while (i < paramCharSequence.length)
      {
        localArrayList.add(mention);
        i += 1;
      }
    }
    return localArrayList;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.mentions.MentionsUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */