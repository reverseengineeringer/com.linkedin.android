package com.linkedin.android.entities.school.transformers;

import android.content.res.Resources;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import com.linkedin.android.entities.EntityTransformer;
import com.linkedin.android.entities.EntityUtils;
import com.linkedin.android.entities.school.SchoolDataProvider;
import com.linkedin.android.entities.school.SchoolDataProvider.SchoolState;
import com.linkedin.android.entities.viewmodels.EntityTopCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.EntityBaseCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.MultiHeadlineCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.ParagraphCardViewModel;
import com.linkedin.android.entities.viewmodels.cards.StatisticsCardViewModel;
import com.linkedin.android.infra.app.BaseActivity;
import com.linkedin.android.infra.app.DataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.CollectionUtils;
import com.linkedin.android.infra.shared.GhostImageUtils;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.common.PhoneNumber;
import com.linkedin.android.pegasus.gen.voyager.common.FollowingInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Description;
import com.linkedin.android.pegasus.gen.voyager.entities.common.ItemInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.common.Section.Items;
import com.linkedin.android.pegasus.gen.voyager.entities.school.BasicSchoolInfo;
import com.linkedin.android.pegasus.gen.voyager.entities.school.FinancialInformation;
import com.linkedin.android.pegasus.gen.voyager.entities.school.School;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolDetails;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem;
import com.linkedin.android.pegasus.gen.voyager.entities.school.SchoolItem.Item;
import com.linkedin.android.pegasus.gen.voyager.entities.school.StudentsAndFaculty;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniSchool;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolImpressionItem.Builder;
import com.linkedin.gen.avro2pegasus.events.entities.FlagshipSchoolItemImpressionEvent.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class SchoolTransformer
{
  private static final String TAG = SchoolTransformer.class.getSimpleName();
  
  static Closure<ImpressionData, TrackingEventBuilder> newSchoolImpressionTrackingClosure(String paramString1, final TrackingObject paramTrackingObject, final String paramString2, final List<String> paramList)
  {
    new Closure()
    {
      private TrackingEventBuilder apply(ImpressionData paramAnonymousImpressionData)
      {
        Object localObject1;
        for (;;)
        {
          Object localObject2;
          try
          {
            localObject2 = new FlagshipSchoolImpressionItem.Builder();
            localObject1 = val$itemTrackingId;
            if (localObject1 == null)
            {
              hasItemTrackingId = false;
              itemTrackingId = null;
              localObject1 = Long.valueOf(timeViewed);
              if (localObject1 == null)
              {
                hasVisibleTime = false;
                visibleTime = 0L;
                localObject1 = new ListPosition.Builder().setIndex(Integer.valueOf(position)).build(RecordTemplate.Flavor.RECORD);
                hasListPosition = true;
                listPosition = ((ListPosition)localObject1);
                localObject1 = new EntityDimension.Builder().setHeight(Integer.valueOf(height)).setWidth(Integer.valueOf(width)).build(RecordTemplate.Flavor.RECORD);
                hasSize = true;
                size = ((EntityDimension)localObject1);
                if (paramList != null) {
                  break label292;
                }
                localObject1 = new ArrayList();
                if (localObject1 != null) {
                  break label300;
                }
                hasUrns = false;
                urns = null;
                localObject1 = ((FlagshipSchoolImpressionItem.Builder)localObject2).build(RecordTemplate.Flavor.RECORD);
                Log.d("SchoolImpression", "onTrackImpression() - pos: " + position + " item: " + paramString2);
                paramAnonymousImpressionData = new FlagshipSchoolItemImpressionEvent.Builder();
                localObject2 = paramTrackingObject;
                if (localObject2 != null) {
                  break label313;
                }
                hasSchool = false;
                school = null;
                localObject1 = Collections.singletonList(localObject1);
                if (localObject1 != null) {
                  break;
                }
                hasItems = false;
                items = null;
                return paramAnonymousImpressionData;
              }
            }
            else
            {
              hasItemTrackingId = true;
              itemTrackingId = ((String)localObject1);
              continue;
            }
            hasVisibleTime = true;
          }
          catch (BuilderException paramAnonymousImpressionData)
          {
            Util.safeThrow(new RuntimeException(paramAnonymousImpressionData));
            return null;
          }
          visibleTime = ((Long)localObject1).longValue();
          continue;
          label292:
          localObject1 = paramList;
          continue;
          label300:
          hasUrns = true;
          urns = ((List)localObject1);
          continue;
          label313:
          hasSchool = true;
          school = ((TrackingObject)localObject2);
        }
        hasItems = true;
        items = ((List)localObject1);
        return paramAnonymousImpressionData;
      }
    };
  }
  
  public static List<ViewModel> toCardViewModels(FragmentComponent paramFragmentComponent, SchoolDataProvider paramSchoolDataProvider, List<Section.Items> paramList)
  {
    School localSchool = ((SchoolDataProvider.SchoolState)state).school();
    TrackingObject localTrackingObject = state).schoolTrackingObject;
    ArrayList localArrayList = new ArrayList();
    if ((localSchool == null) || (CollectionUtils.isEmpty(paramList))) {}
    Iterator localIterator;
    do
    {
      return localArrayList;
      localIterator = paramList.iterator();
    } while (!localIterator.hasNext());
    SchoolItem localSchoolItem = nextschoolItemValue;
    Object localObject1 = null;
    Object localObject2 = item;
    paramList = (List<Section.Items>)localObject1;
    switch (itemInfo.itemType.schoolItemTypeValue)
    {
    default: 
      Log.e(TAG, "Unsupported school item type: " + itemInfo.itemType);
      paramList = (List<Section.Items>)localObject1;
    }
    for (;;)
    {
      if ((paramList != null) && (localTrackingObject != null)) {
        trackingEventBuilderClosure = newSchoolImpressionTrackingClosure(itemInfo.trackingId, localTrackingObject, header, trackingUrns);
      }
      CollectionUtils.addItemIfNonNull(localArrayList, paramList);
      break;
      paramList = SchoolCardsTransformer.toFirstDegreeStudentsAndAlumniCard(paramFragmentComponent, paramSchoolDataProvider, miniProfilesCollectionValue);
      continue;
      localObject1 = descriptionValue;
      paramList = new ParagraphCardViewModel();
      header = paramFragmentComponent.activity().getString(2131231020);
      body = text;
      maxLinesCollapsed = paramFragmentComponent.activity().getResources().getInteger(2131558439);
      onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
      continue;
      paramList = schoolDetailsValue;
      localObject2 = basicSchoolInfo.miniSchool.schoolName;
      localObject1 = new MultiHeadlineCardViewModel();
      Object localObject3 = paramFragmentComponent.activity().getResources();
      multiHeadlineCardMaxPairsCollapsed = ((Resources)localObject3).getInteger(2131558424);
      if (hasAddress) {
        items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject3).getString(2131230852), address));
      }
      if (hasEmailAddress) {
        items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject3).getString(2131230891), emailAddress));
      }
      if (hasPhoneNumber) {
        items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject3).getString(2131231012), phoneNumber.number));
      }
      if (hasHomepageUrl) {
        items.add(EntityTransformer.toLinkableDetailItem(paramFragmentComponent, ((Resources)localObject3).getString(2131231067), homepageUrl, homepageUrl, (String)localObject2));
      }
      if (hasSchoolType) {
        items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject3).getString(2131230937), schoolType));
      }
      if (hasYearLevel) {
        items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject3).getString(2131231073), yearLevel));
      }
      onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
      paramList = (List<Section.Items>)localObject1;
      if (items.isEmpty())
      {
        paramList = null;
        continue;
        paramList = SchoolCardsTransformer.toSimilarSchoolBrowseMapList(paramFragmentComponent, nextSchoolsCollectionValue);
        continue;
        paramList = SchoolCardsTransformer.toRankingsCard(paramFragmentComponent, schoolRankingsValue);
        continue;
        paramList = SchoolCardsTransformer.toStudentsAndAlumniCard(paramFragmentComponent, paramSchoolDataProvider, basicSchoolInfo.miniSchool.schoolName, miniProfilesCollectionValue);
        continue;
        localObject3 = financialInformationValue;
        localObject1 = new MultiHeadlineCardViewModel();
        localObject2 = paramFragmentComponent.activity().getResources();
        Object localObject4 = paramFragmentComponent.i18NManager();
        header = ((Resources)localObject2).getString(2131230899);
        multiHeadlineCardMaxPairsCollapsed = ((Resources)localObject2).getInteger(2131558424);
        Object localObject5;
        if (hasFinancialAidAvailable)
        {
          localObject5 = items;
          String str = ((Resources)localObject2).getString(2131230898);
          if (financialAidAvailable)
          {
            paramList = ((Resources)localObject2).getString(2131230857);
            label772:
            ((List)localObject5).add(EntityTransformer.toNonLinkableDetailItem(str, paramList));
          }
        }
        else
        {
          if (hasFinancialAidPercentage) {
            items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject2).getString(2131231011), ((I18NManager)localObject4).getString(2131233038, new Object[] { Double.valueOf(financialAidPercentage / 100.0F) })));
          }
          paramList = inStateTuition;
          localObject5 = outOfStateTuition;
          if ((!hasInStateTuition) || (!hasOutOfStateTuition)) {
            break label968;
          }
          paramList = ((I18NManager)localObject4).getString(2131231032, new Object[] { paramList, localObject5 });
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramList)) {
            items.add(EntityTransformer.toNonLinkableDetailItem(((Resources)localObject2).getString(2131231064), paramList));
          }
          onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
          if (!items.isEmpty()) {
            break label1030;
          }
          paramList = null;
          break;
          paramList = ((Resources)localObject2).getString(2131231065);
          break label772;
          label968:
          if (hasInStateTuition) {
            paramList = ((I18NManager)localObject4).getString(2131231031, new Object[] { paramList });
          } else if (hasOutOfStateTuition) {
            paramList = ((I18NManager)localObject4).getString(2131231033, new Object[] { localObject5 });
          } else {
            paramList = null;
          }
        }
        label1030:
        paramList = (List<Section.Items>)localObject1;
        continue;
        localObject2 = studentsAndFacultyValue;
        paramList = new StatisticsCardViewModel();
        localObject1 = contentPairs;
        localObject3 = paramFragmentComponent.i18NManager();
        localObject4 = paramFragmentComponent.activity().getResources();
        header = ((Resources)localObject4).getString(2131231054);
        maxRowsVisibleWhenCollapsed = ((Resources)localObject4).getInteger(2131558425);
        if (hasNumberOfUndergradStudents) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233020, new Object[] { Integer.valueOf(numberOfUndergradStudents) }), ((I18NManager)localObject3).getString(2131231066)));
        }
        if (hasNumberOfGradStudents) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233020, new Object[] { Integer.valueOf(numberOfGradStudents) }), ((I18NManager)localObject3).getString(2131230905)));
        }
        if (hasNumberOfFaculty) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233020, new Object[] { Integer.valueOf(numberOfFaculty) }), ((I18NManager)localObject3).getString(2131230895)));
        }
        if (hasTotalPopulation) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233020, new Object[] { Integer.valueOf(totalPopulation) }), ((I18NManager)localObject3).getString(2131231063)));
        }
        if (hasStudentFacultyRatio) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131231016, new Object[] { Float.valueOf(studentFacultyRatio) }), ((I18NManager)localObject3).getString(2131231052)));
        }
        if (hasMaleStudentPercentage) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233038, new Object[] { Double.valueOf(maleStudentPercentage / 100.0F) }), ((I18NManager)localObject3).getString(2131230998)));
        }
        if (hasFemaleStudentPercentage) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233038, new Object[] { Double.valueOf(femaleStudentPercentage / 100.0F) }), ((I18NManager)localObject3).getString(2131230897)));
        }
        if (hasAdmittedPercentage) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233038, new Object[] { Double.valueOf(admittedPercentage / 100.0F) }), ((I18NManager)localObject3).getString(2131230853)));
        }
        if (hasGraduationPercentage) {
          ((List)localObject1).add(new Pair(((I18NManager)localObject3).getString(2131233038, new Object[] { Double.valueOf(graduationPercentage / 100.0F) }), ((I18NManager)localObject3).getString(2131230906)));
        }
        onExpandButtonClick = TrackingClosure.createEmptyTrackingClosure(paramFragmentComponent.tracker(), "see_more");
        if (((List)localObject1).isEmpty()) {
          paramList = null;
        }
      }
    }
  }
  
  public static EntityTopCardViewModel toTopCard(final FragmentComponent paramFragmentComponent, final SchoolDataProvider paramSchoolDataProvider, School paramSchool)
  {
    final Map localMap = Tracker.createPageInstanceHeader(paramFragmentComponent.tracker().getCurrentPageInstance());
    EntityTopCardViewModel localEntityTopCardViewModel = new EntityTopCardViewModel();
    I18NManager localI18NManager = paramFragmentComponent.i18NManager();
    final BasicSchoolInfo localBasicSchoolInfo = basicSchoolInfo;
    final MiniSchool localMiniSchool = miniSchool;
    title = schoolName;
    String str = Util.retrieveRumSessionId(paramFragmentComponent);
    icon = new ImageModel(logo, GhostImageUtils.getSchool(2131492964, localMiniSchool), str);
    heroImage = new ImageModel(heroImage, 2130837793, str);
    subtitle2 = EntityUtils.formatLocationAndFollowers(paramFragmentComponent, hasLocation, hasFollowerCount, location, followingInfo.followerCount);
    primaryButtonDefaultText = localI18NManager.getString(2131230858);
    primaryButtonClickedText = localI18NManager.getString(2131230859);
    primaryButtonDefaultIcon = EntityUtils.createButtonIcon(paramFragmentComponent, 2130838246, 2130837652);
    primaryButtonClickedIcon = EntityUtils.createButtonIcon(paramFragmentComponent, 2130837935, 2130837641);
    primaryButtonIconPadding = ((int)paramFragmentComponent.activity().getResources().getDimension(2131492989));
    isPrimaryButtonClicked = followingInfo.following;
    onPrimaryButtonClick = new TrackingClosure(paramFragmentComponent.tracker(), "school_follow_toggle") {};
    return localEntityTopCardViewModel;
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.school.transformers.SchoolTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */