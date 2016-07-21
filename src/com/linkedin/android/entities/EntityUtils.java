package com.linkedin.android.entities;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.TextUtils;
import com.linkedin.android.entities.viewmodels.cards.EntityFeedUpdateWrapperCardViewModel;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.fission.interfaces.FissileDataModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata.Builder;
import com.linkedin.android.pegasus.gen.voyager.common.GraphDistance;
import com.linkedin.android.pegasus.gen.voyager.common.MemberDistance;
import com.linkedin.android.pegasus.gen.voyager.entities.common.PagingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.EntitiesMiniProfile;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import java.util.Collections;
import java.util.List;

public final class EntityUtils
{
  public static void addObjectUrnIfNonNull(List<String> paramList, Urn paramUrn)
  {
    if (paramUrn != null) {
      paramList.add(paramUrn.toString());
    }
  }
  
  public static Drawable createButtonIcon(FragmentComponent paramFragmentComponent, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = ContextCompat.getDrawable(paramFragmentComponent.activity(), paramInt1);
    ColorStateList localColorStateList = ContextCompat.getColorStateList(paramFragmentComponent.activity(), paramInt2);
    paramFragmentComponent = localDrawable;
    if (localDrawable != null)
    {
      paramFragmentComponent = DrawableCompat.wrap(localDrawable);
      DrawableCompat.setTintList(paramFragmentComponent, localColorStateList);
    }
    return paramFragmentComponent;
  }
  
  public static <E extends FissileDataModel<E>> CollectionTemplate<E, com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata> createDefaultCollection(List<E> paramList, PagingInfo paramPagingInfo)
    throws BuilderException
  {
    com.linkedin.android.pegasus.gen.restli.common.CollectionMetadata localCollectionMetadata = null;
    if (paramPagingInfo != null) {
      localCollectionMetadata = new CollectionMetadata.Builder().setStart(Integer.valueOf(start)).setCount(Integer.valueOf(count)).setTotal(Integer.valueOf(total)).setLinks(Collections.emptyList()).build(RecordTemplate.Flavor.RECORD);
    }
    if (localCollectionMetadata != null) {}
    for (boolean bool = true;; bool = false) {
      return new CollectionTemplate(paramList, null, localCollectionMetadata, null, null, true, false, bool);
    }
  }
  
  public static String formatCompanyNameAndLocation(FragmentComponent paramFragmentComponent, String paramString1, String paramString2)
  {
    paramFragmentComponent = paramFragmentComponent.i18NManager();
    if ((paramString1 != null) && (paramString2 != null)) {
      paramFragmentComponent = paramFragmentComponent.getString(2131230956, new Object[] { paramString1, paramString2 });
    }
    do
    {
      return paramFragmentComponent;
      paramFragmentComponent = paramString1;
    } while (paramString1 != null);
    return paramString2;
  }
  
  public static String formatLocationAndFollowers(FragmentComponent paramFragmentComponent, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2)) {
      paramString = paramFragmentComponent.i18NManager().getString(2131230880, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    while (paramBoolean1) {
      return paramString;
    }
    return paramFragmentComponent.i18NManager().getString(2131230881, new Object[] { Integer.valueOf(paramInt) });
  }
  
  public static EntityFeedUpdateWrapperCardViewModel getFeedUpdateWrapperViewModel(List<ViewModel> paramList, String paramString)
  {
    int i = 0;
    while (i < paramList.size())
    {
      ViewModel localViewModel = (ViewModel)paramList.get(i);
      if (((localViewModel instanceof EntityFeedUpdateWrapperCardViewModel)) && (TextUtils.equals(feedUpdateViewModel.updateUrn, paramString))) {
        return (EntityFeedUpdateWrapperCardViewModel)localViewModel;
      }
      i += 1;
    }
    return null;
  }
  
  public static boolean isImmediateConnection(EntitiesMiniProfile paramEntitiesMiniProfile)
  {
    if (distance == null) {
      return false;
    }
    return distance.value.equals(GraphDistance.DISTANCE_1);
  }
  
  public static boolean isLixEnabled(LixManager paramLixManager, Lix paramLix)
  {
    return "enabled".equals(paramLixManager.getTreatment(paramLix));
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityUtils
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */