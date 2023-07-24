package com.health.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

/**
 * @author wuyang
 * @ClassName JwtUtils用来生成签名，校验签名，通过签名
 * @Description TODO
 * @Version 1.0
 **/
public class JwtUtils {
    //过期30分钟
    private static final long  EXPIRE_TIME = 20 * 60 * 1000 ;
    //密钥
    private static final String  SECRET = "jwt_secret";
    /**
     * @Author wuyang
     * @Description TODO 生成签名，30分钟后过期
     * @Param [username]
     * @return java.lang.String
     **/
    public static String sign(String userRole){
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        JWTCreator.Builder builder = JWT.create();
        //将权限写入到Token中
        builder.withAudience(userRole);
       // 设值token的生存期 30分钟后过期
        builder.withExpiresAt(date);
        // 设值token的密钥
        String sign = builder.sign(algorithm);
        //        String sign1 = JWT.create()
        //                .withAudience(userId)
        //                .withExpiresAt(date)
        //                .sign(algorithm);

        return sign ;
    }

    /**
     * @Author wuyang
     * @Description 从token中获取userRole
     * @Param [token]
     * @return java.lang.String
     **/
    public static String  getUserRole(String token){
        String userRole = JWT.decode(token).getAudience().get(0);
        return userRole;
    }
    /**
     * @Author wuyang
     * @Description 校验token
     * @Param [token]
     * @return boolean
     **/
    public static boolean checkToken(String token){

        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        //使用与令牌生成相同的算法，构建一个验证令牌的校验器对象
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT verify = jwtVerifier.verify(token);

            if(verify!=null){
                System.out.println("ok");
                return true;
            }
            else{
                System.out.println("no ok");
                return false;
            }

        }catch(Exception ex){
            System.out.println(ex);
            return false;
        }
    }
}

