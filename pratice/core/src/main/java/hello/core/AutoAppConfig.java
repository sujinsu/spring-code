package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration

@ComponentScan(
  // basePackages : 탐색 시작할 패키지 시작 위치 BUT 권장하는 방법 : 설정정보 클래스 위치를 최상단에 두는 것. 위치지정 X
  // basePackages = "hello.core", 
  // excludeFilters : 예제를 안전하게 유지하기 위해 제외 (AppConfig, TestConfig 등)
  excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
  
}
