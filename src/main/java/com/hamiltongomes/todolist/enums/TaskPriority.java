package com.hamiltongomes.todolist.enums;

public enum TaskPriority {
    LOW("Baixa"),
    MEDIUM("Média"),
    HIGH("Alta");

    public final String value;

    TaskPriority(String value) {
        this.value = value;
    }
}
