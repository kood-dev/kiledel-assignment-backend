# kiledel backend
- reservation service


# Getting started
`` docker-compose up -d``을 통해 redis, mysql을 실행합니다.

## Environments
- **Language**: java 17
- **Framework**: spring
- **Database**: mysql, redis

### API Docs
- localhost:8081/docs/index.html

### Architecture
- 포트를 통해 어댑터를 구현하고 도메인을 중심으로 설계 하는것을 목표로 하였습니다.
    - 비지니스 로직이 도메인을 제외한 외부요소(`Presentation`, `Persistence`)에 의존하지 않도록 합니다.
    - `Single Responsibility Principle`(단일책임원칙)을 통해 의존성을 낮추고 `Dependency Inversion Principle`(의존성역전원칙)을 통해 도메인 계층을 타 계층에서 의존하도록 합니다. 
- 조회 시 L2캐시를 도메인 서비스에 적용, gateway에서는 글로벌 캐시(redis)를 적용하여 조회 성능을 향상시킵니다. 
- 
### Modeling



