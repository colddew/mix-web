package edu.ustc.mix.core.util;

import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import edu.ustc.mix.persistence.entity.permission.User;

@Service
public class PasswordUtils {
	
	private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	
	@Value("${password.algorithmName}")
	private String algorithmName;
	
	@Value("${password.hashIterations}")
	private int hashIterations;
	
	public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
		this.randomNumberGenerator = randomNumberGenerator;
	}
	
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
	
	public void setHashIterations(int hashIterations) {
		this.hashIterations = hashIterations;
	}
	
	public void encryptPassword(User user) {
		
		user.setSalt(randomNumberGenerator.nextBytes().toHex());
		
		String password = new SimpleHash(algorithmName, user.getPassword(),
				ByteSource.Util.bytes(user.getCredentialsSalt()),
				hashIterations).toHex();
		
		user.setPassword(password);
	}
}
