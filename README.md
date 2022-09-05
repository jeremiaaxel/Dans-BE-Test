# Dans-BE-Test

Tes Java Backend Developer

Dev: Dijalankan menggunakan IDE IntelliJ

## Available APIs
POST `<base_url>/users/register`
Request body:
```
{
  "username":"username",
  "password":"password",
  "passwordVal":"password",
  "email":"email@email.com"
}
```
POST `<base_url>/users/login`
Request body:
```
{
  "username":"username",
  "password":"password"
}
```
GET `<base_url>/jobs/`
GET `<base_url>/jobs/{id}`
