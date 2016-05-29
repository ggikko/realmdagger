package ggikko.me.daggerrealmtestapp.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by admin on 16. 5. 29..
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Code extends RealmObject {

    private long id;
    private String code;
}
