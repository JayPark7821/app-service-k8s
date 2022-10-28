package kr.perfume.api.core.tempuser;

import kr.perfume.api.composite.auth.OAuth2UserInfo;
import kr.perfume.api.core.enums.ProviderType;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TempUserDto {

    private String userUuid;
    private String userId;
    private String username;
    private String email;
    private ProviderType providerType;
    private String profileImageUrl;


    @Builder
    public TempUserDto(String userUuid, String userId, String username, String email, ProviderType providerType, String profileImageUrl) {
        this.userUuid = userUuid;
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.providerType = providerType;
        this.profileImageUrl = profileImageUrl;
    }

    public TempUserDto(String userUuid, OAuth2UserInfo userInfo, ProviderType providerType) {
        this.userUuid = userUuid;
        this.userId = userInfo.getId();
        this.username = userInfo.getName();
        this.email = userInfo.getEmail();
        this.providerType = providerType;
        this.profileImageUrl = userInfo.getImageUrl();
    }
}