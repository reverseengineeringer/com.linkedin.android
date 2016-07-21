package com.linkedin.android.search.secondaryresults;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseIntArray;
import com.linkedin.android.infra.components.ActivityComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.lix.Lix;
import com.linkedin.android.infra.lix.LixManager;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.DateUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.LongClickUtil;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.GroupMembershipStatus;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniCompany;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniGroup;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.pegasus.gen.voyager.search.DiscussionActivityInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchCompany;
import com.linkedin.android.pegasus.gen.voyager.search.SearchGroup;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit;
import com.linkedin.android.pegasus.gen.voyager.search.SearchHit.HitInfo;
import com.linkedin.android.pegasus.gen.voyager.search.SearchJob;
import com.linkedin.android.pegasus.gen.voyager.search.SearchSchool;
import com.linkedin.android.pegasus.gen.voyager.search.SearchType;
import com.linkedin.android.search.FollowingInfoChangeListener;
import com.linkedin.android.search.SearchDataProvider;
import com.linkedin.android.search.searchengine.SearchEngineTransformer;
import com.linkedin.android.search.shared.SearchUtils;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;

public final class SecondaryResultsTransformer
{
  final SearchDataProvider dataProvider;
  public FollowingInfoChangeListener<SecondaryResultsViewModel> followingListener;
  private Handler handler = new Handler(Looper.getMainLooper());
  final I18NManager i18NManager;
  private final LongClickUtil longClickUtil;
  SecondaryResultsViewModel revealedViewModel;
  private Runnable revealedViewModelRunnable = new SecondaryResultsTransformer.1(this);
  
  @Inject
  public SecondaryResultsTransformer(ActivityComponent paramActivityComponent)
  {
    dataProvider = paramActivityComponent.searchDataProvider();
    i18NManager = paramActivityComponent.i18NManager();
    longClickUtil = paramActivityComponent.longClickUtil();
  }
  
  public static boolean isNewJobPosted(Long paramLong)
  {
    if (paramLong == null) {}
    long l1;
    long l2;
    do
    {
      return false;
      l1 = new Date().getTime();
      l2 = paramLong.longValue();
    } while (TimeUnit.MILLISECONDS.toDays(l1 - l2) != 0L);
    return true;
  }
  
  private void setUpRevealViewListeners(FragmentComponent paramFragmentComponent, SearchHit paramSearchHit, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, SecondaryResultsViewModel paramSecondaryResultsViewModel)
  {
    longClickListener = new SecondaryResultsTransformer.6(this, paramSecondaryResultsViewModel, paramFragmentComponent);
    ctaButtonListener = new SecondaryResultsTransformer.7(this, paramFragmentComponent.tracker(), paramFragmentComponent, paramSearchHit, paramSecondaryResultsViewModel, paramString1, paramInt1, paramInt2, paramString2, paramString3);
  }
  
  public final void startRevealViewModelRunnable(FragmentComponent paramFragmentComponent)
  {
    startRevealViewModelRunnable(paramFragmentComponent, 4000L);
  }
  
  public final void startRevealViewModelRunnable(FragmentComponent paramFragmentComponent, long paramLong)
  {
    if (revealedViewModel != null)
    {
      paramFragmentComponent.animationProxy();
      handler.postDelayed(revealedViewModelRunnable, paramLong);
    }
  }
  
  public final void stopRevealViewModelRunnable()
  {
    if (revealedViewModel != null) {
      handler.removeCallbacks(revealedViewModelRunnable);
    }
  }
  
