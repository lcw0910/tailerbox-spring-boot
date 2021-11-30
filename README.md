# Error Handling
## Annotation
- @ControllerAdvice
- @RestControllerAdvice
  - annotations = { RestController.class }
  - basePackages = { "com.tutorial.tailerbox.controller" }
  - basePackageClasses = { UserController.class }
  - assignableTypes = { ErrorController.class }
- @Order(Ordered.LOWEST_PRECEDENCE)
- @ExceptionHandler

## 우선순위
1. try .. catch
2. 해당 클래스 내의 @ExceptionHandler Annotation
3. 전역 핸들링을 위한 클래스의 @ControllerAdvice 또는 @RestControllerAdvice
   1. 특정 어노테이션, 패키지 그룹, 클래스, @Order 를 통해 우선순위 지정가능