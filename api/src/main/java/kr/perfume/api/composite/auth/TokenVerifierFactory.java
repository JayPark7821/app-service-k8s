package kr.perfume.api.composite.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;


public interface TokenVerifierFactory {
	OAuth2UserInfo verifyTdToken(String token) throws GeneralSecurityException, IOException;
}
