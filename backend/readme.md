# 사용 기술
- Git
- GitHub
- java 17
- Spring MVC
- Vue.js   
	- axios, webpack, lodash
- MariaDB
---

# 개발 도메인 리스트
## goal 0 : 단위 서비스
1. User
   - User
     - id
     - password
     - name
2. Board
   - Board
     - id
     - name
   - Post
     - id
     - name
3. Auth
   - User
     - id
   - Refresh
     - id
     - refresh
     - last_access

## goal 1: 단일 도커 엔진 MSA
![goal1_pattern](./docs/goal1_pattern.png)
1. Eureka
2. Docker 구성
   - Docker file
   - Docker Compose file

![goal1_finished](./docs/goal1_containers.PNG)

3. 호스트 머신의 DB

### goal 1.1: auth-server
1. [OpenID Provider (OAuth 2.1)](./docs/OAuth.md)
2. 써드파티 OpenID Provider 이용

### goal 1.1: CI/CD
1. Jenkins
2. 

## goal 2: 복수 가상 머신의 MSA

![goal2_pattern](./docs/goal2_pattern.png)

1. Docker 포트포워딩

## goal 3: 분산 가상 머신의 MSA
- 컴포즈 파일은 goal1을 따라도 될까..?

![goal3_pattern](./docs/goal3_pattern.png)
