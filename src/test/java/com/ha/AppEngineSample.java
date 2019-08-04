package com.ha;

public class AppEngineSample {}/*extends AbstractAppEngineAuthorizationCodeServlet {
	private static final long serialVersionUID = 2787106249145197540L;

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
		        "https://server.example.com/authorize")
					.setCredentialDataStore(StoredCredential.getDefaultDataStore(AppEngineDataStoreFactory.getDefaultInstance()))
					.build();
	}

}
*/