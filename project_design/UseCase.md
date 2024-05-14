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
* contributor 설정
  
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
      3. 유저가 회원가입 완료 버튼을 누르면, 회원 가입이 된다. <br>
      (4. 가능하면 완료된 후, 로그인 창으로 다시 넘어간다) 
    </p>
    <li>Alternate Scenarios</li>
    <p>
      1-1. 회원 가입 장면으로 전환되지 않은 경우, 유저는 다시 회원가입을 클릭한다. <br>
      3-1. 유저가 입력한 정보가 검증에 실패할 경우, 재입력을 받는다. <br>
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
      1. 사용자는 계정 정보를 입력한다. <br>
      2. 로그인 버튼을 누르면 다음 화면으로 변경된다.
    </p>
    <li>Alternate Scenarios</li>
    <p>
      2-1. 입력 정보가 검증에 실패할 경우, 로그인 실패를 알려준다.
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

### 이후에 모든 과정은 [로그인] usecase를 만족한 뒤 이뤄진다. ###

<details>
<summary>프로젝트 생성</summary>
<ul>
    <li>Main Scenario</li>
    <p>
      1. 유저는 프로젝트 생성을 클릭한다. <br>
      2. 팝업 창에(변경 가능) 프로젝트 정보들을 입력한다. <br>
      3. 유저는 모든 정보 입력을 완료하면, 프로젝트 생성 완료를 눌러 새 프로젝트를 만든다. 
    </p>
    <li>Alternate Scenarios</li>
    <p>
      3-1. 필수 정보들을 입력하지 않으면, 프로젝트 생성 완료가 되지 않는다.
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
<summary>이슈 통계 내기</summary>
<ul>
    <li>Main Scenario-1</li>
    <p>
      1. 유저가 유저 상세 정보를 누른다 <br>
      2. 통계 리스트에서, 원하는 통계를 누른다 <br>
      3. 화면의 빈 공간에서 디폴트 값이 들어간 매개변수 설정 칸과 디폴트로 그려진 그래프가 나타난다. <br>
      4. 사용자는 매개변수 입력 칸에 새로운 값을 설정하여, 원하는 통계 정보를 볼 수 있다. 
    </p>
    <li>Alternate Scenarios-1</li>
    <p>
      2-1. 통계 리스트가 비어있는 경우 새로고침을 통해 다시 로딩한다. <br>
      4-1. 사용자가 매개변수 입력 칸을 비워두거나, 선택하지 않는 경우 디폴트 매개변수 값이 들어간다. 
    </p>
    <li>Main Scenario-2</li>
    <p>
      1. 유저가 통계를 보고자 하는 프로젝트를 클릭한다. <br>
      2. 유저는 프로젝트 내에서, 통계 확인 버튼을 누른다. <br>
      3. 새로 나타난 화면에는 통계 리스트가 존재하고, 통계 리스트 중 보고자 하는 통계를 누른다. <br>
      4. 화면의 빈 공간에서 디폴트 값이 들어간 매개변수 설정 칸과 디폴트로 그려진 그래프가 나타난다. <br>
      5. 사용자는 매개변수 입력 칸에 새로운 값을 설정하여, 원하는 통계 정보를 볼 수 있다. 
    </p>
    <li>Alternate Scenarios-2</li>
    <p>
      3-1. 통계 리스트가 비어있는 경우 새로고침을 통해 다시 로딩한다. <br>
      5-1. 사용자가 매개변수 입력 칸을 비워두거나, 선택하지 않는 경우 디폴트 매개변수 값이 들어간다. 
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
<summary>프로젝트 리스트 browse, enter</summary>
<ul>
    <li>Main Scenario</li>
    <p>
      1. 로그인한 유저는 자신이 contributor로 해당한 모든 프로젝트의 리스트를 볼 수 있다. <br>
      2. 프로젝트를 클릭하면, 해당 프로젝트로 화면이 바뀐다.
    </p>
    <li>Alternate Scenarios</li>
    <p>
     2-1. 해당 프로젝트로 이동이 되지 않는 경우, 다시 한번 프로젝트를 클릭한다.
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

## 2.contributor
<details>
<summary>이슈 리스트 browse and filter</summary>
<ul>
    <li>Main Scenario</li>
    <p>
      1. 프로젝트 내부에서, contributor는 이슈 리스트를 볼 수 있다. <br>
      2. contributor는 원하는 이슈를 찾기 위해 이슈에 대한 필터를 설정할 수 있다. <br>
      3. 필터 설정 후, 검색을 누르면 해당하는 이슈들만 모아놓은 이슈 리스트가 보여진다.
    </p>
    <li>Alternate Scenarios</li>
    <p>
      1.1, 3.1. 이슈가 하나도 업을 경우, 빈 리스트를 보게 된다.<br>
      2-1. 아무것도 설정하지 않은 경우, 디폴트로 모든 이슈를 보여준다.
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
<summary>코멘트 달기</summary>
<ul>
    <li>Main Scenario</li>
    <p>
      1. [프로젝트 browse enter] usecase를 통해 프로젝트에 들어간다.<br>
      2. 프로젝트에 들어간 contributor는 이슈 리스트에서 이슈를 클릭해서 이슈의 상세정보 및 이슈에 달린 코멘트를 확인할 수 있다.<br>
      3. contributor는 해당 이슈에 코멘트를 작성할 수 있다. 
    </p>
    <li>Alternate Scenarios</li>
    <p>
      3-1. 코멘트의 필수 정보를 채우지 않은 경우, 코멘트가 작성되지 않는다.
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

## 3. admin
<details>
<summary>contributor 설정</summary>
<ul>
    <li>Main Scenario</li>
    <p>
      1. 유저는 자신이 생성한 프로젝트(자신이 admin 권한을 갖는 프로젝트)에서 설정으로 들어간다<br>
      2. 검색을 통해 권한을 주고자 하는 유저를 찾을 수 있다. <br>
      3. tester, developer, player의 권한을 다른 유저에게 주거나 회수할 수 있다. <br>
      (의논 : 설정 버튼 따로 생성?)
    </p>
    <li>Alternate Scenarios</li>
    <p>
      2-1. 검색한 유저가 존재하지 않는 경우, 빈 리스트를 보게 된다. 
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
