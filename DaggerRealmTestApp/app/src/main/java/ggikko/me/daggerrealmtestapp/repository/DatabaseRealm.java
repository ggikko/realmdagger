package ggikko.me.daggerrealmtestapp.repository;

import android.content.Context;

import java.util.List;

import javax.inject.Inject;

import ggikko.me.daggerrealmtestapp.dagger.injector.ApplicationInjector;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;

public class DatabaseRealm {

    @Inject Context mContext;

    RealmConfiguration realmConfiguration;

    public DatabaseRealm() {
        ApplicationInjector.getApplicationComponent().inject(this);
    }

    public void setup() {
        if (realmConfiguration == null) {
            realmConfiguration = new RealmConfiguration.Builder(mContext).build();
            Realm.setDefaultConfiguration(realmConfiguration);
        } else {
            throw new IllegalStateException("database already configured");
        }
    }

    public Realm getRealmInstance() {
        return Realm.getDefaultInstance();
    }

    public <T extends RealmObject> T add(T model) {
        Realm realm = getRealmInstance();
        realm.beginTransaction();
        realm.copyToRealm(model);
        realm.commitTransaction();
        return model;
    }

    public <T extends RealmObject> List<T> findAll(Class<T> clazz) {
        return getRealmInstance().where(clazz).findAll();
    }

    public <T extends RealmObject> void deleteAll(Class<T> clazz) {
        getRealmInstance().delete(clazz);
    }


}
