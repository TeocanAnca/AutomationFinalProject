package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.filter.Filter;
import io.restassured.http.*;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.*;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.security.KeyStore;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class RequestSpecificationBuilder implements RequestSpecification {
    private RequestSpecBuilder requestSpecBuilder;

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

    @Override
    public RequestSpecification body(String s) {
        return null;
    }

    @Override
    public RequestSpecification body(byte[] bytes) {
        return null;
    }

    @Override
    public RequestSpecification body(File file) {
        return null;
    }

    @Override
    public RequestSpecification body(InputStream inputStream) {
        return null;
    }

    @Override
    public RequestSpecification body(Object o) {
        return null;
    }

    @Override
    public RequestSpecification body(Object o, ObjectMapper objectMapper) {
        return null;
    }

    @Override
    public RequestSpecification body(Object o, ObjectMapperType objectMapperType) {
        return null;
    }

    @Override
    public RedirectSpecification redirects() {
        return null;
    }

    @Override
    public RequestSpecification cookies(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification cookies(Map<String, ?> map) {
        return null;
    }

    @Override
    public RequestSpecification cookies(Cookies cookies) {
        return null;
    }

    @Override
    public RequestSpecification cookie(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification cookie(String s) {
        return null;
    }

    @Override
    public RequestSpecification cookie(Cookie cookie) {
        return null;
    }

    @Override
    public RequestSpecification params(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification params(Map<String, ?> map) {
        return null;
    }

    @Override
    public RequestSpecification param(String s, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification param(String s, Collection<?> collection) {
        return null;
    }

    @Override
    public RequestSpecification queryParams(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification queryParams(Map<String, ?> map) {
        return null;
    }

    @Override
    public RequestSpecification queryParam(String s, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification queryParam(String s, Collection<?> collection) {
        return null;
    }

    @Override
    public RequestSpecification formParams(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification formParams(Map<String, ?> map) {
        return null;
    }

    @Override
    public RequestSpecification formParam(String s, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification formParam(String s, Collection<?> collection) {
        return null;
    }

    @Override
    public RequestSpecification pathParam(String s, Object o) {
        return null;
    }

    @Override
    public RequestSpecification pathParams(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification pathParams(Map<String, ?> map) {
        return null;
    }

    @Override
    public RequestSpecification config(RestAssuredConfig restAssuredConfig) {
        return null;
    }

    @Override
    public RequestSpecification keyStore(String s, String s1) {
        return null;
    }

    @Override
    public RequestSpecification keyStore(File file, String s) {
        return null;
    }

    @Override
    public RequestSpecification trustStore(String s, String s1) {
        return null;
    }

    @Override
    public RequestSpecification trustStore(File file, String s) {
        return null;
    }

    @Override
    public RequestSpecification trustStore(KeyStore keyStore) {
        return null;
    }

    @Override
    public RequestSpecification keyStore(KeyStore keyStore) {
        return null;
    }

    @Override
    public RequestSpecification relaxedHTTPSValidation() {
        return null;
    }

    @Override
    public RequestSpecification relaxedHTTPSValidation(String s) {
        return null;
    }

    @Override
    public RequestSpecification headers(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification headers(Map<String, ?> map) {
        return null;
    }

    @Override
    public RequestSpecification headers(Headers headers) {
        return null;
    }

    @Override
    public RequestSpecification header(String s, Object o, Object... objects) {
        return null;
    }

    @Override
    public RequestSpecification header(Header header) {
        return null;
    }

    @Override
    public RequestSpecification contentType(ContentType contentType) {
        return null;
    }

    @Override
    public RequestSpecification contentType(String s) {
        return null;
    }

    @Override
    public RequestSpecification noContentType() {
        return null;
    }

    @Override
    public RequestSpecification accept(ContentType contentType) {
        return null;
    }

    @Override
    public RequestSpecification accept(String s) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(MultiPartSpecification multiPartSpecification) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(File file) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, File file) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, File file, String s1) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, Object o) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, Object o, String s1) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1, Object o, String s2) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1, byte[] bytes) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1, byte[] bytes, String s2) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1, InputStream inputStream) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1, InputStream inputStream, String s2) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1) {
        return null;
    }

    @Override
    public RequestSpecification multiPart(String s, String s1, String s2) {
        return null;
    }

    @Override
    public AuthenticationSpecification auth() {
        return null;
    }

    @Override
    public RequestSpecification csrf(String s) {
        return null;
    }

    @Override
    public RequestSpecification csrf(String s, String s1) {
        return null;
    }

    @Override
    public RequestSpecification disableCsrf() {
        return null;
    }

    @Override
    public RequestSpecification port(int i) {
        return null;
    }

    @Override
    public RequestSpecification spec(RequestSpecification requestSpecification) {
        return null;
    }

    @Override
    public RequestSpecification sessionId(String s) {
        return null;
    }

    @Override
    public RequestSpecification sessionId(String s, String s1) {
        return null;
    }

    @Override
    public RequestSpecification urlEncodingEnabled(boolean b) {
        return null;
    }

    @Override
    public RequestSpecification filter(Filter filter) {
        return null;
    }

    @Override
    public RequestSpecification filters(List<Filter> list) {
        return null;
    }

    @Override
    public RequestSpecification filters(Filter filter, Filter... filters) {
        return null;
    }

    @Override
    public RequestSpecification noFilters() {
        return null;
    }

    @Override
    public <T extends Filter> RequestSpecification noFiltersOfType(Class<T> aClass) {
        return null;
    }

    @Override
    public RequestLogSpecification log() {
        return null;
    }

    @Override
    public ResponseSpecification response() {
        return null;
    }

    @Override
    public RequestSpecification and() {
        return null;
    }

    @Override
    public RequestSpecification with() {
        return null;
    }

    @Override
    public ResponseSpecification then() {
        return null;
    }

    @Override
    public ResponseSpecification expect() {
        return null;
    }

    @Override
    public RequestSpecification when() {
        return null;
    }

    @Override
    public RequestSpecification given() {
        return null;
    }

    @Override
    public RequestSpecification that() {
        return null;
    }

    @Override
    public RequestSpecification request() {
        return null;
    }

    @Override
    public RequestSpecification baseUri(String s) {
        return null;
    }

    @Override
    public RequestSpecification basePath(String s) {
        return null;
    }

    @Override
    public RequestSpecification proxy(String s, int i) {
        return null;
    }

    @Override
    public RequestSpecification proxy(String s) {
        return null;
    }

    @Override
    public RequestSpecification proxy(int i) {
        return null;
    }

    @Override
    public RequestSpecification proxy(String s, int i, String s1) {
        return null;
    }

    @Override
    public RequestSpecification proxy(URI uri) {
        return null;
    }

    @Override
    public RequestSpecification proxy(ProxySpecification proxySpecification) {
        return null;
    }

    @Override
    public Response get(String s, Object... objects) {
        return null;
    }

    @Override
    public Response get(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response post(String s, Object... objects) {
        return null;
    }

    @Override
    public Response post(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response put(String s, Object... objects) {
        return null;
    }

    @Override
    public Response put(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response delete(String s, Object... objects) {
        return null;
    }

    @Override
    public Response delete(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response head(String s, Object... objects) {
        return null;
    }

    @Override
    public Response head(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response patch(String s, Object... objects) {
        return null;
    }

    @Override
    public Response patch(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response options(String s, Object... objects) {
        return null;
    }

    @Override
    public Response options(String s, Map<String, ?> map) {
        return null;
    }

    @Override
    public Response get(URI uri) {
        return null;
    }

    @Override
    public Response post(URI uri) {
        return null;
    }

    @Override
    public Response put(URI uri) {
        return null;
    }

    @Override
    public Response delete(URI uri) {
        return null;
    }

    @Override
    public Response head(URI uri) {
        return null;
    }

    @Override
    public Response patch(URI uri) {
        return null;
    }

    @Override
    public Response options(URI uri) {
        return null;
    }

    @Override
    public Response get(URL url) {
        return null;
    }

    @Override
    public Response post(URL url) {
        return null;
    }

    @Override
    public Response put(URL url) {
        return null;
    }

    @Override
    public Response delete(URL url) {
        return null;
    }

    @Override
    public Response head(URL url) {
        return null;
    }

    @Override
    public Response patch(URL url) {
        return null;
    }

    @Override
    public Response options(URL url) {
        return null;
    }

    @Override
    public Response get() {
        return null;
    }

    @Override
    public Response post() {
        return null;
    }

    @Override
    public Response put() {
        return null;
    }

    @Override
    public Response delete() {
        return null;
    }

    @Override
    public Response head() {
        return null;
    }

    @Override
    public Response patch() {
        return null;
    }

    @Override
    public Response options() {
        return null;
    }

    @Override
    public Response request(Method method) {
        return null;
    }

    @Override
    public Response request(String s) {
        return null;
    }

    @Override
    public Response request(Method method, String s, Object... objects) {
        return null;
    }

    @Override
    public Response request(String s, String s1, Object... objects) {
        return null;
    }

    @Override
    public Response request(Method method, URI uri) {
        return null;
    }

    @Override
    public Response request(Method method, URL url) {
        return null;
    }

    @Override
    public Response request(String s, URI uri) {
        return null;
    }

    @Override
    public Response request(String s, URL url) {
        return null;
    }
}
