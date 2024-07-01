package all_projects.src.designPattern.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.whizdm.mockserver.model.Log;
import com.whizdm.mockserver.model.MockDetails;
import com.whizdm.mockserver.persistence.LogRepository;
import com.whizdm.mockserver.persistence.MockDetailsRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @author : darpan
 * @since : 29/11/21
 */

@RestController
@RequestMapping("v1/mock")
public class MockService {
    @Autowired
    MockDetailsRepository mockDetailsRepository;

    @Autowired
    LogRepository logRepository;

    @PostMapping("/**")
    public @ResponseBody
    ResponseEntity<String> getResponse(@RequestBody(required = false) String body) {
        int statusCode = 404;

        String endpoint = extractEndpoint();
        System.out.println(endpoint);

        MockDetails responseDetails = getMockResponse(endpoint, "POST");

        if(StringUtils.hasLength(responseDetails.getEndpoint())) {
            statusCode = responseDetails.getStatusCode();
        }

        saveDetailsInDB(responseDetails, endpoint);
        return new ResponseEntity(responseDetails.getMockResponse(), getHeaders(responseDetails), HttpStatus.valueOf(statusCode));
    }

    private String extractEndpoint() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest().getRequestURI().replace("/mockserver/v1/mock/","");
    }

    private MockDetails getMockResponse(String endpoint, String methodType) {
        String responseBody = "";
        MockDetails responseDetails = new MockDetails();
        List<MockDetails> mockDetails = mockDetailsRepository.findAllByActiveAndEndpointAndMethodType(Boolean.TRUE, endpoint, methodType);
        if(mockDetails == null || mockDetails.isEmpty()) {
            responseBody = "{\"res\" : \"no endpoint configured for this url\" }";
        } else {
            int length = mockDetails.size();
            int randomInt = new Random().nextInt(100) % length;

            responseDetails = mockDetails.get(randomInt);
            responseBody = responseDetails.getResponse();
            if (StringUtils.hasLength(responseBody)) {
                if (responseBody.contains("{{uniqueId}}")) {
                    responseBody = responseBody.replace("{{uniqueId}}",
                            RandomStringUtils.randomAlphanumeric(20).toUpperCase()
                    );
                }
            }
            putTimeoutIfApplicable(responseDetails.getTimeout());
        }
        responseDetails.setMockResponse(responseBody);
        return responseDetails;
    }

    private boolean putTimeoutIfApplicable(int timeout) {
        if (timeout > 0) {
            try {
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                System.out.println("Unable to put timeout " + e);
                return false;
            }
            return true;
        }
        return false;
    }


    private HttpHeaders getHeaders(MockDetails mockDetails) {
        HttpHeaders headers = new HttpHeaders();
//        headers.add("Content-Type" , "application/json");
        if(StringUtils.hasLength(mockDetails.getHeaders())) {
            try {
                HashMap optionalHeader = new ObjectMapper().readValue(mockDetails.getHeaders(), HashMap.class);

                for(Object key : optionalHeader.keySet()) {
                    headers.add((String) key, optionalHeader.get(key).toString());
                }
            } catch (Exception ignored) {
            }
        }
        return headers;
    }

    @GetMapping("/**")
    public @ResponseBody
    ResponseEntity<String> get(@RequestBody(required = false) String body) {
        int statusCode = 404;

        String endpoint = extractEndpoint();

        MockDetails responseDetails = getMockResponse(endpoint, "GET");

        if(StringUtils.hasLength(responseDetails.getEndpoint())) {
            statusCode = responseDetails.getStatusCode();
        }

        saveDetailsInDB(responseDetails, endpoint);
        return new ResponseEntity(responseDetails.getMockResponse(), getHeaders(responseDetails), HttpStatus.valueOf(statusCode));
    }

    @PutMapping("/**")
    public @ResponseBody
    ResponseEntity<String> getPutResponse(@RequestBody(required = false) String body) {
        int statusCode = 404;

        String endpoint = extractEndpoint();
        System.out.println(endpoint);

        MockDetails responseDetails = getMockResponse(endpoint, "PUT");

        if(StringUtils.hasLength(responseDetails.getEndpoint())) {
            statusCode = responseDetails.getStatusCode();
        }

        saveDetailsInDB(responseDetails, endpoint);
        return new ResponseEntity(responseDetails.getMockResponse(), getHeaders(responseDetails), HttpStatus.valueOf(statusCode));
    }

    @PatchMapping("/**")
    public @ResponseBody
    ResponseEntity<String> getPatchResponse(@RequestBody(required = false) String body) {
        int statusCode = 404;

        String endpoint = extractEndpoint();
        System.out.println(endpoint);

        MockDetails responseDetails = getMockResponse(endpoint, "PATCH");

        if(StringUtils.hasLength(responseDetails.getEndpoint())) {
            statusCode = responseDetails.getStatusCode();
        }

        saveDetailsInDB(responseDetails, endpoint);
        return new ResponseEntity(responseDetails.getMockResponse(), getHeaders(responseDetails), HttpStatus.valueOf(statusCode));
    }

    @DeleteMapping("/**")
    public @ResponseBody
    ResponseEntity<String> getDeleteResponse(@RequestBody(required = false) String body) {
        int statusCode = 404;

        String endpoint = extractEndpoint();
        System.out.println(endpoint);

        MockDetails responseDetails = getMockResponse(endpoint, "DELETE");

        if(StringUtils.hasLength(responseDetails.getEndpoint())) {
            statusCode = responseDetails.getStatusCode();
        }

        saveDetailsInDB(responseDetails, endpoint);
        return new ResponseEntity(responseDetails.getMockResponse(), getHeaders(responseDetails), HttpStatus.valueOf(statusCode));
    }

    private void saveDetailsInDB(MockDetails mockDetails, String endpoint) {
        Log log = new Log();

        log.setEndpoint(endpoint);
        log.setHeaders(mockDetails.getHeaders());
        log.setMethodType(mockDetails.getMethodType());
        log.setStatusCode(mockDetails.getStatusCode());
        log.setResponse(mockDetails.getMockResponse());

        logRepository.save(log);
    }
}
