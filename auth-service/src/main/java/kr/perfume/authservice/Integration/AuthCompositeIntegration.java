package kr.perfume.authservice.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.perfume.api.core.tempuser.TempUserController;
import kr.perfume.api.core.tempuser.TempUserDto;
import kr.perfume.api.core.user.UserController;
import kr.perfume.api.core.user.UserDto;
import kr.perfume.utils.enums.ErrorCode;
import kr.perfume.utils.exception.PerfumeApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class AuthCompositeIntegration implements UserController, TempUserController {

    private final WebClient webClient;
    private final RestTemplate restTemplate;
    private final ObjectMapper mapper;

    private final String userServiceUrl;
    private final String tempUserServiceUrl;

    @Autowired
    public AuthCompositeIntegration(

            WebClient.Builder webClient,
            RestTemplate restTemplate,
            ObjectMapper mapper,

            @Value("${app.user-service.host}") String userServiceHost,
            @Value("${app.user-service.port}") int userServicePort,

            @Value("${app.tempuser-service.host}") String tempUserServiceHost,
            @Value("${app.tempuser-service.port}") int tempServicePort

    ) {

        this.webClient = webClient.build();
        this.restTemplate = restTemplate;
        this.mapper = mapper;

        userServiceUrl = "http://" + userServiceHost + ":" + userServicePort + "/api/v1/user";
        tempUserServiceUrl = "http://" + tempUserServiceHost + ":" + tempServicePort + "/api/v1/tempuser";
    }

    @Override
    public UserDto getUserByEmail(String email) {
        try {
            String requestUrl = userServiceUrl + "/" + email;
            return restTemplate.getForObject(requestUrl, UserDto.class);
        } catch (HttpClientErrorException ex) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        try {
            String requestUrl = userServiceUrl + "/user";
            return restTemplate.postForObject(requestUrl, userDto, UserDto.class);
        } catch (HttpClientErrorException ex) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public TempUserDto forceSaveTempUser(TempUserDto tempUserDto) {
        try {
            String requestUrl = tempUserServiceUrl + "/force-save";
            return restTemplate.postForObject(requestUrl, tempUserDto, TempUserDto.class);
        } catch (HttpClientErrorException ex) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public TempUserDto getTempUserByTempUserId(String tempUserId) {
        try {
            String requestUrl = tempUserServiceUrl + "/tempuser/" + tempUserId;
            return restTemplate.getForObject(requestUrl, TempUserDto.class);
        } catch (HttpClientErrorException ex) {
            throw new PerfumeApplicationException(ErrorCode.INTERNAL_SERVER_ERROR);
        }
    }
}
