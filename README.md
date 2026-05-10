<div align="center">

![VeloTask](https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=180&section=header&text=VeloTask&fontSize=40&fontColor=fff&animation=twinkling&fontAlignY=32&desc=Konsolowa+aplikacja+do+zarządzania+zadaniami&descAlignY=52&descSize=16)

[![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![License](https://img.shields.io/badge/License-MIT-2ECC71?style=for-the-badge)](LICENSE)

<br>

> Prosta aplikacja konsolowa do zarządzania zadaniami.
> Dodawaj, usuwaj i śledź postęp swoich zadań.

<br>

</div>

---

## Funkcje

| Funkcja | Opis |
|---|---|
| Dodawanie zadań | Tytuł + opis |
| Usuwanie zadań | Po ID |
| Zmiana statusu | TODO / IN_PROGRESS / DONE |
| Zmiana priorytetu | LOW / MEDIUM / HIGH |
| Lista zadań | Wszystkie zadania z detalami |

---

## Jak uruchomić

1. Sklonuj repo
2. Otwórz w IntelliJ IDEA
3. Uruchom `Main.java`

---

## Menu

```
=== VeloTask ===
1) Nowe zadanie
2) Zmiana statusu
3) Zmiana priorytetu
4) Lista zadań
5) Usuń zadanie
0) Wyjście
```

---

## Struktura projektu

```
src/
├── Main.java
├── cli/
│   └── TaskCLI.java
├── enums/
│   ├── Priority.java
│   └── Status.java
├── model/
│   └── Task.java
├── repository/
│   └── TaskRepository.java
├── service/
│   └── TaskService.java
└── util/
    ├── ChatUtil.java
    └── SleepUtil.java
```

---

<div align="center">

![footer](https://capsule-render.vercel.app/api?type=waving&color=gradient&customColorList=6,11,20&height=80&section=footer)

Made with ☕ by [MrPikchu](https://github.com/mrpikchu) • Java 21

</div>
