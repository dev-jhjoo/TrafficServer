# Traffic Server


> EC2의 Free Tier 인스턴스는 어느정도의 트래픽 까지 결딜 수 있을지를 확인하기 위한 
> Spring boot 서버 입니다.


## 준비

### Backend: Spring boot
- 0~500ms 사이의 랜덤 sleep 이후 응답 하도록 로직 구현

### 프로젝트 빌드
```text
./gradlew clean build
```

### Docker build
```text
docker build -t traffic-app .
```


## 방법

1. EC2 free-tier 인스턴스 1개에 Springboot 서버를 docker image로 실행
2. 부하테스트 진행 
   - 연속으로 요청 
   - 병렬로 요청
3. 인스턴스 2개와 ALB 구성 후 부하테스트 진행
4. 인스턴스 3개로 같은 테스트 진행


## 결과

진행중...
