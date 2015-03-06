package edu.ustc.mix.openapi.service;

import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;

public interface OpenAPI {
	
	public OpenAPIConfig getOpenAPIConfig() throws Exception;
	
	public AccessToken convertResponseToAccessToken(OAuthJSONAccessTokenResponse response) throws Exception;
}
