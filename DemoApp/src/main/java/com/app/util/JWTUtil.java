package com.app.util;
import java.util.Date;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class JWTUtil {
	static String SECRET = "thisistopsecrecode";
	// This line is used for data encryption using SHA 256 (Secure Hash Algorithm)
	// ref - bcrypt
	static Algorithm algo = Algorithm.HMAC256(SECRET);
	static long expireTime = 10 * 60 * 1000; // this is 10 mins in mili secs
	static Date currentDateTime = new Date();
	static long currentTime = currentDateTime.getTime();
	static Date expireDateTime = new Date(currentTime + expireTime);
	//this function is used to create a JWT token
	public static String createToken(String email, int OTP) {
		String token = JWT.create()
		.withIssuedAt(currentDateTime)
		.withExpiresAt(expireDateTime)
		.withSubject(email)
//		.withClaim("phoneNum", phone)
//		.withClaim("userName", name)
//		.withClaim("gender", gender)
		.withIssuer("SEC-C")
		.withClaim("otp", OTP)
		.sign(algo);
//		System.out.println(token);
		return token;
	}
	
	public static void verifyJWT(String token) {
		try {
			DecodedJWT decodedToken = JWT.require(algo)
					.build().verify(token);
			System.out.println("THE TOKEN IS VALID");
			System.out.println("The issuer name is " + decodedToken.getIssuer());
			System.out.println("The email add is " + decodedToken.getSubject());
			System.out.println("The user name is " + decodedToken.getClaim("userName"));
			System.out.println("The user phone is " + decodedToken.getClaim("phoneNum"));
			System.out.println("The user gender is " + decodedToken.getClaim("gender"));
			System.out.println("The OTP is " + decodedToken.getClaim("otp"));
			System.out.println("Token issue time is " + decodedToken.getIssuedAt());
			System.out.println("Token expire time is " + decodedToken.getExpiresAt());
		} catch (Exception e) {
			System.out.println("THE TOKEN IS EXPIRED, PLEASE RETRY");
		}
	
	}
	
	public static void main(String s []) {
//		createToken("admin@rdec.in", 123123, "Ayush Singh", "M", 123456);
		String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE3NjQwNDYxODksImV4cCI6MTc2NDA0Njc4OSwic3ViIjoiYWRtaW5AcmRlYy5pbiIsInBob25lTnVtIjoxMjMxMjMsInVzZXJOYW1lIjoiQXl1c2ggU2luZ2giLCJnZW5kZXIiOiJNIiwiaXNzIjoiU0VDLUMiLCJvdHAiOjEyMzQ1Nn0.MV4uHejor_9jRXx_6bnepmhJTiSDNUzGGNmrrGElkqc";
		verifyJWT(token);
	}
}
