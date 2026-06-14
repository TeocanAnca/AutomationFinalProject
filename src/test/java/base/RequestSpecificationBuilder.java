package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RequestSpecificationBuilder {
    private final RequestSpecBuilder requestSpecBuilder;

    public RequestSpecificationBuilder() {
        this.requestSpecBuilder = new RequestSpecBuilder();
    }

    public RequestSpecificationBuilder addHeaders(Map<String, String> defaultHeaders) {
        requestSpecBuilder.addHeaders(defaultHeaders);
        return this;
    }

    public RequestSpecificationBuilder setRelaxedHTTPSValidation() {
        requestSpecBuilder.setRelaxedHTTPSValidation();
        return this;
    }

    public RequestSpecification build() {
        return requestSpecBuilder.build();
    }
}
