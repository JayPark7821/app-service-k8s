package kr.perfume.userservice.persistence;


import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.perfume.api.core.enums.ProviderType;
import kr.perfume.api.core.enums.RoleType;
import kr.perfume.api.core.user.UserDto;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "user_table")
public class User {

    @JsonIgnore
    @Id
    @Column(name = "user_seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userSeq;

    @Column(name = "user_id", length = 64, unique = true)
    @NotNull
    @Size(max = 64)
    private String userId;

    @Column(name = "username", length = 100)
    @NotNull
    @Size(max = 100)
    private String username;

    @JsonIgnore
    @Column(name = "password", length = 128)
    @NotNull
    @Size(max = 128)
    private String password;

    @Column(name = "email", length = 512, unique = true)
    @NotNull
    @Size(max = 512)
    private String email;

    @Column(name = "email_verified_yn", length = 1)
    @NotNull
    @Size(min = 1, max = 1)
    private String emailVerifiedYn;

    @Column(name = "profile_image_url", length = 512)
    @Size(max = 512)
    private String profileImageUrl;

    @Column(name = "provider_type", length = 20)
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Column(name = "role_type", length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoleType roleType;

    @Builder
    public User(String userId, String username, String password, String email, String emailVerifiedYn,
                String profileImageUrl, ProviderType providerType, RoleType roleType) {

        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.emailVerifiedYn = emailVerifiedYn;
        this.profileImageUrl = profileImageUrl;
        this.providerType = providerType;
        this.roleType = roleType;
    }

    public User(UserDto userDto) {
        this.userId = userDto.getUserId();
        this.username = userDto.getName();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
        this.emailVerifiedYn = "Y";
        this.profileImageUrl = userDto.getProfileImage();
        this.providerType = userDto.getProviderType();
        this.roleType = userDto.getRoleType();
    }

    public UserDto toDto() {
        return UserDto.builder()
                .userSeq(this.getUserSeq())
                .email(this.getEmail())
                .name(this.getUsername())
                .providerType(this.getProviderType())
                .profileImage(this.profileImageUrl)
                .roleType(this.roleType)
                .build();
    }

}
