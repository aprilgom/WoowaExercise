## 기능 목록

먼저, 이 게임의 숫자는 1부터 9까지이다. 0은 포함되지 않는다.

### 정답 숫자를 설정하는 기능
- 3자리 숫자를 랜덤으로 생성해야 한다.

### 사용자로부터 숫자를 입력 받는 기능
- 3자리 숫자를 입력받아야 한다.
- 조건 외 숫자를 입력받을 시 예외 처리  

### 사용자로부터 받은 숫자와 정답 숫자를 비교하는 기능
- 같은 수가 같은 자리에 있으면 스트라이크.
- 같은 수가 다른 자리에 있으면 볼.
- 같은 수가 전혀 없으면 낫싱.

### 게임 흐름 기능  

- 조건에 따라 함수를 반복하는 기능
```
게임의 흐름
1. 정답 숫자를 정한다.
2. 사용자로부터 숫자를 입력받는다.
3. 사용자로부터 받은 숫자와 정답 숫자를 비교한다.
4. 만약 3스트라이크가 아닌 경우, 2부터 반복한다.
5. 3스트라이크일 경우, 사용자로부터 게임 재시작 여부를 묻는다.
6. 재시작하고 싶다면 1번부터 다시 시작하고, 아니라면 게임을 끝낸다.
```

