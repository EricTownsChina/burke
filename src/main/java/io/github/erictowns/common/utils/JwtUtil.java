package io.github.erictowns.common.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;

/**
 * Description: jwt util
 *
 * @author EricTowns
 * @date 2023/10/22 16:08
 */
public final class JwtUtil {

    private JwtUtil() {}

    public static final SecretKey GENERIC_SECRET_KEY = Jwts.SIG.HS256.key().build();

}
