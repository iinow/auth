package com.ha;

public class AppEngineCallbackSample{}/* extends AbstractAppEngineAuthorizationCodeCallbackServlet {
	private static final long serialVersionUID = 3178433294450929794L;

	@Override
	protected String getUserId(HttpServletRequest req) throws ServletException, IOException {
		return super.getUserId(req);
	}

	@Override
	protected void onError(HttpServletRequest req, HttpServletResponse resp, AuthorizationCodeResponseUrl errorResponse)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.onError(req, resp, errorResponse);
	}

	@Override
	protected void onSuccess(HttpServletRequest req, HttpServletResponse resp, Credential credential)
			throws ServletException, IOException {
		resp.sendRedirect("/");
	}

	@Override
	protected String getRedirectUri(HttpServletRequest req) throws ServletException, IOException {
		GenericUrl url = new GenericUrl(req.getRequestURL().toString());
	    url.setRawPath("/oauth2callback");
	    return url.build();
	}

	@Override
	protected AuthorizationCodeFlow initializeFlow() throws ServletException, IOException {
		return new AuthorizationCodeFlow.Builder(BearerToken.authorizationHeaderAccessMethod(),
		        new UrlFetchTransport(),
		        new JacksonFactory(),
		        new GenericUrl("https://server.example.com/token"),
		        new BasicAuthentication("s6BhdRkqt3", "7Fjfp0ZBr1KtDRbnfVdmIw"),
		        "s6BhdRkqt3",
		        "https://server.example.com/authorize").setCredentialDataStore(
		            StoredCredential.getDefaultDataStore(AppEngineDataStoreFactory.getDefaultInstance()))
		        .build();
	}
}
*/