#  v1. 

## jar 빌드
```shell
./gradlew bootJar
```

## 도커 파일 빌드
```shell
docker build -t markhong93/eureka-server .
docker build -t markhong93/gateway-server .
docker build -t markhong93/user-server .
```
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
docker run -d --network=compose_test-net --name=user-server -e EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://eureka-server/eureka markhong93/user-server

# 컨테이너 추가 여부 - 네트워크 확인
docker network inspect compose_test-net
```

