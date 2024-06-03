# Srender

Srender - приложение для отслеживания качества работы дежурных.

Приложение позволяет следить SRE за ключевыми метриками дежурных - таких как время ответа на мониторинг.
В приложение через ручку приходят алёрты из внешних систем. Приложение подключается к чату дежурных в телеграме
и выводит это сообщение с несколькими кнопками - отреагировать и поставить мьют на мониторинг на несколько часов
или отметить алёрт как ложное срабатывание.
Приложение позволяет в удобном виде выводить по каждому дежурному статистки и сравнивать показатели.
Связь пользователей чата и системы хранится в отдельном сервисе.

MVP приложения позволяет:
- создавать пользователей и команды
- заводить учения
- планировать учения на дежурных

## Визуальная схема фронтенда

![Список дежурных](../docs/marketing/img/list.png)
![Конкретный дежурный](../docs/marketing/img/concrete_duty.png)

[Макеты в figma](https://www.figma.com/file/wWYy6hft7bmY5XcfcCz1Ks/Untitled?type=design&node-id=103-68&mode=design)

## Документация

1. Маркетинг
    1. [Заинтересанты](../docs/marketing/stakeholders.md)
    2. [Целевая аудитория](../docs/marketing/target-audience.md)
    3. [Конкурентный анализ](../docs/marketing/concurrency.md)
    4. [Анализ экономики](../docs/marketing/economy.md)
    5. [Пользовательские истории](../docs/marketing/user-stories.md)
2. DevOps
    1. [Архитектурная диаграмма](../docs/architecture/infrastruture.md)
    3. [API (эндпоинты, описание сущностей)](../docs/architecture/api.md)
4. Тесты
    1. [Тесты](../docs/tests/tests.md)

## Сборка контейнера для хранения в яндексе в условиях санкций
```
https://console.yandex.cloud/folders/b1gjagmdpggtocd9o1hh/container-registry/registries/crpil4t07sqib79pev3t/overview/srender/image
docker build . -t cr.yandex/crpil4t07sqib79pev3t/srender
docker push cr.yandex/crpil4t07sqib79pev3t/srender:latest
```