  public final List<ViewModel> transformSecondaryResultsModelList(FragmentComponent paramFragmentComponent, String paramString1, List<SearchHit> paramList, int paramInt, SparseIntArray paramSparseIntArray, String paramString2, String paramString3)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    if (CollectionUtils.isEmpty(paramList))
    {
      localArrayList.add(SearchEngineTransformer.transformToEmptyResultViewModel(paramFragmentComponent));
      return localArrayList;
    }
    Iterator localIterator = paramList.iterator();
    label45:
    label186:
    label247:
    label266:
    label861:
    label1024:
    label1056:
    for (;;)
    {
      SearchHit localSearchHit;
      Object localObject1;
      if (localIterator.hasNext())
      {
        localSearchHit = (SearchHit)localIterator.next();
        paramList = hitInfo;
        if (searchJobValue == null) {
          break label266;
        }
        paramList = new SecondaryResultsViewModel();
        entityDescription = hitInfo.searchJobValue.companyName;
        localObject1 = hitInfo.searchJobValue.job;
        entityName = title;
        image = new ImageModel(logo, GhostImageUtils.getJob(2131492962, (MiniJob)localObject1), Util.retrieveRumSessionId(paramFragmentComponent));
        metadata = location;
        locationMetadata = true;
        if (!isNewJobPosted(Long.valueOf(listDate))) {
          break label247;
        }
        newPost = true;
        clickListener = new SecondaryResultsTransformer.2(this, paramFragmentComponent.tracker(), "search_srp_result", new TrackingEventBuilder[0], paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray, paramString2, paramString3, (MiniJob)localObject1);
      }
      for (;;)
      {
        if (paramList == null) {
          break label1056;
        }
        localArrayList.add(paramList);
        paramInt += 1;
        break label45;
        break;
        dateInfo = DateUtils.getTimestampText(listDate, i18NManager);
        break label186;
        Object localObject2;
        if (searchCompanyValue != null)
        {
          paramList = new SecondaryResultsViewModel();
          localObject1 = hitInfo.searchCompanyValue;
          localObject2 = company;
          type = SearchType.COMPANIES;
          entityName = name;
          image = new ImageModel(logo, GhostImageUtils.getCompany(2131492962, (MiniCompany)localObject2), Util.retrieveRumSessionId(paramFragmentComponent));
          isCtaClicked = following.following;
          clickListener = new SecondaryResultsTransformer.3(this, paramFragmentComponent.tracker(), "search_srp_result", new TrackingEventBuilder[0], paramList, paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray, paramString2, paramString3, (MiniCompany)localObject2);
          if (hasIndustry) {
            entityDescription = industry;
          }
          if (hasLocation) {
            metadata = location;
          }
          locationMetadata = true;
          if (SearchUtils.shouldShowFollowView(paramFragmentComponent, following, Lix.LIX_SEARCH_FOLLOW_COMPANY_ACTION)) {
            setUpRevealViewListeners(paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray.get(paramInt), paramString2, paramString3, paramList);
          }
          if (followingListener != null) {
            followingListener.listenForUpdates(following, paramList);
          }
        }
        else
        {
          boolean bool;
          if (searchGroupValue != null)
          {
            paramList = new SecondaryResultsViewModel();
            localObject1 = hitInfo.searchGroupValue;
            localObject2 = group;
            type = SearchType.GROUPS;
            entityName = groupName;
            image = new ImageModel(logo, GhostImageUtils.getGroup(2131492962, (MiniGroup)localObject2), Util.retrieveRumSessionId(paramFragmentComponent));
            if ((membershipInfo != null) && (membershipInfo.status != GroupMembershipStatus.NON_MEMBER)) {}
            for (bool = true;; bool = false)
            {
              isCtaClicked = bool;
              clickListener = new SecondaryResultsTransformer.4(this, paramFragmentComponent.tracker(), "search_srp_result", new TrackingEventBuilder[0], paramList, paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray, paramString2, paramString3, (MiniGroup)localObject2);
              if ((hasDiscussionActivity) && (discussionActivity != null)) {
                entityDescription = discussionActivity.displayText;
              }
              if (hasMemberCount) {
                metadata = paramFragmentComponent.i18NManager().getString(2131233541, new Object[] { Integer.valueOf(memberCount) });
              }
              if ("enabled".equals(paramFragmentComponent.lixManager().getTreatment(Lix.LIX_SEARCH_JOIN_GROUP_ACTION))) {
                setUpRevealViewListeners(paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray.get(paramInt), paramString2, paramString3, paramList);
              }
              break;
            }
          }
          if (searchSchoolValue != null)
          {
            localObject1 = new SecondaryResultsViewModel();
            localObject2 = hitInfo.searchSchoolValue;
            paramList = school;
            type = SearchType.SCHOOLS;
            entityName = schoolName;
            image = new ImageModel(logo, GhostImageUtils.getSchool(2131492962, paramList), Util.retrieveRumSessionId(paramFragmentComponent));
            if ((following != null) && (following.following))
            {
              bool = true;
              isCtaClicked = bool;
              clickListener = new SecondaryResultsTransformer.5(this, paramFragmentComponent.tracker(), "search_srp_result", new TrackingEventBuilder[0], (SecondaryResultsViewModel)localObject1, paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray, paramString2, paramString3, paramList);
              if (hasLocation) {
                entityDescription = location;
              }
              if (hasStudentAndAlumniCount) {
                break label1024;
              }
            }
            for (paramList = null;; paramList = i18NManager.getString(2131233567, new Object[] { Integer.valueOf(studentAndAlumniCount) }))
            {
              metadata = paramList;
              if (SearchUtils.shouldShowFollowView(paramFragmentComponent, following, Lix.LIX_SEARCH_FOLLOW_SCHOOL_ACTION)) {
                setUpRevealViewListeners(paramFragmentComponent, localSearchHit, paramString1, paramInt, paramSparseIntArray.get(paramInt), paramString2, paramString3, (SecondaryResultsViewModel)localObject1);
              }
              if ((followingListener != null) && (following != null)) {
                followingListener.listenForUpdates(following, (ViewModel)localObject1);
              }
              paramList = (List<SearchHit>)localObject1;
              break;
              bool = false;
              break label861;
            }
          }
          paramList = null;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.secondaryresults.SecondaryResultsTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */