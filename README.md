## Restaurant-app

This project has 3 services:

1. ### **customer-service**:
   Swagger api doc: http://localhost:8010/customer-service/swagger-ui/index.html
2. ### **Food-service**:
   Swagger api doc: http://localhost:8011/food-service/swagger-ui/index.html#/item-controller/createItem
3. ### **Order-service**:

### Project start-up instruction:
1. After Gradle dependency fetch, 
   run `.\CleanBuildAllServices.bat`
   This command will build all projects.
2. run docker compose up
        or 
   run `docker compose up -d `


Hurrah! You are all set.
Now test the project using `swagger` or `postman`
