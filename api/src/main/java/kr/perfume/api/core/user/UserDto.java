package kr.perfume.api.core.user;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserDto {

    private Long userSeq;
    private String userId;
    private String email;
    private String name;
    private ProviderType providerType;
    private RoleType roleType;
    private String profileImage;
    private String password;

    @Builder
    public UserDto(Long userSeq, String userId, String email, String name, ProviderType providerType, RoleType roleType, String profileImage, String password) {
        this.userSeq = userSeq;
        this.userId = userId;
        this.email = email;
        this.name = name;
        this.providerType = providerType;
        this.roleType = roleType;
        this.profileImage = profileImage;
        this.password = password;
    }
}
