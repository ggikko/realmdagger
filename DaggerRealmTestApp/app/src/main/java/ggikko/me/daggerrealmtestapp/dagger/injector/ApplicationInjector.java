package ggikko.me.daggerrealmtestapp.dagger.injector;

import ggikko.me.daggerrealmtestapp.GgikkoApplication;
import ggikko.me.daggerrealmtestapp.dagger.component.GgikkoApplicationComponent;
import lombok.Getter;

public class ApplicationInjector {

//    private ApplicationInjector(){}

    @Getter
    private static GgikkoApplicationComponent applicationComponent;

    public ApplicationInjector(GgikkoApplicationComponent applicationComponent) {
        this.applicationComponent = applicationComponent;
    }

    public void inject(GgikkoApplication application) {
        applicationComponent.inject(application);
    }
}
