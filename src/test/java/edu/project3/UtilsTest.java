package edu.project3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.project3.Utils.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.Map;
import java.util.List;

public class UtilsTest {
    private static final List<Log> logs = List.of(
        Log.generateLog(
            "5.63.153.125 - - [21/May/2015:03:05:26 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404 337 \"-\" \"Debian APT-HTTP/1.3 (0.9.7.8)\"\n"),
        Log.generateLog(
            "5.63.153.125 - - [29/May/2015:18:05:40 +0000] \"PUT /downloads/product_2 HTTP/1.1\" 404 338 \"-\" \"Debian APT-HTTP/1.3 (1.0.1ubuntu2)\"\n"),
        Log.generateLog(
            "93.180.71.3 - - [17/May/2021:08:05:32 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.21)\"\n"),
        Log.generateLog(
            "54.172.110.13 - - [28/May/2023:07:05:53 +0000] \"GET /downloads/product_2 HTTP/1.1\" 404 333 \"-\" \"Debian APT-HTTP/1.3 (1.0.1ubuntu2)\"\n"),
        Log.generateLog(
            "79.136.114.202 - - [04/Jun/2023:07:06:50 +0000] \"GET /downloads/product_1 HTTP/1.1\" 404 334 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.22)\"\n")
    );

    @Test
    @DisplayName("Test getRequestResource")
    void TestGetRequestResource() {
        Map<String, Integer> requestResource = getRequestResource(logs);
        assertThat(requestResource.get("/downloads/product_1")).isEqualTo(3);
        assertThat(requestResource.get("/downloads/product_2")).isEqualTo(2);
    }

    @Test
    @DisplayName("Test getStatusCode")
    void TestGetStatusCode() {
        Map<String, Integer> statusCode = getStatusCode(logs);
        assertThat(statusCode.get("404")).isEqualTo(4);
        assertThat(statusCode.get("304")).isEqualTo(1);
    }

    @Test
    @DisplayName("Test getIpAddresse")
    void TestGetIpAddresses() {
        Map<String, Integer> IpAddresses = getIpAddresses(logs);
        assertThat(IpAddresses.get("5.63.153.125")).isEqualTo(2);
        assertThat(IpAddresses.get("93.180.71.3")).isEqualTo(1);
        assertThat(IpAddresses.get("54.172.110.13")).isEqualTo(1);
        assertThat(IpAddresses.get("79.136.114.202")).isEqualTo(1);
    }

    @Test
    @DisplayName("Test getRequestTypes")
    void TestGetRequestTypes() {
        Map<String, Integer> requestTypes = getRequestTypes(logs);
        assertThat(requestTypes.get("GET")).isEqualTo(4);
        assertThat(requestTypes.get("PUT")).isEqualTo(1);
    }

    @Test
    @DisplayName("Test getAverageBytesResponse")
    void TestGetAverageBytesResponse() {
        double averageBytesResponse = getAverageBytesResponse(logs);
        assertThat(averageBytesResponse).isEqualTo(268.4);
    }

}
