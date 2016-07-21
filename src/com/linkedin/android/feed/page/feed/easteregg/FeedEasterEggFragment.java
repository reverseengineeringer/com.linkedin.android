package com.linkedin.android.feed.page.feed.easteregg;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.InjectView;
import com.linkedin.android.imageloader.LiImageView;
import com.linkedin.android.infra.animations.DefaultAnimatorListener;
import com.linkedin.android.infra.app.BaseFragment;
import com.linkedin.android.infra.app.PageFragment;
import com.linkedin.android.infra.components.FragmentComponent;
import com.linkedin.android.infra.viewmodel.shared.ImageModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class FeedEasterEggFragment
  extends PageFragment
{
  private double accuracy;
  private ArrayList<Animator> activeAnimators;
  @InjectView(2131755768)
  FrameLayout container;
  private ArrayList<View> headImageViews;
  private int headSize;
  private ArrayList<ImageHead> imageHeads;
  private LayoutInflater inflater;
  @InjectView(2131755769)
  TextView message;
  private Random random;
  private ViewGroup rootView;
  private double score;
  @InjectView(2131755770)
  TextView scoreText;
  private int screenHeight;
  private int screenWidth;
  private AtomicInteger totalAdded;
  private AtomicInteger totalPopped;
  private ArrayList<View> usedImagedViews;
  private AtomicInteger viewTapCount;
  
  private void animateHeadFalling(final View paramView, final boolean paramBoolean)
  {
    final Path localPath = getRandomPath();
    final ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(Math.max(4000L - score / 3000L * 100L, 2500L));
    localValueAnimator.addListener(new DefaultAnimatorListener()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        if (((Integer)paramView.getTag()).intValue() == 1) {
          FeedEasterEggFragment.access$1100(FeedEasterEggFragment.this, paramView);
        }
        activeAnimators.remove(localValueAnimator);
      }
      
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        paramView.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymous2View)
          {
            val$head.setOnClickListener(null);
            val$head.setTag(Integer.valueOf(2));
            val$fallAnimation.cancel();
            totalPopped.incrementAndGet();
            if (val$isBonusHead)
            {
              FeedEasterEggFragment.access$800(FeedEasterEggFragment.this, val$head);
              return;
            }
            FeedEasterEggFragment.access$900(FeedEasterEggFragment.this, val$head, false);
            FeedEasterEggFragment.access$1000(FeedEasterEggFragment.this);
          }
        });
      }
    });
    localValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
    {
      float[] point = new float[2];
      
      public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
      {
        float f = paramAnonymousValueAnimator.getAnimatedFraction();
        paramAnonymousValueAnimator = new PathMeasure(localPath, false);
        paramAnonymousValueAnimator.getPosTan(paramAnonymousValueAnimator.getLength() * f, point, null);
        paramView.setX(point[0]);
        paramView.setY(point[1]);
      }
    });
    activeAnimators.add(localValueAnimator);
    localValueAnimator.start();
  }
  
  private void calculateScreenSize()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    screenHeight = heightPixels;
    screenWidth = widthPixels;
  }
  
  private Path getRandomPath()
  {
    int n = screenWidth - headSize;
    int i = (screenHeight + headSize) / 3;
    int j = random.nextInt(n);
    int k = random.nextInt(n);
    int m = random.nextInt(n);
    n = random.nextInt(n);
    Path localPath = new Path();
    localPath.moveTo(j, 0.0F);
    localPath.cubicTo(k, i, m, i * 2, n, i * 3);
    return localPath;
  }
  
  public static FeedEasterEggFragment newInstance(FeedEasterEggBundle paramFeedEasterEggBundle)
  {
    FeedEasterEggFragment localFeedEasterEggFragment = new FeedEasterEggFragment();
    localFeedEasterEggFragment.setArguments(paramFeedEasterEggBundle.build());
    return localFeedEasterEggFragment;
  }
  
  public final boolean isAnchorPage()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    calculateScreenSize();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    imageHeads = new ArrayList();
    imageHeads.add(new ImageHead("Gavin Chu", "GC", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAQAAAAAJDU3NTFjMmI2LTdhMmQtNDNjNS04MmRjLTllMzVkYjBlNDc4NA.jpg"));
    imageHeads.add(new ImageHead("Vivek Tripathi", "VT", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/5/005/054/210/12c438c.jpg"));
    imageHeads.add(new ImageHead("Deepak VP", "DV", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/4/005/087/343/27ab571.jpg"));
    imageHeads.add(new ImageHead("Samish Chandra Kolli", "SK", "https://media.licdn.com/mpr/mpr/shrink_100_100/p/2/005/078/242/0dc75b2.jpg"));
    imageHeads.add(new ImageHead("Puneet Sethi", "PS", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/1/005/091/25d/1ece41e.jpg"));
    imageHeads.add(new ImageHead("Aarthi Jayaram", "AJ", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAANgAAAAJDUxNWFiNjMxLTliZjItNDg4Ni05MGRkLWQ2ODYzOTNmMmUyOQ.jpg"));
    imageHeads.add(new ImageHead("Heidi Wang", "HW", "https://media.licdn.com/media/p/1/000/1bf/0e0/18e6ede.jpg"));
    imageHeads.add(new ImageHead("Asha Chandrashekaran", "AC", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/4/005/027/0da/1d3da8a.jpg"));
    imageHeads.add(new ImageHead("Collin Yen", "CY", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/8/005/071/277/2565231.jpg"));
    imageHeads.add(new ImageHead("Benjamin Hendricks", "BH", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAP-AAAAJDg3NTQyNDk0LTZhMzYtNGZiZS04Nzk0LWE5MWY5MjlhNGMzOQ.jpg"));
    imageHeads.add(new ImageHead("Caleb Gomer", "CG", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/4/005/095/399/03b2067.jpg"));
    imageHeads.add(new ImageHead("Nathan Hibner", "NH", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/6/005/076/010/01017de.jpg"));
    imageHeads.add(new ImageHead("Shoulong Li", "SL", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/7/005/0a6/102/26d3c2d.jpg"));
    imageHeads.add(new ImageHead("Mauroof Ahmed", "MA", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/1/005/078/248/026a41c.jpg"));
    imageHeads.add(new ImageHead("Pramod Khincha", "PK", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/3/005/03d/06b/06c63ac.jpg"));
    imageHeads.add(new ImageHead("Andri Kristinsson", "AK", "https://media.licdn.com/media/AAEAAQAAAAAAAAIWAAAAJDQ3NDVjYmI2LWM1ZGMtNGFkNy04YmU3LWI4OGFjNDc4MmVkNw.jpg"));
    imageHeads.add(new ImageHead("Bonnie Barrilleaux", "BB", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/6/005/071/1c0/130ed83.jpg"));
    imageHeads.add(new ImageHead("Caitlin O'Connor", "CO", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/2/005/02d/25f/11f3d48.jpg"));
    imageHeads.add(new ImageHead("Christine Fok", "CF", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/1/005/0a6/31c/122f30a.jpg"));
    imageHeads.add(new ImageHead("Corine Yang", "CY", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAa_AAAAJDljMTgzYjljLWY4MGYtNDE4Ni1iNWM5LTc0YTI2ZTg5OTViMQ.jpg"));
    imageHeads.add(new ImageHead("James Baker", "JB", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAWyAAAAJDEwYTliMTkwLWE1YWYtNGRjNy1iMTBhLTVmN2YwMzI5NTgzNQ.jpg"));
    imageHeads.add(new ImageHead("Lindsay Norman", "LN", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAVrAAAAJDU5MTVmNzFlLWU0Y2UtNDc4OC1iMDc0LTlmMzk1NmRkMzMxMg.jpg"));
    imageHeads.add(new ImageHead("Priyanka Dogra", "PD", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/3/000/024/024/08f9783.jpg"));
    imageHeads.add(new ImageHead("Paul Gueli", "PG", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/7/000/273/144/214c4ca.jpg"));
    imageHeads.add(new ImageHead("Ryan Cruz", "RC", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/3/000/0e3/19a/03cdc1a.jpg"));
    imageHeads.add(new ImageHead("Rajat Nigam", "RN", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/6/005/021/32f/2e9976b.jpg"));
    imageHeads.add(new ImageHead("Sara Adams", "SA", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/8/000/288/34a/08fc841.jpg"));
    imageHeads.add(new ImageHead("Sarah Xing", "SX", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/3/005/008/2c6/36a5440.jpg"));
    imageHeads.add(new ImageHead("Sean Johnson", "SJ", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAQFAAAAJDA1NjEyNzZlLTI2YTYtNDNiOC04YjJlLTI3NjE1Y2ZmZWE2MA.jpg"));
    imageHeads.add(new ImageHead("Sendu Indrakumar", "SI", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/5/005/07b/1d3/0fcaa0e.jpg"));
    imageHeads.add(new ImageHead("Scott Sheffield", "SS", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/5/005/03b/2ea/33c0ee6.jpg"));
    imageHeads.add(new ImageHead("Shao-Hua Kao", "SK", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/5/000/252/12b/08d8b9c.jpg"));
    imageHeads.add(new ImageHead("Tomer Cohen", "TC", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAZwAAAAJGQwZWE5NTIwLTE0NjMtNGFjMi04YjkzLTZlNjJkMTdkYTlkZQ.jpg"));
    imageHeads.add(new ImageHead("Hosain Fathelbab", "HF", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAXhAAAAJDlmM2E0ODEwLTE5OTAtNDEzYS1iN2QzLTg3MDc4ZmI3NTFkOQ.jpg"));
    imageHeads.add(new ImageHead("Hui Wang", "HW", "https://media.licdn.com/media/p/4/000/13c/3c9/2fb9181.jpg"));
    imageHeads.add(new ImageHead("Kevin Chang", "KC", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/7/005/02f/288/2685261.jpg"));
    imageHeads.add(new ImageHead("Pannaga Shivaswamy", "PS", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/1/005/064/161/0d57f78.jpg"));
    imageHeads.add(new ImageHead("Boyi Chen", "BC", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/6/005/015/1d8/0ffd802.jpg"));
    imageHeads.add(new ImageHead("Ying Xuan", "YX", "https://media.licdn.com/media/AAEAAQAAAAAAAAJCAAAAJDgwNGZmMjU0LTRkYzctNDUwOS1hYTNiLTNhOGFjOTZmNGU2MA.jpg"));
    imageHeads.add(new ImageHead("Liang Tang", "LT", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/3/000/23b/38f/120618b.jpg"));
    imageHeads.add(new ImageHead("Nikita Lytkin", "NL", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/6/005/02e/0ac/2ffc5c8.jpg"));
    imageHeads.add(new ImageHead("Lin Yang", "LY", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAXjAAAAJDNiMWIxYWU4LTQxODctNDc3NC1iYTg2LWFjYzI2ZWZmNjQ2Yg.jpg"));
    imageHeads.add(new ImageHead("Keith Langston", "KL", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAS5AAAAJDI4ODJjOTIyLTgwZjUtNDU0YS1iYTQ4LWEwNjAxMzllOTYyYQ.jpg"));
    imageHeads.add(new ImageHead("Yanen Li", "YL", "https://media.licdn.com/media/p/8/005/02f/328/21ef68d.jpg"));
    imageHeads.add(new ImageHead("Mikhail Obukhov", "MO", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/1/000/0dc/2e0/04ce30d.jpg"));
    imageHeads.add(new ImageHead("Neda Mirian", "NM", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAS_AAAAJDdjZTE5MDI3LWJiZjUtNDcxNS1hYjdiLWI2YjgwMmUzYTBiNw.jpg"));
    imageHeads.add(new ImageHead("Arthur Fung", "AF", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/7/005/05a/2ca/18737fd.jpg"));
    imageHeads.add(new ImageHead("Ashutosh Pendse", "AP", null));
    imageHeads.add(new ImageHead("Ellis Weng", "EW", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/2/000/236/196/2235823.jpg"));
    imageHeads.add(new ImageHead("Chenhui Zhai", "CZ", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAALtAAAAJDg5ZmE1MDZiLTczZTYtNDA2Mi1iYzNjLTQyN2YwMWViNGVlYw.jpg"));
    imageHeads.add(new ImageHead("Chao Zhang", "CZ", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAUHAAAAJGE0NDVjODEwLTZlY2UtNGE5OS1iODc2LWU0ODVlYjgzNDg2OA.jpg"));
    imageHeads.add(new ImageHead("Nikhil Bedi", "NB", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/6/005/098/05c/2f28587.jpg"));
    imageHeads.add(new ImageHead("Iosef Kaver", "TK", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAIOAAAAJGQyMTE0M2YxLWVjNWEtNGVhNi04MDBkLTI0MzYyMGZkMGRkOQ.jpg"));
    imageHeads.add(new ImageHead("Yi Hou", "YH", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/AAEAAQAAAAAAAAOLAAAAJDBmNTQyZTM3LWIyZDUtNGI4Ni1iNzc5LTE1YjkwNGVjZTM2OQ.jpg"));
    imageHeads.add(new ImageHead("Siddhesh Vartak", "SV", null));
    imageHeads.add(new ImageHead("Sujit Supekar", "SS", null));
    imageHeads.add(new ImageHead("Sagar Waghmare", "SW", "https://media.licdn.com/mpr/mpr/shrinknp_100_100/p/7/005/0af/30c/2d05d5b.jpg"));
    imageHeads.add(new ImageHead("Raja Venkataraman", "RV", null));
    imageHeads.add(new ImageHead("Indrajit Shanbhag", "IS", null));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    inflater = paramLayoutInflater;
    rootView = paramViewGroup;
    return paramLayoutInflater.inflate(2130968745, paramViewGroup, false);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    calculateScreenSize();
    headImageViews = new ArrayList();
    usedImagedViews = new ArrayList();
    Iterator localIterator = imageHeads.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (ImageHead)localIterator.next();
      if (imageUrl != null)
      {
        localObject = new ImageModel(imageUrl, 2130838233);
        paramBundle = (LiImageView)inflater.inflate(2130968746, rootView, false);
        ((ImageModel)localObject).setImageView(fragmentComponent.mediaCenter(), paramBundle);
        paramBundle.setTag(Integer.valueOf(1));
      }
      for (;;)
      {
        headImageViews.add(paramBundle);
        paramBundle.setVisibility(8);
        container.addView(paramBundle);
        break;
        paramBundle = (TextView)inflater.inflate(2130968747, rootView, false);
        paramBundle.setText(initials);
        paramBundle.setTag(Integer.valueOf(1));
      }
    }
    activeAnimators = new ArrayList();
    headSize = getResources().getDimensionPixelSize(2131492962);
    random = new Random();
    viewTapCount = new AtomicInteger(0);
    totalAdded = new AtomicInteger(0);
    totalPopped = new AtomicInteger(0);
    accuracy = 0.0D;
    score = 0.0D;
    paramView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (viewTapCount.get() % 20 == 0) {
          FeedEasterEggFragment.access$100(FeedEasterEggFragment.this);
        }
        if (viewTapCount.incrementAndGet() <= 10) {
          FeedEasterEggFragment.access$200(FeedEasterEggFragment.this, 2131231211);
        }
        for (;;)
        {
          int i = random.nextInt(2);
          FeedEasterEggFragment.access$400(FeedEasterEggFragment.this, i + 1);
          return;
          if (viewTapCount.get() <= 20) {
            FeedEasterEggFragment.access$200(FeedEasterEggFragment.this, 2131231214);
          } else {
            FeedEasterEggFragment.access$200(FeedEasterEggFragment.this, 2131231210);
          }
        }
      }
    });
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        FeedEasterEggFragment.access$500(FeedEasterEggFragment.this);
        return true;
      }
    });
  }
  
  public final String pageKey()
  {
    return "feed_easter_egg";
  }
  
  private static final class ImageHead
  {
    String imageUrl;
    String initials;
    private String name;
    
    public ImageHead(String paramString1, String paramString2, String paramString3)
    {
      name = paramString1;
      initials = paramString2;
      imageUrl = paramString3;
    }
  }
}

/* Location:
 * Qualified Name:     com.linkedin.android.feed.page.feed.easteregg.FeedEasterEggFragment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */