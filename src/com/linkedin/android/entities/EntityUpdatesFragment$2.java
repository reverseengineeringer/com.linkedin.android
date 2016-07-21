package com.linkedin.android.entities;

import com.linkedin.android.feed.utils.UpdateChangeCoordinator;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.viewmodel.ViewModel;
import com.linkedin.android.pegasus.gen.collection.CollectionTemplate;
import com.linkedin.android.pegasus.gen.voyager.common.CollectionMetadata;
import com.linkedin.android.pegasus.gen.voyager.feed.Update;
import java.util.Collections;
import java.util.List;

final class EntityUpdatesFragment$2
  extends EntityViewAllListBaseFragment.DataLoadListener<Update>
{
  EntityUpdatesFragment$2(EntityUpdatesFragment paramEntityUpdatesFragment)
  {
    super(paramEntityUpdatesFragment);
  }
  
  protected final List<ViewModel> transformModels(CollectionTemplate<Update, CollectionMetadata> paramCollectionTemplate)
  {
    if (elements == null) {
      return Collections.emptyList();
    }
    this$0.fragmentComponent.updateChangeCoordinator().listenForUpdates(elements, EntityUpdatesFragment.access$100(this$0));
    return this$0.getViewModels(elements);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.EntityUpdatesFragment.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */