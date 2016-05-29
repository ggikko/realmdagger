package ggikko.me.daggerrealmtestapp.dagger.component;

import javax.inject.Singleton;

import dagger.Component;
import ggikko.me.daggerrealmtestapp.GgikkoApplication;
import ggikko.me.daggerrealmtestapp.dagger.module.GgikkoApplicationModule;

/**
 * Created by admin on 16. 5. 29..
 */


@Singleton
@Component(modules = GgikkoApplicationModule.class)
public interface GgikkoApplicationComponent {
    void inject(GgikkoApplication application);
}
