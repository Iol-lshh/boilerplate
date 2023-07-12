#  v1. 
## 컴포스 파일 실행
```shell
cd boilerplate\backend\v1\compose
docker compose up
```

## 별도 컨테이너 추가
```shell
# 생성된 네트워크 확인
docker network ls

# 컨테이너 별도 실행
docker run -d --network=compose_test-net --name=user-server -e EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server:8761/eureka markhong93/user-server

# 컨테이너 추가 여부 - 네트워크 확인
docker network inspect compose_test-net
```

