package edu.ustc.mix.front.action.openapi;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAuthzResponse;
import org.apache.oltu.oauth2.client.response.OAuthJSONAccessTokenResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import edu.ustc.mix.core.service.openapi.OpenAPI;
import edu.ustc.mix.core.service.openapi.OpenAPIConfig;
import edu.ustc.mix.core.service.openapi.OpenAPIDispatcher;
import edu.ustc.mix.core.util.SSLURLConnectionClient;

@Controller
@Scope("prototype")
@RequestMapping(value = "/openapi")
public class OpenAPIAction {
	
	@Autowired
	private OpenAPIDispatcher dispatcher;
	
	@RequestMapping("/authorize/{channel}")
	public ModelAndView authorize(@PathVariable String channel, Model model) throws Exception {
		
		OpenAPI openAPI = dispatcher.dispatch(channel);
		OpenAPIConfig config = openAPI.getOpenAPIConfig();
		
		OAuthClientRequest request = OAuthClientRequest
				.authorizationLocation(config.getCodeUrl())
				.setClientId(config.getAppkey())
				.setRedirectURI(config.getRedirectUri())
				.setResponseType(ResponseType.CODE.toString())
				.setScope(config.getScope())
				.setState(config.getState())
				.buildQueryMessage();
		
		return new ModelAndView(new RedirectView(request.getLocationUri()));
	}
	
	@RequestMapping(value = "/token/{channel}", method = RequestMethod.GET)
	public ModelAndView getAccessToken(@PathVariable String channel, Model model, 
			HttpServletRequest req) throws Exception {
		
		OpenAPI openAPI = dispatcher.dispatch(channel);
		OpenAPIConfig config = openAPI.getOpenAPIConfig();
		
		OAuthAuthzResponse res = OAuthAuthzResponse.oauthCodeAuthzResponse(req);
		
		OAuthClientRequest request = OAuthClientRequest
				.tokenLocation(config.getTokenUrl())
				.setClientId(config.getAppkey())
				.setClientSecret(config.getAppSecret())
				.setRedirectURI(config.getRedirectUri())
				.setCode(res.getCode())
				.setGrantType(GrantType.AUTHORIZATION_CODE)
				.buildBodyMessage();
		
		OAuthClient client = new OAuthClient(new SSLURLConnectionClient());
		
		OAuthJSONAccessTokenResponse response = client.accessToken(request, OAuthJSONAccessTokenResponse.class);
		
		openAPI.convertResponseToAccessToken(response);
		
		return new ModelAndView("redirect:/index.html");
	}
}
