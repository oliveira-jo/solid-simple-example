
# SOLID Introduction

This week in my free time I sow a gay in Youtube talking about how SOLID pattern is cool and practical, so I decided to read about theory and see how this is put in practice. 

As incredible as it may seem, I have been applying them to my codes for a long time, since when got a degree in college FACCAT, in 2014. I apply it but I didn’t know the real name of each pattern.

So let see a little bit about each patter and apply them in a simple code example.

## Learnins:

    1.	Single Responsibility Principle (SRP): A class should have only one reason to change, meaning it should only have one responsibility.
    2.	Open/Closed Principle (OCP): Software entities (classes, modules, functions) should be open for extension but closed for modification.
    3.	Liskov Substitution Principle (LSP): Subtypes must be substitutable for their base types without affecting program correctness.
    4.	Interface Segregation Principle (ISP): Clients should not be forced to depend on interfaces they do not use.
    5.	Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules; both should depend on abstractions.

## ❌ Without SOLID (Bad Design)

<img src="src/main/resources/imgs/Order-without-solid-classes.png"/>

## ✅ With SOLID (Better Design)

<img src="src/main/resources/imgs/Order-solid-classes.png"/>


## How SOLID was applied:

- SRP: Order only handles order-related logic.
- OCP: We can add new OrderRepository implementations without modifying existing code.
- LSP: DatabaseOrderRepository and EmailNotificationService can be replaced with other implementations (e.g., FileOrderRepository).
- ISP: OrderRepository and NotificationService are separate interfaces.
- DIP: OrderService depends on abstractions (OrderRepository, NotificationService) instead of concrete implementations.


## Benefits:
- ✅ More modular and maintainable;
- ✅ Easy to extend without modifying existing code;
- ✅ Easy to test with mock implementations.
 