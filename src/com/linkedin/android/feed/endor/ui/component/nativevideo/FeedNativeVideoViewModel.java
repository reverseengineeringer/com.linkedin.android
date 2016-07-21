package com.linkedin.android.feed.endor.ui.component.nativevideo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ProgressBar;
import com.google.android.exoplayer.util.Util;
import com.linkedin.android.feed.endor.ui.component.FeedComponentLayout;
import com.linkedin.android.feed.endor.ui.component.FeedComponentViewModel;
import com.linkedin.android.feed.promptresponselist.PlayerLibDelegate;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.ViewHolderCreator;
import com.linkedin.android.infra.components.ApplicationComponent;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.network.MediaCenter;
import com.linkedin.android.infra.ui.NativeVideoSurfaceView;
import com.linkedin.android.infra.ui.NativeVideoSurfaceView.PlayerReleasedListener;
import com.linkedin.android.infra.ui.TintableImageButton;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import com.linkedin.android.litrackinglib.metric.Tracker;
import com.linkedin.android.logger.Log;
import com.linkedin.android.pegasus.gen.videocontent.ProgressiveDownloadMetadata;
import com.linkedin.android.pegasus.gen.videocontent.StreamingLocation;
import com.linkedin.android.pegasus.gen.videocontent.Thumbnail;
import com.linkedin.android.pegasus.gen.videocontent.VideoPlayMetadata;
import com.linkedin.android.tracking.v2.event.TrackingEventBuilder;
import com.linkedin.android.tracking.v2.listeners.TrackingOnClickListener;
import com.linkedin.android.video.LIBandwidthMeter;
import com.linkedin.android.video.LIVideoPlayer;
import com.linkedin.android.video.controller.MediaPlayerControl;
import com.linkedin.android.video.listener.SimplePlayerViewListener;
import com.linkedin.android.video.perf.LIMonitoringSessionManager;
import com.linkedin.android.video.perf.LIVideoPerfMetadata;
import com.linkedin.android.video.perf.LIVideoPerfMetadata.Builder;
import com.linkedin.android.video.progressive.IProgressiveStreamSelector;
import com.linkedin.android.video.progressive.ProgressiveStreamSelector;
import com.linkedin.android.video.renderer.RendererBuilder;
import com.linkedin.android.video.renderer.RendererBuilderFactory;
import com.linkedin.data.lite.BuilderException;
import com.linkedin.gen.avro2pegasus.events.feed.FeedActionEvent.Builder;
import com.linkedin.gen.avro2pegasus.events.player.PlayPauseChangedReason;

