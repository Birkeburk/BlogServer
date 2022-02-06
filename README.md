
## Server

### BlogInlägg.java

-[x] Skapa en klass som mall för blog-inlägg(Objekt)
- Title (String)
- Body (String)
- Id (int)
- Encapsulation

### BlogController.java

- [x] Skapa en ArrayList där alla blog-inlägg sparas

#### /api/v1/blog/list
- [x] Funktion där användaren kan lista alla inlägg
- Given: Att användaren har användaren meny framför sig
- When: Användaren väljer alternativet att lista blog inlägg
- Then: Ska klienten visa en lista med alla blog inlägg

#### /api/v1/blog/view/<id>
- [x] Funktion där användaren kan lista specifikt inlägg
- Given: Att användaren har användaren meny framför sig
- When: Användaren väljer alternativet att visa specifikt blog inlägg
- Then: Ska klienten visa det efterfrågade blog inlägget

#### /api/v1/blog/update/<id>
- [x] Funktion där användaren kan uppdatera ett inlägg
- Given: Att användaren har valt att uppdatera ett inlägg
- When: Användaren angett de nya uppgifterna
- Then: Ska klienten visa ett meddelande att uppdateringen gick bra

#### /api/v1/blog/create
- [x] Funktion där användaren kan skapa ett nytt inlägg
- Given: Att användaren har användaren meny framför sig
- When: Användare väljer alternativet att skapa ett blog inlägg
- Then: Ska klienten svara med att blog inlägget har skapats

#### /api/v1/blog/delete/<id>
- [x] Funktion där användaren kan ta bort ett inlägg
- Given: Att användaren har användaren meny framför sig
- When: Användaren väljer alternativet att ta bort ett inlägg
- Then: Ska klienten svara med att inlägget tagits bort

#### Om användare försöker redigera/radera inlägg som inte finns
- [x] Funktionalitet till att ta bort och redigera inlägg
- Given: Att användaren har användaren meny framför sig och vill redigera eller radera
- When: Klienten försöker skicka en förfrågan till servern om att radera/redigera ett inlägg som inte finns
- Then: Ska servern svara med att blogginlägget inte finns

#### Om användaren försöker skapa/redigera inlägg men saknar obligatorisk information
- [x] Funktionalitet till att skapa och redigera inlägg
- Given: Att användaren har menyn framför sig och vill skapa eller redigera inlägg
- When: Klienten försöker skicka en förfrågan till server om att radera/redigera ett inlägg utan obligatorisk information
- Then: Ska servern svara med att det saknas information

### ResponseEntity
- [x] Lägga till så man kan kontrollera retur-koden

### Dependency Injection
- [x] Dela upp BlogController i en controller och en service.

### Loggning
- [x] Lägga till ramverk för loggning och skriva till några metoder

## Klient

### Användar menu
- [x] Skapa en användarvänlig meny
- Given: Att användaren har applikationen på sin klient
- When: Användaren startar applikationen
- Then: Ska användaren presenteras med en huvudmeny

## Server Docker

### Container
- [x] Skapa en Docker fil med instruktioner om hur vår server ska köras i en container
- [x] Bygga en container av vår docker image så att klienten kan ansluta till servern i containern
