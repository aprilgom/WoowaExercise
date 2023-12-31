# 기능 목록  
### 코치의 이름을 입력받는 기능  
- 코치의 이름은 최소 2글자, 최대 4글자  
- 코치는 최소 2명, 최대 5명  
### 각 코치별 먹지 못하는 메뉴를 입력받는 기능
- 먹지 못하는 메뉴는 최소 0개, 최대 2개
- 먹지 못하는 메뉴는 빈 값으로 입력 받음
- 추천 못하는 경우는 없으니 고려하지 말고 입력받을 것.
### 각 요일에 카테고리를 랜덤으로 정하는 기능  
- 한 주에 같은 카테고리는 최대 2회  
- camp.nextstep.edu.missionutils 의 Randoms.pickNumberInRange()`를 사용할 것.  
- 임의로 카테고리의 순서 또는 데이터를 변경하면 안 된다.
    - `Randoms.pickNumberInRange()`의 결과가 **1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식**을 추천해야 한다.
    - 추천할 수 없는 카테고리인 경우 다시 `Randoms.pickNumberInRange()`를 통해 임의의 값을 생성해서 추천할 카테고리를 정해야 한다.  
### 카테고리별 메뉴를 랜덤으로 정하는 기능  
- 코치별 먹지 못하는 메뉴는 추천 불가. 
- 한 주에 중복되는 메뉴는 추천 불가.  
- 추천할 메뉴는 정해진 카테고리에 있는 메뉴를 [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms.shuffle()`을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용해야 한다.
    - 카테고리에 포함되는 메뉴 목록을 `List<String>` 형태로 준비한다. 
  - `val menu: String = Randoms.shuffle(menus)[0]`
- 임의로 메뉴의 순서 또는 데이터를 변경하면 안 된다.
    - `Randoms.shuffle()` 메서드의 인자로 전달되는 메뉴 데이터는, 최초에 제공한 목록을 그대로 전달해야 한다.
        - 코치에게 추천할 메뉴를 정할 때 이미 추천한 메뉴, 먹지 못하는 메뉴도 포함된 리스트를 전달해야 한다.
- 추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용해야 한다.
### 예외처리 기능  
- 예외 상황 시 "[ERROR]"로 시작되는 에러문구를 출력할 것.