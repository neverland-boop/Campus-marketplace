package controllers;

import io.javalin.http.Context;
import java.util.Map;

public class demo {
    public static void showWelcome(Context ctx) {
        // This is your logic
        String campusName = "Makerere University";
        int activeAds = 154;

        // You put the variables into a Map (Key -> Value)
        Map<String, Object> model = Map.of(
                "university", campusName,
                "count", activeAds
        );

        // render() sends the map to the HTML
        ctx.render("public/index.html", model);
    }
}
