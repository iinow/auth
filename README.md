# auth

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

curl -X POST "http://localhost:8080/oauth/check_token" \

       -d "token=067d81ec-6c68-42f3-afc6-97e4b6dc2dd6"