public final class FeedNativeVideoViewModel
  extends FeedComponentViewModel<FeedNativeVideoViewHolder, FeedComponentLayout<FeedNativeVideoViewHolder>>
{
  public FeedActionEvent.Builder actionEvent;
  private FragmentComponent fragmentComponent;
  public VideoPlayMetadata metadata;
  
  public FeedNativeVideoViewModel(FeedNativeVideoLayout paramFeedNativeVideoLayout, FragmentComponent paramFragmentComponent)
  {
    super(paramFeedNativeVideoLayout);
    fragmentComponent = paramFragmentComponent;
  }
  
  private void onBindViewHolder(LayoutInflater paramLayoutInflater, MediaCenter paramMediaCenter, final FeedNativeVideoViewHolder paramFeedNativeVideoViewHolder)
  {
    super.onBindViewHolder(paramLayoutInflater, paramMediaCenter, paramFeedNativeVideoViewHolder);
    new ImageModel(ProgressiveStreamSelectorgetInstanceselectStreammetadata).thumbnail.url, 2130837812).setImageView(paramMediaCenter, thumbnail);
    paramLayoutInflater = new TrackingOnClickListener(fragmentComponent.tracker(), "object", new TrackingEventBuilder[0])
    {
      public final void onClick(View paramAnonymousView)
      {
        super.onClick(paramAnonymousView);
        playVideo(paramFeedNativeVideoViewHolder, paramAnonymousView.getContext());
      }
    };
    if (actionEvent != null) {
      paramLayoutInflater.addCustomTrackingEventBuilder(actionEvent);
    }
    videoFrame.setOnClickListener(paramLayoutInflater);
    playButton.setOnClickListener(paramLayoutInflater);
  }
  
  public final ViewHolderCreator<FeedNativeVideoViewHolder> getCreator()
  {
    return FeedNativeVideoViewHolder.CREATOR;
  }
  
  public final void onLeaveViewPort(int paramInt1, int paramInt2)
  {
    NativeVideoSurfaceView localNativeVideoSurfaceView = NativeVideoSurfaceView.getInstance(fragmentComponent.context());
    if (player != null) {
      player.stop();
    }
  }
  
  public final void playVideo(final FeedNativeVideoViewHolder paramFeedNativeVideoViewHolder, Context paramContext)
  {
    paramContext = NativeVideoSurfaceView.getInstance(paramContext);
    Log.d(NativeVideoSurfaceView.TAG, "stopping the player");
    if (player != null)
    {
      player.removeViewListener(playerViewListener);
      playerViewListener = null;
    }
    playerViewListener = new SimplePlayerViewListener()
    {
      public final void onStateChanged(boolean paramAnonymousBoolean, int paramAnonymousInt)
      {
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 3: 
          localFeedNativeVideoViewHolder = paramFeedNativeVideoViewHolder;
          playButton.setVisibility(8);
          spinner.setVisibility(0);
          thumbnail.setVisibility(0);
          return;
        case 1: 
        case 2: 
        case 5: 
          FeedNativeVideoViewModel.access$100$725a87e6(paramFeedNativeVideoViewHolder);
          return;
        }
        FeedNativeVideoViewHolder localFeedNativeVideoViewHolder = paramFeedNativeVideoViewHolder;
        spinner.setVisibility(8);
        playButton.setVisibility(8);
        thumbnail.setVisibility(8);
      }
    };
    playerReleasedListener = new NativeVideoSurfaceView.PlayerReleasedListener()
    {
      public final void onPlayerReleased()
      {
        FeedNativeVideoViewModel.access$100$725a87e6(paramFeedNativeVideoViewHolder);
      }
    };
    paramContext.setVisibility(8);
    Object localObject1 = (ViewGroup)paramContext.getParent();
    if (localObject1 != null) {
      ((ViewGroup)localObject1).removeView(paramContext);
    }
    paramFeedNativeVideoViewHolder = videoFrame;
    localObject1 = new FrameLayout.LayoutParams(-1, -1);
    gravity = 17;
    paramContext.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    paramFeedNativeVideoViewHolder.addView(paramContext);
    Object localObject2 = metadata;
    if (player != null)
    {
      if (playerViewListener != null) {
        player.addViewListener(playerViewListener);
      }
      Log.d(NativeVideoSurfaceView.TAG, "starting the player");
      paramFeedNativeVideoViewHolder = player.getPlayerControlInstance();
      if (paramFeedNativeVideoViewHolder.isPlaying()) {
        paramFeedNativeVideoViewHolder.pause(PlayPauseChangedReason.EXITED_VIEWPORT);
      }
      player.stop();
      player.seekTo(0L);
      Object localObject3 = new ProgressiveStreamSelector(LIBandwidthMeter.getInstance());
      localObject1 = ((IProgressiveStreamSelector)localObject3).selectStream((VideoPlayMetadata)localObject2);
      localObject3 = ((IProgressiveStreamSelector)localObject3).selectStreamingLocation((ProgressiveDownloadMetadata)localObject1);
      LIVideoPerfMetadata.Builder localBuilder = new LIVideoPerfMetadata.Builder();
      localBuilder.metadata((VideoPlayMetadata)localObject2, (ProgressiveDownloadMetadata)localObject1, (StreamingLocation)localObject3);
      localObject2 = localBuilder.build();
    }
    try
    {
      LIMonitoringSessionManager.enableConviva(false);
      player.setupTracking((LIVideoPerfMetadata)localObject2);
      localObject1 = new RendererBuilderFactory(context, appComponent.networkClient(), Util.getUserAgent(context, context.getString(2131233769)), PlayerLibDelegate.getInstance(appComponent)).getRendererBuilder((ProgressiveDownloadMetadata)localObject1, null);
      player.setRendererBuilder((RendererBuilder)localObject1);
      player.prepare();
      if (!player.hasSurface()) {
        player.attachSurfaceView(videoSurfaceView);
      }
      player.setBackgrounded(false);
      player.enableLooping(false);
      player.setPlayWhenReady(false);
      if (!paramFeedNativeVideoViewHolder.isPlaying()) {
        paramFeedNativeVideoViewHolder.start(PlayPauseChangedReason.ENTERED_VIEWPORT);
      }
      return;
    }
    catch (BuilderException localBuilderException)
    {
      for (;;) {}
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.endor.ui.component.nativevideo.FeedNativeVideoViewModel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */