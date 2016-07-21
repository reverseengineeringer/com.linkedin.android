package com.linkedin.android.search.typeahead;

import android.text.TextUtils;
import android.text.TextWatcher;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.annotation.AnnotatedText.Builder;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit;
import com.linkedin.android.pegasus.gen.voyager.typeahead.TypeaheadHit.Builder;
import com.linkedin.android.search.ClickEvent;
import com.linkedin.android.search.SearchBarListener;
import com.linkedin.android.tracking.v2.event.ControlInteractionEvent;
import com.linkedin.android.tracking.v2.event.ControlType;
import com.linkedin.android.tracking.v2.event.InteractionType;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.search.SearchResultPageOrigin;
import java.io.IOException;
import java.util.ArrayList;
import javax.inject.Inject;

public final class TypeAheadSearchBarPresenter
{
  String currentQuery;
  String customTrackingName;
  Bus eventBus;
  boolean isPickerMode;
  SearchBarListener searchBarListener;
  TextWatcher textChangeListener;
  Tracker tracker;
  
  final boolean handleEnterPressed(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean) {}
    while ((TextUtils.isEmpty(currentQuery)) || (TextUtils.getTrimmedLength(currentQuery) == 0)) {
      try
      {
        TypeaheadHit localTypeaheadHit = new TypeaheadHit.Builder().setText(new AnnotatedText.Builder().setText(currentQuery).setAnnotations(new ArrayList()).build()).build(RecordTemplate.Flavor.RECORD);
        Bus.publish(new ClickEvent(13, localTypeaheadHit));
        if (customTrackingName != null) {
          new ControlInteractionEvent(tracker, customTrackingName, ControlType.TEXTFIELD, InteractionType.KEYBOARD_SUBMIT).send();
        }
        return true;
      }
      catch (BuilderException localBuilderException)
      {
        return false;
      }
    }
    new ControlInteractionEvent(tracker, "search_box", ControlType.TEXTFIELD, InteractionType.KEYBOARD_SUBMIT).send();
    return searchBarListener.onQuerySubmit(currentQuery, SearchResultPageOrigin.GLOBAL_SEARCH_HEADER.toString(), null, null);
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.search.typeahead.TypeAheadSearchBarPresenter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */