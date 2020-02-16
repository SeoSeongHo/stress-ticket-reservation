# stress-ticket-reservation-was

대학교 수강신청, 공연 티켓 예매 등 순간적으로 다수의 요청이 몰릴 수 있는 상황을 견딜 수 있는 서버를 구축하려 합니다. 다음과 같은 요구사항을 만족하는 WAS 와 Worker를 개발하는 것을 프로젝트의 목표로 설정하였습니다.

## Focus

### Low Latency (지연시간)
비동기 처리를 통하여 Response 를 빠르게 반환함으로써, Low Latency 를 보장하는 WAS 를 구현

### Idempotent (멱등성)
데이터의 손실 없이 정확하고 안전하게 파이프라인을 구축하여 멱등성 보장

### Multi-Thread (멀티 스레드)
여러 대의 WAS 로부터 들어오는 요청을, Multi-Thread 형태로 신속하고, 안전하게 처리하는 Worker 를 구현
  
***

## Architecture

### WAS
WAS는 이벤트 필터링, DB 저장 등 간단한 작업을 제외하고는 구체적인 작업에 대한 책임을 모두 Worker 에게 전가하고, Latency 를 최소화하는 방향으로 작업했습니다.

![architecture](/images/aws_service_diagram.png)

자세한 스펙은 Worker Repo (아래 링크) 에 같이 정리하였습니다.

***

### Worker
[stress-ticket-reservation-worker](https://github.com/BaekGeunYoung/stress-ticket-reservation-worker)

***

### Client (Bot)
[stress-ticket-reservation-bot](https://github.com/SeoSeongHo/stress_bot)

***
