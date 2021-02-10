package bug.controller;

import bug.controller.responses.*;
import bug.controller.responses.SuccessResponse;
import io.javalin.http.*;
import io.javalin.plugin.openapi.annotations.*;

public class TestController {

    @OpenApi(
            summary = "This is a summary",
            operationId = "some operation id",
            path = "/contextPath/:testID", // I believe we should not have this contextPath here!
            //path = "/:testID", // but removing it leads to problems
            method = HttpMethod.GET,
            tags = {"SOMETAG"},
            pathParams = {@OpenApiParam(name = "testID", type = String.class, description = "The test ID")},
            responses = {
                    @OpenApiResponse(status = "200", content = {@OpenApiContent(from = SuccessResponse.class)}),
                    @OpenApiResponse(status = "400", content = {@OpenApiContent(from = ErrorResponse.class)}),
                    @OpenApiResponse(status = "404", content = {@OpenApiContent(from = ErrorResponse.class)})
            }
    )

    public static void retrieve(Context ctx) {
        String testID = ctx.pathParam("testID");
        ctx.json(new SuccessResponse(
                "Successful retrieve",
                200,
                "SuccessResponse",
                testID));
    }
}

