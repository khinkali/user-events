package ch.khinkali.cryptowatch.user.events.entity;

import ch.khinkali.cryptowatch.events.entity.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.json.JsonObject;

@AllArgsConstructor
@Getter
public class UserCreated extends BaseEvent {
    public static final String TOPIC = "users";

    public enum JSON_KEYS {
        USER_ID("userId"), USERNAME("username");

        @Getter
        String jsonKey;

        JSON_KEYS(String jsonKey) {
            this.jsonKey = jsonKey;
        }
    }

    private final String userId;
    private final String username;

    public UserCreated(JsonObject jsonObject) {
        userId = jsonObject.getString(JSON_KEYS.USER_ID.getJsonKey());
        username = jsonObject.getString(JSON_KEYS.USERNAME.getJsonKey());
    }

    public JsonObject getJson() {
        return getJsonBuilder()
                .add(JSON_KEYS.USER_ID.getJsonKey(), userId)
                .add(JSON_KEYS.USERNAME.getJsonKey(), username)
                .build();
    }

}
