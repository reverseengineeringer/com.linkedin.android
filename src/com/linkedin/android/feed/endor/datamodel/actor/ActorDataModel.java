package com.linkedin.android.feed.endor.datamodel.actor;

import android.widget.ImageView.ScaleType;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.common.Image;

public abstract class ActorDataModel<ACTOR_METADATA>
{
  public String actorUrn;
  public Image backgroundImage;
  public int followerCount;
  public boolean following;
  public FollowingInfo followingInfo;
  public String formattedHeadline;
  public ImageModel formattedImage;
  public String formattedName;
  public String i18nActorType;
  public String id;
  public Image image;
  public ACTOR_METADATA metadata;
  public String name;
  public boolean showFollowAction;
  public int type;
  
  public ActorDataModel(ACTOR_METADATA paramACTOR_METADATA, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, Image paramImage1, Image paramImage2, FollowingInfo paramFollowingInfo, boolean paramBoolean, Urn paramUrn, String paramString6)
  {
    metadata = paramACTOR_METADATA;
    id = paramString2;
    type = paramInt;
    i18nActorType = paramString1;
    formattedName = paramString3;
    formattedHeadline = paramString4;
    name = paramString5;
    image = paramImage1;
    backgroundImage = paramImage2;
    followingInfo = paramFollowingInfo;
    boolean bool;
    if ((paramFollowingInfo != null) && (following))
    {
      bool = true;
      following = bool;
      if ((paramFollowingInfo == null) || (!hasFollowerCount)) {
        break label159;
      }
      followerCount = followerCount;
      label105:
      if ((!paramBoolean) || (paramFollowingInfo == null)) {
        break label167;
      }
      paramBoolean = true;
      label118:
      showFollowAction = paramBoolean;
      if (paramUrn == null) {
        break label173;
      }
    }
    label159:
    label167:
    label173:
    for (paramACTOR_METADATA = paramUrn.toString();; paramACTOR_METADATA = null)
    {
      actorUrn = paramACTOR_METADATA;
      formattedImage = makeFormattedImage(2131492962, paramString6);
      return;
      bool = false;
      break;
      followerCount = -1;
      break label105;
      paramBoolean = false;
      break label118;
    }
  }
  
  public static void prepareImageViewHolderForActor(int paramInt, LiImageView paramLiImageView, boolean paramBoolean)
  {
    paramLiImageView.setImageDrawable(null);
    paramLiImageView.setOnClickListener(null);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramLiImageView.setVisibility(i);
      switch (paramInt)
      {
      default: 
        return;
      }
    }
    paramLiImageView.setOval(true);
    paramLiImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    return;
    paramLiImageView.setOval(false);
    paramLiImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
  }
  
  public abstract ImageModel makeFormattedImage(int paramInt, String paramString);
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.datamodel.actor.ActorDataModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */