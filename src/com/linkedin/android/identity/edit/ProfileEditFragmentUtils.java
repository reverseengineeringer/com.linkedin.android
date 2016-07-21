package com.linkedin.android.identity.edit;

import android.net.Uri;
import com.linkedin.android.identity.profile.view.ProfileViewListener;
import com.linkedin.android.identity.shared.ProfileEditPhotoCropBundleBuilder;
import com.linkedin.android.identity.shared.ProfileEditPhotoCropFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.EndorsedSkill;
import com.linkedin.android.pegasus.gen.voyager.identity.profile.ProfileContactInfo;

public final class ProfileEditFragmentUtils
{
  public static void startAddCertification(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfileCertificationEditFragment.newInstance(new ProfileCertificationEditBundleBuilder()));
  }
  
  public static void startAddCertification(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfileCertificationEditFragment.newInstance(new ProfileCertificationEditBundleBuilder()));
  }
  
  public static void startAddCourse(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfileCourseEditFragment.newInstance(new ProfileCourseEditBundleBuilder()));
  }
  
  public static void startAddCourse(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfileCourseEditFragment.newInstance(new ProfileCourseEditBundleBuilder(), paramProfileViewListener));
  }
  
  public static void startAddEducation(ProfileEditListener paramProfileEditListener, boolean paramBoolean)
  {
    ProfileEducationEditBundleBuilder localProfileEducationEditBundleBuilder = new ProfileEducationEditBundleBuilder();
    localProfileEducationEditBundleBuilder.setResetDataAfterSave(paramBoolean);
    paramProfileEditListener.startEditFragment(ProfileEducationEditFragment.newInstance(localProfileEducationEditBundleBuilder));
  }
  
  public static void startAddEducation(ProfileViewListener paramProfileViewListener, boolean paramBoolean, FragmentComponent paramFragmentComponent)
  {
    ProfileEducationEditBundleBuilder localProfileEducationEditBundleBuilder = new ProfileEducationEditBundleBuilder();
    localProfileEducationEditBundleBuilder.setResetDataAfterSave(paramBoolean);
    if ("enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_EDUCATION_V2)))
    {
      paramProfileViewListener.startEditFragment(ProfileEducationEditFragmentV2.newInstance(localProfileEducationEditBundleBuilder));
      return;
    }
    paramProfileViewListener.startEditFragment(ProfileEducationEditFragment.newInstance(localProfileEducationEditBundleBuilder));
  }
  
  public static void startAddHonor(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfileHonorEditFragment.newInstance(new ProfileHonorEditBundleBuilder()));
  }
  
  public static void startAddHonor(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfileHonorEditFragment.newInstance(new ProfileHonorEditBundleBuilder()));
  }
  
  public static void startAddPatent(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfilePatentEditFragment.newInstance(new ProfilePatentEditBundleBuilder()));
  }
  
  public static void startAddPatent(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfilePatentEditFragment.newInstance(new ProfilePatentEditBundleBuilder()));
  }
  
  public static void startAddPosition(ProfileEditListener paramProfileEditListener, boolean paramBoolean)
  {
    ProfilePositionEditBundleBuilder localProfilePositionEditBundleBuilder = new ProfilePositionEditBundleBuilder();
    localProfilePositionEditBundleBuilder.setResetDataAfterSave(paramBoolean);
    paramProfileEditListener.startEditFragment(ProfilePositionEditFragment.newInstance(localProfilePositionEditBundleBuilder));
  }
  
  public static void startAddPosition(ProfileViewListener paramProfileViewListener, boolean paramBoolean, FragmentComponent paramFragmentComponent)
  {
    ProfilePositionEditBundleBuilder localProfilePositionEditBundleBuilder = new ProfilePositionEditBundleBuilder();
    localProfilePositionEditBundleBuilder.setResetDataAfterSave(paramBoolean);
    if ("enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.PROFILE_EDIT_POSITION_V2)))
    {
      paramProfileViewListener.startEditFragment(ProfilePositionEditFragmentV2.newInstance(localProfilePositionEditBundleBuilder));
      return;
    }
    paramProfileViewListener.startEditFragment(ProfilePositionEditFragment.newInstance(localProfilePositionEditBundleBuilder));
  }
  
  public static void startAddProject(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfileProjectEditFragment.newInstance(new ProfileProjectEditBundleBuilder()));
  }
  
  public static void startAddProject(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfileProjectEditFragment.newInstance(new ProfileProjectEditBundleBuilder()));
  }
  
  public static void startAddPublication(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfilePublicationEditFragment.newInstance(new ProfilePublicationEditBundleBuilder()));
  }
  
  public static void startAddPublication(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfilePublicationEditFragment.newInstance(new ProfilePublicationEditBundleBuilder()));
  }
  
  public static void startAddVolunteerExperience(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfileVolunteeringExperienceEditFragment.newInstance(new ProfileVolunteeringExperienceEditBundleBuilder()));
  }
  
  public static void startAddVolunteerExperience(ProfileViewListener paramProfileViewListener)
  {
    paramProfileViewListener.startEditFragment(ProfileVolunteeringExperienceEditFragment.newInstance(new ProfileVolunteeringExperienceEditBundleBuilder()));
  }
  
  public static void startEditBasicProfile(ProfileEditListener paramProfileEditListener)
  {
    paramProfileEditListener.startEditFragment(ProfileBasicInfoEditFragment.newInstance(new ProfileBasicInfoEditBundleBuilder()));
  }
  
  public static void startEditBasicProfile(ProfileEditListener paramProfileEditListener, ProfileBasicInfoEditBundleBuilder.Focus paramFocus)
  {
    ProfileBasicInfoEditBundleBuilder localProfileBasicInfoEditBundleBuilder = new ProfileBasicInfoEditBundleBuilder();
    localProfileBasicInfoEditBundleBuilder.setFocus(paramFocus);
    paramProfileEditListener.startEditFragment(ProfileBasicInfoEditFragment.newInstance(localProfileBasicInfoEditBundleBuilder));
  }
  
  public static void startEditBasicProfile(ProfileViewListener paramProfileViewListener, ProfileBasicInfoEditBundleBuilder.Focus paramFocus)
  {
    ProfileBasicInfoEditBundleBuilder localProfileBasicInfoEditBundleBuilder = new ProfileBasicInfoEditBundleBuilder();
    localProfileBasicInfoEditBundleBuilder.setFocus(paramFocus);
    paramProfileViewListener.startEditFragment(ProfileBasicInfoEditFragment.newInstance(localProfileBasicInfoEditBundleBuilder));
  }
  
  public static void startEditContactInfo(ProfileEditListener paramProfileEditListener, ProfileContactInfo paramProfileContactInfo)
  {
    ProfileContactInfoEditBundleBuilder.Focus localFocus = ProfileContactInfoEditBundleBuilder.Focus.NONE;
    paramProfileEditListener.startEditFragment(ProfileContactInfoEditFragment.newInstance(new ProfileContactInfoEditBundleBuilder().setContactInfo(paramProfileContactInfo).setFocus(localFocus)));
  }
  
  public static void startEditContactInfo(ProfileViewListener paramProfileViewListener, ProfileContactInfo paramProfileContactInfo)
  {
    ProfileContactInfoEditBundleBuilder.Focus localFocus = ProfileContactInfoEditBundleBuilder.Focus.NONE;
    paramProfileViewListener.startEditFragment(ProfileContactInfoEditFragment.newInstance(new ProfileContactInfoEditBundleBuilder().setContactInfo(paramProfileContactInfo).setFocus(localFocus)));
  }
  
  public static void startEditEndorsements(ProfileEditListener paramProfileEditListener, EndorsedSkill paramEndorsedSkill)
  {
    ProfileEndorsementsEditBundleBuilder localProfileEndorsementsEditBundleBuilder = new ProfileEndorsementsEditBundleBuilder();
    localProfileEndorsementsEditBundleBuilder.setEndorsedSkill(paramEndorsedSkill);
    paramProfileEditListener.startEditFragment(ProfileEndorsementsEditFragment.newInstance(localProfileEndorsementsEditBundleBuilder));
  }
  
  public static void startEditEndorsements(ProfileViewListener paramProfileViewListener, EndorsedSkill paramEndorsedSkill)
  {
    ProfileEndorsementsEditBundleBuilder localProfileEndorsementsEditBundleBuilder = new ProfileEndorsementsEditBundleBuilder();
    localProfileEndorsementsEditBundleBuilder.setEndorsedSkill(paramEndorsedSkill);
    paramProfileViewListener.startEditFragment(ProfileEndorsementsEditFragment.newInstance(localProfileEndorsementsEditBundleBuilder));
  }
  
  public static void startEditFeaturedSkills(ProfileEditListener paramProfileEditListener, boolean paramBoolean)
  {
    ProfileSkillsEditBundleBuilder localProfileSkillsEditBundleBuilder = new ProfileSkillsEditBundleBuilder();
    localProfileSkillsEditBundleBuilder.setDefaultInEditMode(paramBoolean);
    paramProfileEditListener.startEditFragment(ProfileSkillsEditFragmentV2.newInstance(localProfileSkillsEditBundleBuilder));
  }
  
  public static void startEditFeaturedSkills(ProfileViewListener paramProfileViewListener, boolean paramBoolean)
  {
    ProfileSkillsEditBundleBuilder localProfileSkillsEditBundleBuilder = new ProfileSkillsEditBundleBuilder();
    localProfileSkillsEditBundleBuilder.setDefaultInEditMode(paramBoolean);
    paramProfileViewListener.startEditFragment(ProfileSkillsEditFragmentV2.newInstance(localProfileSkillsEditBundleBuilder));
  }
  
  public static void startEditPhoto(ProfileEditListener paramProfileEditListener, Uri paramUri)
  {
    paramProfileEditListener.startEditFragment(ProfileEditPhotoCropFragment.newInstance(ProfileEditPhotoCropBundleBuilder.create(paramUri)));
  }
  
  public static void startEditPhoto(ProfileViewListener paramProfileViewListener, Uri paramUri)
  {
    paramProfileViewListener.startEditFragment(ProfileEditPhotoCropFragment.newInstance(ProfileEditPhotoCropBundleBuilder.create(paramUri)));
  }
  
  public static void startEditSkills(ProfileEditListener paramProfileEditListener, boolean paramBoolean)
  {
    ProfileSkillsEditBundleBuilder localProfileSkillsEditBundleBuilder = new ProfileSkillsEditBundleBuilder();
    localProfileSkillsEditBundleBuilder.setDefaultInEditMode(paramBoolean);
    paramProfileEditListener.startEditFragment(ProfileSkillsEditFragment.newInstance(localProfileSkillsEditBundleBuilder));
  }
  
  public static void startEditSkills(ProfileViewListener paramProfileViewListener, boolean paramBoolean)
  {
    ProfileSkillsEditBundleBuilder localProfileSkillsEditBundleBuilder = new ProfileSkillsEditBundleBuilder();
    localProfileSkillsEditBundleBuilder.setDefaultInEditMode(paramBoolean);
    paramProfileViewListener.startEditFragment(ProfileSkillsEditFragment.newInstance(localProfileSkillsEditBundleBuilder));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.identity.edit.ProfileEditFragmentUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */