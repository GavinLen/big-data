package xyz.ieden.entity;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpRequest;
import org.springframework.lang.Nullable;

import java.net.URI;

/**
 * @author ThinkPad
 * @date Created by 2018/4/18 13:46
 */
public class EdenRequest implements HttpRequest{

    private HttpMethod method;
    private URI uri;
    private HttpHeaders headers;
    private String host;
    private String path;

    @Override
    public String getMethodValue() {
        String methodValue = "";
        if (this.method != null) {
            methodValue = this.method.name();
        }
        return methodValue;
    }

    @Override
    public URI getURI() {
        return this.uri;
    }

    @Nullable
    @Override
    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }

    @Override
    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
