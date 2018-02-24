package ch.khinkali.cryptowatch.user.events.entity;

import ch.khinkali.cryptowatch.events.entity.BaseEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.json.Json;
import javax.json.JsonObject;

@AllArgsConstructor
@Getter
public class UserCreated implements BaseEvent {
    public static final String TOPIC = "users";

    private final String userId;
    private final String username;

    public UserCreated(JsonObject jsonObject) {
        this(jsonObject.getString("userId"),
                jsonObject.getString("username"));
    }

    @Override
    public JsonObject getJson() {
        return Json.createObjectBuilder()
                .add("userId", userId)
                .add("username", username)
                .build();
    }


}
