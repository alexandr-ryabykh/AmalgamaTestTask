package api.factories;

import api.Api;
import api.TestApi;

public class ApiFactory {
    public static Api create() {
        return new TestApi();
    }
}
