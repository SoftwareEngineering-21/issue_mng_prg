## Project 빌드 및 실행하는 법
 * ubuntu22 LTS 기준
1. 필요한 패키지 설치
 - JDK-21
 - Gradle 7.5 버전 이상
```
# JDK 21 설치
sudo apt update 
sudo apt install openjdk-21-jdk
# Gradle 설치
# https://gradle.org/install/ 참고
sudo apt install wget unzip
wget https://services.gradle.org/distributions/gradle-8.8-bin.zip -P /tmp
sudo unzip -d /opt/gradle /tmp/gradle-8.8-bin.zip
```

2. 빌드
```
cd ITS # 소스코드가 있는 ITS폴더로 이동
/opt/gradle/gradle-8.8/bin/gradle wrap # gradle wrapper 생성
./gradlew bootJar # 빌드
```

3. 실행

- web only  버전
```
java -jar build/libs/ITS-0.0.1-SNAPSHOT.jar
```

- swing 추가 버전
```
java -jar ITS-1.0.0.jar -compact
```
===

*윈도우 기준 빌드 및 실행 방법은 다음과 같습니다.

1. 필요한 패키지 설치
 - JDK-21
 - Gradle 7.5 버전 이상

다음의 글을 참고하여 필요한 패키지 설치
 - Gradle: https://gradle.org/install/
 - Java: https://velog.io/@pikamon/JAVA-1

2. 빌드

cmd 실행
cd ITS # 소스코드가 있는 ITS폴더로 이동
gradle wrap # gradle wrapper 생성
gradlew bootJar # 빌드

3. 실행

- web only  버전
```
java -jar build/libs/ITS-0.0.1-SNAPSHOT.jar
```

- swing 추가 버전
```
java -jar ITS-1.0.0.jar -compact
```


## 기술 스택

Java Spring boot 3.2.5   
Java 21   
H2 console   
Lombok   
Mybatis Framework   
cloud Bootstrap   
Thymeleaf
