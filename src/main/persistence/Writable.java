package persistence;

import org.json.JSONObject;

public interface Writable {
    // Code source: JsonSerializationDemo file: https://github.com/stleary/JSON-java
    // EFFECTS: returns this as JSON object
    JSONObject toJson();

}
