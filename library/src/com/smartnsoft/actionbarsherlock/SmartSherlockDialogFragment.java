package com.smartnsoft.actionbarsherlock;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import com.actionbarsherlock.app.SherlockDialogFragment;
import com.smartnsoft.droid4me.app.AppPublics.BroadcastListener;
import com.smartnsoft.droid4me.app.Droid4mizer;
import com.smartnsoft.droid4me.app.Smartable;
import com.smartnsoft.droid4me.framework.ActivityResultHandler.CompositeHandler;
import com.smartnsoft.droid4me.menu.MenuHandler.Composite;
import com.smartnsoft.droid4me.menu.StaticMenuCommand;

/**
 * @author Jocelyn Girard
 * @since 2013.02.04
 */
public abstract class SmartSherlockDialogFragment<AggregrateClass>
    extends SherlockDialogFragment
    implements Smartable<AggregrateClass>
{

  private Droid4mizer<AggregrateClass, SmartSherlockDialogFragment<AggregrateClass>> droid4mizer;

  @Override
  public void onAttach(Activity activity)
  {
    if (log.isDebugEnabled())
    {
      log.debug("SmartFragment::onAttach");
    }
    super.onAttach(activity);
    droid4mizer = new Droid4mizer<AggregrateClass, SmartSherlockDialogFragment<AggregrateClass>>(activity, this, this, this);
  }

  @Override
  public void onCreate(final Bundle savedInstanceState)
  {
    droid4mizer.onCreate(new Runnable()
    {
      public void run()
      {
        SmartSherlockDialogFragment.super.onCreate(savedInstanceState);
      }
    }, savedInstanceState);
  }

  @Override
  public void onResume()
  {
    super.onResume();
    droid4mizer.onResume();
  }

  @Override
  public void onSaveInstanceState(Bundle outState)
  {
    super.onSaveInstanceState(outState);
    droid4mizer.onSaveInstanceState(outState);
  }

  @Override
  public void onStart()
  {
    super.onStart();
    droid4mizer.onStart();
  }

  @Override
  public void onPause()
  {
    try
    {
      droid4mizer.onPause();
    }
    finally
    {
      super.onPause();
    }
  }

  @Override
  public void onStop()
  {
    try
    {
      droid4mizer.onStop();
    }
    finally
    {
      super.onStop();
    }
  }

  @Override
  public void onDestroy()
  {
    try
    {
      droid4mizer.onDestroy();
    }
    finally
    {
      super.onDestroy();
    }
  }

  // @Override
  // public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater)
  // {
  // super.onCreateOptionsMenu(menu, menuInflater);
  // droid4mizer.onCreateOptionsMenu(true, menu);
  // }
  //
  // @Override
  // public void onPrepareOptionsMenu(Menu menu)
  // {
  // super.onPrepareOptionsMenu(menu);
  // droid4mizer.onPrepareOptionsMenu(true, menu);
  // }
  //
  // @Override
  // public boolean onOptionsItemSelected(MenuItem item)
  // {
  // return droid4mizer.onOptionsItemSelected(super.onOptionsItemSelected(item), item);
  // }
  //
  // @Override
  // public boolean onContextItemSelected(MenuItem item)
  // {
  // return droid4mizer.onContextItemSelected(super.onContextItemSelected(item), item);
  // }

  @Override
  public void onActivityResult(int requestCode, int resultCode, Intent data)
  {
    super.onActivityResult(requestCode, resultCode, data);
    droid4mizer.onActivityResult(requestCode, resultCode, data);
  }

  /**
   * Smartable implementation.
   */

  public AggregrateClass getAggregate()
  {
    return droid4mizer.getAggregate();
  }

  public void setAggregate(AggregrateClass aggregate)
  {
    droid4mizer.setAggregate(aggregate);
  }

  public Handler getHandler()
  {
    return droid4mizer.getHandler();
  }

  public SharedPreferences getPreferences()
  {
    return droid4mizer.getPreferences();
  }

  public void onException(Throwable throwable, boolean fromGuiThread)
  {
    droid4mizer.onException(throwable, fromGuiThread);
  }

  public void registerBroadcastListeners(BroadcastListener[] broadcastListeners)
  {
    droid4mizer.registerBroadcastListeners(broadcastListeners);
  }

  public int getOnSynchronizeDisplayObjectsCount()
  {
    return droid4mizer.getOnSynchronizeDisplayObjectsCount();
  }

  public boolean isRefreshingBusinessObjectsAndDisplay()
  {
    return droid4mizer.isRefreshingBusinessObjectsAndDisplay();
  }

  public boolean isFirstLifeCycle()
  {
    return droid4mizer.isFirstLifeCycle();
  }

  public final boolean isInteracting()
  {
    return droid4mizer.isInteracting();
  }

  public final boolean isAlive()
  {
    return droid4mizer.isAlive();
  }

  public void refreshBusinessObjectsAndDisplay(boolean retrieveBusinessObjects, Runnable onOver, boolean immediately)
  {
    droid4mizer.refreshBusinessObjectsAndDisplay(retrieveBusinessObjects, onOver, immediately);
  }

  /**
   * AppInternals.LifeCycleInternals implementation.
   */

  public boolean shouldKeepOn()
  {
    return droid4mizer.shouldKeepOn();
  }

  public Composite getCompositeActionHandler()
  {
    return droid4mizer.getCompositeActionHandler();
  }

  public CompositeHandler getCompositeActivityResultHandler()
  {
    return droid4mizer.getCompositeActivityResultHandler();
  }

  /**
   * Own implementation.
   */

  public void onBusinessObjectsRetrieved()
  {
  }

  public List<StaticMenuCommand> getMenuCommands()
  {
    return null;
  }

  /**
   * Same as invoking {@link #refreshBusinessObjectsAndDisplay(true, null, false)}.
   * 
   * @see #refreshBusinessObjectsAndDisplay(boolean, Runnable, boolean)
   */
  public final void refreshBusinessObjectsAndDisplay()
  {
    refreshBusinessObjectsAndDisplay(true, null, false);
  }

  /**
   * Specific implementation.
   */

  /**
   * Does the same thing as the {@link #getActivity()}, except that it throws an exception if the fragment has been detached, instead of returning
   * {@code null}
   * 
   * @return a never-null activity, which is the hosting activity
   * @throws IllegalStateException
   *           if the fragment activity is currently null
   */
  public final Activity getCheckedActivity()
      throws IllegalStateException
  {
    if (getActivity() == null)
    {
      // This will generate an IllegalStateException
      getResources();
    }
    return getActivity();
  }

}
