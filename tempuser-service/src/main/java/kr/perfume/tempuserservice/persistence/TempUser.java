package kr.perfume.tempuserservice.persistence;

import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.tempuser.TempUserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "temp_user")
public class TempUser {

    @Id
    @Column(name = "user_uuid")
    private String userUuid;

    @Column(name = "user_id", length = 64, unique = true)
    @NotNull
    @Size(max = 64)
    private String userId;

    @Column(name = "username", length = 100)
    @NotNull
    @Size(max = 100)
    private String username;

    @Column(name = "email", length = 512, unique = true)
    @NotNull
    @Size(max = 512)
    private String email;

    @Column(name = "provider_type", length = 20)
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Column(name = "profile_image_url", length = 512)
    @Size(max = 512)
    private String profileImageUrl;


    public TempUser(TempUserDto tempUserDto) {
        this.userUuid = tempUserDto.getUserUuid();
        this.userId = tempUserDto.getUserId();
        this.username = tempUserDto.getUsername();
        this.email = tempUserDto.getEmail();
        this.providerType = tempUserDto.getProviderType();
        this.profileImageUrl = tempUserDto.getProfileImageUrl();
    }

    public void updateTempUser(TempUserDto tempUserDto) {
        this.userUuid = tempUserDto.getUserUuid();
        this.userId = tempUserDto.getUserId();
        this.username = tempUserDto.getUsername();
        this.email = tempUserDto.getEmail();
        this.providerType = tempUserDto.getProviderType();
        this.profileImageUrl = tempUserDto.getProfileImageUrl();
    }

    public TempUserDto toDto() {
        return TempUserDto.builder()
                .userUuid(this.userUuid)
                .userId(this.userId)
                .username(this.username)
                .email(this.email)
                .providerType(this.providerType)
                .profileImageUrl(this.profileImageUrl)
                .build();
    }

}