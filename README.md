# Structure:
```
| REST | — | Service | — | DAO | — | DB |
```

# Assumptions:
- REST layer will be built by another team member.
- All layers will be created once.(singletone scope)
- There is a database.
  - Session class is added for communication between the app and DB.
  - Communication between DAO and DB is thread-safe.
  - In DAO layer, a current session is gotten.
- Request and Response data will be handled/transformed in REST layer.
  - Handling exceptions will be done in REST layer.
