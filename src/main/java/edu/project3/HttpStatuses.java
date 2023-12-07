package edu.project3;

public class HttpStatuses {
    protected HttpStatuses() {

    }

    private static final java.util.Map<String, String> STATUS_HTTP = new java.util.HashMap<>();

    static {
        initializeHttpStatusMap();
    }

    private static void initializeHttpStatusMap() {
        STATUS_HTTP.put("100", "Continue");
        STATUS_HTTP.put("101", "Switching Protocols");
        STATUS_HTTP.put("102", "Processing ");
        STATUS_HTTP.put("200", "OK");
        STATUS_HTTP.put("201", "Created");
        STATUS_HTTP.put("202", "Accepted");
        STATUS_HTTP.put("203", "Non-Authoritative Information");
        STATUS_HTTP.put("204", "No Content");
        STATUS_HTTP.put("205", "Reset Content");
        STATUS_HTTP.put("206", "Partial Content");
        STATUS_HTTP.put("207", "Multi-Status");
        STATUS_HTTP.put("208", "Already Reported");
        STATUS_HTTP.put("226", "IM Used");
        STATUS_HTTP.put("300", "Multiple Choices");
        STATUS_HTTP.put("301", "Moved Permanently");
        STATUS_HTTP.put("302", "Moved Temporarily");
        STATUS_HTTP.put("303", "See Other");
        STATUS_HTTP.put("304", "Not Modified");
        STATUS_HTTP.put("305", "Use Proxy");
        STATUS_HTTP.put("307", "Temporary Redirect");
        STATUS_HTTP.put("308", "Permanent Redirect");
        STATUS_HTTP.put("400", "Bad Request");
        STATUS_HTTP.put("401", "Unauthorized");
        STATUS_HTTP.put("402", "Payment Required");
        STATUS_HTTP.put("403", "Forbidden");
        STATUS_HTTP.put("404", "Not Found");
        STATUS_HTTP.put("405", "Method Not Allowed");
        STATUS_HTTP.put("406", "Not Acceptable");
        STATUS_HTTP.put("407", "Proxy Authentication Required");
        STATUS_HTTP.put("408", "Request Timeout");
        STATUS_HTTP.put("409", "Conflict");
        STATUS_HTTP.put("410", "Gone");
        STATUS_HTTP.put("411", "Length Required");
        STATUS_HTTP.put("412", "Precondition Failed");
        STATUS_HTTP.put("413", "Payload Too Large");
        STATUS_HTTP.put("414", "URI Too Long (URI");
        STATUS_HTTP.put("415", "Unsupported Media Type");
        STATUS_HTTP.put("416", "Range Not Satisfiable");
        STATUS_HTTP.put("417", "Expectation Failed");
        STATUS_HTTP.put("418", "I’m a teapot");
        STATUS_HTTP.put("421", "Misdirected Request");
        STATUS_HTTP.put("422", "Unprocessable Entity");
        STATUS_HTTP.put("423", "Locked");
        STATUS_HTTP.put("424", "Failed Dependency");
        STATUS_HTTP.put("425", "Too Early");
        STATUS_HTTP.put("426", "Upgrade Required");
        STATUS_HTTP.put("428", "Precondition Required");
        STATUS_HTTP.put("429", "Too Many Requests");
        STATUS_HTTP.put("431", "Request Header Fields Too Large");
        STATUS_HTTP.put("451", "Unavailable For Legal Reasons");
        STATUS_HTTP.put("500", "Internal Server Error");
        STATUS_HTTP.put("501", "Not Implemented");
        STATUS_HTTP.put("502", "Bad Gateway");
        STATUS_HTTP.put("503", "Service Unavailable");
        STATUS_HTTP.put("504", "Gateway Timeout");
        STATUS_HTTP.put("505", "HTTP Version Not Supported");
        STATUS_HTTP.put("506", "Variant Also Negotiates");
        STATUS_HTTP.put("507", "Insufficient Storage");
        STATUS_HTTP.put("508", "Loop Detected");
        STATUS_HTTP.put("510", "Not Extended");
        STATUS_HTTP.put("511", "Network Authentication Required");
    }

    public static String getDescriptionByCode(final String code) {
        return STATUS_HTTP.get(code);
    }
}
