package edu.ustc.mix.openapi.service;

import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TopOpenAPI implements OpenAPI {

	@Autowired
	@Qualifier("topOpenAPIConfig")
	private OpenAPIConfig openAPIConfig;
	
	@Override
	public OpenAPIConfig getOpenAPIConfig() throws Exception {
		return openAPIConfig;
	}

	@Override
	public AccessToken convertResponseToAccessToken(OAuthJSONAccessTokenResponse response) throws Exception {
		return null;
	}
}
