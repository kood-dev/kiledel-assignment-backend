# kiledel backend
- reservation service

## Required
1. 강연장에 입장 가능한 **인원 수는 강연마다 다릅**니다
2. 강연신청 목록에는 **강연시작시간 1주일 전에 노출되며 강연시작시간 1일 후 노출목록에서 노출하지 않습니다**.
3. 강연 신청시에는 **사번만 입력하면 되며 1인 1좌석만 예약 가능**합니다.
4. 같은 **강연의 중복신청은 불가**합니다.
5. 사번을 입력하면 **해당 사번으로 신청된 강연목록 조회가 가능**합니다.
6. 조회한 신청한 **강연정보를 취소**할 수 있어햐 합니다.
7. 강연 정보는 강연자, 강연장, 신청인원, 강연시간, 강연내용 입력이 가능해야 합니다.
8. 강연관련 백오피스 페이지에서는 강연 신청한 사람들의 사번 목록 조회가 가능합니다.
9. 실시간 인기 강연 메뉴가 있으며 해당 메뉴는 3일간 가장 신청이 많은 강연순으로 노출합니다.

## APIs
### Back-office
- [x] 강연 목록 API(전체 목록) 
- [x] 강연 등록 
   1. 강연자, 강연장, 신청인원, 강연시간, 강연내용
- [ ] 강연 신청자 목록(강연별 신청한 사번 목록)

### front
- [ ] 강연 목록(신청 가능한 싯점부터 강연시작시간 1일 후까지 노출)
- [ ] 강연 신청(사번 입력, 같은 강연 중복 신청 제한)
- [ ] 신청내역 조회(사번 입력)
- [ ] 신청한 강연 취소
- [ ] 실시간 인기 강연

### API Docs
- localhost:8081/docs/index.html

# Getting started
`` docker-compose up -d``을 통해 redis, mysql을 실행합니다.

## Environments
- **Language**: java 17
- **Framework**: spring
- **Database**: mysql, redis


### Architecture
- 포트를 통해 어댑터를 구현하고 도메인을 중심으로 설계 하는것을 목표로 하였습니다.
    - 비지니스 로직이 도메인을 제외한 외부요소(`Presentation`, `Persistence`)에 의존하지 않도록 합니다.
    - `Single Responsibility Principle`(단일책임원칙)을 통해 의존성을 낮추고 `Dependency Inversion Principle`(의존성역전원칙)을 통해 도메인 계층을 타 계층에서 의존하도록 합니다. 
- 조회 시 L2캐시를 도메인 서비스에 적용, gateway에서는 글로벌 캐시(redis)를 적용하여 조회 성능을 향상시킵니다. 
- 
### Modeling

### package info


