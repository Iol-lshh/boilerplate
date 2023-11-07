# 사용 기술
- Git
- GitHub
- Java 17
   - Spring
      - Spring Boot
      - Spring MVC
      - Spring WebFlux
      - Spring Cloud
      - Spring Security
- JS
   - ES6+
   - Vue.js
   - axios, webpack, lodash
- MariaDB
---
# 브랜치 전략
1. 메인 브렌치
  - 상시 유지되는 브렌치
    1. main 통합 브렌치 (develop)
       - main branch를 develop branch로 사용한다.
       - product 단계의 branch는 없기 때문.
2. 보조 브렌치
   1. 개개인의 feature 브렌치(topic branch)
      - develop 브렌치로 부터 나온다.
      - develop 브렌치로 merge 한다.
      - master, main, develop, release-*, hotfix-* 를 제외한 이름으로 한다.

---
# BackEnd
- [backEnd Readme](./backend/readme.md)
