# Миграция схемы
Схемы хранятся в папке **schema-registry/src/main/avro**.    

В наименование файла указан текущая версия, 
например: [task-stream-v1.avsc](schema-registry%2Fsrc%2Fmain%2Favro%2Ftask%2Ftask-stream-v1.avsc).
**v1** = первая версия схемы. Создавая новую версию схемы - необхоидимо увеличить предыдущую версию на 1.

### Порядок миграции схемы

1. Создать следующую верси файла с avro разметкой;
2. Провести необходимые изменения в новой версии схемы:
   - Необходимо изменить версию внутри разметки;
   - Изменить наименование генерируемых файлов;
   - Внести необходимые изменения в поля.
3. Сгенирировать новые классы используя Gradle таску  **schema-registry/tasks/other/generateAvro**
4. Добавить новую версию топика в файл **schema-registry/src/main/java/com/example/schemaregistry/Topics.java**
5. Создать consumer, который будет подписан на новый топик;
6. Создать producer, который будет рассылать события в новый топик;
7. После того как producer перестанет рассылать старые версии событий, старый consumer и producer необходимо удалить.

# Обработка ошибок сообщений
Ошибочные сообщения записываются в таблицу **dead_letter_queue**, ошибка пишется в лог, после чего обрабатывается
разработчиком в зависомости от контекста.