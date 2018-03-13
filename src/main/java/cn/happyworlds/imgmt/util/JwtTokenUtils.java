package cn.happyworlds.imgmt.util;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import cn.happyworlds.imgmt.bean.StaffTokenBean;
import cn.happyworlds.imgmt.json.Jackson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtils {

	private static String secretKey = "happyworld";
	private static String issue = "YANWU";
	
	public static long defaultExpPeriod = 24 * 60 * 60 * 1000;
	
	public static String createJwtToken(String id, Object subject, long expPeriod){
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(secretKey);
		Key key = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());
		JwtBuilder jwtBuilder = Jwts.builder();
		jwtBuilder.setId(id);
		jwtBuilder.setSubject(Jackson.writeJson(subject));
		jwtBuilder.setIssuedAt(new Date());
		jwtBuilder.setIssuer(issue);
		jwtBuilder.signWith(signatureAlgorithm, key);
		jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + expPeriod));
		return jwtBuilder.compact();
	}
	public static Object parseJwt(String token){
		Claims clams = Jwts.parser()
				.setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
				.parseClaimsJws(token).getBody();
		return clams.getSubject();
	}
}
