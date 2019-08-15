# OAuth

Basic = clientId:clientsecret

https://jsonobject.tistory.com/363

## /oauth/authorize
User���� ������ �����̷�Ʈ ������


## /oauth/token
��ū �߱�

    curl -X POST "http://localhost:8080/oauth/token" \
 	    -H 'Content-Type: application/x-www-form-urlencoded' \
        -H 'authorization: Basic Y2xpZW50aWQ6c2VjcmV0' \
        -d "grant_type=client_credentials"
       
## /oauth/check_token       
��ū�� ��ȿ���� Ȯ���Ѵ�.

    curl -X POST "http://localhost:8080/oauth/check_token" \
        -d "token=067d81ec-6c68-42f3-afc6-97e4b6dc2dd6"

## /oauth/token_key
����Ű�� �߱޹޴´�.

    curl "http://localhost:8080/oauth/token_key

## SSO (Single Sign On) 
Provider ex) google, facebook, kakao, github oauth login �����ϴ� ������ 
���� local �� token �� �߱��� �޾Ƽ� resource ������ �����ϴ� ���� �ҽ��� �Ǿ����� �׿� �����ڵ�� ������ ��ū�� �б��Ϸ��� WebSecurityConfigurerAdapter Ŭ������ �� �����ؼ� ó���ؾ��ϴµ� ���� ������Ʈ�� ���� ���ߴ�
