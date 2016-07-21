package com.linkedin.android.feed.endor.ui;

import android.os.Handler;
import android.text.SpannableStringBuilder;
import com.linkedin.android.feed.actions.UndoRemovalOnClickListener;
import com.linkedin.android.feed.endor.datamodel.FeedDataModelMetadata;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateDataModelTransformer;
import com.linkedin.android.feed.endor.datamodel.transformer.UpdateException;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsData;
import com.linkedin.android.feed.endor.datamodel.transformer.service.ModelsTransformedCallback;
import com.linkedin.android.feed.endor.datamodel.transformer.service.TransformerExecutor;
import com.linkedin.android.feed.endor.datamodel.update.UnsupportedUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.UpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedConnectionUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedFollowRecommendationUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedPymkUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedSingleUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.AggregatedUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.aggregated.jymbii.AggregatedJymbiiUpdateDataModel;
import com.linkedin.android.feed.endor.datamodel.update.single.SingleUpdateDataModel;
import com.linkedin.android.feed.endor.ui.component.collapse.FeedCollapseLayout;
import com.linkedin.android.feed.endor.ui.component.collapse.FeedCollapseViewModel;
import com.linkedin.android.feed.endor.ui.component.componentlist.FeedComponentListViewModel;
import com.linkedin.android.feed.endor.ui.component.contentdetail.FeedContentDetailTransformer;
import com.linkedin.android.feed.endor.ui.component.header.FeedHeaderViewTransformer;
import com.linkedin.android.feed.endor.ui.component.richmedia.FeedRichMediaTransformer;
import com.linkedin.android.feed.endor.ui.component.seeall.FeedSeeAllTransformer;
import com.linkedin.android.feed.endor.ui.component.unsupported.FeedUnsupportedTransformer;
import com.linkedin.android.feed.endor.ui.update.FeedUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.aggregated.connection.FeedAggregatedConnectionUpdateViewTransformer;
import com.linkedin.android.feed.endor.ui.update.aggregated.followrecommendation.FeedAggregatedFollowRecommendationUpdateViewTransformer;
import com.linkedin.android.feed.endor.ui.update.aggregated.jymbii.FeedAggregatedJymbiiUpdateViewTransformer;
import com.linkedin.android.feed.endor.ui.update.aggregated.pymk.FeedAggregatedPymkUpdateViewTransformer;
import com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedNestedSingleUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedNestedSingleUpdateViewTransformer;
import com.linkedin.android.feed.endor.ui.update.aggregated.single.FeedAggregatedSingleUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewModel;
import com.linkedin.android.feed.endor.ui.update.single.FeedSingleUpdateViewTransformer;
import com.linkedin.android.feed.tracking.FeedTracking;
import com.linkedin.android.feed.utils.FeedI18NUtils;
import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.feed.viewmodels.models.UpdateActionModel;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.I18NManager;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class FeedViewTransformer
{
  static ModelData<Update, UpdateDataModel, FeedUpdateViewModel> toCollapsedViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, UpdateActionModel paramUpdateActionModel)
  {
    int i = type;
    String str2 = actorName;
    boolean bool = self;
    UndoRemovalOnClickListener localUndoRemovalOnClickListener;
    String str1;
    Object localObject4;
    Object localObject5;
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if ((i == 15) || (i == 16) || (i == 17) || (i == 18) || (i == 19) || (i == 21) || (i == 22) || (i == 23))
    {
      localUndoRemovalOnClickListener = null;
      str1 = "DEFAULT_TEXT";
      localObject4 = null;
      localObject5 = null;
      localObject3 = localObject4;
      localObject1 = str1;
      localObject2 = localObject5;
      switch (i)
      {
      default: 
        localObject2 = localObject5;
        localObject1 = str1;
        localObject3 = localObject4;
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      case 19: 
      case 20: 
        label208:
        localObject4 = localObject3;
        if (localObject3 == null) {
          localObject4 = paramFragmentComponent.i18NManager().getString(2131231199);
        }
        if ((localObject2 == null) && (!((String)localObject1).equals("DEFAULT_TEXT")))
        {
          localObject1 = FeedI18NUtils.translateActorString$4fa0acfe(paramFragmentComponent.i18NManager(), 2131231197, str2, (String)localObject1);
          label262:
          if (localUndoRemovalOnClickListener == null) {
            break label670;
          }
          bool = true;
          label270:
          if (!bool) {
            break label676;
          }
          localUndoRemovalOnClickListener = null;
          localObject2 = new SpannableStringBuilder();
          ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
          ((SpannableStringBuilder)localObject2).append(" ");
          i = ((SpannableStringBuilder)localObject2).length();
          localObject1 = paramFragmentComponent.i18NManager().getString(2131231195);
          ((SpannableStringBuilder)localObject2).append((CharSequence)localObject1);
          ((SpannableStringBuilder)localObject2).setSpan(FeedTracking.newUndoSpan(paramFragmentComponent, paramUpdate, paramUpdateActionModel), i, ((CharSequence)localObject1).length() + i, 17);
          bool = false;
          localObject1 = localUndoRemovalOnClickListener;
          paramUpdateActionModel = (UpdateActionModel)localObject2;
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = FeedTracking.newImproveMyFeedClickListener(paramFragmentComponent);
      return new ModelData(paramUpdate, null, new FeedSingleUpdateViewModel(paramUpdate, paramFragmentComponent, paramFeedComponentsViewPool, Collections.singletonList(new FeedCollapseViewModel(new FeedCollapseLayout(bool), (CharSequence)localObject4, paramUpdateActionModel, (TrackingOnClickListener)localObject1, (TrackingOnClickListener)localObject2)), null));
      localUndoRemovalOnClickListener = FeedTracking.newUndoRemovalClickListener(paramFragmentComponent, paramUpdate, paramUpdateActionModel);
      break;
      localObject1 = "MEMBER";
      localObject3 = localObject4;
      localObject2 = localObject5;
      break label208;
      localObject1 = "SCHOOL";
      localObject3 = localObject4;
      localObject2 = localObject5;
      break label208;
      localObject1 = "CHANNEL";
      localObject3 = localObject4;
      localObject2 = localObject5;
      break label208;
      localObject1 = "GROUP";
      localObject3 = localObject4;
      localObject2 = localObject5;
      break label208;
      localObject1 = "COMPANY";
      localObject3 = localObject4;
      localObject2 = localObject5;
      break label208;
      localObject1 = "MEMBER";
      localObject3 = localObject4;
      localObject2 = localObject5;
      break label208;
      localObject2 = FeedI18NUtils.translateActorString$4fa0acfe(paramFragmentComponent.i18NManager(), 2131231192, str2, "MEMBER");
      localObject3 = localObject4;
      localObject1 = str1;
      break label208;
      if (bool)
      {
        localObject2 = paramFragmentComponent.i18NManager().getString(2131231202);
        localObject3 = localObject4;
        localObject1 = str1;
        break label208;
      }
      localObject2 = paramFragmentComponent.i18NManager().getString(2131231201);
      localObject3 = localObject4;
      localObject1 = str1;
      break label208;
      localObject3 = paramFragmentComponent.i18NManager().getString(2131231182);
      localObject2 = paramFragmentComponent.i18NManager().getString(2131231183, new Object[] { groupName });
      localObject1 = str1;
      break label208;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label262;
      }
      localObject1 = paramFragmentComponent.i18NManager().getString(2131231175);
      break label262;
      label670:
      bool = false;
      break label270;
      label676:
      paramUpdateActionModel = (UpdateActionModel)localObject1;
      localObject1 = localUndoRemovalOnClickListener;
    }
  }
  
  public static void toCollapsedViewModel(FragmentComponent paramFragmentComponent, final FeedComponentsViewPool paramFeedComponentsViewPool, final Update paramUpdate, final UpdateActionModel paramUpdateActionModel, final ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel> paramModelTransformedCallback)
  {
    paramFragmentComponent.transformerExecutor().execute(new Runnable()
    {
      public final void run()
      {
        final ModelData localModelData = FeedViewTransformer.toCollapsedViewModel(val$fragmentComponent, paramFeedComponentsViewPool, paramUpdate, paramUpdateActionModel);
        val$fragmentComponent.mainHandler().post(new Runnable()
        {
          public final void run()
          {
            val$callback.onModelTransformed(localModelData);
          }
        });
      }
    });
  }
  
  public static ModelData<Update, UpdateDataModel, FeedUpdateViewModel> toViewModel(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, Update paramUpdate, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    Object localObject1 = paramFragmentComponent.updateChangeCoordinator();
    Object localObject2 = urn;
    if (localObject2 != null) {}
    for (localObject1 = (UpdateActionModel)collapsedUpdates.get(((Urn)localObject2).toString()); localObject1 != null; localObject1 = null)
    {
      localUpdateDataModel = null;
      localObject2 = (FeedUpdateViewModel)toCollapsedViewModelviewModel;
      localObject1 = localUpdateDataModel;
      searchId = searchId;
      FeedTopBarManager.configureTopBar(paramFragmentComponent, (FeedUpdateViewModel)localObject2);
      FeedBorderManager.applyBorders$2d7435b4(paramFeedComponentsViewPool, (FeedUpdateViewModel)localObject2);
      return new ModelData(paramUpdate, localObject1, (ViewModel)localObject2);
    }
    UpdateDataModel localUpdateDataModel = UpdateDataModelTransformer.toDataModel(paramFragmentComponent, paramUpdate, paramFeedDataModelMetadata);
    localObject1 = null;
    if ((localUpdateDataModel instanceof SingleUpdateDataModel)) {
      localObject1 = FeedSingleUpdateViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (SingleUpdateDataModel)localUpdateDataModel, true, false, false);
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = FeedUnsupportedTransformer.toUnsupportedViewModel(paramFragmentComponent, paramFeedComponentsViewPool, pegasusUpdate, null);
      }
      localObject1 = localUpdateDataModel;
      break;
      if ((localUpdateDataModel instanceof AggregatedUpdateDataModel))
      {
        AggregatedUpdateDataModel localAggregatedUpdateDataModel = (AggregatedUpdateDataModel)localUpdateDataModel;
        localObject1 = null;
        if ((localAggregatedUpdateDataModel instanceof AggregatedSingleUpdateDataModel))
        {
          localObject2 = (AggregatedSingleUpdateDataModel)localAggregatedUpdateDataModel;
          if (content == null) {
            localObject1 = null;
          }
        }
        for (;;)
        {
          localObject2 = localObject1;
          if (localObject1 == null) {
            localObject2 = FeedUnsupportedTransformer.toUnsupportedViewModel(paramFragmentComponent, paramFeedComponentsViewPool, pegasusUpdate, null);
          }
          localObject1 = localObject2;
          break;
          localObject1 = new ArrayList(3);
          if ((!FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent)) && (!FeedAggregatedNestedSingleUpdateViewTransformer.safeAdd((List)localObject1, FeedHeaderViewTransformer.toViewModel(paramFragmentComponent, (UpdateDataModel)localObject2)))) {
            localObject1 = null;
          }
          for (;;)
          {
            if (localObject1 != null) {
              break label341;
            }
            localObject1 = null;
            break;
            FeedAggregatedNestedSingleUpdateViewTransformer.safeAdd((List)localObject1, FeedRichMediaTransformer.toViewModel(paramFragmentComponent, (UpdateDataModel)localObject2));
            if (!FeedAggregatedNestedSingleUpdateViewTransformer.safeAdd((List)localObject1, FeedContentDetailTransformer.toViewModel((UpdateDataModel)localObject2, paramFragmentComponent, FeedContentDetailTransformer.getContentDetailType((UpdateDataModel)localObject2), true))) {
              localObject1 = null;
            } else {
              localObject1 = new FeedComponentListViewModel(paramFeedComponentsViewPool, (List)localObject1);
            }
          }
          label341:
          localObject1 = new FeedAggregatedSingleUpdateViewModel(pegasusUpdate, paramFragmentComponent, paramFeedComponentsViewPool, (FeedComponentListViewModel)localObject1);
          if (!FeedViewTransformerHelpers.isAggregateFeedPage(paramFragmentComponent))
          {
            ArrayList localArrayList = new ArrayList(updates.size());
            int j = Math.min(updates.size(), 2);
            int i = 0;
            if (i < j)
            {
              if (i == j - 1) {}
              for (boolean bool = true;; bool = false)
              {
                localArrayList.add(new FeedAggregatedNestedSingleUpdateViewModel(FeedSingleUpdateViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (SingleUpdateDataModel)updates.get(i), false, true, bool), paramFeedComponentsViewPool));
                i += 1;
                break;
              }
            }
            updateViewModels.addAll(localArrayList);
            if (updateViewModels.size() <= 0)
            {
              localObject1 = null;
              continue;
            }
            if (updates.size() > 2) {
              seeAllViewModel = FeedSeeAllTransformer.toViewModel((UpdateDataModel)localObject2, paramFragmentComponent);
            }
          }
          if (!actions.isEmpty()) {
            controlMenuClickListener = FeedTracking.newControlMenuClickListener(pegasusUpdate, actions, paramFragmentComponent);
          }
          continue;
          if ((localAggregatedUpdateDataModel instanceof AggregatedJymbiiUpdateDataModel))
          {
            localObject1 = FeedAggregatedJymbiiUpdateViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (AggregatedJymbiiUpdateDataModel)localAggregatedUpdateDataModel);
          }
          else if ((localAggregatedUpdateDataModel instanceof AggregatedConnectionUpdateDataModel))
          {
            localObject1 = FeedAggregatedConnectionUpdateViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (AggregatedConnectionUpdateDataModel)localAggregatedUpdateDataModel);
          }
          else if ((localAggregatedUpdateDataModel instanceof AggregatedFollowRecommendationUpdateDataModel))
          {
            localObject1 = (AggregatedFollowRecommendationUpdateDataModel)localAggregatedUpdateDataModel;
            if (isHorizontal) {
              localObject1 = FeedAggregatedFollowRecommendationUpdateViewTransformer.toHorizontalViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (AggregatedFollowRecommendationUpdateDataModel)localObject1);
            } else {
              localObject1 = FeedAggregatedFollowRecommendationUpdateViewTransformer.toVerticalViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (AggregatedFollowRecommendationUpdateDataModel)localObject1);
            }
          }
          else if ((localAggregatedUpdateDataModel instanceof AggregatedPymkUpdateDataModel))
          {
            localObject1 = FeedAggregatedPymkUpdateViewTransformer.toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (AggregatedPymkUpdateDataModel)localAggregatedUpdateDataModel);
          }
        }
      }
      if ((localUpdateDataModel instanceof UnsupportedUpdateDataModel)) {
        localObject1 = FeedUnsupportedTransformer.toUnsupportedViewModel(paramFragmentComponent, paramFeedComponentsViewPool, pegasusUpdate, reason.getMessage());
      }
    }
  }
  
  public static void toViewModel(FragmentComponent paramFragmentComponent, final FeedComponentsViewPool paramFeedComponentsViewPool, final Update paramUpdate, final FeedDataModelMetadata paramFeedDataModelMetadata, final ModelTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel> paramModelTransformedCallback)
  {
    paramFragmentComponent.transformerExecutor().execute(new Runnable()
    {
      public final void run()
      {
        final ModelData localModelData = FeedViewTransformer.toViewModel(val$fragmentComponent, paramFeedComponentsViewPool, paramUpdate, paramFeedDataModelMetadata);
        val$fragmentComponent.mainHandler().post(new Runnable()
        {
          public final void run()
          {
            val$callback.onModelTransformed(localModelData);
          }
        });
      }
    });
  }
  
  public static ModelsData<Update, UpdateDataModel, FeedUpdateViewModel> toViewModels(FragmentComponent paramFragmentComponent, FeedComponentsViewPool paramFeedComponentsViewPool, List<Update> paramList, FeedDataModelMetadata paramFeedDataModelMetadata)
  {
    int i = paramList.size();
    ArrayList localArrayList1 = new ArrayList(i);
    ArrayList localArrayList2 = new ArrayList(i);
    i = 0;
    int j = paramList.size();
    while (i < j)
    {
      ModelData localModelData = toViewModel(paramFragmentComponent, paramFeedComponentsViewPool, (Update)paramList.get(i), paramFeedDataModelMetadata);
      localArrayList1.add(dataModel);
      localArrayList2.add(viewModel);
      i += 1;
    }
    return new ModelsData(paramList, localArrayList1, localArrayList2);
  }
  
  public static void toViewModels(FragmentComponent paramFragmentComponent, final FeedComponentsViewPool paramFeedComponentsViewPool, final List<Update> paramList, final FeedDataModelMetadata paramFeedDataModelMetadata, final ModelsTransformedCallback<Update, UpdateDataModel, FeedUpdateViewModel> paramModelsTransformedCallback)
  {
    paramFragmentComponent.transformerExecutor().execute(new Runnable()
    {
      public final void run()
      {
        final ModelsData localModelsData = FeedViewTransformer.toViewModels(val$fragmentComponent, paramFeedComponentsViewPool, paramList, paramFeedDataModelMetadata);
        val$fragmentComponent.mainHandler().post(new Runnable()
        {
          public final void run()
          {
            val$callback.onModelsTransformed(localModelsData);
          }
        });
      }
    });
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.FeedViewTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */