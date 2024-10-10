После запуска бэкенд будет доступен на порту 3000.

Эндпоинты:
1. Добавление клиента
   
   POST /api/v1/clients
   
   Body: { "name": "Test" }

3. Добавление контакта клиента:
   
   POST /api/v1/clients/{clientId}/contacts
   
   Body: { "type": "PHONE", "value": "+1234567890" }

5. Получение всех клиентов:
   
   GET /api/v1/clients

7. Получение клиента по ID:
   
   GET /api/v1/clients/{id}

9. Получение всех контактов клиента:
    
   GET /api/v1/clients/{clientId}/contacts

11. Получение контактов клиента по типу:
    
   GET /api/v1/clients/{clientId}/contacts/{type}
