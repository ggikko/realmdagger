package ggikko.me.daggerrealmtestapp.dagger.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.daggerrealmtestapp.GgikkoApplication;

/**
 * Created by admin on 16. 5. 29..
 */
@Module
public class GgikkoApplicationModule {

    private GgikkoApplication mGgikkoApplication;

    public GgikkoApplicationModule(GgikkoApplication mGgikkoApplication){
        this.mGgikkoApplication = mGgikkoApplication;
    }


    @Provides
    @Singleton
    public Context applicationContext() {
        return mGgikkoApplication.getApplicationContext();
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPrefs(){
        return PreferenceManager.getDefaultSharedPreferences(mGgikkoApplication);
    }



}
