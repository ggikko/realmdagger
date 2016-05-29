package ggikko.me.daggerrealmtestapp.dagger.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ggikko.me.daggerrealmtestapp.repository.DatabaseRealm;

/**
 * Created by ggikko on 16. 5. 27..
 */
@Module
public class RepositoryModule {

    /**
     * realm database singleton object
     * @return
     */
    @Provides
    @Singleton
    public DatabaseRealm provideDatabaseRealm() {
        return new DatabaseRealm();
    }
}
