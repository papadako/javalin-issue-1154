package bug.routes;

import bug.controller.TestController;
import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

/**
 * Describe here all routes
 */
public class TestRoute {

    public static void routes(Javalin app) {
        app.routes(() -> {
            path("/", () -> {
                path("/:testID", () -> {
                    get(TestController::retrieve);
                });
            });
        });
    }
}
