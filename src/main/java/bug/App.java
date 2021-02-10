package bug;

import bug.routes.TestRoute;
import com.google.common.io.Resources;
import bug.routes.APIRoute;

import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

import java.util.Properties;
import java.util.function.Consumer;

public class App {
    /**
     * Set the configuration for our instance
     */
    public static Consumer<JavalinConfig> setConfig = (config) -> {

        // Set up openAPI
        config.registerPlugin(APIRoute.getConfiguredOpenApiPlugin());

        // Set contextpath
        config.contextPath = "/contextPath";

        // Set default content type
        config.defaultContentType = "application/json";

    };

    /**
     * Main of our service
     *
     * @param args
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException {
        try {

            // Create instance of service (getty for now)
            Javalin app = Javalin.create(setConfig);

            String hostname = "localhost";
            Integer port = 9999;

            // Start the service
            app.start(hostname, port);

            // Add login routes
            TestRoute.routes(app);

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
