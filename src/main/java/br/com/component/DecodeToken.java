package br.com.component;

import com.auth0.jwt.JWT;

import java.util.Optional;

public class DecodeToken {

    public static String getFunctionalInToken(final String token) {
        return getDataTokenByKey(token, "key")
                .orElseThrow(() -> new NotFoundException(""));
    }

    public static Optional<String> getDataTokenByKey(final String token, final String key) {
        final var jwt = JWT.decode(token);
        final var value = jwt.getClaims().get(key);

        return Optional.ofNullable(value.asString());
    }
}
