package bug.controller.responses;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * An immutable record for error responses
 * <p>
 * title holds the title of the error (description of the specific error)
 * status holds the status code (400, 404, ...)
 * type holds the descriptions of the status code (NOT FOUND, etc...)
 * details holds in a map any more specific information (e.g., errors in specific input)
 */
public record ErrorResponse(String title, int status, String type, Map<String, String> details) {
    public ErrorResponse(String title, int status, String type, Map<String, String> details) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(type);

        this.title = title;
        this.status = status;
        this.type = type;
        if (details == null) {
            this.details = new HashMap<>();
        } else {
            this.details = details;
        }
    }
};
