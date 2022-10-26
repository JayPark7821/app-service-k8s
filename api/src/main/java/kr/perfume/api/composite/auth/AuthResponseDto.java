package kr.perfume.api.composite.auth;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import kr.perfume.api.core.user.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthResponseDto {

    private String tempUserId;
    private String email;
    private String name;
    private ProviderType providerType;
    private RoleType roleType;
    private String profileImage;
    private String accessToken;
    private String refreshToken;


    public AuthResponseDto(UserDto user, String accessToken, String refreshToken) {
        this.email = user.getEmail();
        this.name = user.getName();
        this.profileImage = user.getProfileImage();
        this.providerType = user.getProviderType();
        this.roleType = user.getRoleType();
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }


    public AuthResponseDto(String tempUserId, String email, String name, ProviderType providerType,
                           String profileImage ) {
        this.tempUserId = tempUserId;
        this.email = email;
        this.name = name;
        this.providerType = providerType;
        this.profileImage = profileImage;
    }
}
