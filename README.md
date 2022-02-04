
## Server

### BlogInlägg.java

Skapa en klass som mall för blog-inlägg(Objekt)
- Title (String)
- Body (String)
- Id (int)
- Encapsulation

### BlogController.java

- Skapa en ArrayList där alla blog-inlägg sparas

#### /api/v1/blog/list

- Given: Att användaren har användaren meny framför sig
- When: Användaren väljer alternativet att lista blog inlägg
- Then: Ska klienten visa en lista med alla blog inlägg

#### /api/v1/blog/view/<id>
- Given: Att användaren har användaren meny framför sig
- When: Användaren väljer alternativet att visa specifikt blog inlägg
- Then: Ska klienten visa det efterfrågade blog inlägget

#### /api/v1/blog/update/<id>
- Given: Att användaren har valt att uppdatera ett inlägg
- When: Användaren angett de nya uppgifterna
- Then: Ska klienten visa ett meddelande att uppdateringen gick bra

#### /api/v1/blog/create
- Given: Att användaren har användaren meny framför sig
- When: Användare väljer alternativet att skapa ett blog inlägg
- Then: Ska klienten svara med att blog inlägget har skapats

#### /api/v1/blog/delete/<id>
- Given: Att användaren har användaren meny framför sig
- When: Användaren väljer alternativet att ta bort ett inlägg
- Then: Ska klienten svara med att inlägget tagits bort

#### Om användare försöker redigera inlägg som inte finns
- Given: Att användaren har användaren meny framför sig
- When: Klienten försöker skicka en förfrågan till servern om ovanstående information
- Then: Ska servern svara med att blogginlägget inte finns, och klienten sedan visar detta svar.

### ResponseEntity
- Lägga till så man får mer specifika respons-koder

### Dependency Injection
- Dela upp BlogController i en controller och en service.

### Loggning
- Lägga till ramverk för loggning och skriva till några metoder

## Klient

### Användar menu
- Given: Att användaren har applikationen på sin klient
- When: Användaren startar applikationen
- Then: Ska användaren presenteras med en huvudmeny

### ResponseEntity
- Lägga in så att respons-koden visas när något har gått fel i klienten

