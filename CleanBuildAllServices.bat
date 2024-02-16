@echo off

.\gradlew :customer-service:clean :food-service:clean :order-service:clean :customer-service:build -x test :food-service:build -x test :order-service:build -x test
