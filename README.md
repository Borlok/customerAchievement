Приложение на получение ачивок пользователем

Идея:
1. В запросе на контроллер передается пользователь, который проверяется на наличие новых достижений.
2. Пользователь уходит в сервис, где проходит проверку на наличие критериев, для получения новых достижений.
3. В ответе отправляются все его достижения.

Сервис проверки должен быть легко расширяемым, 
это должно выглядеть как стратегия. 
Легко добавлять новые достижения, 
легко менять условия для получения достижений, а так же, 
если старые условия в дальнейшем мы захотим изменить,
достижения старых пользователей удалены не будут, так как содержатся в бд.

Весь основной код покрыт тестами.
1. Юнит тестирование для проверки критериев получения достижений
2. Интеграционное тестирование для обработчика пользователей

Подключено логирование в БД (Только для контроллера).

В главном пакете есть файл Request.http для проверки работы Post запроса с пользователем.
Есть три достижения:
1. Первый шаг (Для получения нужно иметь баланс выше 15 000). Баланс пользователя указан в копейках, поэтому 15 000 = 1 500 000.
2. Открыт миру (Вы должны иметь польностью заполненый профиль). Имя и фамилия.
3. Экстремальное падение (Вы должны иметь минусовой баланс)

Баланс указывается в копейках.

Стек:
Java, Spring(Boot, Mvc, Data), MySql, Flyway, JUnit, Mockito
