# Sets the minimum CMake version required for this project.
cmake_minimum_required(VERSION 3.22.1)

project("miworld_game")

add_library(
    ${CMAKE_PROJECT_NAME} SHARED
    MiWorldGame.cpp
)

target_link_libraries(
    ${CMAKE_PROJECT_NAME}
    android
    log
)