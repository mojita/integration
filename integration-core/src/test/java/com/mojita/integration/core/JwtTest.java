package com.mojita.integration.core;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author lijunhong
 * @since 18/6/11 上午10:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTest {


    @Test
    public void createToken() {
        Map<String,Object> payload = new HashMap<>();
        Date date = new Date();
        test1(payload, date);
    }


    public void test1(Map<String, Object> payload, Date date) {

        payload.put("uid", "2008");
        payload.put("iat",date.getTime());
        long time = date.getTime() + 1000 * 60 * 2;
        payload.put("ext", time);
    }

    //这里采用的是HMAC256方式进行加密
    @Test
    public void getKey() throws UnsupportedEncodingException {
        Algorithm algorithm = Algorithm.HMAC256("secret");
        String token = JWT.create().withIssuer("auth0").sign(algorithm);
        System.out.println(algorithm.toString());
        //上面是生成token


        //下面是验证token
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer("auth0")
                .build();
        DecodedJWT decodedJWT = verifier.verify(token);


        print(decodedJWT, token);

        //进行token解码
        DecodedJWT jwt = JWT.decode(token);
        System.out.println(jwt);
    }

    public void print(DecodedJWT decodedJWT, String token) {
        System.out.println(decodedJWT);
        System.out.println(token);
    }


    //下面是采用的RSA256进行加密
//    @Test
//    public void


























}
