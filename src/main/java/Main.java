import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import io.javalin.rendering.template.JavalinPebble;
import static io.javalin.apibuilder.ApiBuilder.*;
import controllers.demo;

public class Main {
    public static void main(String[] args) {

        // 1. Create the 'app' variable to hold the server instance
        var app = Javalin.create(config -> {

            // Tell Javalin to use Pebble for HTML "reflection"
            config.fileRenderer(new JavalinPebble());

            // Set up the 'public' folder for CSS, JS, and Images
            config.staticFiles.add(staticFiles -> {
                staticFiles.directory = "/public";
                staticFiles.location = Location.CLASSPATH;
            });

            // 2. Setup the Routing Switchboard
            config.routes.apiBuilder(() -> {

                // Home page: Calls the logic in your controller
                get("/", demo::showWelcome);

                // Example Login route (Dynamic page)
                get("/login", ctx -> ctx.render("public/login.html"));
            });

        });

        // 3. Start the server on port 7070
        app.start(7070);
    }
}