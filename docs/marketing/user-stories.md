### User Stories

#### 1. User Story: Время реакции дежурного
Как инженер, ответственный за дежурство в команде, я хочу чтобы время моей реакции на алерты автоматически регистрировалось системой, чтобы мне не приходилось вручную отслеживать и записывать эти данные.

#### Критерии приемки
1. Система автоматически регистрирует время между получением алерта и моим ответом на него.
2. Я могу просматривать и анализировать свои средние показатели времени реакции.
3. Система предоставляет сравнительный анализ моих результатов с командными и индивидуальными нормативами.

#### 2. User Story: Количество алертов
Как руоводитель команды, я хочу визуализировать количество алертов, обрабатываемых каждым дежурным, чтобы определить загруженность персонала и необходимость корректировки расписания дежурств.

#### Критерии приемки
1. Я могу видеть общее количество алертов, обработанных каждым дежурным за определенный период.
2. Система позволяет анализировать данные по сменам, дням, неделям или месяцам.
3. Могу использовать данные для расчета оптимального количества смен и дежурных.

#### 3. User Story: Тренды стабильности
- Как SRE нескольких команд, я хочу анализировать тренды стабильности системы, чтобы прогнозировать потенциальные проблемы и своевременно принимать предупредительные меры.

#### Критерии приемки
1. Я могу просматривать и анализировать тренды по времени реакции, количеству алертов и общей эффективности работы системы.
2. Система предоставляет графическую визуализацию трендов за выбранный период.
3. Данные доступны для сравнения по различным интервалам времени и командам.

#### 4. Автоматизированное проведение учений
- Как SRE нескольких команд, я хочу автоматизировать проведение учений (отключение ДЦ, востановление БД и тд.)

#### Критерии приемки
1. Я могу заводить учения
2. Система по сигналу начинает их проведение
3. Из системы понятно, какие дежурные проводили учения
