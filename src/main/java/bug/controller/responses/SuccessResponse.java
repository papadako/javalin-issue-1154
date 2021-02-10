package bug.controller.responses;

import java.util.Objects;

/**
 * An immutable record for success responses
 * <p>
 * title holds the title of the error (description of the specific error)
 * status holds the status code (400, 404, ...)
 * type holds the descriptions of the status code (NOT FOUND, etc...)
 * details is the representation of the object, if valid
 */
public record SuccessResponse<T>(String title, int status, String type, T details) {
    public SuccessResponse(String title, int status, String type, T details) {
        Objects.requireNonNull(title);
        Objects.requireNonNull(type);
        Objects.requireNonNull(details);

        this.title = title;
        this.status = status;
        this.type = type;
        this.details = details;
    }
};
