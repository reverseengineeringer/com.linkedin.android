package com.linkedin.android.entities.jymbii.transformers;

import android.widget.ImageView;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.shared.Closure;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.infra.shared.Util;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.litrackinglib.viewport.ImpressionData;
import com.linkedin.android.pegasus.gen.common.Urn;
import com.linkedin.android.pegasus.gen.voyager.entities.job.Jymbii;
import com.linkedin.android.pegasus.gen.voyager.entities.shared.MiniJob;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.data.lite.RecordTemplate.Flavor;
import com.linkedin.gen.avro2pegasus.events.common.EntityDimension.Builder;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition;
import com.linkedin.gen.avro2pegasus.events.common.ListPosition.Builder;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject;
import com.linkedin.gen.avro2pegasus.events.common.TrackingObject.Builder;
import com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEntity.Builder;
import com.linkedin.gen.avro2pegasus.events.jobs.JobRecommendationImpressionEvent.Builder;
import java.util.Collections;
import java.util.List;

public final class JymbiiTransformer {}

/* Location:
 * Qualified Name:     com.linkedin.android.entities.jymbii.transformers.JymbiiTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */