package bug.routes;

import com.google.common.io.Resources;
import io.javalin.plugin.openapi.InitialConfigurationCreator;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;

import java.util.Properties;

import static io.javalin.core.security.SecurityUtil.roles;

/**
 * Describe here all routes related to this specific API
 */
public class APIRoute {
    /**
     * Initialize openAPI plugin
     */
    public static OpenApiPlugin getConfiguredOpenApiPlugin() {
        InitialConfigurationCreator initialConfigurationCreator = () -> {
            String hostname = "localhost";
            String basePath = "/";
            String port = "9999";
            String scheme = "http://";

            // Create the server path
            String serverURL = scheme + hostname + ":" + port + basePath;

            return new OpenAPI()
                    .info(new Info().version("0.1").description("javalin-issue-1154"))
                    .addServersItem(new Server().url(serverURL).description("live-version"));
        };

        OpenApiOptions options = new OpenApiOptions(initialConfigurationCreator)
                .activateAnnotationScanningFor("bug")
                .path("/swagger-docs") // endpoint for OpenAPI json
                .swagger(new SwaggerOptions("/")) // endpoint for swagger-ui
                .defaultDocumentation(doc -> {
                });
        return new OpenApiPlugin(options);
    }
}
