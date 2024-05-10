# step 1. actor goal list
※ 단어에 대한 범위 및 정의는 Glossary.txt 참고
## 1. user
* 회원가입
* 로그인
* 프로젝트 생성
* 이슈 통계 내기
* 프로젝트 리스트 browse

## 2.contributor
* 이슈 리스트 browse and filter
* 코멘트 달기
  
## 3. admin
* 프로젝트 관리
  
## 4. player
* 이슈 상태 변경(new, reopened -> assigned / resolved -> closed)
* assignee 배정
  
## 5. developer
* 이슈 상태 변경(assigned -> fixed)
  
## 6. tester
* 이슈 생성
* 이슈 상태 변경(fixed -> reopened, resolved)

# step 2. Speify to Casual Style
## 1. user
<details>
<summary>회원가입</summary>
  <ul>
    <li>Main Scenario</li>
    <p>
      1. 유저가 회원가입을 클릭하면 회원가입하는 장면으로 넘어간다. <br>
      2. 유저는 회원 가입 창에서 아이디랑 비밀번호를 입력한다. <br>
      3. 시스템은 아이디 중복확인, 아이디 비밀번호 조건을 확인한 뒤, 회원가입을 승인한다. <br>
      (4. 가능하면 승인한 뒤, 로그인 창으로 다시 넘어간다) 
    </p>
    <li>Alternate Scenarios</li>
    <p>
      1-1. 회원 가입 장면으로 전환되지 않은 경우, 유저는 다시 회원가입을 클릭한다. <br>
      2-1. 유저가 아이디랑 비밀번호에 한글을 입력한 경우 시스템 상에서 반려하고, 영어로 적어줄 것을 요청한다.<br>
      3-1. DB 상에 중복된 아이디가 있으면, 이를 유저에게 알려서 아이디를 바꾸도록 한다. (바꾸기 전까지는 회원가입 불가능) <br>
      3-2. 아이디와 비밀번호 조건이 맞지 않으면, 이를 유저에게 알려서 조건에 맞게 바꾸도록 한다. (바꾸기 전까지는 회원가입 불가능) <br>
     (4-1) 회원가입이 끝나고 로그인 화면으로 넘어가지 않을 경우, 홈버튼을 따로 마련해 초기 화면으로 넘어갈 수 있도록 한다.
    </p>
    <li>Test</li>
      <p> 1) Boss Test </p>
      <p>
      boss test 해보기
      </p>
      <p> 2) EBP Test </p>
      <p>
      EBP test 해보기
      </p>
      <p> 3) Size Test </p>
      <p>
      Size test 해보기
      </p>
  </ul>
</details>

<details>
<summary>로그인</summary>
  <ul>
    <li>Main Scenario</li>
    <p>
      1. 
    </p>
    <li>Alternate Scenarios</li>
    <p>
      1-1. 
    </p>
    <li>Test</li>
      <p> 1) Boss Test </p>
      <p>
      boss test 해보기
      </p>
      <p> 2) EBP Test </p>
      <p>
      EBP test 해보기
      </p>
      <p> 3) Size Test </p>
      <p>
      Size test 해보기
      </p>
  </ul>
</details>

<details>
<summary>프로젝트 생성</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

<details>
<summary>이슈 통계 내기</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

<details>
<summary>프로젝트 리스트 browse</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

## 2.contributor
<details>
<summary>이슈 리스트 browse and filter</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

<details>
<summary>코멘트 달기</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

## 3. admin
<details>
<summary>프로젝트 관리</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

## 4. player
<details>
<summary>이슈 상태 변경(new, reopened -> assigned / resolved -> closed)</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

<details>
<summary>assignee 배정</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>
  
## 5. developer
<details>
<summary>이슈 상태 변경(assigned -> fixed)</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>
  
## 6. tester
<details>
<summary>이슈 생성</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>

<details>
<summary>이슈 상태 변경(fixed -> reopened, resolved)</summary>
1. Main Scenario
2. Alternate Scenarios
3. Test
  - Boss Test
  - EBP Test
  - Size Test
</details>
