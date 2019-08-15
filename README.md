# OAuth

Basic = clientId:clientsecret

https://jsonobject.tistory.com/363

## /oauth/authorize
User에게 보여줄 리다이렉트 페이지


## /oauth/token
토큰 발급

    curl -X POST "http://localhost:8080/oauth/token" \
 	    -H 'Content-Type: application/x-www-form-urlencoded' \
        -H 'authorization: Basic Y2xpZW50aWQ6c2VjcmV0' \
        -d "grant_type=client_credentials"
       
## /oauth/check_token       
토큰이 유효한지 확인한다.

    curl -X POST "http://localhost:8080/oauth/check_token" \
        -d "token=067d81ec-6c68-42f3-afc6-97e4b6dc2dd6"

## /oauth/token_key
공개키를 발급받는다.

    curl "http://localhost:8080/oauth/token_key

## SSO (Single Sign On) 
Provider ex) google, facebook, kakao, github oauth login 제공하는 곳에서 
기존 local 로 token 을 발급을 받아서 resource 서버에 접근하는 것은 소스로 되었지만 그외 공급자들로 인증된 토큰을 분기하려면 WebSecurityConfigurerAdapter 클래스를 재 구현해서 처리해야하는데 아직 업데이트를 하진 못했다
