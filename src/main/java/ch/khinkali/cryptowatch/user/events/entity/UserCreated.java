package ch.khinkali.cryptowatch.user.events.entity;

import ch.khinkali.cryptowatch.events.entity.BaseEvent;
import lombok.Getter;

import javax.json.JsonObject;

@Getter
public class UserCreated extends BaseEvent {
    public static final String TOPIC = "users";

    private final String userId;
    private final String username;

    public UserCreated(final String userId, final String username) {
        this.userId = userId;
        this.username = username;
    }

    public UserCreated(JsonObject jsonObject) {
        this(jsonObject.getString("userId"),
                jsonObject.getString("username"));
    }

}
