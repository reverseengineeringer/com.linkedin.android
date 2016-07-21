package com.linkedin.android.growth.onboarding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.linkedin.android.growth.lego.LegoActionTrackingOnClickListener;
import com.linkedin.android.growth.lego.LegoWidget;
import com.linkedin.android.growth.onboarding.pymk.PymkItemViewModel;
import com.linkedin.android.identity.guidededit.infra.shared.LegoTrackingDataProvider;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.events.Bus;
import com.linkedin.android.infra.shared.TrackingClosure;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.pegasus.gen.voyager.common.Industry;
import com.linkedin.android.pegasus.gen.voyager.common.lego.ActionCategory;
import com.linkedin.android.pegasus.gen.voyager.growth.goal.GoalType;
import com.linkedin.android.pegasus.gen.voyager.relationships.shared.pymk.PeopleYouMayKnow;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;

public final class OnboardingTransformer {}

/* Location:
 * Qualified Name:     com.linkedin.android.growth.onboarding.OnboardingTransformer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */