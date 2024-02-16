@echo off

docker compose down order-service
docker rmi restaurant-app-order-service:latest